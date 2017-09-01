package com.codi.api.controller.v2;

import com.codi.api.validation.QueryValidation;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.FundInfoService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.UserService;
import com.codi.message.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查询v2
 *
 * @author Shangdu Lin
 * @date 2016年12月14日
 */
@Controller
@RequestMapping("/query/v2")
public class QueryControllerV2 {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Autowired
    private QueryValidation queryValidation;

    @Resource(name = "fundInfoService")
    private FundInfoService fundInfoService;

    /**
     * 查询交易记录，过滤掉T0基金
     *
     * @param request
     * @param response
     * @param token
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param deviceId
     */
    @RequestMapping(value = "/applys", method = RequestMethod.GET)
    @ResponseBody
    @Loggable
    public BaseResult applyQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                                 @RequestParam Integer requestNum, @RequestParam Integer queryFlag, @RequestParam Integer beginNum,
                                 @RequestParam String sortDirection,
                                 @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        ApplyListResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            return validateTokenResult;
        }

        result = queryService.queryApplys(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum,
            sortDirection, true);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return result;
    }

    /**
     * 查询资产，过滤掉T0基金
     *
     * @param request
     * @param response
     * @param token
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param deviceId
     */
    @RequestMapping(value = "/shares", method = RequestMethod.GET)
    @ResponseBody
    @Loggable
    public BaseResult shareQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                                 @RequestParam Integer requestNum, @RequestParam Integer queryFlag, @RequestParam Integer beginNum,
                                 @RequestParam String sortDirection,
                                 @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        ShareListResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);

            return validateTokenResult;
        }

        // 验证输入
        result = queryValidation.validateShareQuery(requestNum);
        if (result != null) {
            return result;
        }

        result = queryService.queryShares(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum,
            sortDirection, true);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return result;
    }

    /**
     * 查询基金基本信息
     *
     * @param request
     * @param response
     * @param keyword
     * @throws Exception
     */
    @Loggable
    @RequestMapping("/fundInfos")
    @ResponseBody
    public BaseResult queryFundInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String
        keyword) throws Exception {
        // 查询基金
        FundInfoListResult result = fundInfoService.query(keyword);

        return result;
    }
}
