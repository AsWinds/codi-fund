package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.domain.PEProduct;

/**
 * 
 * @author Shangdu Lin
 *  
 * @date 2017年1月9日 下午11:21:20
 */
public interface PEProductService {
	/**
	 * 查询产品
	 * @param status
	 * @return
	 */
    List<PEProduct> queryList(Integer status);
}
