package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

public class FundManager extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.ID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.InnerCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Integer innerCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.InfoPublDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Date infoPublDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.InfoSource
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private String infoSource;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.PersonalCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Long personalCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.Name
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.PostName
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Integer postName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.Incumbent
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Byte incumbent;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.AccessionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Date accessionDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.DimissionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Date dimissionDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.ManagementTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Integer managementTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.Performance
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private BigDecimal performance;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.Notes
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private String notes;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.UpdateTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundManagerNew.JSID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    private Long JSID;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.ID
     *
     * @return the value of MF_FundManagerNew.ID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.ID
     *
     * @param ID
     *            the value for MF_FundManagerNew.ID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.InnerCode
     *
     * @return the value of MF_FundManagerNew.InnerCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Integer getInnerCode() {
        return innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.InnerCode
     *
     * @param innerCode
     *            the value for MF_FundManagerNew.InnerCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.InfoPublDate
     *
     * @return the value of MF_FundManagerNew.InfoPublDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Date getInfoPublDate() {
        return infoPublDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.InfoPublDate
     *
     * @param infoPublDate
     *            the value for MF_FundManagerNew.InfoPublDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setInfoPublDate(Date infoPublDate) {
        this.infoPublDate = infoPublDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.InfoSource
     *
     * @return the value of MF_FundManagerNew.InfoSource
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public String getInfoSource() {
        return infoSource;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.InfoSource
     *
     * @param infoSource
     *            the value for MF_FundManagerNew.InfoSource
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource == null ? null : infoSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.PersonalCode
     *
     * @return the value of MF_FundManagerNew.PersonalCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Long getPersonalCode() {
        return personalCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.PersonalCode
     *
     * @param personalCode
     *            the value for MF_FundManagerNew.PersonalCode
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.Name
     *
     * @return the value of MF_FundManagerNew.Name
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.Name
     *
     * @param name
     *            the value for MF_FundManagerNew.Name
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.PostName
     *
     * @return the value of MF_FundManagerNew.PostName
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Integer getPostName() {
        return postName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.PostName
     *
     * @param postName
     *            the value for MF_FundManagerNew.PostName
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setPostName(Integer postName) {
        this.postName = postName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.Incumbent
     *
     * @return the value of MF_FundManagerNew.Incumbent
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Byte getIncumbent() {
        return incumbent;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.Incumbent
     *
     * @param incumbent
     *            the value for MF_FundManagerNew.Incumbent
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setIncumbent(Byte incumbent) {
        this.incumbent = incumbent;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.AccessionDate
     *
     * @return the value of MF_FundManagerNew.AccessionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Date getAccessionDate() {
        return accessionDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.AccessionDate
     *
     * @param accessionDate
     *            the value for MF_FundManagerNew.AccessionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setAccessionDate(Date accessionDate) {
        this.accessionDate = accessionDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.DimissionDate
     *
     * @return the value of MF_FundManagerNew.DimissionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Date getDimissionDate() {
        return dimissionDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.DimissionDate
     *
     * @param dimissionDate
     *            the value for MF_FundManagerNew.DimissionDate
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.ManagementTime
     *
     * @return the value of MF_FundManagerNew.ManagementTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Integer getManagementTime() {
        return managementTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.ManagementTime
     *
     * @param managementTime
     *            the value for MF_FundManagerNew.ManagementTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setManagementTime(Integer managementTime) {
        this.managementTime = managementTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.Performance
     *
     * @return the value of MF_FundManagerNew.Performance
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public BigDecimal getPerformance() {
        return performance;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.Performance
     *
     * @param performance
     *            the value for MF_FundManagerNew.Performance
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.Notes
     *
     * @return the value of MF_FundManagerNew.Notes
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public String getNotes() {
        return notes;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.Notes
     *
     * @param notes
     *            the value for MF_FundManagerNew.Notes
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.UpdateTime
     *
     * @return the value of MF_FundManagerNew.UpdateTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.UpdateTime
     *
     * @param updateTime
     *            the value for MF_FundManagerNew.UpdateTime
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_FundManagerNew.JSID
     *
     * @return the value of MF_FundManagerNew.JSID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_FundManagerNew.JSID
     *
     * @param JSID
     *            the value for MF_FundManagerNew.JSID
     *
     * @mbggenerated Sun Oct 09 10:53:53 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }
}