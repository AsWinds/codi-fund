package com.codi.api.service;

import com.codi.api.BaseTest;
import com.codi.bus.core.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-21 15:59
 */
@Slf4j
public class UserProfileTest extends BaseTest {

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void run() {
        userProfileService.updateUserRiskLevelExpireTime(260L, "20160901");
    }
}
