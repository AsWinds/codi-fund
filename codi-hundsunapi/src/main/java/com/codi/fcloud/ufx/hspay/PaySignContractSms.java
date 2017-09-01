package com.codi.fcloud.ufx.hspay;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.PaySignContractSmsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("paySignContractSmsService")
public class PaySignContractSms extends UfxSDKFactory implements PaySignContractSmsService {

    /**
     * 短信签约第一步， 不发送验证码 & 原交易流水号
     */
	@Loggable
    @Override
    public Map<String, Object> paySign_Step_One(String serialNo, String idNo, String realName, String bankNo,
            String bankAccount, String mobile) {

        try {
            String capitalMode = apiValueMap.get(HSInputParameterNames.CAPITAL_MODE);
            String merchantName = apiValueMap.get(HSInputParameterNames.MERCHANT_NAME);

            Map<String, Object> request = new HashMap<String, Object>();
            request = new HashMap<String, Object>();
            request.put(HSInputParameterNames.SERIAL_NO, serialNo); // 流水序号
            request.put(HSInputParameterNames.CAPITAL_MODE, capitalMode); // 资金方式
            request.put(HSInputParameterNames.MERCHANT_NAME, merchantName); // 商户名称
            request.put(HSInputParameterNames.ORDER_DATE, "");
            request.put(HSInputParameterNames.ORDER_TIME, "");
            request.put(HSInputParameterNames.ID_KIND_GB, "0"); // 证件类别-0:身份证
            request.put(HSInputParameterNames.ID_NO, idNo);
            request.put(HSInputParameterNames.REAL_NAME, realName);
            request.put(HSInputParameterNames.MOBILE_TEL, mobile);
            request.put(HSInputParameterNames.BANK_ACCOUNT, bankAccount);
            request.put(HSInputParameterNames.BANK_NO, bankNo);

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    /**
     * 短信签约第二步， 发送校验码 & 原交易流水号
     */
    @Loggable
    @Override
    public Map<String, Object> paySign_Step_Two(String serialNo, String originalSerialNo, String idNo, String realName,
            String bankNo, String bankAccount, String mobile, String mobileCode, String smsSerialNo) {

        try {

            String capitalMode = apiValueMap.get(HSInputParameterNames.CAPITAL_MODE);
            String merchantName = apiValueMap.get(HSInputParameterNames.MERCHANT_NAME);

            Map<String, Object> request = new HashMap<String, Object>();

            request = new HashMap<String, Object>();
            request.put(HSInputParameterNames.SERIAL_NO, serialNo); // 流水序号
            request.put(HSInputParameterNames.ORIGINAL_SERIAL_NO, originalSerialNo); // 原流水序号：与第一步流水号相同
            request.put(HSInputParameterNames.CAPITAL_MODE, capitalMode); // 资金方式
            request.put(HSInputParameterNames.MERCHANT_NAME, merchantName); // 商户名称
            request.put(HSInputParameterNames.ORDER_DATE, "");
            request.put(HSInputParameterNames.ORDER_TIME, "");
            request.put(HSInputParameterNames.ID_KIND_GB, "0"); // 证件类别-0:身份证
            request.put(HSInputParameterNames.ID_NO, idNo);
            request.put(HSInputParameterNames.REAL_NAME, realName);
            request.put(HSInputParameterNames.MOBILE_TEL, mobile);
            request.put(HSInputParameterNames.BANK_ACCOUNT, bankAccount);
            request.put(HSInputParameterNames.BANK_NO, bankNo);
            request.put(HSInputParameterNames.MOBILE_CODE, mobileCode); // 手机验证码：发送到手机号
            request.put(HSInputParameterNames.SMS_SERIAL_NO, smsSerialNo); // 短信流水序号：第一步返回

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_PAY + UrlConstants.PAY_SIGN_CONTRACT_SMS;
    }

}
