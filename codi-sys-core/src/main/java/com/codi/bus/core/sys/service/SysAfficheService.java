package com.codi.bus.core.sys.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.vo.SysAfficheVo;

public interface SysAfficheService {

	BaseResult getSysAffiches(String location, Pageable pageReq);

	BaseResult getSysAffiches(Pageable pageReq);

	BaseResult createSysAffiche(SysAfficheVo vo);

	BaseResult updateSysAffiche(SysAfficheVo vo);

	int delete(Long[] ids);

	List<SysAfficheVo> getAllUps();

}
