package com.codi.api.interceptor;

import com.codi.bus.exception.BaseException;
import com.codi.bus.util.Platform;
import com.codi.message.constant.ErrorConstant;
import com.codi.superman.base.domain.SysAppVersion;
import com.codi.superman.base.service.SysAppVersionService;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateAppVersionInterceptor2 implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ValidateAppVersionInterceptor2.class);

	@Autowired
	@Qualifier("sysAppVersionService")
	private SysAppVersionService appVersionService;

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
		String appCode = request.getHeader("App-Identifier");
		logger.info("Request from app-version: {}, os-type: {}, app-identifier: {}", appVersion, osType, appCode);
		if (appCode == null) {
			throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, null);
		}
		SysAppVersion info = appVersionService.queryLatestVersionByAppCode(appCode, appVersion);
		if (info != null && BooleanUtils.isNotFalse(info.getForceUpdate())) {
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
