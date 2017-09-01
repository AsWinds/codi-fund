package com.codi.fundData.dao;

import com.codi.fundData.domain.FundPersonInfo;

/**
 * 基金从业人员
 * @author shi.pengyan
 * @date 2016年10月17日 上午9:57:29
 */
public interface FundPersonInfoDao {

    FundPersonInfo select(FundPersonInfo record);
}