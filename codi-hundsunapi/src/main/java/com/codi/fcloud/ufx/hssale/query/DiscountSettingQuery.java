package com.codi.fcloud.ufx.hssale.query;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.bus.util.FundOperation;
import com.codi.fcloud.ufx.UfxSDKFactory;

@Service("discountSettingQuery")
public class DiscountSettingQuery extends UfxSDKFactory {

    private static final int PAGE_SIZE = 10;

    @Loggable
    public List<Map<String, Object>> query(String fund_code, String fund_busin_code) {
        try {
            Map<String, Object> request = getRequest("1", "1", fund_code, fund_busin_code);
            List<Map<String, Object>> firstPage = getUfxSDK().query(getTarget(), request);
            if (firstPage.size() == 0) {
                throw new RuntimeException("HS returned unexpected result, the list length is 0!!!");
            }
            if (firstPage.size() == 1 && StringUtils.isNotBlank((String) firstPage.get(0).get("error_code"))) {
                return new ArrayList<>(0);
            }
            if (firstPage.size() < PAGE_SIZE) {
                return filter_trust_way(firstPage);
            }
            List<Map<String, Object>> res = new ArrayList<>(firstPage);
            for (;;) {
                List<Map<String, Object>> current = getUfxSDK().query(getTarget(),
                        getRequest("0", Integer.toString(res.size() + 1), fund_code, fund_busin_code));
                res.addAll(current);
                if (current.size() < PAGE_SIZE) {
                    break;
                }
                continue;
            }
            return filter_trust_way(res);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    private Map<String, Object> getRequest(String reqry_recordsum_flag, String qry_beginrownum, String fund_code,
            String fund_busin_code) {
        Map<String, Object> request = new LinkedHashMap<String, Object>();
        request.put("trust_way", DEF_trust_way); // 交易委托方式
        request.put("request_num", String.valueOf(PAGE_SIZE)); // 请求行数
        request.put("reqry_recordsum_flag", reqry_recordsum_flag); // 重新统计总记录数标志
        request.put("qry_beginrownum", qry_beginrownum); // 查询起始行号
        request.put("belongdate_begin", ""); // 开始日期
        request.put("belongdate_end", ""); // 结束日期
        request.put("fund_code", fund_code); // 基金代码
        request.put("share_type", ""); // 份额类型
        request.put("fund_busin_code", fund_busin_code); // 业务代码
        request.put("min_bala", ""); // 开始金额
        request.put("max_bala", ""); // 结束金额
        request.put("capital_mode", ""); // 资金方式
        return request;
    }

    private List<Map<String, Object>> filter_trust_way(List<Map<String, Object>> src) {
        CollectionUtils.filter(src, new Predicate() {

            @Override
            public boolean evaluate(Object object) {
                @SuppressWarnings("unchecked")
                Map<String, Object> ele = (Map<String, Object>) object;
                if (StringUtils.equals(DEF_trust_way, (String) ele.get("trust_way"))) {
                    return true;
                }
                return false;
            }
        });
        return src;
    }

    @Override
    protected String getTarget() {
        return "/cwsale/v1/discount_setting_qry";
    }

    public static void main(String[] args) {
        List<Map<String, Object>> response = new DiscountSettingQuery().query("151001",
                FundOperation.Apply.getHsCode());

        System.out.println(response);
        System.out.println("--------");
        System.out.println(response.size());
        System.out.println(JSON.toJSONString(response));
    }

}