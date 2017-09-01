package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金管理人概括
 * 
 * @author shi.pengyan
 * @date 2016年9月23日 下午7:41:08
 */
public class FundInvestAdvisorOutline extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.ID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.InvestAdvisorCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Integer investAdvisorCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.InvestAdvisorName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String investAdvisorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.InvestAdvisorAbbrName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String investAdvisorAbbrName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.LegalRepr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String legalRepr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.GeneralManager
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String generalManager;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.EstablishmentDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Date establishmentDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.OrganizationForm
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String organizationForm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.RegCapital
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private BigDecimal regCapital;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.RegAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String regAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.OfficeAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String officeAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.ZipCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String zipCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.Email
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.ContactAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String contactAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.Tel
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.Fax
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String fax;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.WebSite
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String webSite;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.LinkMan
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String linkMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.Region
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Integer region;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.XGRQ
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Date XGRQ;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.JSID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.ServiceLine
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String serviceLine;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.MaturityEndDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private Date maturityEndDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.TACode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String TACode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.CSRCCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String CSRCCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MF_InvestAdvisorOutline.Background
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    private String background;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.ID
     *
     * @return the value of MF_InvestAdvisorOutline.ID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.ID
     *
     * @param ID the value for MF_InvestAdvisorOutline.ID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.InvestAdvisorCode
     *
     * @return the value of MF_InvestAdvisorOutline.InvestAdvisorCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Integer getInvestAdvisorCode() {
        return investAdvisorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.InvestAdvisorCode
     *
     * @param investAdvisorCode the value for MF_InvestAdvisorOutline.InvestAdvisorCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setInvestAdvisorCode(Integer investAdvisorCode) {
        this.investAdvisorCode = investAdvisorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.InvestAdvisorName
     *
     * @return the value of MF_InvestAdvisorOutline.InvestAdvisorName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getInvestAdvisorName() {
        return investAdvisorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.InvestAdvisorName
     *
     * @param investAdvisorName the value for MF_InvestAdvisorOutline.InvestAdvisorName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setInvestAdvisorName(String investAdvisorName) {
        this.investAdvisorName = investAdvisorName == null ? null : investAdvisorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.InvestAdvisorAbbrName
     *
     * @return the value of MF_InvestAdvisorOutline.InvestAdvisorAbbrName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getInvestAdvisorAbbrName() {
        return investAdvisorAbbrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.InvestAdvisorAbbrName
     *
     * @param investAdvisorAbbrName the value for MF_InvestAdvisorOutline.InvestAdvisorAbbrName
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setInvestAdvisorAbbrName(String investAdvisorAbbrName) {
        this.investAdvisorAbbrName = investAdvisorAbbrName == null ? null : investAdvisorAbbrName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.LegalRepr
     *
     * @return the value of MF_InvestAdvisorOutline.LegalRepr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getLegalRepr() {
        return legalRepr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.LegalRepr
     *
     * @param legalRepr the value for MF_InvestAdvisorOutline.LegalRepr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setLegalRepr(String legalRepr) {
        this.legalRepr = legalRepr == null ? null : legalRepr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.GeneralManager
     *
     * @return the value of MF_InvestAdvisorOutline.GeneralManager
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getGeneralManager() {
        return generalManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.GeneralManager
     *
     * @param generalManager the value for MF_InvestAdvisorOutline.GeneralManager
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager == null ? null : generalManager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.EstablishmentDate
     *
     * @return the value of MF_InvestAdvisorOutline.EstablishmentDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.EstablishmentDate
     *
     * @param establishmentDate the value for MF_InvestAdvisorOutline.EstablishmentDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.OrganizationForm
     *
     * @return the value of MF_InvestAdvisorOutline.OrganizationForm
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getOrganizationForm() {
        return organizationForm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.OrganizationForm
     *
     * @param organizationForm the value for MF_InvestAdvisorOutline.OrganizationForm
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm == null ? null : organizationForm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.RegCapital
     *
     * @return the value of MF_InvestAdvisorOutline.RegCapital
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public BigDecimal getRegCapital() {
        return regCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.RegCapital
     *
     * @param regCapital the value for MF_InvestAdvisorOutline.RegCapital
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setRegCapital(BigDecimal regCapital) {
        this.regCapital = regCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.RegAddr
     *
     * @return the value of MF_InvestAdvisorOutline.RegAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.RegAddr
     *
     * @param regAddr the value for MF_InvestAdvisorOutline.RegAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr == null ? null : regAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.OfficeAddr
     *
     * @return the value of MF_InvestAdvisorOutline.OfficeAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getOfficeAddr() {
        return officeAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.OfficeAddr
     *
     * @param officeAddr the value for MF_InvestAdvisorOutline.OfficeAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr == null ? null : officeAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.ZipCode
     *
     * @return the value of MF_InvestAdvisorOutline.ZipCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.ZipCode
     *
     * @param zipCode the value for MF_InvestAdvisorOutline.ZipCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.Email
     *
     * @return the value of MF_InvestAdvisorOutline.Email
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.Email
     *
     * @param email the value for MF_InvestAdvisorOutline.Email
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.ContactAddr
     *
     * @return the value of MF_InvestAdvisorOutline.ContactAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getContactAddr() {
        return contactAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.ContactAddr
     *
     * @param contactAddr the value for MF_InvestAdvisorOutline.ContactAddr
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr == null ? null : contactAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.Tel
     *
     * @return the value of MF_InvestAdvisorOutline.Tel
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.Tel
     *
     * @param tel the value for MF_InvestAdvisorOutline.Tel
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.Fax
     *
     * @return the value of MF_InvestAdvisorOutline.Fax
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.Fax
     *
     * @param fax the value for MF_InvestAdvisorOutline.Fax
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.WebSite
     *
     * @return the value of MF_InvestAdvisorOutline.WebSite
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.WebSite
     *
     * @param webSite the value for MF_InvestAdvisorOutline.WebSite
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.LinkMan
     *
     * @return the value of MF_InvestAdvisorOutline.LinkMan
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.LinkMan
     *
     * @param linkMan the value for MF_InvestAdvisorOutline.LinkMan
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.Region
     *
     * @return the value of MF_InvestAdvisorOutline.Region
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Integer getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.Region
     *
     * @param region the value for MF_InvestAdvisorOutline.Region
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setRegion(Integer region) {
        this.region = region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.XGRQ
     *
     * @return the value of MF_InvestAdvisorOutline.XGRQ
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Date getXGRQ() {
        return XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.XGRQ
     *
     * @param XGRQ the value for MF_InvestAdvisorOutline.XGRQ
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setXGRQ(Date XGRQ) {
        this.XGRQ = XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.JSID
     *
     * @return the value of MF_InvestAdvisorOutline.JSID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.JSID
     *
     * @param JSID the value for MF_InvestAdvisorOutline.JSID
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.ServiceLine
     *
     * @return the value of MF_InvestAdvisorOutline.ServiceLine
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getServiceLine() {
        return serviceLine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.ServiceLine
     *
     * @param serviceLine the value for MF_InvestAdvisorOutline.ServiceLine
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setServiceLine(String serviceLine) {
        this.serviceLine = serviceLine == null ? null : serviceLine.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.MaturityEndDate
     *
     * @return the value of MF_InvestAdvisorOutline.MaturityEndDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public Date getMaturityEndDate() {
        return maturityEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.MaturityEndDate
     *
     * @param maturityEndDate the value for MF_InvestAdvisorOutline.MaturityEndDate
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setMaturityEndDate(Date maturityEndDate) {
        this.maturityEndDate = maturityEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.TACode
     *
     * @return the value of MF_InvestAdvisorOutline.TACode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getTACode() {
        return TACode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.TACode
     *
     * @param TACode the value for MF_InvestAdvisorOutline.TACode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setTACode(String TACode) {
        this.TACode = TACode == null ? null : TACode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.CSRCCode
     *
     * @return the value of MF_InvestAdvisorOutline.CSRCCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getCSRCCode() {
        return CSRCCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.CSRCCode
     *
     * @param CSRCCode the value for MF_InvestAdvisorOutline.CSRCCode
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setCSRCCode(String CSRCCode) {
        this.CSRCCode = CSRCCode == null ? null : CSRCCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MF_InvestAdvisorOutline.Background
     *
     * @return the value of MF_InvestAdvisorOutline.Background
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public String getBackground() {
        return background;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MF_InvestAdvisorOutline.Background
     *
     * @param background the value for MF_InvestAdvisorOutline.Background
     *
     * @mbggenerated Fri Sep 23 19:39:16 CST 2016
     */
    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }
}