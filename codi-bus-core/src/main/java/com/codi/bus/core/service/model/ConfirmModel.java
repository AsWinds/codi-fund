package com.codi.bus.core.service.model;

import java.math.BigDecimal;

public class ConfirmModel {
	// 基金代码
	private String fundCode;

	public String getFundCode() {
		return this.fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	// 总记录数
	private Long totalCount;

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalCount() {
		return this.totalCount;
	}

	// 记录数
	private Long rowCount;

	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}

	public Long getRowCount() {
		return this.rowCount;
	}

	// 确认标志
	private String taConfirmFlag;

	public String getTAConfirmFlag() {
		return this.taConfirmFlag;
	}

	public void setTAConfirmFlag(String taConfirmFlag) {
		this.taConfirmFlag = taConfirmFlag;
	}

	// 业务代码
	private String fundBusinCode;

	public String getFundBusinCode() {
		return this.fundBusinCode;
	}

	public void setFundBusinCode(String fundBusinCode) {
		this.fundBusinCode = fundBusinCode;
	}

	// 交易账号
	private String tradeAcco;

	public String getTradeAcco() {
		return this.tradeAcco;
	}

	public void setTradeAcco(String tradeAcco) {
		this.tradeAcco = tradeAcco;
	}

	// 交易确认金额 - 即本金
	private BigDecimal confirmBalance;

	public BigDecimal getConfirmBalance() {
		return this.confirmBalance;
	}

	public void setConfirmBalance(BigDecimal confirmBalance) {
		this.confirmBalance = confirmBalance;
	}

    // 交易确认份额
    private BigDecimal confirmShares;

    public BigDecimal getConfirmShares() {
        return this.confirmShares;
    }

    public void setConfirmShares(BigDecimal confirmShares) {
        this.confirmShares = confirmShares;
    }

    // 交易账号
    private String affirmDate;

    public String getAffirmDate() {
        return this.affirmDate;
    }

    public void setAffirmDate(String affirmDate) {
        this.affirmDate = affirmDate;
    }

}
