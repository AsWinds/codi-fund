package com.codi.bus.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.codi.base.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.codi.base.cache.CacheUtil;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.constant.CacheKeyConst;
import com.codi.bus.constant.FundConst;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.FundAnnouncementResult;
import com.codi.bus.core.resultModel.FundDetailResult;
import com.codi.bus.core.resultModel.FundDiscountSetting;
import com.codi.bus.core.resultModel.FundNetValueHistoryResult;
import com.codi.bus.core.resultModel.FundNetValueResult;
import com.codi.bus.core.resultModel.FundOverViewResult;
import com.codi.bus.core.resultModel.FundPerformanceResult;
import com.codi.bus.core.resultModel.FundRate;
import com.codi.bus.core.resultModel.WorkingDayResult;
import com.codi.bus.core.resultModel.fund.FundBaseResult;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.FundInfoService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.WorkingDateService;
import com.codi.bus.core.service.model.FundAssetAllocationModel;
import com.codi.bus.core.service.model.FundInvestIndustryModel;
import com.codi.bus.core.service.model.FundManagerModel;
import com.codi.bus.core.service.model.FundNetValueModel;
import com.codi.bus.core.service.model.FundSortModel;
import com.codi.bus.core.service.model.FundStatisticModel;
import com.codi.bus.core.service.model.NewsModel;
import com.codi.bus.core.service.util.BizUtils;
import com.codi.bus.core.service.util.FundUtil;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.FundOperation;
import com.codi.bus.util.HtmlUtil;
import com.codi.fundData.dao.FundAnnouncementDao;
import com.codi.fundData.dao.FundArchivesAttachDao;
import com.codi.fundData.dao.FundAssetAllocationDao;
import com.codi.fundData.dao.FundBondPortifolioDetailDao;
import com.codi.fundData.dao.FundDetailDao;
import com.codi.fundData.dao.FundDividendDao;
import com.codi.fundData.dao.FundInvestAdvisorOutlineDao;
import com.codi.fundData.dao.FundInvestIndustryDao;
import com.codi.fundData.dao.FundKeyStockPortfolioDao;
import com.codi.fundData.dao.FundMMYieldPerformanceDao;
import com.codi.fundData.dao.FundManagerDao;
import com.codi.fundData.dao.FundNetValueDao;
import com.codi.fundData.dao.FundNetValuePerformanceDao;
import com.codi.fundData.dao.FundPersonInfoDao;
import com.codi.fundData.dao.FundQDIIAssetAllocationDao;
import com.codi.fundData.dao.FundQDIIPortfolioDetailDao;
import com.codi.fundData.dao.FundQDIIPortfolioIndustryDao;
import com.codi.fundData.dao.FundRatingDao;
import com.codi.fundData.dao.FundSharesSplitDao;
import com.codi.fundData.dao.FundTrusteeDao;
import com.codi.fundData.dao.SecurityProductDao;
import com.codi.fundData.domain.FundAnnouncement;
import com.codi.fundData.domain.FundArchivesAttach;
import com.codi.fundData.domain.FundAssetAllocation;
import com.codi.fundData.domain.FundCodeRelationship;
import com.codi.fundData.domain.FundDetail;
import com.codi.fundData.domain.FundDividend;
import com.codi.fundData.domain.FundInvestAdvisorOutline;
import com.codi.fundData.domain.FundInvestIndustry;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.domain.FundManager;
import com.codi.fundData.domain.FundNetValue;
import com.codi.fundData.domain.FundNetValuePerformance;
import com.codi.fundData.domain.FundPersonInfo;
import com.codi.fundData.domain.FundPortifolio;
import com.codi.fundData.domain.FundQDIIAssetAllocation;
import com.codi.fundData.domain.FundQDIIPortfolioIndustry;
import com.codi.fundData.domain.FundRating;
import com.codi.fundData.domain.FundSharesSplit;
import com.codi.fundData.domain.FundTrustee;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.fundData.service.FundCodeRelationshipService;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

@Service("fundDetailService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class FundDetailServiceImpl implements FundDetailService {

    private static final Logger logger = LoggerFactory.getLogger(FundDetailService.class);

    @Resource
    private QueryService queryService;

    @Resource
    private FundInfoService fundInfoService;

    @Resource
    private FundCodeRelationshipService fundCodeRelationshipService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplateObj;

    @Resource(name = "fundDetailDao")
    private FundDetailDao fundDetailDao;

    @Resource(name = "securityProductDao")
    private SecurityProductDao securityProductDao;

    @Resource(name = "fundNetValueDao")
    private FundNetValueDao fundNetValueDao;

    @Resource(name = "fundRatingDao")
    private FundRatingDao fundRatingDao;

    @Resource(name = "fundNetValuePerformaceDao")
    private FundNetValuePerformanceDao fundNetValuePerformaceDao;

    @Resource(name = "fundMMYieldPerformanceDao")
    private FundMMYieldPerformanceDao fundMMYieldPerformanceDao;

    @Resource(name = "fundInvestAdvisorOutlineDao")
    private FundInvestAdvisorOutlineDao fundInvestAdvisorOutlineDao;

    @Resource(name = "fundAnnouncementDao")
    private FundAnnouncementDao fundAnnouncementDao;

    @Resource(name = "fundManagerDao")
    private FundManagerDao fundManagerDao;

    @Resource(name = "fundPersonInfoDao")
    private FundPersonInfoDao fundPersonInfoDao;

    @Resource(name = "fundTrusteeDao")
    private FundTrusteeDao fundTrusteeDao;

    @Resource(name = "fundAssetAllocationDao")
    private FundAssetAllocationDao fundAssetAllocationDao;

    @Resource(name = "fundDividendDao")
    private FundDividendDao fundDividendDao;

    @Resource(name = "fundSharesSplitDao")
    private FundSharesSplitDao fundSharesSplitDao;

    @Resource(name = "fundArchivesAttachDao")
    private FundArchivesAttachDao fundArchivesAttachDao;

    @Resource(name = "fundBondPortifolioDetailDao")
    private FundBondPortifolioDetailDao fundBondPortifolioDetailDao;

    @Resource(name = "fundKeyStockPortfolioDao")
    private FundKeyStockPortfolioDao fundKeyStockPortfolioDao;

    @Resource(name = "fundInvestIndustryDao")
    private FundInvestIndustryDao fundInvestIndustryDao;

    @Resource(name = "fundQDIIAssetAllocationDao")
    private FundQDIIAssetAllocationDao fundQDIIAssetAllocationDao;

    @Resource(name = "fundQDIIPortfolioDetailDao")
    private FundQDIIPortfolioDetailDao fundQDIIPortfolioDetailDao;

    @Resource(name = "fundQDIIPortfolioIndustryDao")
    private FundQDIIPortfolioIndustryDao fundQDIIPortfolioIndustryDao;

    @Resource(name = "workingDateService")
    private WorkingDateService workingDateService;

    @Override
    public SecurityProduct getSecurityProduct(String fundCode) throws BaseException {
        fundCode = fundCode.trim();
        return getProduct(fundCode);
    }

    @Override
    public List<SecurityProduct> getSecurityProducts(List<String> fundCodes) throws BaseException {
        return securityProductDao.querySecurityProducts(fundCodes);
    }

    @Override
    public FundDetail getFundDetail(String fundCode) throws BaseException {
        fundCode = fundCode.trim();

        FundDetail fundDetail = fundDetailDao.queryByFundCode(fundCode);
        if (fundDetail == null) {
            logger.warn("fundCode={} is not exist", fundCode);
            return null;
        }

        FundBaseResult result = new FundBaseResult();
        queryAndSetFundType(fundDetail, result);

        fundDetail.setFundType(result.getFundType());
        fundDetail.setFundTypeCode(result.getFundTypeCode());
        fundDetail.setOriginFundType(result.getOriginFundType());
        fundDetail.setOriginFundTypeCode(result.getOriginFundTypeCode());

        return fundDetail;
    }

    @Override
    public FundDetail getFundDetailByInnerCode(Integer innerCode) throws BaseException {
        FundDetail fundDetail = fundDetailDao.queryFundDetail(innerCode);

        FundBaseResult result = new FundBaseResult();
        queryAndSetFundType(fundDetail, result);

        fundDetail.setFundType(result.getFundType());
        fundDetail.setFundTypeCode(result.getFundTypeCode());
        fundDetail.setOriginFundType(result.getOriginFundType());
        fundDetail.setOriginFundTypeCode(result.getOriginFundTypeCode());

        return fundDetail;
    }

    /**
     * 基金详情(复杂)
     */
    @Override
    public FundDetailResult getFundDetailByFundCode(String fundCode) throws BaseAppException {
        logger.debug("query fundCode={}", fundCode);
        fundCode = fundCode.trim();

        SecurityProduct product = getProduct(fundCode);
        FundDetailResult result = new FundDetailResult();

        if (product == null) {
            return null;
        }

        int innerCode = product.getInnerCode();

        // 基金风险等级
        NewsModel riskModel = queryService.getRiskLevel(fundCode);
        if (riskModel != null) {
            result.setRiskLevel(riskModel.getRiskLevel());
            result.setRiskLevelString(riskModel.getRiskLevelString());
        }

        FundDetail fundDetail = fundDetailDao.queryFundDetail(innerCode);

        result.setInnerCode(innerCode);
        result.setFundCode(product.getSecuCode());
        result.setFundName(product.getChiName());
        result.setFundNameAbbr(product.getChiNameAbbr());

        // 基金等级
        FundRating fundRating = getFundRating(innerCode);
        if (fundRating != null) {
            result.setFundStarRank(fundRating.getStarRank());
        } else {
            logger.warn("fund {} star rank is null", fundCode);
        }

        if (fundDetail != null) {
            queryAndSetFundType(fundDetail, result);

            // 基金经理
            result.setFundManager(fundDetail.getManager());

            FundManager param = new FundManager();
            param.setInnerCode(innerCode);
            param.setIncumbent(FundConst.FUND_MANAGER_INCUMBENT);
            List<FundManager> fundManagerList = fundManagerDao.selectManagers(param);
            if (ListUtil.isNotEmpty(fundManagerList)) {
                List<FundManagerModel> fundManagers = new ArrayList<>();
                for (FundManager fundManager : fundManagerList) {
                    FundManagerModel model = new FundManagerModel();
                    model.setCode(fundManager.getPersonalCode());
                    model.setName(fundManager.getName());
                    model.setAccessionDate(fundManager.getAccessionDate());
                    if (fundManager.getPerformance() != null) {
                        model.setPerformance(MoneyUtils.calcRateToFrontEnd(fundManager.getPerformance()));
                    }
                    fundManagers.add(model);
                }
                result.setFundManagers(fundManagers);
            }

            // 基金管理人
            FundInvestAdvisorOutline investAdvisor = fundInvestAdvisorOutlineDao.selectFundInvestAdvisor(fundDetail
                .getInvestAdvisorCode());
            if (investAdvisor != null) {
                result.setInvestAdvisor(investAdvisor.getInvestAdvisorName());
                result.setInvestAdvisorCode(investAdvisor.getInvestAdvisorCode());
            }
        } else {
            logger.debug("fund detail is null");
        }

        // 特殊基金
        // 1.短期理财，按货币基金来展示 //resetFund

        // TODO 2.QDII 二期

        // 货币基金
        if (EqualsUtil.equals(FundConst.FUND_TYPE_CODE_CURRENCY, result.getFundTypeCode().intValue())
            || EqualsUtil
            .equals(FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING, result.getFundTypeCode().intValue())) {
            FundMMYieldPerformance record = new FundMMYieldPerformance();
            record.setInnerCode(innerCode);
            FundMMYieldPerformance currencyNetValue = fundMMYieldPerformanceDao.selectFundMMYieldPerformace(record);
            if (currencyNetValue != null) {
                // private BigDecimal LatestWeeklyYield;// 最近7日折算年收益率（%）
                // private BigDecimal DailyProfit;// 每万份基金单位当日收益（元）
                result.setLatestWeeklyYield(MoneyUtils.parseRate(currencyNetValue.getLatestWeeklyYield()));
                result.setDailyProfit(MoneyUtils.parseRate(currencyNetValue.getDailyProfit(), 4));
                result.setTradingDay(DateUtils.translateDate(currencyNetValue.getTradingDay(), DateUtils.MM_dd));

                result.setRRInSingleWeek(MoneyUtils.parseRate(currencyNetValue.getRRInSingleWeek()));
                result.setRRInSingleMonth(MoneyUtils.parseRate(currencyNetValue.getRRInSingleMonth()));
                result.setRRInThreeMonth(MoneyUtils.parseRate(currencyNetValue.getRRInThreeMonth()));
                result.setRRInSixMonth(MoneyUtils.parseRate(currencyNetValue.getRRInSixMonth()));
                result.setRRInSingleYear(MoneyUtils.parseRate(currencyNetValue.getRRInSingleYear()));
                result.setRRSinceThisYear(MoneyUtils.parseRate(currencyNetValue.getRRSinceThisYear()));
                result.setRRSinceStart(MoneyUtils.parseRate(currencyNetValue.getRRSinceStart()));
            } else {
                logger.debug("currencyNetValue is null");
            }

        } else {
            // 非货基
            // TODO 债券型货基需要特殊处理
            FundNetValuePerformance record = new FundNetValuePerformance();
            record.setInnerCode(innerCode);
            FundNetValuePerformance netValue = fundNetValuePerformaceDao.select(record);

            if (netValue != null) {
                // private BigDecimal nvDailyGrowthRate; // 日涨幅
                // private BigDecimal unitUV; // 单位净值
                result.setNvDailyGrowthRate(MoneyUtils.parseRate(netValue.getNVDailyGrowthRate()));
                result.setUnitNV(MoneyUtils.parseRate(netValue.getUnitNV(), 4));
                result.setTradingDay(DateUtils.translateDate(netValue.getTradingDay(), DateUtils.MM_dd));

                result.setRRInSingleWeek(MoneyUtils.parseRate(netValue.getRRInSingleWeek()));
                result.setRRInSingleMonth(MoneyUtils.parseRate(netValue.getRRInSingleMonth()));
                result.setRRInThreeMonth(MoneyUtils.parseRate(netValue.getRRInThreeMonth()));
                result.setRRInSixMonth(MoneyUtils.parseRate(netValue.getRRInSixMonth()));
                result.setRRInSingleYear(MoneyUtils.parseRate(netValue.getRRInSingleYear()));
                result.setRRSinceThisYear(MoneyUtils.parseRate(netValue.getRRSinceThisYear()));
                result.setRRSinceStart(MoneyUtils.parseRate(netValue.getRRSinceStart()));
            } else {
                logger.warn("net value is null");
            }

            // 费率
            List<FundRate> fundRateList = queryService.queryFundRate(fundCode, FundOperation.Apply);
            if (!fundRateList.isEmpty()) {
                // 选择最小一级 (0-x)
                FundRate maxFundRate = BizUtils.getMappingFundRate(fundRateList, GlobalConstant.BIG_DECIMAL_0);
                if (maxFundRate != null) {
                    String ratioStr = maxFundRate.getRatio();
                    BigDecimal ratio = new BigDecimal(ratioStr);
                    BigDecimal fareRatio = ratio.multiply(GlobalConstant.BIG_DECIMAL_100);
                    result.setFareRatio(MoneyUtils.parseRate(fareRatio, 2));

                    // 折扣率
                    List<FundDiscountSetting> fundDiscountSetting = queryService.queryFundDiscountSettings(fundCode,
                        FundOperation.Apply);
                    if (!fundDiscountSetting.isEmpty()) {
                        FundDiscountSetting maxFundDiscountSetting = BizUtils.getMappingFundDiscountSetting(
                            fundDiscountSetting, GlobalConstant.BIG_DECIMAL_0);
                        if (maxFundDiscountSetting != null) {
                            String afterDiscount = MoneyUtils.calcRate(ratioStr, maxFundDiscountSetting.getDiscount(),
                                maxFundDiscountSetting.getMin_fare_ratio());
                            result.setFareRatioAfterDiscount(afterDiscount);
                        }
                    }
                }
            }

        }

        return result;
    }

    @Override
    public FundRating getFundRating(Integer innerCode) throws BaseAppException {
        String key = CacheUtil.getKey(CacheKeyConst.MF_FUNDRATING, innerCode);
        FundRating result = CacheUtil.getStrObj(redisTemplate, key, FundRating.class);

        if (result == null) {
            result = fundRatingDao.selectFundRatingByInnerCode(innerCode);
            CacheUtil.setStrObj(redisTemplate, key, result);
        }
        return result;
    }

    @Override
    public FundOverViewResult getFundOverView(String fundCode) throws BaseException {
        fundCode = fundCode.trim();

        FundOverViewResult result = new FundOverViewResult();

        SecurityProduct product = getProduct(fundCode);

        if (product == null) {
            logger.debug("fund product is null");
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            // Alter by Shangdu - 20161115
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, fundCode));
            return result;
        }

        FundDetail fundDetail = fundDetailDao.queryFundDetail(product.getInnerCode());

        if (fundDetail == null) {
            logger.error("fund detail is null");
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FUND_DETAIL_NOT_EXIST);
            // Alter by Shangdu - 20161115
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_DETAIL_NOT_EXIST));
            return result;
        }

        result.setInnerCode(product.getInnerCode());
        result.setFundName(product.getChiName());
        result.setFundNameAbbr(product.getSecuAbbr());
        result.setFundCode(fundCode);

        queryAndSetFundType(fundDetail, result);

        // 风险等级
        NewsModel riskModel = queryService.getRiskLevel(fundCode);
        if (riskModel != null) {
            result.setRiskLevel(riskModel.getRiskLevel());
            result.setRiskLevelString(riskModel.getRiskLevelString());
        }
        result.setEstablishmentDate(fundDetail.getEstablishmentDate());

        // 资产规模
        FundAssetAllocation record = new FundAssetAllocation();
        record.setInnerCode(product.getInnerCode());
        record.setAssetTypeCode(FundConst.FUND_ASSET_TYPE_TOTAL);
        FundAssetAllocation fundAsset = fundAssetAllocationDao.select(record);

        if (fundAsset != null) {
            String marketValue;
            if (fundAsset.getMarketValue().compareTo(GlobalConstant.NUMBER_ONE_MILLION) >= 0) {
                // 亿元
                marketValue = MoneyUtils.formatMoney(
                    fundAsset.getMarketValue().divide(GlobalConstant.NUMBER_ONE_HUNDRED_MILLION), 2);
                result.setMarketValueUnit(GlobalConstant.PRICE_UNIT_TEN_HUNDRED_MILLION);
            } else {
                // 万元
                marketValue = MoneyUtils.formatMoney(
                    fundAsset.getMarketValue().divide(GlobalConstant.NUMBER_TEN_THOUSAND), 2);
                result.setMarketValueUnit(GlobalConstant.PRICE_UNIT_TEN_THOUSAND);
            }
            result.setMarketValue(marketValue);
        }

        // 份额
        String foundedSize;
        if (fundDetail.getFoundedSize().compareTo(GlobalConstant.NUMBER_ONE_HUNDRED_MILLION) >= 0) {
            // 亿份
            foundedSize = MoneyUtils.formatMoney(
                fundDetail.getFoundedSize().divide(GlobalConstant.NUMBER_ONE_HUNDRED_MILLION), 2);
            result.setFoundedSizeUnit(GlobalConstant.SHARE_UNIT_TEN_HUNDRED_MILLION);
        } else {
            // 万份
            // 亿份
            foundedSize = MoneyUtils.formatMoney(
                fundDetail.getFoundedSize().divide(GlobalConstant.NUMBER_TEN_THOUSAND), 2);
            result.setFoundedSizeUnit(GlobalConstant.SHARE_UNIT_TEN_THOUSAND);
        }
        result.setFoundedSize(foundedSize);

        // 基金管理人(基金公司)
        FundInvestAdvisorOutline investAdvisor = fundInvestAdvisorOutlineDao.selectFundInvestAdvisor(fundDetail
            .getInvestAdvisorCode());
        if (investAdvisor != null) {
            result.setFundCompany(investAdvisor.getInvestAdvisorName());
        }
        // 基金托管人
        FundTrustee fundTrustee = fundTrusteeDao.select(fundDetail.getTrusteeCode());
        if (fundTrustee != null) {
            result.setFundTrustee(fundTrustee.getTrusteeName());
        }
        // 基金经理
        result.setFundManager(fundDetail.getManager());
        result.setInvestTarget(HtmlUtil.convert2HTML(fundDetail.getInvestTarget()));
        result.setInvestField(HtmlUtil.convert2HTML(fundDetail.getInvestField()));
        result.setInvestOrientation(HtmlUtil.convert2HTML(fundDetail.getInvestOrientation()));

        result.setSuccess(true);

        return result;
    }

    @Override
    public FundNetValueResult getFundNetValue(String fundCode, Date date) throws BaseException {
        fundCode = fundCode.trim();
        logger.debug("fundCode={},date={}", fundCode, date);

        SecurityProduct product = getProduct(fundCode);

        if (product == null) {
            return null;
        }

        FundNetValueResult result = new FundNetValueResult();
        FundDetail fundDetail = fundDetailDao.queryFundDetail(product.getInnerCode());

        FundNetValue param = new FundNetValue();
        param.setInnerCode(product.getInnerCode());
        // Shangdu Lin - 20170421 - 使用净值截止日期
        param.setEndDate(date);

        FundNetValue netValue = fundNetValueDao.selectFundNetValue(param);
        if (netValue != null) {
            result.setNvDailyGrowthRate(netValue.getNvDailyGrowthRate());
            result.setUnitNV(netValue.getUnitNV());

            result.setTradingDay(netValue.getEndDate());
            result.setDailyProfit(netValue.getDailyProfit());
            result.setLatestWeeklyYield(netValue.getLatestWeeklyYield());

            logger.warn("当前传入时间:{},净值日期:{}", date, netValue.getEndDate());
        }

        result.setFundCode(product.getSecuCode());
        if (fundDetail != null) {
            queryAndSetFundType(fundDetail, result);
        }

        result.setChiName(product.getChiName());
        result.setChiNameAbbr(product.getChiNameAbbr());
        result.setSecuAbbr(product.getSecuAbbr());

        return result;
    }

    @Override
    public List<FundNetValueResult> getFundNetValueByBatch(List<String> fundCodeList, Date date) throws BaseException {
        logger.debug("fundCodeList={},date={}", fundCodeList, date);

        List<FundNetValueResult> result = new ArrayList<FundNetValueResult>(fundCodeList.size());

        for (String fundCode : fundCodeList) {
            FundNetValueResult netValue = getFundNetValue(fundCode, date);
            result.add(netValue);
        }
        return result;
    }

    @Override
    public FundNetValueHistoryResult getFundNetValueHistory(Integer innerCode, Integer pageIndex, Integer pageSize,
                                                            Integer sort) throws BaseException {
        FundNetValueHistoryResult result = new FundNetValueHistoryResult();
        result.setSuccess(true);

        List<FundNetValue> history = fundNetValueDao.selectFundNetValue(innerCode, pageIndex, pageSize, sort);

        if (history != null) {
            List<FundNetValueModel> netValueList = new ArrayList<FundNetValueModel>(history.size());
            for (FundNetValue netValue : history) {
                FundNetValueModel record = new FundNetValueModel();
                record.setTradingDay(netValue.getEndDate());
                // 货基
                record.setDailyProfit(MoneyUtils.parseRate(netValue.getDailyProfit(), 4));
                record.setLatestWeeklyYield(MoneyUtils.calcRateToFrontEnd(netValue.getLatestWeeklyYield()));

                // 非货基
                record.setNvDailyGrowthRate(MoneyUtils.calcRateToFrontEnd(netValue.getNvDailyGrowthRate()));
                record.setUnitNV(MoneyUtils.parseRate(netValue.getUnitNV(), 4));
                record.setAccumulatedUnitNV(MoneyUtils.parseRate(netValue.getAccumulatedUnitNV(), 4));

                netValueList.add(record);
            }
            result.setNetValueList(netValueList);
        }
        return result;
    }

    @Override
    public FundNetValuePerformance getFundNetValuePerformance(String fundCode) throws BaseException {
        fundCode = fundCode.trim();
        logger.debug("fundCode={}", fundCode);

        SecurityProduct product = getProduct(fundCode);
        if (product == null) {
            logger.debug("fund product is null");
            return null;
        }
        FundNetValuePerformance record = new FundNetValuePerformance();
        record.setInnerCode(product.getInnerCode());
        return fundNetValuePerformaceDao.select(record);
    }

    @Override
    public FundPerformanceResult getFundPerformance(String fundCode) throws BaseException {
        fundCode = fundCode.trim();
        logger.debug("fundCode={}", fundCode);

        SecurityProduct product = getProduct(fundCode);

        if (product == null) {
            logger.error("Fund product is null.");
            return null;
        }
        FundPerformanceResult result = new FundPerformanceResult();

        FundDetail fundDetail = fundDetailDao.queryFundDetail(product.getInnerCode());
        result.setFundCode(fundCode);

        if (fundDetail == null) {
            logger.error("fund detail is null.");
            // Alter by Shangdu - 20161115
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            return result;
        }

        result.setFundCode(product.getSecuCode());
        result.setChiName(product.getChiName());
        result.setChiNameAbbr(product.getChiNameAbbr());
        result.setSecuAbbr(product.getSecuAbbr());

        queryAndSetFundType(fundDetail, result);

        // 货币基金+短期理财
        if (EqualsUtil.equals(FundConst.FUND_TYPE_CODE_CURRENCY, result.getFundTypeCode().intValue())
            || EqualsUtil
            .equals(FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING, result.getFundTypeCode().intValue())) {
            FundMMYieldPerformance record = new FundMMYieldPerformance();
            record.setInnerCode(product.getInnerCode());
            // record.setTradingDay(date);
            FundMMYieldPerformance currencyNetValue = fundMMYieldPerformanceDao.selectFundMMYieldPerformace(record);

            if (currencyNetValue == null) {
                // Alter by Shangdu - 20161115
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                logger.error("没有查询到货基净值");
            } else {
                result.setTradingDay(currencyNetValue.getTradingDay());
                result.setLatestWeeklyYield(currencyNetValue.getLatestWeeklyYield());
                result.setRRInSingleWeek(currencyNetValue.getRRInSingleWeek());
                result.setRRInSingleMonth(currencyNetValue.getRRInSingleMonth());
                result.setRRInThreeMonth(currencyNetValue.getRRInThreeMonth());
                result.setRRInSixMonth(currencyNetValue.getRRInSixMonth());
                result.setRRInSingleYear(currencyNetValue.getRRInSingleYear());
                result.setRRSinceThisYear(currencyNetValue.getRRSinceThisYear());
                result.setRRSinceStart(currencyNetValue.getRRSinceStart());
                //Shangdu Lin - 20170329
                result.setRRInTwoYear(currencyNetValue.getRRInTwoYear());
                result.setRRInThreeYear(currencyNetValue.getRRInThreeYear());
                result.setRRInFiveYear(currencyNetValue.getRRInFiveYear());
                result.setRRInTenYear(currencyNetValue.getRRInTenYear());
            }
        } else {
            // 非货基
            FundNetValuePerformance record = new FundNetValuePerformance();
            record.setInnerCode(product.getInnerCode());
            // 只能查出最新的，才会有统计信息
            FundNetValuePerformance netValue = fundNetValuePerformaceDao.select(record);

            if (netValue != null) {
                result.setTradingDay(netValue.getTradingDay());
                result.setRRInSingleWeek(netValue.getRRInSingleWeek());
                result.setRRInSingleMonth(netValue.getRRInSingleMonth());
                result.setRRInThreeMonth(netValue.getRRInThreeMonth());
                result.setRRInSixMonth(netValue.getRRInSixMonth());
                result.setRRInSingleYear(netValue.getRRInSingleYear());
                result.setRRSinceThisYear(netValue.getRRSinceThisYear());
                result.setRRSinceStart(netValue.getRRSinceStart());
                //Shangdu Lin - 20170329
                result.setRRInTwoYear(netValue.getRRInTwoYear());
                result.setRRInThreeYear(netValue.getRRInThreeYear());
                result.setRRInFiveYear(netValue.getRRInFiveYear());
                result.setRRInTenYear(netValue.getRRInTenYear());
            } else {
                logger.warn("{}没有查询到非货基金净值", fundCode);
            }
        }

        return result;
    }

    @Override
    public List<FundPerformanceResult> getFundPerformanceByBatch(List<String> fundCodeList) throws BaseException {
        logger.debug("fundCodeList={}", fundCodeList);

        List<FundPerformanceResult> result = new ArrayList<FundPerformanceResult>(fundCodeList.size());

        for (String fundCode : fundCodeList) {
            FundPerformanceResult netValue = getFundPerformance(fundCode);
            result.add(netValue);
        }

        return result;
    }

    @Override
    public FundMMYieldPerformance getFundMMYieldPerformance(String fundCode) throws BaseException {
        fundCode = fundCode.trim();
        logger.debug("fundCode={}", fundCode);

        SecurityProduct product = getProduct(fundCode);
        if (product == null) {
            logger.debug("fund product is null");
            return null;
        }

        FundMMYieldPerformance record = new FundMMYieldPerformance();
        record.setInnerCode(product.getInnerCode());
        return fundMMYieldPerformanceDao.selectFundMMYieldPerformace(record);
    }

    @Override
    public FundInvestAdvisorOutline getFundInvestAdvisorOutline(Integer InvestAdvisorCode) throws BaseException {
        return fundInvestAdvisorOutlineDao.selectFundInvestAdvisor(InvestAdvisorCode);
    }

    @Override
    public List<FundAnnouncement> getFundAnnouncements(Integer innerCode, Integer pageIndex, Integer pageSize)
        throws BaseException {
        return fundAnnouncementDao.queryFundAnnouncement(innerCode, pageIndex, pageSize);
    }

    @Override
    public FundAnnouncementResult getFundAnnouncement(Long announcementId, String resourceType) throws BaseException {
        logger.debug("announcementId={},resourceType={}", announcementId, resourceType);
        FundAnnouncement announcement = null;

        switch (resourceType) {
            case FundConst.FUND_ANNOUNCEMENT_FROM_ANNOUNCEMENT:
                announcement = fundAnnouncementDao.queryFundAnnouncement(announcementId);
                break;
            case FundConst.FUND_ANNOUNCEMENT_FROM_INTERIMBULLETIN:
                announcement = fundAnnouncementDao.queryFundInterimBulletin(announcementId);
                break;
        }

        FundAnnouncementResult result = new FundAnnouncementResult();
        if (announcement != null) {
            String content = announcement.getContent();

            String key = CacheUtil.getKey("MF_Announcement", "" + announcement.getID());
            ValueOperations<String, String> op = redisTemplate.opsForValue();
            String cacheContent = op.get(key);
            if (StringUtil.isEmpty(cacheContent)) {
                logger.warn("redis key={} is null", key);
                StringBuilder sb = new StringBuilder();
                sb.append("<p>").append(content.replaceAll("\n", "</p><p>")).append("</p>");
                announcement.setContent(sb.toString());

                op.set(key, sb.toString(), 7, TimeUnit.DAYS); // 一周
            } else {
                announcement.setContent(cacheContent);
            }

            BeanUtils.copyProperties(announcement, result);
        }
        return result;
    }

    @Override
    public List<FundManager> getFundManagers(String fundCode) throws BaseException {
        fundCode = fundCode.trim();

        SecurityProduct product = getProduct(fundCode);
        if (product == null) {
            return null;
        }
        FundManager param = new FundManager();
        param.setInnerCode(product.getInnerCode());
        param.setIncumbent(FundConst.FUND_MANAGER_INCUMBENT);

        return fundManagerDao.selectManagers(param);
    }

    @Override
    public FundPersonInfo getFundPersonInfo(Long personalCode) throws BaseException {
        String key = CacheUtil.getKey(CacheKeyConst.MF_FUND_MANAGER_PERSON_INFO, personalCode.longValue());

        FundPersonInfo personInfo = CacheUtil.getStrObj(redisTemplate, key, FundPersonInfo.class);

        if (personInfo == null) {
            logger.warn("cache[{}] is not existed", key);

            FundPersonInfo record = new FundPersonInfo();
            record.setPersonalCode(personalCode);
            personInfo = fundPersonInfoDao.select(record);

            CacheUtil.setStrObj(redisTemplate, key, personInfo, 2, TimeUnit.DAYS);
        }

        return personInfo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> getFundManagerPerformance(String fundManagerCode, Byte status)
        throws BaseException {
        String key = CacheUtil.getKey("FundManagerPerformance", fundManagerCode);
        ValueOperations<String, Object> redisOp = redisTemplateObj.opsForValue();

        Object cacheObj = redisOp.get(key);
        if (cacheObj != null) {
            return (List<Map<String, Object>>) cacheObj;
        }
        logger.warn("cache[{}] is not existed", key);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("personalCode", fundManagerCode);
        if (status != null) {
            param.put("incumbent", status);
        }
        List<Map<String, Object>> perfs = fundManagerDao.queryManagerPerformance(param);
        redisOp.set(key, perfs, 1, TimeUnit.DAYS);

        return perfs;
    }

    @Override
    public List<FundDividend> getFundDividend(Map<String, Object> param) throws BaseException {
        // innerCode,pageView
        return fundDividendDao.select(param);
    }

    @Override
    public List<FundSharesSplit> getFundSharesSplit(Map<String, Object> param) throws BaseException {
        // innerCode,pageView
        return fundSharesSplitDao.select(param);
    }

    @Override
    public List<FundAssetAllocationModel> getFundAssetAllocation(int innerCode, List<Integer> assetTypeCodes)
        throws BaseException {
        FundDetail fundDetail = fundDetailDao.queryFundDetail(innerCode);

        FundBaseResult result = new FundBaseResult();
        queryAndSetFundType(fundDetail, result);

        // 分级基金，子基金没有相关的数据
        List<FundCodeRelationship> codeRelationships = fundCodeRelationshipService.getCodeRelationships(innerCode,
            FundConst.CODE_EFFECT_YES);

        if (ListUtil.isNotEmpty(codeRelationships)) {
            FundCodeRelationship first = codeRelationships.get(0);
            innerCode = first.getInnercode();
            logger.debug("parent fund innerCode is {}", innerCode);
        }

        List<FundAssetAllocationModel> assetAllocations = null;

        // QDII
        if (EqualsUtil.equals(result.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_QDII)) {
            List<FundQDIIAssetAllocation> list = fundQDIIAssetAllocationDao.selectList(innerCode, assetTypeCodes);
            if (ListUtil.isNotEmpty(list)) {
                assetAllocations = new ArrayList<>(list.size());
                for (FundQDIIAssetAllocation assetAllocation : list) {
                    FundAssetAllocationModel model = new FundAssetAllocationModel();
                    model.setAssetType(assetAllocation.getAssetName());
                    model.setAssetTypeCode(assetAllocation.getAssetType());
                    model.setMarketValue(assetAllocation.getMarketValue());
                    model.setRatioInNV(MoneyUtils.formatMoney(assetAllocation.getRatioInNV(), 2));
                    model.setReportDate(assetAllocation.getEndDate());
                    assetAllocations.add(model);
                }
            }
            return assetAllocations;
        }

        // Other
        List<FundAssetAllocation> list = fundAssetAllocationDao.selectList(innerCode, assetTypeCodes);
        if (ListUtil.isNotEmpty(list)) {
            assetAllocations = new ArrayList<>(list.size());
            for (FundAssetAllocation assetAllocation : list) {
                FundAssetAllocationModel model = new FundAssetAllocationModel();
                model.setAssetType(assetAllocation.getAssetType());
                model.setAssetTypeCode(assetAllocation.getAssetTypeCode());
                model.setMarketValue(assetAllocation.getMarketValue());
                model.setRatioInNV(MoneyUtils.calcRateToFrontEnd(assetAllocation.getRatioInNV()));
                model.setReportDate(assetAllocation.getReportDate());
                assetAllocations.add(model);
            }
        }

        return assetAllocations;
    }

    @Override
    public List<FundPortifolio> getFundPortifolio(int innerCode) throws BaseException {
        FundDetail fundDetail = fundDetailDao.queryFundDetail(innerCode);

        FundBaseResult result = new FundBaseResult();
        queryAndSetFundType(fundDetail, result);

        // 分级基金，子基金没有相关的数据
        List<FundCodeRelationship> codeRelationships = fundCodeRelationshipService.getCodeRelationships(innerCode,
            FundConst.CODE_EFFECT_YES);

        if (ListUtil.isNotEmpty(codeRelationships)) {
            FundCodeRelationship first = codeRelationships.get(0);
            innerCode = first.getInnercode();
            logger.debug("parent fund innerCode is {}", innerCode);
        }

        List<FundPortifolio> list = new ArrayList<>();
        // QDII
        if (EqualsUtil.equals(result.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_QDII)) {
            List<Map<String, Object>> portfolios = fundQDIIPortfolioDetailDao.selectLatest(innerCode);
            parsePortifolio(list, portfolios, FundConst.FUND_TYPE_CODE_QDII);
            return list;
        }

        // 其他类型
        List<Map<String, Object>> portfolios = fundBondPortifolioDetailDao.selectLatest(innerCode);
        List<Map<String, Object>> portfolios2 = fundKeyStockPortfolioDao.selectLatest(innerCode);

        parsePortifolio(list, portfolios, result.getFundTypeCode());
        parsePortifolio(list, portfolios2, result.getFundTypeCode());

        return list;
    }

    @Override
    public List<FundInvestIndustryModel> getFundInvestIndustry(int innerCode) throws BaseException {
        FundDetail fundDetail = fundDetailDao.queryFundDetail(innerCode);

        FundBaseResult result = new FundBaseResult();
        queryAndSetFundType(fundDetail, result);

        // 分级基金，子基金没有相关的数据
        List<FundCodeRelationship> codeRelationships = fundCodeRelationshipService.getCodeRelationships(innerCode,
            FundConst.CODE_EFFECT_YES);

        if (ListUtil.isNotEmpty(codeRelationships)) {
            FundCodeRelationship first = codeRelationships.get(0);
            innerCode = first.getInnercode();
            logger.debug("parent fund innerCode is {}", innerCode);
        }

        List<FundInvestIndustryModel> list = new ArrayList<>();
        // QDII
        if (EqualsUtil.equals(result.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_QDII)) {
            List<FundQDIIPortfolioIndustry> industrys = fundQDIIPortfolioIndustryDao.selectLatest(innerCode);
            if (ListUtil.isNotEmpty(industrys)) {
                for (FundQDIIPortfolioIndustry industry : industrys) {
                    FundInvestIndustryModel model = new FundInvestIndustryModel();
                    model.setIndustryName(industry.getIndustryName());
                    model.setRatioInNV(MoneyUtils.formatMoney(industry.getRatioInNV(), 2));// 含%
                    list.add(model);
                }
            }
            return list;
        }

        // 其他类型
        List<FundInvestIndustry> industrys = fundInvestIndustryDao.selectLatest(innerCode);
        if (ListUtil.isNotEmpty(industrys)) {
            for (FundInvestIndustry industry : industrys) {
                FundInvestIndustryModel model = new FundInvestIndustryModel();
                model.setIndustryName(industry.getIndustryName());
                // Shangdu Lin - 20170406 - 需要判断是否为空
                BigDecimal ratioInNV = industry.getRatioInNV();
                if (ratioInNV != null) {
                    model.setRatioInNV(MoneyUtils.formatMoney(
                        ratioInNV.multiply(GlobalConstant.BIG_DECIMAL_100), 2));
                }
                list.add(model);
            }
        }

        return list;
    }

    @Override
    public List<Map<String, Object>> getFundByInvestAdvisor(int investAdvisorCode, int pageIndex, int pageSize)
        throws BaseAppException {
        return fundDetailDao.queryByInvestAdvisorCode(investAdvisorCode, pageIndex, pageSize);
    }

    @Override
    public List<FundStatisticModel> getStatisticData(Integer innerCode, int monthCount, Date endDate)
        throws BaseAppException {
        if (endDate == null) {
            endDate = DateUtils.addDay(new Date(), -1);// 默认是前一天
        }
        monthCount = monthCount <= 0 ? 1 : monthCount;
        monthCount = monthCount > 12 ? 12 : monthCount; // 防止过量查询

        String key = CacheUtil.getKey("MF_NET_VALUE", "STATIC", innerCode);
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        String valueStr = op.get(key);

        List<FundStatisticModel> result = JSON.parseArray(valueStr, FundStatisticModel.class);

        if (ListUtil.isEmpty(result)) {
            Date beginDate = DateUtils.addMondth(endDate, monthCount * -1);
            logger.debug("beginDate={},endDate={}", beginDate, endDate);

            List<FundNetValue> temp = fundNetValueDao.select(innerCode, beginDate, endDate);
            FundDetail fundDetail = getFundDetailByInnerCode(innerCode);
            boolean isCurrency = EqualsUtil.equals(fundDetail.getFundTypeCode().intValue(),
                FundConst.FUND_TYPE_CODE_CURRENCY);

            result = new ArrayList<>();
            for (FundNetValue netValue : temp) {
                FundStatisticModel model = new FundStatisticModel();
                model.setTradingDay(netValue.getEndDate());
                if (isCurrency) {
                    // 转成带%的
                    model.setRate(MoneyUtils.convert2Percent(netValue.getLatestWeeklyYield(), 2));
                } else {
                    model.setRate(MoneyUtils.convert2Percent(netValue.getNvDailyGrowthRate(), 2));
                }
                result.add(model);
            }

            op.set(key, JSON.toJSONString(result));
        } else {
            logger.debug("load from cache");
        }

        return result;
    }

    @Override
    public BigDecimal getStatisticTotal(Integer innerCode, int monthCount, Date endDate) throws BaseAppException {
        if (endDate == null) {
            endDate = DateUtils.addDay(new Date(), -1);// 默认是前一天
        }
        monthCount = monthCount <= 0 ? 1 : monthCount;
        monthCount = monthCount > 12 ? 12 : monthCount; // 防止过量查询

        String key = CacheUtil.getKey("MF_NET_VALUE", "STATIC_TOTAL", innerCode);
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        String valueStr = op.get(key);

        FundNetValuePerformance netValuePerformance;
        if (StringUtil.isEmpty(valueStr)) {
            // Date beginDate = DateUtils.addMondth(endDate, monthCount * -1);
            // logger.debug("beginDate={},endDate={}", beginDate, endDate);

            logger.debug("query date=[{}] performance", endDate);

            FundNetValuePerformance record = new FundNetValuePerformance();
            record.setInnerCode(innerCode);
            record.setTradingDay(endDate);
            netValuePerformance = fundNetValuePerformaceDao.select(record);

            if (netValuePerformance == null) {
                logger.error("query fund[innerCode={}] net value performance is null, please check!", innerCode);
            } else {
                op.set(key, JSON.toJSONString(netValuePerformance));
            }
        } else {
            logger.debug("load from cache[{}]", key);
            netValuePerformance = JSON.parseObject(valueStr, FundNetValuePerformance.class);
        }
        if (netValuePerformance != null) {
            switch (monthCount) {
                case 1:
                    return MoneyUtils.format(netValuePerformance.getRRInSingleMonth(), 2);
                case 3:
                    return MoneyUtils.format(netValuePerformance.getRRInThreeMonth(), 2);
                case 6:
                    return MoneyUtils.format(netValuePerformance.getRRInSixMonth(), 2);
                case 12:
                    return MoneyUtils.format(netValuePerformance.getRRInSingleYear(), 2);
            }
        }
        return null;
    }

    @Override
    public List<FundSortModel> getSortByNetValuePerformance(Integer fundTypeCode, List<String> fundCodes,
                                                            Integer statisType, Integer sort, Integer pageIndex, Integer pageSize) throws BaseAppException {

        boolean isCurrency = FundUtil.isCurrency(fundTypeCode);
        // validate param
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        sort = (sort.intValue() == 0 || sort.intValue() == 1) ? sort : 1;
        statisType = isCurrency ? 0 : statisType;

        String key = CacheUtil.getKey(CacheKeyConst.MF_FUND_NET_VALUE_PERFORMANCE_SORT, fundTypeCode, statisType, sort);
        ListOperations<String, String> listOp = redisTemplate.opsForList();
        Long allPageCount = listOp.size(key);

        List<FundSortModel> result = null;

        if (allPageCount == null || EqualsUtil.equals(allPageCount.intValue(), 0)) {
            logger.warn("loading data from db");

            List<SecurityProduct> products = securityProductDao.querySecurityProducts(fundCodes);
            List<Integer> innerCodes = new ArrayList<>(products.size());
            for (SecurityProduct product : products) {
                innerCodes.add(product.getInnerCode());
            }
            if (ListUtil.isEmpty(innerCodes)) {
                logger.warn("no innerCode");
                return null;
            }

            Date tradingDay = null; // 查询最新的交易日
            List<Map<String, Object>> temp; // 返回结果
            String staticTypeValue = "NVDailyGrowthRate"; // 默认字段

            WorkingDayResult workingDayResult = workingDateService.getLastWorkingDay(new Date());
            logger.debug("query work day result={}", workingDayResult);
            if (workingDayResult != null && workingDayResult.getSuccess()) {
                tradingDay = workingDayResult.getLastWorkingDay();
            }
            if (tradingDay == null) {
                logger.warn("tradingDay is null, do nothing.");
                return null;
            }

            if (isCurrency) {
                temp = fundNetValueDao.selectSort(innerCodes, isCurrency, tradingDay, pageIndex, pageSize, sort);
            } else {
                temp = fundNetValuePerformaceDao.selectSort(innerCodes, statisType, tradingDay, pageIndex, pageSize,
                    sort);
                staticTypeValue = FundUtil.getStatisType(statisType);
            }

            if (ListUtil.isNotEmpty(temp)) {
                result = new ArrayList<>(temp.size());
                for (Map<String, Object> map : temp) {

                    FundSortModel model = new FundSortModel();
                    model.setFundCode(MapUtils.getStr(map, "FundCode"));
                    model.setFundName(MapUtils.getStr(map, "ChiNameAbbr"));
                    model.setFundNameAbbr(MapUtils.getStr(map, "SecuAbbr"));
                    model.setInnerCode(MapUtils.getInteger(map, "InnerCode"));

                    Date recentlyTradingDay = null;
                    String rate = null, value = null;

                    if (isCurrency) { // 货基
                        recentlyTradingDay = MapUtils.getDate(map, "EndDate");
                        rate = MoneyUtils.calcRateToFrontEnd(MapUtils.getBigDecimal(map, "LatestWeeklyYield"));
                        value = MoneyUtils.formatMoney(MapUtils.getBigDecimal(map, "DailyProfit"), 4);

                        if (recentlyTradingDay == null) { // 查询最近一次的净值

                            logger.warn("fundCode={},innerCode={} has no tradingDay,then query recently latest.",
                                model.getFundCode(), model.getInnerCode());

                            FundNetValue netValue = fundNetValueDao.selectLatest(model.getInnerCode());
                            if (netValue == null) {
                                logger.warn("fund has no latest netvalue.");
                            } else {
                                recentlyTradingDay = netValue.getEndDate();
                                rate = MoneyUtils.calcRateToFrontEnd(netValue.getLatestWeeklyYield());
                                value = MoneyUtils.formatMoney(netValue.getDailyProfit(), 4);
                            }
                        }

                    } else { // 非货基
                        recentlyTradingDay = MapUtils.getDate(map, "TradingDay");
                        rate = MoneyUtils.formatMoney(MapUtils.getBigDecimal(map, staticTypeValue), 2);
                        value = MoneyUtils.formatMoney(MapUtils.getBigDecimal(map, "UnitNV"), 4);

                        if (recentlyTradingDay == null) { // 获取最近一次的净值

                            logger.warn("innerCode={},recently TradingDay is null", model.getFundCode());
                            FundNetValuePerformance netValue = fundNetValuePerformaceDao.selectLatest(model
                                .getInnerCode());

                            if (netValue == null) {
                                logger.warn("recently NetValuePerformance is null,innerCode={}", model.getInnerCode());
                            } else {
                                recentlyTradingDay = netValue.getTradingDay();
                                rate = MoneyUtils.formatMoney(FundUtil.getStatisType(netValue, statisType), 2);
                                value = MoneyUtils.formatMoney(netValue.getUnitNV(), 4);
                            }
                        }
                    }

                    model.setTradingDay(recentlyTradingDay);
                    model.setRate(rate);
                    model.setValue(value);

                    result.add(model);
                }
            }
        } else {
            logger.debug("loading data from cache");
            int pageCount = allPageCount.intValue() / pageSize + (allPageCount.intValue() % pageSize == 0 ? 0 : 1);
            if (pageIndex > pageCount) {
                logger.warn("pageIndex={},pageSize={}", pageIndex, pageSize);
                logger.warn("all pageCount={}", pageCount);
                return null;
            }
            int nextPageIndex = pageIndex * pageSize - 1;
            int fromIndex = (pageIndex - 1) * pageSize;
            int toIndex = nextPageIndex > allPageCount.intValue() ? allPageCount.intValue() : nextPageIndex;
            List<String> temp = listOp.range(key, fromIndex, toIndex);

            result = new ArrayList<>(temp.size());
            for (String sortModelStr : temp) {
                result.add(JSON.parseObject(sortModelStr, FundSortModel.class));
            }

        }

        return result;
    }

    // ------------------- private method begin -----------------------
    private SecurityProduct getProduct(String fundCode) {
        fundCode = fundCode.trim();
        logger.debug("query fundCode={}", fundCode);
        String key = CacheUtil.getKey(CacheKeyConst.MF_SECUMAIN, fundCode);

        SecurityProduct product = CacheUtil.getStrObj(redisTemplate, key, SecurityProduct.class);
        if (product == null) {
            product = securityProductDao.querySecurityProduct(fundCode);
            CacheUtil.setStrObj(redisTemplate, key, product);
        }

        return product;
    }

    /**
     * 重新设置基金类型 <br/>
     * 新增加一种类型后需要重新刷新一下cache
     *
     * @param innerCode 基金内部编码
     * @param result    FundBaseResult
     */
    @SuppressWarnings("unchecked")
    private void queryAndSetFundType(FundDetail fundDetail, FundBaseResult result) {
        result.setFundType(fundDetail.getFundType());
        result.setFundTypeCode(fundDetail.getFundTypeCode());
        result.setOriginFundType(fundDetail.getFundType());
        result.setOriginFundTypeCode(fundDetail.getFundTypeCode());

        ValueOperations<String, Object> op = redisTemplateObj.opsForValue();
        String key = CacheUtil.getKey(CacheKeyConst.MF_FUND_TYPE, fundDetail.getInnerCode());
        Object valueObj = op.get(key);

        if (valueObj != null) {
            Map<String, Object> map = (Map<String, Object>) valueObj;
            result.setFundType(MapUtils.getStr(map, "FUND_TYPE"));
            result.setFundTypeCode(MapUtils.getInteger(map, "FUND_TYPE_CODE"));
            return;
        }

        Map<String, Object> map = new HashMap<>();

        FundArchivesAttach fundArchiveAttach = getShortTermFinancing(fundDetail.getInnerCode());
        if (fundArchiveAttach != null) {
            result.setFundType(FundConst.FUND_TYPE_LABEL_SHORT_TERM_FINANCING);
            result.setFundTypeCode(FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING);

            map.put("FUND_TYPE", FundConst.FUND_TYPE_LABEL_SHORT_TERM_FINANCING);
            map.put("FUND_TYPE_CODE", FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING);
            op.set(key, map);
            return;
        }

        fundArchiveAttach = getQDII(fundDetail.getInnerCode());
        if (fundArchiveAttach != null) {
            result.setFundType(FundConst.FUND_TYPE_LABEL_QDII);
            result.setFundTypeCode(FundConst.FUND_TYPE_CODE_QDII);

            map.put("FUND_TYPE", FundConst.FUND_TYPE_LABEL_QDII);
            map.put("FUND_TYPE_CODE", FundConst.FUND_TYPE_CODE_QDII);
            op.set(key, map);
            return;
        }

        fundArchiveAttach = getIndexFund(fundDetail.getInnerCode());
        if (fundArchiveAttach != null) {
            result.setFundType(FundConst.FUND_TYPE_LABEL_INDEX);
            result.setFundTypeCode(FundConst.FUND_TYPE_CODE_INDEX);

            map.put("FUND_TYPE", FundConst.FUND_TYPE_LABEL_INDEX);
            map.put("FUND_TYPE_CODE", FundConst.FUND_TYPE_CODE_INDEX);
            op.set(key, map);
            return;
        }

        map.put("FUND_TYPE", result.getFundType());
        map.put("FUND_TYPE_CODE", result.getFundTypeCode());
        op.set(key, map);
    }

    /**
     * 获取短期理财类型
     *
     * @param innerCode 基金内部编码
     * @return 基金附表
     */
    private FundArchivesAttach getShortTermFinancing(int innerCode) {
        ValueOperations<String, Object> op = redisTemplateObj.opsForValue();
        String key = CacheUtil.getKey("MF_FUND_TYPE", innerCode);
        Object valueObj = op.get(key);
        if (valueObj != null) {
            return (FundArchivesAttach) valueObj;
        }

        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("typeCode", FundConst.TYPE_CODE_JU_YUAN);

        List<Integer> dataCodes = new ArrayList<>(3);
        dataCodes.add(FundConst.DATA_CODE_SHORT_TERM_FINANCING);
        dataCodes.add(FundConst.DATA_CODE_SHORT_TERM_FINANCING_A);
        dataCodes.add(FundConst.DATA_CODE_SHORT_TERM_FINANCING_B_AND_C);
        param.put("dataCodes", dataCodes);

        FundArchivesAttach archivesAttach = fundArchivesAttachDao.select(param);
        if (archivesAttach != null) {
            op.set(key, archivesAttach);
        }

        return archivesAttach;
    }

    /**
     * QDII类型基金
     *
     * @param innerCode 基金内部编码
     * @return 基金附表
     */
    private FundArchivesAttach getQDII(int innerCode) {
        ValueOperations<String, Object> op = redisTemplateObj.opsForValue();
        String key = CacheUtil.getKey("MF_FUND_TYPE", innerCode);
        Object valueObj = op.get(key);
        if (valueObj != null) {
            return (FundArchivesAttach) valueObj;
        }

        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("typeCode", FundConst.TYPE_CODE_JU_YUAN);

        List<Integer> dataCodes = new ArrayList<>();
        dataCodes.add(FundConst.DATA_CODE_QDII);
        dataCodes.add(FundConst.DATA_CODE_QDII_100);
        dataCodes.add(FundConst.DATA_CODE_QDII_101);
        dataCodes.add(FundConst.DATA_CODE_QDII_102);
        dataCodes.add(FundConst.DATA_CODE_QDII_103);
        dataCodes.add(FundConst.DATA_CODE_QDII_104);
        dataCodes.add(FundConst.DATA_CODE_QDII_105);
        dataCodes.add(FundConst.DATA_CODE_QDII_108);
        dataCodes.add(FundConst.DATA_CODE_QDII_109);
        dataCodes.add(FundConst.DATA_CODE_QDII_200);
        dataCodes.add(FundConst.DATA_CODE_QDII_300);
        dataCodes.add(FundConst.DATA_CODE_QDII_400);
        dataCodes.add(FundConst.DATA_CODE_QDII_500);
        dataCodes.add(FundConst.DATA_CODE_QDII_600);
        dataCodes.add(FundConst.DATA_CODE_QDII_700);
        dataCodes.add(FundConst.DATA_CODE_QDII_701);
        dataCodes.add(FundConst.DATA_CODE_QDII_702);

        param.put("dataCodes", dataCodes);

        FundArchivesAttach archivesAttach = fundArchivesAttachDao.select(param);
        if (archivesAttach != null) {
            op.set(key, archivesAttach);
        }

        return archivesAttach;
    }

    /**
     * 指数型基金
     *
     * @param innerCode 基金内部编码
     * @return
     */
    private FundArchivesAttach getIndexFund(Integer innerCode) {
        String key = CacheUtil.getKey("MF_FUND_TYPE", innerCode);
        FundArchivesAttach fundAttach = CacheUtil.getStrObj(redisTemplate, key, FundArchivesAttach.class);

        if (fundAttach == null) {
            Map<String, Object> param = new HashMap<>();
            param.put("innerCode", innerCode);
            param.put("typeCode", FundConst.TYPE_CODE_JU_YUAN);

            List<Integer> dataCodes = new ArrayList<>(2);
            dataCodes.add(FundConst.DATA_CODE_INDEX_100);
            dataCodes.add(FundConst.DATA_CODE_INDEX_200);

            param.put("dataCodes", dataCodes);

            fundAttach = fundArchivesAttachDao.select(param);
            if (fundAttach != null) {
                CacheUtil.setStrObj(redisTemplate, key, fundAttach);
            }
        }

        return fundAttach;
    }

    /**
     * 将内容解析到指定集合中
     *
     * @param list
     * @param portfolios
     * @param type
     */
    private void parsePortifolio(List<FundPortifolio> list, List<Map<String, Object>> portfolios, int fundTypeCode) {
        if (ListUtil.isNotEmpty(portfolios)) {
            for (Map<String, Object> map : portfolios) {
                FundPortifolio portifolio = new FundPortifolio();

                if (EqualsUtil.equals(fundTypeCode, FundConst.FUND_TYPE_CODE_QDII)) {
                    portifolio.setReportDate(MapUtils.getDate(map, "InfoPublDate"));
                    portifolio.setRatioInNV(MoneyUtils.formatMoney(MapUtils.getBigDecimal(map, "RatioInNV"), 2));
                } else {
                    portifolio.setReportDate(MapUtils.getDate(map, "ReportDate"));
                    portifolio.setRatioInNV(MoneyUtils.calcRateToFrontEnd(MapUtils.getBigDecimal(map, "RatioInNV")));
                }
                portifolio.setSerialNumber(MapUtils.getInteger(map, "SerialNumber"));
                portifolio.setHoldVolume(MapUtils.getBigDecimal(map, "HoldVolume"));
                portifolio.setMarketValue(MapUtils.getBigDecimal(map, "MarketValue"));
                portifolio.setFundName(MapUtils.getStr(map, "FundName"));
                portifolio.setFundNameAbbr(MapUtils.getStr(map, "FundNameAbbr"));

                list.add(portifolio);
            }
        }
    }

    // ------------------- private method end -----------------------

}
