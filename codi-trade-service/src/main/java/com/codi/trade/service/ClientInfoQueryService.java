package com.codi.trade.service;

import com.codi.trade.dto.ClientInfoQueryDto;

import java.util.Map;

/**
 * 客户资料查询接口
 *
 * @author shi.pengyan
 * @date 2017-05-25 10:40
 */
public interface ClientInfoQueryService {

    /**
     * 通过交易账号查询客户信息
     *
     * @param tradeAcco
     * @return
     */
    Map<String, Object> queryByTradeAcco(String tradeAcco);

    /**
     * 查询用户信息
     *
     * @param dto
     * @return
     */
    Map<String, Object> query(ClientInfoQueryDto dto);

}
