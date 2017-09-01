package com.codi.api.service;

import com.codi.api.BaseTest;
import com.codi.bus.core.resultModel.PaperInfoTestResult;
import com.codi.bus.core.service.PaperInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-21 16:55
 */
@Slf4j
public class PaperInfoServiceTest extends BaseTest {

    @Autowired
    private PaperInfoService paperInfoService;

    @Test
    public void run() {
        PaperInfoTestResult result = paperInfoService.addDefaultTestResult(260L);
        log.debug("result={}", result);
    }

}
