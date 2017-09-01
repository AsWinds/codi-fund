package com.codi.bus.core.dao;
import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.UserBank;

public interface UserBankDao extends BaseDAO<UserBank> {
	void add(UserBank entity);   
    boolean isExistBankNo(String bankNo, String capitalMode);
    UserBank getEntityByBankNo(Long userId, String bankNo, String capitalMode);
    List<UserBank> getListByUserId(Long userId);
}