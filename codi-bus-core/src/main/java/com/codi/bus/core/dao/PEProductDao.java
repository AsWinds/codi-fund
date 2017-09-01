package com.codi.bus.core.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.PEProduct;

/**
 * 
 * @author Shangdu Lin
 *  
 * @date 2017年1月9日 下午11:17:10
 */
public interface PEProductDao extends BaseDAO<PEProduct> {
	/**
	 * 查询产品
	 * @param status
	 * @return
	 */
    List<PEProduct> queryList(Integer status);
}