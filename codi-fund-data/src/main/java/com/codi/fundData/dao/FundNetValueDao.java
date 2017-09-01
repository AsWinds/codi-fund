package com.codi.fundData.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundNetValue;

/**
 * 基金净值
 * 
 * @author shi.pengyan
 * @date 2016年9月26日 下午5:31:35
 */
public interface FundNetValueDao {

    /**
     * 基金净值
     * 
     * @param fundNetValue
     * @return
     */
    FundNetValue selectFundNetValue(FundNetValue fundNetValue);

    /**
     * 查看净值列表
     * 
     * @param innerCode
     *            基金内部编码
     * @param pageIndex
     *            页码
     * @param pageSize
     *            记录数
     * @return
     */
    List<FundNetValue> selectFundNetValue(Integer innerCode, Integer pageIndex, Integer pageSize,Integer sort);

    /**
     * 查询指定基金的净值，并排序<br/>
     * 货基和非货基没有可比性 (同一日期比较)
     * 
     * @param innerCodes
     *            基金内部编码列表
     * @param isCurrency
     *            是否是货币
     * @param tradingDay
     *            交易日
     * @param pageIndex
     *            页码，从1开始
     * @param pageSize
     *            记录数
     * @param sort
     *            升降序;0:升序；1：降序
     * @return
     */
    List<Map<String, Object>> selectSort(List<Integer> innerCodes, boolean isCurrency, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort);

    /**
     * 查询指定基金的净值，并排序<br/>
     * 货基和非货基没有可比性 (没有同一日期比较排到最后)
     * 
     * @param innerCodes
     *            基金内部编码列表
     * @param isCurrency
     *            是否是货币
     * @param tradingDay
     *            交易日
     * @param pageIndex
     *            页码，从1开始
     * @param pageSize
     *            记录数
     * @param sort
     *            升降序;0:升序；1：降序
     * @return
     */
    List<Map<String, Object>> selectSortOrderyByNotSameDay(List<Integer> innerCodes, boolean isCurrency, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort);

    /**
     * 选择某基金的最新一条记录
     * 
     * @param innerCode
     * @return
     * @throws BaseAppException
     */
    FundNetValue selectLatest(Integer innerCode) throws BaseAppException;

    /**
     * 查询基金在某段时间内的数据
     * 
     * @param innerCode
     *            基金内部编码
     * @param beiginDate
     *            开始时间
     * @param endDate
     *            结束时间
     * @return
     * @throws BaseAppException
     */
    List<FundNetValue> select(Integer innerCode, Date beginDate, Date endDate) throws BaseAppException;

}