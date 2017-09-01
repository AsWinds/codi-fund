package com.codi.bus.core.service.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.util.DateUtils;
import com.codi.base.util.MoneyUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金资产
 *
 * @author Shangdu Lin
 *
 */
public class AssetFundModel {

	/**
	 * 是否有在途
	 */
	private boolean inTransit;

	public boolean getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(boolean inTransit) {
		this.inTransit = inTransit;
	}

	/**
	 * 净值日期
	 */
	private Date netValueDate;

	@JSONField(serialize = false)
	public Date getNetValueDate() {
		return this.netValueDate;
	}

	public void setNetValueDate(Date netValueDate) {
		this.netValueDate = netValueDate;
	}

	// 净值日期字符串 MM-dd
	public String getNetValueDateString() {
		if (this.netValueDate != null) {
			return DateUtils.formatDate7(this.netValueDate);
		} else {
			return null;
		}
	}

	/**
	 * 当日收益
	 */
	private BigDecimal totalTodayIncome;

	public BigDecimal getTotalTodayIncome() {
		return this.totalTodayIncome;
	}

	public void setTotalTodayIncome(BigDecimal totalTodayIncome) {
		this.totalTodayIncome = totalTodayIncome;
	}

	public String getTotalTodayIncomeString() {
		return MoneyUtils.formatMoney(this.totalTodayIncome, 2);
	}

	/**
	 * 总资产
	 */
	private BigDecimal totalWorthValue;

	public BigDecimal getTotalWorthValue() {
		return this.totalWorthValue;
	}

	public void setTotalWorthValue(BigDecimal totalWorthValue) {
		this.totalWorthValue = totalWorthValue;
	}

	public String getTotalWorthValueString() {
		return MoneyUtils.formatMoney(this.totalWorthValue, 2);
	}

	/**
	 * 基金个数
	 */
	private Integer fundsCount;

	public Integer getFundsCount() {
		return this.fundsCount;
	}

	public void setFundsCount(Integer fundsCount) {
		this.fundsCount = fundsCount;
	}

	/**
     * 当日净值
     */
    private BigDecimal netValue;

    @JSONField(serialize = false)
    public BigDecimal getNetValue() {
        return this.netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    /**
     * 上一工作日净值
     */
    private BigDecimal lastNetValue;

    @JSONField(serialize = false)
    public BigDecimal getLastNetValue() {
        return this.lastNetValue;
    }

    public void setLastNetValue(BigDecimal lastNetValue) {
        this.lastNetValue = lastNetValue;
    }

	/**
	 * 货币基金的万份收益
	 */
	private BigDecimal dailyProfit;

	@JSONField(serialize = false)
	public BigDecimal getDailyProfit() {
		return this.dailyProfit;
	}

	public void setDailyProfit(BigDecimal dailyProfit) {
		this.dailyProfit = dailyProfit;
	}

	/**
	 * 非货币基金的日收益率
	 */
	private BigDecimal todayIncomeRate;

	@JSONField(serialize = false)
	public BigDecimal getTodayIncomeRate() {
		return this.todayIncomeRate;
	}

	public void setTodayIncomeRate(BigDecimal todayIncomeRate) {
		this.todayIncomeRate = todayIncomeRate;
	}

	/**
	 * 是否是货币基金
	 */
	private boolean isCurrency;

	@JSONField(serialize = false)
	public boolean getIsCurrency() {
		return this.isCurrency;
	}

	public void setIsCurrency(boolean isCurrency) {
		this.isCurrency = isCurrency;
	}

	/**
	 * 当前份额
	 */
	private BigDecimal currentShares;

	@JSONField(serialize = false)
	public BigDecimal getCurrentShares() {
		return this.currentShares;
	}

	public void setCurrentShares(BigDecimal currentShares) {
		this.currentShares = currentShares;
	}

    /**
     * 当前份额减去T确认的T-1申购的不算T-1日收益的份额
     */
    private BigDecimal currentSharesWithoutTodayConfirmed;

    @JSONField(serialize = false)
    public BigDecimal getCurrentSharesWithoutTodayConfirmed() {
        return this.currentSharesWithoutTodayConfirmed;
    }

    public void setCurrentSharesWithoutTodayConfirmed(BigDecimal currentSharesWithoutTodayConfirmed) {
        this.currentSharesWithoutTodayConfirmed = currentSharesWithoutTodayConfirmed;
    }


	/**
	 * 资产类型
	 */
	private int assetType;

	public int getAssetType() {
		return this.assetType;
	}

	public void setAssetType(int assetType) {
		this.assetType = assetType;
	}

	private String fundCode;

	@JSONField(serialize = false)
	public String getFundCode() {
		return this.fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	private BigDecimal accumIncome;

    @JSONField(serialize = false)
    public BigDecimal getAccumIncome() {
        return accumIncome;
    }

    public void setAccumIncome(BigDecimal accumIncome) {
        this.accumIncome = accumIncome;
    }

    private BigDecimal totalAccumIncome;

    public BigDecimal getTotalAccumIncome() {
        return totalAccumIncome;
    }

    public void setTotalAccumIncome(BigDecimal totalAccumIncome) {
        this.totalAccumIncome = totalAccumIncome;
    }

    public String getTotalAccumIncomeString() {
        return MoneyUtils.formatMoney(this.totalAccumIncome, 2);
    }

    private BigDecimal unpaidIncome;

    @JSONField(serialize = false)
    public BigDecimal getUnpaidIncome() {
        return unpaidIncome;
    }

    public void setUnpaidIncome(BigDecimal unpaidIncome) {
        this.unpaidIncome = unpaidIncome;
    }

    private BigDecimal totalUnpaidIncome;

    @JSONField(serialize = false)
    public BigDecimal getTotalUnpaidIncome() {
        return totalUnpaidIncome;
    }

    public void setTotalUnpaidIncome(BigDecimal totalUnpaidIncome) {
        this.totalUnpaidIncome = totalUnpaidIncome;
    }
}
