package com.codi.bus.core.sys.domain;

import com.codi.base.domain.BaseDomain;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-08 13:12
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