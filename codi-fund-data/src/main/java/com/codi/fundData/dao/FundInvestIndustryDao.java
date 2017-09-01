package com.codi.fundData.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundInvestIndustry;

/**
 * 基金行业投资
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午4:04:03
 */
public interface FundInvestIndustryDao extends BaseDAO<FundInvestIndustry> {

    /**
     * 选择最新的基金行业投资
     * 
     * @param innerCode
     * @return
     */
    List<FundInvestIndustry> selectLatest(int innerCode);
}