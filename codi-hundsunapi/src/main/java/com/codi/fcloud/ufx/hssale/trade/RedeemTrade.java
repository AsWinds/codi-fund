package com.codi.fcloud.ufx.hssale.trade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.RedeemTradeService;

@Service("redeemTradeService")
public class RedeemTrade extends UfxSDKFactory implements RedeemTradeService {

    // 赎回转购业务在赎回接口实现，可以实现不同TA下的基金份额转换，转换同一TA请用基金转换
	@Loggable
    public Map<String, Object> sell(String capitalMode, String tradeAcco, String password, String fundCode,
            String shareType, BigDecimal shares, String tradeSource) {

        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

            Map<String, Object> request = new HashMap<String, Object>();
            // 交易委托方式
            request.put("trust_way", trustWay);
            // 交易账号
            request.put("trade_acco", tradeAcco);
            // 密码
            request.put("password", password);
            // 申请时间
            request.put("apply_time", "");
            // 下单日期
            request.put("order_date", "");
            // 基金代码
            request.put("fund_code", fundCode);
            // 份额分类
            request.put("share_type", shareType);
            // 发生份额
            request.put("shares", shares);
            // 巨额赎回标志
            request.put("fund_exceed_flag", "");
            // 资金方式
            request.put("capital_mode", capitalMode);
            // 银行代码
            request.put("bank_no", "");
            // 银行账号
            request.put("bank_account", "");
            // 经纪人
            request.put("broker", "");
            // 业务大类
            request.put("busin_board_type", "");
            // 交易来源
            request.put("trade_source", tradeSource);// 必输字段 ?
            // 交易来源申请编号
            request.put("channel_serial_id", "");
            // 对方交易账号
            request.put("oppo_trade_account", "");
            // 赎回转购业务 目标基金代码
            request.put("target_fund_code", "");
            // 赎回转购业务 目标基金类别
            request.put("target_share_type", "");
            // 业务辅助代码
            request.put("busin_ass_code", "");

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
        return UrlConstants.PREFIX_SALE + UrlConstants.REDEEM_TRADE;
    }

}
