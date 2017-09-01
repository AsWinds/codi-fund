package com.codi.bus.core.resultModel;

import java.math.BigDecimal;
import java.util.List;

import com.codi.bus.core.service.model.ShareModel;

public class ShareResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private List<ShareModel> shares;

	public void setShares(List<ShareModel> shares) {
		this.shares = shares;
	}

	public List<ShareModel> getShares() {
		return this.shares;
	}

	// 总持仓收益
	private BigDecimal totalAccumIncome;

	public void setTotalAccumIncome(BigDecimal totalAccumIncome) {
		this.totalAccumIncome = totalAccumIncome;
	}

	public BigDecimal getTotalAccumIncome() {
		return this.totalAccumIncome;
	}

	// 总本金
	private BigDecimal totalFundBalance;

	public void setTotalFundBalance(BigDecimal totalFundBalance) {
		this.totalFundBalance = totalFundBalance;
	}

	public BigDecimal getTotalFundBalance() {
		return this.totalFundBalance;
	}

	// 总资产
	private BigDecimal totalWorthValue;

	public void setTotalWorthValue(BigDecimal totalWorthValue) {
		this.totalWorthValue = totalWorthValue;
	}

	public BigDecimal getTotalWorthValue() {
		return this.totalWorthValue;
	}

	// 总当日收益
	private BigDecimal totalTodayIncome;

	public void setTotalTodayIncome(BigDecimal totalTodayIncome) {
		this.totalTodayIncome = totalTodayIncome;
	}

	public BigDecimal getTotalTodayIncome() {
		return this.totalTodayIncome;
	}

}
