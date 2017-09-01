package com.codi.admin.controller;

import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.PageResult;
import com.codi.bus.core.service.WarningMarkHisService;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 警示留痕
 *
 * @author shi.pengyan
 * @date 2017-06-26 15:44
 */
@Slf4j
@RestController
@RequestMapping("warning_mark")
public class WarningMarkController {

    @Autowired
    private WarningMarkHisService warningMarkHisService;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public BaseResult search(@Validated WarningMarkHisSearchVo warningMarkHisSearchVo,
                             Pageable pageable) {

        log.info("pageable={}", pageable);

        return new PageResult<>(warningMarkHisService.search(warningMarkHisSearchVo, pageable));
    }

}
