package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.BankLimitModel;
import com.codi.bus.core.service.model.TradeLimitModel;

public class TradeLimitListResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private List<TradeLimitModel> limits;
	public void setLimits(List<TradeLimitModel> limits){
		this.limits=limits;
	}
	public List<TradeLimitModel> getLimits(){
		return this.limits;
	}
	
	/*private List<BankLimitModel> bankLimits;
	public void setBankLimits(List<BankLimitModel> bankLimits){
		this.bankLimits=bankLimits;
	}
	public List<BankLimitModel> getBankLimits(){
		return this.bankLimits;
	}*/
	
}
