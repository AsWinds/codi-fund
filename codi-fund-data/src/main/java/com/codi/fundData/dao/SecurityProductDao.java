package com.codi.fundData.dao;

import java.util.List;

import com.codi.fundData.domain.SecurityProduct;

/**
 * 证券主表
 * 
 * @author shi.pengyan
 * @date 2016年11月21日 下午1:47:06
 */
public interface SecurityProductDao {

    SecurityProduct querySecurityProduct(String secuCode);

    List<SecurityProduct> querySecurityProducts(List<String> fundCodes);
}