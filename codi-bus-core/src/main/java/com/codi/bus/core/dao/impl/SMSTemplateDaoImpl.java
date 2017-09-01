package com.codi.bus.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.SMSTemplateDao;
import com.codi.bus.core.domain.SMSTemplate;

@Repository("smsTemplateDao")
public class SMSTemplateDaoImpl extends BaseDAOImpl<SMSTemplate> implements SMSTemplateDao {

	@Override
	public SMSTemplate getEntityByTemplateCode(String templateCode) {
		//返回使用中、未删除的一条记录
		return this.getObject(SMSTemplate.class.getName() + ".selectByTemplateCode", templateCode);
	}

}
