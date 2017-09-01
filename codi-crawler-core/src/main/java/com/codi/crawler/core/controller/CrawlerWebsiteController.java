package com.codi.crawler.core.controller;

import com.codi.base.domain.BaseResult;
import com.codi.crawler.core.service.CrawlerWebsiteService;
import com.codi.crawler.core.vo.CrawlerWebsiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
@RequestMapping("/crawler/website/query")
@RestController
public class CrawlerWebsiteController {
    @Autowired
    private CrawlerWebsiteService websiteService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseResult list(Pageable pageable) {
        if (pageable == null) {
            return new BaseResult(false);
        }

        return websiteService.queryList(pageable);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody CrawlerWebsiteVo vo) {
        if (vo == null) {
            return new BaseResult(false);
        }

        return websiteService.addWebsite(vo);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody CrawlerWebsiteVo vo) {
        if (vo == null) {
            return new BaseResult(false);
        }

        return websiteService.updateWebsite(vo);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(@RequestBody CrawlerWebsiteVo vo) {
        if (vo == null) {
            return new BaseResult(false);
        }

        websiteService.delete(vo.getId());

        return new BaseResult();
    }
}
