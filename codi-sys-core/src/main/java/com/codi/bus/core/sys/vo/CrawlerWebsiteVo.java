package com.codi.bus.core.sys.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by wangzhenhao on 2017/5/12.
 */
@Data
public class CrawlerWebsiteVo {
    private Integer id;

    private String name;

    private String link;

    private String selectorTitle;

    private String selectorLink;

    private String selectorDate;

    private Date operateDate;
}
