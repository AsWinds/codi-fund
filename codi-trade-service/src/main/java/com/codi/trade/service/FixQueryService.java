/**
 * 
 */
package com.codi.trade.service;

import java.util.Map;

/**
 * @author song-jj
 *
 */
public interface FixQueryService {
    /**
     * 定期定额协议查询（全部参数）
     * @param requestNum 请求行数
     * @param queryFlag 重新统计总记录数标志
     * @param beginNum 查询起始行号
     * @param sortDirection 返回排序方式
     * @param clientId 客户编号
     * @param tradeAccount 交易账号
     * @param scheduledProtocolId 定投协议号
     * @param taAcco TA账号
     * @param protocolName 协议名称
     * @param fundCode 基金代码
     * @param tradeSource 交易来源
     * @param businBoardType 业务大类
     * @return 已定投的基金
     */
    Map<String, Object> query(String netNo, Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String clientId, String tradeAccount, String scheduledProtocolId, String taAcco, String protocolName, String fundCode,
            String tradeSource, String businBoardType);
    
    /**
     * 定期定额协议查询（部分参数）
     * @param requestNum 请求行数
     * @param queryFlag 重新统计总记录数标志
     * @param beginNum 查询起始行号
     * @param sortDirection 返回排序方式
     * @param clientId 客户编号
     * @return 已定投的基金
     */
    Map<String, Object> query(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
            String clientId);
}
