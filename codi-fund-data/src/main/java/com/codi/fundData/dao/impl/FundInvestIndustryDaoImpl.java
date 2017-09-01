package com.codi.fundData.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundInvestIndustryDao;
import com.codi.fundData.domain.FundInvestIndustry;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午4:06:43
 */
@Repository("fundInvestIndustryDao")
public class FundInvestIndustryDaoImpl extends BaseDAOImpl<FundInvestIndustry> implements FundInvestIndustryDao {

    public List<FundInvestIndustry> selectLatest(int innerCode) {
        return this.findList(generateStatement("selectLatest"), innerCode);
    }

}
