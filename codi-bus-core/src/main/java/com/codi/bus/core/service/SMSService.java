package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.resultModel.SMSSendResult;
import com.codi.bus.core.service.model.SMSParameter;
import com.codi.bus.exception.BaseException;

public interface SMSService {
	SMSSendResult generateSmsMessage(String mobile, List<SMSParameter> params) throws BaseException;
}
