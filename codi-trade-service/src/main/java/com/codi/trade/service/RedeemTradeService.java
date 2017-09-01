package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

public interface RedeemTradeService {
	// 赎回基金
	Map<String, Object> sell(String capitalMode, String tradeAcco, String password, String fundCode,
			String shareType, BigDecimal shares, String tradeSource);
}
