package com.codi.api.hundsun.paperInfo;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.bus.core.resultModel.PaperInfoQuestion;
import com.codi.bus.core.service.PaperInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 风险测评
 *
 * @author shi.pengyan
 * @date 2017-06-21 10:42
 */
@Slf4j
public class PaperInfoTest extends BaseHundSunTest {

    @Autowired
    private PaperInfoService paperInfoService;


    @Test
    public void run() {
        List<PaperInfoQuestion> list = paperInfoService.queryPaperInfoQuestions(null);
        if (list != null) {
            for (PaperInfoQuestion question : list) {
                log.debug("question={}", question);
            }
        }
    }

    @Test
    public void run2() {
        List<PaperInfoQuestion> list = paperInfoService.queryPaperInfoQuestionsNew(null);
        if (list != null) {
            for (PaperInfoQuestion question : list) {
                log.debug("question={}", question);
            }
        }
    }
}
