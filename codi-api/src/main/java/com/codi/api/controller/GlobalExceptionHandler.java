package com.codi.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.codi.base.exception.BaseAppException;
import com.codi.base.log.desensitizer.LogProxy;
import com.codi.base.spring.SpringContextHolder;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.exception.BaseException;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 *
 * Class used to handle global controller exceptions.
 *
 * Spring MVC build Exceptions, in 3.2.17 Exception HTTP Status Code
 * BindException 400 (Bad Request) ConversionNotSupportedException 500 (Internal
 * Server Error) HttpMediaTypeNotAcceptableException 406 (Not Acceptable)
 * HttpMediaTypeNotSupportedException 415 (Unsupported Media Type)
 * HttpMessageNotReadableException 400 (Bad Request)
 * HttpMessageNotWritableException 500 (Internal Server Error)
 * HttpRequestMethodNotSupportedException 405 (Method Not Allowed)
 * MethodArgumentNotValidException 400 (Bad Request)
 * MissingServletRequestParameterException 400 (Bad Request)
 * MissingServletRequestPartException 400 (Bad Request)
 * NoSuchRequestHandlingMethodException 404 (Not Found) TypeMismatchException
 * 400 (Bad Request)
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = BaseAppException.class)
	public void handleBaseAppException(HttpServletRequest request, HttpServletResponse response, BaseAppException e) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("success", false);
		jsonObj.put("errorCode", e.getCode());
		jsonObj.put("errorType", e.getErrorType());

		String desc = e.getDesc();
		if (StringUtil.isEmpty(desc)) {
			desc = MessageUtil.getErrorMsg(e.getCode());
		}
		jsonObj.put("errorMessage", desc);
		ResponseUtils.renderJson2(request, response, jsonObj, true);
	}

	@ExceptionHandler(value = BaseException.class)
	public @ResponseBody ResponseEntity<BaseResult> handleBaseException(HttpServletRequest request, BaseException be) {
		return new ResponseEntity<>(buildBaseResult(request, be.getCode(), be.getMessage(), be.getErrorType(), getMessage(be)),
				HttpStatus.OK);
	}

	@ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
	public @ResponseBody ResponseEntity<?> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
			HttpMediaTypeNotAcceptableException be) {
		return new ResponseEntity<>(buildBaseResult(request, ErrorConstant.ERROR_SYS_EXCEPTION, be.getMessage(),
				GlobalConstant.ERROR_TYPE_SYSTEM, getMessage(be)), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public @ResponseBody ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpServletRequest request,
			HttpRequestMethodNotSupportedException be) {
		return new ResponseEntity<>(buildBaseResult(request, ErrorConstant.ERROR_SYS_EXCEPTION, be.getMessage(),
				GlobalConstant.ERROR_TYPE_SYSTEM, getMessage(be)), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(value = NoSuchRequestHandlingMethodException.class)
	public @ResponseBody ResponseEntity<?> handleNoSuchRequestHandlingMethodException(HttpServletRequest request,
			NoSuchRequestHandlingMethodException be) {
		return new ResponseEntity<>(buildBaseResult(request, ErrorConstant.ERROR_SYS_EXCEPTION, be.getMessage(),
				GlobalConstant.ERROR_TYPE_SYSTEM, getMessage(be)), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
			MissingServletRequestParameterException.class, MissingServletRequestPartException.class,
			TypeMismatchException.class, ServletRequestBindingException.class, BindException.class })
	public @ResponseBody ResponseEntity<BaseResult> handleExceptions(HttpServletRequest request, Exception e) {
		return new ResponseEntity<>(buildBaseResult(request, ErrorConstant.ERROR_INVALID_REQUEST, e.getMessage(),
				GlobalConstant.ERROR_TYPE_APPLICATION, getMessage(e)), HttpStatus.OK);
	}

	@ExceptionHandler(value = { ConversionNotSupportedException.class, HttpMessageNotWritableException.class,
			Exception.class })
	public @ResponseBody ResponseEntity<BaseResult> handleException(HttpServletRequest request, Exception e) {
		ExceptionUtil.logError(logger, "Unexpected exceptions!!!", e);
		return new ResponseEntity<>(buildBaseResult(request, ErrorConstant.ERROR_SYS_EXCEPTION, null,
				GlobalConstant.ERROR_TYPE_SYSTEM, getMessage(e)), HttpStatus.OK);
	}

	private BaseResult buildBaseResult(HttpServletRequest request, int errorCode, String errorMsg, String errorType,
			String errorMsgForLog) {
		// 返回给前端的结果
		BaseResult result = getBaseResult(errorCode, errorMsg, errorType);
		// 方法日志记录, 因为Loggable标签对此方法不起作用不能拦该方法，原因待查， 所以在这里中转下
		BaseResult resultForLog = getBaseResult(errorCode, errorMsgForLog, errorType);
		LogProxy logProxy = SpringContextHolder.getBean("logProxy");
		logProxy.data(request, resultForLog);

		return result;
	}

	private BaseResult getBaseResult(int errorCode, String errorMsg, String errorType) {
		BaseResult result = new BaseResult();
		result.setSuccess(false);
		result.setErrorCode(errorCode);
		result.setErrorType(errorType);
		if (StringUtil.isEmpty(errorMsg)) {
			String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
			result.setErrorMessage(errorMessage);
		} else {
			result.setErrorMessage(errorMsg);
		}

		return result;
	}

    /**
     * 如果Exception Message为空，则获取异常的堆栈信息
     * @param exception
     * @return
     */
	private String getMessage(Exception exception){
	    String message=exception.getMessage();
	    if(!StringUtil.isEmpty(message)){
	        return message;
        }
	    try{
            ByteArrayOutputStream buffer=new ByteArrayOutputStream();
            exception.printStackTrace(new PrintWriter(buffer,true));
            message=buffer.toString();
        }catch (Exception inner){

        }

        return message;
    }

}
