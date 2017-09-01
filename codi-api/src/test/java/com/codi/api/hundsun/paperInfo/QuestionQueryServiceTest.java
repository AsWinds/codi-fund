package com.codi.api.hundsun.paperInfo;

import com.alibaba.fastjson.JSON;
import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.trade.dto.QuestionQueryDto;
import com.codi.trade.service.paperinfo.QuestionQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-22 17:46
 */
@Slf4j
public class QuestionQueryServiceTest extends BaseHundSunTest {

    @Autowired
    private QuestionQueryService questionQueryService;

    @Test
    public void run() {

        QuestionQueryDto dto = new QuestionQueryDto();
        dto.setIntegrity_flag(HsConst.INTERGRITY_NO);

        List<Map<String, Object>> questions1 = questionQueryService.query(dto);

        log.debug("question size={}", questions1.size());
        log.debug("question ={}", JSON.toJSONString(questions1));

    }
}
