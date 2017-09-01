package com.codi.bus.core.service.impl;

import com.codi.base.util.*;
import com.codi.bus.constant.FundBusinCodeUtil;
import com.codi.bus.constant.FundConst;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.dao.*;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.WorkingDateService;
import com.codi.bus.core.service.model.*;
import com.codi.bus.core.service.model.ApplyModel.FundApplyType;
import com.codi.bus.core.service.util.BizUtils;
import com.codi.bus.core.service.util.HundsunUtils;
import com.codi.bus.core.service.util.LookupUtil;
import com.codi.bus.core.service.util.ModelPopulateUtils;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.bus.exception.SystemDBException;
import com.codi.bus.util.FundOperation;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.fcloud.ufx.hssale.query.DiscountSettingQuery;
import com.codi.fcloud.ufx.hssale.query.FixQuery;
import com.codi.fcloud.ufx.hssale.query.RateQuery;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import com.codi.trade.dto.WarningContentQueryDto;
import com.codi.trade.service.*;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

/*
 * 查询类不用记日志
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService {

    private static final Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userSessionDao")
    private UserSessionDao userSessionDao;

    @Resource(name = "shareQueryService")
    private ShareQueryService shareQueryService;

    @Resource(name = "transactionDao")
    private TransactionDao transactionDao;

    @Resource(name = "userBankDao")
    private UserBankDao userBankDao;

    @Resource(name = "fundQueryService")
    private FundQueryService fundQueryService;

    @Resource(name = "tradeApplyQueryService")
    private TradeApplyQueryService tradeApplyQueryService;

    @Resource(name = "fundDetailService")
    private FundDetailService fundDetailService;

    @Resource(name = "shareTypeQueryService")
    private ShareTypeQueryService shareTypeQueryService;

    @Resource(name = "accountBankQueryService")
    private AccountBankQueryService accountBankQueryService;

    @Resource(name = "rateQuery")
    private RateQuery rateQuery;

    @Autowired
    private DiscountSettingQuery discountSettingQuery;

    @Resource(name = "tradeConfirmQueryService")
    private TradeConfirmQueryService tradeConfirmQueryService;

    @Resource(name = "tradeLimitQueryService")
    private TradeLimitQueryService tradeLimitQueryService;

    @Resource(name = "newsQueryService")
    private NewsQueryService newsQueryService;

    @Resource(name = "accountQueryService")
    private AccountQueryService accountQueryService;

    @Resource(name = "fixQuery")
    private FixQuery fixQuery;

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    @Resource(name = "tradeOrderDao")
    private TradeOrderDao tradeOrderDao;

    @Resource(name = "nextDayQueryService")
    private NextDayQueryService nextDayQueryService;

    @Resource(name = "workingDateService")
    private WorkingDateService workingDateService;

    @Resource(name = "dividendsQueryService")
    private DividendsQueryService dividendsQueryService;

    @Autowired
    private WarningContentQueryService warningContentQueryService;

    /**
     * 交易确认查询
     *
     * @param userId
     * @param requestNum
     * @param queryFlag
     * @param beginNum
     * @param sortDirection
     * @param fundCode
     * @param businCode
     * @param beginDate
     * @param endDate
     * @param confirmFlag
     * @return
     */
    public CollectionResult<ConfirmModel> queryTradeConfirms(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
                                                             String sortDirection, String fundCode, String businCode, Date beginDate, Date endDate, String confirmFlag) {

        CollectionResult<ConfirmModel> result = new CollectionResult<>();
        try {

            // 获取用户
            User user = userDao.getEntity(userId);

            // 判断是否已开户
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            Map<String, Object> map = tradeConfirmQueryService.query(requestNum, queryFlag, beginNum, sortDirection, "", user.getExternalClientId(), DateUtils.formatDate4(beginDate), DateUtils.formatDate4(endDate), "", confirmFlag, "", fundCode, businCode, "", "", "", "", "", "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<ConfirmModel> confirms = ModelPopulateUtils.populateConfirm(list);

            result.setObjs(confirms);

            return result;

        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryTradeConfirms - Exception:", exception);
            throw new SystemDBException("queryTradeConfirms Failure!", exception);
        }
    }

    /**
     * Shangdu Lin: 查询某一用户下的某一时间段的所有交易记录, 此方法被用于计算当前交易日T0基金快速赎回限制
     *
     * @param userId
     * @param beginDate
     * @param endDate
     * @param businCode
     * @param onlyT0
     * @return
     * @throws BaseException
     */
    @Override
    public ApplyListResult queryApplys(Long userId, Date beginDate, Date endDate, String businCode, String confirmFlag,
                                       boolean onlyT0) throws BaseException {

        ApplyListResult result = new ApplyListResult();

        try {

            // 获取用户
            User user = userDao.getEntity(userId);

            // 判断是否已开户
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            String beginDateString = DateUtils.formatDate4(beginDate);
            String endDateString = DateUtils.formatDate4(endDate);
            // 查出这个用户下当前时间段所有的交易记录，包括已确认和未确认的，传ClientId
            Map<String, Object> map = tradeApplyQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", "",
                user.getExternalClientId(), beginDateString, endDateString, "", confirmFlag, "", "", businCode, "",
                "", "", "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // 交易业务名称
            List<Lookup> tradeLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_BUSINAME);
            // 银行名称
            List<Lookup> bankLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            // populate
            List<ApplyModel> applys = ModelPopulateUtils.populateApply(list, result, tradeLookups, bankLookups);
            // 只计算T0基金
            if (onlyT0) {
                List<Lookup> T0Funds = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
                Iterator<ApplyModel> iterator = applys.iterator();
                while (iterator.hasNext()) {
                    ApplyModel model = iterator.next();
                    if (!ModelPopulateUtils.isT0Fund(T0Funds, model.getFundCode())) {
                        iterator.remove();
                    }
                }
            }

            result.setSuccess(true);
            result.setApplys(applys);

            return result;

        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryApplys - Exception:", exception);
            throw new SystemDBException("queryApplys Failure!", exception);
        }
    }

    /**
     * 我的资产页面数据查询 -Shangdu Lin
     *
     * @param userId
     * @return 出参：总资产，当日收益，零钱包：{总资产，当日收益，净值日期，是否有在途}，基金：{总资产，当日收益，净值日期，是否有在途，
     * 基金数} { "success":true, "funds":[ { "assetType":1, "fundsCount":1,
     * "inTransit":false, "netValueDateString":"11-28",
     * "totalTodayIncomeString":"4.31",
     * "totalWorthValueString":"70,000.98" }, { "assetType":2,
     * "fundsCount":1, "inTransit":true, "netValueDateString":"11-28",
     * "totalTodayIncomeString":"87.82",
     * "totalWorthValueString":"505,100.37" } ],
     * "totalTodayIncomeString":"92.13",
     * "totalWorthValueString":"575,101.35" }
     * @throws BaseException
     */
    @Override
    public AssetsResult queryAssets(Long userId) throws BaseException {
        try {

            /**
             * Step 0: 验证数据
             */
            // 结果
            AssetsResult result = new AssetsResult();
            // 获取用户
            User user = userDao.getEntity(userId);

            // 判断是否已开户
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            /**
             * Step 0-1:查询当前工作日
             */
            Date currentWorkingDate = workingDateService.getWorkingDay(new Date());

            /**
             * Step 1: 资产查询
             */
            // 查询该用户下的所有份额
            Map<String, Object> map = shareQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "", "1", "", "", "",
                user.getExternalClientId(), "", "", null);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            ShareListResult shareListResult = new ShareListResult();
            List<ShareModel> shares = ModelPopulateUtils.populateShare(list, null, shareListResult);

            /**
             * Step 2: 交易记录查询
             */
            // 查出这个用户下所有的未确认的交易记录，传ClientId
            map = tradeApplyQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", "",
                user.getExternalClientId(), "", "", "", GlobalConstant.TACONFIRM_FLAG_UNCONFIRM, "", "", "", "", "",
                "", "", "");

            // 查询结果
            list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }
            // populate applys
            ApplyListResult applyListResult = new ApplyListResult();
            List<ApplyModel> applys = ModelPopulateUtils.populateApply(list, applyListResult, null, null);

            /**
             * Step 2-1: 交易确认查询
             */
            CollectionResult<ConfirmModel> collectionResult = queryTradeConfirms(userId, GlobalConstant.MAX_REQUEST_NUM, 1, 1,
                "1", "", "", currentWorkingDate, currentWorkingDate, "");
            if (!collectionResult.getSuccess()) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(collectionResult.getErrorCode());
                result.setErrorMessage(collectionResult.getErrorMessage());
                return result;
            }

            /**
             * Step 3: 获取T+0基金以及从聚源获取基金信息
             */
            // 获取T+0基金
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
            // 从聚源获取基金信息
            List<String> fundCodeList = new ArrayList<String>();
            for (ShareModel shareModel : shares) {
                fundCodeList.add(shareModel.getFundCode());
            }

            List<FundNetValueResult> fundNetValueList = null;
            boolean gliDataException = false;
            try {
                fundNetValueList = fundDetailService.getFundNetValueByBatch(fundCodeList, new Date());
            } catch (Exception ex) {
                ExceptionUtil.logError(logger, "queryAssets - fundDetailService - Exception:", ex);
                gliDataException = true;
            }

            // 如果没有找到聚源的，返回错误
            if (gliDataException || fundNetValueList == null) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
                result.setErrorCode(ErrorConstant.ERROR_GILDATA_WRONG);
                return result;
            }

            // 获取上一工作日净值
            Map<String, BigDecimal> lastNetValues = new HashedMap();
            for (FundNetValueResult netValueResult :
                fundNetValueList) {
                if (!lastNetValues.containsKey(netValueResult.getFundCode())) {
                    BigDecimal lastUnitValue = getLastUnitValue(netValueResult.getFundCode(), netValueResult.getTradingDay());
                    lastNetValues.put(netValueResult.getFundCode(), lastUnitValue);
                }
            }

            /**
             * Step 4: 计算出前后15天未确认的快速赎回的份额（如果要精确计算的话，只要算当前工作日以及上一工作日的未T+
             * 1确认的实时成功的快速赎回的份额）
             */
            Map<String, BigDecimal> fastRedeemShares = getFastRedeemSharesWithInterval(userId, new Date(),
                GlobalConstant.FAST_REDEEM_INTERVAL_DAYS_AFTER_BEFORE);
            /**
             * 当前净值日期未T+1确认实时成功的快速赎回的份额
             */
            Date netDate = ModelPopulateUtils.getNetDate(fundNetValueList, lookups);
            Map<String, BigDecimal> lastFastRedeemShares = getCurrentWorkingDayFastRedeemShares(userId, netDate, true);

            /**
             * Step 5: 计算结果值
             */
            // 计算份额，净值日期， 日收益率，万份收益
            List<AssetFundModel> funds = ModelPopulateUtils.extractFunds(shares, lookups, fundNetValueList);
            // 计算总和值，是否有在途
            // 汇总列表
            List<AssetFundModel> sumOfFunds = new ArrayList<>();
            // 零钱包 - 计算零钱包总资产和零钱包总收益
            // 零钱包资产要减去当前工作日已快速赎回的部分，因为快速赎回的部分当前工作日已经没有日收益
            AssetFundModel wallet = ModelPopulateUtils.sumOfAsset(funds, applys, lookups, true, fastRedeemShares,
                lastFastRedeemShares, null, collectionResult.getObjs(), currentWorkingDate);
            sumOfFunds.add(wallet);
            /**
             * Step 5-1: 计算累加收益
             */
             if(StringUtil.isNotEmpty(wallet.getFundCode())) {
                 // 计算红利总金额
                 BigDecimal totalDividends = sumOfDividends(user.getExternalClientId(), wallet.getFundCode());
                 // 累计收益 = 每月5号06文件中的“红利资金” + 每日05文件中的“货币基金未分配收益金额”
                 BigDecimal totalAccumIncome=MoneyUtils.add(totalDividends, wallet.getTotalUnpaidIncome());
                 wallet.setTotalAccumIncome(totalAccumIncome);
                 logger.warn("累计收益：{}，红利资金：{}，货币基金未分配收益金额：{}",totalAccumIncome,totalDividends,wallet
                     .getTotalUnpaidIncome());
             }

            // 基金
            AssetFundModel fund = ModelPopulateUtils.sumOfAsset(funds, applys, lookups, false, fastRedeemShares,
                lastFastRedeemShares, lastNetValues, collectionResult.getObjs(), currentWorkingDate);
            sumOfFunds.add(fund);
            // 总资产
            BigDecimal totalWorthValue = MoneyUtils.add(wallet.getTotalWorthValue(), fund.getTotalWorthValue());
            // 总收益
            BigDecimal totalTodayIncome = MoneyUtils.add(wallet.getTotalTodayIncome(), fund.getTotalTodayIncome());

            // 返回结果
            result.setSuccess(true);
            // 零钱包
            result.setWallet(wallet);
            // 基金
            result.setFund(fund);
            // 总资产
            result.setTotalWorthValue(totalWorthValue);
            // 当日收益
            result.setTotalTodayIncome(totalTodayIncome);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryAssets - Exception:", exception);
            throw new SystemDBException("queryAssets Failure!", exception);
        }
    }

    /**
     * 累加分红 - add by Shangdu Lin - 20170612
     * @param clientId
     * @param fundCode
     * @return
     */
    private BigDecimal sumOfDividends(String clientId, String fundCode){
        /**
         * Step 1: 分红明细查询
         */
        // 查询该用户下的所有份额
        Map<String, Object> map = dividendsQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", "", "", clientId, fundCode);

        // 查询结果
        BaseResult result=new BaseResult();
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(),result.getErrorMessage());
        }

        // populate
        BaseListResult baseListResult = new BankListResult();
        List<DividendModel> dividends = ModelPopulateUtils.populateDividend(list,baseListResult);
        if(CollectionUtils.isEmpty(dividends)){
            return null;
        }

        /**
         * Step 2: 累加分红
         */
        BigDecimal totalDividends=new BigDecimal(0);
        for (DividendModel dividend :
            dividends) {
            totalDividends=MoneyUtils.add(totalDividends,dividend.getTotalDividendBalance());
        }

        return totalDividends;
    }

    /**
     * 获取某一用户当前工作日未T+1确认实时成功的快速赎回的份额
     *
     * @param userId
     * @param currentDate
     * @return
     */
    @Override
    public Map<String, BigDecimal> getCurrentWorkingDayFastRedeemShares(Long userId, Date currentDate,
                                                                        boolean isWorkingDate) throws BaseException {
        try {

            Date beginDate = new Date();
            Date endDate = new Date();

            if (!isWorkingDate) {
                WorkingDayResult workingDaysResult = workingDateService.getWorkingDays(currentDate);
                if (!workingDaysResult.getSuccess()) {
                    throw new BaseException(workingDaysResult.getErrorCode(), workingDaysResult.getErrorMessage());
                }

                List<Date> workingDays = workingDaysResult.getWorkingDates();
                if (workingDays.size() == 0) {
                    throw new BaseException(ErrorConstant.ERROR_WORKING_DATE_NO_FIND);
                }

                beginDate = workingDays.get(0);
                endDate = workingDays.get(0);
                if (workingDays.size() > 1) {
                    endDate = workingDays.get(1);
                }
            } else {
                beginDate = currentDate;
                endDate = currentDate;
            }

            ApplyListResult applyListResult = queryApplys(userId, beginDate, endDate,
                GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL, GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS,
                true);
            if (!applyListResult.getSuccess()) {
                throw new BaseException(applyListResult.getErrorCode(), applyListResult.getErrorMessage());
            }

            return ModelPopulateUtils.getFastSellShares(applyListResult.getApplys());
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getFastRedeemShares - Exception:", exception);
            throw new SystemDBException("getFastRedeemShares Failure!", exception);
        }
    }

    /**
     * 当前净值日期的上一工作日未T+1确认实时成功的快速赎回的份额
     *
     * @param userId
     * @param currentDate
     * @return
     * @throws BaseException
     */
    @Override
    public Map<String, BigDecimal> getLastWorkingDayFastRedeemShares(Long userId, Date currentDate)
        throws BaseException {
        try {
            WorkingDayResult workingDaysResult = workingDateService.getLastWorkingDay(currentDate);
            if (!workingDaysResult.getSuccess()) {
                throw new BaseException(workingDaysResult.getErrorCode(), workingDaysResult.getErrorMessage());
            }

            Date lastWorkingDate = workingDaysResult.getLastWorkingDay();

            ApplyListResult applyListResult = queryApplys(userId, lastWorkingDate, lastWorkingDate,
                GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL, GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS,
                true);
            if (!applyListResult.getSuccess()) {
                throw new BaseException(applyListResult.getErrorCode(), applyListResult.getErrorMessage());
            }

            return ModelPopulateUtils.getFastSellShares(applyListResult.getApplys());
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getFastRedeemShares - Exception:", exception);
            throw new SystemDBException("getFastRedeemShares Failure!", exception);
        }
    }

    /**
     * 计算出前后30天未T+1确认的实时成功的快速赎回的份额 - Shangdu Lin
     * 如果要精确计算的话，只要算当前工作日以及上一工作日的未T+1确认的实时成功的快速赎回的份额
     *
     * @param userId
     * @param currentDate
     * @param interval
     * @return
     * @throws BaseException
     */
    @Override
    public Map<String, BigDecimal> getFastRedeemSharesWithInterval(Long userId, Date currentDate, Integer interval)
        throws BaseException {
        try {

            Date beginDate = DateUtils.addDay(currentDate, interval * (-1));
            Date endDate = DateUtils.addDay(currentDate, interval);

            ApplyListResult applyListResult = queryApplys(userId, beginDate, endDate,
                GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL, GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS,
                true);
            if (!applyListResult.getSuccess()) {
                throw new BaseException(applyListResult.getErrorCode(), applyListResult.getErrorMessage());
            }

            return ModelPopulateUtils.getFastSellShares(applyListResult.getApplys());
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getFastRedeemShares - Exception:", exception);
            throw new SystemDBException("getFastRedeemShares Failure!", exception);
        }
    }

    // 获取基金的风险等级
    @Override
    public NewsModel getRiskLevel(String fundCode) throws BaseException {
        logger.info("getRiskLevel - Fund Code:" + fundCode);
        try {

            // 基金的风险等级查询
            Map<String, Object> map = newsQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", fundCode, "",
                "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            BaseResult result = new BaseResult();
            // 检查转换结果
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                throw new BaseException(result.getErrorCode(), result.getErrorMessage(), result.getErrorType());
            }

            NewsModel model = new NewsModel();
            // 设置默认值
            model.setRiskLevel(-1);
            model.setMinShare(new BigDecimal(0));
            if (list != null && list.size() > 0) {
                Map<String, Object> item = list.get(0);
                String riskLevel = item.get(HSOutputParameterNames.OFUND_RISKLEVEL).toString();
                if (!StringUtil.isEmpty(riskLevel)) {
                    model.setRiskLevel(Integer.parseInt(riskLevel));
                }
                model.setMinShare(
                    BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.EN_MINSHARE).toString()));
                model.setFundType(item.get(HSOutputParameterNames.OFUND_TYPE).toString());
            } else {
                logger.error("getRiskLevel - Fund Code:" + fundCode + ", no risk level found");
            }

            return model;

        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getRiskLevel - Exception:", exception);
            throw new SystemDBException("getRiskLevel Failure!", exception);
        }
    }

    // 获取主交易账号
    @Override
    public AccountModel getMainAccount(String clientId) throws BaseException {
        logger.info("getMainAccount - client Id:" + clientId);
        try {

            // 查询TA账户信息
            Map<String, Object> map = accountQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "", "", clientId,
                "", "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            BaseResult result = new BaseResult();
            // 检查转换结果
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                throw new BaseException(result.getErrorCode(), result.getErrorMessage(), result.getErrorType());
            }

            // populate
            BaseListResult listResult = new BaseListResult();
            List<AccountModel> accounts = ModelPopulateUtils.populateAccount(list, listResult);

            for (AccountModel accountModel : accounts) {
                if (accountModel.getMainAccountFlag().equals(GlobalConstant.MAIN_ACCOUNT_FLAG_YES)) {
                    return accountModel;
                }
            }

        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getMainAccount - Exception:", exception);
            throw new SystemDBException("getMainAccount Failure!", exception);
        }

        return null;
    }

    /**
     * 查询基金的交易限制 - Shangdu Lin - 20170330
     *
     * @param fundCode
     * @return
     */
    @Override
    public List<TradeLimitModel> queryTradeLimits(String fundCode) {
        return queryTradeLimits(fundCode, null, null, null);
    }

    /**
     * 获取基金的交易限制 - Shangdu Lin - 20170330
     *
     * @param fundCode
     * @param capitalMode
     * @param businCode
     * @param customType
     * @return
     */
    @Override
    public List<TradeLimitModel> queryTradeLimits(String fundCode, String capitalMode, String businCode,
                                                  String customType) {
        // 如果没有找到份额类别，则直接返回
        ShareTypeModel shareTypeModel = getShareType(fundCode);
        if (shareTypeModel == null) {
            return null;
        }

        // 如果没传资金方式，则从字典表中获取开户时使用的资金方式
        if (StringUtil.isEmpty(capitalMode)) {
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_CAPITALMODE);
            if (CollectionUtils.isEmpty(lookups)) {
                return null;
            }

            for (Lookup item :
                lookups) {
                // 获取开户时使用的资金方式
                String flag = item.getComponentValue();
                if (flag != null && flag.equals("1")) {
                    capitalMode = item.getRuleValue();
                }
            }
        }

        //如果未找到资金方式，则直接返回
        if (StringUtil.isEmpty(capitalMode)) {
            return null;
        }

        // 如果没有配置交易类别，则默认查出所有的交易类别的交易限制
        if (StringUtil.isEmpty(businCode)) {
            businCode = "";
        }

        //如果没有传入客户类别，则默认查询个人客户的交易限制
        if (StringUtil.isEmpty(customType)) {
            customType = GlobalConstant.CUST_TYPE_PERSONAL;
        }

        TradeLimitListResult limits = queryTradeLimits(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1",
            fundCode, shareTypeModel.getShareType(), capitalMode, businCode, customType);
        if (!limits.getSuccess()) {
            return null;
        }

        return limits.getLimits();
    }

    @Override
    public TradeLimitListResult queryTradeLimits(Integer requestNum, Integer queryFlag, Integer beginNum,
                                                 String sortDirection, String fundCode, String shareType, String capitalMode, String businCode,
                                                 String customType) throws BaseException {
        logger.info(MessageFormat.format(
            "queryTradeLimits - fundCode={0}, shareType={1}, capitalMode={2}, businCode={3}, customType={4}",
            fundCode, shareType, capitalMode, businCode, customType));

        TradeLimitListResult result = new TradeLimitListResult();
        try {

            // 交易限制查询
            // 资金方式之前因为直销系统只配了柜台的交易限制，没有配易宝的交易限制，所以传了空，不限制渠道
            Map<String, Object> map = tradeLimitQueryService.query(requestNum, queryFlag, beginNum, sortDirection,
                fundCode, shareType, capitalMode, businCode, customType);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<TradeLimitModel> limits = ModelPopulateUtils.populateTradeLimit(list);

            NewsModel newsModel = getRiskLevel(fundCode);
            if (newsModel != null) {
                for (TradeLimitModel tradeLimitModel : limits) {
                    tradeLimitModel.setMinHoldShares(newsModel.getMinShare());
                }
            }

            // 新建新接口来获取银行卡的交易限额
            // 获取支行渠道对银行卡的交易限额
            /*
             * List<Lookup> lookups=lookupDao.getLookupByType(RuleConstant.
			 * RULE_LOOKUP_TYPE_EPAYBANK); List<BankLimitModel> bankLimits=new
			 * ArrayList<>(); for (Lookup lookup : lookups) { BankLimitModel
			 * model=new BankLimitModel();
			 * model.setBankName(lookup.getRuleText());
			 * model.setBankCode(lookup.getRuleValue());
			 * model.setSingleTradeLimit(BigDecimalUtil.ConvertToBigDecimal(
			 * lookup.getComponentValue(), new BigDecimal(-1)));
			 *
			 * bankLimits.add(model); }
			 */

            result.setSuccess(true);
            result.setLimits(limits);
            // result.setBankLimits(bankLimits);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryTradeLimits - Exception:", exception);
            throw new SystemDBException("queryTradeLimits Failure!", exception);
        }
    }

    // 交易限制查询
    @Override
    public TradeLimitModel getTradeLimit(String fundCode, String businCode, String shareType, String customType,
                                         String capitalMode) throws BaseException {
        logger.info(MessageFormat.format(
            "queryTradeLimits - fundCode={0}, shareType={1}, capitalMode={2}, businCode={3}, customType={4}",
            fundCode, shareType, capitalMode, businCode, customType));

        // 调用恒生接口
        // 资金方式之前因为直销系统只配了柜台的交易限制，没有配易宝的交易限制，所以传了空，不限制渠道
        Map<String, Object> map = tradeLimitQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", fundCode,
            shareType, capitalMode, businCode, customType);

        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        BaseResult result = new BaseResult();
        // 检查转换结果
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(), result.getErrorMessage(), result.getErrorType());
        }

        // populate
        List<TradeLimitModel> limits = ModelPopulateUtils.populateTradeLimit(list);

        NewsModel newsModel = getRiskLevel(fundCode);
        if (newsModel != null) {
            for (TradeLimitModel tradeLimitModel : limits) {
                tradeLimitModel.setMinHoldShares(newsModel.getMinShare());
            }
        }

        if (limits != null && limits.size() > 0) {
            return limits.get(0);
        }

        return null;
    }

    @Override
    public BaseListResult queryAccountBanks(String tradeAccount, String clientId, String capitalMode,
                                            Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection) throws BaseException {
        logger.info(MessageFormat.format("queryAccountBanks - tradeAccount={0}, clientId={1}, capitalMode={2}",
            tradeAccount, clientId, capitalMode));
        BankListResult result = new BankListResult();
        try {

            // 根据恒生银行编号获取银行名称
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);

            // 客户银行帐号查询
            Map<String, Object> map = accountBankQueryService.query(requestNum, queryFlag, beginNum, sortDirection,
                tradeAccount, clientId, capitalMode);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<BankModel> banks = ModelPopulateUtils.populateBank(list, lookups, result);

            // 获取TA账户信息
            TAListResult taListResult = queryTAAccounts(clientId);
            if (!taListResult.getSuccess()) {
                return taListResult;
            }
            List<AccountModel> accountModels = taListResult.getAccounts();

            // 获取交易账号状态Lookup
            List<Lookup> tradeAccountStatusLookup = lookupDao
                .getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_TDACCSTATUS);

            // 获取TA账号状态Lookup
            // List<Lookup> taAccountStatusLookup =
            // lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_TAACCSTATUS);

            // 过滤掉相同交易账号不同TA账号的银行卡
            Iterator<BankModel> iterator = banks.iterator();
            Map<String, String> dictionary = new HashMap<>();
            while (iterator.hasNext()) {
                BankModel model = iterator.next();
                String key = MessageFormat.format("{0}|{1}", model.getUserBankNo(), model.getCapitalMode());
                if (dictionary.containsKey(key)) {
                    iterator.remove();
                } else {
                    dictionary.put(key, key);

                    if (accountModels != null) {
                        for (AccountModel accountModel : accountModels) {
                            if (accountModel.getTradeAccount().equals(model.getTradeAccount())) {
                                model.setMainAccountFlag(accountModel.getMainAccountFlag());
                                model.setTradeAccountStatus(accountModel.getTradeAccountStatus());
                                model.setTaAccount(accountModel.getTaAccount());
                                model.setTradeAccountStatusString(LookupUtil.getText(tradeAccountStatusLookup,
                                    accountModel.getTradeAccountStatus()));
                                /*
                                 * model.setTaAccountStatus(accountModel.
								 * getTaAccountStatus());
								 * model.setTaAccountStatusString(
								 * LookupUtil.getText(taAccountStatusLookup,
								 * accountModel.getTaAccountStatus()));
								 */
                            }
                        }
                    }
                }
            }

            result.setSuccess(true);
            result.setBanks(banks);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryAccountBanks - Exception:", exception);
            throw new SystemDBException("queryAccountBanks Failure!", exception);
        }
    }

    @Override
    public ShareTypeListResult queryShareTypes(Integer requestNum, Integer queryFlag, Integer beginNum,
                                               String sortDirection, String fundCode, String fundName) throws BaseException {

        logger.info(MessageFormat.format("queryShareTypes - fundCode={0}, fundName={1}", fundCode, fundName));

        ShareTypeListResult result = new ShareTypeListResult();

        // 查询份额类别接口
        Map<String, Object> map = shareTypeQueryService.query(requestNum, queryFlag, beginNum, sortDirection, fundCode,
            fundName);

        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            return result;
        }

        List<ShareTypeModel> shareTypes = ModelPopulateUtils.populateShareType(list);

        result.setSuccess(true);
        result.setShareTypes(shareTypes);

        return result;
    }

    // 获取ShareType
    @Override
    public ShareTypeModel getShareType(String fundCode) throws BaseException {

        logger.info("getShareType - fundCode=" + fundCode);

        ShareTypeListResult result = queryShareTypes(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1", fundCode, "");
        if (!result.getSuccess()) {
            logger.error("getShareType - fundCode=" + fundCode + ", no fund type found");
            return null;
        }

        List<ShareTypeModel> shareTypes = result.getShareTypes();
        if (shareTypes != null && shareTypes.size() > 0) {
            return shareTypes.get(0);
        }

        return null;
    }

    // 查询某一笔交易
    @Override
    public ApplyModel queryApply(String applyNo) throws BaseException {
        logger.info("queryApply - applyNo=" + applyNo);

        ApplyListResult result = new ApplyListResult();

        // 查询某一笔交易
        Map<String, Object> map = tradeApplyQueryService.query(1, 1, 1, "1", "", "", "", "", applyNo, "", "", "", "",
            "", "", "", "", "");

        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            logger.warn("queryApply - applyNo=" + applyNo + ", no apply trade order found");
            return null;
        }

        // 交易业务名称
        List<Lookup> tradeLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_BUSINAME);
        // 银行名称
        List<Lookup> bankLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
        // populate
        List<ApplyModel> applys = ModelPopulateUtils.populateApply(list, result, tradeLookups, bankLookups);
        if (applys != null && applys.size() > 0) {
            return applys.get(0);
        }

        return null;
    }

    @Override
    public ApplyListResult queryApplys(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
                                       String sortDirection, boolean filterT0) throws BaseException {
        logger.info("queryApplys - userId=" + userId);

        ApplyListResult result = new ApplyListResult();
        try {

            // 获取用户
            User user = userDao.getEntity(userId);

            // 判断是否已开户
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            // 查出这个用户下所有的交易记录，包括已确认和未确认的，传ClientId
            Map<String, Object> map = tradeApplyQueryService.query(requestNum, queryFlag, beginNum, sortDirection, "",
                user.getExternalClientId(), "", "", "", "", "", "", "", "", "", "", "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // 交易业务名称
            List<Lookup> tradeLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_BUSINAME);
            // 银行名称
            List<Lookup> bankLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);
            // populate
            List<ApplyModel> applys = ModelPopulateUtils.populateApply(list, result, tradeLookups, bankLookups);
            // 把T0基金过滤掉，因为T0基金有专门的页面来显示
            if (filterT0) {
                List<Lookup> T0Funds = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
                Iterator<ApplyModel> iterator = applys.iterator();
                while (iterator.hasNext()) {
                    ApplyModel model = iterator.next();
                    if (ModelPopulateUtils.isT0Fund(T0Funds, model.getFundCode())) {
                        iterator.remove();
                    }
                }
            }

            // 从聚源获取基金信息
            List<String> fundCodeList = new ArrayList<String>();
            for (ApplyModel shareModel : applys) {
                fundCodeList.add(shareModel.getFundCode());
            }

            List<FundNetValueResult> fundNetValueList = null;
            try {
                // 获取聚源数据
                fundNetValueList = fundDetailService.getFundNetValueByBatch(fundCodeList, new Date());

            } catch (Exception ex) {
                ExceptionUtil.logError(logger, "queryApplys - fundDetailService - Exception:", ex);
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
                result.setErrorCode(ErrorConstant.ERROR_GILDATA_WRONG);
                return result;
            }

            // 如果没有找到聚源数据，则默认为空数组
            if (fundNetValueList == null) {
                fundNetValueList = new ArrayList<>();
            }

            // 判断是否有在途的交易
            boolean inTransit = false;
            for (ApplyModel model : applys) {
                // 未确认并且不能是无效扣款状态
                if (model.getTAConfirmFlag().equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)
                    && !model.getDeductStatus().equals(GlobalConstant.DEDUCT_STATUS_INVALID)) {
                    inTransit = true;
                }
                // 设置基金信息
                for (FundNetValueResult fundNetValue : fundNetValueList) {
                    if (fundNetValue == null) {
                        continue;
                    }
                    if (fundNetValue.getFundCode().equals(model.getFundCode())) {
                        model.setFundName(fundNetValue.getChiNameAbbr());
                        break;
                    }
                }
            }

            // 是否有在途的交易
            result.setInTransit(inTransit);
            result.setSuccess(true);
            result.setApplys(applys);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryApplys - Exception:", exception);
            throw new SystemDBException("queryApplys Failure!", exception);
        }
    }

    /**
     * 查询某只基金
     * @param fundCode
     * @return
     */
    @Override
    public FundModel queryFund(String fundCode){

        FundListResult result = new FundListResult();
        // 基金查询
        Map<String, Object> map = fundQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1",
            fundCode);

        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(),result.getErrorMessage(), result.getErrorType());
        }

        // populate
        List<FundModel> funds = ModelPopulateUtils.populateFund(list, result);
        if(CollectionUtils.isEmpty(funds)){
            logger.error("queryFund: Fund Code - {}, 未能找到该只基金");
            return null;
        }

        return funds.get(0);
    }

    @Override
    public FundListResult queryFunds(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
                                     String fundCode) throws BaseException {
        logger.info("queryFunds - fundCode=" + fundCode);

        FundListResult result = new FundListResult();
        try {

            // 基金查询
            Map<String, Object> map = fundQueryService.query(requestNum, queryFlag, beginNum, sortDirection, fundCode);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<FundModel> funds = ModelPopulateUtils.populateFund(list, result);

            // 获取T+0基金
            List<Lookup> T0Funds = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
            // 从聚源获取基金信息
            List<String> fundCodeList = new ArrayList<String>();
            for (FundModel model : funds) {
                // 判断是否为T0基金
                model.setIsT0(ModelPopulateUtils.isT0Fund(T0Funds, model.getFundCode()));
                // 设置基金风险等级
                NewsModel newsModel=getRiskLevel(model.getFundCode());
                model.setRiskLevel(newsModel.getRiskLevel());

                fundCodeList.add(model.getFundCode());
            }
            List<FundPerformanceResult> fundNetValueList = null;
            try {
                fundNetValueList = fundDetailService.getFundPerformanceByBatch(fundCodeList);
            } catch (Exception ex) {
                ExceptionUtil.logError(logger, "queryFunds - fundDetailService - Exception:", ex);
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
                result.setErrorCode(ErrorConstant.ERROR_GILDATA_WRONG);
                return result;
            }

            // 如果获取不到数据，则默认为空数组
            if (fundNetValueList == null) {
                fundNetValueList = new ArrayList<>();
            }

            for (FundModel model : funds) {
                // 设置基金信息
                for (FundPerformanceResult fundPerformanceResult : fundNetValueList) {
                    if (fundPerformanceResult == null) {
                        continue;
                    }
                    String tempCode = fundPerformanceResult.getFundCode();
                    if (!StringUtil.isEmpty(tempCode)) {
                        if (tempCode.equals(model.getFundCode())) {
                            // 近三月收益
                            BigDecimal recentRateInThreeMonth = fundPerformanceResult.getRRInThreeMonth();
                            if (recentRateInThreeMonth == null) {
                                recentRateInThreeMonth = new BigDecimal(0);
                            }
                            // 7日年化收益率
                            BigDecimal latestWeeklyYield = fundPerformanceResult.getLatestWeeklyYield();
                            if (latestWeeklyYield == null) {
                                latestWeeklyYield = new BigDecimal(0);
                            }

                            model.setLatestWeeklyYield(latestWeeklyYield);
                            model.setThreeMonthRate(recentRateInThreeMonth);
                            model.setFundName(fundPerformanceResult.getChiNameAbbr());
                            // 设置前端显示的基金类型
                            model.setAppFundType(fundPerformanceResult.getFundTypeCode());

                            break;
                        }
                    }
                }
                if (model.getThreeMonthRate() == null) {
                    model.setThreeMonthRate(new BigDecimal(0));
                }
                if (model.getLatestWeeklyYield() == null) {
                    model.setLatestWeeklyYield(new BigDecimal(0));
                }
            }

            // 过滤掉被排除的基金类型
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EXCLUDE_FUND_TYPE);
            Iterator<FundModel> iterator = null;
            if (ListUtil.isNotEmpty(lookups)) {
                iterator = funds.iterator();
                while (iterator.hasNext()) {
                    FundModel model = iterator.next();
                    for (Lookup lookup : lookups) {
                        String fundType = String.valueOf(model.getAppFundType());
                        if (lookup.getRuleValue().equals(fundType)) {
                            iterator.remove();
                        }
                    }
                }
            }

            // 过滤掉被排除的基金代码
            lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EXCLUDE_FUND_CODE);
            if (ListUtil.isNotEmpty(lookups)) {
                iterator = funds.iterator();
                while (iterator.hasNext()) {
                    FundModel model = iterator.next();
                    for (Lookup lookup : lookups) {
                        if (lookup.getRuleValue().equals(model.getFundCode())) {
                            iterator.remove();
                        }
                    }
                }
            }

            result.setSuccess(true);
            result.setFunds(funds);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryFunds - Exception:", exception);
            throw new SystemDBException("queryFunds Failure!", exception);
        }

    }

    /*
     * 根据交易确认的记录来算购买某个基金的本金，可以按以下来计算： Step 1:
     * 过滤出确认标记taConfirm_Flag为1和2的记录，即确认成功和部分确认的记录 Step 2:
     * 把所有确认业务编码fund_busin_code为122相加，即申购的相加 Step 3:
     * 把所有确认业务编码fund_busin_code为120相加，即认购的相加 Step 4:
     * 减去所有确认业务编码fund_busin_code为124，即减去赎回的记录
     */
    // TODO 如果有快速赎回业务，则需要另外考虑，快速赎回是钱实时到账，份额则需要申请，T+1减份额
    @Override
    public ShareListResult queryShares(Long userId, Integer requestNum, Integer queryflag, Integer beginNum,
                                       String sortDirection, boolean filterT0) throws BaseException {
        logger.info("queryShares - userId=" + userId);

        ShareListResult result = new ShareListResult();
        try {

            // Step 1: 获取用户
            User user = userDao.getEntity(userId);

            // 判断是否已开户
            if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
                result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
                return result;
            }

            // 根据恒生银行编号获取银行名称
            List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);

            // 查询当前工作日
            Date currentWorkingDate = workingDateService.getWorkingDay(new Date());

            // Step 2: 资产查询, 查询该用户下的所有份额
            Map<String, Object> map = shareQueryService.query(requestNum, queryflag, beginNum, "", sortDirection, "",
                "", "", user.getExternalClientId(), "", "", null);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<ShareModel> shares = ModelPopulateUtils.populateShare(list, lookups, result);
            // 把T0基金过滤掉，因为T0基金有专门的页面来显示
            if (filterT0) {
                List<Lookup> T0Funds = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
                Iterator<ShareModel> iterator = shares.iterator();
                while (iterator.hasNext()) {
                    ShareModel model = iterator.next();
                    if (ModelPopulateUtils.isT0Fund(T0Funds, model.getFundCode())) {
                        iterator.remove();
                    }
                }
            }

            // Step 3: 从聚源获取基金信息
            List<String> fundCodeList = new ArrayList<String>();
            for (ShareModel shareModel : shares) {
                fundCodeList.add(shareModel.getFundCode());
            }

            List<FundNetValueResult> fundNetValueList = null;
            try {
                fundNetValueList = fundDetailService.getFundNetValueByBatch(fundCodeList, new Date());
            } catch (Exception ex) {
                ExceptionUtil.logError(logger, "queryShares - fundDetailService - Exception:", ex);
                result.setSuccess(false);
                result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
                result.setErrorCode(ErrorConstant.ERROR_GILDATA_WRONG);
                return result;
            }

            // 如果没有找到聚源的，则默认为空
            if (fundNetValueList == null) {
                fundNetValueList = new ArrayList<>();
            }

            // Step 4: 从恒生获取交易确认信息
            // 入参为交易账号的话，只查询该交易账号下的交易, 如果为客户编号的话，则查询该客户编号下的所有交易账号的交易
            Map<String, Object> confirmMap = tradeConfirmQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1",
                user.getExternalClientId(), "", "");

            // 查询结果
            List<Map<String, Object>> mapList = new ArrayList<>();
            HundsunUtils.ConvertToList(confirmMap, mapList, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<ConfirmModel> confirms = ModelPopulateUtils.populateConfirm(mapList);

            // Step 5: 根据数据计算
            // 总持仓收益
            BigDecimal totalAccumIncome = new BigDecimal(0);
            // 总本金
            BigDecimal totalFundBalance = new BigDecimal(0);
            // 总资产
            BigDecimal totalWorthValue = new BigDecimal(0);
            // 总当日收益
            BigDecimal totalTodayIncome = new BigDecimal(0);
            // 保存上一工作日净值
            Map<String, BigDecimal> netValues = new HashedMap();
            for (ShareModel shareModel : shares) {

                // 更新基金
                // 设置净值默认值
                shareModel.setNetValue(new BigDecimal(0));
                // 设置今日收益默认值
                shareModel.setTodayIncome(new BigDecimal(0));
                // 设置今日收益率默认值
                shareModel.setTodayIncomeRate(new BigDecimal(0));
                // 设置基金信息
                for (FundNetValueResult fundNetValue : fundNetValueList) {
                    // 聚源没有找到该只基金
                    if (fundNetValue == null || StringUtil.isEmpty(fundNetValue.getFundCode())) {
                        continue;
                    }
                    // 以聚源的数据为准
                    if (fundNetValue.getFundCode().equals(shareModel.getFundCode())) {
                        shareModel.setFundName(fundNetValue.getChiNameAbbr());
                        shareModel.setNetValue(fundNetValue.getUnitNV());
                        shareModel.setNetValueDate(fundNetValue.getTradingDay());
                        // 设置前端显示的基金类型
                        shareModel.setAppFundType(fundNetValue.getFundTypeCode());
                        if (fundNetValue.getFundTypeCode() != null) {
                            /**
                             * Shangdu Lin - 20170419
                             * 非货币基金、货币基金：如果净值日期小于当前工作日，则不计算确认日期是当前工作日的基金份额
                             */
                            BigDecimal currentShare = shareModel.getCurrentShare();
                            if (ModelPopulateUtils.dateBefore(fundNetValue.getTradingDay(), currentWorkingDate)) {
                                BigDecimal confirmedShares = ModelPopulateUtils.getConfirmShares(confirms, shareModel
                                    .getFundCode(), currentWorkingDate);
                                currentShare = MoneyUtils.subtract(currentShare, confirmedShares);
                            }
                            if (fundNetValue.getFundTypeCode() == FundConst.FUND_TYPE_CODE_CURRENCY) {
                                // 日收益=当前份额/10000*万份之收益
                                // TODO:有申购时：日收益=当前份额/10000*万份之收益
                                // 有赎回时: 日收益=当前份额/10000*万份之收益
                                // 日收益
                                BigDecimal dailyProfit = fundNetValue.getDailyProfit();
                                if (dailyProfit == null) {
                                    dailyProfit = new BigDecimal(0);
                                    logger.error(MessageFormat.format(
                                        "queryShares-getDailyProfit is null for fund code ={0}",
                                        shareModel.getFundCode()));
                                }

                                BigDecimal todayIncome = currentShare.divide(new BigDecimal(10000), 4)
                                    .multiply(dailyProfit);
                                shareModel.setTodayIncome(todayIncome);
                                // 日收益率
                                if (shareModel.getWorthValue().compareTo(new BigDecimal(0)) > 0) {
                                    BigDecimal todayIncomeRate = todayIncome.divide(shareModel.getWorthValue(), 4);
                                    shareModel.setTodayIncomeRate(todayIncomeRate);
                                } else {
                                    shareModel.setTodayIncomeRate(new BigDecimal(0));
                                }
                                // 万份之收益
                                shareModel.setDailyProfit(dailyProfit);

                            } else {
                                // 日收益=当前基金份额*（当天净值- 前一个工作日净值）
                                // TODO:有申购时：日收益=当前基金份额*（当天净值- 前一个工作日净值）
                                // 有赎回时: 日收益=当前基金份额*（当天净值 - 前一个工作日净值）
                                // 日收益率
                                BigDecimal todayIncomeRate = fundNetValue.getNvDailyGrowthRate();
                                if (todayIncomeRate == null) {
                                    todayIncomeRate = new BigDecimal(0);
                                    logger.error(MessageFormat.format(
                                        "queryShares-getNvDailyGrowthRate is null for fund code ={0}",
                                        shareModel.getFundCode()));
                                }
                                shareModel.setTodayIncomeRate(todayIncomeRate);
                                // 日收益=当前基金份额*（当天净值- 前一个工作日净值）
                                BigDecimal lastUnitValue = new BigDecimal(0);
                                if (netValues.containsKey(shareModel.getFundCode())) {
                                    lastUnitValue = netValues.get(shareModel.getFundCode());
                                } else {
                                    lastUnitValue = getLastUnitValue(shareModel.getFundCode(), fundNetValue.getTradingDay());
                                    netValues.put(shareModel.getFundCode(), lastUnitValue);
                                }
                                BigDecimal margin = MoneyUtils.subtract(fundNetValue.getUnitNV(), lastUnitValue);
                                BigDecimal todayIncome = currentShare.multiply(margin);
                                shareModel.setTodayIncome(todayIncome);

                                logger.warn("queryShares - 基金代码:{},上一工作日净值:{},当前净值:{},当前份额:{},净值差额:{},日收益:{}",
                                    shareModel
                                        .getFundCode(),
                                    lastUnitValue, fundNetValue.getUnitNV(), currentShare, margin, todayIncome);
                            }
                        }

                        break;
                    }
                }

                // 更新最新的资产值
                // 资产=当前份额*净值
                BigDecimal netValue = shareModel.getNetValue();
                if (netValue == null) {
                    netValue = new BigDecimal(0);
                }
                BigDecimal worthValue = shareModel.getCurrentShare().multiply(netValue);
                shareModel.setWorthValue(worthValue);
                // 计算累计收益，即持仓收益
                BigDecimal accumIncome = new BigDecimal(0);
                BigDecimal confirmBalance = new BigDecimal(0);
                for (ConfirmModel confirmModel : confirms) {
                    String taConfirmFlag = confirmModel.getTAConfirmFlag();
                    String fundCode = confirmModel.getFundCode();
                    String businCode = confirmModel.getFundBusinCode();
                    // 只需要考虑成功的交易，即1-确认成功 2-部分确认
                    if (!taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_CONFIRMED)
                        && !taConfirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_PART_CONFIRMED)) {
                        continue;
                    }

                    // 认购、申购的金额相加, 赎回的金额相减
                    if (fundCode.equals(shareModel.getFundCode())) {
                        if (businCode.equals(GlobalConstant.FUND_BUSIN_CODE_CONFIRM_BUY)
                            || businCode.equals(GlobalConstant.FUND_BUSIN_CODE_CONFIRM_SUBSCRIBE_BUY)) {
                            confirmBalance = confirmBalance.add(confirmModel.getConfirmBalance());
                        } else if (businCode.equals(GlobalConstant.FUND_BUSIN_CODE_CONFIRM_SELL)) {
                            confirmBalance = confirmBalance.subtract(confirmModel.getConfirmBalance());
                        }
                    }
                }
                // 更新本金值
                shareModel.setFundBalance(confirmBalance);
                // 更新累计收益
                accumIncome = shareModel.getWorthValue().subtract(confirmBalance);
                shareModel.setAccumIncome(accumIncome);

                // 计算持仓收益率
                shareModel.setAccumIncomeRate(new BigDecimal(0));
                BigDecimal fundWorthValue = shareModel.getWorthValue();
                if (fundWorthValue != null && fundWorthValue.compareTo(new BigDecimal(0)) > 0) {
                    // 持仓收益率
                    BigDecimal accumIncomeRate = shareModel.getAccumIncome().divide(fundWorthValue, 4);
                    shareModel.setAccumIncomeRate(accumIncomeRate);
                }

                // 获取基金类型
                NewsModel newsModel = getRiskLevel(shareModel.getFundCode());
                if (newsModel != null) {
                    shareModel.setFundType(newsModel.getFundType());
                }

                totalAccumIncome = totalAccumIncome.add(shareModel.getAccumIncome());
                totalWorthValue = totalWorthValue.add(shareModel.getWorthValue());
                totalTodayIncome = totalTodayIncome.add(shareModel.getTodayIncome());
            }

            result.setSuccess(true);
            result.setShares(shares);
            result.setTotalAccumIncome(totalAccumIncome);
            result.setTotalFundBalance(totalFundBalance);
            result.setTotalTodayIncome(totalTodayIncome);
            result.setTotalWorthValue(totalWorthValue);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryShares - Exception:", exception);
            throw new SystemDBException("queryShares Failure!", exception);
        }
    }

    /**
     * 获取上一工作日的净值，getFundNetValue会找出比lastDate小的最新的净值
     * <p>
     * Shangdu Lin - 20170417
     *
     * @param fundCode
     * @param currentWorkingDate
     * @return
     */
    private BigDecimal getLastUnitValue(String fundCode, Date currentWorkingDate) {
        // 获取前一工作日的净值
        Date lastDate = DateUtils.addDay(currentWorkingDate, -1);
        FundNetValueResult result = fundDetailService.getFundNetValue(fundCode, lastDate);
        if (!result.getSuccess()) {
            throw new BaseException(ErrorConstant.ERROR_GILDATA_WRONG, result.getErrorMessage(), GlobalConstant.ERROR_TYPE_APPLICATION);
        }

        return result.getUnitNV();
    }

    @Override
    public List<FundRate> queryFundRate(String fund_code, FundOperation operation) {
        fund_code = StringUtil.blankIfNull(fund_code);
        ArrayList<FundRate> result = new ArrayList<>();
        for (Map<String, Object> rate_map : rateQuery.query(fund_code, operation.getHsCode())) {
            FundRate rate = new FundRate();
            rate.setBusin_flag((String) rate_map.get("busin_flag"));
            rate.setCust_type((String) rate_map.get("cust_type"));
            rate.setFare_type((String) rate_map.get("fare_type"));
            rate.setFund_code((String) rate_map.get("fund_code"));
            rate.setMax_balance((String) rate_map.get("max_balance"));
            rate.setMax_fare((String) rate_map.get("max_fare"));
            rate.setMax_hold((String) rate_map.get("max_hold"));
            rate.setMax_predays((String) rate_map.get("max_predays"));
            rate.setMin_balance((String) rate_map.get("min_balance"));
            rate.setMin_fare((String) rate_map.get("min_fare"));
            rate.setMin_hold((String) rate_map.get("min_hold"));
            rate.setMin_predays((String) rate_map.get("min_predays"));
            rate.setRatio((String) rate_map.get("ratio"));
            rate.setSale_type((String) rate_map.get("sale_type"));
            rate.setShare_type((String) rate_map.get("share_type"));
            rate.setZoneno((String) rate_map.get("zoneno"));
            result.add(rate);
        }
        return result;
    }

    @Override
    public List<FundDiscountSetting> queryFundDiscountSettings(String fund_code, FundOperation operation) {
        fund_code = StringUtil.blankIfNull(fund_code);
        List<Map<String, Object>> res = discountSettingQuery.query(fund_code, operation.getHsCode());
        ArrayList<FundDiscountSetting> diss = new ArrayList<>(res.size());
        for (Map<String, Object> dis : res) {
            FundDiscountSetting setting = new FundDiscountSetting();
            setting.setSuccess_type((String) dis.get("success_type"));
            setting.setTrust_way((String) dis.get("trust_way"));
            setting.setFund_busin_code((String) dis.get("fund_busin_code"));
            setting.setCust_kind((String) dis.get("cust_kind"));
            setting.setCust_type((String) dis.get("cust_type"));
            setting.setFund_code((String) dis.get("fund_code"));
            setting.setShare_type((String) dis.get("share_type"));
            setting.setBelongdate_begin((String) dis.get("belongdate_begin"));
            setting.setBelongdate_end((String) dis.get("belongdate_end"));
            setting.setDiscount((String) dis.get("discount"));
            setting.setEnd_discount((String) dis.get("end_discount"));
            setting.setOther_discount((String) dis.get("other_discount"));
            setting.setMin_bala((String) dis.get("min_bala"));
            setting.setMax_bala((String) dis.get("max_bala"));
            setting.setMin_fare_ratio((String) dis.get("min_fare_ratio"));
            diss.add(setting);
        }
        return diss;
    }

    @Override
    public FundTradeRatio getApplyFundRate(String fund_code, BigDecimal balance) {

        return this.calcFundOpeationFee(fund_code, balance, FundOperation.Apply);
    }

    @Override
    public FundTradeRatio getExceedFundRate(String fund_code, BigDecimal balance) {
        // 暂时赎回费率没有优惠
        return this.calcFundOpeationFee(fund_code, balance, FundOperation.Exceed);
    }

    private FundTradeRatio calcFundOpeationFee(String fund_code, BigDecimal balance, FundOperation operation) {

        FundRate rate = BizUtils.getMappingFundRate(this.queryFundRate(fund_code, operation), balance);
        FundTradeRatio res = new FundTradeRatio();
        if (rate == null) {
            logger.warn(
                "No related fund_rate record found according fund_code : " + fund_code + ", balance : " + balance);
            res.setSuccess(false);
            // alter by Shangdu - 20161115
            // 柜台可以不配这个费率，改成不报警 - alter by Shangdu - 20170606
            res.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            res.setErrorMessage("未找到该基金当前金额对应的费率");
            return res;
        }
        FundDiscountSetting discountSetting = BizUtils
            .getMappingFundDiscountSetting(this.queryFundDiscountSettings(fund_code, operation), balance);
        if (discountSetting == null) {
            logger.info("No discount setting for fund_code : " + fund_code + ", balance : " + balance);
        }
        res.setFund_code(fund_code);
        res.setBalance(MoneyUtils.formatMoney(balance, 2));
        res.setRatio(rate.getRatio());
        res.setMin_fare(rate.getMin_fare());
        res.setMax_fare(rate.getMax_fare());
        if (discountSetting != null) {
            res.setDiscount(discountSetting.getDiscount());
            res.setEnd_discount(discountSetting.getEnd_discount());
            res.setOther_discount(discountSetting.getOther_discount());
            res.setMin_fare_ratio(discountSetting.getMin_fare_ratio());
        }
        BigDecimal ratio = new BigDecimal(rate.getRatio());
        if (ratio.compareTo(BigDecimal.ZERO) == 0) {
            BigDecimal origin_fee = new BigDecimal(rate.getMin_fare());
            if (origin_fee.compareTo(BigDecimal.ZERO) == 0) {
                origin_fee = new BigDecimal(rate.getMax_fare());
            }
            String fee = MoneyUtils.formatMoney(origin_fee, 2);
            res.setOrigin_fee(fee);
            res.setFee(fee);
            res.setDiscount_fee(MoneyUtils.formatMoney(BigDecimal.ZERO, 2));
        } else {
            BigDecimal origin_fee = MoneyUtils.getFundApplyFee(balance, ratio);
            res.setOrigin_fee(MoneyUtils.formatMoney(origin_fee, 2));
            BigDecimal fee = MoneyUtils.getFundApplyFee(balance, BizUtils.getFundLastRatio(discountSetting, ratio));
            res.setFee(MoneyUtils.formatMoney(fee, 2));
            res.setDiscount_fee(MoneyUtils.formatMoney(origin_fee.subtract(fee), 2));
        }
        return res;
    }

    /**
     * 取得已定投的基金
     *
     * @param userId 用户Id
     * @return 定投基金列表
     */
    @Override
    public FixListResult getFixes(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
                                  String sortDirection) throws BaseException {
        logger.info("getFixes - userId=" + userId);
        try {
            // 结果
            FixListResult result = new FixListResult();
            result.setSuccess(true);

            // 查询用户信息
            User user = userDao.getEntity(userId);

            // 查询已定投基金
            Map<String, Object> map = fixQuery.query(requestNum, queryFlag, beginNum, sortDirection,
                user.getExternalClientId());

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // 返回结果
            List<String> scheduledProtocolIdList = new ArrayList<String>();
            List<FixModel> fixes = populateFix(list, scheduledProtocolIdList, result);

            // 银行信息
            if (!scheduledProtocolIdList.isEmpty()) {
                setBankInfo(scheduledProtocolIdList, fixes);
            }

            result.setFixes(fixes);
            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "getFixes - Exception:", exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }

    }

    private void setBankInfo(List<String> scheduledProtocolIdList, List<FixModel> fixes) {
        List<FixBankModel> banks = tradeOrderDao.selectBankInfoByScheduledProtocolId(scheduledProtocolIdList);
        Map<String, FixBankModel> bankMap = new HashMap<String, FixBankModel>();
        for (FixBankModel bank : banks) {
            bankMap.put(bank.getScheduledProtocolId(), bank);
        }
        // 设置银行信息
        for (FixModel fix : fixes) {
            if (!bankMap.containsKey(fix.getScheduledProtocolId())) {
                continue;
            }
            FixBankModel bank = bankMap.get(fix.getScheduledProtocolId());
            fix.setBankAccount(bank.getBankAccount()); // 银行账户
            fix.setBankName(bank.getBankName()); // 银行名称
        }
    }

    /**
     * 将取到的Map数据组装成Model对象
     *
     * @param fixMapList
     * @return
     * @throws BaseException
     */
    private List<FixModel> populateFix(List<Map<String, Object>> fixMapList, List<String> scheduledProtocolIdList,
                                       FixListResult result) throws BaseException {

        // 定投基金列表
        List<FixModel> fixes = new ArrayList<FixModel>();

        // 基金代码列表
        List<String> fundCodes = new ArrayList<String>();

        for (Map<String, Object> item : fixMapList) {
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(0l);
            } else {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return fixes;
            }

            String fixState = item.get(HSOutputParameterNames.FIX_STATE).toString();// 定投状态
            // 状态是终止的，过滤掉
            /*
             * if (GlobalConstant.FIX_STATE_STOP.equals(fixState)) { continue; }
			 */

            FixModel model = new FixModel();
            // 金额
            model.setBalance(BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.BALANCE).toString()));

            // 基金代码
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            fundCodes.add(model.getFundCode());
            // 协议周期单位
            model.setProtocolPeriodUnit(item.get(HSOutputParameterNames.PROTOCOL_PERIOD_UNIT).toString());

            Long protocolFixDay = Long.parseLong(item.get(HSOutputParameterNames.PROTOCOL_FIX_DAY).toString());
            // 如果协议周期单位是周，需要减1（恒生那边周一的值是2开始的）
            if (GlobalConstant.PROTOCOL_PERIOD_UNIT_WEEK.equals(model.getProtocolPeriodUnit())) {
                protocolFixDay = protocolFixDay - 1;
            }
            // 定投交易日
            model.setProtocolFixDay(protocolFixDay);

            // 累计确认金额
            model.setTotalCfmBala(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.TOTAL_CFM_BALA).toString()));
            // 定投协议号
            model.setScheduledProtocolId(item.get(HSOutputParameterNames.SCHEDULED_PROTOCOL_ID).toString());

            // 终止日期
            model.setExpiryDate(item.get(HSOutputParameterNames.EXPIRY_DATE).toString());

            // 协议状态
            model.setFixState(fixState);
            // 资金方式（支付方式）
            model.setCapitalMode(item.get(HSOutputParameterNames.CAPITAL_MODE).toString());

            // 下次扣款日期
            String nextFixDate = item.get(HSOutputParameterNames.NEXT_FIX_REQUEST_DATE).toString();
            // 将日期转换成YYYY-MM-DD
            model.setNextFixRequestDate(DateUtils.String8ToDateStr(nextFixDate));

            scheduledProtocolIdList.add(model.getScheduledProtocolId());
            fixes.add(model);
        }

        if (scheduledProtocolIdList.isEmpty()) {
            return fixes;
        }

        // 产品
        List<SecurityProduct> products = fundDetailService.getSecurityProducts(fundCodes);
        // 将列表转换为Map
        Map<String, String> codeMap = ModelPopulateUtils.convertProductsToMap(products);

        // 根据code取得基金名称
        for (FixModel model : fixes) {
            if (codeMap.containsKey(model.getFundCode())) {
                // 设置名称
                model.setFundName(codeMap.get(model.getFundCode()));
            }
        }

        return fixes;
    }

    @Override
    public TAListResult queryTAAccounts(String clientId) throws BaseException {
        logger.info("queryTAAccounts - client Id:" + clientId);

        TAListResult result = new TAListResult();
        try {

            // 查询TA账户信息
            Map<String, Object> map = accountQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "", "", clientId,
                "", "", "");

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);
            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<AccountModel> accounts = ModelPopulateUtils.populateAccount(list, result);

            result.setSuccess(true);
            result.setAccounts(accounts);

            return result;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryTAAccounts - Exception:", exception);
            throw new SystemDBException("queryTAAccounts Failure!", exception);
        }
    }

    /**
     * 获取用户的零钱包交易记录, 主要逻辑如下: 1, 检查用户是否开户 2, 获取请求数量的用户交易记录 3, 根据基金代码过滤,
     * 去掉非T0基金的交易记录, 去掉T0基金的非发生实际金额变动的零钱包交易记录(例如定投协议签约修改取消) 4,
     * 给返回的ApplyModel设置上fundType, 表明这是T0基金
     *
     * @author hzren
     * @since pangu003
     */
    @Override
    public ApplyListResult queryWalletOperationList(Long userId, Integer requestNum, Integer queryFlag,
                                                    Integer beginNum, String sortDirection) {
        Assert.notNull(userId);
        // 获取用户
        User user = userDao.getEntity(userId);
        ApplyListResult result = new ApplyListResult();
        // 判断是否已开户
        if (user == null || StringUtil.isEmpty(user.getExternalClientId())) {
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_NO_ACCOUNT);
            result.setErrorMessage(MessageUtil.getErrorMsg(result.getErrorCode()));
            return result;
        }
        // 查出这个用户下所有的交易记录，包括已确认和未确认的，传ClientId
        Map<String, Object> map = tradeApplyQueryService.query(requestNum, queryFlag, beginNum, sortDirection, "",
            user.getExternalClientId(), "", "", "", "", "", "", "", "", "", "", "", "");
        // 检查查询结果是否OK
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            return result;
        }
        // 银行名称
        List<Lookup> bankLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_HSBANK);

        final Set<String> t0fundCodeSet = CollectionsUtils.newSet(
            lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND), new Function<Lookup, String>() {
                @Override
                public String apply(Lookup input) {
                    return input.getRuleValue();
                }
            });

        List<Lookup> businLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_BUSINAME);
        // populate
        List<ApplyModel> applys = ModelPopulateUtils.populateApply(list, result, businLookups, bankLookups);
        // 过滤非T0基金, 并修改T0基金fundBusinCode 为T0申购代码
        org.apache.commons.collections.CollectionUtils.filter(applys, new Predicate() {

            @Override
            public boolean evaluate(Object object) {
                ApplyModel am = (ApplyModel) object;
                String fundCode = am.getFundCode();
                if (!t0fundCodeSet.contains(fundCode)) {
                    return false;
                }
                String businCode = am.getFundBusinCode();
                if (FundBusinCodeUtil.isBuy(businCode) || FundBusinCodeUtil.isSell(businCode)) {
                    return true;
                }
                return false;
            }
        });
        // 设置rowCount和totalCount
        result.setRowCount(Long.valueOf(applys.size()));
        result.setTotalCount(Long.valueOf(applys.size()));
        // 按日期倒叙排序
        Collections.sort(applys, new Comparator<ApplyModel>() {

            @Override
            public int compare(ApplyModel o1, ApplyModel o2) {
                String o1No = o1.getAllotNo(), o2No = o2.getAllotNo();
                if (o1No.length() < o2No.length()) {
                    return 1;
                } else if (o1No.length() > o2No.length()) {
                    return -1;
                }
                return 0 - o1No.compareTo(o2No);
            }
        });

        List<FundNetValueResult> fundNetValueList = fundDetailService
            .getFundNetValueByBatch(Lists.newArrayList(t0fundCodeSet), new Date());
        // 如果没有找到聚源数据，则默认为空数组
        if (fundNetValueList == null) {
            fundNetValueList = new ArrayList<>();
        }

        // 判断是否有在途的交易
        boolean inTransit = false;
        for (ApplyModel model : applys) {
            // 渲染模式为T0基金
            model.setFundType(FundApplyType.T0);
            // 未确认并且不能是无效扣款状态
            if (model.getTAConfirmFlag().equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)
                && !model.getDeductStatus().equals(GlobalConstant.DEDUCT_STATUS_INVALID)) {
                inTransit = true;
            }
            // 设置基金信息
            for (FundNetValueResult fundNetValue : fundNetValueList) {
                if (fundNetValue == null) {
                    continue;
                }
                if (fundNetValue.getFundCode().equals(model.getFundCode())) {
                    model.setFundName(fundNetValue.getChiNameAbbr());
                    break;
                }
            }
        }
        // 是否有在途的交易
        result.setInTransit(inTransit);
        result.setSuccess(true);
        result.setApplys(applys);
        return result;
    }

    /**
     * 查询警示内容
     * @return
     */
    @Override
    public List<WarningModel> queryWarnings(){
        // Step 1: 查询警示内容
        WarningContentQueryDto dto=new WarningContentQueryDto();
        dto.setRequest_num(GlobalConstant.MAX_REQUEST_NUM);
        dto.setWarning_channel(GlobalConstant.WARNING_CHANNEL_APP);
        // 启用
        dto.setWarning_state("1");
        Map<String, Object> map = warningContentQueryService.query(dto);
        // 查询结果
        BaseListResult result=new BaseListResult();
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(), result.getErrorMessage());
        }

        return ModelPopulateUtils.populateWarnings(list,result);
    }
}
