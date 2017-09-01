package com.codi.api.validation;

import java.util.HashMap;
import java.util.Map;

import com.codi.bus.core.annotation.Validator;
import com.codi.bus.core.resultModel.ShareListResult;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Validator
public class QueryValidation {

	public ShareListResult validateShareQuery(Integer requestNum) {
		ShareListResult result = new ShareListResult();
		result.setSuccess(false);

		if (requestNum <= 0) {
			result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
			Map<String, String> map = new HashMap<>();
			map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行账号");
			result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
			return result;
		}

		return null;
	}
}
