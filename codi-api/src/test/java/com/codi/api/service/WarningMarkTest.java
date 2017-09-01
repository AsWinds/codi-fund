package com.codi.api.service;

import com.codi.api.BaseTest;
import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.resultModel.PageResult;
import com.codi.bus.core.service.WarningMarkHisService;
import com.codi.bus.core.vo.WarningMarkHisSearchModel;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-26 13:43
 */
@Slf4j
public class WarningMarkTest extends BaseTest {

    @Autowired
    private WarningMarkHisService warningMarkHisService;

    @Test
    public void run() {
        WarningMarkHis his = new WarningMarkHis();

        warningMarkHisService.addLocalAndSync(his);
    }

    @Test
    public void run2() {
        WarningMarkHisSearchVo record = new WarningMarkHisSearchVo();
        record.setClientName("欧阳");

        Pageable pageable = new PageRequest(1, 10);

        Page<WarningMarkHisSearchModel> page = warningMarkHisService.search(record, pageable);

        PageResult<WarningMarkHisSearchModel> result = new PageResult<>(page);

        print(result);
    }


    @Test
    public void run3() {
        WarningMarkHisSearchVo record = new WarningMarkHisSearchVo();
        record.setClientName("欧阳");

        Pageable pageable = null;

        Page<WarningMarkHisSearchModel> page = warningMarkHisService.search(record, pageable);

        PageResult<WarningMarkHisSearchModel> result = new PageResult<>(page);

        print(result);
    }
}
