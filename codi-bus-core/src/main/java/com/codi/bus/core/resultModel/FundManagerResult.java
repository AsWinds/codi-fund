package com.codi.bus.core.resultModel;

import java.util.Date;
import java.util.List;

import com.codi.bus.core.service.model.FundManagerPerformanceModel;

/**
 * 基金经理信息
 * 
 * @author shi.pengyan
 * @date 2016年10月9日 下午2:54:30
 */
public class FundManagerResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String name;
    private int gender;
    private Date birthDate;
    private int education;// 最高学历
    private Date practiceDate;
    private String experienceTime;// 证券从业经历
    private String proQualifi;// 从业资格
    private String background;// 背景资料

    private List<FundManagerPerformanceModel> performance; // 基金经理的业绩

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public Date getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(Date practiceDate) {
        this.practiceDate = practiceDate;
    }

    public String getExperienceTime() {
        return experienceTime;
    }

    public void setExperienceTime(String experienceTime) {
        this.experienceTime = experienceTime;
    }

    public String getProQualifi() {
        return proQualifi;
    }

    public void setProQualifi(String proQualifi) {
        this.proQualifi = proQualifi;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<FundManagerPerformanceModel> getPerformance() {
        return performance;
    }

    public void setPerformance(List<FundManagerPerformanceModel> performance) {
        this.performance = performance;
    }

}
