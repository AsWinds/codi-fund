package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.AccountModel;

public class TAListResult extends BaseListResult {
	private static final long serialVersionUID = 1L;
	
	private List<AccountModel> accounts;

	public void setAccounts(List<AccountModel> accounts) {
		this.accounts = accounts;
	}

	public List<AccountModel> getAccounts() {
		return this.accounts;
	}

}
