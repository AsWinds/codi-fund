package com.codi.bus.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.bus.constant.GlobalConstant;
import com.codi.message.constant.ErrorConstant;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -802376082358572333L;

	private final int code;
	// 默认为应用错误，
    private final String errorType;
	
    public BaseException(int code){
    	this(GlobalConstant.ERROR_TYPE_APPLICATION, code, null, null);
    }
    
    /**
     * 
     * 参数: code, errorMsg
     * 
     * */
	public BaseException(int code, String msg) {		
		this(GlobalConstant.ERROR_TYPE_APPLICATION, code, msg, null);
	}
	
	public BaseException(int code, String msg, String errorType) {       
		this(errorType, code, msg, null);
    }

	public BaseException(String msg) {
		this(GlobalConstant.ERROR_TYPE_APPLICATION, ErrorConstant.ERROR_GENERAL, msg, null);
	}
	
	public BaseException(String msg, Throwable ex) {
		this(GlobalConstant.ERROR_TYPE_APPLICATION, ErrorConstant.ERROR_GENERAL, msg, ex);
	}
	
	protected BaseException(String errorType, int code, String errorMsg, Throwable cause) {
		super(errorMsg, cause);
		this.code = code;
		this.errorType = errorType;
	}
	
	@JSONField
	public int getCode() {
		return code;
	}
	
	@JSONField
	public String getErrorType() {
        return errorType;
    }

	@Override
	public String getMessage() {
		if (super.getCause() == null) {
			return super.getMessage();
		} else {
			return super.getMessage() + "; nested exception is " + super.getCause().getClass().getName() + ": "
					+ super.getCause().getMessage();
		}
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		if (super.getCause() == null) {
			super.printStackTrace(ps);
		} else {
			ps.println(this);
			super.getCause().printStackTrace(ps);
		}
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		if (super.getCause() == null) {
			super.printStackTrace(pw);
		} else {
			pw.println(this);
			super.getCause().printStackTrace(pw);
		}
	}
}