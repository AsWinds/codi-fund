package com.codi.bus.core.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codi.base.web.RequestUtils;

public class FastJSONAPILogAspect extends MethodLogAspect {

	@Override
	public String extractLog(Object result, Object[] args, String methodName, long startTime,
			long endTime) {

		// 获取入参值
		Map<String, String> requestMap = null;
		Map<String, String> requestHeaders = null;
		String url = "";
		for (Object object : args) {
			if (object instanceof HttpServletRequest) {
				requestMap = RequestUtils.getRequestMap((HttpServletRequest) object);
				requestHeaders = RequestUtils.getQueryHeaders((HttpServletRequest) object);
				url = RequestUtils.getLocation((HttpServletRequest) object);
			}
		}

		return getLogMap(result, methodName, url, requestMap, requestHeaders, startTime, endTime);
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(FastJSONAPILogAspect.class);
	}

}
