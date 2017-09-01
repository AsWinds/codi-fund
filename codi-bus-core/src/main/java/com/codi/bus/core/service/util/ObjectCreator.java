package com.codi.bus.core.service.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.domain.OrderFund;
import com.codi.bus.core.domain.TradeOrder;
import com.codi.bus.core.domain.Transaction;
import com.codi.bus.core.domain.UserBank;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;

/***
 * 用于实例化对象
 * @author Shangdu Lin
 *
 */
public class ObjectCreator {

    /***
     * 生成Transaction对象
     * 
     * @param map
     *            恒生返回的map
     * @return
     */
    public static Transaction createTransaction(Map<String, Object> map) {
        // 判断请求是否成功
        boolean isSuccess = true;
        if (map.containsKey(HSOutputParameterNames.SUCCESS_TYPE)) {
            String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
            if (!successType.equals("0")) {
                isSuccess = false;
            } else {
                isSuccess = true;
            }
        } else if (map.containsKey(HSOutputParameterNames.ERROR_CODE)) {
            isSuccess = false;
        }

        // 插入交易记录流水
        Transaction transaction = new Transaction();
        transaction.setTransactionApi(map.get(GlobalConstant.KEY_API).toString());
        transaction.setRequestContent(map.get(GlobalConstant.KEY_REQUEST).toString());
        transaction.setResponseContent(map.get(GlobalConstant.KEY_RESPONSE).toString());
        transaction.setTransactionType(GlobalConstant.TRANSACTION_TYPE_HSAPI);

        if (!isSuccess) {
            // 交易状态-失败
            transaction.setTransactionStatus(GlobalConstant.TRANSACTION_STATUS_FAIL);
        } else {
            // 交易状态-成功
            transaction.setTransactionStatus(GlobalConstant.TRANSACTION_STATUS_SUCCESS);
        }

        return transaction;
    }

    /***
     * 生成UserBank对象
     * 
     * @param bankCode
     * @param bankName
     * @param capitalMode
     * @param externalProtocolNo
     * @param externalTradeAccount
     * @param mobile
     * @param bankNo
     * @param userName
     * @param userId
     * @return
     */
    public static UserBank createUserBank(String bankCode, String bankName, String capitalMode,
            String externalProtocolNo, String externalTradeAccount, String mobile, String bankNo, String userName,
            long userId) {
        UserBank bankEntity = new UserBank();
        bankEntity.setBankCode(bankCode);
        bankEntity.setBankName(bankName);
        bankEntity.setCapitalMode(capitalMode);
        bankEntity.setExternalProtocolNo(externalProtocolNo);
        bankEntity.setExternalTradeAccount(externalTradeAccount);
        bankEntity.setUserBankMobile(mobile);
        bankEntity.setUserBankNo(bankNo);
        bankEntity.setUserBankOwner(userName);
        bankEntity.setUserId(userId);

        return bankEntity;
    }

    /***
     * 生成TradeOrder对象
     * 
     * @param capitalMode
     * @param bankCode
     * @param bankAccount
     * @param orderBalance
     * @param orderSn
     * @param userId
     * @param channelId
     * @param tradeType
     * @param orderStatus
     * @param applyDate
     * @return
     */
    public static TradeOrder createTradeOrder(String capitalMode, String bankCode, String bankAccount,
            BigDecimal orderBalance, String orderSn, Long userId, String channelId, String tradeType,
            Integer orderStatus, Date applyDate) {
        // 订单流水号
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setMoneyType(GlobalConstant.MONEY_TYPE_RMB);
        tradeOrder.setPaymentType(capitalMode);
        tradeOrder.setBankCode(bankCode);
        tradeOrder.setBankAccount(bankAccount);
        tradeOrder.setOrderBalance(orderBalance);
        tradeOrder.setOrderSn(orderSn);
        tradeOrder.setUserId(userId);
        tradeOrder.setChannelId(channelId);
        tradeOrder.setTradeType(tradeType);
        tradeOrder.setOrderStatus(orderStatus);
        tradeOrder.setApplyDate(applyDate);

        return tradeOrder;
    }

    /***
     * 生成OrderFund对象
     * 
     * @param orderId
     * @param shares
     * @param balance
     * @param fundCode
     * @param fundName
     * @param externalApplyNo
     * @param shareType
     * @param fundStatus
     * @param protocolFixDay
     * @param protocolPeriodUnit
     * @param externalScheduledProtocolId
     * @return
     */
    public static OrderFund createOrderFund(Long orderId, BigDecimal shares, BigDecimal balance, String fundCode,
            String fundName, String externalApplyNo, String shareType, Integer fundStatus, Long protocolFixDay,
            String protocolPeriodUnit, String externalScheduledProtocolId) {
        // 订单基金表
        OrderFund orderFund = new OrderFund();
        // 插入数据到订单基金表
        orderFund.setOrderId(orderId);
        orderFund.setShares(shares);
        orderFund.setFundBalance(balance);
        orderFund.setFundCode(fundCode);
        orderFund.setFundName(fundName);
        orderFund.setExternalApplyNo(externalApplyNo);
        orderFund.setShareType(shareType);
        orderFund.setFundStatus(fundStatus);
        orderFund.setExternalProtocolFixDay(protocolFixDay);
        orderFund.setExternalProtocolPeriodUnit(protocolPeriodUnit);
        orderFund.setExternalScheduledProtocolId(externalScheduledProtocolId);

        return orderFund;
    }
}
