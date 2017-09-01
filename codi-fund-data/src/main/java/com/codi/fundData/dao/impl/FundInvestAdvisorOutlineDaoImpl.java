package com.codi.fundData.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundInvestAdvisorOutlineDao;
import com.codi.fundData.domain.FundInvestAdvisorOutline;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:58:06
 */
@Repository("fundInvestAdvisorOutlineDao")
public class FundInvestAdvisorOutlineDaoImpl extends BaseDAOImpl<FundInvestAdvisorOutline> implements
        FundInvestAdvisorOutlineDao {

    @Override
    public FundInvestAdvisorOutline selectFundInvestAdvisor(Integer InvestAdvisorCode) {
        return this.getObject(generateStatement("selectInvestAdvisorOutline"), InvestAdvisorCode);
    }

}
