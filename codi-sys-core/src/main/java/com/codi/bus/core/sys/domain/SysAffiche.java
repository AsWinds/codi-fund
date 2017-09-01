package com.codi.bus.core.sys.domain;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公告
 * @author Administrator
 * @date 2017-05-02 14:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysAffiche extends BaseDomain {
	public static final String L_APP = "APP";
	public static final String L_PC = "PC";
	
    private Long id;

    private String title;

    private String link;

    private Boolean isUp;

    private Date publishTime;

    private Date endTime;

    private String publisher;

    private String location;

    private String content;

    private static final long serialVersionUID = 1L;
}