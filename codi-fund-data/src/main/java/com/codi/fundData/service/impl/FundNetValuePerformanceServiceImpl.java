package com.codi.fundData.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.dataSource.annotation.DataSource;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.constant.GlobalConstant;
import com.codi.fundData.dao.FundNetValuePerformanceDao;
import com.codi.fundData.domain.FundNetValuePerformance;
import com.codi.fundData.service.FundNetValuePerformanceService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 下午2:58:51
 */
@Service("fundNetValuePerformanceService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class FundNetValuePerformanceServiceImpl implements FundNetValuePerformanceService {

    @Resource(name = "fundNetValuePerformaceDao")
    private FundNetValuePerformanceDao fundNetValuePerformaceDao;

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public FundNetValuePerformance selectLatest(Integer innerCode) throws BaseAppException {
        return fundNetValuePerformaceDao.selectLatest(innerCode);
    }

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public List<Map<String, Object>> selectSort(List<Integer> innerCodes, Integer statisType, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException {
        return fundNetValuePerformaceDao.selectSort(innerCodes, statisType, tradingDay, pageIndex, pageSize, sort);
    }

}
