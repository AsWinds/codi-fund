package com.codi.crawler.core.domain;

import com.codi.base.domain.BaseDomain;
import java.util.Date;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-17 17:15
 */
public class CrawlerWebsite extends BaseDomain {
    private Integer id;

    private String name;

    private String link;

    private String selectorFatherNode;

    private String selectorLink;

    private String selectorDate;

    private Date operateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getSelectorFatherNode() {
        return selectorFatherNode;
    }

    public void setSelectorFatherNode(String selectorFatherNode) {
        this.selectorFatherNode = selectorFatherNode == null ? null : selectorFatherNode.trim();
    }

    public String getSelectorLink() {
        return selectorLink;
    }

    public void setSelectorLink(String selectorLink) {
        this.selectorLink = selectorLink == null ? null : selectorLink.trim();
    }

    public String getSelectorDate() {
        return selectorDate;
    }

    public void setSelectorDate(String selectorDate) {
        this.selectorDate = selectorDate == null ? null : selectorDate.trim();
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }
}