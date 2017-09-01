package com.codi.api.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.codi.base.exception.BaseAppException;
import com.codi.base.util.StringUtil;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.exception.BaseException;
import com.codi.message.util.MessageUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 需要Spring Bean支持, 强依赖FastJson的Spring配置
 * 
 * */
@Slf4j
public class ExceptionTranslationFilter implements Filter  {
	
	@Autowired
	private FastJsonHttpMessageConverter4 converter;
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
	    
    }

	@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
	    try {
	        chain.doFilter(request, response);
        }catch (Exception e) {
	    	if (e instanceof BaseAppException) {
	    		BaseAppException bae = (BaseAppException) e;
	    		JSONObject jsonObj = new JSONObject();
	    		jsonObj.put("success", false);
	    		jsonObj.put("errorCode", bae.getCode());
	    		jsonObj.put("errorType", bae.getErrorType());

	    		String desc = bae.getDesc();
	    		if (StringUtil.isEmpty(desc)) {
	    			desc = MessageUtil.getErrorMsg(bae.getCode());
	    		}
	    		jsonObj.put("errorMessage", desc);
	    		write(jsonObj, (HttpServletResponse)response);
	    		return;
			}else if (e instanceof BaseException) {
				BaseException be = (BaseException) e;
				BaseResult result = new BaseResult();
				result.setSuccess(false);
				result.setErrorCode(be.getCode());
				result.setErrorType(be.getErrorType());
				String msg = e.getMessage();
				if (StringUtil.isEmpty(msg)) {
					String errorMessage = MessageUtil.getErrorMessage(be.getCode(), null);
					result.setErrorMessage(errorMessage);
				} else {
					result.setErrorMessage(msg);
				}
				write(result, (HttpServletResponse)response);
				return;
			}
	    	log.error("Unexpect exception", e);
	    	throw e;
		}
	    
    }
	
	private void write(Object result, HttpServletResponse resp) throws HttpMessageNotWritableException, IOException{
		converter.write(result, MediaType.APPLICATION_JSON_UTF8, new ServletServerHttpResponse(resp));
	}

	@Override
    public void destroy() {
	    
    }
	


}
