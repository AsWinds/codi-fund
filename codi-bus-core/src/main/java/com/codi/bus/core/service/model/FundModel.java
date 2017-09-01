package com.codi.bus.core.service.model;

import com.codi.base.util.BigDecimalUtil;
import com.codi.bus.constant.GlobalConstant;

import java.math.BigDecimal;

public class FundModel {
	// 基金代码
	private String fundCode;

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundCode() {
		return this.fundCode;
	}

	// 基金名称
	private String fundName;

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundName() {
		return this.fundName;
	}

	// 基金状态
	private String fundStatus;

	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}

	public String getFundStatus() {
		return this.fundStatus;
	}

	// 能申购：正常开放，停止赎回，权益登记，红利发放
	public boolean getCanBuy() {
		if (fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_OPEN)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_STOP_SELL)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_GAIN_REGISTER)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_DIVIDEND_OFFER)) {
			return true;
		}

		return false;
	}

	// 能赎回：正常开放，停止申购，权益登记，红利发放
	public boolean getCanSell() {
		if (fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_OPEN)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_STOP_BUY)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_GAIN_REGISTER)
				|| fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_DIVIDEND_OFFER)) {
			return true;
		}

		return false;
	}

	// 能认购：认购时期
	public boolean getCanSubscribe() {
		if (fundStatus.equals(GlobalConstant.FUND_BASE_STATUS_SUBSCRIBE)) {
			return true;
		}

		return false;
	}

	// TA编号
	private String taNo;

	public void setTANo(String taNo) {
		this.taNo = taNo;
	}

	public String getTANo() {
		return this.taNo;
	}

	// 基金类型
	private String fundType;

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getFundType() {
		return this.fundType;
	}

	// 前端基金类型
	private int appFundType;

	public void setAppFundType(int appFundType) {
		this.appFundType = appFundType;
	}

	public int getAppFundType() {
		return this.appFundType;
	}

	// 近三月收益率
	private BigDecimal threeMonthRate;

	public void setThreeMonthRate(BigDecimal threeMonthRate) {
		this.threeMonthRate = threeMonthRate;
	}

	public BigDecimal getThreeMonthRate() {
		return this.threeMonthRate;
	}

	// 近三月收益率字符串
	public String getThreeMonthRateString() {
		return BigDecimalUtil.ConvertToString(this.threeMonthRate) + "%";
	}

	// 7日年化收益率
	private BigDecimal latestWeeklyYield;

	public BigDecimal getLatestWeeklyYield() {
		return this.latestWeeklyYield;
	}

	public void setLatestWeeklyYield(BigDecimal latestWeeklyYield) {
		this.latestWeeklyYield = latestWeeklyYield;
	}

	// 7日年化收益率字符串
	public String getLatestWeeklyYieldString() {
		return BigDecimalUtil.ConvertToString(this.latestWeeklyYield) + "%";
	}

	// 是否是T0
	private boolean isT0;

	/**
	 * 是否为T0基金
	 *
	 * @return
	 */
	public boolean getIsT0() {
		return this.isT0;
	}

	public void setIsT0(boolean isT0) {
		this.isT0 = isT0;
	}

    // 基金风险等级
    private Integer riskLevel;

    public Integer getRiskLevel() {
        return this.riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

	/*
	 * // 基金风险等级 - 该字段已废弃，不能用此方式来计算， public Integer getRiskLevel() { if
	 * (this.fundType.trim().equals(GlobalConstant.FUND_TYPE_CURRENCY) ||
	 * this.fundType.trim().equals(GlobalConstant.FUND_TYPE_BREAK_EVEN)) {
	 * return GlobalConstant.RISK_LEVEL_LOW; }
	 *
	 * if (this.fundType.trim().equals(GlobalConstant.FUND_TYPE_BOND)) { return
	 * GlobalConstant.RISK_LEVEL_MEDIUM; }
	 *
	 * if (this.fundType.trim().equals(GlobalConstant.FUND_TYPE_HYBRID) ||
	 * this.fundType.trim().equals(GlobalConstant.FUND_TYPE_STOCK) ||
	 * this.fundType.trim().equals(GlobalConstant.FUND_TYPE_INDEX)) { return
	 * GlobalConstant.RISK_LEVEL_HIGH; }
	 *
	 * // 如果没找到，则默认为低风险 return GlobalConstant.RISK_LEVEL_LOW; }
	 */

}
