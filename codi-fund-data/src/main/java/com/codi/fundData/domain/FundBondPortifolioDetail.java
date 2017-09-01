package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金债券组合明细</br> 记录基金债券组合中占净值前5名债券及处于转股期的可转换债券明细
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:20:57
 */
public class FundBondPortifolioDetail extends BaseDomain {
    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.ID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.InnerCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Integer innerCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.ReportDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Date reportDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.SerialNumber
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Integer serialNumber;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.BondCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Integer bondCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.HoldVolume
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private BigDecimal holdVolume;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.MarketValue
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private BigDecimal marketValue;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.RatioInNV
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private BigDecimal ratioInNV;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.IfInConvertibleTerm
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Byte ifInConvertibleTerm;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.XGRQ
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Date XGRQ;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.JSID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_BondPortifolioDetail.InfoPublDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    private Date infoPublDate;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.ID
     *
     * @return the value of MF_BondPortifolioDetail.ID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.ID
     *
     * @param ID
     *            the value for MF_BondPortifolioDetail.ID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.InnerCode
     *
     * @return the value of MF_BondPortifolioDetail.InnerCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Integer getInnerCode() {
        return innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.InnerCode
     *
     * @param innerCode
     *            the value for MF_BondPortifolioDetail.InnerCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.ReportDate
     *
     * @return the value of MF_BondPortifolioDetail.ReportDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.ReportDate
     *
     * @param reportDate
     *            the value for MF_BondPortifolioDetail.ReportDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.SerialNumber
     *
     * @return the value of MF_BondPortifolioDetail.SerialNumber
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Integer getSerialNumber() {
        return serialNumber;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.SerialNumber
     *
     * @param serialNumber
     *            the value for MF_BondPortifolioDetail.SerialNumber
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.BondCode
     *
     * @return the value of MF_BondPortifolioDetail.BondCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Integer getBondCode() {
        return bondCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.BondCode
     *
     * @param bondCode
     *            the value for MF_BondPortifolioDetail.BondCode
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setBondCode(Integer bondCode) {
        this.bondCode = bondCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.HoldVolume
     *
     * @return the value of MF_BondPortifolioDetail.HoldVolume
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public BigDecimal getHoldVolume() {
        return holdVolume;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.HoldVolume
     *
     * @param holdVolume
     *            the value for MF_BondPortifolioDetail.HoldVolume
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setHoldVolume(BigDecimal holdVolume) {
        this.holdVolume = holdVolume;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.MarketValue
     *
     * @return the value of MF_BondPortifolioDetail.MarketValue
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public BigDecimal getMarketValue() {
        return marketValue;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.MarketValue
     *
     * @param marketValue
     *            the value for MF_BondPortifolioDetail.MarketValue
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.RatioInNV
     *
     * @return the value of MF_BondPortifolioDetail.RatioInNV
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public BigDecimal getRatioInNV() {
        return ratioInNV;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.RatioInNV
     *
     * @param ratioInNV
     *            the value for MF_BondPortifolioDetail.RatioInNV
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setRatioInNV(BigDecimal ratioInNV) {
        this.ratioInNV = ratioInNV;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.IfInConvertibleTerm
     *
     * @return the value of MF_BondPortifolioDetail.IfInConvertibleTerm
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Byte getIfInConvertibleTerm() {
        return ifInConvertibleTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.IfInConvertibleTerm
     *
     * @param ifInConvertibleTerm
     *            the value for MF_BondPortifolioDetail.IfInConvertibleTerm
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setIfInConvertibleTerm(Byte ifInConvertibleTerm) {
        this.ifInConvertibleTerm = ifInConvertibleTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.XGRQ
     *
     * @return the value of MF_BondPortifolioDetail.XGRQ
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Date getXGRQ() {
        return XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.XGRQ
     *
     * @param XGRQ
     *            the value for MF_BondPortifolioDetail.XGRQ
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setXGRQ(Date XGRQ) {
        this.XGRQ = XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.JSID
     *
     * @return the value of MF_BondPortifolioDetail.JSID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.JSID
     *
     * @param JSID
     *            the value for MF_BondPortifolioDetail.JSID
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_BondPortifolioDetail.InfoPublDate
     *
     * @return the value of MF_BondPortifolioDetail.InfoPublDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public Date getInfoPublDate() {
        return infoPublDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_BondPortifolioDetail.InfoPublDate
     *
     * @param infoPublDate
     *            the value for MF_BondPortifolioDetail.InfoPublDate
     *
     * @mbggenerated Mon Oct 24 17:20:23 CST 2016
     */
    public void setInfoPublDate(Date infoPublDate) {
        this.infoPublDate = infoPublDate;
    }
}