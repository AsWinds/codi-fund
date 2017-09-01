package com.codi.trade.service;

import java.util.Map;

/**
 * 系统参数查询
 *
 * @author shi.pengyan
 * @version 1.0 2017-07-05 13:27
 * @since 1.0
 */
public interface SystemParameterQueryService {

    /**
     * 系统参数查询
     *
     * @param paramItem  参数项
     * @param paramClass 分类
     * @return
     */
    Map<String, Object> query(String paramItem, String paramClass);

    /**
     * 查询系统参数
     *
     * @param paramItem 参数项
     * @return
     */
    Map<String, Object> query(String paramItem);
}
