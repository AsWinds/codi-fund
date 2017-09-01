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
import com.codi.fundData.dao.FundNetValueDao;
import com.codi.fundData.domain.FundNetValue;

@Repository("fundNetValueDao")
public class FundNetValueDaoImpl extends BaseDAOImpl<FundNetValue> implements FundNetValueDao {

    @Override
    public FundNetValue selectFundNetValue(FundNetValue fundNetValue) {
        return this.getObject(generateStatement("selectLatestNetValue"), fundNetValue);
    }

    @Override
    public List<FundNetValue> selectFundNetValue(Integer innerCode, Integer pageIndex, Integer pageSize, Integer sort) {
        PageView pageView = getPageView(pageIndex, pageSize);

        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("pageView", pageView);
        param.put("sort", sort);

        return this.findList(generateStatement("selectNetValue"), param);
    }

    @Override
    public FundNetValue selectLatest(Integer innerCode) throws BaseAppException {
        return this.getObject(generateStatement("selectLatest"), innerCode);
    }

    @Override
    public List<FundNetValue> select(Integer innerCode, Date beginDate, Date endDate) throws BaseAppException {
        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("beginDate", beginDate);
        param.put("endDate", endDate);

        // 查询统计数据表
        return this.findList(generateStatement("selectStatic"), param);
    }

    @Override
    public List<Map<String, Object>> selectSort(List<Integer> innerCodes, boolean isCurrency, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) {
        Map<String, Object> param = new HashMap<>();
        param.put("innerCodes", innerCodes);
        param.put("tradingDay", tradingDay);
        param.put("sort", sort);
        param.put("isCurrency", isCurrency);

        if (EqualsUtil.equals(pageIndex.intValue(), 0) && EqualsUtil.equals(pageSize.intValue(), 0)) {

        } else {
            PageView pageView = getPageView(pageIndex, pageSize);
            param.put("pageView", pageView);
        }

        return getSqlSession().selectList(generateStatement("selectBySort"), param);
    }

    @Override
    public List<Map<String, Object>> selectSortOrderyByNotSameDay(List<Integer> innerCodes, boolean isCurrency,
            Date tradingDay, Integer pageIndex, Integer pageSize, Integer sort) {
        Map<String, Object> param = new HashMap<>();
        param.put("innerCodes", innerCodes);
        param.put("tradingDay", tradingDay);
        param.put("sort", sort);
        param.put("isCurrency", isCurrency);

        if (EqualsUtil.equals(pageIndex.intValue(), 0) && EqualsUtil.equals(pageSize.intValue(), 0)) {

        } else {
            PageView pageView = getPageView(pageIndex, pageSize);
            param.put("pageView", pageView);
        }

        return getSqlSession().selectList(generateStatement("selectBySort"), param);
    }

}
