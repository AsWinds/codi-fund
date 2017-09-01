package com.codi.api.util;

import com.codi.bus.util.IdCardUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-19 14:37
 */
@Slf4j
public class IdCardUtilTest {
    @Test
    public void run() {
        getBirthday("320902198812016079");
        getBirthday("130503670401001");
    }

    private void getBirthday(String idCard) {
        log.debug("birthday={}", IdCardUtil.getBirthday(idCard));
    }

}
