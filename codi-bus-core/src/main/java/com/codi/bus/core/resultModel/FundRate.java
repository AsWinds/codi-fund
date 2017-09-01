package com.codi.bus.core.resultModel;

import java.math.BigDecimal;

import com.codi.base.domain.BaseDomain;
import com.codi.base.util.StringUtil;

public class FundRate extends BaseDomain implements Comparable<FundRate> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String zoneno;
    private String fund_code;
    private String share_type;
    private String busin_flag;
    private String fare_type;
    private String cust_type;
    private String sale_type;
    private String min_balance;
    private String max_balance;
    private String min_predays;
    private String max_predays;
    private String min_hold;
    private String max_hold;
    private String ratio;
    private String min_fare;
    private String max_fare;

    public String getZoneno() {
        return zoneno;
    }

    public void setZoneno(String zoneno) {
        this.zoneno = zoneno;
    }

    public String getFund_code() {
        return fund_code;
    }

    public void setFund_code(String fund_code) {
        this.fund_code = fund_code;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public String getBusin_flag() {
        return busin_flag;
    }

    public void setBusin_flag(String busin_flag) {
        this.busin_flag = busin_flag;
    }

    public String getFare_type() {
        return fare_type;
    }

    public void setFare_type(String fare_type) {
        this.fare_type = fare_type;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public String getSale_type() {
        return sale_type;
    }

    public void setSale_type(String sale_type) {
        this.sale_type = sale_type;
    }

    public String getMin_balance() {
        return min_balance;
    }

    public void setMin_balance(String min_balance) {
        this.min_balance = min_balance;
    }

    public String getMax_balance() {
        return max_balance;
    }

    public void setMax_balance(String max_balance) {
        this.max_balance = max_balance;
    }

    public String getMin_predays() {
        return min_predays;
    }

    public void setMin_predays(String min_predays) {
        this.min_predays = min_predays;
    }

    public String getMax_predays() {
        return max_predays;
    }

    public void setMax_predays(String max_predays) {
        this.max_predays = max_predays;
    }

    public String getMin_hold() {
        if (StringUtil.isEmpty(min_hold)) {
            return "0";
        }
        return min_hold;
    }

    public void setMin_hold(String min_hold) {
        this.min_hold = min_hold;
    }

    public String getMax_hold() {
        return max_hold;
    }

    public void setMax_hold(String max_hold) {
        this.max_hold = max_hold;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getMin_fare() {
        return min_fare;
    }

    public void setMin_fare(String min_fare) {
        this.min_fare = min_fare;
    }

    public String getMax_fare() {
        return max_fare;
    }

    public void setMax_fare(String max_fare) {
        this.max_fare = max_fare;
    }

    @Override
    public int compareTo(FundRate fundRate) {
        BigDecimal before = new BigDecimal(this.getMin_balance());
        BigDecimal after = new BigDecimal(fundRate.getMin_balance());
        return before.compareTo(after);
    }

}
