package com.codi.bus.core.service.model;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月27日 上午10:05:22
 */
public class FundInvestAdvisorFundModel extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String fundCode;
    private String fundName;
    private String fundNameAbbr;
    private String fundType;
    private Integer fundTypeCode;
    private String RRInSingleYear;// 一年回报率

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

    public String getFundNameAbbr() {
        return fundNameAbbr;
    }

    public void setFundNameAbbr(String fundNameAbbr) {
        this.fundNameAbbr = fundNameAbbr;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public Integer getFundTypeCode() {
        return fundTypeCode;
    }

    public void setFundTypeCode(Integer fundTypeCode) {
        this.fundTypeCode = fundTypeCode;
    }

    public String getRRInSingleYear() {
        return RRInSingleYear;
    }

    public void setRRInSingleYear(String rRInSingleYear) {
        RRInSingleYear = rRInSingleYear;
    }

}
