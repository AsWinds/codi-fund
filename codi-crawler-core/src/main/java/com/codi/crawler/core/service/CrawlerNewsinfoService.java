package com.codi.crawler.core.service;

import com.codi.bus.core.resultModel.BaseResult;
import com.codi.crawler.core.domain.CrawlerNewsinfo;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/15.
 */
public interface CrawlerNewsinfoService {
    int addNewsinfo(CrawlerNewsinfo newsinfo);

    BaseResult storeNewsinfos();

    void deleteCurrentDayCrawlerData();
}
