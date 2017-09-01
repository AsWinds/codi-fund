package com.codi.fundData.dao.impl;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundRatingDao;
import com.codi.fundData.domain.FundRating;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月4日 下午11:30:07
 */
@Repository("fundRatingDao")
public class FundRatingDaoImpl extends BaseDAOImpl<FundRating> implements FundRatingDao {

    @Override
    public FundRating selectFundRatingByInnerCode(Integer innerCode) {
        return this.getObject(generateStatement("selectLatest"), innerCode);
    }

}
