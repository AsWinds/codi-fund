package com.codi.bus.core.service.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.domain.BaseDomain;

/**
 * 钱包七日年化收益率模型
 * 
 * @author shi.pengyan
 * @date 2016年12月9日 上午10:21:15
 */
public class WalletDetailRateSimpleModel extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date tradingDay;
    private String rate;

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

}
