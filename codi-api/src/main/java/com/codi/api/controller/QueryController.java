package com.codi.api.controller;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codi.api.validation.QueryValidation;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.ApplyListResult;
import com.codi.bus.core.resultModel.AssetsResult;
import com.codi.bus.core.resultModel.BankListResult;
import com.codi.bus.core.resultModel.BankResult;
import com.codi.bus.core.resultModel.BaseListResult;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.FixListResult;
import com.codi.bus.core.resultModel.FundInfoListResult;
import com.codi.bus.core.resultModel.FundListResult;
import com.codi.bus.core.resultModel.ShareListResult;
import com.codi.bus.core.resultModel.ShareTypeListResult;
import com.codi.bus.core.resultModel.ShareTypeResult;
import com.codi.bus.core.resultModel.TradeLimitListResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.FundInfoService;
import com.codi.bus.core.service.LookupService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.model.BankModel;
import com.codi.bus.core.service.model.ShareTypeModel;
import com.codi.bus.exception.BaseException;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Controller
@RequestMapping("/query")
public class QueryController {

    private static final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource(name = "fundInfoService")
    private FundInfoService fundInfoService;
    
    @Resource(name = "lookupService")
    private LookupService lookupService;
    
    @Autowired
    private QueryValidation queryValidation;
    
    @Loggable
    @RequestMapping(value = "/assets", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult assetsQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,            
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        AssetsResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            
            return validateTokenResult;
        }
       
        result=queryService.queryAssets(validateTokenResult.getUserId());
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return result;
    }

    @RequestMapping(value = "/limits", method = RequestMethod.GET)
    public void limitQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String fundCode, @RequestParam String capitalMode, @RequestParam String businCode,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        TradeLimitListResult result = new TradeLimitListResult();
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            logger.info(MessageFormat.format("limitQuery - fundCode:{0}, can not find share type", fundCode));
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        String shareType = shareTypeModel.getShareType();
        logger.info(MessageFormat.format("limitQuery - fundCode:{0}, shareType={1}", fundCode, shareType));
        result = queryService.queryTradeLimits(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", fundCode, shareType,
                capitalMode, businCode, GlobalConstant.CUST_TYPE_PERSONAL);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        logger.info(MessageFormat.format("limitQuery - fundCode:{0}, shareType={1}, result={2}", fundCode, shareType,
                result.toString()));
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/accbank", method = RequestMethod.GET)
    public void accountBankQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String tradeAccount,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        BankResult result = new BankResult();
        logger.info("accountBankQuery - tradeAccount:" + tradeAccount);
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        if (StringUtil.isEmpty(tradeAccount)) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "交易账号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));

            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        BaseListResult listResult = queryService.queryAccountBanks(tradeAccount, "", "", 1, 1, 1, "");
        if (!listResult.getSuccess()) {
            ResponseUtils.renderJson(request, response, listResult, true);
            return;
        }
        result.setSuccess(true);
        List<BankModel> banks = ((BankListResult) listResult).getBanks();
        if (banks != null && banks.size() > 0) {
            BankModel model = banks.get(0);
            result.setBankName(model.getBankName());
        }
        ResponseUtils.renderJson(request, response, result, true);

    }

    @RequestMapping(value = "/sharetype", method = RequestMethod.GET)
    public void shareTypeQuery(HttpServletRequest request, HttpServletResponse response,
            @RequestParam String fundCode) {
        ShareTypeResult result = new ShareTypeResult();
        if (StringUtil.isEmpty(fundCode)) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "基金");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
        } else {
            result.setSuccess(true);

            ShareTypeListResult listResult = queryService.queryShareTypes(1, 1, 1, "", fundCode, "");
            List<ShareTypeModel> shareTypes = listResult.getShareTypes();
            if (shareTypes != null && shareTypes.size() > 0) {
                ShareTypeModel model = shareTypes.get(0);
                result.setFundCode(model.getFundCode());
                result.setFundName(model.getFundName());
                result.setShareType(model.getShareType());
            }
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/applys", method = RequestMethod.GET)
    public void applyQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam Integer requestNum, @RequestParam Integer queryFlag, @RequestParam Integer beginNum,
            @RequestParam String sortDirection,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        ApplyListResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        result = queryService.queryApplys(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum,
                sortDirection, false);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/funds", method = RequestMethod.GET)
    public void fundQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer requestNum,
            @RequestParam Integer queryFlag, @RequestParam Integer beginNum, @RequestParam String sortDirection,
            @RequestParam String fundCode) {
        FundListResult result = null;
        result = queryService.queryFunds(requestNum, queryFlag, beginNum, sortDirection, fundCode);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/shares", method = RequestMethod.GET)
    public void shareQuery(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam Integer requestNum, @RequestParam Integer queryFlag, @RequestParam Integer beginNum,
            @RequestParam String sortDirection,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        ShareListResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        // 验证输入
        result = queryValidation.validateShareQuery(requestNum);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        result = queryService.queryShares(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum,
                sortDirection, false);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 查询基金基本信息
     * 
     * @param request
     * @param response
     * @param keyword
     * @throws Exception
     */
    @RequestMapping("fundInfos")
    @ResponseBody
    public void queryFundInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String keyword) {
        FundInfoListResult result = null;
        try {

            // 查询基金
            result = fundInfoService.query(keyword);

        } catch (BaseException exception) {
            result = new FundInfoListResult();
            result.setSuccess(false);
            Integer errorCode = exception.getCode();
            result.setErrorCode(errorCode);
            if (StringUtil.isEmpty(result.getErrorMessage())) {
                String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
                result.setErrorMessage(errorMessage);
            }
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "queryFundInfo - Exception:", e);
            result = new FundInfoListResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_SYS_EXCEPTION);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_SYS_EXCEPTION, null));
        }

        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 定投基金查询
     * 
     * @param request
     * @param response
     * @param token 用户TOKEN
     * @param requestNum 请求行数
     * @param queryFlag 重新统计总记录数标志
     * @param beginNum 查询起始行号
     * @param sortDirection 返回排序方式 （0:倒序；1：顺序）
     */
    @RequestMapping(value = "fixes", method = RequestMethod.GET)
    @Loggable
    public @ResponseBody FixListResult fixes(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam Integer requestNum, @RequestParam Integer queryFlag, @RequestParam Integer beginNum,
            @RequestParam String sortDirection,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        FixListResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return result;
        }

        // 查询定投基金
        return queryService.getFixes(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum, sortDirection);

    }
}
