package com.codi.api.controller;

import com.codi.api.validation.PEValidation;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.HttpHeaderConstant;
import com.codi.bus.core.domain.PEProduct;
import com.codi.bus.core.domain.UserPrivateequity;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.PaperInfoTestResult;
import com.codi.bus.core.service.PEAppointmentService;
import com.codi.bus.core.service.PEProductService;
import com.codi.bus.core.service.UserPrivateequityService;
import com.codi.bus.core.service.model.PrivateequityModel;
import com.codi.bus.exception.BaseException;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Shangdu Lin
 * @date 2017年1月9日 下午8:43:39
 */
@Controller
@RequestMapping("/pe")
public class PrivateEquityController {

    @Autowired
    private UserPrivateequityService privateequityService;

    @Autowired
    private PEAppointmentService peappointmentService;

    @Autowired
    private PEProductService peproductService;

    /**
     * 查询用户是否是合法的投资者
     *
     * @param request
     * @param response
     * @param userId
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getPEUser(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId) throws BaseException {

        UserPrivateequity user = privateequityService.getByUserId(userId);

        PrivateequityModel model = new PrivateequityModel();
        if (user != null) {
            model.setQualifiedInvester(user.getQualifiedInvester());
        }

        BaseResult result = new BaseResult();
        result.setResult(model);

        return result;
    }

    /**
     * 设置用户是否为合法投资者
     *
     * @param request
     * @param response
     * @param userId
     * @param isQualified
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updatePEUser(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId,
                                   boolean isQualified)
        throws BaseException {

        privateequityService.addOrUpdate(userId, isQualified);

        return new BaseResult();
    }

    /**
     * 私募预约
     *
     * @param request
     * @param response
     * @param userId
     * @param clientName
     * @param clientMobile
     * @param productId
     * @param productName
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addAppointment(HttpServletRequest request, HttpServletResponse response,
                                     @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId,
                                     @RequestParam String clientName, @RequestParam String clientMobile, @RequestParam Long productId,
                                     @RequestParam String productName) throws BaseException {

        BaseResult result = PEValidation.validateAppointment(clientName, clientMobile, productId, productName);
        if (result != null) {
            return result;
        }

        peappointmentService.addAppointment(userId, clientName, clientMobile, productId, productName);

        return new BaseResult();
    }

    /**
     * 查询用户是否在24小时内已预约
     * @param request
     * @param response
     * @param clientMobile
     * @param productId
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/hasAppointed", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult hasAppointed(HttpServletRequest request, HttpServletResponse response,
                                     @RequestParam String clientMobile, @RequestParam Long productId) throws BaseException {

        boolean hasAppointed= peappointmentService.hasAppointed(clientMobile,productId);
        BaseResult result=new BaseResult();
        result.setResult(hasAppointed);

        return result;
    }


    /**
     * 查询私募产品
     *
     * @param request
     * @param response
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult queryProducts(HttpServletRequest request, HttpServletResponse response)
        throws BaseException {

        List<PEProduct> products = peproductService.queryList(GlobalConstant.PE_PRODUCT_STUTAS_ONSALE);
        BaseResult result = new BaseResult();
        result.setResult(products);

        return result;
    }

    /**
     * 查询风险测评结果
     *
     * @param request
     * @param response
     * @param userId
     * @return
     * @throws BaseException
     */
    @Loggable
    @RequestMapping(value = "/test-result", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult queryTestResult(HttpServletRequest request, HttpServletResponse response,
                                      @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId)
        throws BaseException {

        PaperInfoTestResult result = privateequityService.getTestResult(userId);

        return result;
    }


    /**
     * 提交风险测评结果
     *
     * @param request
     * @param response
     * @param userId
     * @param answers
     */
    @Loggable
    @RequestMapping(value = "/commit_answer", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult commitAnswer(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId,
                                   @RequestParam String answers) {

        if (StringUtil.isEmpty(answers)) {
            String errorMessage = MessageUtil.getErrorMsg(ErrorConstant.ERROR_FIELD_NO_FIND, "风险测评答案");
            throw new BaseException(ErrorConstant.ERROR_FIELD_NO_FIND, errorMessage);
        }

        return privateequityService.commitAnswers(userId, answers);
    }
}
