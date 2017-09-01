package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.base.util.EqualsUtil;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.service.BankService;
import com.codi.bus.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 16:46
 */
@Slf4j
public class AcctTest extends BaseHundSunTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;


    @Test
    public void open() {
        Long userId = 68L;
        User user = userService.getUser(userId);
        user.setTradePassword("654321");//模拟密码

        List<UserBank> banks = bankService.getListByUserId(userId);

        //选出招行
        UserBank userBank = null;
        for (int i = 0; i < banks.size(); i++) {
            UserBank bank = banks.get(i);
            if (EqualsUtil.equals(bank.getBankCode(), "CMB")) {
                userBank = bank;
                break;
            }
        }

        userService.openAccount(user, userBank);
    }

}
