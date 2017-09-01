package com.codi.bus.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.util.DateUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.VerifyDao;
import com.codi.bus.core.domain.Verify;
import com.codi.bus.core.resultModel.SMSSendResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.model.SMSParameter;
import com.codi.bus.exception.BaseException;


@Service("smsService")
@Transactional
public class VerifyCodesSMSServiceImpl extends SMSServiceImpl {

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="verifyDao")
	private VerifyDao verifyDao;

	@Override
	String getTemplateCode() {
		String templateCode = GlobalConstant.SMS_TEMPLATE_CODE_DEFAULT;
		if (smsMap.containsKey(GlobalConstant.SMS_PROPERTY_TEMPLATE_CODE)) {
			templateCode = smsMap.get(GlobalConstant.SMS_PROPERTY_TEMPLATE_CODE);
		}

		return templateCode;
	}

	@Override
	SMSSendResult preCheck(String mobile, List<SMSParameter> params) throws BaseException {
//		if (userService.checkMobile(mobile)) {
//			SMSSendResult result = new SMSSendResult();
//			result.setSuccess(false);
//			result.setErrorCode(ErrorConstant.ERROR_MOBILE_REGED);
//			return result;
//		}
		return null;
	}

	@Override
	void preCreateMessage(String mobile, List<SMSParameter> params) {
		//删除已存在的验证码
		Verify verifyEntity=new Verify();
		verifyEntity.setBizCode(GlobalConstant.SMS_BIZ_CODE_VERIFY);
		verifyEntity.setMobile(mobile);
		//删除验证码
		verifyDao.deleteVerifyByMobileAndBizCode(verifyEntity);
		
		// 将验证码保存到验证码表
		Date createDate = new Date();
		Verify vcode = new Verify();
		vcode.setBizCode(GlobalConstant.SMS_BIZ_CODE_VERIFY);
		vcode.setCreateDate(createDate);
		Integer expiredSeconds=GlobalConstant.SMS_EXPIRED_SECONDS_DEFAULT;
		if (smsMap.containsKey(GlobalConstant.SMS_PROPERTY_EXPIRED_SECONDS)) {
			expiredSeconds = Integer.parseInt(smsMap.get(GlobalConstant.SMS_PROPERTY_EXPIRED_SECONDS));
		}		
		vcode.setExpireDate(DateUtils.addSecond(createDate, expiredSeconds));
		vcode.setMobile(mobile);
		vcode.setVerifyCode(params.get(0).getValue());
		
		verifyDao.add(vcode);		
	}

	@Override
	void afterCreateMessage(String mobile, List<SMSParameter> params) {
		// TODO Auto-generated method stub

	}

}
