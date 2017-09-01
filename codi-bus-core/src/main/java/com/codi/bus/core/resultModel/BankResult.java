package com.codi.bus.core.resultModel;

public class BankResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private String bankName;
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}
}
