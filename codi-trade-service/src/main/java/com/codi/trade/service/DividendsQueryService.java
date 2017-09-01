package com.codi.trade.service;

import java.util.Map;

/**
 * Created by Shangdu Lin on 2017/6/12 11:17.
 */
public interface DividendsQueryService {
    /**
     * 分红明细查询
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param tradeAccount
     * @param taAccount
     * @param clientId
     * @param fundCode
     * @return
     */
    Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
                              String tradeAccount, String taAccount, String clientId, String fundCode);
}
