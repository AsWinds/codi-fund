package com.codi.api.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codi.base.dao.plugin.page.PageView;
import com.codi.base.exception.BaseAppException;
import com.codi.base.exception.ExceptionHandler;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.DateUtils;
import com.codi.base.util.EqualsUtil;
import com.codi.base.util.ListUtil;
import com.codi.base.util.MapUtils;
import com.codi.base.util.MoneyUtils;
import com.codi.base.util.StringUtil;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.constant.FundConst;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.domain.FundInfo;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.FundAnnouncementResult;
import com.codi.bus.core.resultModel.FundAnnouncementsResult;
import com.codi.bus.core.resultModel.FundAssetAllocationResult;
import com.codi.bus.core.resultModel.FundBuyNoticeResult;
import com.codi.bus.core.resultModel.FundDetailResult;
import com.codi.bus.core.resultModel.FundDiscountSetting;
import com.codi.bus.core.resultModel.FundDividendAndSharesSplitResult;
import com.codi.bus.core.resultModel.FundInvestAdvisorResult;
import com.codi.bus.core.resultModel.FundListResult;
import com.codi.bus.core.resultModel.FundManagerResult;
import com.codi.bus.core.resultModel.FundNetValueHistoryResult;
import com.codi.bus.core.resultModel.FundOverViewResult;
import com.codi.bus.core.resultModel.FundPerformanceResult;
import com.codi.bus.core.resultModel.FundRate;
import com.codi.bus.core.resultModel.FundSortResult;
import com.codi.bus.core.resultModel.FundStaticResult;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.FundInfoService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.StaticSH300Service;
import com.codi.bus.core.service.model.FundAssetAllocationModel;
import com.codi.bus.core.service.model.FundDiscountModel;
import com.codi.bus.core.service.model.FundDividendModel;
import com.codi.bus.core.service.model.FundInvestAdvisorFundModel;
import com.codi.bus.core.service.model.FundInvestIndustryModel;
import com.codi.bus.core.service.model.FundManagerPerformanceModel;
import com.codi.bus.core.service.model.FundModel;
import com.codi.bus.core.service.model.FundPurchaseModel;
import com.codi.bus.core.service.model.FundRedeemModel;
import com.codi.bus.core.service.model.FundSharesSplitModel;
import com.codi.bus.core.service.model.FundStatisticModel;
import com.codi.bus.core.service.model.NewsModel;
import com.codi.bus.core.service.model.ShareTypeModel;
import com.codi.bus.core.service.model.TradeLimitModel;
import com.codi.bus.core.service.util.FundUtil;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.FundOperation;
import com.codi.bus.util.HtmlUtil;
import com.codi.fundData.domain.FundAnnouncement;
import com.codi.fundData.domain.FundDetail;
import com.codi.fundData.domain.FundDividend;
import com.codi.fundData.domain.FundInvestAdvisorOutline;
import com.codi.fundData.domain.FundPersonInfo;
import com.codi.fundData.domain.FundPortifolio;
import com.codi.fundData.domain.FundSharesSplit;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.message.constant.ErrorConst;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;

/**
 * 基金数据相关接口
 * 
 * @author shi.pengyan
 * @date 2016年10月1日 上午9:59:54
 */
@Controller
@RequestMapping("fund")
public class FundController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundController.class);

    @Resource(name = "fundDetailService")
    private FundDetailService fundDetailService;

    @Resource(name = "staticSH300Service")
    private StaticSH300Service staticSH300Service;

    @Autowired
    private QueryService queryService;

    @Resource(name = "fundInfoService")
    private FundInfoService fundInfoService;

    /**
     * 查询基金详情页(总入口)
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param fundCode
     *            基金代码
     * @throws BaseAppException
     */
    @RequestMapping("detail")
    public void queryFundDetail(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "fundCode") String fundCode) throws BaseAppException {
        logger.debug("fundCode={}", fundCode);
        FundDetailResult result = null;
        result = fundDetailService.getFundDetailByFundCode(fundCode);

        if (result == null) {
            result = new FundDetailResult();
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, fundCode));
            result.setSuccess(false);
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        result.setInnerCode(null);
        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 基金概括
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param fundCode
     *            基金代码
     */
    @RequestMapping("overview")
    public void queryOverView(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "fundCode") String fundCode) {
        FundOverViewResult result = null;
        result = fundDetailService.getFundOverView(fundCode);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 基金相关公告列表
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param fundCode
     *            基金代码
     * @throws BaseAppException
     */
    @RequestMapping("announcements")
    public void queryAnnouncements(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "fundCode") String fundCode, @RequestParam(value = "pageIndex") Integer pageIndex,
            @RequestParam(value = "pageSize") Integer pageSize) throws BaseAppException {

        FundAnnouncementsResult result = new FundAnnouncementsResult();
        FundDetail fundDetail = fundDetailService.getFundDetail(fundCode);
        if (fundDetail == null) {
            ExceptionHandler.publish(ErrorConst.FUND_NOT_EXIST);
        }

        List<FundAnnouncement> list = fundDetailService.getFundAnnouncements(fundDetail.getInnerCode(), pageIndex,
                pageSize);

        result.setAnnouncements(list);
        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 获取单个基金公告
     * 
     * @param request
     *            Request
     * @param response
     *            Response
     * @param resId
     *            公告ID
     * @param resType
     *            公共类型
     */
    @RequestMapping("announcement")
    public void queryAnnouncement(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "resId") Long resId, @RequestParam(value = "resType") String resType) {
        logger.debug("resId={},resType={}", resId, resType);
        FundAnnouncementResult result = null;
        result = fundDetailService.getFundAnnouncement(resId, resType);
        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 查询基金的历史净值
     * 
     * @param request
     *            Request
     * @param response
     *            Request
     * @param fundCode
     *            基金代码
     * @throws BaseAppException
     */
    @RequestMapping("netValueHistory")
    public void queryNetValueHistory(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "fundCode") String fundCode, @RequestParam(value = "pageIndex") Integer pageIndex,
            @RequestParam(value = "pageSize") Integer pageSize) throws BaseAppException {

        FundDetail fundDetail = fundDetailService.getFundDetail(fundCode);
        if (fundDetail == null) {
            ExceptionHandler.publish(ErrorConst.FUND_NOT_EXIST);
        }

        FundNetValueHistoryResult result = fundDetailService.getFundNetValueHistory(fundDetail.getInnerCode(),
                pageIndex, pageSize, FundConst.SORT_DESC);
        result.setSuccess(true);

        result.setFundType(fundDetail.getFundType());
        result.setFundTypeCode(fundDetail.getFundTypeCode());
        result.setOriginFundType(fundDetail.getOriginFundType());
        result.setOriginFundTypeCode(fundDetail.getOriginFundTypeCode());

        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 购买须知（将费率、起单份额集成） <br>
     * 货基没有购买手续费，非货基才有购买手续费
     * 
     * @param request
     *            Request
     * @param response
     *            response
     * @param fundCode
     *            基金代码
     */
    @RequestMapping("purchaseNotice")
    public void getFundBuyNotice(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("fundCode") String fundCode) {
        logger.debug("fundCode={}", fundCode);

        FundBuyNoticeResult result = new FundBuyNoticeResult();
        SecurityProduct product = fundDetailService.getSecurityProduct(fundCode);

        if (product == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, fundCode));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 最最低持有份额
        NewsModel newsModel = queryService.getRiskLevel(fundCode);
        result.setMinHold(MoneyUtils.formatMoney(newsModel.getMinShare(), 0));

        // 份额类型
        ShareTypeModel shareTypeModel = queryService.getShareType(fundCode);

        if (shareTypeModel == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_NO_SHARE_TYPE_FIND));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        result.setShareType(shareTypeModel.getShareType());// 份额类型：a,b

        TradeLimitModel tradeLimitModel = queryService.getTradeLimit(fundCode,
                GlobalConstant.FUND_BUSIN_CODE_APPLY_BUY, shareTypeModel.getShareType(),
                GlobalConstant.CUST_TYPE_PERSONAL, GlobalConstant.CAPITAL_MODE_EPAY);
        // 最小申购
        if (tradeLimitModel != null) {
            result.setMinPurchase(MoneyUtils.formatMoney(tradeLimitModel.getMinValue(), 2));
        }

        // 赎回时最小赎回份额
        tradeLimitModel = queryService.getTradeLimit(fundCode, GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL,
                shareTypeModel.getShareType(), GlobalConstant.CUST_TYPE_PERSONAL, GlobalConstant.CAPITAL_MODE_EPAY);
        if (tradeLimitModel != null) {
            result.setMinRedeem(MoneyUtils.formatMoney(tradeLimitModel.getMinValue(), 2));
        }

        FundDetail fundDetail = fundDetailService.getFundDetail(fundCode);
        result.setFundType(fundDetail.getFundType());
        result.setFundTypeCode(fundDetail.getFundTypeCode());

        // 货基没有申购费率
        if (EqualsUtil.equals(fundDetail.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_CURRENCY)) {
            result.setSuccess(true);
            result.setErrorCode(ErrorConstant.ERROR_FUND_CURRENCY_NO_RATE);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_CURRENCY_NO_RATE));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 申购费率
        List<FundRate> applyRateList = queryService.queryFundRate(fundCode, FundOperation.Apply);
        logger.debug("applyRateList={}", applyRateList);

        // 申购费率折扣
        List<FundDiscountSetting> applyDiscountSettingList = queryService.queryFundDiscountSettings(fundCode,
                FundOperation.Apply);
        logger.debug("applyDiscountSettingList={}", applyDiscountSettingList);

        if (ListUtil.isNotEmpty(applyRateList)) {
            Collections.sort(applyRateList);// 排序

            List<FundPurchaseModel> fundPurchaseList = new ArrayList<>();
            for (int i = 0; i < applyRateList.size(); i++) {
                FundRate fundRate = applyRateList.get(i);
                // 排除机构户（大客户）
                if (EqualsUtil.equals(fundRate.getCust_type(), GlobalConstant.CUST_TYPE_ORGANIZATION)) {
                    continue;
                }
                FundPurchaseModel model = new FundPurchaseModel();

                // 份额为B的，不需要进行折扣
                if (EqualsUtil.equalsIgnoreCase(shareTypeModel.getShareType(), GlobalConstant.SHARE_TYPE_B)) {
                    model.setMinValue(fundRate.getMin_hold());
                    model.setMaxValue(fundRate.getMax_hold());
                    model.setFareRatio(MoneyUtils.calcRateToFrontEnd(fundRate.getRatio()));
                    fundPurchaseList.add(model);
                    continue;
                }

                model.setMinValue(fundRate.getMin_balance());
                model.setMaxValue(fundRate.getMax_balance());
                model.setFareRatio(MoneyUtils.calcRateToFrontEnd(fundRate.getRatio()));

                // 如果费率为0，则判断是否有【一笔交易多少钱】
                if (MoneyUtils.isZero(fundRate.getRatio())) {
                    model.setMinFare(MoneyUtils.parseRate(fundRate.getMin_fare(), 2));
                    model.setMaxFare(MoneyUtils.parseRate(fundRate.getMax_fare(), 2));
                    fundPurchaseList.add(model);
                    continue;
                }

                if (ListUtil.isNotEmpty(applyDiscountSettingList)) {
                    Collections.sort(applyDiscountSettingList); // 排序

                    List<FundDiscountModel> fundDiscountList = new ArrayList<>();

                    BigDecimal MIN = new BigDecimal(fundRate.getMin_balance());
                    BigDecimal MAX = new BigDecimal(fundRate.getMax_balance());

                    for (int j = 0; j < applyDiscountSettingList.size(); j++) {
                        FundDiscountSetting discountSetting = applyDiscountSettingList.get(j);

                        BigDecimal discountMin = new BigDecimal(discountSetting.getMin_bala());
                        BigDecimal discountMax = new BigDecimal(discountSetting.getMax_bala());
                        //
                        FundDiscountModel discountModel = new FundDiscountModel();

                        // minBalance=maxBalance=0 统一折扣
                        if (discountMin.compareTo(discountMax) == 0
                                && discountMin.compareTo(GlobalConstant.BIG_DECIMAL_0) == 0) {

                            discountModel.setMinBalanceValue(fundRate.getMin_balance());
                            discountModel.setMaxBalanceValue(fundRate.getMax_balance());
                            discountModel.setDiscount(discountSetting.getDiscount());

                            // 计算折扣后的费率
                            String ratioAfterDiscount = MoneyUtils.calcRate(fundRate.getRatio(),
                                    discountSetting.getDiscount(), discountSetting.getMin_fare_ratio());
                            discountModel.setFareRatioAfterDiscount(ratioAfterDiscount);
                            discountModel.setMinFareRatio(MoneyUtils.calcRateToFrontEnd(discountSetting
                                    .getMin_fare_ratio()));

                            fundDiscountList.add(discountModel);
                            continue;
                        }

                        int compare = MIN.compareTo(discountMin);
                        if (compare == 0 || compare == -1) {

                            compare = MAX.compareTo(discountMax);
                            discountModel.setMinBalanceValue(discountSetting.getMin_bala());
                            discountModel.setMaxBalanceValue(compare >= 0 ? discountSetting.getMax_bala() : fundRate
                                    .getMax_balance());
                            discountModel.setDiscount(discountSetting.getDiscount());

                            // 计算折扣后的费率
                            String ratioAfterDiscount = MoneyUtils.calcRate(fundRate.getRatio(),
                                    discountSetting.getDiscount(), discountSetting.getMin_fare_ratio());
                            discountModel.setFareRatioAfterDiscount(ratioAfterDiscount);
                            discountModel.setMinFareRatio(MoneyUtils.calcRateToFrontEnd(discountSetting
                                    .getMin_fare_ratio()));

                            fundDiscountList.add(discountModel);
                        } else {
                            int compareMax = MAX.compareTo(discountMax);
                            int compareMinMax = MIN.compareTo(discountMax); // 范围最小值和折扣最大值

                            if (compareMinMax > 0) {
                                discountModel.setDiscount(discountSetting.getDiscount());

                                discountModel.setMinBalanceValue(fundRate.getMin_balance());
                                discountModel.setMaxBalanceValue(compareMax >= 0 ? discountSetting.getMax_bala()
                                        : fundRate.getMax_balance());

                                // 计算折扣后的费率
                                String ratioAfterDiscount = MoneyUtils.calcRate(fundRate.getRatio(),
                                        discountSetting.getDiscount(), discountSetting.getMin_fare_ratio());
                                discountModel.setFareRatioAfterDiscount(ratioAfterDiscount);
                                discountModel.setMinFareRatio(MoneyUtils.calcRateToFrontEnd(discountSetting
                                        .getMin_fare_ratio()));

                                fundDiscountList.add(discountModel);
                            }

                        }

                    }
                    model.setDiscountList(fundDiscountList);
                }

                fundPurchaseList.add(model);
            }
            result.setFundPurchaseList(fundPurchaseList);
        }

        // 赎回
        List<FundRate> exceedRateList = queryService.queryFundRate(fundCode, FundOperation.Exceed);
        List<FundDiscountSetting> redeemDiscountSettingList = queryService.queryFundDiscountSettings(fundCode,
                FundOperation.Exceed);

        logger.debug("exceedRateList={}", exceedRateList);
        logger.debug("redeemDiscountSettingList={}", redeemDiscountSettingList);

        if (ListUtil.isNotEmpty(exceedRateList)) {
            Collections.sort(exceedRateList, new Comparator<FundRate>() {
                @Override
                public int compare(FundRate o1, FundRate o2) {
                    String min = "0", max = "0";
                    if (StringUtil.isNotEmpty(o1.getMin_hold())) {
                        min = o1.getMin_hold();
                    }
                    if (StringUtil.isNotEmpty(o2.getMax_hold())) {
                        max = o2.getMax_hold();
                    }

                    BigDecimal before = new BigDecimal(min);
                    BigDecimal after = new BigDecimal(max);
                    return before.compareTo(after);
                }
            });// 排序

            List<FundRedeemModel> redeemList = new ArrayList<>();
            for (int i = 0; i < exceedRateList.size(); i++) {
                FundRate fundRate = exceedRateList.get(i);
                // 排除机构户（大客户）
                if (EqualsUtil.equals(fundRate.getCust_type(), GlobalConstant.CUST_TYPE_ORGANIZATION)) {
                    continue;
                }
                FundRedeemModel redeemModel = new FundRedeemModel();
                redeemModel.setMinDay(fundRate.getMin_hold());
                redeemModel.setMaxDay(fundRate.getMax_hold());
                String ratioStr = fundRate.getRatio();
                if (StringUtil.isEmpty(ratioStr)) {
                    ratioStr = "0";
                }
                BigDecimal ratio = new BigDecimal(ratioStr);
                redeemModel.setFareRatio(MoneyUtils.parseRate(ratio.multiply(GlobalConstant.BIG_DECIMAL_100)));
                redeemList.add(redeemModel);
            }
            result.setFundRedeemList(redeemList);
        }

        // 赎回没有折扣 //暂不计算
        // System.out.println("---------------");
        // for (FundDiscountSetting discountSetting :
        // redeemDiscountSettingList)
        // {
        // System.out.println(discountSetting);
        // }
        // System.out.println("-------------------");

        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping(value = "/apply/fee", method = RequestMethod.GET)
    public void getFundApplyFee(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("fund_code") String fund_code, @RequestParam("balance") BigDecimal balance) {
        ResponseUtils.renderJson(request, response, queryService.getApplyFundRate(fund_code, balance), true);
    }

    @RequestMapping(value = "/exceed/fee", method = RequestMethod.GET)
    public void getFundExceed(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("fund_code") String fund_code, @RequestParam("balance") BigDecimal balance) {
        ResponseUtils.renderJson(request, response, queryService.getExceedFundRate(fund_code, balance), true);
    }

    /**
     * 查询该基金下的基金经理信息
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @param managerCode
     *            基金经理编码
     */
    @RequestMapping(value = "/manager")
    public void getFundManager(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("managerCode") String fundManagerCode) {

        FundManagerResult result = new FundManagerResult();
        Long personCode = Long.valueOf(fundManagerCode);

        // 基金经理基本信息
        FundPersonInfo personInfo = fundDetailService.getFundPersonInfo(personCode);

        if (personInfo == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FUND_MANAGER_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_MANAGER_NOT_EXIST));

            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        result.setName(personInfo.getChineseName());
        result.setGender(personInfo.getGender());
        result.setBirthDate(personInfo.getBirthDate());
        // 1-博士后，2-博士，3-硕士，4-大学本科，5-大专
        result.setEducation(personInfo.getEducation());
        // 证券从业日期
        result.setPracticeDate(personInfo.getPracticeDate());
        // 证券从业经历
        result.setExperienceTime(MoneyUtils.formatMoney(personInfo.getExperienceTime(), 1));
        result.setProQualifi(personInfo.getProQualifi());// 从业资格
        result.setBackground(personInfo.getBackground());// 背景资料

        // 基金经理业绩
        List<Map<String, Object>> fundPerfList = fundDetailService.getFundManagerPerformance(fundManagerCode, null);
        if (ListUtil.isNotEmpty(fundPerfList)) {
            List<FundManagerPerformanceModel> perfList = new ArrayList<>();
            for (Map<String, Object> map : fundPerfList) {
                FundManagerPerformanceModel perf = new FundManagerPerformanceModel();
                perf.setFundName(MapUtils.getStr(map, "ChiNameAbbr"));
                perf.setFundNameAbbr(MapUtils.getStr(map, "SecuAbbr"));
                perf.setAccessionDate(MapUtils.getDate(map, "AccessionDate"));
                perf.setDimissionDate(MapUtils.getDate(map, "DimissionDate"));
                perf.setPerformance(MoneyUtils.calcRateToFrontEnd(MapUtils.getBigDecimal(map, "Performance")));
                perf.setFundCode(MapUtils.getStr(map, "SecuCode"));
                perfList.add(perf);
            }
            result.setPerformance(perfList);
        }

        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 获取分红和拆分
     * 
     * @param request
     *            request
     * @param response
     *            resp
     * @param fundCode
     *            基金代码
     */
    @RequestMapping("dividendAndSharesSplit")
    public void getDividendAndSharesSplit(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("fundCode") String fundCode) throws BaseAppException {

        FundDividendAndSharesSplitResult result = new FundDividendAndSharesSplitResult();
        result.setSuccess(false);

        SecurityProduct product;
        product = fundDetailService.getSecurityProduct(fundCode);
        if (product == null) {
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, fundCode));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        FundDetail fundDetail = fundDetailService.getFundDetailByInnerCode(product.getInnerCode());
        if (EqualsUtil.equals(fundDetail.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_CURRENCY)) {
            result.setErrorCode(ErrorConstant.ERROR_FUND_CURRENCY_NO_SHARE);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_CURRENCY_NO_SHARE));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        Map<String, Object> param = new HashMap<String, Object>();

        PageView pageView = new PageView();
        pageView.setPageNow(1); // 页码
        pageView.setPageSize(50);

        param.put("pageView", pageView);
        param.put("innerCode", product.getInnerCode());
        param.put("ifDistributed", FundConst.FUND_DIVIDEND_DISTRIBUTE_YES);

        List<FundDividend> list = fundDetailService.getFundDividend(param);
        if (ListUtil.isNotEmpty(list)) {
            List<FundDividendModel> dividendList = new ArrayList<>(list.size());
            for (FundDividend dividend : list) {
                FundDividendModel obj = new FundDividendModel();

                if (dividend.getDividendRatioBeforeTax() != null) {
                    obj.setRatio(MoneyUtils.formatMoney(
                            dividend.getDividendRatioBeforeTax().divide(GlobalConstant.NUMBER_TEN), 4));
                }
                obj.setExecuteDate(dividend.getExecuteDate());
                obj.setExRightDate(dividend.getExRightDate());
                obj.setReDate(dividend.getReDate());
                dividendList.add(obj);
            }
            result.setDividendList(dividendList);
        }

        List<FundSharesSplit> shareList = fundDetailService.getFundSharesSplit(param);
        if (ListUtil.isNotEmpty(shareList)) {
            List<FundSharesSplitModel> sharesSplitList = new ArrayList<>(shareList.size());
            for (FundSharesSplit item : shareList) {
                FundSharesSplitModel obj = new FundSharesSplitModel();

                obj.setSplitDay(item.getSplitDay());
                if (item.getSplitRatio() != null) {
                    obj.setSplitRatio(MoneyUtils.formatMoney(item.getSplitRatio(), 4));
                }

                sharesSplitList.add(obj);
            }
            result.setSharesSplitList(sharesSplitList);
        }
        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    @RequestMapping("assetAllocation")
    public void getAssetAllocation(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "fundCode") String fundCode) {

        FundAssetAllocationResult result = new FundAssetAllocationResult();
        SecurityProduct product;
        product = fundDetailService.getSecurityProduct(fundCode);

        if (product == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMsg(ErrorConstant.ERROR_FUND_NOT_EXIST, fundCode));
            ResponseUtils.renderJson(request, response, result, true);
            return;
        }

        // 资产配置
        List<Integer> assetTypeCodes = new ArrayList<>(5);
        // 股票 、 债券 、银行存款、其他资产、 基金
        assetTypeCodes.add(FundConst.ASSET_TYPE_CODE_STOCK);
        assetTypeCodes.add(FundConst.ASSET_TYPE_CODE_BOND);
        assetTypeCodes.add(FundConst.ASSET_TYPE_CODE_BANK);
        assetTypeCodes.add(FundConst.ASSET_TYPE_CODE_OTHER);
        assetTypeCodes.add(FundConst.ASSET_TYPE_CODE_FUND);

        List<FundAssetAllocationModel> assetAllocations = fundDetailService.getFundAssetAllocation(
                product.getInnerCode(), assetTypeCodes);
        result.setAssetAllocations(assetAllocations);

        // 十大重仓
        List<FundPortifolio> portifolios = fundDetailService.getFundPortifolio(product.getInnerCode());
        result.setPortifolios(portifolios);

        // 行业分布
        List<FundInvestIndustryModel> industrys = fundDetailService.getFundInvestIndustry(product.getInnerCode());
        result.setIndustrys(industrys);

        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 基金管理人信息
     * 
     * @param request
     * @param response
     * @param investAdvisorCode
     *            基金管理人编码
     * @throws BaseException
     * @throws BaseAppException
     */
    @RequestMapping("investAdvisor")
    public void getInvestAdvisor(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "investAdvisorCode") Integer investAdvisorCode) throws BaseAppException {
        FundInvestAdvisorResult result = new FundInvestAdvisorResult();

        FundInvestAdvisorOutline investAdvisor = fundDetailService.getFundInvestAdvisorOutline(investAdvisorCode);

        result.setBackground(HtmlUtil.convert2HTML(investAdvisor.getBackground()));

        List<Map<String, Object>> fundList = fundDetailService.getFundByInvestAdvisor(investAdvisorCode, 1, 10);
        if (ListUtil.isNotEmpty(fundList)) {
            List<String> fundCodeList = new ArrayList<>(fundList.size());

            for (Map<String, Object> map : fundList) {
                fundCodeList.add(MapUtils.getStr(map, "FundCode"));
            }

            List<FundPerformanceResult> performances = fundDetailService.getFundPerformanceByBatch(fundCodeList);
            if (ListUtil.isNotEmpty(performances)) {
                List<FundInvestAdvisorFundModel> funds = new ArrayList<>(performances.size());
                for (FundPerformanceResult performance : performances) {
                    FundInvestAdvisorFundModel model = new FundInvestAdvisorFundModel();
                    model.setFundCode(performance.getFundCode());
                    model.setFundName(performance.getChiNameAbbr());
                    model.setFundNameAbbr(performance.getSecuAbbr());
                    model.setFundType(performance.getFundType());
                    model.setFundTypeCode(performance.getFundTypeCode());
                    model.setRRInSingleYear(MoneyUtils.formatMoney(performance.getRRInSingleYear(), 2));
                    funds.add(model);
                }
                result.setFunds(funds);
            }
        }

        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 基金管理人下管理的基金
     * 
     * @param request
     * @param response
     * @param investAdvisorCode
     *            基金管理人编码
     * @param pageIndex
     *            页码
     * @param pageSize
     *            记录数
     * @throws BaseAppException
     */
    @RequestMapping("investAdvisorFunds")
    public void getInvestAdvisorFunds(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "investAdvisorCode") Integer investAdvisorCode,
            @RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize)
            throws BaseAppException {

        FundInvestAdvisorResult result = new FundInvestAdvisorResult();

        List<Map<String, Object>> fundList = fundDetailService.getFundByInvestAdvisor(investAdvisorCode, pageIndex,
                pageSize);
        if (ListUtil.isNotEmpty(fundList)) {
            List<String> fundCodeList = new ArrayList<>(fundList.size());

            for (Map<String, Object> map : fundList) {
                fundCodeList.add(MapUtils.getStr(map, "FundCode"));
            }

            List<FundPerformanceResult> performances = fundDetailService.getFundPerformanceByBatch(fundCodeList);
            if (ListUtil.isNotEmpty(performances)) {
                List<FundInvestAdvisorFundModel> funds = new ArrayList<>(performances.size());
                for (FundPerformanceResult performance : performances) {
                    FundInvestAdvisorFundModel model = new FundInvestAdvisorFundModel();
                    model.setFundCode(performance.getFundCode());
                    model.setFundName(performance.getChiNameAbbr());
                    model.setFundNameAbbr(performance.getSecuAbbr());
                    model.setFundType(performance.getFundType());
                    model.setFundTypeCode(performance.getFundTypeCode());
                    model.setRRInSingleYear(MoneyUtils.formatMoney(performance.getRRInSingleYear(), 2));
                    funds.add(model);
                }
                result.setFunds(funds);
            }
        }

        result.setSuccess(true);
        ResponseUtils.renderJson(request, response, result, true);
    }

    /**
     * 获取基金表现的统计数据
     * 
     * @param request
     * @param response
     * @param fundCode
     *            基金代码
     * @param monthCount
     *            只能为1,3,6,12
     * @throws BaseAppException
     */
    @RequestMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Loggable
    public FundStaticResult getFundStaticData(@RequestParam(value = "fundCode") String fundCode,
            @RequestParam(value = "monthCount") Integer monthCount) throws BaseAppException {

        // validate param
        switch (monthCount.intValue()) {
        case 1:
        case 3:
        case 6:
        case 12:
            break;
        default:
            ExceptionHandler.publish(ErrorConst.COMMON_INVALID_PARAM);
            break;
        }

        FundDetail fundDetail = fundDetailService.getFundDetail(fundCode);
        if (fundDetail == null) {
            ExceptionHandler.publish(ErrorConst.FUND_NOT_EXIST);
        }
        Integer innerCode = fundDetail.getInnerCode();
        FundStaticResult result = new FundStaticResult();
        result.setSuccess(true);

        result.setFundCode(fundDetail.getSecurityCode());
        result.setFundType(fundDetail.getFundType());
        result.setFundTypeCode(fundDetail.getFundTypeCode());
        result.setMonthCount(monthCount);

        Date yesterday = DateUtils.addDay(new Date(), -1);

        List<FundStatisticModel> netValueList = fundDetailService.getStatisticData(innerCode, monthCount, yesterday);
        List<FundStatisticModel> sh300List = staticSH300Service.getStatisticData(monthCount, yesterday);

        result.setNetValueList(netValueList);
        result.setSh300List(sh300List);

        // 数据汇总
        // 货基不需要统计数据，
        // 只显示非货基的统计数据
        if (!EqualsUtil.equals(fundDetail.getFundTypeCode().intValue(), FundConst.FUND_TYPE_CODE_CURRENCY)) {
            result.setFundTotal(fundDetailService.getStatisticTotal(innerCode, monthCount, yesterday));
        }
        if (ListUtil.isNotEmpty(sh300List) && sh300List.size() > 1) {
            FundStatisticModel first = sh300List.get(0);
            FundStatisticModel last = sh300List.get(sh300List.size() - 1);
            if (first != null && last != null) {
                BigDecimal delta = last.getClosePrice().subtract(first.getClosePrice());
                BigDecimal ratio = delta.divide(last.getClosePrice(), 5, BigDecimal.ROUND_HALF_EVEN);
                BigDecimal ratioBigDecimal = MoneyUtils.convert2Percent(ratio, 2);
                result.setSh300Total(ratioBigDecimal);
            }
        }

        return result;
    }

    /**
     * 收益排行
     * 
     * @param fundTypeCode
     *            基金类型编码
     * @param statisType
     *            统计类型 , 0-8: 日,周,月,季,半年,一年,两年,三年,今年以来(货币类型和短期理财忽略此参数)
     * @param sort
     *            排序；0：升序；1：降序
     * @param pageIndex
     *            页码
     * @param pageSize
     *            记录数
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "sort/performance", method = RequestMethod.GET)
    @ResponseBody
    @Loggable
    public FundSortResult querySortByNetValuePerformance(
            @RequestParam(value = "fundTypeCode", defaultValue = "0") Integer fundTypeCode,
            @RequestParam(value = "statisType", defaultValue = "0") Integer statisType,
            @RequestParam(value = "sort", defaultValue = "1") Integer sort,
            @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws BaseAppException {

        switch (fundTypeCode) {
        case 0:
        case FundConst.FUND_TYPE_CODE_STOCK:
        case FundConst.FUND_TYPE_CODE_MIXIN:
        case FundConst.FUND_TYPE_CODE_BOND:
        case FundConst.FUND_TYPE_CODE_INDEX:
        case FundConst.FUND_TYPE_CODE_CURRENCY:
            // case FundConst.FUND_TYPE_CODE_GUARANTEE:保本型合并到混合类型中
        case FundConst.FUND_TYPE_CODE_QDII:
        case FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING:
            break;
        default:
            ExceptionHandler.publish(ErrorConst.COMMON_INVALID_FUND_TYPE_CODE);
            break;
        }

        boolean isCurrency = FundUtil.isCurrency(fundTypeCode);
        if ((!isCurrency) && (statisType.intValue() < 0 || statisType.intValue() > 8)) {
            logger.error("not currency fund, param sort should be in 0-8.");
            ExceptionHandler.publish(ErrorConst.COMMON_INVALID_PARAM_SORT);
        }

        FundSortResult result = new FundSortResult();
        result.setSuccess(true);

        // fundType=0,查询所有在售基金的排序（除了货基）
        // 查询出基金的InnerCodes

        List<String> fundCodes = null;
        List<FundInfo> fundInfos = null;

        if (EqualsUtil.equals(0, fundTypeCode.intValue())) {
            // 注意这里的init size, 排除货基
            List<Integer> fundTypeCodes = new ArrayList<>(7);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_STOCK);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_MIXIN);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_BOND);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_GUARANTEE);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_INDEX);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_OTHER);
            fundTypeCodes.add(FundConst.FUND_TYPE_CODE_QDII);

            fundInfos = fundInfoService.queryFundInfoByTypes(fundTypeCodes);
        } else {
            fundInfos = fundInfoService.queryFundInfoByType(fundTypeCode);
        }

        if (ListUtil.isEmpty(fundInfos)) {
            return result;
        } else {
            fundCodes = new ArrayList<>(fundInfos.size());
            for (FundInfo fund : fundInfos) {
                if (fund.getFundTypeCode() == null) {
                    logger.warn("fundCode={},fundName={} has no fund type code", fund.getFundCode(), fund.getFundName());
                    continue;
                }
                fundCodes.add(fund.getFundCode());
            }
        }

        result.setSortList(fundDetailService.getSortByNetValuePerformance(fundTypeCode, fundCodes, statisType, sort,
                pageIndex, pageSize));

        return result;
    }

    /**
     * 从恒生查询基金信息，并插入数据库
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("insertQueryInfo")
    public void insertQueryInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FundListResult result = null;
        try {

            int lastRowCount = 1;
            List<FundModel> insertFundList = new ArrayList<FundModel>();
            // 查询基金
            result = queryService.queryFunds(GlobalConstant.MAX_REQUEST_NUM, 1, lastRowCount, "1", "");
            insertFundList = result.getFunds();

            // 插入数据库
            if (insertFundList.size() > 0) {
                fundInfoService.insertFundInfo(insertFundList);
                result.setFunds(insertFundList);
            }

        } catch (BaseException exception) {
            result = new FundListResult();
            result.setSuccess(false);
            Integer errorCode = exception.getCode();
            result.setErrorCode(errorCode);
            if (StringUtil.isEmpty(result.getErrorMessage())) {
                String errorMessage = MessageUtil.getErrorMessage(errorCode, null);
                result.setErrorMessage(errorMessage);
            }
        } catch (Exception e) {
            logger.error("InsertQueryInfo - Exception:" + e.getMessage());
            result = new FundListResult();
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_SYS_EXCEPTION);
            result.setErrorMessage(MessageUtil.getErrorMessage(ErrorConstant.ERROR_SYS_EXCEPTION, null));
        }
    }

    /**
     * 调用该接口，更新已有基金的基金类型（一般仅用于线下）
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("updateFundType")
    public @ResponseBody BaseResult updateFundType(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        int updatedCount = fundInfoService.updateFundType();
        logger.error("更新已有基金：【" + updatedCount + "】只");
        return result;
    }

}
