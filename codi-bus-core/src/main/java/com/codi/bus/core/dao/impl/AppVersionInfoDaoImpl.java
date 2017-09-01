package com.codi.bus.core.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.AppVersionInfoDao;
import com.codi.bus.core.domain.AppVersionInfo;

@Repository("appVersionInfoDao")
public class AppVersionInfoDaoImpl extends BaseDAOImpl<AppVersionInfo> implements AppVersionInfoDao {

	@Override
	public int deleteByPrimaryKey(Long id) {
		Assert.notNull(id);
		return delete("deleteByPrimaryKey", id);
	}

	@Override
	public int insert(AppVersionInfo record) {
		Assert.notNull(record);
		return insert("insert", record);
	}

	@Override
	public int insertSelective(AppVersionInfo record) {
		Assert.notNull(record);
		return insert("insertSelective", record);
	}

	@Override
	public AppVersionInfo selectByPrimaryKey(Long id) {
		Assert.notNull(id);
		return super.getObject(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AppVersionInfo record) {
		Assert.notNull(record);
		return super.update("updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(AppVersionInfo record) {
		Assert.notNull(record);
		return update("updateByPrimaryKeyWithBLOBs", record);
	}

	@Override
	public int updateByPrimaryKey(AppVersionInfo record) {
		Assert.notNull(record);
		return update(record);
	}

}
