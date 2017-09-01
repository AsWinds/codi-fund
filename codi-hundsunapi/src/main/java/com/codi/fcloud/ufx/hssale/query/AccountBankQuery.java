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
import com.codi.trade.service.AccountBankQueryService;

@Service("accountBankQueryService")
public class AccountBankQuery extends UfxSDKFactory implements AccountBankQueryService {

    // 客户银行帐号查询
	@Loggable
	@Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String tradeAccount, String clientId, String capitalMode) {

        try {

            // 获取第一页
            Map<String, Object> request = getRequestParams(requestNum, queryFlag, beginNum, sortDirection, tradeAccount,
                    clientId, capitalMode);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            // 如果requestNum是我们系统定义的最大值，则表明数据需要全部取出来
            getNextResponse(request, response, requestNum);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.ACCOBANK_QRY;
    }

    /**
     * 获取请求参数
     * 
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param tradeAccount
     * @param clientId
     * @param capitalMode
     * @return
     */
    private Map<String, Object> getRequestParams(Integer requestNum, Integer queryFlag, Integer beginNum,
            String sortDirection, String tradeAccount, String clientId, String capitalMode) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trustWay); // 交易委托方式
        request.put("request_num", requestNum); // 请求行数
        request.put("reqry_recordsum_flag", queryFlag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("sort_direction", sortDirection); // 返回排序方式
        request.put("trade_acco", StringUtil.isEmpty(tradeAccount) ? "" : tradeAccount); // 交易帐号
        request.put("ta_acco", "");// TA账号
        request.put("client_id", StringUtil.isEmpty(clientId) ? "" : clientId); // 客户编号
        request.put("capital_mode", StringUtil.isEmpty(capitalMode) ? "" : capitalMode);// 资金方式
        request.put("trade_source", ""); // 交易来源
        request.put("bank_no", ""); // 银行代码

        return request;
    }

}
