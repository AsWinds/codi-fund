package com.codi.bus.core.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.LookupKey;

public interface LookupDao extends BaseDAO<Lookup> {
    
	/**
	 * 查询证券类型
	 * @param type
	 * @return
	 */
	List<Lookup> getLookupByType(String type);
	
	/**
	 * 根据Key来获取一个lookup
	 * @param key
	 * @return
	 */
	Lookup getLookupByKey(LookupKey key);
	
}