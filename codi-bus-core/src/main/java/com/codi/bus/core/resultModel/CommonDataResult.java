package com.codi.bus.core.resultModel;

public class CommonDataResult<T> extends BaseResult {
	private static final long serialVersionUID = 1L;
	
	private final T data;

	public CommonDataResult() {
		super();
		this.data = null;
	}
	
	public CommonDataResult(T data){
		super();
		this.data = data;
	}
	
	public CommonDataResult(boolean success, Integer errorCode, String errorType){
		super(success, errorType, errorCode);
		this.data = null;
	}
	
	public CommonDataResult(boolean success, String errorMsg, T data){
		super(success, errorMsg);
		this.data = null;
	}
	
	public T getData() {
		return data;
	}
}
