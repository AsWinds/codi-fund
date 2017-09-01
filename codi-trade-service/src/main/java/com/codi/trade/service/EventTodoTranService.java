package com.codi.trade.service;

import com.codi.trade.dto.EventTodoTranDto;

import java.util.Map;

/**
 * 代办事项处理
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:19
 */
public interface EventTodoTranService {

    /**
     * 处理待办事项
     *
     * @param dto
     * @return
     */
    Map<String, Object> dealWith(EventTodoTranDto dto);

}
