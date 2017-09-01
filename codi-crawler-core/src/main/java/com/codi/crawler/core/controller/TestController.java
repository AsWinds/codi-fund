package com.codi.crawler.core.controller;

import com.codi.bus.core.resultModel.BaseResult;
import com.codi.crawler.core.service.CrawlerNewsinfoService;
import com.codi.crawler.core.service.CrawlerSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhenhao on 2017/5/15.
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    CrawlerSubService subService;

    @Autowired
    CrawlerNewsinfoService newsinfoService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public BaseResult test() {
        newsinfoService.storeNewsinfos();
        return  new BaseResult();
    }
}
