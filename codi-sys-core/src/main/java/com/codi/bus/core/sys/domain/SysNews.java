package com.codi.bus.core.sys.domain;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * �ף�д����ע����
 * @author Administrator
 * @date 2017-05-03 16:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysNews extends BaseDomain {
	public static final String STATUS_OFF = "下线";
	public static final String STATUS_ON = "上线";
	
	public static final String LOCATION_PC = "PC";
	public static final String LOCATION_APP = "APP";
	
    private Long id;

    private String title;
    
    private String briefTitle;
    
    private String description;

    private String source;

    private String fromUrl;

    private Date publishDate;

    private Date modifyDate;

    private String location;

    private String status;

    private String publisher;

    private String keyword;

    private String content;

    private static final long serialVersionUID = 1L;
}