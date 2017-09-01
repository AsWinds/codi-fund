package com.codi.fundData.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundNetValue;

/**
 * 基金净值
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 下午2:54:51
 */
public interface FundNetValueService {

    FundNetValue selectLatest(Integer innerCode) throws BaseAppException;

    List<Map<String, Object>> selectSort(List<Integer> innerCodes, boolean isCurrency, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException;

}
