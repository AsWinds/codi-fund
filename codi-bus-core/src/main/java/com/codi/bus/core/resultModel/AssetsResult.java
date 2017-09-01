package com.codi.bus.core.resultModel;

import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.MoneyUtils;
import com.codi.bus.core.service.model.AssetFundModel;

import java.math.BigDecimal;

/**
 * 我的资产
 *
 * @author Shangdu Lin
 *
 */
public class AssetsResult extends BaseResult {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当日收益
	 */
	private BigDecimal totalTodayIncome;

	public BigDecimal getTotalTodayIncome() {
		return this.totalTodayIncome;
	}

	public void setTotalTodayIncome(BigDecimal todayIncome) {
		this.totalTodayIncome = todayIncome;
	}

	public String getTotalTodayIncomeString() {
		BigDecimal walletIncome = new BigDecimal(0);
		if (wallet != null) {
			walletIncome = BigDecimalUtil
					.ConvertToBigDecimal(MoneyUtils.unformatMoney(wallet.getTotalTodayIncomeString()));
		}

		BigDecimal fundIncome = new BigDecimal(0);
		if (fund != null) {
			fundIncome = BigDecimalUtil.ConvertToBigDecimal(MoneyUtils.unformatMoney(fund.getTotalTodayIncomeString()));
		}

		return MoneyUtils.formatMoney(MoneyUtils.add(walletIncome, fundIncome));
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
		BigDecimal walletWorth = new BigDecimal(0);
		if (wallet != null) {
			walletWorth = BigDecimalUtil
					.ConvertToBigDecimal(MoneyUtils.unformatMoney(wallet.getTotalWorthValueString()));
		}

		BigDecimal fundWorth = new BigDecimal(0);
		if (fund != null) {
			fundWorth = BigDecimalUtil.ConvertToBigDecimal(MoneyUtils.unformatMoney(fund.getTotalWorthValueString()));
		}
		return MoneyUtils.formatMoney(MoneyUtils.add(walletWorth, fundWorth));
	}

	/**
	 * 基金
	 */
	private AssetFundModel fund;

	public void setFund(AssetFundModel fund) {
		this.fund = fund;
	}

	public AssetFundModel getFund() {
		return this.fund;
	}

	/**
	 * 零钱包
	 */
	private AssetFundModel wallet;

	public void setWallet(AssetFundModel wallet) {
		this.wallet = wallet;
	}

	public AssetFundModel getWallet() {
		return this.wallet;
	}
}
