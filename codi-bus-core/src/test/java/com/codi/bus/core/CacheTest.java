package com.codi.bus.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.codi.base.cache.CacheUtil;
import com.codi.bus.core.service.model.FundSortModel;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月11日 下午4:52:38
 */
public class CacheTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplateObj;

    @Test
    public void multiKeyTest() {
        Set<String> keys = redisTemplate.keys("MF_SECUMAIN:*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void listTest() {
        String key = CacheUtil.getKey("test", "spy", "list");
        BoundListOperations<String, String> listOps = redisTemplate.boundListOps(key);

        listOps.rightPushAll("1", "2", "3");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            FundSortModel model = new FundSortModel();
            model.setFundName("fundName2" + i);
            list.add(JSON.toJSONString(model));
        }

        // 只有list<String> 才不会转换成单个对象
        ListOperations<String, String> listOp = redisTemplate.opsForList();
        listOp.rightPushAll(key, list);

        List<String> result = listOp.range(key, 10, 100);
        for (String temp : result) {
            System.out.println(temp);
        }

    }
}
