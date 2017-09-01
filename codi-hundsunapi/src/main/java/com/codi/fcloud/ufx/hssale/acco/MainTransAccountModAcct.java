package com.codi.fcloud.ufx.hssale.acco;

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
import com.codi.trade.service.MainTransAccountModAcctService;

@Service("mainTransAccountModAcctService")
public class MainTransAccountModAcct extends UfxSDKFactory implements MainTransAccountModAcctService {

    /*
     * 变更主交易账号 变更主交易账号是指客户想要解绑开户时的银行卡，可以变更主交易账号到增开的交易账号，变更需要指交易账户三无状态
     */
	@Loggable
	@Override
    public Map<String, Object> replace(String tradeAccount, String taAccount, String password,
            String originalTradeAccount) {
        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

            Map<String, Object> request = new HashMap<String, Object>();

            request.put("trust_way", trustWay); // 委托交易方式
            request.put("trade_acco", tradeAccount); // 交易帐号
            request.put("ta_acco", taAccount); // TA帐号
            request.put("password", password); // 密码
            request.put("apply_time", ""); // 申请时间
            request.put("order_date", ""); // 下单时间
            request.put("origin_tradeacco", originalTradeAccount);// 原交易帐号

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
        return UrlConstants.PREFIX_SALE + UrlConstants.MAINTRANSACCOUNT_MOD_ACCT;
    }

}
