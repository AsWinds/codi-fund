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
import com.codi.trade.service.LoginAcctService;

@Service("loginAcctService")
public class LoginAcct extends UfxSDKFactory implements LoginAcctService {

    /**
     * 登录身份验证
     * 
     */
	@Loggable
    @Override
    public Map<String, Object> login(String password, String userName, String idCard) {
        try {
            Map<String, Object> request = new HashMap<String, Object>();

            request.put("trust_way", DEF_trust_way); // 交易委托方式
            request.put("apply_time", ""); // 申请时间
            request.put("order_date", ""); // 下单日起
            request.put("client_name", userName); // 客户名称
            request.put("id_kind_gb", DEF_id_kind_gb); // 证件类型
            request.put("id_no", idCard); // 证件号码
            request.put("password", password); // 密码

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
        return UrlConstants.PREFIX_SALE + UrlConstants.LOGIN_ACCT;
    }

}
