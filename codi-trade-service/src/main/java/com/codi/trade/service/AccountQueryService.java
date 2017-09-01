package com.codi.trade.service;

import java.util.Map;

public interface AccountQueryService {
	//TA帐号查询 通过TA账号查询可以获取到交易账号状态，TA账号状态，是否是主交易账号，客户编号，所有的交易账号，TA编号等
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String tradeAccount,
			String taAcco, String clientId, String custType, String cardType, String idCard);
}
