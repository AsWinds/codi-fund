package com.codi.fundData.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundNetValuePerformance;

/**
 * 基金净值表现
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 下午2:54:51
 */
public interface FundNetValuePerformanceService {

    FundNetValuePerformance selectLatest(Integer innerCode) throws BaseAppException;

    List<Map<String, Object>> selectSort(List<Integer> innerCodes, Integer statisType, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException;

}
