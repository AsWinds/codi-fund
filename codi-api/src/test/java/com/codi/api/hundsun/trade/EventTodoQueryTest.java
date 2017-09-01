package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.trade.dto.EventTodoQueryDto;
import com.codi.trade.service.EventTodoQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-31 11:10
 */
@Slf4j
public class EventTodoQueryTest extends BaseHundSunTest {

    @Autowired
    private EventTodoQueryService eventTodoQueryService;


    @Test
    public void run() {
        EventTodoQueryDto dto = new EventTodoQueryDto();
        dto.setQry_beginrownum(1).setSort_direction(HsConst.SORT_DIRECTION_ASC)
            .setRequest_num(50).setReqry_recordsum_flag(HsConst.REQRY_RECORDSUM_FLAG_NO_REFRESH);

        Map<String, Object> map = eventTodoQueryService.query(dto);
        log2(map);
        log(map);

    }


    @Test
    public void run2() {
// oh shit!
        Map<String, Object> map = eventTodoQueryService.query(null, 1, "0", 50, 0,  null);

        log2(map);
        log(map);
    }


}
