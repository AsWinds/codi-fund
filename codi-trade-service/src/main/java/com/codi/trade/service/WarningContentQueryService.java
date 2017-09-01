package com.codi.trade.service;

import com.codi.trade.dto.WarningContentQueryDto;

import java.util.Map;

/**
 * 警示内容查询
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:50
 */
public interface WarningContentQueryService {

    /**
     * 查询警示内容
     *
     * @param dto
     * @return
     */
    Map<String, Object> query(WarningContentQueryDto dto);

}
