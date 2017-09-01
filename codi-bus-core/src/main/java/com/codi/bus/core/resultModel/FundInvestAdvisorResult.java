package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundInvestAdvisorFundModel;

/**
 * 基金管理人相关资料返回值
 * 
 * @author shi.pengyan
 * @date 2016年10月27日 上午10:02:02
 */
public class FundInvestAdvisorResult extends BaseResult {
    private static final long serialVersionUID = 1L;

    private String background; // 背景介绍
    private List<FundInvestAdvisorFundModel> funds; // 管理的基金列表

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<FundInvestAdvisorFundModel> getFunds() {
        return funds;
    }

    public void setFunds(List<FundInvestAdvisorFundModel> funds) {
        this.funds = funds;
    }

}
