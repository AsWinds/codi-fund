package com.codi.bus.util;

public enum FundOperation {
	Apply("022"), Exceed("024");
	
	private final String code;
	
	private FundOperation(String code) {
		this.code = code;
	}
	
	public String getHsCode(){
		return code;
	}
}
