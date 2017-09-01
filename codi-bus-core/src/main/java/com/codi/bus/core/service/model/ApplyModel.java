package com.codi.bus.core.service.model;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import org.springframework.util.Assert;

import com.codi.base.util.DateUtils;
import com.codi.base.util.MoneyUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.FundBusinCodeUtil;
import com.codi.bus.constant.GlobalConstant;

public class ApplyModel {

	/**
	 * fund types
	 * 
	 */
	public static enum FundApplyType {
		Normal, T0;
	}

	private FundApplyType fundApplyType = FundApplyType.Normal;

	public void setFundType(FundApplyType fundApplyType) {
		Assert.notNull(fundApplyType);
		this.fundApplyType = fundApplyType;
	}

	// 基金代码
	private String fundCode;

	public String getFundCode() {
		return this.fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	// 基金名称
	private String fundName;

	public String getFundName() {
		return this.fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	// 申请编号
	private String allotNo;

	public String getAllotNo() {
		return this.allotNo;
	}

	public void setAllotNo(String allotNo) {
		this.allotNo = allotNo;
	}

	// 下单日期
	private String orderDate;

	public String getOrderDate() {
		if (!StringUtil.isEmpty(orderDate)) {
			Date date = DateUtils.stringToDate(orderDate, GlobalConstant.DATE_FORMAT_YYYYMMDD);
			return DateUtils.dateToSimpleStr(date);
		}
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	// 下单时间
	private String orderTime;

	public String getOrderTime() {
		if (!StringUtil.isEmpty(orderTime)) {
			Date date = DateUtils.stringToDate(orderTime, GlobalConstant.DATE_FORMAT_HHMMSS);
			return DateUtils.dateToTime(date);
		}
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	// 申购金额
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	// 申购金额字符串
	public String getBalanceString() {
		return MoneyUtils.formatMoney(balance, 2);
	}

	// 赎回份额
	private BigDecimal shares;

	public BigDecimal getShares() {
		return this.shares;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	// 赎回份额字符串
	public String getSharesString() {
		return MoneyUtils.formatMoney(this.shares, 2);
	}

	// 银行代码
	private String bankCode;

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	// 银行恒生代码
	private String bankHSCode;

	public String getBankHSCode() {
		return this.bankHSCode;
	}

	public void setBankHSCode(String bankHSCode) {
		this.bankHSCode = bankHSCode;
	}

	// 银行名称
	private String bankName;

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	// 扣款状态
	private String deductStatus;

	public String getDeductStatus() {
		return this.deductStatus;
	}

	public void setDeductStatus(String deductStatus) {
		this.deductStatus = deductStatus;
	}

	// 扣款状态名称
	public String getDeductStatusString() {
		if (this.fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_BUY) || getIsFixBuy()) {
			if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_UNCHECK)) {
				return GlobalConstant.DEDUCT_STATUS_UNCHECK_STRING;
			}
			if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_INVALID)) {
				return GlobalConstant.DEDUCT_STATUS_INVALID_STRING;
			}
			if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_VALID)) {
				return GlobalConstant.DEDUCT_STATUS_VALID_STRING;
			}
			if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_SENT)) {
				return GlobalConstant.DEDUCT_STATUS_SENT_STRING;
			}
		}

		if (this.fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL) || getIsFixSell()) {
			if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_VALID)) {
				if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)) {
					if (fundApplyType == FundApplyType.T0) {
						return "交易中";
					}
					return GlobalConstant.DEDUCT_STATUS_SELLING_STRING;
				}

				if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_CONFIRMED)) {
					return GlobalConstant.DEDUCT_STATUS_SELLED_STRING;
				}
			}
		}

		return "";
	}

	// 是否可撤单状态位
	public boolean getUndoStatus() {
		// 定投不能撤单
		if (getIsFixBuy() || getIsFixSell()) {
			return false;
		}
		if (fundApplyType == FundApplyType.T0
				&& GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL.equals(fundBusinCode)) {
			return false;
		}
		// 如果此申购交易已撤单，则不能再撤单
		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_UNDO)) {
			return false;
		}
		// 如果是撤单申请交易，则不能再对撤单交易再撤单
		if (this.fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_UNDO)) {
			return false;
		}
		// 15:00, 有效、未发送的交易才可以撤单
		Date date = DateUtils.stringToDate(
				MessageFormat.format("{0}{1}", this.applyDate, GlobalConstant.WORKING_DATE_END_TIME),
				DateUtils.yyyyMMddHHmmss_plain);
		Date now = new Date();
		if (this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_VALID)
				&& this.sendFlag.equals(GlobalConstant.SEND_FLAG_UNSEND) && now.before(date)) {
			return true;
		}
		return false;
	}

	/**
	 * 是否是定投申购
	 * 
	 * @return
	 */
	public boolean getIsFixBuy() {
		return FundBusinCodeUtil.isFixBuy(this.fundBusinCode);
	}

	/**
	 * 是否是定投赎回
	 * 
	 * @return
	 */
	public boolean getIsFixSell() {
		return FundBusinCodeUtil.isFixSell(this.fundBusinCode);
	}

	// 确认标志
	private String taConfirmFlag;

	public String getTAConfirmFlag() {
		return this.taConfirmFlag;
	}

	public void setTAConfirmFlag(String taConfirmFlag) {
		this.taConfirmFlag = taConfirmFlag;
	}

	// 确认标志字符串
	public String getTAConfirmFlagString() {
		// 未确认且非无效扣款状态
		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)
				&& !this.deductStatus.equals(GlobalConstant.DEDUCT_STATUS_INVALID)) {
			return GlobalConstant.TACONFIRM_FLAG_UNCONFIRM_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_ACTION)) {
			return GlobalConstant.TACONFIRM_FLAG_ACTION_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_CONFIRMED)) {
			if (fundApplyType == FundApplyType.T0) {
				return "交易成功";
			}
			return GlobalConstant.TACONFIRM_FLAG_CONFIRMED_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_FAIL)) {
			if (fundApplyType == FundApplyType.T0) {
				return "交易失败";
			}
			return GlobalConstant.TACONFIRM_FLAG_FAIL_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_PART_CONFIRMED)) {
			return GlobalConstant.TACONFIRM_FLAG_PART_CONFIRMED_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS)) {
			if (fundApplyType == FundApplyType.T0) {
				return "交易成功";
			}
			return GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS_STRING;
		}

		if (this.taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_UNDO)) {
			return GlobalConstant.TACONFIRM_FLAG_UNDO_STRING;
		}
		return "";
	}

	// 业务代码
	private String fundBusinCode;

	public String getFundBusinCode() {
		return this.fundBusinCode;
	}

	public void setFundBusinCode(String fundBusinCode) {
		this.fundBusinCode = fundBusinCode;
	}

	// 业务名称从数据库Lookup表中获取
	private String fundBusinName;

	public void setFundBusinName(String fundBusinName) {
		this.fundBusinName = fundBusinName;
	}

	// 业务名称
	public String getFundBusinName() {
		if (fundApplyType == FundApplyType.T0) {
			if (FundBusinCodeUtil.isBuy(this.fundBusinCode)) {
				return "存入";
			} else if (FundBusinCodeUtil.isT0Sell(fundBusinCode)) {
				return "快速取现";
			} else if (FundBusinCodeUtil.isNormalSell(fundBusinCode)) {
				return "普通取现";
			} else if (FundBusinCodeUtil.isSell(fundBusinCode)) {
				return "取现";
			}
		}
		return this.fundBusinName;
	}

	// 交易账号
	private String tradeAcco;

	public String getTradeAcco() {
		return this.tradeAcco;
	}

	public void setTradeAcco(String tradeAcco) {
		this.tradeAcco = tradeAcco;
	}

	// 发送状态
	private String sendFlag;

	public String getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	// 申请日期（15:00之后，申请日期为T+1)
	private String applyDate;

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

}
