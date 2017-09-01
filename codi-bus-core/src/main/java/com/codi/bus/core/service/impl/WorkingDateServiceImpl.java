package com.codi.bus.core.service.impl;

import com.codi.base.util.DateUtils;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.WorkingDayResult;
import com.codi.bus.core.service.WorkingDateService;
import com.codi.bus.core.service.util.HundsunUtils;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.message.constant.ErrorConstant;
import com.codi.trade.service.NextDayQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工作日服务
 *
 * @author Shangdu Lin
 * @date 2016年12月27日 下午4:34:17
 */
@Service("workingDateService")
public class WorkingDateServiceImpl implements WorkingDateService {

	private static final Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

	@Resource(name = "nextDayQueryService")
	private NextDayQueryService nextDayQueryService;

	/**
	 * 获取下一个工作日
	 *
	 * @param currentDate
	 * @return
	 */
	@Override
	public WorkingDayResult getNextWorkingDay(Date currentDate) throws BaseException {
		try {

			WorkingDayResult result = new WorkingDayResult();
			Map<String, Object> map = nextDayQueryService.query(currentDate);
			// 查询结果
			List<Map<String, Object>> list = new ArrayList<>();
			HundsunUtils.ConvertToList(map, list, result);
			if (!result.getSuccess()) {
				return result;
			}

			String nextDay = "";
			for (Map<String, Object> item : list) {
				// 记录数
				String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
				if (StringUtil.isEmpty(rowCount)) {
					result.setSuccess(false);
					result.setErrorCode(ErrorConstant.ERROR_CANNOT_FIND_NEXT_WORKING_DAY);
					return result;
				}

				nextDay = item.get(HSOutputParameterNames.NEXT_DAY).toString();
			}

			if (StringUtil.isEmpty(nextDay)) {
				result.setSuccess(false);
				result.setErrorCode(ErrorConstant.ERROR_CANNOT_FIND_NEXT_WORKING_DAY);
			} else {
				result.setSuccess(true);
				// yyyyMMdd
				result.setNextWorkingDay(DateUtils.stringToDate4(nextDay));
			}

			return result;

		} catch (BaseException baseException) {
			throw baseException;
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "getNextWorkingDay - Exception:", exception);
			throw new SystemDBException("getNextWorkingDay Failure!", exception);
		}
	}

	/**
	 * 获取上一个工作日
	 * 目前会有一个问题：如果现在系统配置的最早的一个工作日为20160817，而当前传入的currentDate比20160817小，如：
	 * 20160101， 则会永远找不到比currentDate-20160101小的工作日，此方法会无限循环的执行下去
	 *
	 * 解决办法：控制循环次数，即往后推算相减的天数，可以理解为最大的假期天数， 如果超出该天数还找不到，则报错
	 *
	 * @param currentDate
	 * @return
	 */
	@Override
	public WorkingDayResult getLastWorkingDay(Date currentDate) throws BaseException {
		try {

			// 开始时我们假设当前是工作日，
			// 上一天也是工作日，大前天也是工作日，为了调用下一个工作日接口来获取上一个工作日，
			// 我们需要在当前日期减去2天调用下一个工作日接口，来获取当前日期的上一个工作日
			// currentDay - yyyyMMdd
			Date currentDay = DateUtils.stringToDate4(DateUtils.formatDate4(currentDate));
			Date beginDate = DateUtils.addDay(currentDate, -2);
			WorkingDayResult nextResult = getNextWorkingDay(beginDate);
			if (!nextResult.getSuccess()) {
				return nextResult;
			}

			int count = 1;
			// 如果下一个工作日在当前日之后，则需要在往前减1天继续获取下一个工作日，直到找到了即是工作日，又在当前日之前
			// 最多循环15次
			while (!nextResult.getNextWorkingDay().before(currentDay)) {
				// 最多循环15次
				if (count > GlobalConstant.MAX_NON_WORKING_DAY) {
					WorkingDayResult result = new WorkingDayResult();
					result.setSuccess(false);
					result.setErrorCode(ErrorConstant.ERROR_CANNOT_FIND_LAST_WORKING_DAY);
					return result;
				}

				beginDate = DateUtils.addDay(beginDate, -1);
				nextResult = getNextWorkingDay(beginDate);
				if (!nextResult.getSuccess()) {
					return nextResult;
				}

				count = count + 1;
			}

			WorkingDayResult lastResult = new WorkingDayResult();
			lastResult.setSuccess(true);
			lastResult.setLastWorkingDay(nextResult.getNextWorkingDay());
			return lastResult;

		} catch (BaseException baseException) {
			throw baseException;
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "getLastWorkingDay - Exception:", exception);
			throw new SystemDBException("getLastWorkingDay Failure!", exception);
		}
	}

	/**
	 * 判断当前日期是否为工作日
	 *
	 * @param currentDate
	 * @return
	 * @throws BaseException
	 */
	@Override
	public boolean isWorkingDate(Date currentDate) throws BaseException {
		try {
			// 获取上一天
			Date lastDate = DateUtils.addDay(currentDate, -1);
			WorkingDayResult result = getNextWorkingDay(lastDate);
			if(!result.getSuccess()){
				throw new BaseException(result.getErrorCode());
			}
			// 当上一天的下一工作日大于当日时，则表明当日不是工作日
			if (result.getNextWorkingDay().after(currentDate)) {
				return false;
			}

			return true;
		} catch (BaseException baseException) {
			throw baseException;
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "isWorkingDate - Exception:", exception);
			throw new SystemDBException("isWorkingDate Failure!", exception);
		}
	}

    /**
     * 获取当前工作日
     * @param currentDate
     * @return
     * @throws BaseException
     */
    @Override
    public Date getWorkingDay(Date currentDate) throws BaseException {
	    WorkingDayResult result=getWorkingDays(currentDate);
	    if(!result.getSuccess()){
	        throw new BaseException(result.getErrorCode(),result.getErrorMessage(),GlobalConstant.ERROR_TYPE_APPLICATION);
        }

        List<Date> dates=result.getWorkingDates();
        int size=dates.size();
        if(size==0){
            throw new BaseException(ErrorConstant.ERROR_WORKING_DATE_NO_FIND,"", GlobalConstant.ERROR_TYPE_APPLICATION);
        }

        // 获取最后一个
        return dates.get(size - 1);
    }

	/**
	 * 获取工作日, 如果是周末，则会是头尾的2天，比如当前日是周六，非工作日，则此方法会返回周六，下周一
	 *
	 * @param currentDate
	 * @return
	 * @throws BaseException
	 */
	@Override
	public WorkingDayResult getWorkingDays(Date currentDate) throws BaseException {
		try {

			List<Date> dates = new ArrayList<>();
			boolean isWorkingDate = isWorkingDate(currentDate);
			if (isWorkingDate) {
				dates.add(currentDate);
			} else {
				WorkingDayResult lastWorkingDayResult = getLastWorkingDay(currentDate);
				if (!lastWorkingDayResult.getSuccess()) {
					return lastWorkingDayResult;
				}
				WorkingDayResult nextWorkingDayRsult = getNextWorkingDay(currentDate);
				if (!nextWorkingDayRsult.getSuccess()) {
					return nextWorkingDayRsult;
				}

				Date lastDay = DateUtils.addDay(lastWorkingDayResult.getLastWorkingDay(), 1);
				dates.add(lastDay);
				dates.add(nextWorkingDayRsult.getNextWorkingDay());
			}

			WorkingDayResult result = new WorkingDayResult();
			result.setSuccess(true);
			result.setWorkingDates(dates);

			return result;

		} catch (BaseException baseException) {
			throw baseException;
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "isWorkingDate - Exception:", exception);
			throw new SystemDBException("isWorkingDate Failure!", exception);
		}
	}

}
