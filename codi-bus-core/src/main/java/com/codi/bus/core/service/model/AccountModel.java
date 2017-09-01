package com.codi.bus.core.service.model;

public class AccountModel {

	private String tradeAccount;

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	public String getTradeAccount() {
		return this.tradeAccount;
	}

	private String mainAccountFlag;

	public void setMainAccountFlag(String mainAccountFlag) {
		this.mainAccountFlag = mainAccountFlag;
	}

	public String getMainAccountFlag() {
		return this.mainAccountFlag;
	}

	private String clientId;

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return this.clientId;
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

	private String taAccount;

	public void setTaAccount(String taAccount) {
		this.taAccount = taAccount;
	}

	public String getTaAccount() {
		return this.taAccount;
	}

	// TA账号状态
	// 恒生Map
	/*
	 * 0 正常 1 新开户 2 账号登记 5 正在销户 6 销户 A 挂失 D 冻结 F 开户失败 G 冻结且挂失      I	取消登记
	 */
	private String taAccountStatus;

	public void setTaAccountStatus(String taAccountStatus) {
		this.taAccountStatus = taAccountStatus;
	}

	public String getTaAccountStatus() {
		return this.taAccountStatus;
	}
}
