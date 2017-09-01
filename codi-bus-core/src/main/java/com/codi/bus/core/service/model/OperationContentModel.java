package com.codi.bus.core.service.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.codi.bus.core.domain.OperationContent;

/**
 * 
 * @author song-jj
 */
public class OperationContentModel extends OperationContent {
    
    /**
     * 收益率
     */
    private BigDecimal rate;

    /**
     * 标签列表
     */
    private List<String> tags;
    
    /**
     * 额外的信息：基金类型，基金名称等
     */
    private Map<String, Object> extraInfo;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, Object> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public BigDecimal getRate() {
        if (rate == null) {
            rate = BigDecimal.ZERO;
        }
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
