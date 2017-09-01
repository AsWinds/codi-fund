package com.codi.bus.core.service.model;

public class ShareTypeModel {
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

	// 基金代码
	private String fundCode;

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundCode() {
		return this.fundCode;
	}

	// 份额类别
	private String shareType;

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getShareType() {
		return this.shareType;
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

	// 基金类型
	private String fundType;

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getFundType() {
		return this.fundType;
	}

}
