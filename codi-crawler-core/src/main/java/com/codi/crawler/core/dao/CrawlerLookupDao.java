package com.codi.crawler.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.crawler.core.domain.CrawlerLookup;

import java.util.List;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-22 11:21
 */
public interface CrawlerLookupDao extends GeneratedBaseDao<CrawlerLookup> {
    List<CrawlerLookup> selectTriggerTime();

    int updateTriggerTime(CrawlerLookup lookup);
}
