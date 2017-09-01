package com.codi.api.controller;

import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.PaperInfoQuestionRequest;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.PaperInfoService;
import com.codi.bus.core.service.UserService;
import com.codi.message.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/paperinfo")
public class PaperInfoController {

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private PaperInfoService paperInfoService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public void getPaperinfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                             @RequestParam(required = false) String sort_direction, @RequestParam(required = false) String answer_object,
                             @RequestParam(required = false) String paper_client_type,
                             @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

//        ResponseUtils.renderJson(request, response, paperInfoService.queryPaperInfoQuestions(
//            new PaperInfoQuestionRequest(sort_direction, answer_object, paper_client_type)), true);

        // 普通+诚信
        ResponseUtils.renderJson(request, response, paperInfoService.queryPaperInfoQuestionsNew(
            new PaperInfoQuestionRequest(sort_direction, answer_object, paper_client_type)), true);
    }

    @RequestMapping(value = "/test_result", method = RequestMethod.GET)
    public void getPaperInfoTestResult(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam String token, @RequestParam(required = false) String password,
                                       @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        ResponseUtils.renderJson(request, response,
            paperInfoService.getUserPaperInfoTestResult(validateTokenResult.getUserId(), password), true);
    }

    @RequestMapping(value = "/commit_answer", method = RequestMethod.POST)
    public void commitAnswer(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                             @RequestParam String elig_content, @RequestParam(required = false) String invest_risk_tolerance,
                             @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        ResponseUtils.renderJson(request, response, paperInfoService
            .addOrModifyPaperInfoAcct(validateTokenResult.getUserId(), elig_content, invest_risk_tolerance), true);
    }

    @RequestMapping(value = "/add_default_answer", method = RequestMethod.PUT)
    public void addDefultAnswerIfNecessary(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam String token,
                                           @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        ResponseUtils.renderJson(request, response,
            paperInfoService.addDefaultTestResult(validateTokenResult.getUserId()), true);
    }

}
