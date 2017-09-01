package com.codi.fundData.service;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundMMYieldPerformance;

/**
 * 货基收益
 * 
 * @author shi.pengyan
 * @date 2016年12月9日 上午11:24:13
 */
public interface FundMMYieldPerformanceService {

    /**
     * 获取最新的货币基金收益
     * 
     * @param innerCode
     *            内部编码
     * @return 基金收益
     * @throws BaseAppException
     */
    FundMMYieldPerformance getFundMMYieldPerformance(Integer innerCode) throws BaseAppException;
}
