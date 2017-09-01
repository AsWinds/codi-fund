package com.codi.crawler.core.domain;

import com.codi.base.domain.BaseDomain;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-15 13:59
 */
public class CrawlerKeyword extends BaseDomain {
    private Integer id;

    private String keyword;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}