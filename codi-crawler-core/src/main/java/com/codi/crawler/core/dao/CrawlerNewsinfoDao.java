package com.codi.crawler.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.crawler.core.domain.CrawlerNewsinfo;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-18 14:48
 */
public interface CrawlerNewsinfoDao extends GeneratedBaseDao<CrawlerNewsinfo> {
    int deleteCurrentDayCrawlerData();
}
