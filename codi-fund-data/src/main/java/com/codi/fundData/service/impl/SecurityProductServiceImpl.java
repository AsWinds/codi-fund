package com.codi.fundData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codi.base.dataSource.annotation.DataSource;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.constant.GlobalConstant;
import com.codi.fundData.dao.SecurityProductDao;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.fundData.service.SecurityProductService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月21日 下午1:48:37
 */
@Service("securityProductService")
public class SecurityProductServiceImpl implements SecurityProductService {

    @Resource(name = "securityProductDao")
    private SecurityProductDao securityProductDao;

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public SecurityProduct querySecurityProduct(String fundCode) throws BaseAppException {
        return securityProductDao.querySecurityProduct(fundCode);
    }

}
