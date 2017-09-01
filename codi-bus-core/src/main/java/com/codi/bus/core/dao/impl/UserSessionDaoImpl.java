package com.codi.bus.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.UserSessionDao;
import com.codi.bus.core.domain.UserSession;

@Repository("userSessionDao")
public class UserSessionDaoImpl extends BaseDAOImpl<UserSession> implements UserSessionDao {

	@Override
	public void add(UserSession entity) {
		this.insert(entity);		
	}

	@Override
	public void deleteByUserId(Long userId) {
		this.delete(UserSession.class.getName()+".deleteByUserId", userId);
	}

	@Override
	public UserSession getEntityByToken(String token) {
		return this.getObject(UserSession.class.getName()+".selectByToken", token);
	}

	@Override
	public void updateExpireTimeByToken(UserSession entity) {
		this.update(UserSession.class.getName()+".updateExpireTimeByToken", entity);
	}

	@Override
	public UserSession getEntityByUserId(Long userId) {
		return this.getObject(UserSession.class.getName()+".selectByUserId", userId);
	}

    @Override
    public UserSession getEntityByTokenAndDeviceId(String token, String deviceId) {
        UserSession entity=new UserSession();
        entity.setToken(token);
        entity.setDeviceId(deviceId);
        return this.getObject(UserSession.class.getName()+".selectByUserIdAndDeviceId", entity);
    }

}
