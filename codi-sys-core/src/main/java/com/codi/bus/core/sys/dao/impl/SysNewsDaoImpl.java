package com.codi.bus.core.sys.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.codi.base.dao.PageImpl;
import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.bus.core.sys.dao.SysNewsDao;
import com.codi.bus.core.sys.domain.SysNews;
import com.github.pagehelper.PageRowBounds;

@Repository
public class SysNewsDaoImpl extends GeneratedBaseDaoImpl<SysNews> implements SysNewsDao{

	@Override
	public Page<SysNews> findAll(Pageable pageable) {
		PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
		List<SysNews> result = super.findList(generateStatement("findAll"), null, prb);
		return new PageImpl<>(result, pageable, prb.getTotal());
	}

	@Override
	public Page<SysNews> search(String keyword, Pageable pageable) {
		PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
		List<SysNews> result = super.findList(generateStatement("searchAll"), keyword, prb);
		return new PageImpl<>(result, pageable, prb.getTotal());
	}

	@Override
	public Page<SysNews> listSysNews(String location, String status, Pageable pageable) {
		PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
        Map<String, String> param=new HashMap<>();
        param.put("location", location);
        param.put("status", status);
		List<SysNews> result = super.findList(generateStatement("findByLocationAndStatus"), param, prb);
		return new PageImpl<>(result, pageable, prb.getTotal());
	}

}
