package com.codi.bus.core.service.model;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 下午2:10:23
 */
public class FundDividendModel extends BaseDomain {

    private static final long serialVersionUID = 1L;
    private String ratio;
    private Date reDate;
    private Date exRightDate;
    private Date executeDate;


    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public Date getExRightDate() {
        return exRightDate;
    }

    public void setExRightDate(Date exRightDate) {
        this.exRightDate = exRightDate;
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }
}
