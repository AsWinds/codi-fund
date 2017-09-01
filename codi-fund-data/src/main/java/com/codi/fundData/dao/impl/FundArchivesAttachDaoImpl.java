package com.codi.fundData.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundArchivesAttachDao;
import com.codi.fundData.domain.FundArchivesAttach;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月14日 下午1:55:56
 */
@Repository("fundArchivesAttachDao")
public class FundArchivesAttachDaoImpl extends BaseDAOImpl<FundArchivesAttach> implements FundArchivesAttachDao {

    @Override
    public FundArchivesAttach select(Map<String, Object> param) {
        return this.getObject(generateStatement("selectFundArchivesAttach"), param);
    }

}
