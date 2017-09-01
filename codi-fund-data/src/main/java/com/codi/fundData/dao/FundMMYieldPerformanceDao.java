package com.codi.fundData.dao;

import com.codi.fundData.domain.FundMMYieldPerformance;

/**
 * 货币基金收益表现
 * 
 * @author shi.pengyan
 * @date 2016年9月25日 上午9:56:11
 */
public interface FundMMYieldPerformanceDao {

    /**
     * 查询最新记录
     * 
     * @param record
     *            货基模型
     * @return
     */
    FundMMYieldPerformance selectFundMMYieldPerformace(FundMMYieldPerformance record);

    /**
     * 
     * @param innerCode
     * @return
     */
    FundMMYieldPerformance selectFundMMYieldPerformaceList(Integer innerCode);

}