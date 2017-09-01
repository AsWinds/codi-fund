package com.codi.bus.core.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.PropertiesUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.SMSTemplateDao;
import com.codi.bus.core.dao.SendMessageDao;
import com.codi.bus.core.domain.SMSTemplate;
import com.codi.bus.core.domain.SendMessage;
import com.codi.bus.core.resultModel.SMSSendResult;
import com.codi.bus.core.service.SMSService;
import com.codi.bus.core.service.model.SMSParameter;
import com.codi.bus.exception.BaseException;
import com.codi.message.constant.ErrorConstant;


@Transactional
public abstract class SMSServiceImpl implements SMSService {
	private static final Logger logger = LoggerFactory.getLogger(SMSServiceImpl.class);
	
	protected Map<String, String> smsMap = PropertiesUtil.doGetProperties("sms.properties");

	@Resource(name = "smsTemplateDao")
	private SMSTemplateDao smsTemplateDao;
	
	@Resource(name="sendMessageDao")
	private SendMessageDao sendMessageDao;

	@Override
	@Transactional(rollbackFor = { BaseException.class })
	public SMSSendResult generateSmsMessage(String mobile, List<SMSParameter> params) throws BaseException {
		
		SMSSendResult result=null;
		try {
			// 检查输入的手机号和参数是否符合要求
			result = preCheck(mobile, params);
			if (result != null) {
				return result;
			}
			// 查找Template
			SMSTemplate template = findSMSTemplateContent(getTemplateCode());
			if (template==null || StringUtil.isEmpty(template.getTemplateContent())) {
				result = new SMSSendResult();
				result.setSuccess(false);
				result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
				result.setErrorCode(ErrorConstant.ERROR_TEMPLATE_NO_FIND);
				return result;
			}
			// 创建Message
			String msg = buildSMSMessage(template.getTemplateContent(), params);
			// 插入短信到数据库前执行的方法
			preCreateMessage(mobile, params);
			// 将信息插入到数据库
			storeMessage(mobile, msg, template.getSmsType());
			// 插入信息到数据库后执行的方法
			afterCreateMessage(mobile, params);

			result = new SMSSendResult();
			result.setSuccess(true);			

		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "generateSmsMessage exception", exception);
			result = new SMSSendResult();
			result.setSuccess(false);
			result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
			result.setErrorCode(ErrorConstant.ERROR_SYSTEM_DB);
		}
		
		return result;		
	}

	private final void storeMessage(String mobile, String message, Integer smsType) {
		// 将数据保存到数据库
		SendMessage msg = new SendMessage();
		msg.setMobile(mobile);
		msg.setContent(message);
		String channel=GlobalConstant.SMS_CHANNEL_DEFAULT;
		if(smsMap.containsKey(GlobalConstant.SMS_PROPERTY_CHANNEL)){
			channel=smsMap.get(GlobalConstant.SMS_PROPERTY_CHANNEL);
		}
		msg.setChannel(channel);
		//验证码
		msg.setType(smsType);
		//发送计划-立即发送
		msg.setSendPlan(GlobalConstant.SMS_PLAN_INSTANT);
		//发送状态-发送中
		msg.setSendStatus(GlobalConstant.SMS_STATUS_SENDING);
		msg.setCreateDate(new Date());
		msg.setIsValid(true);
		sendMessageDao.add(msg);
	}

	private final String buildSMSMessage(String template, List<SMSParameter> params) {
		for (SMSParameter param : params) {
			template = template.replaceAll(param.getKey(), param.getValue());
		}
		return template;
	}

	private final SMSTemplate findSMSTemplateContent(String templateCode) {
		SMSTemplate template = smsTemplateDao.getEntityByTemplateCode(templateCode);
		return template;
	}

	abstract String getTemplateCode();

	abstract SMSSendResult preCheck(String mobile, List<SMSParameter> params) throws BaseException;

	abstract void preCreateMessage(String mobile, List<SMSParameter> params)  throws BaseException;

	abstract void afterCreateMessage(String mobile, List<SMSParameter> params)  throws BaseException;

}
