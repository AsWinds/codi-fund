package com.codi.fundData.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.codi.base.domain.BaseDomain;

/**
 * MF_FundArchives
 * 
 * @author shi.pengyan
 * @date 2016年11月21日 下午4:04:51
 */
public class FundDetail extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     */
    private Long id;

    /** 
     */
    private Integer innerCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.EstablishmentDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date establishmentDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ListedDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date listedDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.Duration
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal duration;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.StartDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date startDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ExpireDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date expireDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.Manager
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String manager;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestAdvisorCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer investAdvisorCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.TrusteeCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer trusteeCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.Warrantor
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String warrantor;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.Type
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestmentType
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer investmentType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestStyle
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer investStyle;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.FoundedSize
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal foundedSize;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestOrientation
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String investOrientation;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestTarget
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String investTarget;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.PerformanceBenchMark
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String performanceBenchMark;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ProfitDistributionRule
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String profitDistributionRule;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.InvestField
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String investField;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.XGRQ
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date xgrq;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.JSID
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Long jsid;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ApplyingCodeFront
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String applyingCodeFront;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ApplyingCodeBack
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String applyingCodeBack;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.GuaranteedPeriod
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal guaranteedPeriod;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.RiskReturncharacter
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String riskReturnCharacter;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LowestSumSubscribing
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String lowestSumSubscribing;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LowestSumRedemption
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal lowestSumRedemption;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LSFRDescription
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String lsfrDescription;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LowestSumForHolding
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal lowestSumForHolding;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LSFHDescription
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String lsfhDescription;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.FundNature
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer fundNature;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.FundTypeCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer fundTypeCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.FundType
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String fundType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.CarryOverDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer carryOverDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.CarryOverDateRemark
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String carryOverDateRemark;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.CarryOverType
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer carryOverType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.RegInstCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer regInstCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.SecurityCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String securityCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.DeliveryDays
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer deliveryDays;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.RiskReturnCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer riskReturnCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.FloatType
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer floatType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.CustodyMarket
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer custodyMarket;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.OperationPeriod
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal operationPeriod;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.OperationPDUnitCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer operationPDUnitCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.OperationPDUnitName
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String operationPDUnitName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.IfInitiatingFund
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer ifInitiatingFund;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ClassificationFundType
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer classificationFundType;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.AgrBenchmkRateOfShareA
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String agrBenchmkRateOfShareA;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.AgrBenchmkRateOfShareANotes
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String agrBenchmkRateOfShareANotes;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.RegularShareConversionNotes
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String regularShareConversionNotes;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.NonRegularShareConversionNotes
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String nonRegularShareConversionNotes;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ExApplyingMarket
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer exApplyingMarket;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ExApplyingCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String exApplyingCode;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ExApplyingAbbr
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String exApplyingAbbr;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.ShareProperties
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Integer shareProperties;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.StClearingDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date stClearingDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.EnClearingDate
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private Date enClearingDate;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LowestSumSubLL
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal lowestSumSubLL;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.LowestSumPurLL
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private BigDecimal lowestSumPurLL;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column MF_FundArchives.MainCode
     *
     * @mbggenerated Thu Sep 22 10:13:48 CST 2016
     */
    private String mainCode;

    private String briefIntro;

    private String originFundType;
    private Integer originFundTypeCode;

    public String getOriginFundType() {
        return originFundType;
    }

    public void setOriginFundType(String originFundType) {
        this.originFundType = originFundType;
    }

    public Integer getOriginFundTypeCode() {
        return originFundTypeCode;
    }

    public void setOriginFundTypeCode(Integer originFundTypeCode) {
        this.originFundTypeCode = originFundTypeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(Integer innerCode) {
        this.innerCode = innerCode;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getInvestAdvisorCode() {
        return investAdvisorCode;
    }

    public void setInvestAdvisorCode(Integer investAdvisorCode) {
        this.investAdvisorCode = investAdvisorCode;
    }

    public Integer getTrusteeCode() {
        return trusteeCode;
    }

    public void setTrusteeCode(Integer trusteeCode) {
        this.trusteeCode = trusteeCode;
    }

    public String getWarrantor() {
        return warrantor;
    }

    public void setWarrantor(String warrantor) {
        this.warrantor = warrantor;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(Integer investmentType) {
        this.investmentType = investmentType;
    }

    public Integer getInvestStyle() {
        return investStyle;
    }

    public void setInvestStyle(Integer investStyle) {
        this.investStyle = investStyle;
    }

    public BigDecimal getFoundedSize() {
        return foundedSize;
    }

    public void setFoundedSize(BigDecimal foundedSize) {
        this.foundedSize = foundedSize;
    }

    public String getInvestOrientation() {
        return investOrientation;
    }

    public void setInvestOrientation(String investOrientation) {
        this.investOrientation = investOrientation;
    }

    public String getInvestTarget() {
        return investTarget;
    }

    public void setInvestTarget(String investTarget) {
        this.investTarget = investTarget;
    }

    public String getProfitDistributionRule() {
        return profitDistributionRule;
    }

    public void setProfitDistributionRule(String profitDistributionRule) {
        this.profitDistributionRule = profitDistributionRule;
    }

    public String getInvestField() {
        return investField;
    }

    public void setInvestField(String investField) {
        this.investField = investField;
    }

    public Date getXgrq() {
        return xgrq;
    }

    public void setXgrq(Date xgrq) {
        this.xgrq = xgrq;
    }

    public Long getJsid() {
        return jsid;
    }

    public void setJsid(Long jsid) {
        this.jsid = jsid;
    }

    public String getApplyingCodeFront() {
        return applyingCodeFront;
    }

    public void setApplyingCodeFront(String applyingCodeFront) {
        this.applyingCodeFront = applyingCodeFront;
    }

    public String getApplyingCodeBack() {
        return applyingCodeBack;
    }

    public void setApplyingCodeBack(String applyingCodeBack) {
        this.applyingCodeBack = applyingCodeBack;
    }

    public BigDecimal getGuaranteedPeriod() {
        return guaranteedPeriod;
    }

    public void setGuaranteedPeriod(BigDecimal guaranteedPeriod) {
        this.guaranteedPeriod = guaranteedPeriod;
    }

    public String getRiskReturnCharacter() {
        return riskReturnCharacter;
    }

    public void setRiskReturnCharacter(String riskReturnCharacter) {
        this.riskReturnCharacter = riskReturnCharacter;
    }

    public String getLowestSumSubscribing() {
        return lowestSumSubscribing;
    }

    public void setLowestSumSubscribing(String lowestSumSubscribing) {
        this.lowestSumSubscribing = lowestSumSubscribing;
    }

    public BigDecimal getLowestSumRedemption() {
        return lowestSumRedemption;
    }

    public void setLowestSumRedemption(BigDecimal lowestSumRedemption) {
        this.lowestSumRedemption = lowestSumRedemption;
    }

    public String getLsfrDescription() {
        return lsfrDescription;
    }

    public void setLsfrDescription(String lsfrDescription) {
        this.lsfrDescription = lsfrDescription;
    }

    public BigDecimal getLowestSumForHolding() {
        return lowestSumForHolding;
    }

    public void setLowestSumForHolding(BigDecimal lowestSumForHolding) {
        this.lowestSumForHolding = lowestSumForHolding;
    }

    public String getLsfhDescription() {
        return lsfhDescription;
    }

    public void setLsfhDescription(String lsfhDescription) {
        this.lsfhDescription = lsfhDescription;
    }

    public Integer getFundNature() {
        return fundNature;
    }

    public void setFundNature(Integer fundNature) {
        this.fundNature = fundNature;
    }

    public Integer getFundTypeCode() {
        return fundTypeCode;
    }

    public void setFundTypeCode(Integer fundTypeCode) {
        this.fundTypeCode = fundTypeCode;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public Integer getCarryOverDate() {
        return carryOverDate;
    }

    public void setCarryOverDate(Integer carryOverDate) {
        this.carryOverDate = carryOverDate;
    }

    public String getCarryOverDateRemark() {
        return carryOverDateRemark;
    }

    public void setCarryOverDateRemark(String carryOverDateRemark) {
        this.carryOverDateRemark = carryOverDateRemark;
    }

    public Integer getCarryOverType() {
        return carryOverType;
    }

    public void setCarryOverType(Integer carryOverType) {
        this.carryOverType = carryOverType;
    }

    public Integer getRegInstCode() {
        return regInstCode;
    }

    public void setRegInstCode(Integer regInstCode) {
        this.regInstCode = regInstCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Integer getRiskReturnCode() {
        return riskReturnCode;
    }

    public void setRiskReturnCode(Integer riskReturnCode) {
        this.riskReturnCode = riskReturnCode;
    }

    public Integer getFloatType() {
        return floatType;
    }

    public void setFloatType(Integer floatType) {
        this.floatType = floatType;
    }

    public Integer getCustodyMarket() {
        return custodyMarket;
    }

    public void setCustodyMarket(Integer custodyMarket) {
        this.custodyMarket = custodyMarket;
    }

    public BigDecimal getOperationPeriod() {
        return operationPeriod;
    }

    public void setOperationPeriod(BigDecimal operationPeriod) {
        this.operationPeriod = operationPeriod;
    }

    public Integer getOperationPDUnitCode() {
        return operationPDUnitCode;
    }

    public void setOperationPDUnitCode(Integer operationPDUnitCode) {
        this.operationPDUnitCode = operationPDUnitCode;
    }

    public String getOperationPDUnitName() {
        return operationPDUnitName;
    }

    public void setOperationPDUnitName(String operationPDUnitName) {
        this.operationPDUnitName = operationPDUnitName;
    }

    public Integer getIfInitiatingFund() {
        return ifInitiatingFund;
    }

    public void setIfInitiatingFund(Integer ifInitiatingFund) {
        this.ifInitiatingFund = ifInitiatingFund;
    }

    public Integer getClassificationFundType() {
        return classificationFundType;
    }

    public void setClassificationFundType(Integer classificationFundType) {
        this.classificationFundType = classificationFundType;
    }

    public String getAgrBenchmkRateOfShareANotes() {
        return agrBenchmkRateOfShareANotes;
    }

    public void setAgrBenchmkRateOfShareANotes(String agrBenchmkRateOfShareANotes) {
        this.agrBenchmkRateOfShareANotes = agrBenchmkRateOfShareANotes;
    }

    public String getRegularShareConversionNotes() {
        return regularShareConversionNotes;
    }

    public void setRegularShareConversionNotes(String regularShareConversionNotes) {
        this.regularShareConversionNotes = regularShareConversionNotes;
    }

    public String getNonRegularShareConversionNotes() {
        return nonRegularShareConversionNotes;
    }

    public void setNonRegularShareConversionNotes(String nonRegularShareConversionNotes) {
        this.nonRegularShareConversionNotes = nonRegularShareConversionNotes;
    }

    public Integer getExApplyingMarket() {
        return exApplyingMarket;
    }

    public void setExApplyingMarket(Integer exApplyingMarket) {
        this.exApplyingMarket = exApplyingMarket;
    }

    public String getExApplyingCode() {
        return exApplyingCode;
    }

    public void setExApplyingCode(String exApplyingCode) {
        this.exApplyingCode = exApplyingCode;
    }

    public String getExApplyingAbbr() {
        return exApplyingAbbr;
    }

    public void setExApplyingAbbr(String exApplyingAbbr) {
        this.exApplyingAbbr = exApplyingAbbr;
    }

    public Integer getShareProperties() {
        return shareProperties;
    }

    public void setShareProperties(Integer shareProperties) {
        this.shareProperties = shareProperties;
    }

    public Date getStClearingDate() {
        return stClearingDate;
    }

    public void setStClearingDate(Date stClearingDate) {
        this.stClearingDate = stClearingDate;
    }

    public Date getEnClearingDate() {
        return enClearingDate;
    }

    public void setEnClearingDate(Date enClearingDate) {
        this.enClearingDate = enClearingDate;
    }

    public BigDecimal getLowestSumSubLL() {
        return lowestSumSubLL;
    }

    public void setLowestSumSubLL(BigDecimal lowestSumSubLL) {
        this.lowestSumSubLL = lowestSumSubLL;
    }

    public BigDecimal getLowestSumPurLL() {
        return lowestSumPurLL;
    }

    public void setLowestSumPurLL(BigDecimal lowestSumPurLL) {
        this.lowestSumPurLL = lowestSumPurLL;
    }

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public String getPerformanceBenchMark() {
        return performanceBenchMark;
    }

    public void setPerformanceBenchMark(String performanceBenchMark) {
        this.performanceBenchMark = performanceBenchMark;
    }

    public String getAgrBenchmkRateOfShareA() {
        return agrBenchmkRateOfShareA;
    }

    public void setAgrBenchmkRateOfShareA(String agrBenchmkRateOfShareA) {
        this.agrBenchmkRateOfShareA = agrBenchmkRateOfShareA;
    }

}