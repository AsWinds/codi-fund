package com.codi.bus.core.service.model;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 折扣模型
 * 
 * @author shi.pengyan
 * @date 2016年9月30日 上午11:17:30
 */
public class FundDiscountModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private Date beginDate;
    private Date endDate;

    private String minBalanceValue;
    private String maxBalanceValue;
    private String discount;
    private String fareRatioAfterDiscount;
    private String minFareRatio;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMinBalanceValue() {
        return minBalanceValue;
    }

    public void setMinBalanceValue(String minBalanceValue) {
        this.minBalanceValue = minBalanceValue;
    }

    public String getMaxBalanceValue() {
        return maxBalanceValue;
    }

    public void setMaxBalanceValue(String maxBalanceValue) {
        this.maxBalanceValue = maxBalanceValue;
    }

    public String getFareRatioAfterDiscount() {
        return fareRatioAfterDiscount;
    }

    public void setFareRatioAfterDiscount(String fareRatioAfterDiscount) {
        this.fareRatioAfterDiscount = fareRatioAfterDiscount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMinFareRatio() {
        return minFareRatio;
    }

    public void setMinFareRatio(String minFareRatio) {
        this.minFareRatio = minFareRatio;
    }
}
