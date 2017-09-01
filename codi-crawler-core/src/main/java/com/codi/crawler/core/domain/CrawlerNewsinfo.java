package com.codi.crawler.core.domain;

import com.codi.base.domain.BaseDomain;
import java.util.Date;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-18 14:48
 */
public class CrawlerNewsinfo extends BaseDomain {
    private Integer id;

    private String title;

    private String link;

    private String releaseDate;

    private String source;

    private Date crawlerDate;

    private String matchDegree;

    private String mainContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getCrawlerDate() {
        return crawlerDate;
    }

    public void setCrawlerDate(Date crawlerDate) {
        this.crawlerDate = crawlerDate;
    }

    public String getMatchDegree() {
        return matchDegree;
    }

    public void setMatchDegree(String matchDegree) {
        this.matchDegree = matchDegree == null ? null : matchDegree.trim();
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent == null ? null : mainContent.trim();
    }
}