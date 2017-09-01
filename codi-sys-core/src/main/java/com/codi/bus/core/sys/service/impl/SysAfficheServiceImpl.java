package com.codi.bus.core.sys.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.dao.SysAfficheDao;
import com.codi.bus.core.sys.domain.SysAffiche;
import com.codi.bus.core.sys.service.SysAfficheService;
import com.codi.bus.core.sys.vo.SysAfficheVo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Transactional
@Service
public class SysAfficheServiceImpl implements SysAfficheService {
	
	@Autowired
	private SysAfficheDao saDao;

	@Override
	public BaseResult getSysAffiches(String location, Pageable pageReq) {
		Assert.notNull(pageReq);
		//TODO
		return null;
	}

	@Override
	public BaseResult getSysAffiches(Pageable pageReq) {
		Page<SysAffiche> page = saDao.findAll(pageReq);
		return new PageResult<>(page.map(new Converter<SysAffiche, SysAfficheVo>() {

			@Override
			public SysAfficheVo convert(SysAffiche source) {
				SysAfficheVo vo = new SysAfficheVo();
				BeanUtils.copyProperties(source, vo);
				return vo;
			}
		}));
	}

	@Override
	public BaseResult createSysAffiche(SysAfficheVo vo) {
		Assert.isNull(vo.getId());
		if (vo.getContent() == null && vo.getLink() == null) {
			return new BaseResult(false, "内容和链接不能同时为空");
		}
		SysAffiche affiche = new SysAffiche();
		BeanUtils.copyProperties(vo, affiche);
		saDao.insert(affiche);
		SysAfficheVo res = new SysAfficheVo();
		BeanUtils.copyProperties(affiche, res);
		return new BaseResult(res);
	}

	@Override
	public BaseResult updateSysAffiche(SysAfficheVo vo) {
		Assert.notNull(vo.getId());
		SysAffiche affiche = new SysAffiche();
		BeanUtils.copyProperties(vo, affiche);
		saDao.updateByPrimaryKeySelective(affiche);
		return new BaseResult(vo);
	}

	@Override
	public int delete(Long[] ids) {
		int deleted = 0;
		for (int i = 0; i < ids.length; i++) {
			deleted += saDao.deleteByPrimaryKey(ids[i]);
		}
		return deleted;
	}

	@Override
	public List<SysAfficheVo> getAllUps() {
		List<SysAffiche> all = saDao.findList("findAllUp", null);
		return Lists.transform(all, new Function<SysAffiche, SysAfficheVo>(){

			@Override
			public SysAfficheVo apply(SysAffiche input) {
				SysAfficheVo vo = new SysAfficheVo();
				BeanUtils.copyProperties(input, vo);
				return vo;
			}});
	}

}
