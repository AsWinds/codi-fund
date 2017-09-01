package com.codi.crawler.core.dao.impl;

import com.codi.base.dao.PageImpl;
import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.crawler.core.dao.CrawlerWebsiteDao;
import com.codi.crawler.core.domain.CrawlerWebsite;
import com.github.pagehelper.PageRowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/18.
 */
@Repository("crawlerWebsiteDao")
public class CrawlerWebsiteDaoImpl extends GeneratedBaseDaoImpl<CrawlerWebsite> implements CrawlerWebsiteDao{
    @Override
    public List<CrawlerWebsite> selectAll() {
        List<CrawlerWebsite> websites = this.findList(this.generateStatement("selectAll"), null);

        return websites;
    }

    @Override
    public int add(CrawlerWebsite website) {
        return this.insert(this.generateStatement("insertSelective"), website);
    }

    @Override
    public int modify(CrawlerWebsite website) {
        return this.updateByPrimaryKeySelective(website);
    }

    @Override
    public int delete(int websiteId) {
        return this.delete(this.generateStatement("deleteByPrimaryKey"), websiteId);
    }

    @Override
    public Page<CrawlerWebsite> findList(Pageable pageReq) {
        PageRowBounds prb = new PageRowBounds(pageReq.getPageNumber(), pageReq.getPageSize());
        List<CrawlerWebsite> websites = this.findList("listWebsites", null, prb);

        return new PageImpl<CrawlerWebsite>(websites, pageReq, prb.getTotal());
    }
}
