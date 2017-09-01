package com.codi.fundData.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundTrusteeDao;
import com.codi.fundData.domain.FundTrustee;

/**
 * 基金托管人
 * 
 * @author shi.pengyan
 * @date 2016年10月10日 下午1:40:55
 */
@Repository("fundTrusteeDao")
public class FundTrusteeDaoImpl extends BaseDAOImpl<FundTrustee> implements FundTrusteeDao {

    @Override
    public FundTrustee select(Integer trusteeCode) {
        return this.getObject(generateStatement("selectFundTrustee"), trusteeCode);
    }

}
