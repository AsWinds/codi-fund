package com.codi.fundData.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundDividendDao;
import com.codi.fundData.domain.FundDividend;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 上午10:30:30
 */
@Repository("fundDividendDao")
public class FundDividendDaoImpl extends BaseDAOImpl<FundDividend> implements FundDividendDao {

    @Override
    public List<FundDividend> select(Map<String, Object> record) {
        return this.findList(generateStatement("selectFundDividendList"), record);
    }

}
