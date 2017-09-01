package com.codi.bus.core.resultModel;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.bus.core.resultModel.fund.FundBaseResult;

/**
 * 基金净值
 * 
 * @author shi.pengyan
 * @date 2016年9月25日 上午9:29:45
 */
public class FundNetValueResult extends FundBaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String chiName;
    private String chiNameAbbr;
    private String secuAbbr;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date tradingDay; // 交易日

    // 货币型基金
    private BigDecimal LatestWeeklyYield;// 最近7日折算年收益率（%）
    private BigDecimal DailyProfit;// 每万份基金单位当日收益（元）

    // 非货币型基金
    private BigDecimal nvDailyGrowthRate; // 日涨幅
    private BigDecimal unitNV; // 单位净值

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

    public BigDecimal getLatestWeeklyYield() {
        return LatestWeeklyYield;
    }

    public void setLatestWeeklyYield(BigDecimal latestWeeklyYield) {
        LatestWeeklyYield = latestWeeklyYield;
    }

    public BigDecimal getDailyProfit() {
        return DailyProfit;
    }

    public void setDailyProfit(BigDecimal dailyProfit) {
        DailyProfit = dailyProfit;
    }

    public BigDecimal getNvDailyGrowthRate() {
        return nvDailyGrowthRate;
    }

    public void setNvDailyGrowthRate(BigDecimal nvDailyGrowthRate) {
        this.nvDailyGrowthRate = nvDailyGrowthRate;
    }

    public BigDecimal getUnitNV() {
        return unitNV;
    }

    public void setUnitNV(BigDecimal unitNV) {
        this.unitNV = unitNV;
    }

}
