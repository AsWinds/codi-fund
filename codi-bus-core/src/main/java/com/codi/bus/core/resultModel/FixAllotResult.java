package com.codi.bus.core.resultModel;

import java.math.BigDecimal;

import com.codi.base.util.MoneyUtils;

/**
 * 定投基金申购 返回
 * 
 * @author song-jj
 */
public class FixAllotResult extends BaseResult {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 申请编号
	 */
	private String allotNo;

	/**
	 * 定投协议号
	 */
	private String scheduledProtocolId;

	/**
	 * 下次交易日期
	 */
	private String nextFixRequestDate;

	/**
	 * 基金名称
	 */
	private String fundName;

	/**
	 * 定投周期
	 */
	private String protocolPeriodUnit;

	/**
	 * 扣款日期
	 */
	private Long protocolFixDay;

	/**
	 * 定投金额
	 */
	private BigDecimal balance;

	public String getAllotNo() {
		return allotNo;
	}

	public void setAllotNo(String allotNo) {
		this.allotNo = allotNo;
	}

	public String getScheduledProtocolId() {
		return scheduledProtocolId;
	}

	public void setScheduledProtocolId(String scheduledProtocolId) {
		this.scheduledProtocolId = scheduledProtocolId;
	}

	public String getNextFixRequestDate() {
		return nextFixRequestDate;
	}

	public void setNextFixRequestDate(String nextFixRequestDate) {
		this.nextFixRequestDate = nextFixRequestDate;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getProtocolPeriodUnit() {
		return protocolPeriodUnit;
	}

	public void setProtocolPeriodUnit(String protocolPeriodUnit) {
		this.protocolPeriodUnit = protocolPeriodUnit;
	}

	public Long getProtocolFixDay() {
		return protocolFixDay;
	}

	public void setProtocolFixDay(Long protocolFixDay) {
		this.protocolFixDay = protocolFixDay;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	// 申购金额字符串
	public String getBalanceString() {
		return MoneyUtils.formatMoney(balance, 2);
	}

}
