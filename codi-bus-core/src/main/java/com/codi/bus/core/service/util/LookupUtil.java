package com.codi.bus.core.service.util;

import java.util.List;

import com.codi.base.util.ListUtil;
import com.codi.bus.core.domain.Lookup;

public class LookupUtil {

	/***
	 * 获取字典值
	 * @param lookups
	 * @param value
	 * @return
	 */
	public static String getText(List<Lookup> lookups, String value){
		if(ListUtil.isEmpty(lookups)){
			return value;
		}
		
		for (Lookup lookup : lookups) {
			if(lookup.getRuleValue().equals(value)){
				return lookup.getRuleText();
			}			
		}
		
		return value;
	}
}
