package com.codi.fundData.service;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.SecurityProduct;

/**
 * 证券主表
 * 
 * @author shi.pengyan
 * @date 2016年11月21日 下午1:34:24
 */
public interface SecurityProductService {

    /**
     * 查询证券(不缓存)
     * 
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseAppException
     */
    SecurityProduct querySecurityProduct(String fundCode) throws BaseAppException;
}
