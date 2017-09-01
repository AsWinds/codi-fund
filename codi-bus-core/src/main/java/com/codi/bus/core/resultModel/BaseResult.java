package com.codi.bus.core.resultModel;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.domain.BaseDomain;

public class BaseResult extends BaseDomain {
	private static final long serialVersionUID = 1L;

	@JSONField(ordinal = -1003)
	private boolean success = true;

	@JSONField(ordinal = -1002)
	private Integer errorCode;

	@JSONField(ordinal = -1001)
	private String errorMessage;  
	
	private Object result;

	// 错误类别
	private String errorType;

	public BaseResult() {
		this(true, null);
	}  
	
	public BaseResult(boolean success, String errorType, Integer errorCode){
		this.success = success;
        this.errorCode=errorCode;
        this.errorType=errorType;
	}

	public BaseResult(boolean success, String errorMsg) {
		this.success = success;
		this.errorMessage = errorMsg;
	}
	
	public BaseResult(boolean success, String errorMsg, String errorType) {
        this.success = success;
        this.errorMessage = errorMsg;
        this.errorType=errorType;
    }

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    
    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
