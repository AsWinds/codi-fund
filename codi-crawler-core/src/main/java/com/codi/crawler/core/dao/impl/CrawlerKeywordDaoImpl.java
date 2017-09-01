package com.codi.crawler.core.dao.impl;

import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.crawler.core.dao.CrawlerKeywordDao;
import com.codi.crawler.core.domain.CrawlerKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/18.
 */
@Repository("crawlerKeywordDao")
public class CrawlerKeywordDaoImpl extends GeneratedBaseDaoImpl<CrawlerKeyword> implements CrawlerKeywordDao{
    @Override
    public List<CrawlerKeyword> selectAll() {
        return this.findList(this.generateStatement("selectAll"), null);
    }
}
