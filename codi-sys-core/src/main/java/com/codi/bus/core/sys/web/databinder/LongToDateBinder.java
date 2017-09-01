package com.codi.bus.core.sys.web.databinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class LongToDateBinder extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new Date(Long.parseLong(text)));
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	@Override
	public String getAsText() {
		return String.valueOf(((Date)getValue()).getTime());
	}

}
