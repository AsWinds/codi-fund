package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.BankModel;

public class BankListResult extends BaseListResult {
	private static final long serialVersionUID = 1L;
	
	private List<BankModel> banks;
	public void setBanks(List<BankModel> banks){
		this.banks=banks;
	}
	public List<BankModel> getBanks(){
		return this.banks;
	}
}
