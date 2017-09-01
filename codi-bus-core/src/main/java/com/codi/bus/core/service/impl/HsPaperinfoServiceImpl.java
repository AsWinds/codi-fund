package com.codi.bus.core.service.impl;

import com.codi.base.util.DateUtil;
import com.codi.base.util.DateUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.UserDao;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.resultModel.PaperInfoQuestion;
import com.codi.bus.core.resultModel.PaperInfoQuestion.QuestionSection;
import com.codi.bus.core.resultModel.PaperInfoQuestionRequest;
import com.codi.bus.core.resultModel.PaperInfoTestResult;
import com.codi.bus.core.service.PaperInfoService;
import com.codi.bus.core.service.UserPrivateequityService;
import com.codi.bus.core.service.UserProfileService;
import com.codi.fcloud.ufx.HsResponseUtil;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.fcloud.ufx.paperinfo.*;
import com.codi.trade.dto.QuestionQueryDto;
import com.codi.trade.service.paperinfo.QuestionQueryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service("paperinfoService")
@Transactional
public class HsPaperinfoServiceImpl implements PaperInfoService {

    private static final Logger logger = LoggerFactory.getLogger(HsPaperinfoServiceImpl.class);

    @Autowired
    private AnswerModify modifyAnswer;

    @Autowired
    private ResultQuery resultQuery;

    @Autowired
    private AnswerAdd addAnswer;

    @Autowired
    private QuestionQuery questionQuery;

    @Autowired
    private QuestionSectionQuery questionSectionQuery;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPrivateequityService privateequityService;

    // shi.pengyan 2017-6-21 14:14:29
    @Autowired
    private QuestionQueryService questionQueryService;

    @Autowired
    private UserProfileService userProfileService;


    @Override
    @Deprecated // shi.epngyan
    public List<PaperInfoQuestion> queryPaperInfoQuestions(PaperInfoQuestionRequest req) {
        //TODO parm req not used now
        List<Map<String, Object>> questions = questionQuery.getAllQuestions();
        List<Map<String, Object>> sections  = questionSectionQuery.getAllQuestionSections();

        List<PaperInfoQuestion>        res             = new ArrayList<>();
        Map<String, PaperInfoQuestion> question_no_map = new HashMap<>();
        for (Map<String, Object> question_map : questions) {
            PaperInfoQuestion question    = new PaperInfoQuestion();
            String            question_no = (String) question_map.get("question_no");
            if (StringUtils.isBlank(question_no)) {
                continue;
            }
            question.setQuestion_no(question_no);
            question.setQuestion_content(String.valueOf(question_map.get("question_content")));
            question.setAnswer_object(String.valueOf(question_map.get("answer_object")));
            question.setOrder_no(String.valueOf(question_map.get("order_no")));
            res.add(question);
            question_no_map.put(question_no, question);
        }

        for (Map<String, Object> section : sections) {
            String question_no = (String) section.get("question_no");
            if (!question_no_map.containsKey(question_no)) {
                continue;
            }
            PaperInfoQuestion     question          = question_no_map.get(question_no);
            List<QuestionSection> question_sections = question.getSections();
            if (question_sections == null) {
                question_sections = new ArrayList<>();
                question.setSections(question_sections);
            }
            QuestionSection qc = question.new QuestionSection();
            qc.setOption_content((String) section.get("option_content"));
            qc.setOption_no((String) section.get("option_no"));
            qc.setOption_score((String) section.get("option_score"));
            qc.setOrder_no((String) section.get("order_no"));
            question_sections.add(qc);
        }

        logger.info("all question size={}", res.size());
        return res;
    }

    @Override
    public List<PaperInfoQuestion> queryPaperInfoQuestionsNew(PaperInfoQuestionRequest request) {

        QuestionQueryDto dto = new QuestionQueryDto();
        dto.setIntegrity_flag(HsConst.INTERGRITY_NO);
        List<Map<String, Object>> questions1 = questionQueryService.query(dto);

        if (questions1 != null) {
            logger.info("question1 size={}", questions1.size());
        }

        dto = new QuestionQueryDto();
        dto.setIntegrity_flag(HsConst.INTERGRITY_YES);
        List<Map<String, Object>> questions2 = questionQueryService.query(dto);

        if (questions2 != null) {
            logger.info("question2 size={}", questions2.size());
        }

        List<Map<String, Object>> questions = new ArrayList<>();
        questions.addAll(questions1);
        questions.addAll(questions2);

        List<Map<String, Object>> sections = questionSectionQuery.getAllQuestionSections();

        List<PaperInfoQuestion>        res             = new ArrayList<>();
        Map<String, PaperInfoQuestion> question_no_map = new HashMap<>();
        for (Map<String, Object> question_map : questions) {
            PaperInfoQuestion question    = new PaperInfoQuestion();
            String            question_no = (String) question_map.get("question_no");
            if (StringUtils.isBlank(question_no)) {
                continue;
            }
            question.setQuestion_no(question_no);
            question.setQuestion_content(String.valueOf(question_map.get("question_content")));
            question.setAnswer_object(String.valueOf(question_map.get("answer_object")));
            question.setOrder_no(String.valueOf(question_map.get("order_no")));
            res.add(question);
            question_no_map.put(question_no, question);
        }

        for (Map<String, Object> section : sections) {
            String question_no = (String) section.get("question_no");
            if (!question_no_map.containsKey(question_no)) {
                continue;
            }
            PaperInfoQuestion     question          = question_no_map.get(question_no);
            List<QuestionSection> question_sections = question.getSections();
            if (question_sections == null) {
                question_sections = new ArrayList<>();
                question.setSections(question_sections);
            }
            QuestionSection qc = question.new QuestionSection();
            qc.setOption_content((String) section.get("option_content"));
            qc.setOption_no((String) section.get("option_no"));
            qc.setOption_score((String) section.get("option_score"));
            qc.setOrder_no((String) section.get("order_no"));
            question_sections.add(qc);
        }


        logger.info("all question size={}", res.size());
        return res;
    }

    @Override
    public PaperInfoTestResult addOrModifyPaperInfoAcct(Long user_id, String elig_content, String invest_risk_tolerance) {
        invest_risk_tolerance = StringUtil.blankIfNull(invest_risk_tolerance);
        User                user      = userDao.getEntity(user_id);
        PaperInfoTestResult exist_res = getUserPaperInfoTestResult(user_id, null);

        PaperInfoTestResult result;
        //还没保存过成绩
        if (!exist_res.isHave_tested()) {
            Map<String, Object> add_res = addAnswer.addPaperInfoAcct(user.getUserName(), user.getUserCard(), elig_content, invest_risk_tolerance);
            if (HsResponseUtil.isOperationOk(add_res)) {
                result = getUserPaperInfoTestResult(user_id, null);
            } else {
                throw new RuntimeException("调用HS接口失败");
            }
        } else {
            Map<String, Object> update_res = modifyAnswer.modifyPaperInfoAcct(exist_res.getPaper_id(), elig_content, invest_risk_tolerance, user.getUserName(), user.getUserCard());
            if (HsResponseUtil.isOperationOk(update_res)) {
                result = getUserPaperInfoTestResult(user_id, null);
            } else {
                throw new RuntimeException("调用HS接口失败");
            }
        }

        //更新过期时间 shi.pengyan 2017-6-21 15:32:22
        userProfileService.updateUserRiskLevelExpireTime(user.getUserId(), result.getUpdate_date());

        return result;
    }

    @Override
    public PaperInfoTestResult getUserPaperInfoTestResult(Long user_id, String password) {
        User                user   = userDao.getEntity(user_id);
        Map<String, Object> res    = resultQuery.getPaperinfoTestResult(user.getUserName(), user.getUserCard(), password);
        PaperInfoTestResult result = new PaperInfoTestResult();
        if (!HsResponseUtil.isOperationOk(res)) {
            result.setHave_tested(false);
            result.setPaper_score("0");
            result.setInvest_risk_tolerance("1");
        } else {
            result.setHave_tested(true);
            result.setPaper_score((String) res.get("paper_score"));
            result.setInvest_risk_tolerance((String) res.get("invest_risk_tolerance"));
        }
        result.setSuccess_type((String) res.get("success_type"));
        result.setPaper_id((String) res.get("paper_id"));
        result.setClient_id((String) res.get("client_id"));
        result.setCust_type((String) res.get("cust_type"));
        result.setFull_name((String) res.get("full_name"));
        result.setId_kind_gb((String) res.get("id_kind_gb"));
        result.setId_no((String) res.get("id_no"));
        result.setUpdate_date((String) res.get("update_date"));
        result.setElig_content((String) res.get("elig_content"));

        //问卷有效期 shi.pengyan 2017-7-5，该标识只用于刷新用户风险测评时间
        // 刷完之后，该字段为空 //TODO 恒生奇葩逻辑
        Object endDateObj = res.get("risk_enddate");
        log.info("endDateObj={}", endDateObj);

        if (endDateObj == null) {
            //直接计算过期时间
            if (StringUtil.isNotEmpty(result.getUpdate_date())) {
                result.setExpire_date(calcExpireDate(result.getUpdate_date()));
            } else {
                log.warn("update_date is null, plz check");
            }
        } else {
            String endDate = (String) endDateObj;
            if (StringUtil.isNotEmpty(endDate)) {
                result.setExpire_date(endDate);
            } else {
                if (StringUtil.isNotEmpty(result.getUpdate_date())) {
                    result.setExpire_date(calcExpireDate(result.getUpdate_date()));
                } else {
                    log.warn("update_date is null, plz check...");
                }
            }
        }

        return result;
    }

    @Override
    public PaperInfoTestResult addDefaultTestResult(Long user_id) {
        PaperInfoTestResult result = getUserPaperInfoTestResult(user_id, "");
        if (result.isHave_tested()) {
            logger.warn("Ignore add default test result for user : " + user_id + " because user have tested !");
            return result;
        }

        //判断是否已在私募入口做过风险测评，如果已做过，则传入之前的风险测评结果
        PaperInfoTestResult privateResult = privateequityService.getTestResult(user_id);
        if (privateResult.isHave_tested()) {
            return addOrModifyPaperInfoAcct(user_id, "", privateResult.getInvest_risk_tolerance());
        }

        List<PaperInfoQuestion> qs  = queryPaperInfoQuestionsNew(new PaperInfoQuestionRequest(null, null, null));
        ArrayList<String>       q_s = new ArrayList<>(qs.size());
        for (PaperInfoQuestion qiu : qs) {
            String     question_no   = qiu.getQuestion_no();
            BigDecimal defult        = new BigDecimal(-999);
            BigDecimal lower_score   = defult;
            String     lower_section = null;
            for (QuestionSection section : qiu.getSections()) {
                BigDecimal score = new BigDecimal(section.getOption_score());
                if (lower_score == defult || score.compareTo(lower_score) == -1) {
                    lower_score = score;
                    lower_section = section.getOption_no();
                    continue;
                }
            }
            q_s.add(question_no + ":" + lower_section);
        }
        String elig_content = StringUtils.join(q_s, "|");
        return addOrModifyPaperInfoAcct(user_id, elig_content, "");
    }

    private String calcExpireDate(String effectDate) {

        Date expireTime = DateUtils.addMondth(DateUtil.parse(effectDate, GlobalConstant.DATE_FORMAT_YYYYMMDD),
            HsConst.USER_RISK_LEVEL_EFFECT_YEAR * 12);
        String expireDate = DateUtil.format(expireTime, GlobalConstant.DATE_FORMAT_YYYY_MM_DD);
        log.info("effectTime={},expireTime={}", effectDate, expireDate);

        return expireDate;
    }

}
