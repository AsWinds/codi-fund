package com.codi.bus.core.service.model;

import java.math.BigDecimal;

public class TradeLimitModel {
	// 基金代码
	private String fundCode;

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundCode() {
		return this.fundCode;
	}

	// 业务代码
	private String fundBusinCode;

	public String getFundBusinCode() {
		return this.fundBusinCode;
	}

	public void setFundBusinCode(String fundBusinCode) {
		this.fundBusinCode = fundBusinCode;
	}

	// 总记录数
	private Long totalCount;

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalCount() {
		return this.totalCount;
	}

	// 记录数
	private Long rowCount;

	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}

	public Long getRowCount() {
		return this.rowCount;
	}

	// 份额类别
	private String shareType;

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getShareType() {
		return this.shareType;
	}

	// 最高
	private BigDecimal maxValue;

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMaxValue() {
		return this.maxValue;
	}

	// 追加最低
	private BigDecimal secondMin;

	public void setSecondMin(BigDecimal secondMin) {
		this.secondMin = secondMin;
	}

	public BigDecimal getSecondMin() {
		return this.secondMin;
	}

	// 首次最低
	//最低赎回份额
	private BigDecimal minValue;

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public BigDecimal getMinValue() {
		return this.minValue;
	}

	// 最小持有份额
	private BigDecimal minHoldShares;

	public void setMinHoldShares(BigDecimal minHoldShares) {
		this.minHoldShares = minHoldShares;
	}

	public BigDecimal getMinHoldShares() {
		return this.minHoldShares;
	}
}
