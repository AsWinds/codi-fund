package com.codi.fundData.service;

import java.util.List;

import com.codi.fundData.domain.FundCodeRelationship;

/**
 * 基金代码关联表
 * 
 * @author shi.pengyan
 * @date 2016年11月23日 上午10:23:40
 */
public interface FundCodeRelationshipService {

    /**
     * 根据从编码查询主编码
     * 
     * @param relatedInnerCode
     *            内部编码
     * @param ifEffected
     *            是否生效
     * @return
     */
    List<FundCodeRelationship> getCodeRelationships(Integer relatedInnerCode, Integer ifEffected);

    /**
     * 刷新Cache中的数据
     */
    void refreshCodeRelationshipCache(Integer innerCode);
}
