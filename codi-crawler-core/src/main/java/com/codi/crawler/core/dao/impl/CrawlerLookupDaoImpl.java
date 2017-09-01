package com.codi.crawler.core.dao.impl;

import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.crawler.core.dao.CrawlerLookupDao;
import com.codi.crawler.core.domain.CrawlerLookup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
@Repository("crawlerLookupDaoImpl")
public class CrawlerLookupDaoImpl extends GeneratedBaseDaoImpl<CrawlerLookup> implements CrawlerLookupDao{
    @Override
    public List<CrawlerLookup> selectTriggerTime() {
        List<CrawlerLookup> lookups = this.findList(this.generateStatement("selectTriggerTime"), null);

        return lookups;
    }

    @Override
    public int updateTriggerTime(CrawlerLookup lookup) {
        return this.update(this.generateStatement("updateCrawlerTrigger"), lookup);
    }
}
