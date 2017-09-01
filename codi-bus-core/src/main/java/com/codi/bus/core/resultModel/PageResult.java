package com.codi.bus.core.resultModel;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class PageResult<T> extends CollectionResult<T> {

	private static final long serialVersionUID = 1L;
	
	private final int page;
	private final int size;
	private final int totalPage;
	
	public PageResult(Page<T> page) {
		this.page = page.getNumber();
		this.size = page.getSize();
		this.totalPage = page.getTotalPages();
		this.setTotalNum(page.getTotalElements());
		this.setObjs(page.getContent());
	}

}
