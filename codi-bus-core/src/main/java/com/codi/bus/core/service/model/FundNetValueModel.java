package com.codi.bus.core.service.model;

import java.util.Date;

/**
 * 简化的净值模型
 * 
 * @author shi.pengyan
 * @date 2016年9月26日 下午5:49:02
 */
public class FundNetValueModel {

    private Date tradingDay; // 交易日

    // 货币型基金
    private String latestWeeklyYield;// 最近7日折算年收益率（%）
    private String dailyProfit;// 每万份基金单位当日收益（元）

    // 非货币型基金
    private String nvDailyGrowthRate; // 日涨幅
    private String unitNV; // 单位净值
    private String accumulatedUnitNV; // 单位累计净值


    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getLatestWeeklyYield() {
        return latestWeeklyYield;
    }

    public void setLatestWeeklyYield(String latestWeeklyYield) {
        this.latestWeeklyYield = latestWeeklyYield;
    }

    public String getDailyProfit() {
        return dailyProfit;
    }

    public void setDailyProfit(String dailyProfit) {
        this.dailyProfit = dailyProfit;
    }

    public String getNvDailyGrowthRate() {
        return nvDailyGrowthRate;
    }

    public void setNvDailyGrowthRate(String nvDailyGrowthRate) {
        this.nvDailyGrowthRate = nvDailyGrowthRate;
    }

    public String getUnitNV() {
        return unitNV;
    }

    public void setUnitNV(String unitNV) {
        this.unitNV = unitNV;
    }

    public String getAccumulatedUnitNV() {
        return accumulatedUnitNV;
    }

    public void setAccumulatedUnitNV(String accumulatedUnitNV) {
        this.accumulatedUnitNV = accumulatedUnitNV;
    }
}
