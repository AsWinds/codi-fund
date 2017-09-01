package com.codi.fundData.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundMMYieldPerformanceDao;
import com.codi.fundData.domain.FundMMYieldPerformance;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:58:48
 */
@Repository("fundMMYieldPerformanceDao")
public class FundMMYieldPerformanceDaoImpl extends BaseDAOImpl<FundMMYieldPerformance> implements
        FundMMYieldPerformanceDao {

    @Override
    public FundMMYieldPerformance selectFundMMYieldPerformace(FundMMYieldPerformance record) {
        return this.getObject(generateStatement("selectMMYiedlPerformaceLatest"), record);
    }

    @Override
    public FundMMYieldPerformance selectFundMMYieldPerformaceList(Integer innerCode) {
        // TODO
        return null;
    }

}
