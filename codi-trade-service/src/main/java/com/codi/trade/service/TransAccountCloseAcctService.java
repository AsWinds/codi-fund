package com.codi.trade.service;

import java.util.Map;

public interface TransAccountCloseAcctService {
	// 交易账号销户一般用于销非主交易账号，就是解绑增开的银行卡
	Map<String, Object> closeAccount(String tradeAccount, String taAccount, String password);
}
