package com.codi.bus.exception;

import com.codi.bus.constant.GlobalConstant;
import com.codi.message.constant.ErrorConstant;

/**
 * 数据库错误
 * errorCode = 1010
 */
public class SystemDBException extends BaseException {
	

	private static final long serialVersionUID = 108797897L;
	
	public SystemDBException(String msg, Throwable ex) {
		super(GlobalConstant.ERROR_TYPE_SYSTEM, ErrorConstant.ERROR_SYSTEM_DB, msg, ex);
	}

}
