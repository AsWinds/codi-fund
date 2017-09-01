package com.codi.fundData.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundQDIIPortfolioIndustry;

/**
 * QDII类型基金行业分布
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午4:20:52
 */
public interface FundQDIIPortfolioIndustryDao extends BaseDAO<FundQDIIPortfolioIndustry> {

    /**
     * 查询最新
     * @param innerCode
     * @return
     */
    List<FundQDIIPortfolioIndustry> selectLatest(int innerCode);

}