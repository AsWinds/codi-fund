package com.codi.bus.core.resultModel;

import java.math.BigDecimal;

import com.codi.base.util.MoneyUtils;

/*
 * Author : wangzhenhao
 * Date : 2016/12/09
 */
public class CashChangeResult extends BaseResult {

	private static final long serialVersionUID = 1L;

	// 基金代码
	private String fundCode;

	// 基金名称
	private String fundName;

	// 银行名称
	private String bankName;

	// 银行卡号
	private String bankAccount;

	// 可用份额
	private BigDecimal enableShare;

	// 交易账号
	private String tradeAccount;

	// 资金方式
	private String capitalMode;

	
	// 最低持有份额
	private BigDecimal minHoldShares;

	// 最低赎回份额
	private BigDecimal minValue;

	/**
	 * 快速赎回
	 */
	// 每人每天最高提现金额
	private BigDecimal maxValueForFastSell;

	/**
	 * 普通赎回
	 */
	// 每人每天最高提现金额
	private BigDecimal maxValueForSell;

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	public String getCapitalMode() {
		return capitalMode;
	}

	public void setCapitalMode(String capitalMode) {
		this.capitalMode = capitalMode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	public BigDecimal getMinHoldShares() {
		return minHoldShares;
	}

	public void setMinHoldShares(BigDecimal minHoldShares) {
		this.minHoldShares = minHoldShares;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	/**
	 * 快速赎回
	 * 
	 */
	public BigDecimal getMaxValueForFastSell() {
		return maxValueForFastSell;
	}

	public void setMaxValueForFastSell(BigDecimal maxValueForFastSell) {
		this.maxValueForFastSell = maxValueForFastSell;
	}
	
	/**
	 * 普通赎回
	 */
	public BigDecimal getMaxValueForSell() {
		return maxValueForSell;
	}

	public void setMaxValueForSell(BigDecimal maxValueForSell) {
		this.maxValueForSell = maxValueForSell;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public BigDecimal getEnableShare() {
		return enableShare;
	}

	public void setEnableShare(BigDecimal enableShare) {
		this.enableShare = enableShare;
	}

	// 可用份额字符串
	public String getEnableSharesString() {
		return MoneyUtils.formatMoney(enableShare, 2);
	}
}
