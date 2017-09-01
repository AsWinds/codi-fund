package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

public interface ShareQueryService {
	//查询份额
	Map<String, Object> query(Integer requestNum, Integer queryflag, Integer beginNum,
			String tradeAccount, String sortDirection, String taAccount, String fundCode, String shareType,
			String clientId, String fundType, String bankNo, BigDecimal totalShare);
}
