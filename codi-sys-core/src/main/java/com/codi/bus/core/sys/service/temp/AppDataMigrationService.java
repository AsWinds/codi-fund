package com.codi.bus.core.sys.service.temp;

import com.codi.base.exception.BaseAppException;

public interface AppDataMigrationService {
	
	void migrationApps() throws BaseAppException;
	
	void migrationVersions() throws BaseAppException;

}
