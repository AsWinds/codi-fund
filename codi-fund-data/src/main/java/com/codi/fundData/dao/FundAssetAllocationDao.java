package com.codi.fundData.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundAssetAllocation;

/**
 * 基金的资产配置
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午5:52:46
 */
public interface FundAssetAllocationDao extends BaseDAO<FundAssetAllocation> {

    /**
     * 查询基金的资产配置
     * 
     * @param record
     * @return
     */
    FundAssetAllocation select(FundAssetAllocation record);

    /**
     * 查询基金的资产配置组合
     * 
     * @param innerCode
     *            基金内部编码
     * @param assetTypeCodes
     *            查询指定类型的资产
     * @return
     */
    List<FundAssetAllocation> selectList(int innerCode, List<Integer> assetTypeCodes);
}