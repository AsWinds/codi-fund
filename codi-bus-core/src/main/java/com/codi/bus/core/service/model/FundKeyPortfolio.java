package com.codi.bus.core.service.model;

import java.math.BigDecimal;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:01:12
 */
public class FundKeyPortfolio extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String fundName;
    private String fundNameAbbr;
    private String fundTypeCode;
    private BigDecimal ratioInNV;

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

    public String getFundTypeCode() {
        return fundTypeCode;
    }

    public void setFundTypeCode(String fundTypeCode) {
        this.fundTypeCode = fundTypeCode;
    }

    public BigDecimal getRatioInNV() {
        return ratioInNV;
    }

    public void setRatioInNV(BigDecimal ratioInNV) {
        this.ratioInNV = ratioInNV;
    }

}
