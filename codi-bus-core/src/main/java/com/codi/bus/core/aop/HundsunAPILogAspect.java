package com.codi.bus.core.aop;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codi.bus.constant.GlobalConstant;

public class HundsunAPILogAspect extends MethodLogAspect {

	@SuppressWarnings("unchecked")
	@Override
	protected String extractLog(Object result, Object[] args, String methodName, long startTime, long endTime) {

		Map<String, Object> map = null;
		if (result instanceof Map<?, ?>) {
			map = (Map<String, Object>) result;
		}

		if (map != null) {
			String url = "";
			Object request = null;
			Object response = null;
			String requestHeaders = "";

			if (map.containsKey(GlobalConstant.KEY_API)) {
				url = map.get(GlobalConstant.KEY_API).toString();
			}

			if (map.containsKey(GlobalConstant.KEY_REQUEST_RAW)) {
				request = map.get(GlobalConstant.KEY_REQUEST_RAW);
			}

			if (map.containsKey(GlobalConstant.KEY_RESPONSE_RAW)) {
				response = map.get(GlobalConstant.KEY_RESPONSE_RAW);
			}

			return getLogMap(response, methodName, url, request, requestHeaders, startTime, endTime);

		}

		return null;
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(HundsunAPILogAspect.class);
	}

}
