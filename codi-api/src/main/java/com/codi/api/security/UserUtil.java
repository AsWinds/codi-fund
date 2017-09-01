package com.codi.api.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public abstract class UserUtil {

    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();

    /**
     * update thread local as param, return old one
     */
    public static Long setUserId(Long userId) {
        Long now = LOCAL.get();
        LOCAL.set(userId);
        return now;
    }

    public static Long clear() {
        Long userId = LOCAL.get();
        if (userId != null) {
            log.debug("Clear user:" + userId);
        }
        LOCAL.remove();
        return userId;
    }

    /**
     * 获取当前登录的用户, 如果没有找到, 抛出异常
     */
    public static Long getLoginUserId() {
        Long userId = LOCAL.get();
        Assert.notNull(userId);
        return userId;
    }


}
