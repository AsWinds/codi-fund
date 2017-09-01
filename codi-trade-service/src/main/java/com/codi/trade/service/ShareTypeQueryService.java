package com.codi.trade.service;

import java.util.Map;

public interface ShareTypeQueryService {
	// 份额类别查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
				String fundCode, String fundName);
}
