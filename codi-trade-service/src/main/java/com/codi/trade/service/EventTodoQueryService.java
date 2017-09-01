package com.codi.trade.service;

import com.codi.trade.dto.EventTodoQueryDto;

import java.util.Map;

/**
 * 代办事项查询
 *
 * @author shi.pengyan
 * @date 2017-05-26 14:36
 */
public interface EventTodoQueryService {


    /**
     * 查询代办事项
     *
     * @param eventTodoQueryDto
     * @return
     */
    Map<String, Object> query(EventTodoQueryDto eventTodoQueryDto);

    /**
     * 查询代办事项
     * @param client_id
     * @param qry_beginrownum
     * @param sort_direction
     * @param request_num
     * @param reqry_recordsum_flag
     * @param fund_busin_code
     * @return
     */
    Map<String, Object> query(String client_id, Integer qry_beginrownum,
                              String sort_direction, Integer request_num, Integer reqry_recordsum_flag,
                              String fund_busin_code);
}
