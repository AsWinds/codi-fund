package com.codi.crawler.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.crawler.core.domain.CrawlerKeyword;

import java.util.List;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-15 13:59
 */
public interface CrawlerKeywordDao extends GeneratedBaseDao<CrawlerKeyword> {
    List<CrawlerKeyword> selectAll();
}
