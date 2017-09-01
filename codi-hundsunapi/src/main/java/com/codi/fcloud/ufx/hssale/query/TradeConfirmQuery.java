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
import com.codi.trade.service.TradeConfirmQueryService;

@Service("tradeConfirmQueryService")
public class TradeConfirmQuery extends UfxSDKFactory implements TradeConfirmQueryService {

    // 交易确认查询
	@Loggable
    @Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String taAcco, String clientId, String beginDate, String endDate, String allotNo, String taConfirmFlag,
            String tradeAccount, String fundCode, String businCode, String trafficFlag, String targetFundCode,
            String taSerialId, String fundType, String targetFundType, String capitalMode, String scheduledProtocolId) {

        try {

            // 获取第一页
            Map<String, Object> request = getRequestParams(requestNum, queryFlag, beginNum, sortDirection, taAcco,
                    clientId, beginDate, endDate, allotNo, taConfirmFlag, tradeAccount, fundCode, businCode,
                    trafficFlag, targetFundCode, taSerialId, fundType, targetFundType, capitalMode,
                    scheduledProtocolId);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);
            
            // 如果requestNum是我们系统定义的最大值，则表明数据需要全部取出来
            getNextResponse(request, response, requestNum);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    // 交易确认查询
	@Loggable
    @Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String clientId, String taConfirmFlag, String tradeAccount) {
        return query(requestNum, queryFlag, beginNum, sortDirection, "", clientId, "", "", "", taConfirmFlag,
                tradeAccount, "", "", "", "", "", "", "", "", "");
    }

    /**
     * 获取请求参数
     * 
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param taAcco
     * @param clientId
     * @param beginDate
     * @param endDate
     * @param allotNo
     * @param taConfirmFlag
     * @param tradeAccount
     * @param fundCode
     * @param businCode
     * @param trafficFlag
     * @param targetFundCode
     * @param taSerialId
     * @param fundType
     * @param targetFundType
     * @param capitalMode
     * @param scheduledProtocolId
     * @return
     */
    private Map<String, Object> getRequestParams(Integer requestNum, Integer queryFlag, Integer beginNum,
            String sortDirection, String taAcco, String clientId, String beginDate, String endDate, String allotNo,
            String taConfirmFlag, String tradeAccount, String fundCode, String businCode, String trafficFlag,
            String targetFundCode, String taSerialId, String fundType, String targetFundType, String capitalMode,
            String scheduledProtocolId) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trustWay); // 交易委托方式
        request.put("request_num", requestNum); // 请求行数
        request.put("reqry_recordsum_flag", queryFlag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("sort_direction", sortDirection); // 返回排序方式
        request.put("ta_acco", taAcco); // TA账号
        request.put("client_id", StringUtil.isEmpty(clientId) ? "" : clientId); // 客户编号
        request.put("allot_no", allotNo); // 申请编号
        request.put("trade_acco", StringUtil.isEmpty(tradeAccount) ? "" : tradeAccount);// 交易帐号
        request.put("fund_code", fundCode); // 基金代码
        request.put("fund_busin_code", businCode); // 业务代码
        request.put("protocol_traffic_flag", trafficFlag);// 定期定额协议业务标志
        request.put("target_fund_code", targetFundCode); // 目标基金代码
        request.put("start_date", beginDate); // 开始日期；
        request.put("end_date", endDate);// 到期日期
        request.put("ta_serial_id", taSerialId);// TA确认编号；
        request.put("fund_type", fundType); // 基金类型；
        request.put("target_fund_type", targetFundType);// 目标基金类型
        request.put("capital_mode", capitalMode);// 资金方式
        request.put("taconfirm_flag", taConfirmFlag); // 确认标志
        request.put("scheduled_protocol_id", scheduledProtocolId);// 定投协议号

        return request;
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.TRADE_CONFIRM_QRY;
    }

}
