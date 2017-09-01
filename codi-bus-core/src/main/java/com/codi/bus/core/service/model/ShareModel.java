package com.codi.bus.core.service.model;

import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.DateUtils;
import com.codi.base.util.MoneyUtils;

import java.math.BigDecimal;
import java.util.Date;

public class ShareModel {

	// 基金代码
	private String fundCode;

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundCode() {
		return this.fundCode;
	}

	// 份额分类
	private String shareType;

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getShareType() {
		return this.shareType;
	}

	// 当前份额
	private BigDecimal currentShare;

	public void setCurrentShare(BigDecimal currentShare) {
		this.currentShare = currentShare;
	}

	public BigDecimal getCurrentShare() {
		return this.currentShare;
	}

	// 当前份额字符串
    public String getCurrentSharesString(){
    	return MoneyUtils.formatMoney(currentShare, 2);
    }

	// 交易账号
	private String tradeAccount;

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	// 可用份额
	private BigDecimal enableShares;

	public void setEnableShares(BigDecimal enableShares) {
		this.enableShares = enableShares;
	}

	public BigDecimal getEnableShares() {
		return this.enableShares;
	}

	// 可用份额字符串
    public String getEnableSharesString(){
    	return MoneyUtils.formatMoney(enableShares, 2);
    }

	// 基金冻结数量
	private BigDecimal frozenShare;

	public void setFrozenShare(BigDecimal frozenShare) {
		this.frozenShare = frozenShare;
	}

	public BigDecimal getFrozenShare() {
		return this.frozenShare;
	}

	// 分红方式
	private String autoBuy;

	public void setAutoBuy(String autoBuy) {
		this.autoBuy = autoBuy;
	}

	public String getAutoBuy() {
		return this.autoBuy;
	}

	// 交易冻结数量
	private BigDecimal businessFrozenAmount;

	public void setBusinessFrozenAmount(BigDecimal businessFrozenAmount) {
		this.businessFrozenAmount = businessFrozenAmount;
	}

	public BigDecimal getBusinessFrozenAmount() {
		return this.businessFrozenAmount;
	}

	// 未付收益金额
	private BigDecimal unpaidIncome;

	public void setUnpaidIncome(BigDecimal unpaidIncome) {
		this.unpaidIncome = unpaidIncome;
	}

	public BigDecimal getUnpaidIncome() {
		return this.unpaidIncome;
	}

	// 未付收益金额字符串
	public String getUnpaidIncomeString() {
		return MoneyUtils.formatMoney(this.unpaidIncome, 2);
	}

	// 资金方式
	private String capitalMode;

	public void setCapitalMode(String capitalMode) {
		this.capitalMode = capitalMode;
	}

	public String getCapitalMode() {
		return this.capitalMode;
	}

	// 银行账号
	private String bankAccount;

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	// 每日收益
	private BigDecimal todayIncome;

	public void setTodayIncome(BigDecimal todayIncome) {
		this.todayIncome = todayIncome;
	}

	public BigDecimal getTodayIncome() {
		return this.todayIncome;
	}

	// 每日收益格式化字符串
	public String getTodayIncomeString() {
		return MoneyUtils.formatMoney(this.todayIncome, 2);
	}

	// 市值
	private BigDecimal worthValue;

	public void setWorthValue(BigDecimal worthValue) {
		this.worthValue = worthValue;
	}

	public BigDecimal getWorthValue() {
		return this.worthValue;
	}

	// 市值格式化字符串
	public String getWorthValueString() {
		return MoneyUtils.formatMoney(this.worthValue, 2);
	}

	// 总记录数
	private Long totalCount;

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalCount() {
		return this.totalCount;
	}

	// 记录数
	private Long rowCount;

	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}

	public Long getRowCount() {
		return this.rowCount;
	}

	// 可用到期份额
	private BigDecimal availableDueShare;

	public void setAvailableDueShare(BigDecimal availableDueShare) {
		this.availableDueShare = availableDueShare;
	}

	public BigDecimal getAvailableDueShare() {
		return this.availableDueShare;
	}

	// 快速赎回可用份额
	private BigDecimal quickExceedEnableShare;

	public void setQuickExceedEnableShare(BigDecimal quickExceedEnableShare) {
		this.quickExceedEnableShare = quickExceedEnableShare;
	}

	public BigDecimal getQuickExceedEnableShare() {
		return this.quickExceedEnableShare;
	}

	// 累计收益
	private BigDecimal accumIncome;

	public void setAccumIncome(BigDecimal accumIncome) {
		this.accumIncome = accumIncome;
	}

	public BigDecimal getAccumIncome() {
		return this.accumIncome;
	}

	// 累计收益格式化字符串
	public String getAccumIncomeString() {
		return MoneyUtils.formatMoney(this.accumIncome, 2);
	}

	// 当日申购总额
	private BigDecimal todayApplyTotalQuota;

	public void setTodayApplyTotalQuota(BigDecimal todayApplyTotalQuota) {
		this.todayApplyTotalQuota = todayApplyTotalQuota;
	}

	public BigDecimal getTodayApplyTotalQuota() {
		return this.todayApplyTotalQuota;
	}

	// 当日赎回总额
	private BigDecimal todayExceedTotalQuota;

	public void setTodayExceedTotalQuota(BigDecimal todayExceedTotalQuota) {
		this.todayExceedTotalQuota = todayExceedTotalQuota;
	}

	public BigDecimal getTodayExceedTotalQuota() {
		return this.todayExceedTotalQuota;
	}

	// 当日转入总额
	private BigDecimal todayTransinTotalQuota;

	public void setTodayTransinTotalQuota(BigDecimal todayTransinTotalQuota) {
		this.todayTransinTotalQuota = todayTransinTotalQuota;
	}

	public BigDecimal getTodayTransinTotalQuota() {
		return this.todayTransinTotalQuota;
	}

	// 当日转出总额
	private BigDecimal todayTransoutTotalQuota;

	public void setTodayTransoutTotalQuota(BigDecimal todayTransoutTotalQuota) {
		this.todayTransoutTotalQuota = todayTransoutTotalQuota;
	}

	public BigDecimal getTodayTransoutTotalQuota() {
		return this.todayTransoutTotalQuota;
	}

	// 当日赎回转购入总额
	private BigDecimal excetransOutTotalQuota;

	public void setExcetransOutTotalQuota(BigDecimal excetransOutTotalQuota) {
		this.excetransOutTotalQuota = excetransOutTotalQuota;
	}

	public BigDecimal getExcetransOutTotalQuota() {
		return this.excetransOutTotalQuota;
	}

	// 当日赎回转购出总额
	private BigDecimal excetransInTotalQuota;

	public void setExcetransInTotalQuota(BigDecimal excetransInTotalQuota) {
		this.excetransInTotalQuota = excetransInTotalQuota;
	}

	public BigDecimal getExcetransInTotalQuota() {
		return this.excetransInTotalQuota;
	}

	// 净值
	private BigDecimal netValue;

	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	public BigDecimal getNetValue() {
		return this.netValue;
	}

	// 净值字符串
	public String getNetValueString() {
		return MoneyUtils.formatMoney(this.netValue, 4);
	}

	// 净值日期
	private Date netValueDate;

	public void setNetValueDate(Date netValueDate) {
		this.netValueDate = netValueDate;
	}

	public Date getNetValueDate() {
		return this.netValueDate;
	}

	// 净值日期字符串 MM-dd
	public String getNetValueDateString() {
		return DateUtils.formatDate7(this.netValueDate);
	}

	// 基金名字
	private String fundName;

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFundName() {
		return this.fundName;
	}

	// 银行名字
	private String bankName;

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return this.bankName;
	}

	// 银行英文简称
	private String bankCode;

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	// 持仓收益率
	private BigDecimal accumIncomeRate;

	public void setAccumIncomeRate(BigDecimal accumIncomeRate) {
		this.accumIncomeRate = accumIncomeRate;
	}

	public BigDecimal getAccumIncomeRate() {
		return this.accumIncomeRate;
	}

	// 持仓收益率字符串
	public String getAccumIncomeRateString() {
		if(this.accumIncomeRate!=null){
			return BigDecimalUtil.ConvertToString(this.accumIncomeRate.multiply(new BigDecimal(100))) + "%";
		}else {
			return "";
		}
	}

	// 日收益率
	private BigDecimal todayIncomeRate;

	public void setTodayIncomeRate(BigDecimal todayIncomeRate) {
		this.todayIncomeRate = todayIncomeRate;
	}

	public BigDecimal getTodayIncomeRate() {
		return this.todayIncomeRate;
	}

	// 万份之收益-10位小数
	private BigDecimal dailyProfit;

	public BigDecimal getDailyProfit() {
		return dailyProfit;
	}

	public void setDailyProfit(BigDecimal dailyProfit) {
		this.dailyProfit = dailyProfit;
	}

	// 万份之收益字符串-货币型基金
	public String getDailyProfitString() {
		if (dailyProfit == null) {
			dailyProfit = new BigDecimal(0);
		}
		return MoneyUtils.formatMoney(dailyProfit, 4);
	}

	// 日收益率字符串
	public String getTodayIncomeRateString() {
		if(this.todayIncomeRate!=null){
			return BigDecimalUtil.ConvertToString(this.todayIncomeRate.multiply(new BigDecimal(100))) + "%";
		}else {
			return "";
		}
	}

	// 本金
	private BigDecimal fundBalance;

	public void setFundBalance(BigDecimal fundBalance) {
		this.fundBalance = fundBalance;
	}

	public BigDecimal getFundBalance() {
		return this.fundBalance;
	}

	// 本金式化字符串
	public String getFundBalanceString() {
		return MoneyUtils.formatMoney(this.fundBalance, 2);
	}

	// 基金类型
	private String fundType;

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getFundType() {
		return this.fundType;
	}

	// 前端基金类型
	private int appFundType;

	public void setAppFundType(int appFundType) {
		this.appFundType = appFundType;
	}

	public int getAppFundType() {
		return this.appFundType;
	}
}
