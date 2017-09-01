package com.codi.fundData.dao;

import com.codi.fundData.domain.FundInvestAdvisorOutline;

/**
 * 基金管理人
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:52:37
 */
public interface FundInvestAdvisorOutlineDao {

    FundInvestAdvisorOutline selectFundInvestAdvisor(Integer InvestAdvisorCode);
}