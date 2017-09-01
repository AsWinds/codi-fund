package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金净值最新表现，不包括货币基金
 * 
 * @author shi.pengyan
 * @date 2016年9月23日 下午1:32:26
 */
public class FundNetValuePerformance extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.ID
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.InnerCode
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private Integer InnerCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.TradingDay
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private Date TradingDay;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.UnitNV
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal UnitNV;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSelectedWeek
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSelectedWeek;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSingleWeek
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSingleWeek;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSelectedMonth
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSelectedMonth;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSingleMonth
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSingleMonth;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInThreeMonth
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInThreeMonth;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSixMonth
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSixMonth;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRSinceThisYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRSinceThisYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInSingleYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInSingleYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInTwoYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInTwoYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.AnnualizedRRInTwoYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal AnnualizedRRInTwoYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInThreeYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInThreeYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.AnnualizedRRInThreeYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal AnnualizedRRInThreeYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInFiveYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInFiveYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.AnnualizedRRInFiveYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal AnnualizedRRInFiveYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRInTenYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRInTenYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.AnnualizedRRInTenYear
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal AnnualizedRRInTenYear;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.RRSinceStart
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal RRSinceStart;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.AnnualizedRRSinceStart
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal AnnualizedRRSinceStart;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.UpdateTime
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private Date UpdateTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.JSID
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_NetValuePerformance.NVDailyGrowthRate
     *
     * @mbggenerated Fri Sep 23 13:29:22 CST 2016
     */
    private BigDecimal NVDailyGrowthRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInnerCode() {
        return InnerCode;
    }

    public void setInnerCode(Integer innerCode) {
        InnerCode = innerCode;
    }

    public Date getTradingDay() {
        return TradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        TradingDay = tradingDay;
    }

    public BigDecimal getUnitNV() {
        return UnitNV;
    }

    public void setUnitNV(BigDecimal unitNV) {
        UnitNV = unitNV;
    }

    public BigDecimal getRRInSelectedWeek() {
        return RRInSelectedWeek;
    }

    public void setRRInSelectedWeek(BigDecimal rRInSelectedWeek) {
        RRInSelectedWeek = rRInSelectedWeek;
    }

    public BigDecimal getRRInSingleWeek() {
        return RRInSingleWeek;
    }

    public void setRRInSingleWeek(BigDecimal rRInSingleWeek) {
        RRInSingleWeek = rRInSingleWeek;
    }

    public BigDecimal getRRInSelectedMonth() {
        return RRInSelectedMonth;
    }

    public void setRRInSelectedMonth(BigDecimal rRInSelectedMonth) {
        RRInSelectedMonth = rRInSelectedMonth;
    }

    public BigDecimal getRRInSingleMonth() {
        return RRInSingleMonth;
    }

    public void setRRInSingleMonth(BigDecimal rRInSingleMonth) {
        RRInSingleMonth = rRInSingleMonth;
    }

    public BigDecimal getRRInThreeMonth() {
        return RRInThreeMonth;
    }

    public void setRRInThreeMonth(BigDecimal rRInThreeMonth) {
        RRInThreeMonth = rRInThreeMonth;
    }

    public BigDecimal getRRInSixMonth() {
        return RRInSixMonth;
    }

    public void setRRInSixMonth(BigDecimal rRInSixMonth) {
        RRInSixMonth = rRInSixMonth;
    }

    public BigDecimal getRRSinceThisYear() {
        return RRSinceThisYear;
    }

    public void setRRSinceThisYear(BigDecimal rRSinceThisYear) {
        RRSinceThisYear = rRSinceThisYear;
    }

    public BigDecimal getRRInSingleYear() {
        return RRInSingleYear;
    }

    public void setRRInSingleYear(BigDecimal rRInSingleYear) {
        RRInSingleYear = rRInSingleYear;
    }

    public BigDecimal getRRInTwoYear() {
        return RRInTwoYear;
    }

    public void setRRInTwoYear(BigDecimal rRInTwoYear) {
        RRInTwoYear = rRInTwoYear;
    }

    public BigDecimal getAnnualizedRRInTwoYear() {
        return AnnualizedRRInTwoYear;
    }

    public void setAnnualizedRRInTwoYear(BigDecimal annualizedRRInTwoYear) {
        AnnualizedRRInTwoYear = annualizedRRInTwoYear;
    }

    public BigDecimal getRRInThreeYear() {
        return RRInThreeYear;
    }

    public void setRRInThreeYear(BigDecimal rRInThreeYear) {
        RRInThreeYear = rRInThreeYear;
    }

    public BigDecimal getAnnualizedRRInThreeYear() {
        return AnnualizedRRInThreeYear;
    }

    public void setAnnualizedRRInThreeYear(BigDecimal annualizedRRInThreeYear) {
        AnnualizedRRInThreeYear = annualizedRRInThreeYear;
    }

    public BigDecimal getRRInFiveYear() {
        return RRInFiveYear;
    }

    public void setRRInFiveYear(BigDecimal rRInFiveYear) {
        RRInFiveYear = rRInFiveYear;
    }

    public BigDecimal getAnnualizedRRInFiveYear() {
        return AnnualizedRRInFiveYear;
    }

    public void setAnnualizedRRInFiveYear(BigDecimal annualizedRRInFiveYear) {
        AnnualizedRRInFiveYear = annualizedRRInFiveYear;
    }

    public BigDecimal getRRInTenYear() {
        return RRInTenYear;
    }

    public void setRRInTenYear(BigDecimal rRInTenYear) {
        RRInTenYear = rRInTenYear;
    }

    public BigDecimal getAnnualizedRRInTenYear() {
        return AnnualizedRRInTenYear;
    }

    public void setAnnualizedRRInTenYear(BigDecimal annualizedRRInTenYear) {
        AnnualizedRRInTenYear = annualizedRRInTenYear;
    }

    public BigDecimal getRRSinceStart() {
        return RRSinceStart;
    }

    public void setRRSinceStart(BigDecimal rRSinceStart) {
        RRSinceStart = rRSinceStart;
    }

    public BigDecimal getAnnualizedRRSinceStart() {
        return AnnualizedRRSinceStart;
    }

    public void setAnnualizedRRSinceStart(BigDecimal annualizedRRSinceStart) {
        AnnualizedRRSinceStart = annualizedRRSinceStart;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public Long getJSID() {
        return JSID;
    }

    public void setJSID(Long jSID) {
        JSID = jSID;
    }

    public BigDecimal getNVDailyGrowthRate() {
        return NVDailyGrowthRate;
    }

    public void setNVDailyGrowthRate(BigDecimal nVDailyGrowthRate) {
        NVDailyGrowthRate = nVDailyGrowthRate;
    }

}