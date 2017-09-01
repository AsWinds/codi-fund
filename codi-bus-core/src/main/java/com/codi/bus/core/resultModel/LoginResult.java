package com.codi.bus.core.resultModel;

import com.codi.bus.core.service.model.UserModel;
import com.codi.bus.core.service.model.WarningModel;

import java.util.List;

public class LoginResult extends BaseResult {
	private static final long serialVersionUID = 1L;

	private String token;

	//used when check app need update
	private AppUpdateResult appUpdateResult;


	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	private UserModel user;

	public void setUser(UserModel user) {
		this.user = user;
	}

	public UserModel getUser() {
		return user;
	}

	public AppUpdateResult getAppUpdateResult() {
		return appUpdateResult;
	}

	public void setAppUpdateResult(AppUpdateResult appUpdateResult) {
		this.appUpdateResult = appUpdateResult;
	}

    private List<WarningModel> warnings;

    public List<WarningModel> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<WarningModel> warnings) {
        this.warnings = warnings;
    }
}
