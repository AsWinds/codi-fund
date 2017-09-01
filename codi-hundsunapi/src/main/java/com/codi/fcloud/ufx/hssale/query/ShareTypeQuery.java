package com.codi.fcloud.ufx.hssale.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.ShareTypeQueryService;

@Service("shareTypeQueryService")
public class ShareTypeQuery extends UfxSDKFactory implements ShareTypeQueryService {

    // 份额类别查询
	@Loggable
	@Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String fundCode, String fundName) {
        try {
            // 获取第一页
            Map<String, Object> request = getRequestParams(requestNum, queryFlag, beginNum, sortDirection, fundCode,
                    fundName);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);
            // 如果requestNum是我们系统定义的最大值，则表明数据需要全部取出来
            getNextResponse(request, response, requestNum);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    /**
     * 获取请求参数
     * 
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param fundCode
     * @param fundName
     * @return
     */
    private Map<String, Object> getRequestParams(Integer requestNum, Integer queryFlag, Integer beginNum,
            String sortDirection, String fundCode, String fundName) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trustWay); // 交易委托方式
        request.put("request_num", requestNum); // 请求行数
        request.put("reqry_recordsum_flag", queryFlag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("sort_direction", sortDirection); // 返回排序方式
        request.put("trade_acco", ""); // 交易帐号
        request.put("client_id", ""); // 客户编号
        request.put("fund_code", StringUtil.isEmpty(fundCode) ? "" : fundCode); // 基金代码
        request.put("fund_name", StringUtil.isEmpty(fundName) ? "" : fundName); // 基金名称

        return request;
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.SHARETYPE_QRY;
    }

}
