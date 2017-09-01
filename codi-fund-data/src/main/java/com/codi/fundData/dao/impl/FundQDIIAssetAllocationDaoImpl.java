package com.codi.fundData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.fundData.dao.FundQDIIAssetAllocationDao;
import com.codi.fundData.domain.FundQDIIAssetAllocation;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午3:51:36
 */
@Repository("fundQDIIAssetAllocationDao")
public class FundQDIIAssetAllocationDaoImpl extends BaseDAOImpl<FundQDIIAssetAllocation> implements
        FundQDIIAssetAllocationDao {

    @Override
    public FundQDIIAssetAllocation select(FundQDIIAssetAllocation record) {
        return this.getObject(generateStatement("selectLatestAssetAllocation"), record);
    }

    @Override
    public List<FundQDIIAssetAllocation> selectList(int innerCode, List<Integer> assetTypeCodes) {
        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("assetTypeCodes", assetTypeCodes);

        return this.findList(generateStatement("selectAssetAllocationList"), param);
    }

}
