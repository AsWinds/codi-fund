package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundManagerDao;
import com.codi.fundData.domain.FundManager;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月9日 上午10:56:48
 */
@Repository("fundManagerDao")
public class FundManagerDaoImpl extends BaseDAOImpl<FundManager> implements FundManagerDao {

    @Override
    public List<FundManager> selectManagers(FundManager record) {
        return this.findList(generateStatement("selectManager"), record);
    }

    @Override
    public FundManager selectManager(FundManager record) {
        return this.getObject(generateStatement("selectManager"), record);
    }

    @Override
    public List<Map<String, Object>> queryManagerPerformance(Map<String, Object> param) {
        return getSqlSession().selectList(generateStatement("selectManagerPerformance"), param);
    }
}
