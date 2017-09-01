package com.codi.bus.core.service.impl;

import com.codi.bus.core.dao.PEProductDao;
import com.codi.bus.core.domain.PEProduct;
import com.codi.bus.core.service.PEProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Shangdu Lin
 *
 * @date 2017年1月9日 下午11:21:14
 */
@Service("peproductService")
public class PEProductServiceImpl implements PEProductService {

	@Autowired
	private PEProductDao peproductDao;

	@Override
	public List<PEProduct> queryList(Integer status) {
		return peproductDao.queryList(status);
	}

}
