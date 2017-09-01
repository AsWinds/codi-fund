package com.codi.api.validation;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.codi.base.cache.CacheUtil;
import com.codi.base.util.MoneyUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.annotation.Validator;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.util.SignUtil;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Validator
public class TradeValidation implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(TradeValidation.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 交易申请编号， 用于防止重复提交交易
    private ValueOperations<String, String> applyCache;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 申请编号
        applyCache = redisTemplate.opsForValue();
    }

    public BaseResult baseValidate(String bankAccount, String paymentType, String fundName, String fundCode,
            String tradePassword) {
        BaseResult result = new BaseResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(bankAccount)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行账号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(paymentType)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "支付方式");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(fundName)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "基金名称");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(fundCode)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "基金代码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(tradePassword)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "交易密码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        return null;
    }

    // 验证申购输入参数
    public BaseResult validateBuy(String bankAccount, String paymentType, Integer moneyType, String fundName,
            String fundCode, BigDecimal fundBalance, String tradePassword, String token, String applyNo, long userId,
            String sign) {

        BaseResult result = null;

        result = baseValidate(bankAccount, paymentType, fundName, fundCode, tradePassword);
        if (result != null) {
            return result;
        }

        // 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
        if (MoneyUtils.compareTo(fundBalance, 0) != 1) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "购买金额"));
            return result;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token);
        sortMap.put("bankAccount", bankAccount);
        sortMap.put("paymentType", paymentType);
        sortMap.put("moneyType", moneyType);
        sortMap.put("fundName", fundName);
        sortMap.put("fundCode", fundCode);
        sortMap.put("fundBalance", fundBalance);
        sortMap.put("tradePassword", tradePassword);
        sortMap.put("applyNo", applyNo);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));

            return result;
        }

        // 验证是否重复提交, 5分钟过期
        applyNo = applyNo + userId;

        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_BUY, applyNo);
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_APPLY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_APPLY, null));

            return result;
        }
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);

        return null;
    }

    // 验证申购输入参数
    public BaseResult validateSell(String bankAccount, String paymentType, String fundName, String fundCode,
            BigDecimal shares, String tradePassword, String token, String applyNo, String sign, long userId) {

        BaseResult result = null;

        result = baseValidate(bankAccount, paymentType, fundName, fundCode, tradePassword);
        if (result != null) {
            return result;
        }

        // 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
        if (MoneyUtils.compareTo(shares, 0) != 1) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "赎回份额");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token);
        sortMap.put("bankAccount", bankAccount);
        sortMap.put("paymentType", paymentType);
        sortMap.put("fundName", fundName);
        sortMap.put("fundCode", fundCode);
        sortMap.put("shares", shares);
        sortMap.put("tradePassword", tradePassword);
        sortMap.put("applyNo", applyNo);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return result;
        }

        // 验证是否重复提交, 5分钟过期
        applyNo = applyNo + userId;
        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_SELL, applyNo);
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_APPLY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_APPLY, null));
            return result;
        }
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);

        return null;
    }

    // 验证申购输入参数
    public BaseResult validateUndo(String originalApplyNo, String tradePassword, String token, String applyNo,
            long userId, String sign) {

        BaseResult result = new BaseResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(tradePassword)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "交易密码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(originalApplyNo)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "申请编号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token);
        sortMap.put("originalApplyNo", originalApplyNo);
        sortMap.put("tradePassword", tradePassword);
        sortMap.put("applyNo", applyNo);
        String requestString = SignUtil.getRequestString(sortMap);
        logger.info("undo - Request String:" + requestString);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return result;
        }

        // 验证是否重复提交, 5分钟过期
        applyNo = applyNo + userId;
        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_UNDO, applyNo);
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_APPLY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_APPLY, null));

            return result;
        }
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);

        return null;
    }

    /**
     * 验证定投申购时输入的参数（定投申购时用）
     * 
     * @param applyCache 申请编号缓存
     * @param bankAccount 银行账户
     * @param paymentType 支付方式
     * @param fundName 基金名称
     * @param fundCode 基金代码
     * @param tradePassword 交易密码
     * @param balance 金额
     * @param protocolPeriodUnit 扣款周期
     * @param protocolFixDay 扣款日期
     * @param token 用户token
     * @param applyNo 申请编号
     * @param userId 用户ID
     * @param sign 签名
     * @return 验证结果
     */
    public BaseResult validateFix(String bankAccount, String paymentType, String fundName, String fundCode,
            String tradePassword, BigDecimal balance, String protocolPeriodUnit, Long protocolFixDay, String token,
            String applyNo, long userId, String sign, String expiryDate, String fixModel,
            String oldScheduledProtocolId) {
        BaseResult result = null;

        result = baseValidate(bankAccount, paymentType, fundName, fundCode, tradePassword);
        if (result != null) {
            return result;
        }

        // 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
        if (MoneyUtils.compareTo(balance, 0) != 1) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "定投金额");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 扣款周期不能为空
        if (StringUtil.isEmpty(protocolPeriodUnit)) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "扣款周期");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 扣款日期要在1~31之间
        if (protocolFixDay.compareTo(0l) < 0) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_INVALID_DATE);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "扣款日期");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 扣款日期不能是当天，也不能是29~31
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        if (protocolFixDay.compareTo(28l) > 0) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_NOT_SUPPORT_DAY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NOT_SUPPORT_DAY, null));
            return result;
        }

        // 验证签名
        result = validateSign(bankAccount, paymentType, fundName, fundCode, tradePassword, balance, protocolPeriodUnit,
                protocolFixDay, token, applyNo, sign, expiryDate, fixModel, oldScheduledProtocolId);
        if (result != null) {
            return result;
        }

        // 验证是否重复提交, 5分钟过期
        result = validateApplyNo(applyNo, userId);
        if (result != null) {
            return result;
        }

        return null;
    }

    private BaseResult validateApplyNo(String applyNo, long userId) {
        BaseResult result = null;
        applyNo = applyNo + userId;
        // 获取缓存key
        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_BUY, applyNo);
        // 根据applykey，如果去得到，则说明重复提交
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_APPLY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_APPLY, null));

            return result;
        }
        // 将appKey放到
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);
        return null;
    }

    private BaseResult validateSign(String bankAccount, String paymentType, String fundName, String fundCode,
            String tradePassword, BigDecimal balance, String protocolPeriodUnit, Long protocolFixDay, String token,
            String applyNo, String sign, String expiryDate, String fixModel, String oldScheduledProtocolId) {
        BaseResult result = null;
        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token); // 用户token
        sortMap.put("bankAccount", bankAccount);// 银行账户
        sortMap.put("paymentType", paymentType);// 支付类型
        sortMap.put("fundName", fundName);// 基金名称
        sortMap.put("fundCode", fundCode);// 基金代码
        sortMap.put("balance", balance);// 定投金额
        sortMap.put("tradePassword", tradePassword);// 交易密码
        sortMap.put("applyNo", applyNo);// 申请编号
        sortMap.put("protocolPeriodUnit", protocolPeriodUnit);// 扣款周期
        sortMap.put("protocolFixDay", protocolFixDay);// 扣款日期
        if (expiryDate != null) {
            sortMap.put("expiryDate", expiryDate);// 终止日期
        }
        if (fixModel != null) {
            sortMap.put("fixModel", fixModel);// 定投类型
        }
        if (oldScheduledProtocolId != null) {
            sortMap.put("scheduledProtocolId", oldScheduledProtocolId);// 定投协议号
        }
        String requestString = SignUtil.getRequestString(sortMap);

        // 验证签名
        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return result;
        }
        return null;
    }

    /**
     * 快速赎回验证
     * @param bankAccount
     * @param paymentType
     * @param fundName
     * @param fundCode
     * @param shares
     * @param tradePassword
     * @param token
     * @param applyNo
     * @param sign
     * @param userId
     * @param tradeAcco
     * @return
     */
    public BaseResult validateFastRedeem(String bankAccount, String paymentType, String fundName, String fundCode,
            BigDecimal shares, String tradePassword, String token, String applyNo, String sign, long userId,
            String tradeAcco) {
        
        BaseResult result = null;
        
        // 基础信息的验证
        result = baseValidate(bankAccount, paymentType, fundName, fundCode, tradePassword);
        if (result != null) {
            return result;
        }
        
        // 交易账号不能为空
        if (StringUtil.isEmpty(tradeAcco)) {
            result = new BaseResult();
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "交易账号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
        if (MoneyUtils.compareTo(shares, 0) != 1) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "赎回份额");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token);
        sortMap.put("bankAccount", bankAccount);
        sortMap.put("paymentType", paymentType);
        sortMap.put("fundName", fundName);
        sortMap.put("fundCode", fundCode);
        sortMap.put("shares", shares);
        sortMap.put("tradePassword", tradePassword);
        sortMap.put("applyNo", applyNo);
        sortMap.put("tradeAcco", tradeAcco);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return result;
        }

        // 验证是否重复提交, 5分钟过期
        applyNo = applyNo + userId;
        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_FAST_REDEEM, applyNo);
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_APPLY);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_APPLY, null));
            return result;
        }
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);

        return null;
    }

}
