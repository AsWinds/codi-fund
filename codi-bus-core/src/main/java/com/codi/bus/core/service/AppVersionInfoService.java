package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.domain.AppVersionInfo;
import com.codi.bus.core.resultModel.AppUpdateResult;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.CommonDataResult;
import com.codi.bus.util.Platform;

public interface AppVersionInfoService {
	
	BaseResult add(AppVersionInfo info);
	
	/**
	 * Find according ID, Only update field appName, releaseNotes
	 * 
	 * */
	BaseResult update(AppVersionInfo info);
	
	List<AppVersionInfo> getAll();
	
	AppVersionInfo getNewestVersion(String appIdentifier, Platform platform);

	BaseResult delete(Long id);

	CommonDataResult<List<AppVersionInfo>> queryAppVersionsAfter(String appIdentifier, Platform platform, String version);
	
	AppUpdateResult getAppUpdateResult(String clientVersion, Platform osType, String appIdentifier);
	
	AppVersionInfo getVersion(String appIdentifier, Platform osType, String version);
}
