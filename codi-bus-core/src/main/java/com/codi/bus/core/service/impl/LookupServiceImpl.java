package com.codi.bus.core.service.impl;

import com.codi.base.util.ExceptionUtil;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.LookupKey;
import com.codi.bus.core.service.LookupService;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lookupService")
public class LookupServiceImpl implements LookupService {

    private static final Logger logger = LoggerFactory.getLogger(LookupServiceImpl.class);

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    /**
     * 根据字典类型获取所有字典值
     *
     * @param lookupType
     * @return
     * @throws BaseException
     */
    @Override
    public List<Lookup> getLookups(String lookupType) throws BaseException {

        try {
            return lookupDao.getLookupByType(lookupType);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getLookups - Exception:", exception);
            throw new SystemDBException("getLookups Failure!", exception);
        }
    }

    /**
     * 根据字典类型，字典值获取字典项
     *
     * @param lookupType
     * @param lookupValue
     * @return
     * @throws BaseException
     */
    @Override
    public Lookup getLookup(String lookupType, String lookupValue) throws BaseException {
        try {
            LookupKey key=new LookupKey();
            key.setRuleType(lookupType);
            key.setRuleValue(lookupValue);
            return lookupDao.getLookupByKey(key);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getLookup - Exception:", exception);
            throw new SystemDBException("getLookup Failure!", exception);
        }
    }

}
