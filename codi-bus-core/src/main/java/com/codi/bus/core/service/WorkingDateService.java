package com.codi.bus.core.service;

import com.codi.bus.core.resultModel.WorkingDayResult;
import com.codi.bus.exception.BaseException;

import java.util.Date;

/**
 * 工作日服务
 *
 * @author Shangdu Lin
 * @date 2016年12月27日 下午4:34:42
 */
public interface WorkingDateService {
	/**
	 * 获取下一个工作日
	 *
	 * @param currentDate
	 * @return
	 */
	WorkingDayResult getNextWorkingDay(Date currentDate) throws BaseException;

	/**
	 * 获取上一个工作日
	 *
	 * @param currentDate
	 * @return
	 */
	WorkingDayResult getLastWorkingDay(Date currentDate) throws BaseException;

	/**
	 * 判断当前日期是否为工作日
	 *
	 * @param currentDate
	 * @return
	 * @throws BaseException
	 */
	boolean isWorkingDate(Date currentDate) throws BaseException;

    /**
     * 获取当前工作日
     * @param currentDate
     * @return
     * @throws BaseException
     */
    Date getWorkingDay(Date currentDate) throws BaseException;

	/**
	 * 获取工作日, 如果是周末，则会是连续的几天，比如当前日是周六，非工作日，则此方法会返回周六，周日，下周一
	 *
	 * @param currentDate
	 * @return
	 * @throws BaseException
	 */
	WorkingDayResult getWorkingDays(Date currentDate) throws BaseException;
}
