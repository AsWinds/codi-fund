package com.codi.fundData.dao;

import com.codi.fundData.domain.FundRating;

/**
 * 基金评级
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:54:21
 */
public interface FundRatingDao {
    /**
     * 基金评级
     * 
     * @param innerCode
     *            内部编码
     * @return
     */
    FundRating selectFundRatingByInnerCode(Integer innerCode);
}