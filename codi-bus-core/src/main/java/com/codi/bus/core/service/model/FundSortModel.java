package com.codi.bus.core.service.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.domain.BaseDomain;

/**
 * 基金排行模型
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 上午11:30:05
 */
public class FundSortModel extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String fundCode;
    private String fundName;
    private String fundNameAbbr;
    
    @JSONField(serialize=false)
    private Integer innerCode;

    @JSONField(format = "yyyy-MM-dd")
    private Date tradingDay; // 交易日

    // 非货基 货基
    // @JSONField(serializeUsing = BigDecimal2Serializer.class)
    private String rate;// 日增长率； 七日年化率; %
    // @JSONField(serializeUsing = BigDecimal4Serializer.class)
    private String value;// 单位净值; 万份收益 ; 保留四位

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

    public Integer getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
