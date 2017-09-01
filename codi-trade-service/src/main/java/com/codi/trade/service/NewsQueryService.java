package com.codi.trade.service;

import java.util.Map;

public interface NewsQueryService {
	// 最新基金行情查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode, String fundType, String fundStatus, String riskLevel);
}
