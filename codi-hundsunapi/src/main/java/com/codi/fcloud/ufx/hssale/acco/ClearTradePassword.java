package com.codi.fcloud.ufx.hssale.acco;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.UrlConstants;

@Service("clearTradePassword")
public class ClearTradePassword extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + "tradepassword_clear_acct";
    }

    @Loggable
    public Map<String, Object> clearTradePasswd(String trade_acco, String md5_passwd) {
        try {
            Map<String, Object> request = new HashMap<String, Object>();
            request.put("trust_way", DEF_trust_way); // 委托方式
            request.put("trade_acco", trade_acco); // 交易账号
            request.put("ta_acco", ""); // TA账号
            request.put("password", ""); // 密码
            request.put("apply_time", ""); // 申请时间
            request.put("order_date", ""); // 下单时间
            request.put("new_password", md5_passwd);// 新密码
            request.put("channel_serial_id", "");// 交易来源申请编号

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(appendLog(request, response));
            return response;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

}
