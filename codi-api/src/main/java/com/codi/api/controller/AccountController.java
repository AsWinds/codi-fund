package com.codi.api.controller;

import com.codi.api.security.UserUtil;
import com.codi.api.validation.AccountValidation;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.RandomUtil;
import com.codi.base.util.StringUtil;
import com.codi.base.web.RequestUtils;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.domain.UserSession;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.*;
import com.codi.bus.core.service.model.BankModel;
import com.codi.bus.core.service.model.SMSParameter;
import com.codi.bus.core.service.model.UserModel;
import com.codi.bus.core.sys.service.AppUpdateService;
import com.codi.bus.core.vo.UserProfileVo;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.Platform;
import com.codi.bus.util.SignUtil;
import com.codi.bus.util.VfCodeUsage;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Controller
@RequestMapping("/acc")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "smsService")
    private SMSService smsService;

    @Resource(name = "bankService")
    private BankService bankService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private AppUpdateService auService;

    @Autowired
    private AccountValidation accountValidation;

    @Resource(name = "lookupService")
    private LookupService lookupService;

    @Autowired
    private ClientService clientService;


    // 交易账号销户一般用于销非主交易账号，就是解绑增开的银行卡
    @RequestMapping(value = "/close", method = RequestMethod.POST)
    @ResponseBody
    @Loggable
    public BaseResult closeTradeAccount(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam String token, @RequestParam String password, @RequestParam String bankCard,
                                        @RequestParam String capitalMode, @RequestParam String sign,
                                        @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        BaseResult baseResult = accountValidation.validateCloseTradeAccount(token, password, bankCard, capitalMode,
            sign);
        if (baseResult != null && !baseResult.getSuccess()) {
            return baseResult;
        }

        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);

            return validateTokenResult;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.put("token", token);
        sortMap.put("password", password);
        sortMap.put("bankCard", bankCard);
        sortMap.put("capitalMode", capitalMode);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));

            return result;
        }

        BaseResult result = userService.repalceAndCloseTradeAccount(validateTokenResult.getUserId(), password, bankCard,
            capitalMode);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, @RequestParam String loginName,
                      @RequestParam String password, @RequestParam String deviceId, @RequestParam String channelId,
                      @RequestParam(required = false) String token, @RequestParam(required = false) String sign) throws BaseException {
        //special handle when app version is null, this code should delete after 2.0 version
        if (token == null || sign == null) {
            BaseResult result = new BaseResult(false, "有新版本了, 请您务必更新 ! ");
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }
        // 验证输入
        LoginResult result = accountValidation.validateLogin(loginName, password, token);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("token", token);
        sortMap.put("loginName", loginName);
        sortMap.put("password", password);
        sortMap.put("deviceId", deviceId);
        sortMap.put("channelId", channelId);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            result = new LoginResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 获取IP地址
        String ip = RequestUtils.getIpAddr(request);

        result = userService.login(loginName, password, deviceId, channelId, ip);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response, User entity,
                         UserSession sessionEntity) throws BaseException {
        // 验证输入
        LoginResult result = accountValidation.validateRegister(entity);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 获取IP地址
        String ip = RequestUtils.getIpAddr(request);

        // 完成手机号注册
        entity.setUserState(User.USER_STATE_MOBILE);
        String token = userService.registerAccount(entity, sessionEntity, ip);
        result = new LoginResult();
        result.setSuccess(true);
        result.setToken(token);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 开户接口
     * 从2017.7.1起不再使用 shi.pengyan 2017-6-19 13:28:54
     *
     * @param request
     * @param response
     * @param entity
     * @param bankEntity
     * @param sessionEntity
     * @param deviceId
     * @throws BaseException
     */
    @Deprecated
    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public void openAcc(HttpServletRequest request, HttpServletResponse response, User entity, UserBank bankEntity,
                        UserSession sessionEntity, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId)
        throws BaseException {
        AccountOpenResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(sessionEntity.getToken(), deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }
        // 验证输入
        bankEntity.setCapitalMode(GlobalConstant.CAPITAL_MODE_EPAY);
        entity.setUserId(validateTokenResult.getUserId());
        result = accountValidation.validateOpenAcc(entity, bankEntity);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }
        // Step 2: 完成银行卡绑定
        entity.setUserState(User.USER_STATE_BANK);
        bankEntity.setUserId(entity.getUserId());
        bankEntity.setUserBankOwner(entity.getUserName());

        result = userService.openAccount(entity, bankEntity);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/sendvcode", method = RequestMethod.POST)
    public void sendVCode(HttpServletRequest request, HttpServletResponse response, @RequestParam String mobile,
                          @RequestParam String token, @RequestParam String sign, @RequestParam String applyNo,
                          @RequestParam(required = false) VfCodeUsage usage) throws BaseException {
        SMSSendResult result = null;
        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("mobile", mobile);
        sortMap.put("applyNo", applyNo);
        sortMap.put("token", token);
        if (usage != null) {
            sortMap.put("usage", usage.name());
        }
        String requestStr = SignUtil.getRequestString(sortMap);
        logger.info("Sendvcode - Request String:" + requestStr);

        if (!SignUtil.verifyCodiSignV2(requestStr, token, sign)) {
            result = new SMSSendResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 验证输入
        String ip = RequestUtils.getIpAddr(request);
        if (usage == null) {
            usage = VfCodeUsage.Register;
        }

        // 获取短信发送控制配置
        List<Lookup> lookups = lookupService.getLookups(RuleConstant.RULE_LOOKUP_TYPE_SMSCONF);

        result = accountValidation.validateSendVCode(mobile, ip, applyNo, usage, lookups);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        List<SMSParameter> list = new ArrayList<SMSParameter>();
        SMSParameter parameter = new SMSParameter();
        parameter.setKey(GlobalConstant.SMS_PLACEHOLDER_VCODE);
        parameter.setValue(RandomUtil.getNumRandom(6, true));
        list.add(parameter);

        result = smsService.generateSmsMessage(mobile, list);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/validate-card", method = RequestMethod.POST)
    public void validateCardInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam String cardNo,
                                 @RequestParam String token, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId)
        throws BaseException {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        CardBinResult result = accountValidation.validateCard(cardNo);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        result = userService.validateCardInfo(cardNo);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/pay-sign-one", method = RequestMethod.POST)
    public void paySignOne(HttpServletRequest request, HttpServletResponse response, User entity, UserBank bankEntity,
                           UserSession sessionEntity, @RequestParam boolean isOpen,
                           @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseException {
        // 验证输入
        bankEntity.setCapitalMode(GlobalConstant.CAPITAL_MODE_EPAY);
        PaySignResult result = accountValidation.validatePaySign(entity, bankEntity, isOpen);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(sessionEntity.getToken(), deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        // 身份证转成大写
        entity.setUserCard(entity.getUserCard().toUpperCase());
        entity.setUserId(validateTokenResult.getUserId());
        bankEntity.setUserId(entity.getUserId());
        bankEntity.setUserBankOwner(entity.getUserName());

        result = userService.paySign_Step_One(entity, bankEntity);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);

    }

    // 此方法已不在被调用
    @RequestMapping(value = "/pay-sign-two", method = RequestMethod.POST)
    public void paySignTwo(HttpServletRequest request, HttpServletResponse response, User entity, UserBank bankEntity,
                           UserSession sessionEntity, String originalSerialNo, String smsSerialNo, String mobileCode, boolean isOpen,
                           @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseException {
        // 验证输入
        bankEntity.setCapitalMode(GlobalConstant.CAPITAL_MODE_EPAY);
        PaySignResult result = accountValidation.validatePaySign(entity, bankEntity, isOpen);
        if (result != null) {
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(sessionEntity.getToken(), deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        // 身份证转成大写
        entity.setUserCard(entity.getUserCard().toUpperCase());
        entity.setUserId(validateTokenResult.getUserId());
        bankEntity.setUserId(entity.getUserId());
        bankEntity.setUserBankOwner(entity.getUserName());

        // 调用接口
        result = userService.paySign_Step_Two(entity, bankEntity, originalSerialNo, smsSerialNo, mobileCode);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 不再使用 shi.pengyan 2017-6-20 10:14:33
     *
     * @param request
     * @param response
     * @param token
     * @param userName
     * @param userCard
     * @param tradePassword
     * @param bankCode
     * @param bankName
     * @param userBankNo
     * @param userBankMobile
     * @param originalSerialNo
     * @param smsSerialNo
     * @param mobileCode
     * @param isOpen
     * @param deviceId
     * @throws BaseException
     */
    @Deprecated
    @RequestMapping(value = "/pay-open", method = RequestMethod.POST)
    public void paySignTwoAndOpen(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                                  @RequestParam String userName, @RequestParam String userCard, @RequestParam String tradePassword,
                                  @RequestParam String bankCode, @RequestParam String bankName, @RequestParam String userBankNo,
                                  @RequestParam String userBankMobile, @RequestParam String originalSerialNo,
                                  @RequestParam String smsSerialNo, @RequestParam String mobileCode, @RequestParam boolean isOpen,
                                  @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseException {
        AccountOpenResult result = null;
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        Long userId = validateTokenResult.getUserId();
        // 用户基本信息
        User entity = new User();
        entity.setUserId(userId);
        entity.setUserName(userName);
        entity.setUserCard(userCard);
        entity.setTradePassword(tradePassword);
        // 银行卡信息
        UserBank bankEntity = new UserBank();
        bankEntity.setBankCode(bankCode);
        bankEntity.setBankName(bankName);
        bankEntity.setUserBankNo(userBankNo);
        bankEntity.setUserBankMobile(userBankMobile);
        bankEntity.setUserId(userId);
        bankEntity.setUserBankOwner(userName);
        bankEntity.setCapitalMode(GlobalConstant.CAPITAL_MODE_EPAY);

        // 验证输入
        PaySignResult payResult = null;
        payResult = accountValidation.validatePayOpen(entity, bankEntity, originalSerialNo, smsSerialNo, mobileCode,
            isOpen);
        if (payResult != null) {
            ResponseUtils.renderJson(request, response, payResult, true);
            return;
        }

        // Step 1: 调用实名验证步骤二接口
        // 身份证转成大写
        entity.setUserCard(entity.getUserCard().toUpperCase());
        payResult = userService.paySign_Step_Two(entity, bankEntity, originalSerialNo, smsSerialNo, mobileCode);
        if (payResult.getSuccess() == false) {
            if (StringUtil.isEmpty(payResult.getErrorMessage())) {
                payResult.setErrorMessage(MessageUtil.getErrorMessage(payResult.getErrorCode(), null));
            }
            ResponseUtils.renderJson(request, response, payResult, true);
            return;
        }

        // 是否是开户
        if (isOpen) {
            // Step 2: 调用开户接口
            // 完成银行卡绑定
            entity.setUserState(User.USER_STATE_BANK);
            bankEntity.setExternalProtocolNo(payResult.getProtocolNo());
            result = userService.openAccount(entity, bankEntity);
            if (result.getSuccess() == false) {
                if (StringUtil.isEmpty(result.getErrorMessage())) {
                    result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
                }

                ResponseUtils.renderJson(request, response, result, true);
                return;
            }

            // 有移动端触发调用
            // Step 3: 调用设置默认风险等级接口
            paperInfoService.addDefaultTestResult(userId);

        } else {

            // Step 2: 调用新增交易账号
            // 完成银行卡绑定
            result = userService.addAccount(userId, userCard, tradePassword, userName, bankCode, userBankNo, bankName,
                userBankMobile, GlobalConstant.CAPITAL_MODE_EPAY, payResult.getProtocolNo());
            if (result.getSuccess() == false) {
                if (StringUtil.isEmpty(result.getErrorMessage())) {
                    result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
                }

                ResponseUtils.renderJson(request, response, result, true);
                return;
            }
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 开户接口
     * 从2017.7.1起使用 shi.pengyan 2017-6-19 13:28:54
     *
     * @param userName
     * @param userCard
     * @param tradePassword
     * @param bankCode
     * @param bankName
     * @param userBankNo
     * @param userBankMobile
     * @param originalSerialNo
     * @param smsSerialNo
     * @param mobileCode
     * @param isOpen
     * @param userProfileVo
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/pay-open/v2", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult paySignTwoAndOpenNew(@RequestParam String userName, @RequestParam String userCard, @RequestParam String tradePassword,
                                           @RequestParam String bankCode, @RequestParam String bankName, @RequestParam String userBankNo,
                                           @RequestParam String userBankMobile, @RequestParam String originalSerialNo,
                                           @RequestParam String smsSerialNo, @RequestParam String mobileCode,
                                           @RequestParam boolean isOpen,
                                           @Validated UserProfileVo userProfileVo) throws BaseException {
        AccountOpenResult result = null;

        Long userId = UserUtil.getLoginUserId();
        // 用户基本信息
        User entity = new User();
        entity.setUserId(userId);
        entity.setUserName(userName);
        entity.setUserCard(userCard);
        entity.setTradePassword(tradePassword);
        // 银行卡信息
        UserBank bankEntity = new UserBank();
        bankEntity.setBankCode(bankCode);
        bankEntity.setBankName(bankName);
        bankEntity.setUserBankNo(userBankNo);
        bankEntity.setUserBankMobile(userBankMobile);
        bankEntity.setUserId(userId);
        bankEntity.setUserBankOwner(userName);
        bankEntity.setCapitalMode(GlobalConstant.CAPITAL_MODE_EPAY);

        // 验证输入
        PaySignResult payResult = null;
        payResult = accountValidation.validatePayOpenNew(entity, userProfileVo, bankEntity, originalSerialNo, smsSerialNo, mobileCode,
            isOpen);
        if (payResult != null) {
            return payResult;
        }

        // Step 1: 调用实名验证步骤二接口
        // 身份证转成大写
        entity.setUserCard(entity.getUserCard().toUpperCase());
        payResult = userService.paySign_Step_Two(entity, bankEntity, originalSerialNo, smsSerialNo, mobileCode);
        if (payResult.getSuccess() == false) {
            if (StringUtil.isEmpty(payResult.getErrorMessage())) {
                payResult.setErrorMessage(MessageUtil.getErrorMessage(payResult.getErrorCode(), null));
            }
            return payResult;
        }

        // 是否是开户
        if (isOpen) {
            // Step 2: 调用开户接口
            // 完成银行卡绑定
            entity.setUserState(User.USER_STATE_BANK);
            bankEntity.setExternalProtocolNo(payResult.getProtocolNo());
            result = userService.openAccountNew(entity, userProfileVo, bankEntity);
            if (result.getSuccess() == false) {
                if (StringUtil.isEmpty(result.getErrorMessage())) {
                    result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
                }
                return result;
            }

            // 有移动端触发调用
            // Step 3: 调用设置默认风险等级接口
            paperInfoService.addDefaultTestResult(userId);

            //查询用户风险等级等资料，app端要缓存 shi.pengyan
            clientService.initClientInfo(userId, result.getUser());

        } else {

            // Step 2: 调用新增交易账号
            // 完成银行卡绑定
            result = userService.addAccount(userId, userCard, tradePassword, userName, bankCode, userBankNo, bankName,
                userBankMobile, GlobalConstant.CAPITAL_MODE_EPAY, payResult.getProtocolNo());
            if (result.getSuccess() == false) {
                if (StringUtil.isEmpty(result.getErrorMessage())) {
                    result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
                }
                return result;
            }
        }
        return result;
    }


    @RequestMapping(value = "/isaccopen", method = RequestMethod.POST)
    public void checkAccOpen(HttpServletRequest request, HttpServletResponse response, @RequestParam String token,
                             @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE, required = false) String deviceId) {
        //delete this code after 2.0 release
        if (deviceId == null) {
            BaseResult result = new BaseResult(false, "有新版本了, 请您务必更新 ! ");
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        CheckResult result = new CheckResult();
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, validateTokenResult, true);
            return;
        }

        User userEntity = userService.getUser(validateTokenResult.getUserId());
        if (userEntity == null) {
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_USER_FIND);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_NO_USER_FIND));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }
        String externalClientId = userEntity.getExternalClientId();
        result.setSuccess(true);
        if (StringUtil.isEmpty(externalClientId)) {
            // 未开户
            result.setStatus(GlobalConstant.ACCOUNT_STATUS_NO_OPEN);
        } else {
            // 获取用户银行卡
            BaseListResult listResult = queryService.queryAccountBanks("", userEntity.getExternalClientId(), "",
                GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1");
            if (!listResult.getSuccess()) {
                ResponseUtils.renderJson(request, response, listResult, true);
                return;
            }

            List<BankModel> banks = ((BankListResult) listResult).getBanks();
            if (banks == null || banks.size() == 0) {
                // 未开户
                result.setStatus(GlobalConstant.ACCOUNT_STATUS_NO_OPEN);
            } else {
                // 判断是否开户
                int counter = 0;
                int app = 0;
                for (BankModel bankModel : banks) {
                    if (bankModel.getCapitalMode().equals(GlobalConstant.CAPITAL_MODE_COUNTER)) {
                        counter = counter + 1;
                    } else if (!StringUtil.isEmpty(bankModel.getCapitalMode())) {
                        app = app + 1;
                    }
                }

                if (app > 0) {
                    // APP已开户
                    result.setStatus(GlobalConstant.ACCOUNT_STATUS_APP_OPEN);
                } else if (counter > 0) {
                    // 柜台已开户
                    result.setStatus(GlobalConstant.ACCOUNT_STATUS_COUNTER_OPEN);
                } else {
                    // 未开户
                    result.setStatus(GlobalConstant.ACCOUNT_STATUS_NO_OPEN);
                }
            }
        }
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/validate-token", method = RequestMethod.POST)
    public void validateToken(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String token,
                              @RequestHeader(value = "Client-Version", required = false) String clientVersion,
                              @RequestHeader(value = "Os-Type", required = false) Platform osType,
                              @RequestHeader(value = "App-Identifier", required = false) String appIdentifier,
                              @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE, required = false) String deviceId) {
        if (clientVersion != null && osType != null && appIdentifier != null) {
            logger.info("Receive validate-token request, Client-Version:{}, Os-Type:{}, App-Identifier:{}",
                clientVersion, String.valueOf(osType), appIdentifier);
        }
        if (token == null || deviceId == null) {
            LoginResult result = new LoginResult();
            result.setSuccess(true);
            result.setErrorMessage("有新版本了, 请您务必更新 ! ");
            result.setAppUpdateResult(auService.getAppUpdateResult(clientVersion, appIdentifier));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }
        // 获取IP地址
        String ip = RequestUtils.getIpAddr(request);
        // 验证token
        ValidateTokenResult tokenResult = userService.validateToken(token, ip, deviceId, true);
        if (!tokenResult.getSuccess()) {
            LoginResult result = new LoginResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(tokenResult.getErrorCode());
            String errorMessage = MessageUtil.getErrorMessage(result.getErrorCode(), null);
            result.setErrorMessage(errorMessage);
            result.setAppUpdateResult(auService.getAppUpdateResult(clientVersion, appIdentifier));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 设置用户姓名和手机号
        User user = userService.getUser(tokenResult.getUserId());
        LoginResult result = new LoginResult();
        result.setSuccess(true);
        UserModel model = new UserModel();
        model.setMobile(user.getUserMobile());
        model.setUserName(user.getUserName());
        result.setUser(model);

        // token
        result.setToken(tokenResult.getToken());
        result.setAppUpdateResult(auService.getAppUpdateResult(clientVersion, appIdentifier));
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/update_login_password", method = RequestMethod.POST)
    public void changeUserLoginPassword(HttpServletRequest request, HttpServletResponse response, String token,
                                        @RequestParam String old_password, @RequestParam String new_password,
                                        @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {
        ValidateTokenResult result = null;
        // 验证token
        result = userService.validateToken(token, deviceId);
        if (!result.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(result.getErrorCode(), null);
            result.setErrorMessage(errorMessage);
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }
        ResponseUtils.renderJson(request, response,
            userService.update_password(result.getUserId(), old_password, new_password), true);
    }

    @RequestMapping(value = "/reset_login_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Loggable
    public ResponseEntity<?> resetLoginPassword(@RequestParam String mobile, @RequestParam String verification_code,
                                                @RequestParam String newest_passwd, @RequestParam String sign, @RequestParam String token)
        throws BaseException {
        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("mobile", mobile);
        sortMap.put("verification_code", verification_code);
        sortMap.put("newest_passwd", newest_passwd);
        sortMap.put("token", token);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        BaseResult result = userService.resetLoginPassword(mobile, verification_code, newest_passwd);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/reset_trade_password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Loggable
    public ResponseEntity<?> resetTradePassword(@RequestParam String token, @RequestParam String id_card,
                                                @RequestParam String mobile, @RequestParam String verification_code, @RequestParam String newest_passwd,
                                                @RequestParam String sign, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId)
        throws BaseException {
        // 验证签名
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("token", token);
        sortMap.put("id_card", id_card);
        sortMap.put("mobile", mobile);
        sortMap.put("verification_code", verification_code);
        sortMap.put("newest_passwd", newest_passwd);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // 验证token
        ValidateTokenResult va_res = userService.validateToken(token, deviceId);
        if (!va_res.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(va_res.getErrorCode(), null);
            va_res.setErrorMessage(errorMessage);
            return new ResponseEntity<>(va_res, HttpStatus.FORBIDDEN);
        }
        BaseResult result = userService.resetTradePassword(va_res.getUserId(), id_card, mobile, verification_code,
            newest_passwd);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/check/mobile_id_card", method = RequestMethod.POST)
    public ResponseEntity<?> checkUserExist(@RequestParam String id_card, @RequestParam String mobile,
                                            @RequestParam String verification_code) {
        BaseResult result = userService.verifyUserIdAndMobile(id_card, mobile, verification_code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * check verify code do not need user token, the parm token only used to
     * verify the sign of this request
     */
    @RequestMapping(value = "/check/verify_code", method = RequestMethod.POST)
    @Loggable
    public ResponseEntity<?> checkVerifyCode(@RequestParam String mobile, @RequestParam String verification_code,
                                             @RequestParam String token, @RequestParam String sign) {
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("token", token);
        sortMap.put("mobile", mobile);
        sortMap.put("verification_code", verification_code);
        String requestString = SignUtil.getRequestString(sortMap);

        if (!SignUtil.verifyCodiSignV2(requestString, token, sign)) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_INVALID_REQUEST);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_INVALID_REQUEST, null));
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
            userService.verifyVerificationCode(mobile, verification_code, GlobalConstant.SMS_BIZ_CODE_VERIFY),
            HttpStatus.OK);
    }


    /**
     * 获取用户的零钱包操作记录, 因为恒生方面原因, 当前默认获取所有的零钱包交易记录, 后期可能会根据需求进行改造, 例如: 一定时间?
     *
     * @author hzren
     * @since pangu003
     */
    @Loggable
    @RequestMapping(value = "/wallet/operations", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> getWalletOperationList(HttpServletRequest request, HttpServletResponse response,
                                             @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId,
                                             @RequestParam String token) {
        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);
            return new ResponseEntity<>(validateTokenResult, HttpStatus.OK);
        }
        int requestNum = GlobalConstant.MAX_REQUEST_NUM;
        int queryFlag = 1;
        int beginNum = 1;
        String sortDirection = "0";
        return new ResponseEntity<>(queryService.queryWalletOperationList(validateTokenResult.getUserId(), requestNum, queryFlag, beginNum, sortDirection), HttpStatus.OK);
    }

}
