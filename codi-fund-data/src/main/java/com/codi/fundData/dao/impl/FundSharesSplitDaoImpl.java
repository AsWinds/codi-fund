package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundSharesSplitDao;
import com.codi.fundData.domain.FundSharesSplit;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 下午1:41:19
 */
@Repository("fundSharesSplitDao")
public class FundSharesSplitDaoImpl extends BaseDAOImpl<FundSharesSplit> implements FundSharesSplitDao {

    @Override
    public List<FundSharesSplit> select(Map<String, Object> record) {
        return this.findList(generateStatement("selectFundSharesSplitList"), record);
    }

}
