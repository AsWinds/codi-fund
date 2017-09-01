package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金投资组合
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 上午11:05:57
 */
public class FundPortifolio extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private Date reportDate;
    private int serialNumber;
    private BigDecimal holdVolume;
    private BigDecimal marketValue;
    private String ratioInNV;
    private String InnerCode;// 有可能是字符串
    private String chiName;
    private String fundName;
    private String fundNameAbbr;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getHoldVolume() {
        return holdVolume;
    }

    public void setHoldVolume(BigDecimal holdVolume) {
        this.holdVolume = holdVolume;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getRatioInNV() {
        return ratioInNV;
    }

    public void setRatioInNV(String ratioInNV) {
        this.ratioInNV = ratioInNV;
    }

    public String getInnerCode() {
        return InnerCode;
    }

    public void setInnerCode(String innerCode) {
        InnerCode = innerCode;
    }

    public String getChiName() {
        return chiName;
    }

    public void setChiName(String chiName) {
        this.chiName = chiName;
    }

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
}
