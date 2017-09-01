package com.codi.fcloud.ufx.hssale.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.AccountQueryService;

@Service("accountQueryService")
public class AccountQuery extends UfxSDKFactory implements AccountQueryService {

    /**
     * TA帐号查询 通过TA账号查询可以获取到交易账号状态，TA账号状态，是否是主交易账号，客户编号，所有的交易账号，TA编号等
     * 
     * @author Shangdu Lin
     */
	@Loggable
    @Override
    public Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String tradeAccount,
            String taAcco, String clientId, String custType, String cardType, String idCard) {
        try {

            // 获取第一页
            Map<String, Object> request = getRequestParams(requestNum, queryFlag, beginNum, tradeAccount, taAcco,
                    clientId, custType, cardType, idCard);

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
        return UrlConstants.PREFIX_SALE + UrlConstants.ACCOUNT_QRY;
    }

    /**
     * 获取请求参数
     * 
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param tradeAccount
     * @param taAcco
     * @param clientId
     * @param custType
     * @param cardType
     * @param idCard
     * @return
     */
    private Map<String, Object> getRequestParams(Integer requestNum, Integer queryFlag, Integer beginNum,
            String tradeAccount, String taAcco, String clientId, String custType, String cardType, String idCard) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

        Map<String, Object> request = new HashMap<String, Object>();

        request.put("trust_way", trustWay); // 交易委托方式
        request.put("request_num", requestNum); // 请求行数
        request.put("reqry_recordsum_flag", queryFlag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("trade_acco", StringUtil.isEmpty(tradeAccount) ? "" : tradeAccount); // 交易帐号
        request.put("ta_acco", StringUtil.isEmpty(taAcco) ? "" : taAcco); // TA账号
        request.put("client_id", StringUtil.isEmpty(clientId) ? "" : clientId); // 客户编号
        request.put("cust_type", StringUtil.isEmpty(custType) ? "" : custType); // 客户类型
        request.put("id_kind_gb", StringUtil.isEmpty(cardType) ? "" : cardType); // 证件类型
        request.put("id_no", StringUtil.isEmpty(idCard) ? "" : idCard); // 证件号码

        return request;
    }

    public static void main(String[] args) {
        Map<String, Object> res = new AccountQuery().query(1, 1, 1, null, null, null, "1", "0", "330327198308256214");
        System.out.println("JSON:" + JSON.toJSONString(res.get(GlobalConstant.KEY_LIST_MAP)));
        System.out.println("end");
    }

}
