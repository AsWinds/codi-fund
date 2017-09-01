package com.codi.bus.core.sys.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.bus.core.sys.domain.SysNews;

/**
 * �ף�д����ע����
 * @author Administrator
 * @date 2017-05-03 16:22
 */
public interface SysNewsDao extends GeneratedBaseDao<SysNews> {

	Page<SysNews> findAll(Pageable pageable);

	Page<SysNews> search(String keyword, Pageable pageable);

	Page<SysNews> listSysNews(String location, String status, Pageable pageable);

}