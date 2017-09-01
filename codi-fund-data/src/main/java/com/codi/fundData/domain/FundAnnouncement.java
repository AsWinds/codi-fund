package com.codi.fundData.domain;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金公告(临时公告+公告原文(季报))
 * 
 * @author shi.pengyan
 * @date 2016年9月25日 下午12:36:14
 */
public class FundAnnouncement extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long ID;
    private Integer innerCode;
    private String title;
    private String subTitle;
    private String content;
    private int categroyType;
    private Date publicDate;
    private String media;
    private String resourceType; // 来源

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public Integer getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategroyType() {
        return categroyType;
    }

    public void setCategroyType(int categroyType) {
        this.categroyType = categroyType;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

}