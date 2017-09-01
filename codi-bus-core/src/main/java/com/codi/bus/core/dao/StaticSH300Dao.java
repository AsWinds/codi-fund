package com.codi.bus.core.dao;

import java.util.Date;
import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.domain.StaticSH300;

/**
 * 深沪300统计数据
 * 
 * @author shi.pengyan
 * @date 2016年11月3日 上午9:42:47
 */
public interface StaticSH300Dao extends BaseDAO<StaticSH300> {

    /**
     * 插入单条数据
     * 
     * @param record
     * @return
     */
    int insert(StaticSH300 record) throws BaseAppException;

    /**
     * 批量插入数据
     * 
     * @param data
     * @return
     * @throws BaseAppException
     */
    int insertByBatch(List<StaticSH300> data) throws BaseAppException;

    /**
     * 删除所有数据
     * 
     * @return
     */
    int deleteAll() throws BaseAppException;

    /**
     * 选择最新一条记录
     * 
     * @return
     * @throws BaseAppException
     */
    StaticSH300 selectLatest() throws BaseAppException;

    /**
     * 查询指定日期内的内容
     * 
     * @param beginDate
     * @param endDate
     * @return
     * @throws BaseAppException
     */
    List<StaticSH300> select(Date beginDate, Date endDate) throws BaseAppException;

    /**
     * 查询指定日期的交易
     * 
     * @param tradingDate
     * @return
     * @throws BaseAppException
     */
    StaticSH300 select(Date tradingDate) throws BaseAppException;

}