package com.codi.bus.core.resultModel;

import com.codi.bus.core.resultModel.fund.FundBaseResult;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金表现（统计信息）
 *
 * @author shi.pengyan
 * @date 2016年9月25日 上午11:28:17
 */
public class FundPerformanceResult extends FundBaseResult {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String fundCode;

    private String chiName;
    private String chiNameAbbr;
    private String secuAbbr;
    private Date tradingDay; // 交易日

    private BigDecimal LatestWeeklyYield; // 最近7日周算

    private BigDecimal RRInSingleWeek; // 一周回报率
    // private BigDecimal RRInSelectedMonth;// 本月以来回报率
    private BigDecimal RRInSingleMonth;// 一个月回报率
    private BigDecimal RRInThreeMonth;// 三个月回报率
    private BigDecimal RRInSixMonth;// 六个月回报率
    private BigDecimal RRSinceThisYear;// 今年以来回报率
    private BigDecimal RRInSingleYear;// 一年回报率
    private BigDecimal RRSinceStart;// 设立以来回报率（%）

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getChiName() {
        return chiName;
    }

    public void setChiName(String chiName) {
        this.chiName = chiName;
    }

    public String getChiNameAbbr() {
        return chiNameAbbr;
    }

    public void setChiNameAbbr(String chiNameAbbr) {
        this.chiNameAbbr = chiNameAbbr;
    }

    public String getSecuAbbr() {
        return secuAbbr;
    }

    public void setSecuAbbr(String secuAbbr) {
        this.secuAbbr = secuAbbr;
    }

    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public BigDecimal getRRInSingleWeek() {
        return RRInSingleWeek;
    }

    public void setRRInSingleWeek(BigDecimal rRInSingleWeek) {
        RRInSingleWeek = rRInSingleWeek;
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

    public BigDecimal getRRSinceStart() {
        return RRSinceStart;
    }

    public void setRRSinceStart(BigDecimal rRSinceStart) {
        RRSinceStart = rRSinceStart;
    }

    public BigDecimal getLatestWeeklyYield() {
        return LatestWeeklyYield;
    }

    public void setLatestWeeklyYield(BigDecimal latestWeeklyYield) {
        LatestWeeklyYield = latestWeeklyYield;
    }

    private BigDecimal RRInTwoYear;

    public BigDecimal getRRInTwoYear() {
        return RRInTwoYear;
    }

    public void setRRInTwoYear(BigDecimal RRInTwoYear) {
        this.RRInTwoYear = RRInTwoYear;
    }

    private BigDecimal RRInThreeYear;

    public BigDecimal getRRInThreeYear() {
        return RRInThreeYear;
    }

    public void setRRInThreeYear(BigDecimal RRInThreeYear) {
        this.RRInThreeYear = RRInThreeYear;
    }

    private BigDecimal RRInFiveYear;

    public BigDecimal getRRInFiveYear() {
        return RRInFiveYear;
    }

    public void setRRInFiveYear(BigDecimal RRInFiveYear) {
        this.RRInFiveYear = RRInFiveYear;
    }

    private BigDecimal RRInTenYear;

    public BigDecimal getRRInTenYear() {
        return RRInTenYear;
    }

    public void setRRInTenYear(BigDecimal RRInTenYear) {
        this.RRInTenYear = RRInTenYear;
    }
}
