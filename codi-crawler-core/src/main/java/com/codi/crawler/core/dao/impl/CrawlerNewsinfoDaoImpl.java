package com.codi.crawler.core.dao.impl;

import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.crawler.core.dao.CrawlerNewsinfoDao;
import com.codi.crawler.core.domain.CrawlerNewsinfo;
import org.springframework.stereotype.Repository;

/**
 * Created by wangzhenhao on 2017/5/18.
 */
@Repository("crawlerNewsinfoDao")
public class CrawlerNewsinfoDaoImpl extends GeneratedBaseDaoImpl<CrawlerNewsinfo> implements CrawlerNewsinfoDao {
    @Override
    public int deleteCurrentDayCrawlerData() {
        return this.delete(this.generateStatement("deleteCurrentDay"), null);
    }
}
