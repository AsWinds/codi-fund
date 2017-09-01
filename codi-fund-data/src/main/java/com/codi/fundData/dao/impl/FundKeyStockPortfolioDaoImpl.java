package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundKeyStockPortfolioDao;
import com.codi.fundData.domain.FundKeyStockPortfolio;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 上午10:00:31
 */
@Repository("fundKeyStockPortfolioDao")
public class FundKeyStockPortfolioDaoImpl extends BaseDAOImpl<FundKeyStockPortfolio> implements
        FundKeyStockPortfolioDao {

    @Override
    public List<Map<String, Object>> selectLatest(int innerCode) {
        return getSqlSession().selectList(generateStatement("selectLatest"), innerCode);
    }

}
