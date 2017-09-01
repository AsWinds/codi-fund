package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.trade.dto.WarningContentQueryDto;
import com.codi.trade.service.WarningContentQueryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-31 14:07
 */
@Slf4j
public class WarningContentQueryTest extends BaseHundSunTest {

    @Autowired
    private WarningContentQueryService warningContentQueryService;

    @Test
    public void run() {
        WarningContentQueryDto dto = new WarningContentQueryDto();
        dto.setTrade_acco(trade_acco).setQry_beginrownum(1).setWarning_channel(HsConst.WARNING_CHANNEL_APP)
            .setWarning_type(HsConst.WARNING_TYPE_BEFORE_BUY);

        Map<String, Object> map = warningContentQueryService.query(dto);

        log2(map);
        log(map);
    }

}
