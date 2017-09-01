package com.codi.fundData.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundNetValuePerformance;

/**
 * 基金净值最新表现</br>
 * <p>
 * 基金的最新表现，包括周、一个月、三个月、半年、一年、二年、三年、五年、十年、成立以来的回报
 * </p>
 * 
 * @author shi.pengyan
 * @date 2016年11月4日 下午1:42:39
 */
public interface FundNetValuePerformanceDao {
    /**
     * 查询基金表现
     * 
     * @param record
     * @return
     */
    FundNetValuePerformance select(FundNetValuePerformance record);

    /**
     * 查询最新的基金表现
     * 
     * @param innerCode
     *            内部编码
     * @return
     */
    FundNetValuePerformance selectLatest(Integer innerCode);

    /**
     * 查询统计数据的排序
     * 
     * @param innerCodes
     *            内部编码列表
     * @param statisType
     *            统计类型
     * @param tradingDay
     *            交易日
     * @param pageIndex
     *            页码，从1开始
     * @param pageSize
     *            记录数
     * @param sort
     *            升、降序0/1
     * @return
     * @throws BaseAppException
     */
    List<Map<String, Object>> selectSort(List<Integer> innerCodes, Integer statisType, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException;

}