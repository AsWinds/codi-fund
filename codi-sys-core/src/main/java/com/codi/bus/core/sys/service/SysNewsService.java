package com.codi.bus.core.sys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codi.bus.core.sys.vo.SysNewsVo;

public interface SysNewsService {

	Page<SysNewsVo> findAll(Pageable pageable);

	SysNewsVo createSysNews(SysNewsVo vo);

	SysNewsVo updateSysNews(SysNewsVo vo);

	int delete(Long id);

	Page<SysNewsVo> search(String keyword, Pageable pageable);

	/**
	 * APP端获取数据列表接口
	 * */
	Page<SysNewsVo> listNews(String location, String status, Pageable pageable);

    /**
     * 根据资讯ID取得资讯详情
     * @param id
     * @return
     */
    SysNewsVo getNewsById(Long id);

}
