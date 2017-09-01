package com.codi.bus.core.resultModel;

import java.math.BigDecimal;

import com.codi.base.domain.BaseDomain;

public class FundDiscountSetting extends BaseDomain implements Comparable<FundDiscountSetting> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String success_type;
    private String trust_way;
    private String fund_busin_code;
    private String cust_kind;
    private String cust_type;
    private String fund_code;
    private String share_type;
    private String belongdate_begin;
    private String belongdate_end;
    private String discount;
    private String end_discount;
    private String other_discount;
    private String min_bala;
    private String max_bala;
    private String min_fare_ratio;

    public String getSuccess_type() {
        return success_type;
    }

    public void setSuccess_type(String success_type) {
        this.success_type = success_type;
    }

    public String getTrust_way() {
        return trust_way;
    }

    public void setTrust_way(String trust_way) {
        this.trust_way = trust_way;
    }

    public String getFund_busin_code() {
        return fund_busin_code;
    }

    public void setFund_busin_code(String fund_busin_code) {
        this.fund_busin_code = fund_busin_code;
    }

    public String getCust_kind() {
        return cust_kind;
    }

    public void setCust_kind(String cust_kind) {
        this.cust_kind = cust_kind;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
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

    public String getBelongdate_begin() {
        return belongdate_begin;
    }

    public void setBelongdate_begin(String belongdate_begin) {
        this.belongdate_begin = belongdate_begin;
    }

    public String getBelongdate_end() {
        return belongdate_end;
    }

    public void setBelongdate_end(String belongdate_end) {
        this.belongdate_end = belongdate_end;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getEnd_discount() {
        return end_discount;
    }

    public void setEnd_discount(String end_discount) {
        this.end_discount = end_discount;
    }

    public String getOther_discount() {
        return other_discount;
    }

    public void setOther_discount(String other_discount) {
        this.other_discount = other_discount;
    }

    public String getMin_bala() {
        return min_bala;
    }

    public void setMin_bala(String min_bala) {
        this.min_bala = min_bala;
    }

    public String getMax_bala() {
        return max_bala;
    }

    public void setMax_bala(String max_bala) {
        this.max_bala = max_bala;
    }

    public String getMin_fare_ratio() {
        return min_fare_ratio;
    }

    public void setMin_fare_ratio(String min_fare_ratio) {
        this.min_fare_ratio = min_fare_ratio;
    }

    @Override
    public int compareTo(FundDiscountSetting o) {
        BigDecimal before = new BigDecimal(this.min_bala);
        BigDecimal after = new BigDecimal(o.getMin_bala());

        return before.compareTo(after);
    }

}
