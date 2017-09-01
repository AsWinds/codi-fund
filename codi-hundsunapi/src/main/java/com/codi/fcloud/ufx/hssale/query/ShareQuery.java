package com.codi.fcloud.ufx.hssale.query;

import java.math.BigDecimal;
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
import com.codi.trade.service.ShareQueryService;

@Service("shareQueryService")
public class ShareQuery extends UfxSDKFactory implements ShareQueryService {

    // 份额查询
	@Loggable
    @Override
    public Map<String, Object> query(Integer requestNum, Integer queryflag, Integer beginNum, String tradeAccount,
            String sortDirection, String taAccount, String fundCode, String shareType, String clientId, String fundType,
            String bankNo, BigDecimal totalShare) {

        try {

            // 获取第一页
            Map<String, Object> request = getRequestParams(requestNum, queryflag, beginNum, tradeAccount, sortDirection,
                    taAccount, fundCode, shareType, clientId, fundType, bankNo, totalShare);

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
     * @param queryflag
     * @param beginNum
     * @param tradeAccount
     * @param sortDirection
     * @param taAccount
     * @param fundCode
     * @param shareType
     * @param clientId
     * @param fundType
     * @param bankNo
     * @param totalShare
     * @return
     */
    private Map<String, Object> getRequestParams(Integer requestNum, Integer queryflag, Integer beginNum,
            String tradeAccount, String sortDirection, String taAccount, String fundCode, String shareType,
            String clientId, String fundType, String bankNo, BigDecimal totalShare) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trustWay); // 交易委托方式
        request.put("request_num", requestNum); // 请求行数
        // 如果重新统计总记录数标志传0, 返回值 total_count值为空，传1就返回总记录数
        request.put("reqry_recordsum_flag", queryflag); // 重新统计总记录数标志
        request.put("qry_beginrownum", beginNum); // 查询起始行号
        request.put("sort_direction", sortDirection); // 返回排序方式
        request.put("trade_acco", StringUtil.isEmpty(tradeAccount) ? "" : tradeAccount); // 交易帐号
        request.put("ta_acco", taAccount); // TA账号
        request.put("client_id", StringUtil.isEmpty(clientId) ? "" : clientId); // 客户编号
        request.put("fund_code", StringUtil.isEmpty(fundCode) ? "" : fundCode); // 基金代码
        request.put("share_type", shareType); // 份额分类
        request.put("ofund_type", fundType); // 基金类型
        request.put("bank_no", bankNo); // 银行代码
        // HS:这个是有家客户特殊用的 正常情况下都没用
        request.put("trade_source", ""); // 交易来源
        // 这个字段是过滤用的 如total_share=0.01 那么份额为0的份额记录都不会查询出来
        request.put("total_share", totalShare == null ? "" : totalShare); // 份额

        return request;
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.SHARE_QRY;
    }

}
