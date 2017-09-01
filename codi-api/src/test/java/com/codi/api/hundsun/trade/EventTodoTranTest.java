package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.trade.dto.EventTodoTranDto;
import com.codi.trade.service.EventTodoTranService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:31
 */
@Slf4j
public class EventTodoTranTest extends BaseHundSunTest {

    @Autowired
    private EventTodoTranService eventTodoTranService;

    private String todo_serial_no;

    @Before
    public void before() {
        todo_serial_no = ""; //TODO
    }

    @Test
    public void run() {
        EventTodoTranDto dto = new EventTodoTranDto();

        dto.setTrade_acco(trade_acco);
        dto.setTodo_serial_no(todo_serial_no);

        Map<String, Object> map = eventTodoTranService.dealWith(dto);

        log2(map);
        log(map);
    }
}
