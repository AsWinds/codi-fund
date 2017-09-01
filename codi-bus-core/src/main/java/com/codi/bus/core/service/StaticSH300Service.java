package com.codi.bus.core.service;

import java.util.Date;
import java.util.List;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.domain.StaticSH300;
import com.codi.bus.core.service.model.FundStatisticModel;

/**
 * 深沪300数据采集
 * 
 * @author shi.pengyan
 * @date 2016年11月3日 上午9:51:06
 */
public interface StaticSH300Service {

    /**
     * 清空所有数据
     * 
     * @throws BaseAppException
     */
    public int clearAll() throws BaseAppException;

    /**
     * 导入全部数据
     * 
     * @throws BaseAppException
     */
    public void addAll() throws BaseAppException;

    /**
     * 添加最新数据
     * 
     * @throws BaseAppException
     */
    public void addLatestData() throws BaseAppException;

    /**
     * 最近多长时间的统计数据，数据较为底层
     * 
     * @param monthCount
     *            月份的数量
     * @param endDate
     *            结束日期
     * @return
     * @throws BaseAppException
     */
    public List<FundStatisticModel> getStatisticData(int monthCount, Date endDate) throws BaseAppException;

    /**
     * 获取最新记录
     * 
     * @return
     * @throws BaseAppException
     */
    public StaticSH300 getLatestRecord() throws BaseAppException;

}
