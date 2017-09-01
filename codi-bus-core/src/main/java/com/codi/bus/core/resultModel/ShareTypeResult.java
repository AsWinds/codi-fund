package com.codi.bus.core.resultModel;

public class ShareTypeResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
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
}
