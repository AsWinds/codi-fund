/**
 * 基金定投
 */
package com.codi.bus.core.service.model;

import java.math.BigDecimal;

import com.codi.base.util.MoneyUtils;

/**
 * @author song-jj
 *
 */
public class FixModel {
    
    /**
     * 基金代码
     */
    private String fundCode;
    
    /**
     * 基金名称
     */
    private String fundName;
    
    /**
     * 协议周期单位
     */
    private String protocolPeriodUnit;
    
    /**
     * 定投交易日
     */
    private Long protocolFixDay;
    
    /**
     * 发生金额
     */
    private BigDecimal balance;
    
    /**
     * 累计确认金额
     */
    private BigDecimal totalCfmBala;
    
    /**
     * 银行名称
     */
    private String bankName;
    
    /**
     * 银行账户
     */
    private String bankAccount;
    
    /**
     * 定投协议号
     */
    private String scheduledProtocolId;
    
    /**
     * 首次交易日期
     */
    private Integer firstExchDate;
    
    /**
     * 巨额赎回标志
     */
    private String fundExceedFlag; 
    
    /**
     * 发生份额
     */
    private String shares;
    
    /**
     * 终止日期
     */
    private String expiryDate;
    
    /**
     * 定投状态
     */
    private String fixState;
    
    /**
     * 资金方式（支付方式）
     */
    private String capitalMode;
    
    /**
     * 下一扣款日期
     */
    private String nextFixRequestDate;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getProtocolPeriodUnit() {
        return protocolPeriodUnit;
    }

    public void setProtocolPeriodUnit(String protocolPeriodUnit) {
        this.protocolPeriodUnit = protocolPeriodUnit;
    }

    public Long getProtocolFixDay() {
        return protocolFixDay;
    }

    public void setProtocolFixDay(Long protocolFixDay) {
        this.protocolFixDay = protocolFixDay;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    // 申购金额字符串
    public String getBalanceString() {
        return MoneyUtils.formatMoney(balance, 2);
    }

    public BigDecimal getTotalCfmBala() {
        return totalCfmBala;
    }

    public void setTotalCfmBala(BigDecimal totalCfmBala) {
        this.totalCfmBala = totalCfmBala;
    }

    public String getScheduledProtocolId() {
        return scheduledProtocolId;
    }

    public void setScheduledProtocolId(String scheduledProtocolId) {
        this.scheduledProtocolId = scheduledProtocolId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getFirstExchDate() {
        return firstExchDate;
    }

    public void setFirstExchDate(Integer firstExchDate) {
        this.firstExchDate = firstExchDate;
    }

    public String getFundExceedFlag() {
        return fundExceedFlag;
    }

    public void setFundExceedFlag(String fundExceedFlag) {
        this.fundExceedFlag = fundExceedFlag;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }  

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFixState() {
        return fixState;
    }

    public void setFixState(String fixState) {
        this.fixState = fixState;
    }

    public String getCapitalMode() {
        return capitalMode;
    }

    public void setCapitalMode(String capitalMode) {
        this.capitalMode = capitalMode;
    }

    public String getNextFixRequestDate() {
        return nextFixRequestDate;
    }

    public void setNextFixRequestDate(String nextFixRequestDate) {
        this.nextFixRequestDate = nextFixRequestDate;
    }
    
}
