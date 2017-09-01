package com.codi.bus.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.bus.core.dao.SendMessageDao;
import com.codi.bus.core.domain.SendMessage;
import com.codi.bus.core.service.SendMessageService;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;

@Service("sendMessageService")
@Transactional
public class SendMessageServiceImpl implements SendMessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(SendMessageService.class);

	@Resource(name="sendMessageDao")
	private SendMessageDao sendMessageDao;
	
	@Override
	public List<SendMessage> queryUnsentMessages(String channel) throws BaseException {
		try{
			return sendMessageDao.queryUnsentMessages(channel);
		} catch (Exception e) {
			logger.error("queryUnsentMessages - Exception:" + e.getMessage());
			throw new SystemDBException("queryUnsentMessages Failure!", e);
		}
	}

	@Override
	public void updateStatus(SendMessage entity) throws BaseException {
		try{
			sendMessageDao.updateStatus(entity);
		} catch (Exception e) {
			logger.error("updateStatus - Exception:" + e.getMessage());
			throw new SystemDBException("updateStatus Failure!", e);
		}
		
	}

}
