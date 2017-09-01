package com.codi.bus.core.sys.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.domain.SysNews;
import com.codi.bus.core.sys.service.FundCourseService;
import com.codi.bus.core.sys.service.SysNewsService;

@RestController
@RequestMapping("/information")
public class InformationController {

	@Autowired
	private SysNewsService snService;

	@Autowired
	private FundCourseService fcService;

	//category可能值: news, fundCourse
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public BaseResult infomations(String type, Pageable pageable){
		switch (type) {
		case "news":
			return new PageResult<>(snService.listNews("APP", SysNews.STATUS_ON, pageable));

		case "fundCourse":
			return new PageResult<>(fcService.listFundCourse(pageable));

		default:
			return new BaseResult(false, "未知的类型:" + type);
		}
	}

    /**
     *
     * @param type {news, fundCourse}
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public BaseResult infomations(String type, @PathVariable Long articleId){
        switch (type) {
            // 资讯
            case "news":
                return new BaseResult(snService.getNewsById(articleId));
            // 学堂
            case "fundCourse":
                return new BaseResult(fcService.getCourseById(articleId));

            default:
                return new BaseResult(false, "未知的类型:" + type);
        }
    }
}
