package com.codi.trade.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 快速赎回
 * @author song-jj
 */
public interface FastRedeemService {
    
    /**
     * 快速赎回 
     * @param capitalMode 资金方式
     * @param tradeAcco 交易账号
     * @param password 加密后的交易密码
     * @param fundCode 基金代码
     * @param shareType 份额分类
     * @param shares 发生份额
     * @param bankCode 银行代码
     * @param bankAccount 银行账号
     * @param tradeSource 交易来源
     * @return 恒生返回的输出参数
     * @author song-jj
     */
    Map<String, Object> fastRedeem(String capitalMode, String tradeAcco, String password, String fundCode,
            String shareType, BigDecimal shares, String bankCode, String bankAccount, String tradeSource);
}
