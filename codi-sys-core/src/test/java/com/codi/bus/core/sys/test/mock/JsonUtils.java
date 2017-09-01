package com.codi.bus.core.sys.test.mock;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	
	public static void prettyJson(Object obj){
		
		String json = JSON.toJSONString(obj, true);
		System.out.println(json);
	}

}
