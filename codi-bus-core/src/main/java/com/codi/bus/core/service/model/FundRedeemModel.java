package com.codi.bus.core.service.model;

import com.codi.base.domain.BaseDomain;

/**
 * 基金赎回费率模型
 * 
 * @author shi.pengyan
 * @date 2016年10月8日 下午1:48:02
 */
public class FundRedeemModel extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String minDay;
    private String maxDay;
    private String fareRatio;

    public String getMinDay() {
        return minDay;
    }

    public void setMinDay(String minDay) {
        this.minDay = minDay;
    }

    public String getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(String maxDay) {
        this.maxDay = maxDay;
    }

    public String getFareRatio() {
        return fareRatio;
    }

    public void setFareRatio(String fareRatio) {
        this.fareRatio = fareRatio;
    }

}
