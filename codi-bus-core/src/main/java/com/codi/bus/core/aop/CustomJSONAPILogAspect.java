package com.codi.bus.core.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codi.base.web.RequestUtils;

public class CustomJSONAPILogAspect extends MethodLogAspect {

	@Override
	public String extractLog(Object result, Object[] args, String methodName, long startTime,
			long endTime) {

		// 获取入参值
		Map<String, String> requestMap = null;
		Map<String, String> requestHeaders = null;
		String url = "";
		int index = 1;
		for (Object object : args) {
			if (object instanceof HttpServletRequest) {
				requestMap = RequestUtils.getRequestMap((HttpServletRequest) object);
				requestHeaders = RequestUtils.getQueryHeaders((HttpServletRequest) object);
				url = RequestUtils.getLocation((HttpServletRequest) object);
			}

			// LogProxy.data(HttpServletRequest request,Object response)
			// index=2 为Object response
			if (index == 2) {
				result = object;
			}

			index = index + 1;
		}

		return getLogMap(result, methodName, url, requestMap, requestHeaders, startTime, endTime);
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(CustomJSONAPILogAspect.class);
	}

}
