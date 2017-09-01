package com.codi.crawler.core.domain;

import com.codi.base.domain.BaseDomain;
import java.util.Date;

/**
 * 亲，写个类注释呗
 * @author wangzhenhao
 * @date 2017-05-22 11:21
 */
public class CrawlerLookup extends BaseDomain {
    private String ruleLuType;

    private String ruleLuValue;

    private String ruleLuText;

    private Integer ruleLuStatus;

    private Boolean ruleLuValid;

    private String ruleCreateUserId;

    private Date ruleLuCreateDate;

    private String ruleLuLastUpdatedUserId;

    private Date ruleLuLastUpdatedDate;

    private String ruleLuComponentValue;

    private static final long serialVersionUID = 1L;

    public String getRuleLuText() {
        return ruleLuText;
    }

    public void setRuleLuText(String ruleLuText) {
        this.ruleLuText = ruleLuText == null ? null : ruleLuText.trim();
    }

    public Integer getRuleLuStatus() {
        return ruleLuStatus;
    }

    public void setRuleLuStatus(Integer ruleLuStatus) {
        this.ruleLuStatus = ruleLuStatus;
    }

    public Boolean getRuleLuValid() {
        return ruleLuValid;
    }

    public void setRuleLuValid(Boolean ruleLuValid) {
        this.ruleLuValid = ruleLuValid;
    }

    public String getRuleCreateUserId() {
        return ruleCreateUserId;
    }

    public void setRuleCreateUserId(String ruleCreateUserId) {
        this.ruleCreateUserId = ruleCreateUserId == null ? null : ruleCreateUserId.trim();
    }

    public Date getRuleLuCreateDate() {
        return ruleLuCreateDate;
    }

    public void setRuleLuCreateDate(Date ruleLuCreateDate) {
        this.ruleLuCreateDate = ruleLuCreateDate;
    }

    public String getRuleLuLastUpdatedUserId() {
        return ruleLuLastUpdatedUserId;
    }

    public void setRuleLuLastUpdatedUserId(String ruleLuLastUpdatedUserId) {
        this.ruleLuLastUpdatedUserId = ruleLuLastUpdatedUserId == null ? null : ruleLuLastUpdatedUserId.trim();
    }

    public Date getRuleLuLastUpdatedDate() {
        return ruleLuLastUpdatedDate;
    }

    public void setRuleLuLastUpdatedDate(Date ruleLuLastUpdatedDate) {
        this.ruleLuLastUpdatedDate = ruleLuLastUpdatedDate;
    }

    public String getRuleLuComponentValue() {
        return ruleLuComponentValue;
    }

    public void setRuleLuComponentValue(String ruleLuComponentValue) {
        this.ruleLuComponentValue = ruleLuComponentValue == null ? null : ruleLuComponentValue.trim();
    }

    public String getRuleLuType() {
        return ruleLuType;
    }

    public void setRuleLuType(String ruleLuType) {
        this.ruleLuType = ruleLuType;
    }

    public String getRuleLuValue() {
        return ruleLuValue;
    }

    public void setRuleLuValue(String ruleLuValue) {
        this.ruleLuValue = ruleLuValue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
