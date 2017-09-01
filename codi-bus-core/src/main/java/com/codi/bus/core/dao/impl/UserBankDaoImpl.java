package com.codi.bus.core.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.UserBankDao;
import com.codi.bus.core.domain.UserBank;

@Repository("userBankDao")
public class UserBankDaoImpl extends BaseDAOImpl<UserBank> implements UserBankDao {

	@Override
	public void add(UserBank entity) {
		entity.setCreateDate(new Date());		
		entity.setIsValid(true);
		this.insert(entity);
	}
	

	@Override
	public boolean isExistBankNo(String bankNo, String capitalMode) {
		UserBank entity= new UserBank();
		entity.setUserBankNo(bankNo);
		entity.setCapitalMode(capitalMode);
		entity= this.getObject(UserBank.class.getName() + ".selectByBankNo", entity);
		if(entity==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public UserBank getEntityByBankNo(Long userId, String bankNo, String capitalMode) {
		UserBank query=new UserBank();
		query.setUserBankNo(bankNo);
		query.setUserId(userId);
		query.setCapitalMode(capitalMode);
		return this.getObject(UserBank.class.getName() + ".selectByBankNoAndUserId", query);		
	}

	@Override
	public List<UserBank> getListByUserId(Long userId) {
		return this.findList(UserBank.class.getName()+".selectByUserId", userId);
	}

}
