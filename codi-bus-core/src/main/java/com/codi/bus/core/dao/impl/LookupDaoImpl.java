/**
 * 
 */
package com.codi.bus.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.LookupKey;

/**
 * @author Administrator
 *
 */
@Repository("lookupDao")
public class LookupDaoImpl extends BaseDAOImpl<Lookup> implements LookupDao {

	/**
	 * 根据字典类型查询数据
	 */
	public List<Lookup> getLookupByType(String type) {
		return this.findList(generateStatement("queryLookupByType"), type);
	}

	@Override
	public Lookup getLookupByKey(LookupKey key) { 
		return this.getObject(generateStatement("queryLookupByKey"), key);		
	}

	

}
