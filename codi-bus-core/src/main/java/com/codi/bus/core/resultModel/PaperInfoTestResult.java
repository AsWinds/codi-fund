package com.codi.bus.core.resultModel;

import org.apache.commons.lang.StringUtils;

public class PaperInfoTestResult extends BaseResult {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String success_type;
    private String paper_id;
    private String client_id;
    private String cust_type;
    private String full_name;
    private String id_kind_gb;
    private String id_no;
    private String paper_score;
    private String invest_risk_tolerance;
    private String invest_risk_tolerance_desc;
    private String invest_risk_tolerance_detail;
    private String update_date;

    private String expire_date; // 风险测评过期时间 shi.pengyan  2017-6-21 15:36:14

    private String elig_content;
    private boolean have_tested = false;

    public PaperInfoTestResult() {
        this.setSuccess(Boolean.TRUE);
    }

    public String getSuccess_type() {
        return success_type;
    }

    public void setSuccess_type(String success_type) {
        this.success_type = success_type;
    }

    public String getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(String paper_id) {
        this.paper_id = paper_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId_kind_gb() {
        return id_kind_gb;
    }

    public void setId_kind_gb(String id_kind_gb) {
        this.id_kind_gb = id_kind_gb;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getPaper_score() {
        return paper_score;
    }

    public void setPaper_score(String paper_score) {
        this.paper_score = paper_score;
    }

    public String getInvest_risk_tolerance() {
        return invest_risk_tolerance;
    }

    public void setInvest_risk_tolerance(String invest_risk_tolerance) {
        if (StringUtils.isBlank(invest_risk_tolerance)) {
            invest_risk_tolerance = "1";
        }
        int risk_tolerance = Integer.parseInt(invest_risk_tolerance);
        switch (risk_tolerance) {
            case 1:
                this.invest_risk_tolerance_desc = "保守型";
                this.invest_risk_tolerance_detail = "风险承受能力低，对收益要求不高，追求资本金绝对安全。预期报酬率优于中长期存款利率，并确保本金在通货膨胀中发挥保值功能。";
                break;

            case 2:
                this.invest_risk_tolerance_desc = "稳健型";
                this.invest_risk_tolerance_detail = "风险承受能力较低，以获得相对稳定的投资收益为目标，能够承受较低的投资风险，同时，对资产收益要求高于保守型投资者。";
                break;

            case 3:
                this.invest_risk_tolerance_desc = "平衡型";
                this.invest_risk_tolerance_detail = "风险承受能力适中，偏向于资产均衡配置，能够承受一定的投资风险，同时，对资产收益要求高于保守型、稳健型投资者。";
                break;
            case 4:
                this.invest_risk_tolerance_desc = "成长型";
                this.invest_risk_tolerance_detail = "风险承受能力较高，以获得中高收益水平为目标，能够承受较高的投资风险，同时，对资产收益要求高于保守型、稳健型、成长型投资者。";
                break;

            case 5:
                this.invest_risk_tolerance_desc = "进取型";
                this.invest_risk_tolerance_detail = "对风险有非常高的承受能力，资产配置以投资高风险投资品种为主，投机性强，利用市场波动赢取差价，追求在较短周期内的收益最大化。";
                break;

            default:
                throw new RuntimeException("Unknown invest_risk_tolerance : " + invest_risk_tolerance);
        }
        this.invest_risk_tolerance = invest_risk_tolerance;
    }

    public String getInvest_risk_tolerance_desc() {
        return invest_risk_tolerance_desc;
    }

    public String getInvest_risk_tolerance_detail() {
        return invest_risk_tolerance_detail;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getElig_content() {
        return elig_content;
    }

    public void setElig_content(String elig_content) {
        this.elig_content = elig_content;
    }

    public boolean isHave_tested() {
        return have_tested;
    }

    public void setHave_tested(boolean have_tested) {
        this.have_tested = have_tested;
    }

}
