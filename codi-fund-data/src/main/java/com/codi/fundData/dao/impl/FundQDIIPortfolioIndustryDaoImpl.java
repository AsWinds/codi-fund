package com.codi.fundData.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundQDIIPortfolioIndustryDao;
import com.codi.fundData.domain.FundQDIIPortfolioIndustry;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午4:19:48
 */
@Repository("fundQDIIPortfolioIndustryDao")
public class FundQDIIPortfolioIndustryDaoImpl extends BaseDAOImpl<FundQDIIPortfolioIndustry> implements
        FundQDIIPortfolioIndustryDao {

    @Override
    public List<FundQDIIPortfolioIndustry> selectLatest(int innerCode) {
        return this.findList(generateStatement("selectLatest"), innerCode);
    }

}
