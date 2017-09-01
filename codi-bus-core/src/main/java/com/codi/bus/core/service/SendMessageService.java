package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.domain.SendMessage;
import com.codi.bus.exception.BaseException;

public interface SendMessageService {
	List<SendMessage> queryUnsentMessages(String channel) throws BaseException;
	void updateStatus(SendMessage entity) throws BaseException;
}
