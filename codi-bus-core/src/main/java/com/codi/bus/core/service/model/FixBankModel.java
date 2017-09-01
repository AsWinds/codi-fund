package com.codi.bus.core.service.model;

/**
 * 定投银行信息
 * @author song-jj
 */
public class FixBankModel {

    /**
     * 银行名称
     */
    private String bankName;
    
    /**
     * 银行账号
     */
    private String bankAccount;
    
    /**
     * 定投协议号
     */
    private String scheduledProtocolId;

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

    public String getScheduledProtocolId() {
        return scheduledProtocolId;
    }

    public void setScheduledProtocolId(String scheduledProtocolId) {
        this.scheduledProtocolId = scheduledProtocolId;
    }
    
}
