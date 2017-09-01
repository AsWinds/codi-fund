package com.codi.bus.core.resultModel;

import java.util.List;

public class CashChangeListResult extends BaseListResult{
	private static final long serialVersionUID = 1L;
	
	private List<CashChangeResult> cashChangeResults;

	public List<CashChangeResult> getCashChangeResults() {
		return cashChangeResults;
	}

	public void setCashChangeResults(List<CashChangeResult> cashChangeResults) {
		this.cashChangeResults = cashChangeResults;
	}
}
