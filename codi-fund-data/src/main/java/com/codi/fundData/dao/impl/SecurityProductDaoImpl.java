package com.codi.fundData.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dataSource.annotation.DataSource;
import com.codi.bus.constant.GlobalConstant;
import com.codi.fundData.dao.SecurityProductDao;
import com.codi.fundData.domain.SecurityProduct;

/**
 * 证券主表
 * 
 * @author shi.pengyan
 * @date 2016年9月21日 下午7:11:58
 */
@Repository("securityProductDao")
public class SecurityProductDaoImpl extends BaseDAOImpl<SecurityProduct> implements SecurityProductDao {

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public SecurityProduct querySecurityProduct(String secuCode) {
        return this.getObject(generateStatement("selectSecurtyProduct"), secuCode);
    }

    @Override
    public List<SecurityProduct> querySecurityProducts(List<String> fundCodes) {
        return this.findList(generateStatement("selectSecurtyProducts"), fundCodes);
    }

}
