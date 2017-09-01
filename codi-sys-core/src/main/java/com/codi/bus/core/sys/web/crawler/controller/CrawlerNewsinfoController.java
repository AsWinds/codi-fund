package com.codi.bus.core.sys.web.crawler.controller;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.service.CrawlerNewsinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhenhao on 2017/5/11.
 */
@RequestMapping("/crawler/query")
@RestController
public class CrawlerNewsinfoController {
    @Autowired
    private CrawlerNewsinfoService service;

    @RequestMapping(method = RequestMethod.POST)
    public BaseResult list(Pageable pageReq) {
        if (pageReq == null) {
            return new BaseResult(false);
        }

        return service.queryList(pageReq);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public BaseResult search(Pageable pageReq, String content) {
        if (pageReq == null) {
            return new BaseResult(false);
        }

        return service.search(pageReq, content);
    }

    @RequestMapping(value = "trigger", method = RequestMethod.GET)
    public BaseResult trigger() {
        return service.triggerCrawler();
    }
}
