package com.codi.fundData.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundPersonInfoDao;
import com.codi.fundData.domain.FundPersonInfo;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月17日 上午9:59:06
 */
@Repository("fundPersonInfoDao")
public class FundPersonInfoDaoImpl extends BaseDAOImpl<FundPersonInfo> implements FundPersonInfoDao {

    @Override
    public FundPersonInfo select(FundPersonInfo record) {
        return this.getObject(generateStatement("selectPersonInfo"), record);
    }

}
