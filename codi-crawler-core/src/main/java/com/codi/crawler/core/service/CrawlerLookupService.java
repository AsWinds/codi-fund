package com.codi.crawler.core.service;

import com.codi.crawler.core.domain.CrawlerLookup;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
public interface CrawlerLookupService {
    CrawlerLookup getTriggerTime();

    int updateTriggerTime(CrawlerLookup lookup);
}
