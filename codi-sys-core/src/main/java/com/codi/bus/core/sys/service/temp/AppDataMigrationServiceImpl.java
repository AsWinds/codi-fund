package com.codi.bus.core.sys.service.temp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.exception.BaseAppException;
import com.codi.base.util.MD5;
import com.codi.bus.core.dao.AppVersionInfoDao;
import com.codi.bus.core.domain.AppVersionInfo;
import com.codi.superman.base.dao.SysAppDao;
import com.codi.superman.base.dao.SysAppVersionDao;
import com.codi.superman.base.domain.SysApp;
import com.codi.superman.base.domain.SysAppVersion;
import com.codi.superman.base.service.SysAppService;
import com.codi.superman.base.service.SysAppVersionService;

@Transactional
@Service
public class AppDataMigrationServiceImpl implements AppDataMigrationService {
	
	@Autowired
	private AppVersionInfoDao aviDao;
	
	@Autowired
	private SysAppDao saDao;
	
	@Autowired
	private SysAppService saService;
	
	@Autowired
	private SysAppVersionService savService;
	
	@Autowired
	private SysAppVersionDao savDao;
	
//	@PostConstruct
	public void init() throws BaseAppException{
		if (contains("com.codiwealth") && contains("com.cd121.CodiFund")) {
			return;
		}
		migrationApps();
		migrationVersions();
	}

	@Override
	public void migrationApps() {
		//1:ANDROID 2:IOS 3:WINPHONE
		//A:在用 X:已废弃
		createAndroid();
		createIOS();
	}

	@Override
	public void migrationVersions() throws BaseAppException {
		List<SysApp> all = saService.queryApps();
		Map<String, SysApp> appMap = new HashMap<>();
		for (SysApp sysApp : all) {
			appMap.put(sysApp.getAppCode(), sysApp);
		}
		List<AppVersionInfo> avis = aviDao.findList("com.codi.bus.core.dao.AppVersionInfoMapper.findAll");
		Collections.sort(avis, new Comparator<AppVersionInfo>() {

			@Override
			public int compare(AppVersionInfo o1, AppVersionInfo o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});
		for (AppVersionInfo avi : avis) {
			String appCode = avi.getAppIdentifier();
			String version = avi.getVersion();
			SysAppVersion sav = savService.queryVersionByAppCode(appCode, version);
			if (sav == null) {
				sav = new SysAppVersion();
				sav.setAppId(appMap.get(avi.getAppIdentifier()).getAppId());
				sav.setCreateDate(new Date());
				sav.setDownloadPath(avi.getDownloadPath());
				sav.setForceUpdate(avi.getNeedForeceUpdate());
				//A:生效 X:失效
				sav.setState("A");
				sav.setUpdateDate(new Date());
				sav.setVersionDesc(avi.getReleaseNotes());
				sav.setVersionNumber(avi.getVersion());
				savDao.insert(sav);
			}
		}
	}
	
	private boolean contains(String appCode){
		List<SysApp> all;
		try {
			all = saService.queryApps();
		} catch (BaseAppException e) {
			throw new RuntimeException(e);
		}
		for (SysApp sysApp : all) {
			if (sysApp.getAppCode().equals(appCode)) {
				return true;
			}
		}
		return false;
	}
	
	private void createAndroid(){
		String fundAndroid = "com.codiwealth";
		if (contains(fundAndroid)) {
			return;
		}
		SysApp android = new SysApp();
		android.setAppCode(fundAndroid);
		android.setAppName("公募基金安卓客户端");
		android.setAppSecret(MD5.MD5Encode(fundAndroid));
		android.setAppType(1);
		android.setCreateDate(new Date());
		android.setDescription("公募基金安卓客户端");
		android.setState("A");
		android.setUpdateDate(new Date());
		saDao.insert(android);
	}
	
	private void createIOS(){
		String fundIos = "com.cd121.CodiFund";
		if (contains(fundIos)) {
			return;
		}
		SysApp ios = new SysApp();
		ios.setAppCode(fundIos);
		ios.setAppName("公募基金IOS客户端");
		ios.setAppSecret(MD5.MD5Encode(fundIos));
		ios.setAppType(2);
		ios.setCreateDate(new Date());
		ios.setDescription("公募基金IOS客户端");
		ios.setState("A");
		ios.setUpdateDate(new Date());
		saDao.insert(ios);
	}

}
