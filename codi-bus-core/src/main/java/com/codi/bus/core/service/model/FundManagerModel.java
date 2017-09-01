package com.codi.bus.core.service.model;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金经理简化信息
 * 
 * @author shi.pengyan
 * @date 2016年10月9日 下午1:27:09
 */
public class FundManagerModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private Long code; // 基金经理编码
    private String name;// 基金经理名称
    private Date accessionDate;// 到任日期
    private String performance;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAccessionDate() {
        return accessionDate;
    }

    public void setAccessionDate(Date accessionDate) {
        this.accessionDate = accessionDate;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

}
