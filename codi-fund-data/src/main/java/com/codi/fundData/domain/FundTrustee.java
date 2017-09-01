package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金托管人
 * 
 * @author shi.pengyan
 * @date 2016年10月10日 下午1:39:09
 */
public class FundTrustee {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.ID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.TrusteeCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private Integer trusteeCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.TrusteeName
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String trusteeName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.LegalRepr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String legalRepr;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.TrusteeFunctionary
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String trusteeFunctionary;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.LinkMan
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String linkMan;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.EstablishmentDate
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private Date establishmentDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.OrganizationForm
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String organizationForm;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.RegCapital
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private BigDecimal regCapital;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.RegAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String regAddr;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.OfficeAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String officeAddr;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.ZipCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String zipCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.WebSite
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String webSite;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.Email
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.ContactAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String contactAddr;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.Tel
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.Fax
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String fax;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private Date XGRQ;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.JSID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_TrusteeOutline.Background
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    private String background;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.ID
     *
     * @return the value of MF_TrusteeOutline.ID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.ID
     *
     * @param ID
     *            the value for MF_TrusteeOutline.ID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.TrusteeCode
     *
     * @return the value of MF_TrusteeOutline.TrusteeCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public Integer getTrusteeCode() {
        return trusteeCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.TrusteeCode
     *
     * @param trusteeCode
     *            the value for MF_TrusteeOutline.TrusteeCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setTrusteeCode(Integer trusteeCode) {
        this.trusteeCode = trusteeCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.TrusteeName
     *
     * @return the value of MF_TrusteeOutline.TrusteeName
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getTrusteeName() {
        return trusteeName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.TrusteeName
     *
     * @param trusteeName
     *            the value for MF_TrusteeOutline.TrusteeName
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setTrusteeName(String trusteeName) {
        this.trusteeName = trusteeName == null ? null : trusteeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.LegalRepr
     *
     * @return the value of MF_TrusteeOutline.LegalRepr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getLegalRepr() {
        return legalRepr;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.LegalRepr
     *
     * @param legalRepr
     *            the value for MF_TrusteeOutline.LegalRepr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setLegalRepr(String legalRepr) {
        this.legalRepr = legalRepr == null ? null : legalRepr.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.TrusteeFunctionary
     *
     * @return the value of MF_TrusteeOutline.TrusteeFunctionary
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getTrusteeFunctionary() {
        return trusteeFunctionary;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.TrusteeFunctionary
     *
     * @param trusteeFunctionary
     *            the value for MF_TrusteeOutline.TrusteeFunctionary
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setTrusteeFunctionary(String trusteeFunctionary) {
        this.trusteeFunctionary = trusteeFunctionary == null ? null : trusteeFunctionary.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.LinkMan
     *
     * @return the value of MF_TrusteeOutline.LinkMan
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.LinkMan
     *
     * @param linkMan
     *            the value for MF_TrusteeOutline.LinkMan
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.EstablishmentDate
     *
     * @return the value of MF_TrusteeOutline.EstablishmentDate
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.EstablishmentDate
     *
     * @param establishmentDate
     *            the value for MF_TrusteeOutline.EstablishmentDate
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.OrganizationForm
     *
     * @return the value of MF_TrusteeOutline.OrganizationForm
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getOrganizationForm() {
        return organizationForm;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.OrganizationForm
     *
     * @param organizationForm
     *            the value for MF_TrusteeOutline.OrganizationForm
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm == null ? null : organizationForm.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.RegCapital
     *
     * @return the value of MF_TrusteeOutline.RegCapital
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public BigDecimal getRegCapital() {
        return regCapital;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.RegCapital
     *
     * @param regCapital
     *            the value for MF_TrusteeOutline.RegCapital
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setRegCapital(BigDecimal regCapital) {
        this.regCapital = regCapital;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.RegAddr
     *
     * @return the value of MF_TrusteeOutline.RegAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.RegAddr
     *
     * @param regAddr
     *            the value for MF_TrusteeOutline.RegAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr == null ? null : regAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.OfficeAddr
     *
     * @return the value of MF_TrusteeOutline.OfficeAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getOfficeAddr() {
        return officeAddr;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.OfficeAddr
     *
     * @param officeAddr
     *            the value for MF_TrusteeOutline.OfficeAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr == null ? null : officeAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.ZipCode
     *
     * @return the value of MF_TrusteeOutline.ZipCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.ZipCode
     *
     * @param zipCode
     *            the value for MF_TrusteeOutline.ZipCode
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.WebSite
     *
     * @return the value of MF_TrusteeOutline.WebSite
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.WebSite
     *
     * @param webSite
     *            the value for MF_TrusteeOutline.WebSite
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.Email
     *
     * @return the value of MF_TrusteeOutline.Email
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.Email
     *
     * @param email
     *            the value for MF_TrusteeOutline.Email
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.ContactAddr
     *
     * @return the value of MF_TrusteeOutline.ContactAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getContactAddr() {
        return contactAddr;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.ContactAddr
     *
     * @param contactAddr
     *            the value for MF_TrusteeOutline.ContactAddr
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr == null ? null : contactAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.Tel
     *
     * @return the value of MF_TrusteeOutline.Tel
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.Tel
     *
     * @param tel
     *            the value for MF_TrusteeOutline.Tel
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.Fax
     *
     * @return the value of MF_TrusteeOutline.Fax
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.Fax
     *
     * @param fax
     *            the value for MF_TrusteeOutline.Fax
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.XGRQ
     *
     * @return the value of MF_TrusteeOutline.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public Date getXGRQ() {
        return XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.XGRQ
     *
     * @param XGRQ
     *            the value for MF_TrusteeOutline.XGRQ
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setXGRQ(Date XGRQ) {
        this.XGRQ = XGRQ;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.JSID
     *
     * @return the value of MF_TrusteeOutline.JSID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.JSID
     *
     * @param JSID
     *            the value for MF_TrusteeOutline.JSID
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_TrusteeOutline.Background
     *
     * @return the value of MF_TrusteeOutline.Background
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public String getBackground() {
        return background;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_TrusteeOutline.Background
     *
     * @param background
     *            the value for MF_TrusteeOutline.Background
     *
     * @mbggenerated Mon Oct 10 13:38:26 CST 2016
     */
    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }
}