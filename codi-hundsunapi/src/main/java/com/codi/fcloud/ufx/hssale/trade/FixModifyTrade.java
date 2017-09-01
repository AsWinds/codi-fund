package com.codi.fcloud.ufx.hssale.trade;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.FixModifyTradeService;

/**
 * 定期定额协议变更
 * 
 * @author song-jj
 */
@Service("fixModifyTradeService")
public class FixModifyTrade extends UfxSDKFactory implements FixModifyTradeService {

	@Loggable
    @Override
    public Map<String, Object> modifyFix(String capitalMode, String password, String tradeAcco, String tradeSource,
            String fundCode, BigDecimal balance, String shareType, String protocolPeriodUnit, Long protocolFixDay,
            String scheduledProtocolId, String fixModel, String expiryDate) {
        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);
            Long oldFixDay = protocolFixDay;
            // 首次交易日期-YYYYMMDD
            String firstExchDateStr = FixAllotTrade.getFristExchDate(protocolFixDay, protocolPeriodUnit);
            // 首次交易日期-YYYYMM
            Integer firstExchDate = Integer.valueOf(firstExchDateStr.substring(0, 6));
            // 重新计算后的首次交易日期
            protocolFixDay = Long.valueOf(firstExchDateStr.substring(6, firstExchDateStr.length()));
            // 创建request
            Map<String, Object> request = FixAllotTrade.createRequest(capitalMode, password, tradeAcco, tradeSource,
                    fundCode, balance, shareType, protocolPeriodUnit, protocolFixDay, firstExchDate, trustWay,
                    detailFundWay);
            // 接口类型
            request.put("scheduled_protocol_id", scheduledProtocolId);
            // 发生份额
            request.put("shares", 0);
            // 巨额赎回标志
            request.put("fund_exceed_flag", "0");
            // 业务代码
            request.put("fund_busin_code", GlobalConstant.FUND_BUSIN_CODE_FIX);

            String fixState = "";
            if (GlobalConstant.FIX_MODEL_MODIFY.equals(fixModel)) {
                fixState = GlobalConstant.FIX_STATE_NORMAL;
            } else {
                fixState = GlobalConstant.FIX_STATE_STOP;
                request.put("expiry_date", expiryDate);
                request.remove("protocol_period_unit");
            }
            // 定投交易日
            if (GlobalConstant.PROTOCOL_PERIOD_UNIT_WEEK.equals(protocolPeriodUnit)) {
                request.put("protocol_fix_day", oldFixDay + 1);
            }
            // 协议状态
            request.put("fix_state", fixState);

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.FIX_MODIFY_TRADE;
    }

}
