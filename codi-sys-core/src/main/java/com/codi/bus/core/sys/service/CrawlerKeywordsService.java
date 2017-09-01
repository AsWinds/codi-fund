package com.codi.bus.core.sys.service;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.vo.CrawlerKeywordVo;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/8.
 */
public interface CrawlerKeywordsService {
    BaseResult findAllKeywords();

    BaseResult updateAllKeywords(List<CrawlerKeywordVo> keywordVos);
}
