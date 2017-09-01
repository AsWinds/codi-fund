package com.codi.api.hundsun.query;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.trade.service.SystemParameterQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @version 1.0 2017-07-05 13:55
 * @since 1.0
 */
@Slf4j
public class SystemParameterQueryTest extends BaseHundSunTest {


    @Autowired
    SystemParameterQueryService systemParameterQueryService;

    @Test
    public void run() {
        Map<String, Object> map = systemParameterQueryService.query(HsConst.SYS_PARAM_RISK_QUESTION_VALID_DAY_FOR_PERSON);

        log2(map);
    }
}
