package com.codi.bus.core.service.model;

import java.math.BigDecimal;

public class BankLimitModel {
	private String bankName;

	private String bankCode;

	private BigDecimal singleTradeLimit;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode == null ? null : bankCode.trim();
	}

	/**
	 * 单笔限额
	 * 
	 * @return
	 */
	public BigDecimal getSingleTradeLimit() {
		return singleTradeLimit;
	}

	public void setSingleTradeLimit(BigDecimal singleTradeLimit) {
		this.singleTradeLimit = singleTradeLimit;
	}
}
