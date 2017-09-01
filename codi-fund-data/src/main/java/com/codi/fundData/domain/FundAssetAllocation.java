package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金资产配置
 * 
 * @author shi.pengyan
 * @date 2016年10月10日 下午1:54:27
 */
public class FundAssetAllocation {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.ID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.InnerCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Integer innerCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.InfoPublDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Date infoPublDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.ReportDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Date reportDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.AssetType
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private String assetType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.MarketValue
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private BigDecimal marketValue;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.RatioInTotalAsset
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private BigDecimal ratioInTotalAsset;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.RatioInNV
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private BigDecimal ratioInNV;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Date XGRQ;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.JSID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_AssetAllocation.AssetTypeCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    private Integer assetTypeCode;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.ID
     *
     * @return the value of MF_AssetAllocation.ID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.ID
     *
     * @param ID
     *            the value for MF_AssetAllocation.ID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.InnerCode
     *
     * @return the value of MF_AssetAllocation.InnerCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Integer getInnerCode() {
        return innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.InnerCode
     *
     * @param innerCode
     *            the value for MF_AssetAllocation.InnerCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.InfoPublDate
     *
     * @return the value of MF_AssetAllocation.InfoPublDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Date getInfoPublDate() {
        return infoPublDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.InfoPublDate
     *
     * @param infoPublDate
     *            the value for MF_AssetAllocation.InfoPublDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setInfoPublDate(Date infoPublDate) {
        this.infoPublDate = infoPublDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.ReportDate
     *
     * @return the value of MF_AssetAllocation.ReportDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.ReportDate
     *
     * @param reportDate
     *            the value for MF_AssetAllocation.ReportDate
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.AssetType
     *
     * @return the value of MF_AssetAllocation.AssetType
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public String getAssetType() {
        return assetType;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.AssetType
     *
     * @param assetType
     *            the value for MF_AssetAllocation.AssetType
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.MarketValue
     *
     * @return the value of MF_AssetAllocation.MarketValue
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public BigDecimal getMarketValue() {
        return marketValue;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.MarketValue
     *
     * @param marketValue
     *            the value for MF_AssetAllocation.MarketValue
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.RatioInTotalAsset
     *
     * @return the value of MF_AssetAllocation.RatioInTotalAsset
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public BigDecimal getRatioInTotalAsset() {
        return ratioInTotalAsset;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.RatioInTotalAsset
     *
     * @param ratioInTotalAsset
     *            the value for MF_AssetAllocation.RatioInTotalAsset
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setRatioInTotalAsset(BigDecimal ratioInTotalAsset) {
        this.ratioInTotalAsset = ratioInTotalAsset;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.RatioInNV
     *
     * @return the value of MF_AssetAllocation.RatioInNV
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public BigDecimal getRatioInNV() {
        return ratioInNV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.RatioInNV
     *
     * @param ratioInNV
     *            the value for MF_AssetAllocation.RatioInNV
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setRatioInNV(BigDecimal ratioInNV) {
        this.ratioInNV = ratioInNV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.XGRQ
     *
     * @return the value of MF_AssetAllocation.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Date getXGRQ() {
        return XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.XGRQ
     *
     * @param XGRQ
     *            the value for MF_AssetAllocation.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setXGRQ(Date XGRQ) {
        this.XGRQ = XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.JSID
     *
     * @return the value of MF_AssetAllocation.JSID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.JSID
     *
     * @param JSID
     *            the value for MF_AssetAllocation.JSID
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_AssetAllocation.AssetTypeCode
     *
     * @return the value of MF_AssetAllocation.AssetTypeCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public Integer getAssetTypeCode() {
        return assetTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_AssetAllocation.AssetTypeCode
     *
     * @param assetTypeCode
     *            the value for MF_AssetAllocation.AssetTypeCode
     *
     * @mbggenerated Mon Oct 10 13:54:04 CST 2016
     */
    public void setAssetTypeCode(Integer assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }
}