package com.codi.bus.core.sys.web.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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
import com.codi.base.exception.BaseAppException;
import com.codi.base.util.StringUtil;
import com.codi.bus.core.sys.service.FundCourseService;
import com.codi.bus.core.sys.vo.FundCourseVo;
import com.codi.bus.core.sys.web.databinder.LongToDateBinder;
import com.codi.superman.base.util.SessionUtil;

/**
 * Created by Shangdu Lin on 2017/5/3 16:39.
 */
@RequestMapping("/sys/course")
@RestController
public class FundCourseController {
	
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new LongToDateBinder());
    }

    @Autowired
    private FundCourseService fundCourseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Pageable pageReq,String title){
        if(pageReq==null){
            return new BaseResult();
        }
        return fundCourseService.queryList(pageReq,title);
    }

    @RequestMapping(value = "add-or-update", method = RequestMethod.POST)
    public BaseResult addOrUpdate(HttpServletRequest request, @Valid FundCourseVo vo) throws BaseAppException{
        boolean isUpdate=vo.getCourseId()!=null;
        if(isUpdate){
            vo.setLastUpdatedUserId(SessionUtil.getSessionUser().getUserCode());
        }else {
            vo.setPublisher(SessionUtil.getSessionUser().getUserName());
        }

        if(!isUpdate) {
            vo.setPublishDate(new Date());
            return fundCourseService.addCourse(vo);
        }else {
            return fundCourseService.updateCourse(vo);
        }
    }

    @RequestMapping(value = "delete/{courseId}", method = RequestMethod.DELETE)
    public BaseResult delete(@PathVariable Long courseId){
       return new BaseResult(fundCourseService.delete(courseId));
    }

    @RequestMapping(value = "batch-delete/{courseIds}", method = RequestMethod.DELETE)
    public BaseResult deleteBatch(@PathVariable String courseIds){
        if(StringUtil.isEmpty(courseIds)){
            return new BaseResult();
        }
        String[] ids=courseIds.split(",");
        for (String courseId :
            ids) {
            fundCourseService.delete(Long.parseLong(courseId));
        }
        return new BaseResult();
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public BaseResult search(String keyword, Pageable pageable){
    	return new PageResult<>(fundCourseService.search(keyword, pageable));
    }


}
