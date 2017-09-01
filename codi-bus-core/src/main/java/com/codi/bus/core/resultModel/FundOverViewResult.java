package com.codi.bus.core.resultModel;

import java.util.Date;

import com.codi.bus.core.resultModel.fund.FundBaseResult;

/**
 * 基金概要
 * 
 * @author shi.pengyan
 * @date 2016年10月10日 下午12:59:00
 */
public class FundOverViewResult extends FundBaseResult {
    private static final long serialVersionUID = 1L;
    private String fundName;
    private String fundNameAbbr;
    private Date establishmentDate; // 成立日期

    private Integer riskLevel;
    private String riskLevelString;

    private String marketValue;// 资产规模
    private String marketValueUnit;// 资产规模单位
    private String foundedSize; // 份额规模
    private String foundedSizeUnit;// 份额规模单位
    private String fundCompany;// 基金公司
    private String fundTrustee;// 托管人
    private String fundManager;// 基金经理

    private String investTarget;// 投资目标
    private String investField;// 投资范围
    private String investOrientation; // 投资方向

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundNameAbbr() {
        return fundNameAbbr;
    }

    public void setFundNameAbbr(String fundNameAbbr) {
        this.fundNameAbbr = fundNameAbbr;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getFoundedSize() {
        return foundedSize;
    }

    public void setFoundedSize(String foundedSize) {
        this.foundedSize = foundedSize;
    }

    public String getFundCompany() {
        return fundCompany;
    }

    public void setFundCompany(String fundCompany) {
        this.fundCompany = fundCompany;
    }

    public String getFundTrustee() {
        return fundTrustee;
    }

    public void setFundTrustee(String fundTrustee) {
        this.fundTrustee = fundTrustee;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getInvestTarget() {
        return investTarget;
    }

    public void setInvestTarget(String investTarget) {
        this.investTarget = investTarget;
    }

    public String getInvestField() {
        return investField;
    }

    public void setInvestField(String investField) {
        this.investField = investField;
    }

    public String getInvestOrientation() {
        return investOrientation;
    }

    public void setInvestOrientation(String investOrientation) {
        this.investOrientation = investOrientation;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevelString() {
        return riskLevelString;
    }

    public void setRiskLevelString(String riskLevelString) {
        this.riskLevelString = riskLevelString;
    }

    public String getMarketValueUnit() {
        return marketValueUnit;
    }

    public void setMarketValueUnit(String marketValueUnit) {
        this.marketValueUnit = marketValueUnit;
    }

    public String getFoundedSizeUnit() {
        return foundedSizeUnit;
    }

    public void setFoundedSizeUnit(String foundedSizeUnit) {
        this.foundedSizeUnit = foundedSizeUnit;
    }

}
