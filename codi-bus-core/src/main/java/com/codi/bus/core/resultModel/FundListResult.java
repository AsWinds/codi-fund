package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundModel;

public class FundListResult extends BaseListResult {
	private static final long serialVersionUID = 1L;
	
	private List<FundModel> funds;

	public void setFunds(List<FundModel> funds) {
		this.funds = funds;
	}

	public List<FundModel> getFunds() {
		return this.funds;
	}
}
