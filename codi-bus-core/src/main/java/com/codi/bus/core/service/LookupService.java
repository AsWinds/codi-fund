package com.codi.bus.core.service;

import com.codi.bus.core.domain.Lookup;
import com.codi.bus.exception.BaseException;

import java.util.List;

public interface LookupService {

    /**
     * 根据字典类型获取所有字典值
     *
     * @param lookupType
     * @return
     * @throws BaseException
     */
    List<Lookup> getLookups(String lookupType) throws BaseException;

    /**
     * 根据字典类型，字典值获取字典项
     * @param lookupType
     * @param lookupValue
     * @return
     * @throws BaseException
     */
    Lookup getLookup(String lookupType, String lookupValue) throws BaseException;
}
