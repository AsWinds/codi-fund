package com.codi.api.validation;

import com.codi.base.util.StringUtil;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

/**
 * 
 * @author Shangdu Lin
 *  
 * @date 2017年1月9日 下午11:58:37
 */
public class PEValidation {

	/**
	 * 验证预约输入
	 * @param clientName
	 * @param clientMobile
	 * @param productId
	 * @param productName
	 * @return
	 */
	public static BaseResult validateAppointment(String clientName, String clientMobile, Long productId,
			String productName) {

		String placeValue = "";
		boolean isError = false;

		if (!isError && StringUtil.isEmpty(clientName)) {
			isError = true;
			placeValue = "预约用户";
		}

		if (!isError && StringUtil.isEmpty(clientMobile)) {
			isError = true;
			placeValue = "预约电话";
		}

		if (!isError && StringUtil.isEmpty(productName)) {
			isError = true;
			placeValue = "预约产品名称";
		}

		if (!isError && (productId==null || productId<=0)) {
			isError = true;
			placeValue = "预约产品ID";
		}		

		if (isError) {
			BaseResult result = new BaseResult();
			result.setSuccess(false);
			result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
			result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
					ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, placeValue));
			return result;
		}

		return null;

	}
}
