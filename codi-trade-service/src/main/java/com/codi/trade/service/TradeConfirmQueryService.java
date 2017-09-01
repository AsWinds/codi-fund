package com.codi.trade.service;

import java.util.Map;

public interface TradeConfirmQueryService {
	//交易确认请求
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String taAcco, String clientId, String beginDate, String endDate, String allotNo, String taConfirmFlag,
			String tradeAccount, String fundCode, String businCode, String trafficFlag, String targetFundCode,
			String taSerialId, String fundType, String targetFundType, String capitalMode, String scheduledProtocolId);
	//交易确认请求
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String clientId, String taConfirmFlag, String tradeAccount);
}
