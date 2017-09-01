package com.codi.fcloud.ufx;

import com.alibaba.fastjson.JSON;
import com.codi.base.config.ConfigurationMgr;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.PropertiesUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.hundsun.fcloud.ufx.sdk.UfxSDK;
import com.hundsun.fcloud.ufx.sdk.builder.PropertiesUfxSDKBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class UfxSDKFactory {
    // 交易委托方式
    public static final String DEF_trust_way = "2";
    // 默认客户类别
    public static final String DEF_cust_type = "1";
    // 默认证件类型 身份证
    public static final String DEF_id_kind_gb = "0";
    // 默认问卷客户类别
    public static final String DEF_paper_client_type = "0";
    // 默认回答对象
    public static final String DEF_answer_object = "1";
    // 默认查询类别 #1-根据交易帐号或基金帐号查； 2-根据客户类型、客户名称、证件类型和证件号码查,当前默认根据2查询
    public static final String DEF_query_type = "2";
    protected static final Logger logger = LoggerFactory.getLogger(UfxSDKFactory.class);
    // 通过短信签约，fund_interface_type字段传1(其他渠道会用到这个字段，易宝没有用到，但为统一也传1)
    protected final String DEFAULT_FUND_INTERFACE_TYPE = "1";
    protected Map<String, String> apiValueMap = new HashMap<>();
    private UfxSDK ufxSDK;

    public UfxSDKFactory() {
        try {

            ConfigurationMgr mgr = ConfigurationMgr.getInstance();
            Properties props = mgr.getProperties("ufxsdk.properties");
            apiValueMap = PropertiesUtil.doGetProperties(mgr.getProperties("ufxdefaultvalue.properties"));

            //
            this.ufxSDK = new PropertiesUfxSDKBuilder(props).build();
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "UfxSDK Starting Exception", e);
            throw e;
        }
    }

    public UfxSDK getUfxSDK() {
        return ufxSDK;
    }

    protected abstract String getTarget();

    // 记录交易流水
    protected Map<String, Object> appendLog(Map<String, Object> request, Map<String, Object> response) {
        String requestContent = JSON.toJSONString(request);
        String responseContent = JSON.toJSONString(response);
        // 只记录原始的返回结果项
        Map<String, Object> originalResponse = new HashMap<>();
        originalResponse.putAll(response);
        // 请求的内容
        response.put(GlobalConstant.KEY_REQUEST, requestContent);
        // 用在方法切面日志
        response.put(GlobalConstant.KEY_REQUEST_RAW, request);
        // 返回的内容
        response.put(GlobalConstant.KEY_RESPONSE, responseContent);
        // 用在方法切面日志
        response.put(GlobalConstant.KEY_RESPONSE_RAW, originalResponse);
        // 请求的接口
        response.put(GlobalConstant.KEY_API, getTarget());

        return response;
    }

    // 记录列表的交易流水
    protected Map<String, Object> appendLog(Map<String, Object> request, List<Map<String, Object>> response) {
        Map<String, Object> result = new HashMap<String, Object>();
        String requestContent = JSON.toJSONString(request);
        String responseContent = "";
        for (Map<String, Object> map : response) {
            if (responseContent.length() > 0) {
                responseContent = responseContent + ",";
            }
            responseContent = responseContent + JSON.toJSONString(map);
        }

        result.put(GlobalConstant.KEY_REQUEST, requestContent);
        // 用在方法切面日志
        result.put(GlobalConstant.KEY_REQUEST_RAW, request);
        result.put(GlobalConstant.KEY_RESPONSE, responseContent);
        // 用在方法切面日志
        result.put(GlobalConstant.KEY_RESPONSE_RAW, response);
        result.put(GlobalConstant.KEY_API, getTarget());

        // list map跟response重复，不需要再记log
        result.put(GlobalConstant.KEY_LIST_MAP, response);

        return result;
    }

    /**
     * 获取下一页的返回结果
     *
     * @param requestParams
     * @param response
     * @param requestNum
     */
    protected void getNextResponse(Map<String, Object> requestParams, List<Map<String, Object>> response,
                                   Integer requestNum) {
        // 数据需要全部取出来
        if (requestNum.intValue() == GlobalConstant.MAX_REQUEST_NUM.intValue()) {
            // 总记录数
            Integer totalCount = getTotalCount(response);
            // 返回的结果记录数
            Integer totalRequest = response.size();
            // 如果不是最后一页， 则获取剩余页数
            while (totalCount > totalRequest) {
                // 重新计算起始页
                requestParams.put("qry_beginrownum", totalRequest + 1);
                // 获取下一页
                List<Map<String, Object>> subResponse = getUfxSDK().query(getTarget(), requestParams);
                // 刷新总记录数
                totalCount = getTotalCount(subResponse);
                // 加入结果集
                response.addAll(subResponse);
                // 累计记录数
                totalRequest = totalRequest + subResponse.size();
            }
        }
    }

    /**
     * 获取查询列表的总行数
     *
     * @param source
     * @return
     */
    protected Integer getTotalCount(List<Map<String, Object>> source) {
        if (source != null && source.size() > 0) {
            Map<String, Object> item = source.get(0);
            if (item.containsKey(HSOutputParameterNames.TOTAL_COUNT)) {
                // 总记录数
                String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
                if (!StringUtil.isEmpty(totalCount)) {
                    return Integer.parseInt(totalCount);
                }
            }
        }

        return 0;
    }

    protected String getString(String value) {
        return StringUtil.isEmpty(value) ? "" : value;
    }

    protected String getString(String value, String defaultValue) {
        return StringUtil.isEmpty(value) ? defaultValue : value;
    }

    protected Integer getInteger(Integer value, Integer defaultValue) {
        return value == null ? defaultValue : value;
    }

    protected String getFromMap(Map<String, Object> map, String key)
    {
        return getFromMap(map,key,"");
    }
    /**
     * 从查询接口的结果中获取值，该方法目前只用于客户资料修改接口，因为客户资料修改接口需要把所有的值取出来后再赋值传回去
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    protected String getFromMap(Map<String, Object> map, String key, String defaultValue){
        if(map==null || !map.containsKey(key)){
            return defaultValue;
        }

        Object value=map.get(key);
        if(value==null || StringUtil.isEmpty(value.toString())){
            return defaultValue;
        }

        return value.toString();
    }

}
