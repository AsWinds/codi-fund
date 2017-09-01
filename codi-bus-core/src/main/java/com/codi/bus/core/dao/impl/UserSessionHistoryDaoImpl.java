package com.codi.bus.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.UserSessionHistoryDao;
import com.codi.bus.core.domain.UserSession;

@Repository("userSessionHistoryDao")
public class UserSessionHistoryDaoImpl extends BaseDAOImpl<UserSessionHistoryDao> implements UserSessionHistoryDao {

	@Override
	public void addHistory(UserSession entity) {
		this.insert(entity);
	}

}
