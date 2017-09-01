package com.codi.bus.core.service;

import com.codi.bus.core.domain.UserProfile;

/**
 * Created by Shangdu Lin on 2017/6/19 17:22.
 */
public interface UserProfileService {
    /**
     * 查询用户资料
     *
     * @param userId
     * @return
     */
    UserProfile getByUserId(Long userId);

    /**
     * 新增或更新
     *
     * @param model
     */
    void addOrUpdate(UserProfile model);

    /**
     * 更新用户风险测评过期时间
     *
     * @param userId        userId
     * @param effectTimeStr YYYYMMDD 格式
     * @return
     */
    String updateUserRiskLevelExpireTime(Long userId, String effectTimeStr);

}
