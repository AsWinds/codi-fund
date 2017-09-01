package com.codi.crawler.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.codi.base.domain.BaseResult;
import com.codi.crawler.core.domain.CrawlerLookup;
import com.codi.crawler.core.service.CrawlerLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
@RequestMapping("/crawler/trigger")
@RestController
public class CrawlerLookupController {
    @Autowired
    CrawlerLookupService lookupService;

    /**
     * 获取爬取间隔时间
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public BaseResult getCrawlerTriggerTime() {
        CrawlerLookup lookup = lookupService.getTriggerTime();
        BaseResult result = new BaseResult(lookup);

        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseResult updateCrawlerTriggerTime(@RequestBody CrawlerLookup lookup) {
        BaseResult result = new BaseResult();

        if (lookup.getRuleLuText() == null) {
            result.setSuccess(false);

            return result;
        }

        lookupService.updateTriggerTime(lookup);

        return result;
    }
}
