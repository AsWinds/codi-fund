package com.codi.bus.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.AppVersionInfoDao;
import com.codi.bus.core.domain.AppVersionInfo;
import com.codi.bus.core.resultModel.AppUpdateResult;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.CommonDataResult;
import com.codi.bus.core.service.AppVersionInfoService;
import com.codi.bus.util.Platform;
import com.codi.bus.util.VersionUtil;

@Service
public class AppVersionInfoServiceImpl implements AppVersionInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppVersionInfoServiceImpl.class);

    @Resource
    private AppVersionInfoDao appVersionInfoDao;

    @Transactional
    @Override
    public BaseResult add(AppVersionInfo info) {
        AppVersionInfo lastOne = getNewestVersion(info.getAppIdentifier(),
                Enum.valueOf(Platform.class, info.getPlatform()));
        if (lastOne != null) {
            String v_now = info.getVersion();
            String v_last = lastOne.getVersion();
            if (VersionUtil.compareAppVersion(v_now, v_last) != 1) {
                return new BaseResult(false,
                        "Error version, latest version in db:" + v_last + ", and insert version : " + v_now,
                        GlobalConstant.ERROR_TYPE_APPLICATION);
            }
        }
        int res = appVersionInfoDao.insert(info);
        if (res != 1) {
            throw new RuntimeException("Perform save action failed, dao returned : " + res);
        }
        return new BaseResult(true, "Saved successfully!");
    }

    @Transactional
    @Override
    public BaseResult update(AppVersionInfo info) {
        Long id = info.getId();
        if (id == null) {
            return new BaseResult(false, "Require entity ID", GlobalConstant.ERROR_TYPE_APPLICATION);
        }
        AppVersionInfo db_info = appVersionInfoDao.selectByPrimaryKey(id);
        if (db_info == null) {
            return new BaseResult(false, "No record fund by id : " + id, GlobalConstant.ERROR_TYPE_APPLICATION);
        }
        db_info.setAppName(info.getAppName());
        db_info.setReleaseNotes(info.getReleaseNotes());
        int row_num = appVersionInfoDao.update(db_info);
        if (row_num != 1) {
            LOGGER.error("Update AppVersionInfo Fail, Since dao returned unexpected res ：" + row_num);
            return new BaseResult(false, "Action fail!", GlobalConstant.ERROR_TYPE_APPLICATION);
        }
        return new BaseResult(true, "Update Successfully!");
    }

    @Override
    public List<AppVersionInfo> getAll() {
        return appVersionInfoDao.findList("findAll");
    }

    @Override
    public AppVersionInfo getNewestVersion(String appIdentifier, Platform platform) {
        AppVersionInfo condition = new AppVersionInfo();
        condition.setAppIdentifier(appIdentifier);
        condition.setPlatform(platform.name());

        List<AppVersionInfo> res = appVersionInfoDao.findList("slectMaxIdRecord", condition);
        if (!res.isEmpty()) {
            return res.get(0);
        }
        return null;
    }

    @Override
    public BaseResult delete(Long id) {
        AppVersionInfo info = appVersionInfoDao.selectByPrimaryKey(id);
        if (info == null) {
            return new BaseResult(false, "No target object find according id : " + id, GlobalConstant.ERROR_TYPE_APPLICATION);
        }
        int res = appVersionInfoDao.deleteByPrimaryKey(id);
        LOGGER.info("Delete AppVersionInfo By id : " + id + ", db returned : " + res);
        return new CommonDataResult<>(true, null, info);
    }

    @Override
    public CommonDataResult<List<AppVersionInfo>> queryAppVersionsAfter(String appIdentifier, Platform platform,
            String version) {
        AppVersionInfo query = new AppVersionInfo();
        Long target_id = this.getVersion(appIdentifier, platform, version).getId();
        query = new AppVersionInfo();
        query.setId(target_id);
        query.setAppIdentifier(appIdentifier);
        query.setPlatform(platform.name());
        return new CommonDataResult<>(true, null, appVersionInfoDao.findList("slectRecordsAfterId", query));
    }

    @Override
    public AppUpdateResult getAppUpdateResult(String clientVersion, Platform osType, String appIdentifier) {
        if (clientVersion == null || osType == null || appIdentifier == null) {
            return null;
        } else {
            try {
                AppVersionInfo tv = this.getVersion(appIdentifier, osType, clientVersion);
                if (tv == null) {
					return null;
				}
                AppVersionInfo latest = this.getNewestVersion(appIdentifier, osType);
                if (tv.getId().equals(latest.getId())) {
                    return null;
                }
                AppUpdateResult updateResult = new AppUpdateResult(true, null);
                updateResult.setNeedForceUpdate(tv.getNeedForeceUpdate());
                updateResult.setNewVersion(latest.getVersion());
                updateResult.setDownloadPath(latest.getDownloadPath());
                updateResult.setReleaseNotes(latest.getReleaseNotes());
                return updateResult;
            } catch (Exception e) {
                LOGGER.error("Verify app version fail", e);
                return null;
            }
        }
    }

    @Override
    public AppVersionInfo getVersion(String appIdentifier, Platform platform, String version) {
        AppVersionInfo query = new AppVersionInfo();
        query.setAppIdentifier(appIdentifier);
        query.setPlatform(platform.name());
        query.setVersion(version);
        List<AppVersionInfo> targrt = appVersionInfoDao.findList("slectAppVersion", query);
        if (targrt.size() == 0) {
            LOGGER.error("No record find according appIdentifier: {}, platform: {}, version: {}", appIdentifier, platform.name(), version);
            return null;
        }
        return targrt.get(0);
    }

}
