package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.trade.dto.ClientInfoQueryDto;
import com.codi.trade.service.ClientInfoQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 11:02
 */
@Slf4j
public class ClientInfoQueryTest extends BaseHundSunTest {

    @Autowired
    private ClientInfoQueryService clientInfoQueryService;


    @Test
    public void queryTest() {
        Map<String, Object> map = clientInfoQueryService.queryByTradeAcco(trade_acco);
        log2(map);
        log(map);
    }

    @Test
    public void run() {
        trade_acco = "0315";// 交易账号在ub_user_bank表中，欧阳妮妮
        ClientInfoQueryDto dto = new ClientInfoQueryDto();
        dto.setTrade_acco(trade_acco);


        Map<String, Object> map = clientInfoQueryService.query(dto);

        log2(map);
        log(map);

    }

    @Test
    public void run2() {
        trade_acco = "0327";
        ClientInfoQueryDto dto = new ClientInfoQueryDto();
        dto.setTrade_acco(trade_acco);


        Map<String, Object> map = clientInfoQueryService.query(dto);

        log2(map);
        log(map);
    }


}
