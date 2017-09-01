package com.codi.bus.core.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.codi.bus.constant.FundConst;
import com.codi.bus.core.BaseTest;
import com.codi.bus.core.domain.FundInfo;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月15日 下午2:20:20
 */
public class FundInfoServiceTest extends BaseTest {

    @Autowired
    private FundInfoService fundInfoService;

    @Test
    public void test() {
        List<Integer> fundTypeCodes = new ArrayList<>(5);
        fundTypeCodes.add(FundConst.FUND_TYPE_CODE_STOCK);
        fundTypeCodes.add(FundConst.FUND_TYPE_CODE_MIXIN);
        fundTypeCodes.add(FundConst.FUND_TYPE_CODE_BOND);
        fundTypeCodes.add(FundConst.FUND_TYPE_CODE_GUARANTEE);
        fundTypeCodes.add(FundConst.FUND_TYPE_CODE_QDII);

        List<FundInfo> fundInfos = fundInfoService.queryFundInfoByTypes(fundTypeCodes);
        System.out.println(JSON.toJSONString(fundInfos, true));
    }

}
