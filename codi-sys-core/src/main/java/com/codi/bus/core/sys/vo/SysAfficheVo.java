package com.codi.bus.core.sys.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.codi.base.validation.annotation.Strings;
import com.codi.bus.core.sys.domain.SysAffiche;

import lombok.Data;

/**
 * 公告
 * */
@Data
public class SysAfficheVo {
	
	/**
	 * id
	 * */
	private Long id;
	
	/**
	 * 标题
	 * */
	@NotEmpty
	private String title;
	
	/**
	 * 内容
	 * */
	private String content;
	
	/**
	 * 链接
	 * */
	@URL(protocol = "http")
	private String link;

	/**
	 * 是否置顶
	 * */
	@NotNull
	private Boolean isUp;
	
	/**
	 * 发布时间
	 * */
	@NotNull
	private Date publishTime;
	
	/**
	 * 下线时间
	 * */
	private Date endTime;
	
	/**
	 * 发布者
	 * */
	@Null
	private String publisher;
	
	/**
	 * 发布位置
	 * */
	@Strings(values = {SysAffiche.L_APP, SysAffiche.L_PC})
	@NotNull
	private String location;
}
