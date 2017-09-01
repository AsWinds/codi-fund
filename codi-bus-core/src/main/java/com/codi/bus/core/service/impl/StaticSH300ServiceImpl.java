package com.codi.bus.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.codi.base.cache.CacheUtil;
import com.codi.base.exception.BaseAppException;
import com.codi.base.util.DateUtils;
import com.codi.base.util.ListUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.StaticSH300Dao;
import com.codi.bus.core.domain.StaticSH300;
import com.codi.bus.core.service.StaticSH300Service;
import com.codi.bus.core.service.model.FundStatisticModel;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月3日 上午10:20:47
 */
@Service("staticSH300Service")
public class StaticSH300ServiceImpl implements StaticSH300Service {

    private static final Logger logger = LoggerFactory.getLogger(StaticSH300ServiceImpl.class);

    @Resource(name = "staticSH300Dao")
    private StaticSH300Dao staticSH300Dao;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public int clearAll() throws BaseAppException {
        return staticSH300Dao.deleteAll();
    }

    @Override
    public void addAll() throws BaseAppException {
        String key = CacheUtil.getKey("SH300", "ORIGIN");

        BoundHashOperations<String, String, String> op = redisTemplate.boundHashOps(key);

        Date createDate = new Date();
        List<StaticSH300> data = new ArrayList<>();
        BigDecimal lastClosePrice = null;
        for (String mapKey : op.keys()) {
            String line = op.get(mapKey);

            String[] array = line.split(" ");
            // 161020 3317.18 3318.60 3324.90 3312.17 79238871
            String tradingDate = array[0], openPrice = array[1], closePrice = array[2];
            String maxPrice = array[3], minPrice = array[4], turnoverVolume = array[5];

            StaticSH300 record = new StaticSH300();
            record.setTradingDate(DateUtils.stringToDate("20" + tradingDate, "yyyyMMdd"));
            record.setOpenPrice(new BigDecimal(openPrice));
            record.setMaxPrice(new BigDecimal(maxPrice));
            record.setMinPrice(new BigDecimal(minPrice));
            record.setTurnoverVolume(new BigDecimal(turnoverVolume));

            if (lastClosePrice == null) {
                lastClosePrice = new BigDecimal(closePrice);
                record.setClosePrice(lastClosePrice);
            } else {
                BigDecimal close = new BigDecimal(closePrice);
                record.setClosePrice(close);

                BigDecimal deltal = close.subtract(lastClosePrice);
                // 展示成%
                BigDecimal dailyGrowRate = deltal.divide(lastClosePrice, 5, BigDecimal.ROUND_HALF_EVEN)
                        .multiply(GlobalConstant.BIG_DECIMAL_100).setScale(2, BigDecimal.ROUND_HALF_EVEN);

                record.setDailyGrowthRate(dailyGrowRate);
                lastClosePrice = close;
            }

            record.setCreateDate(createDate);
            data.add(record);
        }
        if (ListUtil.isNotEmpty(data)) {
            staticSH300Dao.insertByBatch(data);
        } else {
            logger.warn("import SH300 is null, please notice.");
        }
    }

    @Override
    public void addLatestData() throws BaseAppException {
        String key = CacheUtil.getKey("SH300", "LATEST");
        BoundHashOperations<String, String, String> op = redisTemplate.boundHashOps(key);

        StaticSH300 latestRecord = getLatestRecord();
        if (latestRecord == null) {
            logger.error("Please execute SH300 ALL DATA JOB");
            return;
        }

        Date createDate = new Date();
        List<StaticSH300> data = new ArrayList<>();
        BigDecimal lastClosePrice = latestRecord.getClosePrice();

        for (String mapKey : op.keys()) {
            String line = op.get(mapKey);

            String[] array = line.split(" ");
            // 161020 3317.18 3318.60 3324.90 3312.17 79238871
            String tradingDate = array[0], openPrice = array[1], closePrice = array[2];
            String maxPrice = array[3], minPrice = array[4], turnoverVolume = array[5];

            Date tradingDay = DateUtils.stringToDate("20" + tradingDate, "yyyyMMdd");

            if (tradingDay.compareTo(latestRecord.getTradingDate()) <= 0) {
                continue;
            }
            StaticSH300 record = new StaticSH300();
            record.setTradingDate(tradingDay);
            record.setOpenPrice(new BigDecimal(openPrice));
            record.setMaxPrice(new BigDecimal(maxPrice));
            record.setMinPrice(new BigDecimal(minPrice));
            record.setTurnoverVolume(new BigDecimal(turnoverVolume));

            if (lastClosePrice == null) {
                lastClosePrice = new BigDecimal(closePrice);
                record.setClosePrice(lastClosePrice);
            } else {
                BigDecimal close = new BigDecimal(closePrice);
                record.setClosePrice(close);

                BigDecimal deltal = close.subtract(lastClosePrice);
                // 展示成%
                BigDecimal dailyGrowRate = deltal.divide(lastClosePrice, 5, BigDecimal.ROUND_HALF_EVEN)
                        .multiply(GlobalConstant.BIG_DECIMAL_100).setScale(2, BigDecimal.ROUND_HALF_EVEN);

                record.setDailyGrowthRate(dailyGrowRate);
                lastClosePrice = close;
            }

            record.setCreateDate(createDate);
            data.add(record);
        }

        if (ListUtil.isNotEmpty(data)) {
            staticSH300Dao.insertByBatch(data);
        } else {
            logger.warn("import SH300 is null, please notice.");
        }
    }

    @Override
    public List<FundStatisticModel> getStatisticData(int monthCount, Date endDate) throws BaseAppException {
        monthCount = monthCount < 0 ? 1 : monthCount;
        monthCount = monthCount > 12 ? 12 : monthCount; // 时间跨度不要超过一年

        endDate = (endDate == null) ? DateUtils.addDay(new Date(), -1) : endDate; // 默认是前一天

        String key = CacheUtil.getKey("SH300", "STATIC_MONTH", monthCount);
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        String valueStr = op.get(key);

        List<FundStatisticModel> result = JSON.parseArray(valueStr, FundStatisticModel.class);

        if (ListUtil.isEmpty(result)) {

            Date beginDate = DateUtils.addMondth(endDate, monthCount * -1);
            logger.debug("beginDate={},endDate={}", beginDate, endDate);
            List<StaticSH300> temp = staticSH300Dao.select(beginDate, endDate);

            result = new ArrayList<>(temp.size());
            for (StaticSH300 sh : temp) {
                FundStatisticModel model = new FundStatisticModel();
                model.setTradingDay(sh.getTradingDate());
                model.setRate(sh.getDailyGrowthRate());// 已经 是%
                model.setClosePrice(sh.getClosePrice());
                result.add(model);
            }

            op.set(key, JSON.toJSONString(result));
        } else {
            logger.debug("load from cache[{}]", key);
        }

        return result;
    }

    @Override
    public StaticSH300 getLatestRecord() throws BaseAppException {
        String key = CacheUtil.getKey("SH300", "MAX_TRADING_DATE_RECORD");

        ValueOperations<String, String> op = redisTemplate.opsForValue();

        String valueStr = op.get(key);
        StaticSH300 latestRecord = CacheUtil.getStrObj(redisTemplate, key, StaticSH300.class);
        if (StringUtil.isEmpty(valueStr)) {
            latestRecord = staticSH300Dao.selectLatest();
            CacheUtil.setStrObj(redisTemplate, key, latestRecord);
        } else {
            latestRecord = JSON.parseObject(valueStr, StaticSH300.class);
        }

        return latestRecord;
    }

}
