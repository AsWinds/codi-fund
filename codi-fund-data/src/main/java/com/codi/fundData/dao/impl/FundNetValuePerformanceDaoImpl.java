package com.codi.fundData.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.base.exception.BaseAppException;
import com.codi.base.util.EqualsUtil;
import com.codi.fundData.dao.FundNetValuePerformanceDao;
import com.codi.fundData.domain.FundNetValuePerformance;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 上午10:56:15
 */
@Repository("fundNetValuePerformaceDao")
public class FundNetValuePerformanceDaoImpl extends BaseDAOImpl<FundNetValuePerformance> implements
        FundNetValuePerformanceDao {

    @Override
    public FundNetValuePerformance select(FundNetValuePerformance record) {
        return this.getObject(generateStatement("select"), record);
    }

    @Override
    public FundNetValuePerformance selectLatest(Integer innerCode) {
        return this.getObject(generateStatement("selectLatest"), innerCode);
    }

    @Override
    public List<Map<String, Object>> selectSort(List<Integer> innerCodes, Integer statisType, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException {

        Map<String, Object> param = new HashMap<>();
        param.put("innerCodes", innerCodes);
        param.put("tradingDay", tradingDay);
        param.put("statisType", statisType);
        param.put("sort", sort);

        if (EqualsUtil.equals(pageIndex.intValue(), 0) && EqualsUtil.equals(pageSize.intValue(), 0)) {

        } else {
            PageView pageView = getPageView(pageIndex, pageSize);
            param.put("pageView", pageView);
        }

        return getSqlSession().selectList(generateStatement("selectBySort"), param);
    }

}
