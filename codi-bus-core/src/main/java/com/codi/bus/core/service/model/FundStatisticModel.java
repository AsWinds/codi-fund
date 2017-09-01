package com.codi.bus.core.service.model;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.domain.BaseDomain;

/**
 * 统一化统计数据模型
 * 
 * @author shi.pengyan
 * @date 2016年11月4日 下午3:09:34
 */
public class FundStatisticModel extends BaseDomain {

    /**
     */
    private static final long serialVersionUID = 1L;

    @JSONField(format = "yyyy-MM-dd")
    private Date tradingDay;

    private BigDecimal rate;

    // @JSONField(serialize = false) //需要存储到Redis中
    private BigDecimal closePrice; // 不序列化

    public Date getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(Date tradingDay) {
        this.tradingDay = tradingDay;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

}
