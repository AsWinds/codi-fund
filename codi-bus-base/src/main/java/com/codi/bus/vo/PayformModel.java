package com.codi.bus.vo;

/**
 * 支付表单的数据模型
 * @author shenxi
 *
 */
public class PayformModel {
	// 订单编号
	private String orderSn;
	// 支付方式
	private String paymentWay;
	// 商品名称
	private String goodTitle;
	// 买家ID
	private String buyerId;
	// 卖家ID
	private String sellerId;
	// 交易总金额
	private String totalAmount;
	// 商品总件数
	private String goodQuantity;
	// 交易类型：普通商品|券
	private String orderType;
	// 签名
	private String sign;
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public String getGoodTitle() {
		return goodTitle;
	}
	public void setGoodTitle(String goodTitle) {
		this.goodTitle = goodTitle;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getGoodQuantity() {
		return goodQuantity;
	}
	public void setGoodQuantity(String goodQuantity) {
		this.goodQuantity = goodQuantity;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
}
