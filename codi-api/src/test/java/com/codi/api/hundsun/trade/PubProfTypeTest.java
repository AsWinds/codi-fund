package com.codi.api.hundsun.trade;

import com.codi.fcloud.ufx.constant.PubProfType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-26 10:29
 */
@Slf4j
public class PubProfTypeTest {
    @Test
    public void testName() {
        log.debug("A={}", PubProfType.get("A"));

    }
}
