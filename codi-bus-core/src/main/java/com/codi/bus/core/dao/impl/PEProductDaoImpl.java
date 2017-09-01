package com.codi.bus.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.PEProductDao;
import com.codi.bus.core.domain.PEProduct;

/**
 * 
 * @author Shangdu Lin
 *  
 * @date 2017年1月9日 下午11:18:36
 */
@Repository("peproductDao")
public class PEProductDaoImpl extends BaseDAOImpl<PEProduct> implements PEProductDao {

	@Override
	public List<PEProduct> queryList(Integer status) {
		return this.findList(this.generateStatement("selectByStatus"), status);
	}

}
