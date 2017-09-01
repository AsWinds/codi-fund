package com.codi.fundData.service;

import com.codi.base.exception.BaseAppException;
import com.codi.fundData.domain.FundRating;

/**
 * 基金评级
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午4:55:18
 */
public interface FundRatingService {

    /**
     * 查询基金评级
     * 
     * @param innerCode
     *            基金内部编码
     * @return
     * @throws BaseAppException
     */
    FundRating queryFundRatingByInnerCode(Integer innerCode) throws BaseAppException;
}
