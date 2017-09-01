package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundQDIIPortfolioDetailDao;
import com.codi.fundData.domain.FundQDIIPortfolioDetail;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 上午10:40:34
 */
@Repository("fundQDIIPortfolioDetailDao")
public class FundQDIIPortfolioDetailDaoImpl extends BaseDAOImpl<FundQDIIPortfolioDetail> implements
        FundQDIIPortfolioDetailDao {

    @Override
    public List<Map<String, Object>> selectLatest(int innerCode) {
        return getSqlSession().selectList(generateStatement("selectLatest"), innerCode);
    }

}
