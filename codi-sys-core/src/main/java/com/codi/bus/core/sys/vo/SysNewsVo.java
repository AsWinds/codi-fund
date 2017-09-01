package com.codi.bus.core.sys.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;

import com.codi.base.validation.annotation.Strings;
import com.codi.bus.core.sys.domain.SysNews;

import lombok.Data;

@Data
public class SysNewsVo {
	
    private Long id;

    @NotEmpty
    private String title;
    
    @NotEmpty
    private String briefTitle;
    
    private String description;

    private String source;

    private String fromUrl;

    @NotNull
    private Date publishDate;

    @Null
    private Date modifyDate;

    @Strings(values = {SysNews.LOCATION_APP, SysNews.LOCATION_PC})
    @NotEmpty
    private String location;

    @Strings(values = {SysNews.STATUS_ON, SysNews.STATUS_OFF})
    @NotEmpty
    private String status;

    @NotEmpty
    private String publisher;

    @NotNull
    private String keyword;

    @NotEmpty
    private String content;
}
