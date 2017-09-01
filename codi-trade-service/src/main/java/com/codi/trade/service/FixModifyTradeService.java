package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 定期定额协议变更
 * @author song-jj
 */
public interface FixModifyTradeService {
    Map<String, Object> modifyFix(String capitalMode, String password, String tradeAcco, String tradeSource, String fundCode,
            BigDecimal balance, String shareType, String protocolPeriodUnit, Long protocolFixDay,
            String scheduledProtocolId, String fixModel, String expiryDate);
}
