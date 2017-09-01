package com.codi.trade.service;

import java.util.Map;

public interface PaySignContractSmsService {
	//短信签约第一步， 不发送验证码 & 原交易流水号
	Map<String, Object> paySign_Step_One(String serialNo, String idNo, String realName, String bankNo,
			String bankAccount, String mobile);
	//短信签约第二步， 发送校验码 & 原交易流水号
	Map<String, Object> paySign_Step_Two(String serialNo, String originalSerialNo, String idNo, String realName,
			String bankNo, String bankAccount, String mobile, String mobileCode, String smsSerialNo);
}
