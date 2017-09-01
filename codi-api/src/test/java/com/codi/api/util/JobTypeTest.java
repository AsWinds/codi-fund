package com.codi.api.util;

import com.codi.fcloud.ufx.constant.JobType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-26 14:23
 */
@Slf4j
public class JobTypeTest {

    @Test
    public void run() {

        String index = "1";
        log.debug("{}={}", index, JobType.getLabelByIndex(index));


        log.debug("{}", JobType.Educational);

        String label = "政府部门";
        log.debug("{}={}", JobType.getIndexByLabel(label), label);

    }
}
