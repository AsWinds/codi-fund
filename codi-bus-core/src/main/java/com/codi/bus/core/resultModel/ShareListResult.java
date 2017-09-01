package com.codi.bus.core.resultModel;

import java.math.BigDecimal;
import java.util.List;

import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.MoneyUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.core.service.model.ShareModel;

public class ShareListResult extends BaseListResult {
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

	// 总持仓收益格式化字符串
	public String getTotalAccumIncomeString() {
		return MoneyUtils.formatMoney(this.totalAccumIncome, 2);
	}

	// 总本金
	private BigDecimal totalFundBalance;

	public void setTotalFundBalance(BigDecimal totalFundBalance) {
		this.totalFundBalance = totalFundBalance;
	}

	public BigDecimal getTotalFundBalance() {
		return this.totalFundBalance;
	}

	// 总本金格式化字符串
	public String getTotalFundBalanceString() {
		return MoneyUtils.formatMoney(this.totalFundBalance, 2);
	}

	// 总资产
	private BigDecimal totalWorthValue;

	public void setTotalWorthValue(BigDecimal totalWorthValue) {
		this.totalWorthValue = totalWorthValue;
	}

	public BigDecimal getTotalWorthValue() {
		return this.totalWorthValue;
	}

	// 总资产格式化字符串
	// 每个份额所显示的资产累加, 避免精度问题
	public String getTotalWorthValueString() {
		return getTotalWorthValueString(shares);
	}

	// 总当日收益
	private BigDecimal totalTodayIncome;

	public void setTotalTodayIncome(BigDecimal totalTodayIncome) {
		this.totalTodayIncome = totalTodayIncome;
	}

	public BigDecimal getTotalTodayIncome() {
		return this.totalTodayIncome;
	}

	// 总当日收益格式化字符串
	// 每个份额所显示的当日收益累加, 避免精度问题
	public String getTotalTodayIncomeString() {
		return getTotalTodayIncomeString(shares);
	}

	/**
	 * 获取总的当日收益，用每个份额所显示的当日收益累加，避免精度显示问题 e.g. fund-1: 662.25 fund-2: -24.92
	 * 但总的却是637.34(637.337), 所以界面显示时需要使用662.25+(-24.92)
	 * 
	 * @param shares
	 * @return
	 */
	private String getTotalTodayIncomeString(List<ShareModel> shares) {
		BigDecimal total = new BigDecimal(0);
		if (shares != null) {
			for (ShareModel shareModel : shares) {
				if (!StringUtil.isEmpty(shareModel.getTodayIncomeString())) {
					total = MoneyUtils.add(total, BigDecimalUtil
							.ConvertToBigDecimal(MoneyUtils.unformatMoney(shareModel.getTodayIncomeString())));
				}
			}
		}

		return MoneyUtils.formatMoney(total);
	}

	/**
	 * 获取总资产
	 * 
	 * @param shares
	 * @return
	 */
	private String getTotalWorthValueString(List<ShareModel> shares) {
		BigDecimal total = new BigDecimal(0);
		if (shares != null) {
			for (ShareModel shareModel : shares) {
				if (!StringUtil.isEmpty(shareModel.getWorthValueString())) {
					total = MoneyUtils.add(total, BigDecimalUtil
							.ConvertToBigDecimal(MoneyUtils.unformatMoney(shareModel.getWorthValueString())));
				}
			}
		}

		return MoneyUtils.formatMoney(total);
	}

}
