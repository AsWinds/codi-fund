package com.codi.bus.exception;

import com.codi.bus.constant.GlobalConstant;
import com.codi.message.constant.ErrorConstant;


public class HundsunAPIException extends BaseException {
	private static final long serialVersionUID = 908797897L;
	
	public HundsunAPIException(String msg) {
		super(ErrorConstant.ERROR_HUNDSUNAPI_WRONG, msg,GlobalConstant.ERROR_TYPE_SYSTEM);
	}
}
