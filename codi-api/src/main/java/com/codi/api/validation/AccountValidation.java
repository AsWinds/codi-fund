package com.codi.api.validation;

import com.codi.base.cache.CacheUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.annotation.Validator;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.util.BizUtils;
import com.codi.bus.core.vo.UserProfileVo;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.VfCodeUsage;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Validator
public class AccountValidation implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(AccountValidation.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, List<Date>> redisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisStringTemplate;

    // 同一个号码，每分钟只能发送2次
    private ValueOperations<String, List<Date>> mobileCache = null;
    // 同一个IP，每分钟一个小时只能发送1200次
    private ValueOperations<String, List<Date>> ipCache = null;
    // 交易申请编号， 用于防止重复提交交易
    private ValueOperations<String, String> applyCache = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 单个手机号
        mobileCache = redisTemplate.opsForValue();
        // 单个IP
        ipCache = redisTemplate.opsForValue();
        // 单个申请编号
        applyCache = redisStringTemplate.opsForValue();
    }

    public LoginResult validateLogin(String loginName, String password, String token) {
        LoginResult result = new LoginResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(loginName)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "手机号"));
            return result;
        }

        if (StringUtil.isEmpty(password)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "密码"));
            return result;
        }

        if (StringUtil.isEmpty(token)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "token"));
            return result;
        }

        return null;
    }

    public LoginResult validateRegister(User entity) {
        LoginResult result = new LoginResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(entity.getUserMobile())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "手机号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (!StringUtil.isNumeric(entity.getUserMobile())) {
            result.setErrorCode(ErrorConstant.ERROR_MOBILE_INVALID);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_MOBILE_INVALID, null));
            return result;
        }

        if (StringUtil.isEmpty(entity.getAuthCode())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "验证码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(entity.getLoginPassword()) || !BizUtils.validatePassword(entity.getLoginPassword())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "密码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (!BizUtils.validatePassword(entity.getLoginPassword())) {
            result.setErrorCode(ErrorConstant.ERROR_PASSWORD_MISMATCH_RULE);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_PASSWORD_MISMATCH_RULE, null));
            return result;
        }
        try {
            // 验证手机号是否已存在
            Boolean isExist = userService.checkMobile(entity.getUserMobile());
            if (isExist) {
                result.setErrorCode(ErrorConstant.ERROR_MOBILE_REGED);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_MOBILE_REGED, null));
                return result;
            }
            // 验证短信验证码是否过期
            isExist = userService.checkVerifyCode(entity.getUserMobile(), entity.getAuthCode(),
                GlobalConstant.SMS_BIZ_CODE_VERIFY);
            if (!isExist) {
                result.setErrorCode(ErrorConstant.ERROR_REGVCODE_INCORRECT);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_REGVCODE_INCORRECT, null));
                return result;
            }

        } catch (BaseException exception) {
            Integer errorCode = exception.getCode();
            result.setErrorCode(errorCode);
            String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
            result.setErrorMessage(errorMessage);
            return result;
        }

        return null;
    }

    @Deprecated
    public AccountOpenResult validateOpenAcc(User entity, UserBank bankEntity) {
        AccountOpenResult result = new AccountOpenResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(entity.getUserName())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "姓名");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(entity.getUserCard())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "身份证");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(entity.getTradePassword())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "交易密码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行名称
        if (StringUtil.isEmpty(bankEntity.getBankName())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行名称");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行名称
        if (StringUtil.isEmpty(bankEntity.getBankCode())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行英文名称");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行卡号
        if (StringUtil.isEmpty(bankEntity.getUserBankNo())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行卡号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行预留手机
        if (StringUtil.isEmpty(bankEntity.getUserBankMobile())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行预留手机");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        try {

            // 验证省份证是否已存在
            Boolean isExist = userService.checkIDCard(entity.getUserCard());
            if (isExist) {
                result.setErrorCode(ErrorConstant.ERROR_IDCARD_REGED);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_IDCARD_REGED, null));
                return result;
            }

            // 本地不做验证，由恒生来验证，因为绑定银行卡是否成功是异步的，恒生没有马上返回成功或失败
            /*
             * // 验证银行卡号是否已存在 isExist =
			 * userService.checkBankNo(bankEntity.getUserBankNo(),
			 * bankEntity.getCapitalMode()); if (isExist) {
			 * result.setErrorCode(ErrorConstant.ERROR_BANKNO_REGED);
			 * result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.
			 * ERROR_BANKNO_REGED, null)); return result; }
			 */

        } catch (BaseException exception) {
            Integer errorCode = exception.getCode();
            result.setErrorCode(errorCode);
            String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
            result.setErrorMessage(errorMessage);
            return result;
        }

        return null;
    }

    private Integer getSendCount(Date now, String key, List<Date> sendDates, int timeUnit, int interval) {
        Integer count = 0;
        if (sendDates != null) {
            Iterator<Date> iterator = sendDates.iterator();
            while (iterator.hasNext()) {
                Date date = iterator.next();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                // 判断是否在一分钟内
                calendar.add(timeUnit, interval);
                date = calendar.getTime();
                if (date.after(now)) {
                    count = count + 1;
                } else {
                    iterator.remove();
                }
            }
        }

        return count;
    }

    public SMSSendResult validateSendVCode(String mobile, String ip, String applyNo, VfCodeUsage usage,
                                           List<Lookup> lookups) {
        SMSSendResult result = new SMSSendResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(mobile)) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "手机号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (!StringUtil.isNumeric(mobile)) {
            result.setErrorCode(ErrorConstant.ERROR_MOBILE_INVALID);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_MOBILE_INVALID, null));
            return result;
        }

        if (usage == VfCodeUsage.Register) {
            try {
                // 验证手机号是否已存在
                Boolean isExist = userService.checkMobile(mobile);
                if (isExist) {
                    result.setErrorCode(ErrorConstant.ERROR_MOBILE_REGED);
                    result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_MOBILE_REGED, null));
                    return result;
                }
            } catch (BaseException exception) {
                Integer errorCode = exception.getCode();
                result.setErrorCode(errorCode);
                String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
                result.setErrorMessage(errorMessage);
                return result;
            }
        }

        logger.debug("mobile=" + mobile + ", IP=" + ip + ", usage=:" + usage.name());

        // 设置SMS短信发送限制
        int mobileTime = getSMSConfig(lookups, RuleConstant.RULE_LOOKUP_VALUE_MOBILETIME,
            GlobalConstant.SMS_ALLOWED_TIME_ONE_MOBILE);
        int mobileLimit = getSMSConfig(lookups, RuleConstant.RULE_LOOKUP_VALUE_MOBILELIMIT,
            GlobalConstant.SMS_ALLOWED_NUMBERS_ONE_MOBILE_ONE_UNIT);
        int IPTime = getSMSConfig(lookups, RuleConstant.RULE_LOOKUP_VALUE_IPTIME,
            GlobalConstant.SMS_ALLOWED_TIME_ONE_IP);
        int IPLimit = getSMSConfig(lookups, RuleConstant.RULE_LOOKUP_VALUE_IPLIMIT,
            GlobalConstant.SMS_ALLOWED_NUMBERS_ONE_IP_ONE_UNIT);

        // Step 1: 控制同个手机号的发送频率
        String mobileKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_MOBILE, mobile);
        Date now = new Date();
        List<Date> mobileDates = mobileCache.get(mobileKey);
        Integer count = getSendCount(now, mobile, mobileDates, Calendar.MINUTE, mobileTime);
        // 如果一分钟内，同一个号码发送次数超过2次
        if (count > mobileLimit) {
            result.setErrorCode(ErrorConstant.ERROR_SEND_TOO_FREQUENT);
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));

            return result;
        }

        // Step 2: 控制同个IP的发送频率
        String ipKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_IP, ip);
        List<Date> ipDates = ipCache.get(ipKey);
        count = getSendCount(now, ip, ipDates, Calendar.MINUTE, IPTime);
        // 如果一个小时内，同一个IP发送次数超过100次
        if (count > IPLimit) {
            result.setErrorCode(ErrorConstant.ERROR_SEND_TOO_FREQUENT);
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));

            return result;
        }

        // Step 3: 验证是否重复提交, 5分钟过期
        applyNo = applyNo + mobile;
        String applyKey = CacheUtil.getKey(GlobalConstant.REDIS_KEY_APPLY_VCODE, applyNo);
        if (!StringUtil.isEmpty(applyCache.get(applyKey))) {
            result.setErrorCode(ErrorConstant.ERROR_DUPLICATE_VCODE);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_DUPLICATE_VCODE, null));

            return result;
        }
        applyCache.set(applyKey, applyNo, GlobalConstant.APPLY_EXPIRED_HOURS_DEFAULT, TimeUnit.HOURS);

        // 添加mobile
        if (mobileDates != null) {
            mobileDates.add(now);
        } else {
            mobileDates = new ArrayList<>();
            mobileDates.add(now);
        }
        // 更新缓存
        mobileCache.set(mobileKey, mobileDates);

        // 添加ip
        if (ipDates != null) {
            ipDates.add(now);
        } else {
            ipDates = new ArrayList<>();
            ipDates.add(now);
        }
        // 更新缓存
        ipCache.set(ipKey, ipDates);

        return null;
    }

    /**
     * 获取配置值
     *
     * @param lookups
     * @param code
     * @param defaultValue
     * @return
     */
    private int getSMSConfig(List<Lookup> lookups, String code, int defaultValue) {
        int result = defaultValue;
        try {

            if (!CollectionUtils.isEmpty(lookups)) {
                for (Lookup lookup : lookups) {
                    if (lookup.getRuleValue().equals(code)) {
                        result = Integer.parseInt(lookup.getComponentValue());
                        break;
                    }
                }
            }

        } catch (Exception exception) {

        }

        return result;
    }

    public CardBinResult validateCard(String cardNo) {
        CardBinResult result = new CardBinResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(cardNo) || cardNo.length() < 6) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行卡号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (!StringUtil.isNumeric(cardNo)) {
            result.setErrorCode(ErrorConstant.ERROR_NUMERIC_FIELD);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD, "银行卡号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NUMERIC_FIELD, map));
            return result;
        }

        return null;
    }

    /**
     * 2017.7.1 之后不再使用 shi.pengyan 2017-6-20 10:24:05
     *
     * @param entity
     * @param bankEntity
     * @param originalSerialNo
     * @param smsSerialNo
     * @param mobileCode
     * @param isOpen
     * @return
     */
    @Deprecated
    public PaySignResult validatePayOpen(User entity, UserBank bankEntity, String originalSerialNo, String smsSerialNo,
                                         String mobileCode, boolean isOpen) {
        PaySignResult result = new PaySignResult();
        result.setSuccess(false);

        // 验证用户基本信息
        result = validatePaySign(entity, bankEntity, isOpen);
        if (result != null) {
            return result;
        }

        // 原流水序号
        if (StringUtil.isEmpty(originalSerialNo)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "原流水序号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 短信流水序号
        if (StringUtil.isEmpty(smsSerialNo)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "短信流水序号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 手机验证码
        if (StringUtil.isEmpty(mobileCode)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "手机验证码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        return null;
    }

    /**
     * 开户校验 适应性改造 shi.pengyan 2017-6-20 10:25:11
     *
     * @param entity
     * @param userProfileVo
     * @param bankEntity
     * @param originalSerialNo
     * @param smsSerialNo
     * @param mobileCode
     * @param isOpen
     * @return
     */
    public PaySignResult validatePayOpenNew(User entity, UserProfileVo userProfileVo, UserBank bankEntity,
                                            String originalSerialNo, String smsSerialNo, String mobileCode,
                                            boolean isOpen) {
        // 验证用户基本信息
        PaySignResult result = validatePaySign(entity, bankEntity, isOpen);
        if (result != null) {
            return result;
        }

        result = new PaySignResult();
        result.setSuccess(false);
        // 校验扩展字段
        // 校验用户扩展资料 shi.pengyan 2017-6-20 09:37:11
        // 联系人地址不能为空
        if (StringUtil.isEmpty(userProfileVo.getAddressCode()) || StringUtil.isEmpty(userProfileVo.getUserAddress())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "联系人地址");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 职业
        if (StringUtil.isEmpty(userProfileVo.getOccupationCode()) || StringUtil.isEmpty(userProfileVo.getUserOccupation())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "职业");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (userProfileVo.getSelfSustain() == null) {
            userProfileVo.setSelfSustain(true);
        }

        // 实际受益人
        if (StringUtil.isEmpty(userProfileVo.getBeneficiary())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "实际受益人");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 实际控制人
        if (StringUtil.isEmpty(userProfileVo.getOwner())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "实际控制人");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 原流水序号
        if (StringUtil.isEmpty(originalSerialNo)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "原流水序号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 短信流水序号
        if (StringUtil.isEmpty(smsSerialNo)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "短信流水序号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 手机验证码
        if (StringUtil.isEmpty(mobileCode)) {
            result = new PaySignResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "手机验证码");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        return null;
    }

    public PaySignResult validatePaySign(User entity, UserBank bankEntity, boolean isOpen) {
        PaySignResult result = new PaySignResult();
        result.setSuccess(false);

        if (StringUtil.isEmpty(entity.getUserName())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "姓名");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        if (StringUtil.isEmpty(entity.getUserCard())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "身份证");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        // 银行名称
        if (StringUtil.isEmpty(bankEntity.getBankCode())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行名称");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行卡号
        if (StringUtil.isEmpty(bankEntity.getUserBankNo())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行卡号");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }
        // 银行预留手机
        if (StringUtil.isEmpty(bankEntity.getUserBankMobile())) {
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            Map<String, String> map = new HashMap<>();
            map.put(ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, "银行预留手机");
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND, map));
            return result;
        }

        try {

            Boolean isExist = false;
            // 只有开户的时候需要验证身份证是否存在，新绑银行卡时不需要验证
            if (isOpen) {
                // 验证省份证是否已存在
                isExist = userService.checkIDCard(entity.getUserCard());
                if (isExist) {
                    result.setErrorCode(ErrorConstant.ERROR_IDCARD_REGED);
                    result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_IDCARD_REGED, null));
                    return result;
                }
            }

            // 本地不做验证，由恒生来验证，因为绑定银行卡是否成功是异步的，恒生没有马上返回成功或失败
            /*
             * // 验证银行卡号是否已存在 isExist =
			 * userService.checkBankNo(bankEntity.getUserBankNo(),
			 * bankEntity.getCapitalMode()); if (isExist) {
			 * result.setErrorCode(ErrorConstant.ERROR_BANKNO_REGED);
			 * result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.
			 * ERROR_BANKNO_REGED, null)); return result; }
			 */

        } catch (BaseException exception) {
            Integer errorCode = exception.getCode();
            result.setErrorCode(errorCode);
            String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
            result.setErrorMessage(errorMessage);
            return result;
        }

        return null;
    }

    /***
     * 验证关闭交易账号接口的入参是否合法
     *
     * @param token
     * @param password
     * @param bankCard
     * @param capitalMode
     * @param sign
     * @return
     */
    public BaseResult validateCloseTradeAccount(String token, String password, String bankCard, String capitalMode,
                                                String sign) {

        String placeValue = "";
        boolean isError = false;

        if (!isError && StringUtil.isEmpty(token)) {
            isError = true;
            placeValue = "token";
        }

        if (!isError && StringUtil.isEmpty(password)) {
            isError = true;
            placeValue = "密码";
        }

        if (!isError && StringUtil.isEmpty(bankCard)) {
            isError = true;
            placeValue = "银行卡号";
        }

        if (!isError && StringUtil.isEmpty(capitalMode)) {
            isError = true;
            placeValue = "支付通道";
        }

        if (!isError && StringUtil.isEmpty(sign)) {
            isError = true;
            placeValue = "签名";
        }

        if (isError) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, placeValue));
            return result;
        }

        return null;

    }

    /**
     * 验证客户资料信息
     * @param address
     * @param addressCode
     * @param occupation
     * @param occupationCode
     * @param beneficiary
     * @param owner
     * @param selfSustain
     */
    public static void validateClient(String address, String addressCode, String occupation, String occupationCode, String
        beneficiary, String owner, boolean selfSustain){
        String message="";
        if(StringUtil.isEmpty(address)){
            message=message+",地址";
        }

        if(StringUtil.isEmpty(addressCode)){
            message=message+",地址代码";
        }

        if(StringUtil.isEmpty(occupation)){
            message=message+",职业";
        }

        if(StringUtil.isEmpty(occupationCode)){
            message=message+",职业代码";
        }

        if(!selfSustain) {
            if (StringUtil.isEmpty(beneficiary)) {
                message = message + ",实际受益人";
            }

            if (StringUtil.isEmpty(owner)) {
                message = message + ",实际控制人";
            }
        }

        if(StringUtil.isNotEmpty(message)){
            message=message.substring(1, message.length());
            throw new BaseException(ErrorConstant.ERROR_FIELD_NO_FIND,MessageUtil.getErrorMessage(ErrorConstant.ERROR_FIELD_NO_FIND,
                ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, message));
        }

    }
}
