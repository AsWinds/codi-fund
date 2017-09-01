package com.codi.bus.core.resultModel;

import java.util.List;

public class PayableBankListResult extends BaseListResult {
	private static final long serialVersionUID = 1L;
	
	private List<PayableBankModel> banks;
	public void setBanks(List<PayableBankModel> banks){
		this.banks=banks;
	}
	public List<PayableBankModel> getBanks(){
		return this.banks;
	}
}
