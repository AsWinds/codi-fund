package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.trade.dto.WarningMarkDto;
import com.codi.trade.service.WarningMarkService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-02 15:29
 */
@Slf4j
public class WarningMarkServiceTest extends BaseHundSunTest {

    @Autowired
    private WarningMarkService warningMarkService;


    private String warning_no;


    @Before
    public void before() {
//        "warning_channel":"2",
//        "warning_content":"可能造成本金亏损的警示\n\n您的风险等级为{1}，适合购买{2}风险及以下的基金产品\n\n",
//        "warning_no":"0601000023",
//        "warning_state":"1",
//        "warning_type":"A"

        warning_no = "0601000023";
    }

    @Test
    public void run() {
        WarningMarkDto dto = new WarningMarkDto();
        dto.setTrade_acco(trade_acco);
        dto.setWarning_no(warning_no);

        warningMarkService.save(dto);
    }
}
