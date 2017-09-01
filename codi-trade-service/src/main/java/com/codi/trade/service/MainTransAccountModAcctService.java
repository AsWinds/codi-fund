package com.codi.trade.service;

import java.util.Map;

public interface MainTransAccountModAcctService {
	/*变更主交易账号
	 变更主交易账号是指客户想要解绑开户时的银行卡，可以变更主交易账号到增开的交易账号，变更需要指交易账户三无状态*/
	Map<String, Object> replace(String tradeAccount, String taAccount, String password, String originalTradeAccount);
}
