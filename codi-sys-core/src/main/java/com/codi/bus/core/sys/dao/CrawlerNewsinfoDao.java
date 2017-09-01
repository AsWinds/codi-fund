package com.codi.bus.core.sys.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.sys.domain.CrawlerNewsinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-10 17:22
 */
public interface CrawlerNewsinfoDao extends BaseDAO<CrawlerNewsinfo> {

    /**
     * 爬虫资讯分页
     */
    Page<CrawlerNewsinfo> query(Pageable pageReq);

    /**
     * 资讯查询分页
     */
    Page<CrawlerNewsinfo> search(Pageable pageReq, String content);
}
