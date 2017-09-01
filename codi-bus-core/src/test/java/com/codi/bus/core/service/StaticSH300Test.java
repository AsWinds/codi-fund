package com.codi.bus.core.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.BaseTest;
import com.codi.bus.core.service.model.FundStatisticModel;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月3日 下午1:09:04
 */
public class StaticSH300Test extends BaseTest {

    @Resource(name = "staticSH300Service")
    private StaticSH300Service staticSH300Service;

    @Test
    public void deleteAllTest() throws BaseAppException {
        staticSH300Service.clearAll();
    }

    @Test
    public void insertAllTest() throws BaseAppException {
        staticSH300Service.addAll();
    }

    @Test
    public void insertLatestTest() throws BaseAppException {
        staticSH300Service.addLatestData();
    }

    @Test
    public void getSingleMonthTest() throws BaseAppException {
        Date endDate = new Date();
        List<FundStatisticModel> result = staticSH300Service.getStatisticData(1, endDate);
        System.out.println(result);
    }
}
