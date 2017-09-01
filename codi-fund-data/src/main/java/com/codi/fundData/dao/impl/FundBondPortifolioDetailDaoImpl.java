package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundBondPortifolioDetailDao;
import com.codi.fundData.domain.FundBondPortifolioDetail;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:58:53
 */
@Repository("fundBondPortifolioDetailDao")
public class FundBondPortifolioDetailDaoImpl extends BaseDAOImpl<FundBondPortifolioDetail> implements
        FundBondPortifolioDetailDao {

    @Override
    public List<Map<String, Object>> selectLatest(int innerCode) {
        return getSqlSession().selectList(generateStatement("selectLatest"), innerCode);
    }
}
