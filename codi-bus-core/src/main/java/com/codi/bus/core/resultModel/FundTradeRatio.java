package com.codi.bus.core.resultModel;

public class FundTradeRatio extends BaseResult {

	private static final long serialVersionUID = 1L;
	
	private String fund_code; //基金代码
	private String balance; //金额
	private String discount; //费率折扣率
	private String end_discount; //后收费折扣率
	private String other_discount; //补差费折扣率
	private String fee; //最终费用
	private String origin_fee; //原始的费用
	private String discount_fee; //优惠金额
	private String ratio;
	private String min_fare_ratio; //最小费率
    private String min_fare; //最小费用
    private String max_fare; //最大费用
	
	public FundTradeRatio() {
		this.setSuccess(Boolean.TRUE);
	}
	
	public String getFund_code() {
		return fund_code;
	}
	public void setFund_code(String fund_code) {
		this.fund_code = fund_code;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getEnd_discount() {
		return end_discount;
	}
	public void setEnd_discount(String end_discount) {
		this.end_discount = end_discount;
	}
	public String getOther_discount() {
		return other_discount;
	}
	public void setOther_discount(String other_discount) {
		this.other_discount = other_discount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getOrigin_fee() {
		return origin_fee;
	}
	public void setOrigin_fee(String origin_fee) {
		this.origin_fee = origin_fee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDiscount_fee() {
		return discount_fee;
	}

	public void setDiscount_fee(String discount_fee) {
		this.discount_fee = discount_fee;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getMin_fare_ratio() {
		return min_fare_ratio;
	}

	public void setMin_fare_ratio(String min_fare_ratio) {
		this.min_fare_ratio = min_fare_ratio;
	}

	public String getMin_fare() {
		return min_fare;
	}

	public void setMin_fare(String min_fare) {
		this.min_fare = min_fare;
	}

	public String getMax_fare() {
		return max_fare;
	}

	public void setMax_fare(String max_fare) {
		this.max_fare = max_fare;
	}
}
