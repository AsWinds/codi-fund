package com.codi.trade.service;

import com.codi.trade.dto.WarningMarkDto;

import java.util.Map;

/**
 * 警示留痕服务
 *
 * @author shi.pengyan
 * @date 2017-06-02 15:08
 */
public interface WarningMarkService {

    Map<String, Object> save(WarningMarkDto dto);
}
