package com.codi.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.codi.bus.core.domain.AppVersionInfo;
import com.codi.bus.core.service.AppVersionInfoService;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.Platform;
import com.codi.message.constant.ErrorConstant;

public class ValidateAppVersionInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ValidateAppVersionInterceptor.class);
	
	@Autowired
	private AppVersionInfoService appVersionInfoService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String appVersion = request.getHeader("Client-Version");
		String osType = request.getHeader("Os-Type");
		Platform platform = null;
		try {
			platform = Enum.valueOf(Platform.class, osType);
		} catch (Exception e) {
			throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, null);
		}
		String appIdentifier = request.getHeader("App-Identifier");
		logger.info("Request from app-version: {}, os-type: {}, app-identifier: {}", appVersion, osType, appIdentifier);
		if (appIdentifier == null) {
			throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, null);
		}
		AppVersionInfo info = appVersionInfoService.getVersion(appIdentifier, platform, appVersion);
		if (info != null && info.getNeedForeceUpdate()) {
			throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, "有新版本了, 请您务必更新 ! ");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}
