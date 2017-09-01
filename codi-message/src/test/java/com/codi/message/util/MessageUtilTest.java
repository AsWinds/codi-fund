package com.codi.message.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.codi.message.constant.ErrorConstant;

/**
 * MessageUtil test
 * 
 * @author shi.pengyan
 * @date 2016年9月26日 下午3:32:50
 */
public class MessageUtilTest {

    @Test
    public void getMsgTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("0", "xxxx");
        String msg = MessageUtil.getErrorMessage(ErrorConstant.ERROR_FUND_NOT_EXIST, map);

        System.out.println(msg);
    }

    @Test
    public void getErrorMsgTest() {
        String msg = MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, "1234");
        System.out.println(msg);
    }
}
