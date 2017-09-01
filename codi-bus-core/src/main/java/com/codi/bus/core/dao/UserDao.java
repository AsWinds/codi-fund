package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.User;

public interface UserDao extends BaseDAO<User> {
    void add(User entity);
    void updateUser(User entity);
    User getEntity(Long userId);
    User getEntityByToken(String token);
    boolean isExistMobile(String mobile);
    boolean isExistCard(String idCard);
    User getEntityByMobile(String mobile);
    User getEntityByIDCard(String idCard);
}
