package com.codi.bus.exception;

import com.codi.bus.constant.GlobalConstant;
import com.codi.message.constant.ErrorConstant;

/**
 * {FIELD}不能为空
 * errorCode = 1008
 */
public class InterfaceFieldNoFindExcepiton extends BaseException {
	
	private static final long serialVersionUID = 1781166217698233848L;
	
	public InterfaceFieldNoFindExcepiton(String msg) {
		super(GlobalConstant.ERROR_TYPE_BUSINESS, ErrorConstant.ERROR_FIELD_NO_FIND, msg, null);
	}
}
