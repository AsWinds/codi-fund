package com.codi.fundData.dao;

import java.util.Map;

import com.codi.fundData.domain.FundArchivesAttach;

/**
 * 基金概况表
 * 
 * @author shi.pengyan
 * @date 2016年10月14日 下午1:55:09
 */
public interface FundArchivesAttachDao {
    
    FundArchivesAttach select(Map<String, Object> param);

}