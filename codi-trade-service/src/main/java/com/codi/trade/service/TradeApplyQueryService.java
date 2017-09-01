package com.codi.trade.service;

import java.util.Map;

public interface TradeApplyQueryService {

	// 交易申请查询
	Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
				String taAcco, String clientId, String beginDate, String endDate, String allotNo, String taConfirmFlag,
				String tradeAccount, String fundCode, String businCode, String deductStatus, String originalAppNo,
				String boardType, String trafficFlag, String targetFundCode);
}
