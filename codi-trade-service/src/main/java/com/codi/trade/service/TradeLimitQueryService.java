package com.codi.trade.service;

import java.util.Map;

public interface TradeLimitQueryService {
	//交易限制查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode, String shareType, String capitalMode, String businCode, String customType);
}
