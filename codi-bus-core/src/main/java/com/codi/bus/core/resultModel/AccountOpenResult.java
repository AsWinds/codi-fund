package com.codi.bus.core.resultModel;

import com.codi.bus.core.service.model.UserModel;

public class AccountOpenResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private UserModel user;

	public void setUser(UserModel user) {
		this.user = user;
	}

	public UserModel getUser() {
		return user;
	}
}
