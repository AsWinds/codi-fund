package com.codi.bus.core.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.SendMessage;

public interface SendMessageDao extends BaseDAO<SendMessage> {
    void add(SendMessage entity);
    List<SendMessage> queryUnsentMessages(String channel);
    void updateStatus(SendMessage entity);
}