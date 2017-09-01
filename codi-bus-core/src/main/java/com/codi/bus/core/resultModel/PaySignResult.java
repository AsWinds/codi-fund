package com.codi.bus.core.resultModel;

public class PaySignResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private String smsSerialNo;
	public String getSMSSerialNo() {
		return smsSerialNo;
	}
	public void setSMSSerialNo(String smsSerialNo) {
		this.smsSerialNo = smsSerialNo;
	}
	
	private String originalSerialNo;
	public String getOriginalSerialNo() {
		return originalSerialNo;
	}
	public void setOriginalSerialNo(String originalSerialNo) {
		this.originalSerialNo = originalSerialNo;
	}
	
	private String protocolNo;
	public String getProtocolNo() {
		return protocolNo;
	}
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
}
