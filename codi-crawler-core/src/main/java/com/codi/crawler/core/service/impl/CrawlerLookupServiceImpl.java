package com.codi.crawler.core.service.impl;

import com.codi.crawler.core.dao.CrawlerLookupDao;
import com.codi.crawler.core.domain.CrawlerLookup;
import com.codi.crawler.core.service.CrawlerLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
@Service
public class CrawlerLookupServiceImpl implements CrawlerLookupService {
    @Autowired
    private CrawlerLookupDao lookupDao;

    @Override
    public CrawlerLookup getTriggerTime() {
        List<CrawlerLookup> lookups = lookupDao.selectTriggerTime();

        if (lookups != null && lookups.size() >= 1) {
            return lookups.get(0);
        }

        return null;
    }

    @Override
    public int updateTriggerTime(CrawlerLookup lookup) {
        return lookupDao.updateTriggerTime(lookup);
    }
}
