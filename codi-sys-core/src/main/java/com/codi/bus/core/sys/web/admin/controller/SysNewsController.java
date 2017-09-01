package com.codi.bus.core.sys.web.admin.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.service.SysNewsService;
import com.codi.bus.core.sys.vo.SysNewsVo;
import com.codi.bus.core.sys.web.databinder.LongToDateBinder;

@RequestMapping("/sys/news")
@RestController
public class SysNewsController {
	
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new LongToDateBinder());
    }
	
	@Autowired
	SysNewsService snService;
	
	@RequestMapping(method = RequestMethod.GET)
	public BaseResult listNews(Pageable pageable){
		if (pageable == null) {
			return new BaseResult();
		}
		return new PageResult<>(snService.findAll(pageable));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public BaseResult listNews(@Valid SysNewsVo vo){
		if (vo.getId() == null) {
			return new BaseResult(snService.createSysNews(vo));
		}
		return new BaseResult(snService.updateSysNews(vo));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public BaseResult delete(@PathVariable Long id){
		return new BaseResult(snService.delete(id));
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public BaseResult search(String keyword, Pageable pageable){
		if (pageable == null) {
			return new BaseResult();
		}
		return new PageResult<>(snService.search(keyword, pageable));
	}
	

}
