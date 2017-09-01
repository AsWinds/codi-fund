package com.codi.bus.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.codi.base.cache.CacheUtil;
import com.codi.bus.BaseTest;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月7日 下午9:50:27
 */
public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void commonTest() {
        ValueOperations<String, Object> op = redisTemplate.opsForValue();

        String key = CacheUtil.getKey("test", "spy", "string");
        // op.set(key, "This is test value");
        // op.set(key2, list);
        // expire in 2 min later //意义很重要
//        op.set(key, "普通型");
        System.out.println(op.get(key));
        // op.set(key, "this is test value", 2, TimeUnit.MINUTES);
        // System.out.println(op.get(key));

        // String key2 = CacheUtil.getKey("test", "spy", "list");
        //
        // // redisTemplate.setValueSerializer(new
        // // Jackson2JsonRedisSerializer<List>(List.class));
        // for (int i = 0; i < 10; i++) {
        // redisTemplate.opsForList().leftPush(key2, new Date());
        // }
    }

    @Test
    public void listTest() {
        String key2 = CacheUtil.getKey("test", "spy", "list");
        // 自定义类型
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Integer>(Integer.class));
        ListOperations<String, Object> op = redisTemplate.opsForList();
        for (int i = 0; i < 10; i++) {
            op.leftPush(key2, System.currentTimeMillis());
        }
        // redisTemplate.opsForList().rightPop(key, timeout, unit)
        // redisTemplate.opsForSet().
    }
}
