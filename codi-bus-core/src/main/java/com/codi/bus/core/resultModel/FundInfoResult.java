/**
 *
 */
package com.codi.bus.core.resultModel;

/**
 * @author song-jj
 *
 */
public class FundInfoResult {

    private Long fundId;

    private String fundCode;

    private String fundName;

    private String shortName;

    private String fundStatus;

    private String taNo;

    /**
	 * 基金类型代码
	 */
    private String fundType;

    private Integer appFundType;

    private Integer totalCount;

    private Integer rowCount;

    private String eContractFlag;

    /**
	 * 基金类型名称
	 */
	private String fundTypeName;

	private Integer riskLevel;

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Long getFundId() {
		return fundId;
	}

	public void setFundId(Long fundId) {
		this.fundId = fundId;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFundStatus() {
		return fundStatus;
	}

	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}

	public String getTaNo() {
		return taNo;
	}

	public void setTaNo(String taNo) {
		this.taNo = taNo;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public String geteContractFlag() {
		return eContractFlag;
	}

	public void seteContractFlag(String eContractFlag) {
		this.eContractFlag = eContractFlag;
	}

	public String getFundTypeName() {
		return fundTypeName;
	}

	public void setFundTypeName(String fundTypeName) {
		this.fundTypeName = fundTypeName;
	}

	public Integer getAppFundType() {
		return appFundType;
	}

	public void setAppFundType(Integer appFundType) {
		this.appFundType = appFundType;
	}

}
