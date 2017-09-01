package com.codi.fundData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.dao.FundMMYieldPerformanceDao;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.service.FundMMYieldPerformanceService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年12月9日 下午5:28:04
 */
@Service("fundMMYieldPerformanceService")
public class FundMMYieldPerformanceServiceImpl implements FundMMYieldPerformanceService {

    @Resource(name = "fundMMYieldPerformanceDao")
    private FundMMYieldPerformanceDao fundMMYieldPerformanceDao;

    @Override
    public FundMMYieldPerformance getFundMMYieldPerformance(Integer innerCode) throws BaseAppException {
        FundMMYieldPerformance record = new FundMMYieldPerformance();
        record.setInnerCode(innerCode);

        return fundMMYieldPerformanceDao.selectFundMMYieldPerformace(record);
    }

}
