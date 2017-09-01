package com.codi.fundData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundCodeRelationshipDao;
import com.codi.fundData.domain.FundCodeRelationship;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月23日 上午9:48:04
 */
@Repository("fundCodeRelationshipDao")
public class FundCodeRelationshipDaoImpl extends BaseDAOImpl<FundCodeRelationship> implements FundCodeRelationshipDao {

    @Override
    public List<FundCodeRelationship> queryCodeRelationships(Integer relatedInnerCode, Integer codeDefine,
            Integer ifEffected) {
        Map<String, Object> param = new HashMap<>();
        param.put("relatedInnerCode", relatedInnerCode);
        param.put("codeDefine", codeDefine);
        param.put("ifEffected", ifEffected);

        return this.findList(generateStatement("queryCodeRelationships"), param);
    }

}
