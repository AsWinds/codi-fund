package com.codi.bus.core.sys.dao.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.codi.base.dao.PageImpl;
import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.bus.core.sys.dao.SysAfficheDao;
import com.codi.bus.core.sys.domain.SysAffiche;
import com.github.pagehelper.PageRowBounds;

@Repository
public class SysAfficheDaoImpl extends GeneratedBaseDaoImpl<SysAffiche> implements SysAfficheDao {

	@Override
	public Page<SysAffiche> findAll(Pageable pageable) {
        PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
		List<SysAffiche> result = findList(generateStatement("findAllNotUp"), null, prb);
		return new PageImpl<>(result, pageable, prb.getTotal());
	}

}
