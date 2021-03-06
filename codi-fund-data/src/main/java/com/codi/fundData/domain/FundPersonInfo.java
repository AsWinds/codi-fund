package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * 基金从业人员表
 * 
 * @author shi.pengyan
 * @date 2016年10月17日 上午9:56:22
 */
public class FundPersonInfo extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.ID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Long ID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.PersonalCode
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Long personalCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.ChineseName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String chineseName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.OtherName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String otherName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.EnglishName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String englishName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.Gender
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Integer gender;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.Nationality
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Integer nationality;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.BirthDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Date birthDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.BirthYMInfo
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String birthYMInfo;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.Education
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Integer education;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.IDCardNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String IDCardNum;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.PassportNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String passportNum;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.PracticeDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Date practiceDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.ExperienceTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private BigDecimal experienceTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.ProQualifi
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String proQualifi;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.FileType
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Integer fileType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.UpdateTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.JSID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private Long JSID;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.Background
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private String background;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_PersonalInfo.PersonalData
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    private byte[] personalData;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.Background
     *
     * @return the value of MF_PersonalInfo.Background
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getBackground() {
        return background;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.Background
     *
     * @param background
     *            the value for MF_PersonalInfo.Background
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.PersonalData
     *
     * @return the value of MF_PersonalInfo.PersonalData
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public byte[] getPersonalData() {
        return personalData;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.PersonalData
     *
     * @param personalData
     *            the value for MF_PersonalInfo.PersonalData
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setPersonalData(byte[] personalData) {
        this.personalData = personalData;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.ID
     *
     * @return the value of MF_PersonalInfo.ID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Long getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.ID
     *
     * @param ID
     *            the value for MF_PersonalInfo.ID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.PersonalCode
     *
     * @return the value of MF_PersonalInfo.PersonalCode
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Long getPersonalCode() {
        return personalCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.PersonalCode
     *
     * @param personalCode
     *            the value for MF_PersonalInfo.PersonalCode
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.ChineseName
     *
     * @return the value of MF_PersonalInfo.ChineseName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.ChineseName
     *
     * @param chineseName
     *            the value for MF_PersonalInfo.ChineseName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.OtherName
     *
     * @return the value of MF_PersonalInfo.OtherName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.OtherName
     *
     * @param otherName
     *            the value for MF_PersonalInfo.OtherName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName == null ? null : otherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.EnglishName
     *
     * @return the value of MF_PersonalInfo.EnglishName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.EnglishName
     *
     * @param englishName
     *            the value for MF_PersonalInfo.EnglishName
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.Gender
     *
     * @return the value of MF_PersonalInfo.Gender
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.Gender
     *
     * @param gender
     *            the value for MF_PersonalInfo.Gender
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.Nationality
     *
     * @return the value of MF_PersonalInfo.Nationality
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Integer getNationality() {
        return nationality;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.Nationality
     *
     * @param nationality
     *            the value for MF_PersonalInfo.Nationality
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setNationality(Integer nationality) {
        this.nationality = nationality;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.BirthDate
     *
     * @return the value of MF_PersonalInfo.BirthDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.BirthDate
     *
     * @param birthDate
     *            the value for MF_PersonalInfo.BirthDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.BirthYMInfo
     *
     * @return the value of MF_PersonalInfo.BirthYMInfo
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getBirthYMInfo() {
        return birthYMInfo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.BirthYMInfo
     *
     * @param birthYMInfo
     *            the value for MF_PersonalInfo.BirthYMInfo
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setBirthYMInfo(String birthYMInfo) {
        this.birthYMInfo = birthYMInfo == null ? null : birthYMInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.Education
     *
     * @return the value of MF_PersonalInfo.Education
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Integer getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.Education
     *
     * @param education
     *            the value for MF_PersonalInfo.Education
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.IDCardNum
     *
     * @return the value of MF_PersonalInfo.IDCardNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getIDCardNum() {
        return IDCardNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.IDCardNum
     *
     * @param IDCardNum
     *            the value for MF_PersonalInfo.IDCardNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setIDCardNum(String IDCardNum) {
        this.IDCardNum = IDCardNum == null ? null : IDCardNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.PassportNum
     *
     * @return the value of MF_PersonalInfo.PassportNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getPassportNum() {
        return passportNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.PassportNum
     *
     * @param passportNum
     *            the value for MF_PersonalInfo.PassportNum
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum == null ? null : passportNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.PracticeDate
     *
     * @return the value of MF_PersonalInfo.PracticeDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Date getPracticeDate() {
        return practiceDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.PracticeDate
     *
     * @param practiceDate
     *            the value for MF_PersonalInfo.PracticeDate
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setPracticeDate(Date practiceDate) {
        this.practiceDate = practiceDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.ExperienceTime
     *
     * @return the value of MF_PersonalInfo.ExperienceTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public BigDecimal getExperienceTime() {
        return experienceTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.ExperienceTime
     *
     * @param experienceTime
     *            the value for MF_PersonalInfo.ExperienceTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setExperienceTime(BigDecimal experienceTime) {
        this.experienceTime = experienceTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.ProQualifi
     *
     * @return the value of MF_PersonalInfo.ProQualifi
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public String getProQualifi() {
        return proQualifi;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.ProQualifi
     *
     * @param proQualifi
     *            the value for MF_PersonalInfo.ProQualifi
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setProQualifi(String proQualifi) {
        this.proQualifi = proQualifi == null ? null : proQualifi.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.FileType
     *
     * @return the value of MF_PersonalInfo.FileType
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Integer getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.FileType
     *
     * @param fileType
     *            the value for MF_PersonalInfo.FileType
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.UpdateTime
     *
     * @return the value of MF_PersonalInfo.UpdateTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.UpdateTime
     *
     * @param updateTime
     *            the value for MF_PersonalInfo.UpdateTime
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column MF_PersonalInfo.JSID
     *
     * @return the value of MF_PersonalInfo.JSID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public Long getJSID() {
        return JSID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column MF_PersonalInfo.JSID
     *
     * @param JSID
     *            the value for MF_PersonalInfo.JSID
     *
     * @mbggenerated Mon Oct 17 09:46:51 CST 2016
     */
    public void setJSID(Long JSID) {
        this.JSID = JSID;
    }
}