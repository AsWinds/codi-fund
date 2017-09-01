package com.codi.fcloud.ufx;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.codi.base.util.Assert;
import com.codi.bus.constant.GlobalConstant;

public class HsResponseUtil {

	public static boolean isOperationOk(Map<String, Object> op_res){
		if (StringUtils.isBlank((String) op_res.get("error_code"))) {
			return true;
		}
		return false;
	}
	
	public static boolean isOperationOk(List<Map<String, Object>> op_res){
		Assert.notEmpty(op_res);
		if (op_res.size() != 1) {
			return true;
		}
		Map<String, Object> first = op_res.get(0);
		return isOperationOk(first);
	}
	
	public static Map<String, Object> removeAdditionInfo(Map<String, Object> map){
		String[] keys = {GlobalConstant.KEY_REQUEST, GlobalConstant.KEY_RESPONSE, GlobalConstant.KEY_API};
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			if (map.containsKey(key)) {
				map.remove(key);
			}
		}
		return map;
	}
}
