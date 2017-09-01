package com.codi.fundData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.fundData.dao.FundDetailDao;
import com.codi.fundData.domain.FundDetail;

@Repository("fundDetailDao")
public class FundDetailDaoImpl extends BaseDAOImpl<FundDetail> implements FundDetailDao {

    @Override
    public FundDetail queryFundDetail(Integer innerCode) {

        return this.getObject(generateStatement("selectFundDetail"), innerCode);
    }

    @Override
    public FundDetail queryByFundCode(String fundCode) {
        return this.getObject(generateStatement("selectFundDetailByFundCode"), fundCode);
    }

    @Override
    public List<Map<String, Object>> queryByInvestAdvisorCode(int investAdvisorCode, int pageIndex, int pageSize) {
        PageView pageView = getPageView(pageIndex, pageSize);
        Map<String, Object> param = new HashMap<>();
        param.put("pageView", pageView);
        param.put("investAdvisorCode", investAdvisorCode);
        return getSqlSession().selectList(generateStatement("selectFundByInvestAdvisorCode"), param);
    }
}
