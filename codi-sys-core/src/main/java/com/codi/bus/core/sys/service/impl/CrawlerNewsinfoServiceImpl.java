package com.codi.bus.core.sys.service.impl;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.dao.CrawlerNewsinfoDao;
import com.codi.bus.core.sys.domain.CrawlerNewsinfo;
import com.codi.bus.core.sys.service.CrawlerNewsinfoService;
import com.codi.bus.core.sys.vo.CrawlerNewsinfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangzhenhao on 2017/5/11.
 */
@Service
public class CrawlerNewsinfoServiceImpl implements CrawlerNewsinfoService{
    @Autowired
    private CrawlerNewsinfoDao newsinfoDao;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;
    /**
     * 分页查询资讯
     * @param pageReq
     * @return
     */
    @Override
    public BaseResult queryList(Pageable pageReq) {
        Page<CrawlerNewsinfo> newsinfos = newsinfoDao.query(pageReq);

        return new PageResult<>(newsinfos.map(new Converter<CrawlerNewsinfo, Object>() {
            @Override
            public Object convert(CrawlerNewsinfo crawlerNewsinfo) {
                CrawlerNewsinfoVo vo = new CrawlerNewsinfoVo();
                BeanUtils.copyProperties(crawlerNewsinfo, vo);

                return vo;
            }
        }));
    }

    @Override
    public BaseResult search(Pageable pageReq, String content) {
        Page<CrawlerNewsinfo> newsinfos = newsinfoDao.search(pageReq, content);

        return new PageResult<>(newsinfos.map(new Converter<CrawlerNewsinfo, Object>() {
            @Override
            public Object convert(CrawlerNewsinfo crawlerNewsinfo) {
                CrawlerNewsinfoVo vo = new CrawlerNewsinfoVo();
                BeanUtils.copyProperties(crawlerNewsinfo, vo);

                return vo;
            }
        }));
    }

    @Override
    public BaseResult triggerCrawler() {

        redisTemplate.convertAndSend("pubsub:trigger","trigger_now");

        return new BaseResult();
    }
}
