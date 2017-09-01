package com.codi.bus.core.sys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.bus.core.sys.domain.SysAffiche;

/**
 * 公告DAO
 * @author Administrator
 * @date 2017-05-02 14:48
 */
public interface SysAfficheDao extends GeneratedBaseDao<SysAffiche> {
	
	Page<SysAffiche> findAll(Pageable pageable);
}