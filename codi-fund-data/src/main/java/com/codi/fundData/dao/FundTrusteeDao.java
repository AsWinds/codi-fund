package com.codi.fundData.dao;

import com.codi.fundData.domain.FundTrustee;

/**
 * 基金托管人
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:55:43
 */
public interface FundTrusteeDao {

    /**
     * 查询
     * 
     * @param trusteeCode
     *            托管人编码
     * @return
     */
    FundTrustee select(Integer trusteeCode);
}