package com.codi.bus.core.dao;

import com.codi.bus.core.domain.UserSession;

public interface UserSessionHistoryDao {
	void addHistory(UserSession entity);
}
