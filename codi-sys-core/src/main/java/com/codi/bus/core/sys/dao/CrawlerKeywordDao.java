package com.codi.bus.core.sys.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.sys.domain.CrawlerKeyword;

import java.util.List;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-08 13:12
 */
public interface CrawlerKeywordDao extends BaseDAO<CrawlerKeyword> {

    int insert(CrawlerKeyword record);


    List<CrawlerKeyword> select();

    int deleteAllKeywords();


    int insertAllKeywords(List<CrawlerKeyword> keywords);
}
