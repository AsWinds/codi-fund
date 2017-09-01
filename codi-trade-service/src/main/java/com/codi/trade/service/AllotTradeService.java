package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

public interface AllotTradeService {
	Map<String, Object> buy(String capitalMode, Integer moneyType, String tradeAcco, String password, String fundCode,
			String bankCode, String bankAccount, BigDecimal balance, String shareType, String tradeSource);
}
