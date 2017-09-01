package com.codi.bus.core.sys.web.crawler.controller;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.service.CrawlerKeywordsService;
import com.codi.bus.core.sys.vo.CrawlerKeywordVo;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/8.
 */
@RequestMapping("/crawler/keywords")
@RestController
public class CrawlerKeywordsController {
    @Autowired
    CrawlerKeywordsService ckService;

    @RequestMapping(method = RequestMethod.GET)
    public BaseResult ListKeywords() {
        return ckService.findAllKeywords();
    }

    @RequestMapping(value = "updateAll", method = RequestMethod.POST)
    public BaseResult updateKeywords(@RequestBody List<CrawlerKeywordVo> vos) {
        if (vos == null) {
            return new BaseResult(false);
        }

        return ckService.updateAllKeywords(vos);
    }
}
