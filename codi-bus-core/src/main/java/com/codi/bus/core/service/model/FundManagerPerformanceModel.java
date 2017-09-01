package com.codi.bus.core.service.model;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金经理的业绩
 * 
 * @author shi.pengyan
 * @date 2016年10月9日 下午1:27:09
 */
public class FundManagerPerformanceModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String fundName;
    private String fundNameAbbr;
    private String fundCode;
    private Date accessionDate;// 到任日期
    private Date dimissionDate;// 结束日期
    private String performance;

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

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public Date getAccessionDate() {
        return accessionDate;
    }

    public void setAccessionDate(Date accessionDate) {
        this.accessionDate = accessionDate;
    }

    public Date getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
