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
import com.codi.fundData.dao.FundNetValueDao;
import com.codi.fundData.domain.FundNetValue;
import com.codi.fundData.service.FundNetValueService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 下午2:58:19
 */
@Service("fundNetValueService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class FundNetValueServiceImpl implements FundNetValueService {

    @Resource(name = "fundNetValueDao")
    private FundNetValueDao fundNetValueDao;

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public FundNetValue selectLatest(Integer innerCode) throws BaseAppException {
        return fundNetValueDao.selectLatest(innerCode);
    }

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public List<Map<String, Object>> selectSort(List<Integer> innerCodes, boolean isCurrency, Date tradingDay,
            Integer pageIndex, Integer pageSize, Integer sort) throws BaseAppException {
        return fundNetValueDao.selectSort(innerCodes, isCurrency, tradingDay, pageIndex, pageSize, sort);
    }
}
