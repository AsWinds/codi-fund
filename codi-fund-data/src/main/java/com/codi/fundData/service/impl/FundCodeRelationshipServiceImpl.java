package com.codi.fundData.service.impl;

import com.alibaba.fastjson.JSON;
import com.codi.base.cache.CacheUtil;
import com.codi.base.domain.BaseServiceImpl;
import com.codi.base.util.ListUtil;
import com.codi.bus.constant.CacheKeyConst;
import com.codi.bus.constant.FundConst;
import com.codi.fundData.dao.FundCodeRelationshipDao;
import com.codi.fundData.domain.FundCodeRelationship;
import com.codi.fundData.service.FundCodeRelationshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author shi.pengyan
 * @date 2016年11月23日 上午10:28:16
 */
@Service("fundCodeRelationshipService")
public class FundCodeRelationshipServiceImpl extends BaseServiceImpl implements FundCodeRelationshipService {

    private static final Logger logger = LoggerFactory.getLogger(FundCodeRelationshipServiceImpl.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "fundCodeRelationshipDao")
    private FundCodeRelationshipDao fundCodeRelationshipDao;

    @Override
    public List<FundCodeRelationship> getCodeRelationships(Integer relatedInnerCode, Integer ifEffected) {
        logger.debug("relatedInnerCode={},ifEffected={}", relatedInnerCode, ifEffected);

        String key = CacheUtil.getKey(CacheKeyConst.MF_FUND_CODE_RELATIONSHIP_NEW, relatedInnerCode, ifEffected);

        String listStr = CacheUtil.getStr(redisTemplate, key);
        if (FundConst.NONE.equalsIgnoreCase(listStr)) {
            return null;
        }

        List<FundCodeRelationship> list = JSON.parseArray(listStr, FundCodeRelationship.class);
        if (ListUtil.isEmpty(list)) {
            logger.debug("key=[{}] not in cache, query in DB", key);
            list = fundCodeRelationshipDao.queryCodeRelationships(relatedInnerCode,
                    FundConst.CODE_DEFINE_SAME_FUND_CASCADE, ifEffected);
            if (ListUtil.isNotEmpty(list)) {
                logger.debug("fund code relation is not null, set cache");
                CacheUtil.setStrList(redisTemplate, key, list);
            } else {
                CacheUtil.setStr(redisTemplate, key, FundConst.NONE);
            }
        }

        return list;
    }

    @Override
    public void refreshCodeRelationshipCache(Integer relatedInnerCode) {
        int ifEffected = FundConst.CODE_EFFECT_YES;

        logger.debug("relatedInnerCode={},ifEffected={}", relatedInnerCode, ifEffected);
        String key = CacheUtil.getKey(CacheKeyConst.MF_FUND_CODE_RELATIONSHIP_NEW, relatedInnerCode, ifEffected);

        List<FundCodeRelationship> list = fundCodeRelationshipDao.queryCodeRelationships(relatedInnerCode,
                FundConst.CODE_DEFINE_SAME_FUND_CASCADE, ifEffected);
        if (ListUtil.isNotEmpty(list)) {
            logger.debug("fund code relation is not null, set cache");
            CacheUtil.setStrList(redisTemplate, key, list);
        } else {
            CacheUtil.setStr(redisTemplate, key, FundConst.NONE);
        }
    }
}
