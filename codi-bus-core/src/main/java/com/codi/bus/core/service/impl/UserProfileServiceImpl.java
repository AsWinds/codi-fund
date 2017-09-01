package com.codi.bus.core.service.impl;

import com.codi.base.util.DateUtil;
import com.codi.base.util.DateUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.UserProfileDao;
import com.codi.bus.core.domain.UserProfile;
import com.codi.bus.core.service.UserProfileService;
import com.codi.fcloud.ufx.constant.HsConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by Shangdu Lin on 2017/6/19 17:24.
 */
@Slf4j
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Resource(name = "userProfileDao")
    private UserProfileDao userProfileDao;

    /**
     * 查询用户资料
     *
     * @param userId
     * @return
     */
    @Override
    public UserProfile getByUserId(Long userId) {
        return userProfileDao.selectByUserId(userId);
    }

    /**
     * 新增或更新
     *
     * @param model
     */
    @Override
    public void addOrUpdate(UserProfile model) {
        UserProfile temp = userProfileDao.selectByUserId(model.getUserId());
        // 新增
        if (temp == null) {
            userProfileDao.insertSelective(model);
        } else {
            // 更新
            userProfileDao.updateByUserIdSelective(model);
        }
    }

    private static final String DATE_FORMAT = GlobalConstant.DATE_FORMAT_YYYYMMDD;

    @Override
    public String updateUserRiskLevelExpireTime(Long userId, String effectTimeStr) {
        if (StringUtil.isEmpty(effectTimeStr)) {
            log.warn("user risk level effect time is null, plz check!");
            return "";
        }

        Date expireTime = DateUtils.addMondth(DateUtil.parse(effectTimeStr, DATE_FORMAT), HsConst.USER_RISK_LEVEL_EFFECT_YEAR * 12);
        String expireTimeStr = DateUtil.format(expireTime, DATE_FORMAT);
        log.info("effectTime={},expireTime={}", effectTimeStr, expireTimeStr);


        UserProfile record = new UserProfile();
        record.setUserId(userId);
        record.setTestExpiredDate(expireTime);

        addOrUpdate(record);
        return expireTimeStr;
    }
}
