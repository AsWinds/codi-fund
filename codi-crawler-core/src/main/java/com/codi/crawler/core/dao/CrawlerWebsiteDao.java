package com.codi.crawler.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.crawler.core.domain.CrawlerWebsite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-17 17:15
 */
public interface CrawlerWebsiteDao extends GeneratedBaseDao<CrawlerWebsite> {
    List<CrawlerWebsite> selectAll();

    int add(CrawlerWebsite website);

    int modify(CrawlerWebsite website);

    int delete(int websiteId);

    Page<CrawlerWebsite> findList(Pageable pageReq);
}
