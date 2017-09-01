package com.codi.bus.core.sys.service;

import com.codi.bus.core.resultModel.AppUpdateResult;

public interface AppUpdateService {
	
	AppUpdateResult getAppUpdateResult(String clientVersion, String appIdentifier);

}
