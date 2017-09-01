package com.codi.fundData.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.codi.base.dataSource.annotation.DataSource;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.constant.GlobalConstant;
import com.codi.fundData.dao.FundRatingDao;
import com.codi.fundData.domain.FundRating;
import com.codi.fundData.service.FundRatingService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午4:57:22
 */
@Service("fundRatingService")
public class FundRatingServiceImpl implements FundRatingService {

    @Resource(name = "fundRatingDao")
    private FundRatingDao fundRatingDao;

    @Override
    @DataSource(GlobalConstant.DATA_SOURCE_FUND_DETAIL)
    public FundRating queryFundRatingByInnerCode(Integer innerCode) throws BaseAppException {
        return fundRatingDao.selectFundRatingByInnerCode(innerCode);
    }

}
