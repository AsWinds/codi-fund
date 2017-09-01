package com.codi.bus.core.service.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.DateUtils;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.MD5;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.dao.OrderFundDao;
import com.codi.bus.core.dao.TradeOrderDao;
import com.codi.bus.core.dao.TransactionDao;
import com.codi.bus.core.dao.UserBankDao;
import com.codi.bus.core.dao.UserDao;
import com.codi.bus.core.dao.UserSessionDao;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.OrderFund;
import com.codi.bus.core.domain.TradeOrder;
import com.codi.bus.core.domain.Transaction;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.domain.UserSession;
import com.codi.bus.core.resultModel.AllotTradeResult;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.FixAllotResult;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.TradeService;
import com.codi.bus.core.service.model.ApplyModel;
import com.codi.bus.core.service.util.ObjectCreator;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import com.codi.trade.service.AllotTradeService;
import com.codi.trade.service.FastRedeemService;
import com.codi.trade.service.FixAllotTradeService;
import com.codi.trade.service.FixModifyTradeService;
//import com.codi.trade.service.FixRedeemTradeService;
import com.codi.trade.service.RedeemTradeService;
import com.codi.trade.service.UndoTradeApplyService;

@Service("tradeService")
@Transactional
public class TradeServiceImpl implements TradeService {

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    @Resource(name = "transactionDao")
    private TransactionDao transactionDao;

    @Resource(name = "tradeOrderDao")
    private TradeOrderDao tradeOrderDao;

    @Resource(name = "orderFundDao")
    private OrderFundDao orderFundDao;

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userSessionDao")
    private UserSessionDao userSessionDao;

    @Resource(name = "userBankDao")
    private UserBankDao userBankDao;

    @Resource(name = "allotTradeService")
    private AllotTradeService allotTradeService;

    @Resource(name = "redeemTradeService")
    private RedeemTradeService redeemTradeService;

    @Resource(name = "undoTradeApplyService")
    private UndoTradeApplyService undoTradeApplyService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource(name = "fixAllotTradeService")
    private FixAllotTradeService fixAllotTradeService;

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    @Resource(name = "fixModifyTradeService")
    private FixModifyTradeService fixModifyTradeService;

    @Resource(name = "fastRedeemService")
    private FastRedeemService fastRedeemService;

    @Override
    @Transactional(rollbackFor = { BaseException.class })
    public BaseResult undo(Long userId, String token, String originalApplyNo, String tradePassword)
            throws BaseException {
        logger.info(MessageFormat.format("undo - userId={0},originalApplyNo={1}", userId, originalApplyNo));
        BaseResult result = new BaseResult();
        try {

            // 获取channel Id
            UserSession userSession = userSessionDao.getEntityByToken(token);
            // 判断Session是否存在
            if (userSession == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_LOGIN_IN_OTHER_PLACE);
                return result;
            }

            OrderFund orderFund = orderFundDao.getEntityByExtApplyNo(originalApplyNo);
            if (orderFund == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ORDER_FIND);
                return result;
            }

            TradeOrder tradeOrder = tradeOrderDao.getEntityByOrderId(orderFund.getOrderId());
            if (tradeOrder == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ORDER_FIND);
                return result;
            }

            UserBank userBank = userBankDao.getEntityByBankNo(userId, tradeOrder.getBankAccount(),
                    tradeOrder.getPaymentType());
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }

            // 判断此交易是否可以撤单
            ApplyModel applyModel = queryService.queryApply(originalApplyNo);
            if (applyModel != null) {
                if (!applyModel.getUndoStatus()) {
                    result.setSuccess(false);
                    result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
                    result.setErrorCode(ErrorConstant.ERROR_UNDO_DISABLE);
                    return result;
                }
            }

            Map<String, Object> map = undoTradeApplyService.undo(originalApplyNo, MD5.MD5Encode(tradePassword),
                    userBank.getExternalTradeAccount(), userSession.getChannelId());

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();

            String externalUndoNo = "";
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                logger.error("buy - error info:" + errorInfo);
            } else {
                result.setSuccess(true);
                // 返回的申请编号
                externalUndoNo = map.get(HSOutputParameterNames.ALLOT_NO).toString();
                orderFund.setExternalUndoNo(externalUndoNo);
                orderFund.setFundStatus(GlobalConstant.FUND_STATUS_CANCEL);
                // 更新订单基金表
                orderFundDao.updateStatus(orderFund);

                // 撤单
                tradeOrder.setOrderStatus(GlobalConstant.ORDER_STATUS_CANCEL);
                // 更新状态
                tradeOrderDao.updateStatus(tradeOrder);

            }

            // 插入交易记录流水
            Transaction transaction = ObjectCreator.createTransaction(map);
            // 不管成功或失败，都插入交易流水
            transactionDao.add(transaction);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "undo - Exception:", exception);
            throw new SystemDBException("undo Failure!", exception);
        }
    }

    @Override
    @Transactional(rollbackFor = { BaseException.class })
    public BaseResult buy(Long userId, String token, String bankAccount, String capitalMode, Integer moneyType,
            String fundName, String fundCode, BigDecimal fundBalance, String shareType, String tradePassword,
            String applyNo) throws BaseException {

        logger.info(MessageFormat.format(
                "buy - userId={0}, bankAccount={1}, capitalMode={2}, moneyType={3}, fundName={4}, fundCode={5}, fundBalance={6},shareType={7}",
                userId, bankAccount, capitalMode, moneyType, fundName, fundCode, fundBalance, shareType));
        AllotTradeResult result = new AllotTradeResult();
        try {

            UserSession userSession = userSessionDao.getEntityByToken(token);
            UserBank userBank = userBankDao.getEntityByBankNo(userId, bankAccount, capitalMode);

            // 判断Session是否存在
            if (userSession == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_LOGIN_IN_OTHER_PLACE);
                return result;
            }

            // 判断是否有银行卡
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }

            // 根据恒生银行编号
            String bankHSCode = "";
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            for (Lookup lookup : lookups) {
                if (lookup.getComponentValue().equals(userBank.getBankCode())) {
                    bankHSCode = lookup.getRuleValue();
                    break;
                }
            }
            if (StringUtil.isEmpty(bankHSCode)) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_NO_BANK_CARD_FIND,
                        ErrorConstant.PLACEHOLDER_FIELD_NO_FIND_FIELD, userBank.getBankCode()));
                return result;
            }

            // 调用接口服务
            Map<String, Object> map = allotTradeService.buy(capitalMode, moneyType, userBank.getExternalTradeAccount(),
                    MD5.MD5Encode(tradePassword), fundCode, bankHSCode, userBank.getUserBankNo(), fundBalance,
                    shareType, userSession.getChannelId());

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            Integer orderStatus = 0;
            Integer fundStatus = 0;
            String externalApplyNo = "";
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY_FAIL;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_APPLY_FAIL;
                logger.error("buy - error info:" + errorInfo);
            } else {
                result.setSuccess(true);

                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_AWAITING_CONFIRM;
                // 返回的申请编号
                externalApplyNo = map.get(HSOutputParameterNames.ALLOT_NO).toString();
                result.setAllotNo(externalApplyNo);
                // 申请日期
                result.setApplyDate(map.get(HSOutputParameterNames.APPLY_DATE).toString());
                // 申请时间
                result.setApplyTime(map.get(HSOutputParameterNames.APPLY_TIME).toString());
                // 发生金额
                result.setBalance(
                        BigDecimalUtil.ConvertToBigDecimal(map.get(HSOutputParameterNames.BALANCE).toString()));
                // 清算日期
                result.setClearDate(map.get(HSOutputParameterNames.CLEAR_DATE).toString());
                // 下单日期
                result.setOrderDate(DateUtils.dateToSimpleStr(new Date()));
                // 下单时间
                result.setOrderTime(DateUtils.dateToTime(new Date()));
            }

            // 订单流水号
            String orderSn = MessageFormat.format("{0}{1}", applyNo, userId);
            // 插入订单数据到本地数据库
            storeData(map, capitalMode, userBank.getBankCode(), userBank.getUserBankNo(), new BigDecimal(0),
                    fundBalance, orderSn, userId, userSession.getChannelId(), GlobalConstant.TRADE_TYPE_BUY,
                    orderStatus, new Date(), externalApplyNo, fundCode, fundName, shareType, fundStatus, 0L, "", "");

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "buy - Exception:", exception);
            throw new SystemDBException("buy Failure!", exception);
        }
    }

    @Override
    public BaseResult sell(Long userId, String token, String bankAccount, String capitalMode, String fundName,
            String fundCode, BigDecimal shares, String shareType, String tradePassword, String applyNo)
            throws BaseException {
        logger.info(MessageFormat.format(
                "sell - userId={0}, bankAccount={1}, capitalMode={2}, fundName={3}, fundCode={4}, shares={5},shareType={6}",
                userId, bankAccount, capitalMode, fundName, fundCode, shares, shareType));

        BaseResult result = new BaseResult();
        try {

            UserSession userSession = userSessionDao.getEntityByToken(token);
            UserBank userBank = userBankDao.getEntityByBankNo(userId, bankAccount, capitalMode);

            // 判断Session是否存在
            if (userSession == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_LOGIN_IN_OTHER_PLACE);
                return result;
            }

            // 判断是否有银行卡
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }

            // 调用接口服务
            Map<String, Object> map = redeemTradeService.sell(capitalMode, userBank.getExternalTradeAccount(),
                    MD5.MD5Encode(tradePassword), fundCode, shareType, shares, userSession.getChannelId());

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            Integer fundStatus = 0;
            Integer orderStatus = 0;
            String externalApplyNo = "";
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY_FAIL;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_APPLY_FAIL;
                logger.error("sell - error info:" + errorInfo);
            } else {
                result.setSuccess(true);

                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_AWAITING_CONFIRM;
                // 返回的申请编号
                externalApplyNo = map.get(HSOutputParameterNames.ALLOT_NO).toString();
            }

            // 插入数据到订单表
            // 订单流水号
            String orderSn = MessageFormat.format("{0}{1}", applyNo, userId);
            // 插入订单数据到本地数据库
            storeData(map, capitalMode, userBank.getBankCode(), userBank.getUserBankNo(), shares, new BigDecimal(0),
                    orderSn, userId, userSession.getChannelId(), GlobalConstant.TRADE_TYPE_SELL, orderStatus,
                    new Date(), externalApplyNo, fundCode, fundName, shareType, fundStatus, 0L, "", "");

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "sell - Exception:", exception);
            throw new SystemDBException("sell Failure!", exception);
        }
    }

    /**
     * 定投申购/修改
     */
    @Override
    @Transactional(rollbackFor = { BaseException.class })
    public BaseResult fix(String applyNo, String tradePassword, Long protocolFixDay, String shareType,
            String bankAccount, String fundName, String protocolPeriodUnit, long userId, BigDecimal balance,
            String fundCode, String capitalMode, String token, String fixModel, String oldExternalScheduledProtocolId,
            String expiryDate) throws BaseException {
        logger.info(MessageFormat.format(
                "fix - userId={0}, applyNo={1}, protocolFixDay={2}, shareType={3}, bankAccount={4}, fundName={5}, protocolPeriodUnit={6}, balance={7}, fundCode={8}, capitalMode={9},token={10}",
                userId, bankAccount, capitalMode, fundName, fundCode, balance, shareType));
        FixAllotResult result = new FixAllotResult();
        try {
            UserSession userSession = userSessionDao.getEntityByToken(token);
            UserBank userBank = userBankDao.getEntityByBankNo(userId, bankAccount, capitalMode);
            // 判断是否有银行卡
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }

            Map<String, Object> map = null;
            String tradeType = "";

            // 调用接口服务
            // 如果是变更，则调用变更接口
            if (GlobalConstant.FIX_MODEL_MODIFY.equals(fixModel) || GlobalConstant.FIX_MODEL_STOP.equals(fixModel)) {

                map = fixModifyTradeService.modifyFix(capitalMode, MD5.MD5Encode(tradePassword),
                        userBank.getExternalTradeAccount(), userSession.getChannelId(), fundCode, balance, shareType,
                        protocolPeriodUnit, protocolFixDay, oldExternalScheduledProtocolId, fixModel, expiryDate);
                // 如果不是变更，则申购接口
            } else {
                map = fixAllotTradeService.fix(capitalMode, MD5.MD5Encode(tradePassword),
                        userBank.getExternalTradeAccount(), userSession.getChannelId(), fundCode, balance, shareType,
                        protocolPeriodUnit, protocolFixDay);
            }

            boolean success = false;
            if (map.get(HSOutputParameterNames.SUCCESS_TYPE) != null) {
                success = "0".equals(map.get(HSOutputParameterNames.SUCCESS_TYPE).toString());
            }

            Integer orderStatus = 0;
            Integer fundStatus = 0;
            String externalApplyNo = "";
            if (!success) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);

                orderStatus = GlobalConstant.ORDER_STATUS_APPLY_FAIL;

                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_APPLY_FAIL;

                logger.error("fix - error info:" + errorInfo);
            } else {
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_AWAITING_CONFIRM;
                // 返回的申请编号
                externalApplyNo = map.get(HSOutputParameterNames.ALLOT_NO).toString();
                // 返回数据
                setSuccessResult(result, map, externalApplyNo, balance, fundName, protocolFixDay, protocolPeriodUnit);
            }

            // 插入数据到订单表
            if (GlobalConstant.FIX_MODEL_MODIFY.equals(fixModel)) {
                tradeType = GlobalConstant.TRADE_TYPE_FIX_MODIFY;
            } else if (GlobalConstant.FIX_MODEL_STOP.equals(fixModel)) {
                tradeType = GlobalConstant.TRADE_TYPE_FIX_STOP;
            } else {
                tradeType = GlobalConstant.TRADE_TYPE_FIX;
            }

            // 定投协议号
            String externalScheduledProtocolId = GlobalConstant.FIX_MODEL_NORMAL.equals(fixModel)
                    ? map.get(HSOutputParameterNames.SCHEDULED_PROTOCOL_ID).toString() : oldExternalScheduledProtocolId;

            // 订单号
            String orderSn = applyNo + userId;
            // 插入订单数据到本地数据库
            storeData(map, capitalMode, userBank.getBankCode(), userBank.getUserBankNo(), new BigDecimal(0), balance,
                    orderSn, userId, userSession.getChannelId(), tradeType, orderStatus, new Date(), externalApplyNo,
                    fundCode, fundName, shareType, fundStatus, protocolFixDay, protocolPeriodUnit,
                    externalScheduledProtocolId);

            // 定投协议号
            result.setScheduledProtocolId(externalScheduledProtocolId);
            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "fix - Exception:", exception);
            throw new SystemDBException("fix Failure!", exception);
        }
    }

    /**
     * 快速赎回
     * @param userId 用户Id
     * @param token Token
     * @param capitalMode 资金方式
     * @param tradePassword 交易密码
     * @param fundCode 基金代码
     * @param shareType 份额类型
     * @param shares 份额
     * @param bankAccount 银行账户
     * @param fundName 基金名称
     * @param applyNo 申请编号
     * @param tradeAcco 交易账号
     * @return 赎回结果
     */
    @Loggable
    @Override
    @Transactional(rollbackFor = { BaseException.class })
    public BaseResult fastRedeem(Long userId, String token, String capitalMode, String tradePassword, String fundCode,
            String shareType, BigDecimal shares, String bankAccount, String fundName, String applyNo, String tradeAcco) {
        BaseResult result = new BaseResult();
        try {
            UserSession userSession = userSessionDao.getEntityByToken(token);
            UserBank userBank = userBankDao.getEntityByBankNo(userId, bankAccount, capitalMode);

            // 判断Session是否存在
            if (userSession == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_LOGIN_IN_OTHER_PLACE);
                return result;
            }

            // 判断是否有银行卡
            if (userBank == null || StringUtil.isEmpty(userBank.getExternalTradeAccount())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
                return result;
            }
            
            if (!tradeAcco.equals(userBank.getExternalTradeAccount())) {
                logger.warn("交易账号不一致，之前的交易账号：{0}，现在的交易账号：{1}", tradeAcco, userBank);
            }

            // 调用恒生快速赎回接口
            Map<String, Object> map = fastRedeemService.fastRedeem(capitalMode, tradeAcco,
                    MD5.MD5Encode(tradePassword), fundCode, shareType, shares, userBank.getBankCode(), bankAccount,
                    userSession.getChannelId());

            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString(); // 是否成功
            Integer fundStatus = 0;// 基金状态
            Integer orderStatus = 0;// 订单状态
            String externalApplyNo = "";
            if (!successType.equals("0")) {
                String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
                result.setSuccess(false);
                result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
                result.setErrorMessage(errorInfo);
                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY_FAIL;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_APPLY_FAIL;
                logger.error("sell - error info:" + errorInfo);
            } else {
                result.setSuccess(true);

                // 订单状态
                orderStatus = GlobalConstant.ORDER_STATUS_APPLY;
                // 基金状态
                fundStatus = GlobalConstant.FUND_STATUS_AWAITING_CONFIRM;
                // 返回的申请编号
                externalApplyNo = map.get(HSOutputParameterNames.ALLOT_NO).toString();
            }

            // 插入数据到订单表
            // 订单流水号
            String orderSn = MessageFormat.format("{0}{1}", applyNo, userId);
            // 插入订单数据到本地数据库
            storeData(map, capitalMode, userBank.getBankCode(), userBank.getUserBankNo(), shares, new BigDecimal(0),
                    orderSn, userId, userSession.getChannelId(), GlobalConstant.TRADE_TYPE_FAST_REDEEM, orderStatus,
                    new Date(), externalApplyNo, fundCode, fundName, shareType, fundStatus, 0L, "", "");
            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "fast redeem - Exception:", exception);
            throw new SystemDBException("fast redeem - Failure!", exception);
        }

    }

    /***
     * 插入订单数据到本地数据库
     * 
     * @param map
     * @param capitalMode
     * @param bankCode
     * @param bankAccount
     * @param shares
     * @param orderBalance
     * @param orderSn
     * @param userId
     * @param channelId
     * @param tradeType
     * @param orderStatus
     * @param applyDate
     * @param externalApplyNo
     * @param fundCode
     * @param fundName
     * @param shareType
     * @param fundStatus
     * @param protocolFixDay
     * @param protocolPeriodUnit
     * @param externalScheduledProtocolId
     */
    private void storeData(Map<String, Object> map, String capitalMode, String bankCode, String bankAccount,
            BigDecimal shares, BigDecimal orderBalance, String orderSn, Long userId, String channelId, String tradeType,
            Integer orderStatus, Date applyDate, String externalApplyNo, String fundCode, String fundName,
            String shareType, Integer fundStatus, Long protocolFixDay, String protocolPeriodUnit,
            String externalScheduledProtocolId) {

        // 插入数据到订单表
        TradeOrder tradeOrder = ObjectCreator.createTradeOrder(capitalMode, bankCode, bankAccount, orderBalance,
                orderSn, userId, channelId, tradeType, orderStatus, applyDate);
        // 插入数据到订单表
        tradeOrderDao.add(tradeOrder);

        // 订单基金表
        OrderFund orderFund = ObjectCreator.createOrderFund(tradeOrder.getOrderId(), shares, orderBalance, fundCode,
                fundName, externalApplyNo, shareType, fundStatus, protocolFixDay, protocolPeriodUnit,
                externalScheduledProtocolId);
        // 插入数据到订单基金表
        orderFundDao.add(orderFund);

        // 插入交易记录流水
        Transaction transaction = ObjectCreator.createTransaction(map);
        transaction.setOrderId(tradeOrder.getOrderId());
        // 不管成功或失败，都插入交易流水
        transactionDao.add(transaction);
    }

    private void setSuccessResult(FixAllotResult result, Map<String, Object> map, String externalApplyNo,
            BigDecimal balance, String fundName, Long protocolFixDay, String protocolPeriodUnit) {
        result.setSuccess(true);
        result.setAllotNo(externalApplyNo);
        // 下次扣款日期
        String nextFixDate = map.get(HSOutputParameterNames.NEXT_FIX_REQUEST_DATE).toString();
        // 将日期转换成YYYY-MM-DD
        result.setNextFixRequestDate(DateUtils.String8ToDateStr(nextFixDate));
        // 金额
        result.setBalance(balance);
        // 基金名称
        result.setFundName(fundName);
        // 定投周期
        result.setProtocolFixDay(protocolFixDay);
        // 扣款日期
        result.setProtocolPeriodUnit(protocolPeriodUnit);
    }

}
