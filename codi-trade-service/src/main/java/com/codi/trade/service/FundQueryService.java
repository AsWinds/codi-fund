package com.codi.trade.service;

import java.util.Map;

public interface FundQueryService {
	// 基金查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode);
}
