package com.codi.bus.core.service.model;

import java.math.BigDecimal;

/**
 * Created by Shangdu Lin on 2017/6/12 14:39.
 */
public class DividendModel {

    /**
     * 交易账号
     */
    private String tradeAccount;

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    /**
     * TA账号
     */
    private String taAccount;

    public String getTaAccount() {
        return taAccount;
    }

    public void setTaAccount(String taAccount) {
        this.taAccount = taAccount;
    }

    /**
     * 基金代码
     */
    private String fundCode;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    /**
     * 红利总金额
     */
    private BigDecimal totalDividendBalance;

    public BigDecimal getTotalDividendBalance() {
        return totalDividendBalance;
    }

    public void setTotalDividendBalance(BigDecimal totalDividendBalance) {
        this.totalDividendBalance = totalDividendBalance;
    }
}
