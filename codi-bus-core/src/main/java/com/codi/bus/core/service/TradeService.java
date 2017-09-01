package com.codi.bus.core.service;

import java.math.BigDecimal;

import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.exception.BaseException;

public interface TradeService {
    // 申购基金
    BaseResult buy(Long userId, String token, String bankAccount, String paymentType, Integer moneyType,
            String fundName, String fundCode, BigDecimal fundBalance, String shareType, String tradePassword,
            String applyNo) throws BaseException;

    // 赎回基金
    BaseResult sell(Long userId, String token, String bankAccount, String paymentType, String fundName, String fundCode,
            BigDecimal shares, String shareType, String tradePassword, String applyNo) throws BaseException;

    // 撤单
    BaseResult undo(Long userId, String token, String originalApplyNo, String tradePassword) throws BaseException;

    /**
     * 定投申购
     * 
     * @param applyNo
     * @param tradePassword
     * @param protocolFixDay
     * @param shareType
     * @param bankAccount
     * @param fundName
     * @param protocolPeriodUnit
     * @param userId
     * @param balance
     * @param fundCode
     * @param capitalMode
     * @param token
     * @return
     * @throws BaseException
     */
    BaseResult fix(String applyNo, String tradePassword, Long protocolFixDay, String shareType, String bankAccount,
            String fundName, String protocolPeriodUnit, long userId, BigDecimal balance, String fundCode,
            String capitalMode, String token, String fixModel, String oldExternalScheduledProtocolId, String expiryDate)
            throws BaseException;

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
    BaseResult fastRedeem(Long userId, String token, String capitalMode, String tradePassword, String fundCode,
            String shareType, BigDecimal shares, String bankAccount, String fundName, String applyNo, String tradeAcco);

}
