package com.codi.bus.core.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.UserDao;
import com.codi.bus.core.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("userDao")
public class UserDaoImpl extends BaseDAOImpl<User> implements UserDao {

	@Override
	public void add(User entity) {
		entity.setCreateDate(new Date());
		entity.setIsValid(true);
		this.insert(entity);
	}

	@Override
	public void updateUser(User entity) {
		entity.setLastUpdatedDate(new Date());
		super.update(entity);
	}

	@Override
	public boolean isExistMobile(String mobile) {
		User entity= this.getObject(User.class.getName() + ".selectUserByUserMobile", mobile);
		if(entity==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User getEntity(Long userId) {
		return this.getObject(User.class.getName() + ".selectUserByUserId", userId);
	}

    @Override
    public User getEntityByToken(String token) {
        return this.getObject(User.class.getName() + ".selectUserByToken", token);
    }

	@Override
	public User getEntityByMobile(String mobile) {
		return this.getObject(User.class.getName() + ".selectUserByUserMobile", mobile);
	}

	@Override
	public User getEntityByIDCard(String idCard) {
		return this.getObject(User.class.getName() + ".selectUserByIDCard", idCard);
	}

	@Override
	public boolean isExistCard(String idCard) {
		User entity= getEntityByIDCard(idCard);
		if(entity==null){
			return false;
		}else{
			return true;
		}
	}


}
