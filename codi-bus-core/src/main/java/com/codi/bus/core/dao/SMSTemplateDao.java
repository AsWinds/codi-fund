package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.SMSTemplate;

public interface SMSTemplateDao extends BaseDAO<SMSTemplate> {
	SMSTemplate getEntityByTemplateCode(String templateCode);
}