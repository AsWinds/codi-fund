package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.UserPrivateequity;

/**
 * 私募用户扩展表DAO
 * @author Shangdu Lin
 * @date 2017-1-9 20:12
 */
public interface UserPrivateequityDao extends BaseDAO<UserPrivateequity> {

	/**
	 * 查询用户的私募信息
	 * @param userId
	 * @return
	 */
	UserPrivateequity getByUserId(Long userId);

	/**
	 * 更新是否为合格投资者
	 * @param userId
	 * @param isQualified
	 */
	void updateQualifiedInvester(Long userId, boolean isQualified);

    /**
     * 新增扩展信息
     * @param userId
     * @param isQualified
     */
	void add(Long userId, boolean isQualified);

    /**
     * 新增
     * @param model
     */
	void add(UserPrivateequity model);

    /**
     * 更新
     * @param model
     */
	void updateByUserId(UserPrivateequity model);

}
