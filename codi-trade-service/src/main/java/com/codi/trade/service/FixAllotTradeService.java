package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 定期定额申购协议签约
 * 
 * @author song-jj
 *
 */
public interface FixAllotTradeService {

    /**
     * 定期定额申购协议签约
     * @param capitalMode
     * @param password
     * @param tradeAcco
     * @param tradeSource
     * @param fundCode
     * @param balance
     * @param shareType
     * @param protocolPeriodUnit
     * @param protocolFixDay
     * @return
     */
    Map<String, Object> fix(String capitalMode, String password, String tradeAcco, String tradeSource, String fundCode,
            BigDecimal balance, String shareType, String protocolPeriodUnit, Long protocolFixDay);
}
