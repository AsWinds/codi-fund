package com.codi.trade.service;

import java.util.Date;
import java.util.Map;

public interface NextDayQueryService {
    /**
     * 获取下一工作日,默认只传回一条记录，不管request_num是否比1大
     * 
     * @param currentDate
     * @return
     */
    Map<String, Object> query(Date currentDate);
}
