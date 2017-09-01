package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.fundData.domain.FundSharesSplit;

/**
 * 拆分
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:55:01
 */
public interface FundSharesSplitDao {

    /**
     * 查询
     * 
     * @param record
     *            类型
     * @return
     */
    List<FundSharesSplit> select(Map<String, Object> record);
}