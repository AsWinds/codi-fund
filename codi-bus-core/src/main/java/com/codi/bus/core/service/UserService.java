package com.codi.bus.core.service;

import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.domain.UserSession;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.vo.UserProfileVo;
import com.codi.bus.exception.BaseException;

public interface UserService {
    /**
     * 开户
     * 2017.7.1之后不再使用 shi.pengyan 2017-6-19 16:08:11
     *
     * @param entity
     * @param bankEntity
     * @return
     * @throws BaseException
     */
    @Deprecated
    AccountOpenResult openAccount(User entity, UserBank bankEntity) throws BaseException;

    /**
     * 开户服务
     * 2017.7.1 之后使用
     *
     * @param entity
     * @param userProfileVo
     * @param bankEntity
     * @return
     * @throws BaseException
     * @author shi.pengyan
     * @date 2017-6-19 16:09:34
     */
    AccountOpenResult openAccountNew(User entity, UserProfileVo userProfileVo, UserBank bankEntity) throws BaseException;

    void update(User entity) throws BaseException;

    Boolean checkMobile(String mobile) throws BaseException;

    Boolean checkVerifyCode(String mobile, String authCode, String bizCode) throws BaseException;

    Boolean checkIDCard(String idCard) throws BaseException;

    Boolean checkBankNo(String bankNo, String capitalMode) throws BaseException;

    String registerAccount(User entity, UserSession sessionEntity, String ip) throws BaseException;

    LoginResult login(String loginName, String password, String deviceId, String channelId, String ip) throws BaseException;

    String generateToken(Long userId, String deviceId, String channelId, String ip) throws BaseException;

    ValidateTokenResult validateToken(String token, String deviceId) throws BaseException;

    ValidateTokenResult validateToken(String token, String ip, String deviceId, boolean generateNewToken) throws BaseException;

    CardBinResult validateCardInfo(String cardNo) throws BaseException;

    User getUser(Long userId) throws BaseException;

    User getUserByToken(String token) throws BaseException;

    PaySignResult paySign_Step_One(User entity, UserBank bankEntity) throws BaseException;

    PaySignResult paySign_Step_Two(User entity, UserBank bankEntity, String originalSerialNo, String smsSerialNo,
                                   String mobileCode) throws BaseException;

    BaseResult update_password(Long user_id, String old_password, String new_password);

    // 新增交易账号
    AccountOpenResult addAccount(Long userId, String idNo, String tradePassword, String userName, String bankCode,
                                 String bankNo, String bankName, String mobile, String capitalMode, String externalProtocolNo)
        throws BaseException;

    // 变更主交易账号并且解绑银行卡
    BaseResult repalceAndCloseTradeAccount(long userId, String password, String bankCard, String capitalMode)
        throws BaseException;

    // 交易账号销户
    BaseResult closeAccount(String tradeAccount, String taAccount, String password) throws BaseException;

    // 变更主交易账号
    BaseResult replaceAccount(String newMainAccount, String taAccount, String password, String originalMainAccount)
        throws BaseException;

    BaseResult resetLoginPassword(String mobile, String verification_code, String new_passwd) throws BaseException;

    BaseResult resetTradePassword(Long userId, String id_card, String mobile, String verification_code, String new_passwd) throws BaseException;

    BaseResult verifyVerificationCode(String mobile, String code, String bizCode);

    BaseResult verifyUserIdAndMobile(String id_card, String mobile, String verification_code);

    /**
     * 判断用户是否开户
     *
     * @param userId
     * @return
     */
    boolean checkAccountOpen(Long userId);

}
