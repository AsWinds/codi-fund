package com.codi.bus.core.sys.service.impl;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.dao.CrawlerKeywordDao;
import com.codi.bus.core.sys.domain.CrawlerKeyword;
import com.codi.bus.core.sys.service.CrawlerKeywordsService;
import com.codi.bus.core.sys.vo.CrawlerKeywordVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/8.
 */

@Service
public class CrawlerKeywordsServiceImpl implements CrawlerKeywordsService{
    @Autowired
    private CrawlerKeywordDao skDao;

    public static Converter<CrawlerKeyword, CrawlerKeywordVo> do2vo = new Converter<CrawlerKeyword, CrawlerKeywordVo>() {
        @Override
        public CrawlerKeywordVo convert(CrawlerKeyword keyword) {
            CrawlerKeywordVo vo = new CrawlerKeywordVo();
            BeanUtils.copyProperties(keyword, vo);
            return vo;
        }
    };

    public static Converter<CrawlerKeywordVo, CrawlerKeyword> vo2do = new Converter<CrawlerKeywordVo, CrawlerKeyword>() {
        @Override
        public CrawlerKeyword convert(CrawlerKeywordVo keywordVo) {
            CrawlerKeyword keyword = new CrawlerKeyword();
            BeanUtils.copyProperties(keywordVo, keyword);
            return keyword;
        }
    };

    @Override
    public BaseResult findAllKeywords() {
        List<CrawlerKeyword> keywords = skDao.select();
        List<CrawlerKeywordVo> keywordVos = new ArrayList<>();

        for (CrawlerKeyword keyword : keywords) {
            CrawlerKeywordVo vo = new CrawlerKeywordVo();
            BeanUtils.copyProperties(keyword, vo);
            keywordVos.add(vo);
        }

        BaseResult result = new BaseResult(keywordVos);

        return result;
    }

    @Override
    public BaseResult updateAllKeywords(List<CrawlerKeywordVo> keywordVos) {
        List<CrawlerKeyword> keywords = new ArrayList<>();

        for (CrawlerKeywordVo vo : keywordVos) {
            CrawlerKeyword keyword = new CrawlerKeyword();
            BeanUtils.copyProperties(vo, keyword);
            keywords.add(keyword);
        }

        skDao.deleteAllKeywords();
        skDao.insertAllKeywords(keywords);

        BaseResult result = new BaseResult();

        return result;
    }
}
