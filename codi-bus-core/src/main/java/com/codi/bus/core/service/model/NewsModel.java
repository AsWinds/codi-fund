package com.codi.bus.core.service.model;

import com.codi.bus.constant.GlobalConstant;

import java.math.BigDecimal;

public class NewsModel {

	// 基金风险等级
	private Integer riskLevel;

	public Integer getRiskLevel() {
		return this.riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	// 基金风险等级描述
	public String getRiskLevelString() {
		if (riskLevel == GlobalConstant.RISK_LEVEL_LOW) {
			return GlobalConstant.RISK_LEVEL_LOW_STRING;
		}
        if (riskLevel == GlobalConstant.RISK_LEVEL_MIDDLE_LOW) {
            return GlobalConstant.RISK_LEVEL_MIDDLE_LOW_STRING;
        }
		if (riskLevel == GlobalConstant.RISK_LEVEL_MEDIUM) {
			return GlobalConstant.RISK_LEVEL_MEDIUM_STRING;
		}
        if (riskLevel == GlobalConstant.RISK_LEVEL_MEDIUM_HIGH) {
            return GlobalConstant.RISK_LEVEL_MEDIUM_HIGH_STRING;
        }
		if (riskLevel == GlobalConstant.RISK_LEVEL_HIGH) {
			return GlobalConstant.RISK_LEVEL_HIGH_STRING;
		}

		return "";
	}

	// 最低持有份额
	private BigDecimal minShare;

	public BigDecimal getMinShare() {
		return this.minShare;
	}

	public void setMinShare(BigDecimal minShare) {
		this.minShare = minShare;
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
