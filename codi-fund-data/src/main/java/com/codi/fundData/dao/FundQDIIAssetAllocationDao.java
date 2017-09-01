package com.codi.fundData.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundQDIIAssetAllocation;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:51:16
 */
public interface FundQDIIAssetAllocationDao extends BaseDAO<FundQDIIAssetAllocation> {

    /**
     * 查询基金的资产配置
     * 
     * @param record
     * @return
     */
    FundQDIIAssetAllocation select(FundQDIIAssetAllocation record);

    /**
     * 查询基金的资产配置组合
     * 
     * @param innerCode
     *            基金内部编码
     * @param assetTypeCodes
     *            查询指定类型的资产
     * @return
     */
    List<FundQDIIAssetAllocation> selectList(int innerCode, List<Integer> assetTypeCodes);
}