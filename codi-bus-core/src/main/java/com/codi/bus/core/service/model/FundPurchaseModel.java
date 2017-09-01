package com.codi.bus.core.service.model;

import java.util.List;

import com.codi.base.domain.BaseDomain;

/**
 * 购买须知模型
 * 
 * @author shi.pengyan
 * @date 2016年11月7日 上午10:00:00
 */
public class FundPurchaseModel extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String minValue;
    private String maxValue;
    private String fareRatio;
    // 如果fareRatio为0，则判断是否有【一笔一次性费用】
    private String minFare;// 最小费用
    private String maxFare; // 最大费用

    private List<FundDiscountModel> discountList;

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getFareRatio() {
        return fareRatio;
    }

    public void setFareRatio(String fareRatio) {
        this.fareRatio = fareRatio;
    }

    public List<FundDiscountModel> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<FundDiscountModel> discountList) {
        this.discountList = discountList;
    }

    public String getMinFare() {
        return minFare;
    }

    public void setMinFare(String minFare) {
        this.minFare = minFare;
    }

    public String getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(String maxFare) {
        this.maxFare = maxFare;
    }

}
