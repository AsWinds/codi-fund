package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.resultModel.fund.FundBaseResult;
import com.codi.bus.core.service.model.FundManagerModel;

public class FundDetailResult extends FundBaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int fundStarRank;// 星级

    // private List<FundAnnouncement> fundAnnouncements; // 公告

    private String fundName;
    private String fundNameAbbr;

    private String fundManager; // 基金经理
    private List<FundManagerModel> fundManagers; // 基金经理列表

    private String investAdvisor;// 基金管理人
    private Integer InvestAdvisorCode;// 基金管理人编码

    private String tradingDay;

    private Integer riskLevel; // 基金风险等级
    private String riskLevelString;// 对应的风险等级描述

    // 申购费率，折扣率
    private String fareRatio;
    private String fareRatioAfterDiscount;

    // 货币型基金
    private String latestWeeklyYield;// 最近7日折算年收益率（%）
    private String dailyProfit;// 每万份基金单位当日收益（元）

    // 非货币型基金
    private String nvDailyGrowthRate; // 日涨幅
    private String unitNV; // 单位净值

    private String RRInSingleWeek; // 一周回报率
    // private String RRInSelectedMonth;// 本月以来回报率
    private String RRInSingleMonth;// 一个月回报率
    private String RRInThreeMonth;// 三个月回报率
    private String RRInSixMonth;// 六个月回报率
    private String RRSinceThisYear;// 今年以来回报率
    private String RRInSingleYear;// 一年回报率
    private String RRSinceStart;// 设立以来回报率（%）

    public int getFundStarRank() {
        return fundStarRank;
    }

    public void setFundStarRank(int fundStarRank) {
        this.fundStarRank = fundStarRank;
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

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getRRInSingleWeek() {
        return RRInSingleWeek;
    }

    public void setRRInSingleWeek(String rRInSingleWeek) {
        RRInSingleWeek = rRInSingleWeek;
    }

    public String getRRInSingleMonth() {
        return RRInSingleMonth;
    }

    public void setRRInSingleMonth(String rRInSingleMonth) {
        RRInSingleMonth = rRInSingleMonth;
    }

    public String getRRInThreeMonth() {
        return RRInThreeMonth;
    }

    public void setRRInThreeMonth(String rRInThreeMonth) {
        RRInThreeMonth = rRInThreeMonth;
    }

    public String getRRInSixMonth() {
        return RRInSixMonth;
    }

    public void setRRInSixMonth(String rRInSixMonth) {
        RRInSixMonth = rRInSixMonth;
    }

    public String getRRSinceThisYear() {
        return RRSinceThisYear;
    }

    public void setRRSinceThisYear(String rRSinceThisYear) {
        RRSinceThisYear = rRSinceThisYear;
    }

    public String getRRInSingleYear() {
        return RRInSingleYear;
    }

    public void setRRInSingleYear(String rRInSingleYear) {
        RRInSingleYear = rRInSingleYear;
    }

    public String getRRSinceStart() {
        return RRSinceStart;
    }

    public void setRRSinceStart(String rRSinceStart) {
        RRSinceStart = rRSinceStart;
    }

    public String getInvestAdvisor() {
        return investAdvisor;
    }

    public void setInvestAdvisor(String investAdvisor) {
        this.investAdvisor = investAdvisor;
    }

    public String getFareRatio() {
        return fareRatio;
    }

    public void setFareRatio(String fareRatio) {
        this.fareRatio = fareRatio;
    }

    public String getFareRatioAfterDiscount() {
        return fareRatioAfterDiscount;
    }

    public void setFareRatioAfterDiscount(String fareRatioAfterDiscount) {
        this.fareRatioAfterDiscount = fareRatioAfterDiscount;
    }

    public Integer getInvestAdvisorCode() {
        return InvestAdvisorCode;
    }

    public void setInvestAdvisorCode(Integer investAdvisorCode) {
        InvestAdvisorCode = investAdvisorCode;
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

    public List<FundManagerModel> getFundManagers() {
        return fundManagers;
    }

    public void setFundManagers(List<FundManagerModel> fundManagers) {
        this.fundManagers = fundManagers;
    }
}
