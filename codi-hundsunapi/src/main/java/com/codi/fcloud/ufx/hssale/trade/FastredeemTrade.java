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
import com.codi.trade.service.FastRedeemService;

/**
 * 快速赎回
 * 
 * @author song-jj
 */
@Service("fastRedeemService")
public class FastredeemTrade extends UfxSDKFactory implements FastRedeemService {

    /**
     * 快速赎回 
     * @param capitalMode 资金方式
     * @param tradeAcco 交易账号
     * @param password 加密后的交易密码
     * @param fundCode 基金代码
     * @param shareType 份额分类
     * @param shares 发生份额
     * @param bankCode 银行代码
     * @param bankAccount 银行账号
     * @param tradeSource 交易来源
     * @return 恒生返回的输出参数
     * @author song-jj
     */
    @Loggable
    @Override
    public Map<String, Object> fastRedeem(String capitalMode, String tradeAcco, String password, String fundCode,
            String shareType, BigDecimal shares, String bankCode, String bankAccount, String tradeSource) {
        try {
            // 配置文件中取得交易委托方式
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

            Map<String, Object> request = new HashMap<String, Object>();

            request.put("trust_way", trustWay); // 交易委托方式
            request.put("trade_acco", tradeAcco);// 交易账号
            request.put("ta_acco", ""); // TA账号
            request.put("password", password); // 加密后的交易密码
            request.put("apply_time", ""); // 申请时间
            request.put("order_date", "");// 下单日期
            request.put("fund_code", fundCode);// 基金代码
            request.put("share_type", shareType);// 份额分类
            request.put("shares", shares);// 发生份额
            request.put("capital_mode", capitalMode);// 资金方式
            request.put("bank_no", bankCode);// 银行代码
            request.put("bank_account", bankAccount);// 银行账号
            request.put("busin_board_type", "");// 业务大类
            request.put("busin_ass_code", "");// 业务辅助代码
            request.put("cash_application_type", "");// 取现用途类别
            request.put("channel_serial_id", "");// 银商流水号
            request.put("referee", "");// 推荐人
            request.put("oppo_trade_account", ""); // 对方交易账号 
            request.put("trade_source", tradeSource);// 交易来源
            
            // 调用接口
            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    /**
     * 接口路径
     */
    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.FAST_REDEEM_TRADE;
    }

}
