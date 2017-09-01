package com.codi.bus.core.service.impl;

import com.codi.base.util.*;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.dao.*;
import com.codi.bus.core.domain.*;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.ClientService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.UserProfileService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.model.AccountModel;
import com.codi.bus.core.service.model.BankModel;
import com.codi.bus.core.service.model.UserModel;
import com.codi.bus.core.service.model.WarningModel;
import com.codi.bus.core.service.util.BizUtils;
import com.codi.bus.core.service.util.ObjectCreator;
import com.codi.bus.core.vo.UserProfileVo;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.InterfaceFieldNoFindExcepiton;
import com.codi.bus.exception.SystemDBException;
import com.codi.fcloud.ufx.HsResponseUtil;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.fcloud.ufx.hssale.acco.ClearTradePassword;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import com.codi.trade.dto.FundAcctOpenDto;
import com.codi.trade.service.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userBankDao")
    private UserBankDao userBankDao;

    @Resource(name = "userSessionDao")
    private UserSessionDao userSessionDao;

    @Resource(name = "userSessionHistoryDao")
    private UserSessionHistoryDao userSessionHistoryDao;

    @Resource(name = "verifyDao")
    private VerifyDao verifyDao;

    @Resource(name = "cardBinDao")
    private CardBinDao cardBinDao;

    @Resource(name = "transactionDao")
    private TransactionDao transactionDao;

    @Resource(name = "paySignContractSmsService")
    private PaySignContractSmsService paySignContractSmsService;

    @Resource(name = "fundacctDirectOpenAcctService")
    private FundacctDirectOpenAcctService fundacctDirectOpenAcctService;

    @Resource(name = "loginAcctService")
    private LoginAcctService loginAcctService;

    @Resource(name = "tradeAccountAddAcctService")
    private TradeAccountAddAcctService tradeAccountAddAcctService;

    @Resource(name = "mainTransAccountModAcctService")
    private MainTransAccountModAcctService mainTransAccountModAcctService;

    @Resource(name = "transAccountCloseAcctService")
    private TransAccountCloseAcctService transAccountCloseAcctService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource(name = "loginAcctService")
    private LoginAcctService loginAcct;

    @Resource(name = "accountQueryService")
    private AccountQueryService accountQuery;

    @Resource(name = "clearTradePassword")
    private ClearTradePassword clearTradePassword;

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ClientService clientService;

    /*
     * 解绑银行卡（第一种情况不能解绑银行卡）
     * 解绑银行卡的首要条件是该卡处于3无情况（无在途申请，无持有份额，无在途资金或持有资金，如果客户赎回之后，钱处于尚未划款状态，也无法解绑） 1
     * 只有一个主交易账号（就是第一次开户的账号），主交易账号对应第一张卡 使用销基金账号(对应接口TA帐号销户），需要TA确认，销户后客户编号也会销户
     *
     * 2有主卡（主交易账号），有副卡（非主交易账号）销副卡
     *
     * 使用销交易账号(对应接口交易帐号销户）
     *
     * 3有主卡（主交易账号），有副卡（非主交易账号）销主卡
     * 先使用变更主交易账号(对应接口变更主交易账号），将副卡变为主卡，使用销交易账号(对应接口交易帐号销户）
     */
    // 不需要传TA账号
    @Override
    public BaseResult repalceAndCloseTradeAccount(long userId, String password, String bankCard, String capitalMode)
        throws BaseException {
        logger.info(MessageFormat.format("repalceAndCloseTradeAccount - userId={0}, bankCard={1}, capitalMode={2}",
            userId, bankCard, capitalMode));

        BaseResult result = new BaseResult();
        try {

            // 获取用户信息
            User user = userDao.getEntity(userId);
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            // 获取此银行卡的交易账号信息
            UserBank userBank = userBankDao.getEntityByBankNo(userId, bankCard, capitalMode);
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }
            // 交易账号
            String tradeAccount = userBank.getExternalTradeAccount();

            // 查询此用户的所有银行卡信息
            BaseListResult baseListResult = queryService.queryAccountBanks("", user.getExternalClientId(), "",
                GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1");
            if (!baseListResult.getSuccess()) {
                result.setSuccess(false);
                result.setErrorType(baseListResult.getErrorType());
                result.setErrorCode(baseListResult.getErrorCode());
                return result;
            }

            // 获取主交易账号
            String mainAccount = "";
            String taAccount = "";
            List<BankModel> accounts = ((BankListResult) baseListResult).getBanks();
            if (accounts == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }
            for (BankModel accountModel : accounts) {
                if (accountModel.getMainAccountFlag().equals(GlobalConstant.MAIN_ACCOUNT_FLAG_YES)) {
                    mainAccount = accountModel.getTradeAccount();
                }
                // 获取TA账号
                if (accountModel.getTradeAccount().equals(tradeAccount)) {
                    taAccount = accountModel.getTaAccount();
                }
            }

            // 未找到主交易账号的话直接报错返回
            if (StringUtil.isEmpty(mainAccount)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_MAIN_ACCOUNT_FIND);
                return result;
            }

            logger.info(MessageFormat.format(
                "repalceAndCloseTradeAccount - main account={0}, closing account={1}, TA account={2}", mainAccount,
                tradeAccount, taAccount));

            // 待解绑的银行卡是主卡， 先变更主交易账号
            if (tradeAccount.equals(mainAccount)) {

                // 去找到一个新的主交易账号
                String newTradeAccount = "";
                String newTaAccount = "";
                for (BankModel bank : accounts) {
                    if (bank.getTradeAccount().equals(mainAccount)) {
                        continue;
                    } else if (bank.getTradeAccountStatus().equals(GlobalConstant.TRADE_ACCOUNT_STATUS_WORKING)) {
                        newTradeAccount = bank.getTradeAccount();
                        newTaAccount = bank.getTaAccount();
                        break;
                    }
                }
                // 如果只有主交易账号，则不能销户
                if (StringUtil.isEmpty(newTradeAccount)) {
                    result.setSuccess(false);
                    result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                    result.setErrorCode(ErrorConstant.ERROR_CAN_NOT_CLOSE);
                    return result;
                }

                // 调用接口变更主交易账号
                // 不需要传TA账号
                result = replaceAccount(newTradeAccount, newTaAccount, password, tradeAccount);
                if (result.getSuccess() == false) {
                    return result;
                }
            }

            // 调用接口解绑银行卡
            // 不需要传TA账号
            result = closeAccount(tradeAccount, "", password);
            if (result.getSuccess() == false) {
                return result;
            }

            // 更新银行卡状态
            // TODO 不能马上更新状态，因为解绑是否成功是异步的，解绑需要TA确认的，

            result.setSuccess(true);
            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "repalceAndCloseTradeAccount - Exception:", e);
            throw new SystemDBException("repalceAndCloseTradeAccount Failure!", e);
        }
    }

    // 交易账号销户一般用于销非主交易账号，就是解绑增开的银行卡
    @Override
    public BaseResult closeAccount(String tradeAccount, String taAccount, String password) throws BaseException {

        logger.info(MessageFormat.format("closeAccount - tradeAccount={0}, taAccount={1}", tradeAccount, taAccount));
        try {
            BaseResult result = new BaseResult();

            // 解绑银行卡 - 交易帐号销户
            Map<String, Object> map = transAccountCloseAcctService.closeAccount(tradeAccount, taAccount,
                MD5.MD5Encode(password));

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();

            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("closeAccount - closeAccount - error info:" + errorInfo);
            } else {
                result.setSuccess(true);
            }

            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "closeAccount - Exception:", exception);
            throw new SystemDBException("closeAccount Failure!", exception);
        }
    }

    // 变更朱交易账号是指客户想要解绑开户时的银行卡，可以变更主交易账号到增开的交易账号，变更需要指交易账户三无状态
    @Override
    public BaseResult replaceAccount(String newMainAccount, String taAccount, String password,
                                     String originalMainAccount) throws BaseException {

        logger.info(MessageFormat.format("replaceAccount: newTradeAccount={0}, TA={1}, originalTradeAccount={2}",
            newMainAccount, taAccount, originalMainAccount));
        try {
            BaseResult result = new BaseResult();

            // 需要先调用更换主交易账号
            Map<String, Object> map = mainTransAccountModAcctService.replace(newMainAccount, taAccount,
                MD5.MD5Encode(password), originalMainAccount);

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();

            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("replaceAccount - replace - error info:" + errorInfo);
            } else {
                result.setSuccess(true);
            }

            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "replaceAccount - Exception:", e);
            throw new SystemDBException("replaceAccount Failure!", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public String registerAccount(User entity, UserSession sessionEntity, String ip) throws BaseException {
        if (entity == null) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'User' Is Null!");
        }

        logger.info(MessageFormat.format("registerAccount - mobile={0}", entity.getUserMobile()));

        try {

            Verify verifyEntity = new Verify();
            verifyEntity.setBizCode(GlobalConstant.SMS_BIZ_CODE_VERIFY);
            verifyEntity.setMobile(entity.getUserMobile());
            // 删除验证码
            verifyDao.deleteVerifyByMobileAndBizCode(verifyEntity);

            // 对登录密码加密
            entity.setLoginPassword(MD5.MD5Encode(entity.getLoginPassword()));
            entity.setUserFrom(GlobalConstant.USER_FROM_APP);
            userDao.add(entity);

            // 登录获取token
            String token = generateToken(entity.getUserId(), sessionEntity.getDeviceId(), sessionEntity.getChannelId(),
                ip);

            return token;

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "registerAccount - Exception:", e);
            throw new SystemDBException("registerAccount Failure!", e);
        }
    }

    // 增开交易账号
    @Override
    public AccountOpenResult addAccount(Long userId, String idNo, String tradePassword, String userName,
                                        String bankCode, String bankNo, String bankName, String mobile, String capitalMode,
                                        String externalProtocolNo) throws BaseException {

        logger.info(MessageFormat.format(
            "addAccount - userId={0}, idNo={1}, userName={2}, bankCode={3}, bankNo={4}, bankName={5}, mobile={6}, capitalMode={7}, externalProtocolNo={8}",
            userId, idNo, userName, bankCode, bankNo, bankName, mobile, capitalMode, externalProtocolNo));

        AccountOpenResult result = new AccountOpenResult();
        try {

            User user = userDao.getEntity(userId);
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            // 根据恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(bankCode)) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, bankCode));
                return result;
            }

            tradePassword = MD5.MD5Encode(tradePassword);

            AccountModel accountModel = queryService.getMainAccount(user.getExternalClientId());
            if (accountModel == null || StringUtil.isEmpty(accountModel.getTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_MAIN_ACCOUNT_FIND);
                return result;
            }
            String mainTradeAccount = accountModel.getTradeAccount();
            Map<String, Object> map = tradeAccountAddAcctService.addAcct(idNo, tradePassword, userName, bankHSCode,
                bankNo, bankName, mobile, externalProtocolNo, capitalMode, mainTradeAccount);

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("addAccount - error info:" + errorInfo);
            } else {
                // 只有成功时才有交易账号返回
                String externalTradeAccount = map.get(HSOutputParameterNames.TRADE_ACCO).toString();
                // 返回成功
                result.setSuccess(true);

                // 插入用户银行表
                UserBank bankEntity = ObjectCreator.createUserBank(bankCode, bankName, capitalMode, externalProtocolNo,
                    externalTradeAccount, mobile, bankNo, userName, userId);
                userBankDao.add(bankEntity);
            }

            // TODO 需要考虑一种情况，即最后更新交易账号失败，但恒生开户接口已调用成功，需要回滚？
            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "addAccount - Exception:", e);
            throw new SystemDBException("addAccount Failure!", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public AccountOpenResult openAccount(User entity, UserBank bankEntity) throws BaseException {
        if (entity == null) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'User' Is Null!");
        }

        logger.info("openAccount User ID:" + entity.getUserId());

        AccountOpenResult result = new AccountOpenResult();
        try {

            // 获取恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(bankEntity.getBankCode())) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, bankEntity.getBankCode()));
                return result;
            }

            // 对交易密码加密
            // 不保存交易密码到本地数据库
            // entity.setTradePassword(MD5.MD5Encode(entity.getTradePassword()));
            String tradePassword = MD5.MD5Encode(entity.getTradePassword());
            entity.setTradePassword("");

            // 调用交易接口
            Map<String, Object> map = fundacctDirectOpenAcctService.openAcct(entity.getUserCard(), tradePassword,
                entity.getUserName(), bankHSCode, bankEntity.getUserBankNo(), bankEntity.getBankName(),
                bankEntity.getUserBankMobile(), bankEntity.getExternalProtocolNo(), bankEntity.getCapitalMode());

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("openAccount - error info:" + errorInfo);
            } else {
                // 只有成功时才有交易账号返回
                String externalTradeAccount = map.get(HSOutputParameterNames.TRADE_ACCO).toString();
                // 返回成功
                result.setSuccess(true);

                // 插入用户银行表
                bankEntity.setExternalTradeAccount(externalTradeAccount);
                userBankDao.add(bankEntity);
                // 更新用户表
                entity.setExternalClientId(map.get(HSOutputParameterNames.CLIENT_ID).toString());
                userDao.updateUser(entity);
            }

            // TODO 需要考虑一种情况，即最后更新交易账号失败，但恒生开户接口已调用成功，需要回滚？
            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            // 设置用户信息
            entity = userDao.getEntity(entity.getUserId());
            UserModel model = new UserModel();
            model.setMobile(entity.getUserMobile());
            model.setUserName(entity.getUserName());
            result.setUser(model);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "openAccount - Exception:", e);
            throw new SystemDBException("openAccount Failure!", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public AccountOpenResult openAccountNew(User entity, UserProfileVo userProfileVo, UserBank bankEntity) throws BaseException {
        Assert.notNull(entity);
        Assert.notNull(userProfileVo);
        Assert.notNull(bankEntity);

        logger.info("openAccount User ID:{}", entity.getUserId());

        AccountOpenResult result = new AccountOpenResult();
        try {

            // 获取恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(bankEntity.getBankCode())) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, bankEntity.getBankCode()));
                return result;
            }

            // 对交易密码加密
            // 不保存交易密码到本地数据库
            // entity.setTradePassword(MD5.MD5Encode(entity.getTradePassword()));
            String tradePassword = MD5.MD5Encode(entity.getTradePassword());
            entity.setTradePassword("");

            // 调用开户接口
            FundAcctOpenDto dto = new FundAcctOpenDto();

            dto.setClient_name(entity.getUserName());
            dto.setId_no(entity.getUserCard());
            dto.setPassword(tradePassword);
            dto.setAddress(userProfileVo.getUserAddress());
            dto.setMobile_tel(bankEntity.getUserBankMobile());
            dto.setBank_no(bankHSCode);
            dto.setBank_name(bankEntity.getBankName());
            dto.setBank_account(bankEntity.getUserBankNo());
            dto.setBank_account_name(entity.getUserName());

            dto.setFund_card(bankEntity.getExternalProtocolNo());
            dto.setCapital_mode(bankEntity.getCapitalMode());

            dto.setBeneficiary(userProfileVo.getBeneficiary());// 实际受益人
            dto.setHolding_name(userProfileVo.getOwner());//实际控制人

            Map<String, Object> map = fundacctDirectOpenAcctService.openAcct(dto);

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("openAccount - error info:" + errorInfo);
            } else {
                // 只有成功时才有交易账号返回
                String externalTradeAccount = map.get(HSOutputParameterNames.TRADE_ACCO).toString();
                // 返回成功
                result.setSuccess(true);

                // 插入用户银行表
                bankEntity.setExternalTradeAccount(externalTradeAccount);
                userBankDao.add(bankEntity);
                // 更新用户表
                entity.setExternalClientId(map.get(HSOutputParameterNames.CLIENT_ID).toString());
                userDao.updateUser(entity);

                // 添加扩展资料
                UserProfile userProfile = new UserProfile();
                org.springframework.beans.BeanUtils.copyProperties(userProfileVo, userProfile);
                userProfile.setUserId(entity.getUserId());

                userProfileService.addOrUpdate(userProfile);
                logger.info("add user profile info");
            }

            // TODO 需要考虑一种情况，即最后更新交易账号失败，但恒生开户接口已调用成功，需要回滚？
            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            // 设置用户信息
            entity = userDao.getEntity(entity.getUserId());
            UserModel model = new UserModel();
            model.setMobile(entity.getUserMobile());
            model.setUserName(entity.getUserName());
            result.setUser(model);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "openAccount - Exception:", e);
            throw new SystemDBException("openAccount Failure!", e);
        }
    }


    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public PaySignResult paySign_Step_One(User entity, UserBank bankEntity) throws BaseException {
        if (entity == null) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'User' Is Null!");
        }

        logger.info("paySign_Step_One User Id:" + entity.getUserId());

        PaySignResult result = new PaySignResult();
        try {

            // 获取恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(bankEntity.getBankCode())) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, bankEntity.getBankCode()));
                return result;
            }

            // 插入交易记录获取流水号
            Transaction transaction = new Transaction();
            transactionDao.add(transaction);
            Long transactionId = transaction.getTransactionId();
            // 设置流水号
            String serialNo = String.valueOf(transactionId);

            Map<String, Object> map = paySignContractSmsService.paySign_Step_One(serialNo, entity.getUserCard(),
                entity.getUserName(), bankHSCode, bankEntity.getUserBankNo(), bankEntity.getUserBankMobile());

            if (map.containsKey(HSOutputParameterNames.ERROR_CODE)) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);

            } else {
                String smsSerialNo = map.get(HSOutputParameterNames.SMS_SERIAL_NO).toString();
                result.setSuccess(true);
                result.setSMSSerialNo(smsSerialNo);
                result.setOriginalSerialNo(serialNo);
            }

            transaction = ObjectCreator.createTransaction(map);
            transaction.setTransactionId(transactionId);
            // 更新数据
            transactionDao.updateTransaction(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "paySign_Step_One - Exception:", e);
            throw new SystemDBException("paySign_Step_One Failure!", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public PaySignResult paySign_Step_Two(User entity, UserBank bankEntity, String originalSerialNo, String smsSerialNo,
                                          String mobileCode) throws BaseException {
        if (entity == null) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'User' Is Null!");
        }

        logger.info("paySign_Step_Two User Id:" + entity.getUserId());

        PaySignResult result = new PaySignResult();
        try {

            // 获取恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(bankEntity.getBankCode())) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                    ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, bankEntity.getBankCode()));
                return result;
            }

            // 插入交易记录获取流水号
            Transaction transaction = new Transaction();
            transactionDao.add(transaction);
            Long transactionId = transaction.getTransactionId();

            // 设置流水号
            String serialNo = String.valueOf(transactionId);
            Map<String, Object> map = paySignContractSmsService.paySign_Step_Two(serialNo, originalSerialNo,
                entity.getUserCard(), entity.getUserName(), bankHSCode, bankEntity.getUserBankNo(),
                bankEntity.getUserBankMobile(), mobileCode, smsSerialNo);

            if (map.containsKey(HSOutputParameterNames.ERROR_CODE)) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
            } else {
                String protocolNo = map.get(HSOutputParameterNames.PROTOCOL_NO).toString();
                result.setSuccess(true);
                result.setProtocolNo(protocolNo);
            }

            // 生成对象
            transaction = ObjectCreator.createTransaction(map);
            transaction.setTransactionId(transactionId);
            // 更新数据
            transactionDao.updateTransaction(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception e) {
            ExceptionUtil.logError(logger, "paySign_Step_Two - Exception:", e);
            throw new SystemDBException("paySign_Step_Two Failure!", e);
        }
    }

    @Override
    public User getUser(Long userId) throws BaseException {
        logger.info("Get User entity - User Id:" + userId);

        try {

            return userDao.getEntity(userId);

        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getUser - Exception:", exception);
            throw new SystemDBException("getUser Failure!", exception);
        }
    }

    @Override
    public User getUserByToken(String token) throws BaseException {
        logger.info("Get User entity - token:" + token);

        try {

            return userDao.getEntityByToken(token);

        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getUser - Exception:", exception);
            throw new SystemDBException("getUser Failure!", exception);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public void update(User entity) throws BaseException {
        if (entity == null || entity.getUserId() <= 0) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'User' Is Null!");
        }

        logger.info("Update User entity - User Id:" + entity.getUserId());

        try {

            userDao.update(entity);

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "Update User entity - Exception:", e);
            throw new SystemDBException("Update User entity Failure!", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean checkMobile(String mobile) throws BaseException {
        if (StringUtil.isEmpty(mobile)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'mobile' Is Null!");
        }

        logger.info("checkMobile - Mobile:" + mobile);

        try {

            return userDao.isExistMobile(mobile);

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "checkMobile - Exception:", e);
            throw new SystemDBException("checkMobile Failure!", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean checkVerifyCode(String mobile, String authCode, String bizCode) throws BaseException {
        if (StringUtil.isEmpty(mobile)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'mobile' Is Null!");
        }

        logger.info("checkVerifyCode - Mobile:" + mobile);

        try {

            Verify queryEntity = new Verify();
            queryEntity.setMobile(mobile);
            queryEntity.setBizCode(bizCode);
            Verify entity = verifyDao.getEntityByMobileAndBizCode(queryEntity);
            if (entity == null) {
                return false;
            } else {
                if (entity.getExpireDate().before(new Date())) {
                    return false;
                }

                if (!entity.getVerifyCode().equals(authCode)) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "checkVerifyCode - Exception:", e);
            throw new SystemDBException("checkVerifyCode Failure!", e);
        }
    }

    @Override
    @Transactional(rollbackFor = {BaseException.class})
    public LoginResult login(String loginName, String password, String deviceId, String channelId, String ip)
        throws BaseException {

        if (StringUtil.isEmpty(loginName)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'loginName' Is Null!");
        }

        logger.info("login - loginName:" + loginName);

        try {

            LoginResult result = new LoginResult();
            User entity = null;
            // 手机登录
            if (loginName.length() <= GlobalConstant.MOBILE_LENGTH) {
                entity = userDao.getEntityByMobile(loginName);
            } else {// 身份证登录
                entity = userDao.getEntityByIDCard(loginName);
            }

            if (entity == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                result.setErrorCode(ErrorConstant.ERROR_MOBILE_NOT_REG);
                return result;
            }

            password = MD5.MD5Encode(password);
            if (!password.equals(entity.getLoginPassword())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                result.setErrorCode(ErrorConstant.ERROR_PASSWORD_WRONG);
                return result;
            }

            // 登录成功，则生产token
            String token = generateToken(entity.getUserId(), deviceId, channelId, ip);
            result.setSuccess(true);
            result.setToken(token);
            UserModel model = new UserModel();
            model.setMobile(entity.getUserMobile());
            model.setUserName(entity.getUserName());
            model.setUserCard(entity.getUserCard());
            //初始化客户信息
            clientService.initClientInfo(entity.getUserId(),model);
            result.setUser(model);

            //查询警示内容
            List<WarningModel> warningModels=queryService.queryWarnings();
            result.setWarnings(warningModels);

            return result;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "Login - Exception:", exception);
            throw new SystemDBException("Login Failure!", exception);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseException.class)
    public String generateToken(Long userId, String deviceId, String channelId, String ip) throws BaseException {
        // 创建用户登录token信息
        Date loginTime = new Date();
        Date expireTime = DateUtils.addDay(loginTime, GlobalConstant.EXPIRED_DAYS);
        String token = UUID.randomUUID().toString().replace("-", "_");

        UserSession session = new UserSession();
        session.setUserId(userId);
        session.setChannelId(channelId);
        session.setDeviceId(deviceId);
        session.setLoginTime(loginTime);
        session.setExpireTime(expireTime);
        session.setToken(token);
        session.setIp(ip);
        // 删除之前先备份，插入历史表
        UserSession backupEntity = userSessionDao.getEntityByUserId(userId);
        if (backupEntity != null) {
            userSessionHistoryDao.addHistory(backupEntity);
        }
        // 先删除之前的 Session
        userSessionDao.deleteByUserId(userId);
        // 插入Session
        userSessionDao.add(session);

        return token;
    }

    @Override
    public Boolean checkIDCard(String idCard) throws BaseException {
        if (StringUtil.isEmpty(idCard)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'idCard' Is Null!");
        }

        logger.info("checkIDCard - IDCard:" + idCard);

        try {

            return userDao.isExistCard(idCard);

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "checkIDCard - Exception:", e);
            throw new SystemDBException("checkIDCard Failure!", e);
        }
    }

    @Override
    public Boolean checkBankNo(String bankNo, String capitalMode) throws BaseException {
        if (StringUtil.isEmpty(bankNo)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'bankNo' Is Null!");
        }

        logger.info("checkBankNo - bankNo:" + bankNo);

        try {

            return userBankDao.isExistBankNo(bankNo, capitalMode);

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "checkBankNo - Exception:", e);
            throw new SystemDBException("checkBankNo Failure!", e);
        }
    }

    @Override
    public ValidateTokenResult validateToken(String token, String deviceId) throws BaseException {
        return validateToken(token, null, deviceId, false);
    }

    @Override
    public ValidateTokenResult validateToken(String token, String ip, String deviceId, boolean generateNewToken)
        throws BaseException {
        if (StringUtil.isEmpty(token)) {
            throw new InterfaceFieldNoFindExcepiton("Parameter 'token' Is Null!");
        }

        logger.info("validateToken - token:" + token);

        ValidateTokenResult result = new ValidateTokenResult();
        try {

            // 用户未登录
            if (StringUtil.isEmpty(token)) {
                result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                result.setErrorCode(ErrorConstant.ERROR_NOT_LOGIN);
                result.setSuccess(false);
                return result;
            }

            // 获取用户session
            UserSession entity = userSessionDao.getEntityByToken(token);
            // 用户已在其他地方登录
            if (entity == null) {
                result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                result.setErrorCode(ErrorConstant.ERROR_LOGIN_IN_OTHER_PLACE);
                result.setSuccess(false);
                return result;
                // 该设备不是生成token的设备
            } else if (!entity.getDeviceId().equals(deviceId)) {
                result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                result.setErrorCode(ErrorConstant.ERROR_DEVICE_INVALID);
                result.setSuccess(false);
                return result;
            } else {
                // token已过期
                Date expireDate = entity.getExpireTime();
                if (expireDate.before(new Date())) {
                    result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                    result.setErrorCode(ErrorConstant.ERROR_LOGIN_EXPIRED);
                    result.setSuccess(false);
                    return result;
                } else {
                    // 每次生成新的token时过期时间延后，每次调用方法前的验证token不再更新过期时间
                    String newToken = "";
                    if (generateNewToken) {
                        newToken = generateToken(entity.getUserId(), deviceId, entity.getChannelId(), ip);
                    } else {
                        // 之前的token
                        newToken = entity.getToken();
                    }

                    result.setSuccess(true);
                    result.setUserId(entity.getUserId());
                    result.setChannelId(entity.getChannelId());
                    result.setToken(newToken);

                    return result;
                }
            }

        } catch (Exception e) {
            ExceptionUtil.logError(logger, "validateToken - Exception:", e);
            throw new SystemDBException("validateToken Failure!", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CardBinResult validateCardInfo(String cardNo) throws BaseException {
        CardBinResult result = null;
        if (StringUtil.isEmpty(cardNo) || cardNo.length() < 6) {
            result = new CardBinResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(ErrorConstant.ERROR_FIELD_NO_FIND);
        }

        logger.info("validateCardInfo - cardNo:" + cardNo);
        try {

            result = new CardBinResult();
            String bin = cardNo.substring(0, 6);
            CardBin entity = cardBinDao.getByBinLike(bin);

            // 此方法不能识别类似103的卡bin
            //CardBin entity = cardBinDao.getByBin(bin);

            /*// 因为前端代码目前还没有升级，先注释掉，继续使用以前的处理逻辑
            // 目前卡bin用前6位来判断，需要加上银行卡长度，最终才能定位一张银行卡, 卡bin的长度从9位到3位
            CardBin entity = cardBinDao.getByCardNo(cardNo);*/

            // 过滤掉被排除的银行
            List<Lookup> excludeLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EXCLUDE_BANK);
            // 易宝支持的银行卡
            List<Lookup> epayLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EPAYBANK);

            if (entity != null) {
                result.setSuccess(true);
                result.setBankCode(entity.getBankCode());
                result.setBankName(entity.getBankName());
                result.setCardType(entity.getCardType());
                // 不是支持的银行卡
                // 过滤掉被排除的银行
                boolean exclude = false;
                for (Lookup lookup : excludeLookups) {
                    if (lookup.getRuleValue().equals(result.getBankCode())) {
                        exclude = true;
                    }
                }

                // 是否在易宝支持的银行卡列表里面
                boolean include = false;
                for (Lookup lookup : epayLookups) {
                    if (lookup.getRuleValue().equals(result.getBankCode())) {
                        include = true;
                    }
                }

                if (exclude || !include) {
                    result.setValidCard(GlobalConstant.BANK_CARD_TYPE_NOT_SUPPORT);
                } else {
                    // 储蓄卡
                    if (result.getCardType().equals(GlobalConstant.CARD_TYPE_DC)) {
                        result.setValidCard(GlobalConstant.BANK_CARD_TYPE_DC);
                    } else if (result.getCardType().equals(GlobalConstant.CARD_TYPE_CC)) {
                        // 信用卡
                        result.setValidCard(GlobalConstant.BANK_CARD_TYPE_CC);
                    } else {
                        // 查不出来的默认是合法的银行卡
                        result.setValidCard(GlobalConstant.BANK_CARD_TYPE_UNDEFINE);
                    }
                }

            } else {
                // 如果没找到卡bin, 就默认为合法的银行卡
                result.setSuccess(true);
                result.setValidCard(GlobalConstant.BANK_CARD_TYPE_UNDEFINE);
            }

            return result;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "validateCardInfo - Exception:", exception);
            throw new SystemDBException("validateCardInfo Failure!", exception);
        }
    }

    @Override
    public BaseResult update_password(Long user_id, String old_password, String new_password) {
        if (!BizUtils.validatePassword(new_password)) {
            return new BaseResult(false, "密码不符合规则");
        }
        User user = userDao.getEntity(user_id);
        String md5_password = MD5.MD5Encode(old_password);
        if (md5_password.equals(user.getLoginPassword())) {
            user.setLoginPassword(MD5.MD5Encode(new_password));
            userDao.updateUser(user);
            logger.info("Update user login password, user_id : " + user_id);
            return new BaseResult(true, null);
        } else {
            logger.info("Update user password fail because password mismatch !");
            return new BaseResult(false, "密码不匹配", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
    }

    @Override
    public BaseResult resetLoginPassword(String mobile, String verification_code, String new_passwd)
        throws BaseException {
        if (!BizUtils.validatePassword(new_passwd)) {
            return new BaseResult(false, "密码不符合规则", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        User user = userDao.getEntityByMobile(mobile);
        if (user == null) {
            logger.error("No user found according mobile:" + mobile);
            return new BaseResult(false, "用户未找到", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        boolean verify_code = checkVerifyCode(mobile, verification_code, GlobalConstant.SMS_BIZ_CODE_VERIFY);
        if (!verify_code) {
            return new BaseResult(false, "验证码验证失败", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        //删除验证码
        verifyDao.deleteVerifyByMobileAndBizCode(mobile, GlobalConstant.SMS_BIZ_CODE_VERIFY);
        logger.info("User: " + mobile + " reset login password.");
        user.setLoginPassword(MD5.MD5Encode(new_passwd));
        userDao.updateUser(user);
        return new BaseResult(true, null);
    }

    @Override
    public BaseResult resetTradePassword(Long userId, String id_card, String mobile, String verification_code,
                                         String new_passwd) throws BaseException {
        if (!BizUtils.validateTradePasswd(new_passwd)) {
            return new BaseResult(false, "密码不符合规则", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        User user = userDao.getEntity(userId);
        if (!User.USER_STATE_BANK.equals(user.getUserState())) {
            return new BaseResult(false, "用户未开户", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        if (!StringUtils.equals(user.getUserCard(), id_card)) {
            return new BaseResult(false, "身份证号码错误", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        if (!StringUtils.equals(user.getUserMobile(), mobile)) {
            return new BaseResult(false, "电话号码错误", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        if (!checkVerifyCode(mobile, verification_code, GlobalConstant.SMS_BIZ_CODE_VERIFY)) {
            return new BaseResult(false, "验证码验证失败", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        //删除验证码
        verifyDao.deleteVerifyByMobileAndBizCode(mobile, GlobalConstant.SMS_BIZ_CODE_VERIFY);
        List<UserBank> banks = userBankDao.getListByUserId(userId);
        if (banks.size() == 0) {
            return new BaseResult(false, "未绑定银行卡", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        UserBank first = banks.get(0);
        logger.info("User: " + mobile + " reset trade password.");
        Map<String, Object> res = clearTradePassword.clearTradePasswd(first.getExternalTradeAccount(),
            MD5.MD5Encode(new_passwd));
        if (!HsResponseUtil.isOperationOk(res)) {
            logger.info("User: " + mobile + " reset trade password fail!");
            return new BaseResult(false, "调用恒生接口失败", GlobalConstant.ERROR_TYPE_APPLICATION);
        }
        logger.info("User: " + mobile + " reset trade password successfully!");
        return new BaseResult(true, null);
    }

    @Override
    public BaseResult verifyVerificationCode(String mobile, String code, String bizCode) {
        if (StringUtil.isEmpty(mobile) || StringUtil.isEmpty(bizCode)) {
            throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, null);
        }
        logger.info("checkVerifyCode - Mobile:" + mobile);
        Verify queryEntity = new Verify();
        queryEntity.setMobile(mobile);
        queryEntity.setBizCode(bizCode);
        Verify entity = verifyDao.getEntityByMobileAndBizCode(queryEntity);
        if (entity == null) {
            return new BaseResult(false, "手机号码错误");
        } else {
            if (!entity.getVerifyCode().equals(code)) {
                return new BaseResult(false, "验证码错误");
            }
            if (entity.getExpireDate().before(new Date())) {
                return new BaseResult(false, "验证码已过期");
            }
        }
        return new BaseResult(true, null);
    }

    @Override
    public BaseResult verifyUserIdAndMobile(String id_card, String mobile, String verification_code) {
        if (StringUtil.isEmpty(id_card) || StringUtil.isEmpty(mobile) || StringUtil.isEmpty(verification_code)) {
            throw new BaseException(ErrorConstant.ERROR_INVALID_REQUEST, null);
        }
        User user = userDao.getEntityByMobile(mobile);
        if (user == null || !id_card.equals(user.getUserCard())) {
            return new BaseResult(false, "身份证号码手机号码不匹配");
        }
        if (!checkVerifyCode(mobile, verification_code, GlobalConstant.SMS_BIZ_CODE_VERIFY)) {
            return new BaseResult(false, "验证码验证失败", GlobalConstant.ERROR_TYPE_BUSINESS);
        }
        return new BaseResult(true, null);
    }

    /**
     * 判断用户是否开户
     *
     * @param userId
     * @return
     */
    @Override
    public boolean checkAccountOpen(Long userId) {

        User userEntity = getUser(userId);
        if (userEntity == null) {
            return false;
        }
        String externalClientId = userEntity.getExternalClientId();
        if (StringUtil.isEmpty(externalClientId)) {
            // 未开户
            return false;
        } else {
            // 获取用户银行卡
            BaseListResult listResult = queryService.queryAccountBanks("", userEntity.getExternalClientId(), "",
                GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1");
            if (!listResult.getSuccess()) {
                throw new BaseException(listResult.getErrorCode(), listResult.getErrorMessage());
            }

            List<BankModel> banks = ((BankListResult) listResult).getBanks();
            if (banks == null || banks.size() == 0) {
                // 未开户
                return false;
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
                    return true;
                } else if (counter > 0) {
                    // 柜台已开户
                    return true;
                } else {
                    // 未开户
                    return false;
                }
            }
        }
    }

}
