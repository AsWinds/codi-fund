package com.codi.bus.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.VerifyDao;
import com.codi.bus.core.domain.Verify;

@Repository("verifyDao")
public class VerifyDaoImpl extends BaseDAOImpl<Verify> implements VerifyDao {

	@Override
	public void add(Verify entity) {
		this.insert(entity);
	}

	@Override
	public Verify getEntityByMobileAndBizCode(Verify entity) {
		return this.getObject(Verify.class.getName() + ".selectByMobileAndBizCode", entity);
	}

	@Override
	public void deleteVerifyByMobileAndBizCode(Verify entity) {
		this.delete(Verify.class.getName() + ".deleteByMobileAndBizCode", entity);
	}

	@Override
	public void deleteVerifyByMobileAndBizCode(String mobile, String bizCode) {
        Verify verifyEntity = new Verify();
        verifyEntity.setBizCode(bizCode);
        verifyEntity.setMobile(mobile);
        // 删除验证码
        this.deleteVerifyByMobileAndBizCode(verifyEntity);
	}	
	
}
