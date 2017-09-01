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
import com.codi.trade.service.TransAccountCloseAcctService;

@Service("transAccountCloseAcctService")
public class TransAccountCloseAcct extends UfxSDKFactory implements TransAccountCloseAcctService {

    // 交易账号销户一般用于销非主交易账号，就是解绑增开的银行卡
	@Loggable
	@Override
    public Map<String, Object> closeAccount(String tradeAccount, String taAccount, String password) {
        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

            Map<String, Object> request = new HashMap<String, Object>();

            request.put("trust_way", trustWay); // 委托方式
            request.put("trade_acco", tradeAccount); // 交易账号
            request.put("ta_acco", taAccount); // TA账号
            request.put("password", password); // 密码
            request.put("apply_time", ""); // 申请时间
            request.put("order_date", ""); // 下单时间
            request.put("channel_serial_id", ""); // 交易来源申请编号

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
        return UrlConstants.PREFIX_SALE + UrlConstants.TRANSACCOUNT_CLOSE_ACCT;
    }

}
