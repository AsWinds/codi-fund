package com.codi.bus.core.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.BaseTest;
import com.codi.bus.core.resultModel.WalletDetailResult;

/**
 * 
 * @author shi.pengyan
 * @date 2016年12月12日 下午3:03:37
 */
public class WalletServiceTest extends BaseTest {
    @Autowired
    private WalletService walletService;

    @Test
    public void getDetailTest() throws BaseAppException {
        String token = "bdf77df6_920d_4048_88fd_81bb6baaefd7";
        String deviceId = "352089076210290";
        WalletDetailResult result = walletService.getWalletDetail(token, deviceId);
        System.out.println(result);
    }
}
