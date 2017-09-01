package com.codi.bus.core.sys.service;

import com.codi.base.domain.BaseResult;
import org.springframework.data.domain.Pageable;

/**
 * Created by wangzhenhao on 2017/5/11.
 */
public interface CrawlerNewsinfoService {
    /**
     * 分页查询资讯
     * @param pageReq
     * @return
     */
    BaseResult queryList(Pageable pageReq);

    BaseResult search(Pageable pageReq, String content);

    BaseResult triggerCrawler();
}
