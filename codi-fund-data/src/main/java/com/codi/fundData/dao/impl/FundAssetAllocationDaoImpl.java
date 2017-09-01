package com.codi.fundData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundAssetAllocationDao;
import com.codi.fundData.domain.FundAssetAllocation;

/**
 * 基金资产配置
 * 
 * @author shi.pengyan
 * @date 2016年10月10日 下午1:56:10
 */
@Repository("fundAssetAllocationDao")
public class FundAssetAllocationDaoImpl extends BaseDAOImpl<FundAssetAllocation> implements FundAssetAllocationDao {

    @Override
    public FundAssetAllocation select(FundAssetAllocation record) {
        return this.getObject(generateStatement("selectLatestAssetAllocation"), record);
    }

    @Override
    public List<FundAssetAllocation> selectList(int innerCode, List<Integer> assetTypeCodes) {
        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("assetTypeCodes", assetTypeCodes);

        return this.findList(generateStatement("selectAssetAllocationList"), param);
    }

}
