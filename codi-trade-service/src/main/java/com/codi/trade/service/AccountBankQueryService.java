package com.codi.trade.service;

import java.util.Map;

public interface AccountBankQueryService {
	// 份额查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
				String tradeAccount, String clientId, String capitalMode);
}
