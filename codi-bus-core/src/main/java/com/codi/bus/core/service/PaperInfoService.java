package com.codi.bus.core.service;

import com.codi.bus.core.resultModel.PaperInfoQuestion;
import com.codi.bus.core.resultModel.PaperInfoQuestionRequest;
import com.codi.bus.core.resultModel.PaperInfoTestResult;

import java.util.List;

public interface PaperInfoService {

    List<PaperInfoQuestion> queryPaperInfoQuestions(PaperInfoQuestionRequest request);

    /**
     * 获取风险问卷试题 （包含诚信和非诚信）
     *
     * @param request
     * @return
     * @author shi.pengyan
     * @date 2017-6-21 14:13:02
     */
    List<PaperInfoQuestion> queryPaperInfoQuestionsNew(PaperInfoQuestionRequest request);

    PaperInfoTestResult getUserPaperInfoTestResult(Long user_id, String password);

    PaperInfoTestResult addOrModifyPaperInfoAcct(Long user_id, String elig_content, String invest_risk_tolerance);

    PaperInfoTestResult addDefaultTestResult(Long user_id);
}
