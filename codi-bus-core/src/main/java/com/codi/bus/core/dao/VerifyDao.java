package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.Verify;

public interface VerifyDao extends BaseDAO<Verify> {
    void add(Verify entity);
    Verify getEntityByMobileAndBizCode(Verify entity);
    void deleteVerifyByMobileAndBizCode(Verify entity);
    void deleteVerifyByMobileAndBizCode(String mobile, String bizCode);
}