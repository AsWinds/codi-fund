package com.codi.trade.service;

import java.util.Map;

public interface UndoTradeApplyService {
	//撤单
	Map<String, Object> undo(String originalApplyNo, String tradePassword, String tradeAcco,
			String tradeSource);
}
