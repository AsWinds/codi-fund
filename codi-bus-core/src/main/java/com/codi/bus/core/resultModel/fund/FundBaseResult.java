package com.codi.bus.core.resultModel.fund;

import com.codi.bus.core.resultModel.BaseResult;

/**
 * 基金基类
 * 
 * @author shi.pengyan
 * @date 2016年10月14日 下午2:38:28
 */
public class FundBaseResult extends BaseResult {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer innerCode;
    private String fundCode;
    private String fundType;
    private Integer fundTypeCode;

    // 特殊类型，550012 短期理财
    private String originFundType;// 原始类型
    private Integer originFundTypeCode;// 原始类型编码

    public Integer getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
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

    public String getOriginFundType() {
        return originFundType;
    }

    public void setOriginFundType(String originFundType) {
        this.originFundType = originFundType;
    }

    public Integer getOriginFundTypeCode() {
        return originFundTypeCode;
    }

    public void setOriginFundTypeCode(Integer originFundTypeCode) {
        this.originFundTypeCode = originFundTypeCode;
    }
}
