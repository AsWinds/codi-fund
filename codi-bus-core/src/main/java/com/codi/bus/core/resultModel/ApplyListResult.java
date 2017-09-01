package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.ApplyModel;

public class ApplyListResult extends BaseListResult {
	private static final long serialVersionUID = 1L;
	
	private List<ApplyModel> applys;

	public List<ApplyModel> getApplys() {
		return this.applys;
	}

	public void setApplys(List<ApplyModel> applys) {
		this.applys = applys;
	}

	// 是否有在途交易
	private boolean inTransit;

	public Boolean getInTransit() {
		return inTransit;
	}

	public void setInTransit(Boolean inTransit) {
		this.inTransit = inTransit;
	}
}
