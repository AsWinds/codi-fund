package com.codi.bus.core.resultModel;

public class CardBinResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private String bankCode;	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	private String bankName;	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	private String cardType;	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	private int validCard;	
	public int getValidCard() {
		return validCard;
	}
	public void setValidCard(int validCard) {
		this.validCard = validCard;
	}
}
