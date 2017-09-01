package com.codi.trade.service;

import java.util.Map;

public interface TradeAccountAddAcctService {
	//增开交易账号
	Map<String, Object> addAcct(String idNo, String tradePassword, String userName, String bankCode,
			String bankNo, String bankName, String mobile, String fundCard, String capitalMode, String mainTradeAccount);
}
