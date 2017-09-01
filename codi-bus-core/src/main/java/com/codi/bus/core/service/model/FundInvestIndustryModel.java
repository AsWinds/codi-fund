package com.codi.bus.core.service.model;

import com.codi.base.domain.BaseDomain;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月25日 下午4:42:22
 */
public class FundInvestIndustryModel extends BaseDomain {

    private static final long serialVersionUID = 1L;
    private String industryName;
    private String ratioInNV;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getRatioInNV() {
        return ratioInNV;
    }

    public void setRatioInNV(String ratioInNV) {
        this.ratioInNV = ratioInNV;
    }
}
