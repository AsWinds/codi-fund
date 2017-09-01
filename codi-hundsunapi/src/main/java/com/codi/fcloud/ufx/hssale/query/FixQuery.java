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
import com.codi.trade.service.FixQueryService;

/**
 * 基金定投查询，调用恒生接口
 * 
 * @author song-jj
 *
 */
@Service("fixQuery")
public class FixQuery extends UfxSDKFactory implements FixQueryService {

    /**
     * 查询已定投的基金
     * 
     * @param requestNum
     *            请求行数
     * @param queryFlag
     *            重新统计总记录数标志
     * @param beginNum
     *            查询起始行号
     * @param sortDirection
     *            返回排序方式
     * @param clientId
     *            客户编号
     * @param tradeAccount
     *            交易账号
     * @param scheduledProtocolId
     *            定投协议号
     * @param taAcco
     *            TA账号
     * @param protocolName
     *            协议名称
     * @param fundCode
     *            基金代码
     * @param tradeSource
     *            交易来源
     * @param businBoardType
     *            业务大类
     */
	@Loggable
    @Override
    public Map<String, Object> query(String netNo, Integer requestNum, Integer queryFlag, Integer beginNum,
            String sortDirection, String clientId, String tradeAccount, String scheduledProtocolId, String taAcco,
            String protocolName, String fundCode, String tradeSource, String businBoardType) {
        try {
            // 获取第一页
            Map<String, Object> request = getRequestParams(netNo, requestNum, queryFlag, beginNum, sortDirection,
                    clientId, tradeAccount, scheduledProtocolId, taAcco, protocolName, fundCode, tradeSource,
                    businBoardType);

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
     * 查询已定投的基金
     * 
     * @param requestNum
     *            请求行数
     * @param queryFlag
     *            重新统计总记录数标志
     * @param beginNum
     *            查询起始行号
     * @param sortDirection
     *            返回排序方式
     * @param clientId
     *            客户编号
     * @param tradeAccount
     *            交易账号
     * @param scheduledProtocolId
     *            定投协议号
     * @param taAcco
     *            TA账号
     * @param protocolName
     *            协议名称
     * @param fundCode
     *            基金代码
     * @param tradeSource
     *            交易来源
     * @param businBoardType
     *            业务大类
     */
    @Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String clientId) {
        Map<String, Object> response = query("", requestNum, queryFlag, beginNum, sortDirection, clientId, "", "", "",
                "", "", "", "");

        return response;
    }

    /**
     * 获取请求参数
     * 
     * @param netNo
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param clientId
     * @param tradeAccount
     * @param scheduledProtocolId
     * @param taAcco
     * @param protocolName
     * @param fundCode
     * @param tradeSource
     * @param businBoardType
     * @return
     */
    private Map<String, Object> getRequestParams(String netNo, Integer requestNum, Integer queryFlag, Integer beginNum,
            String sortDirection, String clientId, String tradeAccount, String scheduledProtocolId, String taAcco,
            String protocolName, String fundCode, String tradeSource, String businBoardType) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trustWay); // 交易委托方式
        request.put("net_no", netNo);// 网点代码
        request.put("request_num", requestNum); // 请求行数
        request.put("reqry_recordsum_flag", queryFlag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("sort_direction", sortDirection); // 返回排序方式
        request.put("ta_acco", taAcco); // TA账号
        request.put("client_id", StringUtil.isEmpty(clientId) ? "" : clientId); // 客户编号
        request.put("trade_acco", StringUtil.isEmpty(tradeAccount) ? "" : tradeAccount);// 交易帐号
        request.put("protocol_name", protocolName);// 协议名称
        request.put("fund_code", fundCode);// 基金代码
        request.put("trade_source", tradeSource);// 交易来源
        request.put("busin_board_type", businBoardType);// 业务大类

        return request;
    }

    /*
     * 拼接请求URL路径
     */
    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.FIX_QRY;
    }

}
