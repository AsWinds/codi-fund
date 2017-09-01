package com.codi.bus.core.sys.web.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codi.base.api.result.CollectionResult;
import com.codi.base.domain.BaseResult;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.sys.service.SysAfficheService;
import com.codi.bus.core.sys.vo.SysAfficheVo;
import com.codi.bus.core.sys.web.databinder.LongToDateBinder;
import com.codi.superman.base.util.SessionUtil;

@RequestMapping("/sys/affiche")
@RestController
public class SysAfficheController {

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new LongToDateBinder());
    }

	@Autowired
	SysAfficheService saService;


    @RequestMapping(method = RequestMethod.GET)
	public BaseResult sysAffiches(Pageable pageReq){
		if (pageReq == null) {
			return new BaseResult();
		}
		return saService.getSysAffiches(pageReq);
	}

    @RequestMapping(value = "/up", method = RequestMethod.GET)
	public BaseResult upSysAffiches(){
		return new CollectionResult<>(saService.getAllUps());
	}

    @RequestMapping(method = RequestMethod.POST)
	public BaseResult createSysAffiche(HttpServletRequest request, @Valid SysAfficheVo vo) throws BaseAppException{
		if (vo == null) {
			return new BaseResult(false);
		}
		if (vo.getId() == null) {
	        vo.setPublisher(SessionUtil.getSessionUser().getUserName());
			return saService.createSysAffiche(vo);
		}else {
			return saService.updateSysAffiche(vo);
		}
	}

    @RequestMapping(method = RequestMethod.DELETE)
	public BaseResult delAffiches(@RequestParam Long[] ids){
		return new BaseResult(saService.delete(ids));
	}

}
