package com.codi.bus.core.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codi.bus.core.resultModel.AppUpdateResult;
import com.codi.bus.core.sys.service.AppUpdateService;
import com.codi.superman.base.domain.SysAppVersion;
import com.codi.superman.base.service.SysAppVersionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppUpdateServiceImpl implements AppUpdateService {
	
	@Autowired
	private SysAppVersionService savService;

	@Override
	public AppUpdateResult getAppUpdateResult(String clientVersion, String appCode) {
        if (clientVersion == null || appCode == null) {
            return null;
        } else {
            try {
                SysAppVersion tv = savService.queryVersionByAppCode(appCode, clientVersion);
                if (tv == null) {
                	log.error("No record find by app:{}, version:{}", appCode, clientVersion);
					return null;
				}
                SysAppVersion latest = savService.queryLatestVersionByAppCode(appCode);
                if (tv.getVersionId().equals(latest.getVersionId())) {
                	log.debug("App:{}, version:{}, 已是最新版", appCode, clientVersion);
                    return null;
                }
                AppUpdateResult updateResult = new AppUpdateResult(true, null);
                updateResult.setNeedForceUpdate(tv.getForceUpdate());
                updateResult.setNewVersion(latest.getVersionNumber());
                updateResult.setDownloadPath(latest.getDownloadPath());
                updateResult.setReleaseNotes(latest.getVersionDesc());
                return updateResult;
            } catch (Exception e) {
                log.error("Verify app version fail", e);
                return null;
            }
        }
	}

}
