package com.codi.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.StringUtil;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.resultModel.BankListResult;
import com.codi.bus.core.resultModel.BaseListResult;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.PayableBankListResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.BankService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.UserService;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Controller
@RequestMapping("/bank")
public class BankController {

	private static final Logger logger = LoggerFactory.getLogger(BankController.class);

	@Resource(name = "bankService")
	private BankService bankService;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "queryService")
	private QueryService queryService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getBanks(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
			@RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
		BaseListResult result = null;
		// 验证token
		ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
		if (!validateTokenResult.getSuccess()) {
			result = new BankListResult();
			result.setSuccess(false);
			String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
			result.setErrorMessage(errorMessage);
			ResponseUtils.renderJson(request, response, result, true);
			return;
		}

		// 获取客户编号
		User userEntity = userService.getUser(validateTokenResult.getUserId());
		if (userEntity == null) {
			result = new BankListResult();
			result.setSuccess(false);
			result.setErrorCode(ErrorConstant.ERROR_NO_USER_FIND);
			ResponseUtils.renderJson(request, response, result, true);
			return;
		}
		if (StringUtil.isEmpty(userEntity.getExternalClientId())) {
			result = new BankListResult();
			result.setSuccess(true);
		} else {
			// 调用恒生接口获取银行卡
			result = queryService.queryAccountBanks("", userEntity.getExternalClientId(), "",
					GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1");
			if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
				result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
			}
		}

		ResponseUtils.renderJson(request, response, result, true);

	}

	@RequestMapping(value = "pay-banks", method = RequestMethod.GET)
	public void getPayBanks(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
			@RequestParam String capitalMode,
			@RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
		logger.info("Receive pay-bakns request, capitalMode:" + capitalMode);
		PayableBankListResult result = null;
		// 验证token
		ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
		if (!validateTokenResult.getSuccess()) {
			String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
			validateTokenResult.setErrorMessage(errorMessage);
			ResponseUtils.renderJson(request, response, validateTokenResult, true);
			return;
		}

		// 获取支持的银行列表
		result = bankService.getPayBanks(capitalMode);
		if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
			result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
		}
		ResponseUtils.renderJson(request, response, result, true);
	}

	/**
	 * 获取支付渠道的单笔交易限制
	 * 
	 * @param request
	 * @param response
	 * @param token
	 * @param capitalMode
	 * @param bankCode
	 * @param deviceId
	 * @return
	 */
	@RequestMapping(value = "bank-limits", method = RequestMethod.GET)
	@ResponseBody
	@Loggable
	public BaseResult getPayBankLimits(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String token, @RequestParam String capitalMode, @RequestParam String bankCode,
			@RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
		logger.info("Receive bank-limits request, capitalMode:" + capitalMode);

		// 验证token
		ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
		if (!validateTokenResult.getSuccess()) {
			String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
			validateTokenResult.setErrorMessage(errorMessage);
			return validateTokenResult;
		}

		// 获取支持的银行列表
		BaseResult result = bankService.getPayBankLimits(capitalMode, bankCode);
		if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
			result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
		}

		return result;
	}

}
