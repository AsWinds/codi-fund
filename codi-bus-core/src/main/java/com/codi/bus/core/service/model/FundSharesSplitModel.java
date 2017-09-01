package com.codi.bus.core.service.model;

import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 下午2:14:05
 */
public class FundSharesSplitModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private Date splitDay; // 拆分折算日
    private String splitRatio; // 拆分折算比例(1:X)

    public Date getSplitDay() {
        return splitDay;
    }

    public void setSplitDay(Date splitDay) {
        this.splitDay = splitDay;
    }

    public String getSplitRatio() {
        return splitRatio;
    }

    public void setSplitRatio(String splitRatio) {
        this.splitRatio = splitRatio;
    }
}
