package com.codi.bus.core.resultModel;

public class ValidateTokenResult extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	//used when check app need update
	private AppUpdateResult appUpdateResult;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private String channelId;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId == null ? null : channelId.trim();
	}

	public AppUpdateResult getAppUpdateResult() {
		return appUpdateResult;
	}

	public void setAppUpdateResult(AppUpdateResult appUpdateResult) {
		this.appUpdateResult = appUpdateResult;
	}
	
	private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}
