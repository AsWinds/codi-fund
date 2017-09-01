package com.codi.bus.core.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.dao.StaticSH300Dao;
import com.codi.bus.core.domain.StaticSH300;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月3日 上午9:49:00
 */
@Repository("staticSH300Dao")
public class StaticSH300DaoImpl extends BaseDAOImpl<StaticSH300> implements StaticSH300Dao {

    @Override
    public int insert(StaticSH300 record) throws BaseAppException {
        return insert(generateStatement("insert"), record);
    }

    @Override
    public int insertByBatch(List<StaticSH300> list) throws BaseAppException {
        return this.insert(generateStatement("insertByBatch"), list);
    }

    @Override
    public int deleteAll() throws BaseAppException {
        return this.delete(generateStatement("deleteAll"));
    }

    @Override
    public StaticSH300 selectLatest() throws BaseAppException {
        return this.getObject(generateStatement("selectLatest"));
    }

    @Override
    public List<StaticSH300> select(Date beginDate, Date endDate) throws BaseAppException {
        Map<String, Object> p = new HashMap<>();
        p.put("beginDate", beginDate);
        p.put("endDate", endDate);

        return this.findList(generateStatement("select"), p);
    }

    @Override
    public StaticSH300 select(Date tradingDate) throws BaseAppException {
        return this.getObject(generateStatement("selectByTradingDate"), tradingDate);
    }

}
