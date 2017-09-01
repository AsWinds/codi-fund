package com.codi.bus.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.SendMessageDao;
import com.codi.bus.core.domain.SendMessage;

@Repository("sendMessageDao")
public class SendMessageDaoImpl extends BaseDAOImpl<SendMessage> implements SendMessageDao {

	@Override
	public void add(SendMessage entity) {
		this.insert(entity);		
	}

	@Override
	public List<SendMessage> queryUnsentMessages(String channel) {
		return this.findList(SendMessage.class.getName()+".queryUnsentMessages", channel);
	}

	@Override
	public void updateStatus(SendMessage entity) {		
		this.update(SendMessage.class.getName()+".updateStatus", entity);
	}

}
