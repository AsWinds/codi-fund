package com.codi.trade.service.paperinfo;

import com.codi.trade.dto.QuestionQueryDto;

import java.util.List;
import java.util.Map;

/**
 * 查询风险试题
 *
 * @author shi.pengyan
 * @date 2017-06-21 13:36
 */
public interface QuestionQueryService {

    /**
     * 查询试题
     *
     * @param dto
     * @return
     */
    List<Map<String, Object>> query(QuestionQueryDto dto);
}
