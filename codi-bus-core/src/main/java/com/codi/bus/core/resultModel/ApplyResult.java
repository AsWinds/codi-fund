package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.ApplyModel;

public class ApplyResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private List<ApplyModel> applys;
	public List<ApplyModel> getApplys(){
		return this.applys;
	}
	
	public void setApplys(List<ApplyModel> applys){
		this.applys=applys;
	}
}
