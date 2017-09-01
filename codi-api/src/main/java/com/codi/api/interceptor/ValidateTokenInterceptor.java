package com.codi.api.interceptor;

import com.codi.api.security.UserUtil;
import com.codi.bus.constant.HttpHeaderConstant;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.exception.BaseException;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shangdu Lin on 2017/2/24 10:40.
 */
public class ValidateTokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ValidateTokenInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader("Auth-Token");
        String deviceId = httpServletRequest.getHeader("App-Device");

        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            // 添加错误信息 - alter by Shangdu - 20170606
            throw new BaseException(validateTokenResult.getErrorCode(), MessageUtil.getErrorMsg(validateTokenResult
                .getErrorCode()));
        }

        UserUtil.setUserId(validateTokenResult.getUserId());

        httpServletRequest.setAttribute(HttpHeaderConstant.HEADER_USER_ID, validateTokenResult.getUserId());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        UserUtil.clear();
    }
}
