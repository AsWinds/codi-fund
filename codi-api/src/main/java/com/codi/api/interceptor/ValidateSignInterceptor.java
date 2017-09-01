package com.codi.api.interceptor;

import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.SignUtil;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ValidateSignInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ValidateSignInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sign = request.getParameter("sign");
		if (sign == null) {
			//TODO
			throw new MissingServletRequestParameterException("sign", "String");
		}
		String token = request.getParameter("token");
		if (token == null) {
			token = request.getHeader("Auth-Token");
		}
		if (token == null) {
			//TODO
			throw new MissingServletRequestParameterException("token", "String");
		}
        // 验证签名
		TreeMap<String, Object> sortMap = processParams(request.getParameterMap());
        String requestString = SignUtil.getRequestString(sortMap);
        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            String type = GlobalConstant.ERROR_TYPE_APPLICATION;
            Integer code = ErrorConstant.ERROR_INVALID_REQUEST;
            String msg = MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null);
            throw new BaseException(code, msg, type);
        }
		return true;
	}

	private TreeMap<String, Object> processParams(Map<String, String[]> origin){
		TreeMap<String, Object> res = new TreeMap<String, Object>();
		for (Map.Entry<String, String[]> entry : origin.entrySet()) {
			String key = entry.getKey();
			if ("sign".equals(key)) {
	            continue;
            }
	        String newVal = StringUtils.join(Arrays.asList(entry.getValue()),",");
	        res.put(entry.getKey(), newVal);
        }
		return res;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
