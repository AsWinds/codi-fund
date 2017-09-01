package com.codi.bus.core.service.model;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午4:28:08
 */
public class FundAssetAllocationModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private Date reportDate;
    private int assetTypeCode;
    private String assetType;
    private BigDecimal marketValue;
    private String ratioInNV; // 净值比例

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(int assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
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
}
