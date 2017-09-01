package com.codi.bus.core.sys.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by wangzhenhao on 2017/5/11.
 */
@Data
public class CrawlerNewsinfoVo {
    private Integer id;

    private String title;

    private String link;

    private Date releaseDate;

    private String source;

    private Date crawlerDate;

    private String matchDegree;

    private String mainContent;
}
