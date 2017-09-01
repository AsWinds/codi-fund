package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.fundData.domain.FundDividend;

/**
 * 基金分红
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 上午10:28:29
 */
public interface FundDividendDao {
    List<FundDividend> select(Map<String, Object> record);
}