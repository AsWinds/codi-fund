package com.codi.api.security;

import com.codi.bus.constant.HttpHeaderConstant;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shangdu Lin on 2017/2/24 10:40.
 * 适应性改造完成后移除， 和ValidateTokenInterceptor冲突 shi.pengyan 2017-6-19 16:00:41
 */
public class ValidateTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ValidateTokenFilter.class);

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {
        String token = request.getHeader("Auth-Token");
        String deviceId = response.getHeader("App-Device");
        // 验证token
        ValidateTokenResult result = userService.validateToken(token, deviceId);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(), null);
        }
        request.setAttribute(HttpHeaderConstant.HEADER_USER_ID, result.getUserId());
        UserUtil.setUserId(result.getUserId());
        try {
            chain.doFilter(request, response);
        } finally {
            UserUtil.clear();
        }
    }
}
