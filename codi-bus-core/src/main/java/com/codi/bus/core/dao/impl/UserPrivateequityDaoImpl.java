package com.codi.bus.core.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.UserPrivateequityDao;
import com.codi.bus.core.domain.UserPrivateequity;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * DAO实现
 * @author Shangdu Lin
 *
 * @date 2017年1月9日 下午8:15:35
 */
@Repository("userPrivateequityDao")
public class UserPrivateequityDaoImpl extends BaseDAOImpl<UserPrivateequity> implements UserPrivateequityDao {

	/**
	 * 查询用户的私募信息
	 */
	@Override
	public UserPrivateequity getByUserId(Long userId) {
		return this.getObject(this.generateStatement("selectByUserId"), userId);
	}

	/**
	 * 更新是否为合格投资者
	 */
	@Override
	public void updateQualifiedInvester(Long userId, boolean isQualified) {
		UserPrivateequity model=new UserPrivateequity();
		model.setUserId(userId);
		model.setQualifiedInvester(isQualified);
		model.setLastUpdateDate(new Date());

		this.update(this.generateStatement("updateByUserIdSelective"), model);

	}

	/**
	 * 新增用户
	 */
	@Override
	public void add(Long userId, boolean isQualified) {
		UserPrivateequity model=new UserPrivateequity();
		model.setUserId(userId);
		model.setQualifiedInvester(isQualified);
		model.setCreateDate(new Date());
		model.setIsValid(true);

		this.insert(model);
	}

    /**
     * 新增
     *
     * @param model
     */
    @Override
    public void add(UserPrivateequity model) {
        model.setCreateDate(new Date());
        model.setIsValid(true);
        this.insert(model);
    }

    /**
     * 更新
     *
     * @param model
     */
    @Override
    public void updateByUserId(UserPrivateequity model) {
        model.setLastUpdateDate(new Date());
        this.update(this.generateStatement("updateByUserIdSelective"), model);
    }


}
