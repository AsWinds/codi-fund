package com.codi.bus.core.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.BaseTest;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.service.FundMMYieldPerformanceService;

/**
 * 
 * @author shi.pengyan
 * @date 2016年12月12日 下午2:57:07
 */
public class FundMMYieldPerformanceTest extends BaseTest {
    @Resource(name = "fundMMYieldPerformanceService")
    private FundMMYieldPerformanceService fundMMYieldPerformanceService;

    // @Autowired
    // private FundMMYieldPerformanceService fundMMYieldPerformanceService;

    @Test
    public void test() throws BaseAppException {

        FundMMYieldPerformance perf = fundMMYieldPerformanceService.getFundMMYieldPerformance(12754);
        System.out.println(perf);
    }

}
