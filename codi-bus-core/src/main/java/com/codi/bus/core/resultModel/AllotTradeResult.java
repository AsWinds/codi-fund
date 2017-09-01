package com.codi.bus.core.resultModel;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.util.DateUtils;
import com.codi.base.util.MoneyUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;

public class AllotTradeResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	// 申请编号
	private String allotNo;

	public String getAllotNo() {
		return this.allotNo;
	}

	public void setAllotNo(String allotNo) {
		this.allotNo = allotNo;
	}

	// 发生金额
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	// 申购金额字符串
    public String getBalanceString(){
    	return MoneyUtils.formatMoney(balance, 2);
    }

	// 清算日期
	private String clearDate;

	public String getClearDate() {
		return this.clearDate;
	}

	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}

	// 申请时间
	private String applyTime;

	public String getApplyTime() {
		if (!StringUtil.isEmpty(applyTime)) {
			Date date = DateUtils.stringToDate(applyTime, GlobalConstant.DATE_FORMAT_HHMMSS);
			return DateUtils.dateToTime(date);
		}
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	// 申请日期
	private String applyDate;

	public String getApplyDate() {
		if (!StringUtil.isEmpty(applyDate)) {
			Date date = DateUtils.stringToDate(applyDate, GlobalConstant.DATE_FORMAT_YYYYMMDD);
			return DateUtils.dateToSimpleStr(date);
		}
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	// 下单日期
	private String orderDate;

	public String getOrderDate() {		
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	// 下单时间
	private String orderTime;

	public String getOrderTime() {		
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
}
