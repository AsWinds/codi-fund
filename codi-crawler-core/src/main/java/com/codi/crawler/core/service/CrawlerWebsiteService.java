package com.codi.crawler.core.service;

import com.codi.base.domain.BaseResult;
import com.codi.crawler.core.vo.CrawlerWebsiteVo;
import org.springframework.data.domain.Pageable;

/**
 * Created by wangzhenhao on 2017/5/22.
 */
public interface CrawlerWebsiteService {
    /**
     * 分页查询
     * @param pageable
     * @return
     */
    BaseResult queryList(Pageable pageable);

    /**
     * 添加网站
     * @param website
     * @return
     */
    BaseResult addWebsite(CrawlerWebsiteVo vo);

    /**
     * 更新网站
     * @param website
     * @return
     */
    BaseResult updateWebsite(CrawlerWebsiteVo vo);

    /**
     * 删除网站
     * @param websiteId
     * @return
     */
    int delete(int websiteId);
}
