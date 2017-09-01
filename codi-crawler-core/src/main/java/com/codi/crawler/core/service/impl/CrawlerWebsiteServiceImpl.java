package com.codi.crawler.core.service.impl;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.crawler.core.dao.CrawlerWebsiteDao;
import com.codi.crawler.core.domain.CrawlerWebsite;
import com.codi.crawler.core.service.CrawlerWebsiteService;
import com.codi.crawler.core.vo.CrawlerWebsiteVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
@Service
public class CrawlerWebsiteServiceImpl implements CrawlerWebsiteService{
    @Autowired
    private CrawlerWebsiteDao websiteDao;

    @Override
    public BaseResult queryList(Pageable pageable) {
        Page<CrawlerWebsite> websites = websiteDao.findList(pageable);

        return new PageResult<>(websites.map(new Converter<CrawlerWebsite, Object>() {
            @Override
            public Object convert(CrawlerWebsite website) {
                CrawlerWebsiteVo vo = new CrawlerWebsiteVo();
                BeanUtils.copyProperties(website, vo);

                return vo;
            }
        }));
    }

    @Override
    public BaseResult addWebsite(CrawlerWebsiteVo vo) {
        CrawlerWebsite website = new CrawlerWebsite();
        BeanUtils.copyProperties(vo, website);
        website.setOperateDate(new Date());

        websiteDao.add(website);

        return new BaseResult();
    }

    @Override
    public BaseResult updateWebsite(CrawlerWebsiteVo vo) {
        CrawlerWebsite website = new CrawlerWebsite();
        BeanUtils.copyProperties(vo, website);
        website.setOperateDate(new Date());

        websiteDao.modify(website);

        return new BaseResult();
    }

    @Override
    public int delete(int websiteId) {
        return websiteDao.delete(websiteId);
    }
}
