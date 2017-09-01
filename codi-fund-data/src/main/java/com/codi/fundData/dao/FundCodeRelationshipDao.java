package com.codi.fundData.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundCodeRelationship;

/**
 * 基金编码关联DAO
 * 
 * @author shi.pengyan
 * @date 2016年11月23日 上午9:48:54
 */
public interface FundCodeRelationshipDao extends BaseDAO<FundCodeRelationship> {

    /** 生效 **/
    static int EFFECT_YES = 1;

    /** 失效 **/
    static int EFFECT_NO = 2;

    /**
     * 根据从编码查询主编码，可能会有多个
     * 
     * @param relatedInnerCode
     *            从编码
     * @param ifEffected
     *            是否有效
     * @return
     */
    List<FundCodeRelationship> queryCodeRelationships(Integer relatedInnerCode, Integer codeDefine, Integer ifEffected);
}