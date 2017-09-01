package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.fundData.domain.FundManager;

public interface FundManagerDao {
    /**
     * 查询基金经理列表（在任期内，非任期内等等）
     * 
     * @param record
     * @return
     */
    List<FundManager> selectManagers(FundManager record);

    /**
     * 查询基金经理（在任期内，非任期内等等）
     * 
     * @param record
     * @return
     */
    FundManager selectManager(FundManager record);

    /**
     * 查询基金经理的业绩
     * 
     * @param param
     * @return
     */
    List<Map<String, Object>> queryManagerPerformance(Map<String, Object> param);
}