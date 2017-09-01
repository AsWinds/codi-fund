package com.codi.bus.core.resultModel;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.bus.core.service.model.TradeLimitModel;
import com.codi.bus.core.service.model.WalletDetailRateSimpleModel;

import java.util.Date;
import java.util.List;

/**
 * 钱包详情返回值
 *
 * @author shi.pengyan
 * @date 2016年12月9日 上午10:15:53
 */
public class WalletDetailResult extends BaseResult {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String fundCode; // 用户最终购买成功的，（会有购买基金A一定额度后变成基金B的场景）
    private String fundName;
    private String fundNameAbbr;

    private String fundCodeOnSale; // 当前在售的
    private String fundNameOnSale;
    private String fundNameAbbrOnSale;

    private String walletMoney; // 零钱
    private String latestWeeklyYield; // 七日年化收益率
    @JSONField(format = "yyyy-MM-dd")
    private Date tradingDay;// 交易日
    private String todayIncome; // 日收益
    private String maxLimit;

    // 七日年化收益率
    private List<WalletDetailRateSimpleModel> latestWeeklyYieldList;

    private boolean canSell; // 是否可体现
    private boolean canBuy; // 是否可存入

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
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

    public String getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(String walletMoney) {
        this.walletMoney = walletMoney;
    }

    public String getLatestWeeklyYield() {
        return latestWeeklyYield;
    }

    public void setLatestWeeklyYield(String latestWeeklyYield) {
        this.latestWeeklyYield = latestWeeklyYield;
    }

    public String getTodayIncome() {
        return todayIncome;
    }

    public void setTodayIncome(String todayIncome) {
        this.todayIncome = todayIncome;
    }

    public String getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(String maxLimit) {
        this.maxLimit = maxLimit;
    }

    public List<WalletDetailRateSimpleModel> getLatestWeeklyYieldList() {
        return latestWeeklyYieldList;
    }

    public void setLatestWeeklyYieldList(List<WalletDetailRateSimpleModel> latestWeeklyYieldList) {
        this.latestWeeklyYieldList = latestWeeklyYieldList;
    }

    public boolean isCanSell() {
        return canSell;
    }

    public void setCanSell(boolean canSell) {
        this.canSell = canSell;
    }

    public boolean isCanBuy() {
        return canBuy;
    }

    public void setCanBuy(boolean canBuy) {
        this.canBuy = canBuy;
    }

    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getFundCodeOnSale() {
        return fundCodeOnSale;
    }

    public void setFundCodeOnSale(String fundCodeOnSale) {
        this.fundCodeOnSale = fundCodeOnSale;
    }

    public String getFundNameOnSale() {
        return fundNameOnSale;
    }

    public void setFundNameOnSale(String fundNameOnSale) {
        this.fundNameOnSale = fundNameOnSale;
    }

    public String getFundNameAbbrOnSale() {
        return fundNameAbbrOnSale;
    }

    public void setFundNameAbbrOnSale(String fundNameAbbrOnSale) {
        this.fundNameAbbrOnSale = fundNameAbbrOnSale;
    }

    /**
     * 交易限制 - Shangdu Lin - 20170330
     */
    private List<TradeLimitModel> limits;

    public List<TradeLimitModel> getLimits() {
        return limits;
    }

    public void setLimits(List<TradeLimitModel> limits) {
        this.limits = limits;
    }
}
