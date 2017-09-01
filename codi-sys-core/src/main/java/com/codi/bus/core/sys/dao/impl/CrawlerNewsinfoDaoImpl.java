package com.codi.bus.core.sys.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.PageImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.bus.core.sys.dao.CrawlerNewsinfoDao;
import com.codi.bus.core.sys.domain.CrawlerNewsinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by wangzhenhao on 2017/5/11.
 */
@Repository("crawlerNewsinfoDao")
public class CrawlerNewsinfoDaoImpl extends BaseDAOImpl<CrawlerNewsinfo> implements CrawlerNewsinfoDao{

    @Override
    public Page<CrawlerNewsinfo> query(Pageable pageReq) {
        PageView pageView = getPageView(pageReq.getPageNumber(), pageReq.getPageSize());

        Map<String, Object> map = new HashMap<>();
        map.put("pageView", pageView);

        List<CrawlerNewsinfo> newsinfos = this.findList(this.generateStatement("queryByPage"), map);

        return new PageImpl<CrawlerNewsinfo>(newsinfos, pageReq, pageView.getRowCount());
    }

    @Override
    public Page<CrawlerNewsinfo> search(Pageable pageReq, String content) {
        PageView pageView = getPageView(pageReq.getPageNumber(), pageReq.getPageSize());

        Map<String, Object> map = new HashMap<>();
        map.put("pageView", pageView);
        map.put("search", content);

        List<CrawlerNewsinfo> newsinfos = this.findList(this.generateStatement("querySearch"), map);

        return new PageImpl<CrawlerNewsinfo>(newsinfos, pageReq, pageView.getRowCount());
    }
}
