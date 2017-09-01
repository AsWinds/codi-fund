package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.UserSession;

public interface UserSessionDao extends BaseDAO<UserSession> {
    void add(UserSession entity);
    void deleteByUserId(Long userId);
    UserSession getEntityByToken(String token);
    UserSession getEntityByUserId(Long userId);
    UserSession getEntityByTokenAndDeviceId(String token, String deviceId);
    void updateExpireTimeByToken(UserSession entity);
}