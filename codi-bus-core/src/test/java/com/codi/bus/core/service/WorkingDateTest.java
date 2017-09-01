package com.codi.bus.core.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codi.base.util.DateUtils;
import com.codi.bus.core.BaseTest;
import com.codi.bus.core.resultModel.WorkingDayResult;

public class WorkingDateTest extends BaseTest {
	@Autowired
	private WorkingDateService workingDateService;

	@Test
	public void test() {
		try {

			Date currentDate = DateUtils.addDay(new Date(), -10);
			WorkingDayResult result = workingDateService.getWorkingDays(currentDate);
			if (result.getSuccess()) {
				System.out.println("当前日期：" + DateUtils.dateToString(currentDate));
				List<Date> dates=result.getWorkingDates();
				for (Date date : dates) {
					System.out.println("日期：" + DateUtils.dateToString(date));
				}
			}
			
			System.out.println("-----------------------");
			
			currentDate = DateUtils.addDay(new Date(), -3);
			result = workingDateService.getWorkingDays(currentDate);
			if (result.getSuccess()) {
				System.out.println("当前日期：" + DateUtils.dateToString(currentDate));
				List<Date> dates=result.getWorkingDates();
				for (Date date : dates) {
					System.out.println("日期：" + DateUtils.dateToString(date));
				}
			}
			
			System.out.println("-----------------------");
			
			currentDate = new Date();
			result = workingDateService.getWorkingDays(currentDate);
			if (result.getSuccess()) {
				System.out.println("当前日期：" + DateUtils.dateToString(currentDate));
				List<Date> dates=result.getWorkingDates();
				for (Date date : dates) {
					System.out.println("日期：" + DateUtils.dateToString(date));
				}
			}

			/*
			 * Date currentDate = DateUtils.addDay(new Date(), -3);
			 * WorkingDayResult result =
			 * workingDateService.getNextWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 下一个工作日：" +
			 * result.getNextWorkingDay()); }
			 * 
			 * result = workingDateService.getLastWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 上一个工作日：" +
			 * result.getLastWorkingDay()); }
			 * 
			 * currentDate = DateUtils.addDay(new Date(), -4); result =
			 * workingDateService.getNextWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 下一个工作日：" +
			 * result.getNextWorkingDay()); }
			 * 
			 * result = workingDateService.getLastWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 上一个工作日：" +
			 * result.getLastWorkingDay()); }
			 * 
			 * currentDate = DateUtils.addDay(new Date(), -5); result =
			 * workingDateService.getNextWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 下一个工作日：" +
			 * result.getNextWorkingDay()); }
			 * 
			 * result = workingDateService.getLastWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 上一个工作日：" +
			 * result.getLastWorkingDay()); }
			 * 
			 * currentDate =
			 * DateUtils.addDay(DateUtils.stringToDate4("20160101"), -5); result
			 * = workingDateService.getNextWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 下一个工作日：" +
			 * result.getNextWorkingDay()); }
			 * 
			 * result = workingDateService.getLastWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 上一个工作日：" +
			 * result.getLastWorkingDay()); } else { System.out.println( "当前日期："
			 * + DateUtils.dateToString(currentDate) + ", ErrorCode：" +
			 * result.getErrorCode()); }
			 * 
			 * currentDate =
			 * DateUtils.addDay(DateUtils.stringToDate4("20180101"), -5); result
			 * = workingDateService.getNextWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 下一个工作日：" +
			 * result.getNextWorkingDay()); } else { System.out.println( "当前日期："
			 * + DateUtils.dateToString(currentDate) + ", ErrorCode：" +
			 * result.getErrorCode()); }
			 * 
			 * result = workingDateService.getLastWorkingDay(currentDate); if
			 * (result.getSuccess()) { System.out.println( "当前日期：" +
			 * DateUtils.dateToString(currentDate) + ", 上一个工作日：" +
			 * result.getLastWorkingDay()); } else { System.out.println( "当前日期："
			 * + DateUtils.dateToString(currentDate) + ", ErrorCode：" +
			 * result.getErrorCode()); }
			 */
		} catch (Exception exception) {

		}
	}
}
