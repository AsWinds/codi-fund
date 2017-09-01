package com.codi.api.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codi.api.validation.TradeValidation;
import com.codi.base.util.StringUtil;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.PaperInfoTestResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.PaperInfoService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.TradeService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.model.NewsModel;
import com.codi.bus.core.service.model.ShareTypeModel;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Controller
@RequestMapping("/trade")
public class TradeController {

    private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private TradeValidation tradeValidation;

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public void sell(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String bankAccount, @RequestParam String paymentType, @RequestParam String fundName,
            @RequestParam String fundCode, @RequestParam BigDecimal shares, @RequestParam String tradePassword,
            @RequestParam String sign, @RequestParam String applyNo,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 验证输入
        result = tradeValidation.validateSell(bankAccount, paymentType, fundName, fundCode, shares, tradePassword,
                token, applyNo, sign, validateTokenResult.getUserId());
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 获取份额类别
        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        // 获取份额类别
        String shareType = shareTypeModel.getShareType();

        // 后台不再做验证，APP做完交易限制验证后，后台直接发给恒生，由恒生来决定是否可以做交易
        /*
         * TradeLimitModel limitModel = queryService.getTradeLimit(fundCode,
         * GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL, shareType,
         * GlobalConstant.CUST_TYPE_PERSONAL, paymentType); if (limitModel !=
         * null) { //不做最低赎回限制，因为需要考虑全部赎回的情况，全部赎回有可能小于最低赎回限制 // 验证最低起购份额
         * BigDecimal minValue = limitModel.getMinValue(); if
         * (shares.compareTo(minValue) == -1) { result = new BaseResult();
         * result.setSuccess(false);
         * result.setErrorCode(ErrorConstant.ERROR_SELL_LESS_THAN_MIN_VALUE);
         * result.setErrorMessage(MessageUtil.getErrorMessage(result.
         * getErrorCode(), null)); ResponseUtils.renderJson(request, response,
         * result, true); return; } // 验证最高可赎回的份额 BigDecimal maxValue =
         * limitModel.getMaxValue(); if (shares.compareTo(maxValue) == 1) {
         * result = new BaseResult(); result.setSuccess(false);
         * result.setErrorCode(ErrorConstant.ERROR_SELL_MORE_THAN_MAX_VALUE);
         * result.setErrorMessage(MessageUtil.getErrorMessage(result.
         * getErrorCode(), null)); ResponseUtils.renderJson(request, response,
         * result, true); return; } }
         */

        // 调用接口
        result = tradeService.sell(validateTokenResult.getUserId(), token, bankAccount, paymentType, fundName, fundCode,
                shares, shareType, tradePassword, applyNo);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public void buy(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String bankAccount, @RequestParam String paymentType, @RequestParam Integer moneyType,
            @RequestParam String fundName, @RequestParam String fundCode, @RequestParam BigDecimal fundBalance,
            @RequestParam String tradePassword, @RequestParam boolean checkRisk, @RequestParam String sign,
            @RequestParam String applyNo, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 验证输入
        result = tradeValidation.validateBuy(bankAccount, paymentType, moneyType, fundName, fundCode, fundBalance,
                tradePassword, token, applyNo, validateTokenResult.getUserId(), sign);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 检查基金的风险等级和用户的等级
        if (checkRisk && invalidRisk(request, response, fundCode, validateTokenResult)) {
            return;
        }

        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 获取份额类别
        String shareType = shareTypeModel.getShareType();

        // 后台不再做验证，APP做完交易限制验证后，后台直接发给恒生，由恒生来决定是否可以做交易
        /*
         * TradeLimitModel limitModel = queryService.getTradeLimit(fundCode,
         * GlobalConstant.FUND_BUSIN_CODE_APPLY_BUY, shareType,
         * GlobalConstant.CUST_TYPE_PERSONAL, paymentType); if (limitModel !=
         * null) { // 验证最低起购金额 BigDecimal minValue = limitModel.getMinValue();
         * if (fundBalance.compareTo(minValue) == -1) { result = new
         * BaseResult(); result.setSuccess(false);
         * result.setErrorCode(ErrorConstant.ERROR_BUY_LESS_THAN_MIN_VALUE);
         * result.setErrorMessage(MessageUtil.getErrorMessage(result.
         * getErrorCode(), null)); ResponseUtils.renderJson(request, response,
         * result, true); return; } // 验证最高可购金额 BigDecimal maxValue =
         * limitModel.getMaxValue(); if (fundBalance.compareTo(maxValue) == 1) {
         * result = new BaseResult(); result.setSuccess(false);
         * result.setErrorCode(ErrorConstant.ERROR_BUY_MORE_THAN_MAX_VALUE);
         * result.setErrorMessage(MessageUtil.getErrorMessage(result.
         * getErrorCode(), null)); ResponseUtils.renderJson(request, response,
         * result, true); return; } }
         */

        // 调用接口
        result = tradeService.buy(validateTokenResult.getUserId(), token, bankAccount, paymentType, moneyType, fundName,
                fundCode, fundBalance, shareType, tradePassword, applyNo);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/undo", method = RequestMethod.POST)
    public void undo(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String originalApplyNo, @RequestParam String tradePassword, @RequestParam String sign,
            @RequestParam String applyNo, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        logger.info("undo request, originalApplyNo:" + originalApplyNo + ", applyNo:" + applyNo);
        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 验证输入
        result = tradeValidation.validateUndo(originalApplyNo, tradePassword, token, applyNo,
                validateTokenResult.getUserId(), sign);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 调用接口
        result = tradeService.undo(validateTokenResult.getUserId(), token, originalApplyNo, tradePassword);
        if (!result.getSuccess() && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 申购定投基金
     *
     * @param request
     * @param response
     * @param token
     * @param originalApplyNo
     * @param tradePassword
     * @param sign
     * @param applyNo
     */
    @RequestMapping(value = "/fix", method = RequestMethod.POST)
    public void fix(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String tradePassword, @RequestParam boolean checkRisk, @RequestParam String applyNo,
            @RequestParam String bankAccount, @RequestParam String paymentType, @RequestParam String fundName,
            @RequestParam String fundCode, @RequestParam BigDecimal balance, @RequestParam String protocolPeriodUnit,
            @RequestParam Long protocolFixDay, @RequestParam String sign,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 用户ID
        long userId = validateTokenResult.getUserId();

        // 验证输入
        result = tradeValidation.validateFix(bankAccount, paymentType, fundName, fundCode, tradePassword, balance,
                protocolPeriodUnit, protocolFixDay, token, applyNo, validateTokenResult.getUserId(), sign, null, null,
                null);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 检查基金的风险等级和用户的等级
        if (checkRisk && invalidRisk(request, response, fundCode, validateTokenResult)) {
            return;
        }

        // 获取份额类别
        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        String shareType = shareTypeModel.getShareType(); // 份额类别

        // 调用接口
        result = tradeService.fix(applyNo, tradePassword, protocolFixDay, shareType, bankAccount, fundName,
                protocolPeriodUnit, userId, balance, fundCode, paymentType, token, GlobalConstant.FIX_MODEL_NORMAL,
                null, null);
        if (!result.getSuccess() && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 修改定投协议
     *
     * @param request
     * @param response
     * @param token
     * @param tradePassword
     * @param checkRisk
     * @param applyNo
     * @param bankAccount
     * @param paymentType
     * @param fundName
     * @param fundCode
     * @param balance
     * @param protocolPeriodUnit
     * @param protocolFixDay
     */
    @RequestMapping(value = "/modifyfix", method = RequestMethod.POST)
    public void modifyFix(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
            @RequestParam String tradePassword, @RequestParam boolean checkRisk,
            @RequestParam String protocolPeriodUnit, @RequestParam String applyNo, @RequestParam String bankAccount,
            @RequestParam String paymentType, @RequestParam String fundName, @RequestParam String fundCode,
            @RequestParam BigDecimal balance, @RequestParam String scheduledProtocolId, @RequestParam String fixModel,
            @RequestParam Long protocolFixDay, @RequestParam String sign, @RequestParam String expiryDate,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 用户ID
        long userId = validateTokenResult.getUserId();

        // 验证输入
        result = tradeValidation.validateFix(bankAccount, paymentType, fundName, fundCode, tradePassword, balance,
                protocolPeriodUnit, protocolFixDay, token, applyNo, validateTokenResult.getUserId(), sign, expiryDate,
                fixModel, scheduledProtocolId);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 定投协议号不能为空
        if (StringUtil.isEmpty(scheduledProtocolId)) {
            result = new BaseResult();
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "定投协议号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
        }

        // 检查基金的风险等级和用户的等级
        if (checkRisk && invalidRisk(request, response, fundCode, validateTokenResult)) {
            return;
        }

        // 获取份额类别
        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        String shareType = shareTypeModel.getShareType(); // 份额类别

        // 调用接口
        result = tradeService.fix(applyNo, tradePassword, protocolFixDay, shareType, bankAccount, fundName,
                protocolPeriodUnit, userId, balance, fundCode, paymentType, token, fixModel, scheduledProtocolId,
                expiryDate);
        if (!result.getSuccess() && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 快速赎回
     *
     * @param request
     * @param response
     * @param token 用户Token
     * @param bankAccount 银行账号
     * @param paymentType 支付方式
     * @param fundName 基金名称
     * @param fundCode 基金代码
     * @param shares 份额
     * @param tradeAcco 交易账号
     * @param tradePassword 交易密码
     * @param sign 签名
     * @param applyNo 申请编号
     * @param deviceId 设备ID
     */
    @RequestMapping(value = "/fastRedeem", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<BaseResult> fastRedeem(HttpServletRequest request, HttpServletResponse response,
            @RequestParam String token, @RequestParam String bankAccount, @RequestParam String paymentType,
            @RequestParam String fundName, @RequestParam String fundCode, @RequestParam BigDecimal shares,
            @RequestParam String tradePassword, @RequestParam String sign, @RequestParam String applyNo,
            @RequestParam String tradeAcco, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        BaseResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            return new ResponseEntity<BaseResult>(validateTokenResult, HttpStatus.OK);
        }
        // 验证输入
        result = tradeValidation.validateFastRedeem(bankAccount, paymentType, fundName, fundCode, shares, tradePassword,
                token, applyNo, sign, validateTokenResult.getUserId(), tradeAcco);
        if (result != null) {
            return new ResponseEntity<BaseResult>(result, HttpStatus.OK);
        }

        // 获取份额类别
        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);
        if (shareTypeModel == null || StringUtil.isEmpty(shareTypeModel.getShareType())) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND, null));
            return new ResponseEntity<BaseResult>(result, HttpStatus.OK);
        }

        // 获取份额类别
        String shareType = shareTypeModel.getShareType();

        // 调用接口
        result = tradeService.fastRedeem(validateTokenResult.getUserId(), token, paymentType, tradePassword, fundCode,
                shareType, shares, bankAccount, fundName, applyNo, tradeAcco);

        // 失败
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return new ResponseEntity<BaseResult>(result, HttpStatus.OK);
    }

    /**
     * 检查风险等级是否和用户的匹配
     *
     * @param request
     * @param response
     * @param fundCode
     * @param validateTokenResult
     * @return
     */
    private boolean invalidRisk(HttpServletRequest request, HttpServletResponse response, String fundCode,
            ValidateTokenResult validateTokenResult) {
        BaseResult result;
        NewsModel fundRiskLevel = queryService.getRiskLevel(fundCode);
        PaperInfoTestResult testResult = paperInfoService.getUserPaperInfoTestResult(validateTokenResult.getUserId(),
                "");
        Integer investRiskLevel = 0;
        if (!StringUtil.isEmpty(testResult.getInvest_risk_tolerance())) {
            investRiskLevel = Integer.parseInt(testResult.getInvest_risk_tolerance());
        }

        // 基金的风险等级大于用户的投资风险等级
        /*进取型5,成长型4,平衡型3,稳健型2,保守型1
          高风险5,中高风险4,中风险3,中低风险2,低风险1*/
        if (investRiskLevel < fundRiskLevel.getRiskLevel()) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(ErrorConstant.ERROR_RISK_LEVEL);
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
            ResponseUtils.renderJson(request, response, result, true);
            return true;
        }
        return false;
    }
}
