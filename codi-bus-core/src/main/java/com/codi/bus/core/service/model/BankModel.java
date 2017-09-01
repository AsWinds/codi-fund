package com.codi.bus.core.service.model;

import com.codi.bus.constant.GlobalConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BankModel {

	private String bankName;

	private String bankCode;

	private String userBankNo;

	private String capitalMode;

	private String tradeAccount;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode == null ? null : bankCode.trim();
	}

	public String getUserBankNo() {
		return userBankNo;
	}

	public void setUserBankNo(String userBankNo) {
		this.userBankNo = userBankNo == null ? null : userBankNo.trim();
	}

	public String getCapitalMode() {
		return capitalMode;
	}

	public void setCapitalMode(String capitalMode) {
		this.capitalMode = capitalMode == null ? null : capitalMode.trim();
	}

	public String getCapitalModeName() {
		if (this.capitalMode.equals(GlobalConstant.CAPITAL_MODE_COUNTER)) {
			return GlobalConstant.CAPITAL_MODE_COUNTER_STRING;
		}

		if (this.capitalMode.equals(GlobalConstant.CAPITAL_MODE_EPAY)) {
			return GlobalConstant.CAPITAL_MODE_EPAY_STRING;
		}

		return "";
	}

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount == null ? null : tradeAccount.trim();
	}

	// 交易账号状态
	// 恒生Map
	/*
	 * 0 正常 1 新开户 2 账号登记 5 正在销户 6 销户 A 挂失 D 冻结 F 开户失败 G 冻结且挂失
	 */
	private String tradeAccountStatus;

	public void setTradeAccountStatus(String tradeAccountStatus) {
		this.tradeAccountStatus = tradeAccountStatus;
	}

	public String getTradeAccountStatus() {
		return this.tradeAccountStatus;
	}

	private String tradeAccountStatusString;

	public void setTradeAccountStatusString(String tradeAccountStatusString) {
		this.tradeAccountStatusString = tradeAccountStatusString;
	}

	public String getTradeAccountStatusString() {
		return this.tradeAccountStatusString;
	}

	private String mainAccountFlag;

	public void setMainAccountFlag(String mainAccountFlag) {
		this.mainAccountFlag = mainAccountFlag;
	}

	@JsonIgnore
	public String getMainAccountFlag() {
		return this.mainAccountFlag;
	}

	private String taAccount;

	public void setTaAccount(String taAccount) {
		this.taAccount = taAccount;
	}

	@JsonIgnore
	public String getTaAccount() {
		return this.taAccount;
	}

	// TA账号状态
	// 恒生Map
	/*
	 * 0 正常 1 新开户 2 账号登记 5 正在销户 6 销户 A 挂失 D 冻结 F 开户失败 G 冻结且挂失 I 取消登记
	 */
	/*
	 * private String taAccountStatus;
	 * 
	 * public void setTaAccountStatus(String taAccountStatus) {
	 * this.taAccountStatus = taAccountStatus; }
	 * 
	 * public String getTaAccountStatus() { return this.taAccountStatus; }
	 * 
	 * private String taAccountStatusString;
	 * 
	 * public void setTaAccountStatusString(String taAccountStatusString) {
	 * this.taAccountStatusString = taAccountStatusString; }
	 * 
	 * public String getTaAccountStatusString() { return
	 * this.taAccountStatusString; }
	 */
}
