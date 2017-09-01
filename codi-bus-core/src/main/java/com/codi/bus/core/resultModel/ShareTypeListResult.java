package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.ShareTypeModel;

public class ShareTypeListResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private List<ShareTypeModel> shareTypes;

	public void setShareTypes(List<ShareTypeModel> shareTypes) {
		this.shareTypes = shareTypes;
	}

	public List<ShareTypeModel> getShareTypes() {
		return this.shareTypes;
	}
}
