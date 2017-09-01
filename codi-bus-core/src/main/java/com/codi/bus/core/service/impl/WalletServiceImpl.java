package com.codi.bus.core.service.impl;

import com.codi.base.exception.BaseAppException;
import com.codi.base.exception.ExceptionHandler;
import com.codi.base.util.*;
import com.codi.bus.constant.FundConst;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.dao.UserDao;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.*;
import com.codi.bus.core.service.model.*;
import com.codi.bus.core.service.util.HundsunUtils;
import com.codi.bus.core.service.util.ModelPopulateUtils;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;
import com.codi.fundData.dao.FundMMYieldPerformanceDao;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.fundData.service.FundMMYieldPerformanceService;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import com.codi.trade.service.ShareQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 快速赎回 接口实现类
 *
 * @author song-jj
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService {

    private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    @Resource(name = "fundDetailService")
    private FundDetailService fundDetailService;

    @Resource(name = "fundMMYieldPerformanceService")
    private FundMMYieldPerformanceService fundMMYieldPerformanceService;

    @Resource(name = "fundMMYieldPerformanceDao")
    private FundMMYieldPerformanceDao fundMMYieldPerformanceDao;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "queryService")
    private QueryService queryService;

    @Resource(name = "lookupService")
    private LookupService lookupService;

    @Resource(name = "shareQueryService")
    private ShareQueryService shareQueryService;

    /**
     * 最近七日的收益率
     **/
    private static final int WALLET_NET_VALUE_LIST_DAYS = 7;

    @Override
    public WalletDetailResult getWalletDetail(String token, String deviceId) throws BaseAppException {
        logger.debug("token={},deviceId={}", token, deviceId);

        // 校验fundCode是否在T0列表中
        List<Lookup> lookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
        if (ListUtil.isEmpty(lookups)) {
            logger.error("wallet init sql error, please check.");
            ExceptionHandler.publish("WALLET_INIT_SQL_ERROR");
        }

        WalletDetailResult result = new WalletDetailResult();

        String fundCode = null;
        // --------------- 和用户相关内容 begin ---------------
        // 是否有余额
        boolean hasBalance=false;

        if (StringUtil.isNotEmpty(token)) { // 有token情形；没有token时不需要要处理
            ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
            if (validateTokenResult.getSuccess()) {
                Long userId = validateTokenResult.getUserId();

                /**
                 * 统一用资产查询接口 - Shangdu Lin - 2017-01-19
                 */
                AssetsResult assetsResult = queryService.queryAssets(userId);
                if (!assetsResult.getSuccess()) {
                    String errorMsg = MessageUtil.getErrorMessage(assetsResult.getErrorCode(), null);
                    logger.warn("token={},errorMsg={}", token, errorMsg);
                } else {

                    AssetFundModel wallet = assetsResult.getWallet();
                    if (wallet != null) {
                        // 零钱
                        result.setWalletMoney(MoneyUtils.formatMoney(wallet.getTotalWorthValue(), 2));
                        // 总当日收益
                        result.setTodayIncome(MoneyUtils.formatMoney(wallet.getTotalTodayIncome(), 2));

                        if (wallet.getTotalWorthValue() != null) {
                            if (wallet.getTotalWorthValue().compareTo(GlobalConstant.BIG_DECIMAL_0) > 0) {
                                hasBalance=true;
                            }
                        }

                        fundCode = wallet.getFundCode();
                    }
                }
            } else {
                String errorMsg = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
                logger.warn("token is invalid, token={},errorMsg={}", token, errorMsg);
            }
        }
        // --------------- 和用户相关内容 end ---------------
        Lookup hitLookup = null;
        if (StringUtil.isEmpty(fundCode)) {
            for (Lookup lookup : lookups) {
                // =1 当前在用的T0
                if (EqualsUtil.equals(1, lookup.getRuleStatus().intValue())) {
                    logger.info("fundCode={} in T0 List", lookup.getRuleValue());
                    hitLookup = lookup;
                    break;
                }
            }

            if (hitLookup == null) {
                logger.error("There is no T0 Fund, please check!");
                ExceptionHandler.publish("WALLET_INVALID_FUNDCODE");
            }

            fundCode = hitLookup.getRuleValue();
        } else {
            for (Lookup lookup : lookups) {
                // =1 当前在用的T0
                if (EqualsUtil.equals(fundCode, lookup.getRuleValue())) {
                    logger.info("fundCode={} in T0 List", lookup.getRuleValue());
                    hitLookup = lookup;
                    break;
                }
            }

            if (hitLookup == null) {
                logger.error("There is no T0 Fund, please check!");
                ExceptionHandler.publish("WALLET_INVALID_FUNDCODE");
            }
        }

        // ------- 非用户相关内容 begin -----------
        SecurityProduct product = fundDetailService.getSecurityProduct(fundCode);
        if (product == null) {
            logger.error("Security Product is not exist");
            result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
            result.setSuccess(false);
            return result;
        }

        result.setFundCode(fundCode);
        result.setFundName(product.getChiName());
        result.setFundNameAbbr(product.getSecuAbbr());

        // 每日最大限额
        result.setMaxLimit(hitLookup.getComponentValue());

        // 七日年化率
        FundMMYieldPerformance perf = fundMMYieldPerformanceService.getFundMMYieldPerformance(product.getInnerCode());
        result.setLatestWeeklyYield(MoneyUtils.formatMoney(perf.getLatestWeeklyYield(), 2));// 最近7日折算年收益率（%）
        result.setTradingDay(perf.getTradingDay());

        // 最近七天的七日年化收益率(降序)
        FundNetValueHistoryResult netValueHistorys = fundDetailService.getFundNetValueHistory(product.getInnerCode(), 1,
            WALLET_NET_VALUE_LIST_DAYS, FundConst.SORT_DESC);

        if (ListUtil.isNotEmpty(netValueHistorys.getNetValueList())) {
            List<WalletDetailRateSimpleModel> latestWeeklyYieldList = new ArrayList<>(WALLET_NET_VALUE_LIST_DAYS);

            for (FundNetValueModel model : netValueHistorys.getNetValueList()) {
                WalletDetailRateSimpleModel newModel = new WalletDetailRateSimpleModel();
                newModel.setRate(model.getLatestWeeklyYield());
                newModel.setTradingDay(model.getTradingDay());
                latestWeeklyYieldList.add(newModel);
            }
            Collections.reverse(latestWeeklyYieldList); // 升序
            result.setLatestWeeklyYieldList(latestWeeklyYieldList);
        }

        // ------- 非用户相关内容 end -------------

        // 查询在售的零钱包
        Lookup lookupOnSale = null;
        for (Lookup lookup : lookups) {
            // =1 当前在用的T0
            if (EqualsUtil.equals(1, lookup.getRuleStatus().intValue())) {
                logger.info("fundCode={} in T0 List", lookup.getRuleValue());
                lookupOnSale = lookup;
                break;
            }
        }
        if (lookupOnSale != null) {
            if (EqualsUtil.equals(lookupOnSale.getRuleValue(), fundCode)) {
                result.setFundCodeOnSale(result.getFundCode());
                result.setFundNameOnSale(result.getFundName());
                result.setFundNameAbbrOnSale(result.getFundNameAbbr());
            } else {
                SecurityProduct productOnSale = fundDetailService.getSecurityProduct(lookupOnSale.getRuleValue());
                if (productOnSale == null) {
                    logger.error("Security Product is not exist");
                    result.setErrorCode(ErrorConstant.ERROR_FUND_NOT_EXIST);
                    result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
                    result.setSuccess(false);
                    return result;
                }

                result.setFundCodeOnSale(lookupOnSale.getRuleValue());
                result.setFundNameOnSale(productOnSale.getChiName());
                result.setFundNameAbbrOnSale(productOnSale.getSecuAbbr());
            }
        }

        // Shangdu Lin - 20170502 - 设置基金状态
        FundModel fundModel=queryService.queryFund(result.getFundCodeOnSale());
        if(fundModel!=null){
            // 零钱;日收益;是否能提现;是否能存入
            result.setCanBuy(fundModel.getCanBuy());
            if(hasBalance){
                // 是否能提现（不能提现场景：1.未登陆；2.未开户成功；3.当前用户没有持有宝盈货币的份额）
                result.setCanSell(fundModel.getCanSell());
            }else {
                result.setCanSell(false);
            }
        }else {
            // 如果未找到该只基金，则不能买不能卖
            result.setCanBuy(false);
            result.setCanSell(false);
        }


        // Shangdu Lin - 20170330 - 获取交易限制
        result.setLimits(queryService.queryTradeLimits(result.getFundCodeOnSale()));

        result.setSuccess(true);
        return result;
    }

    /**
     * author:wangzhenhao
     */
    @Override
    public CashChangeListResult getWalletCashChangeDetails(Long userId) {
        // T0 Funds 基金
        List<Lookup> lookups = lookupService.getLookups(RuleConstant.RULE_LOOKUP_TYPE_T0FUND);
        ShareListResult shareListResult = null;
        CashChangeListResult cashChangeListResult = new CashChangeListResult();
        List<CashChangeResult> cashChangeResults = new ArrayList<>();
        Map<String, TradeLimitModel> tradeLimitModels = new HashMap<>();

        if (ListUtil.isNotEmpty(lookups)) {
            for (Lookup lookup : lookups) {
                shareListResult = queryShareModels(userId, lookup.getRuleValue());

                if (false == shareListResult.getSuccess()) {
                    cashChangeListResult.setSuccess(false);
                    cashChangeListResult.setErrorCode(shareListResult.getErrorCode());
                    cashChangeListResult.setErrorType(shareListResult.getErrorType());

                    return cashChangeListResult;
                }

                List<ShareModel> models = shareListResult.getShares();

                for (ShareModel model : models) {
                    CashChangeResult cashChangeResult = new CashChangeResult();
                    cashChangeResult.setBankName(model.getBankName());
                    cashChangeResult.setBankAccount(model.getBankAccount());
                    cashChangeResult.setEnableShare(model.getEnableShares());
                    cashChangeResult.setTradeAccount(model.getTradeAccount());
                    cashChangeResult.setCapitalMode(model.getCapitalMode());
                    cashChangeResult.setFundCode(lookup.getRuleValue());

                    TradeLimitModel tradeLimitModel = null;
                    /**
                     * 赎回限额
                     */
                    String fastSellKey = lookup.getRuleValue() + model.getShareType() + model.getCapitalMode()
                        + GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL;
                    if (tradeLimitModels.get(fastSellKey) == null) {
                        tradeLimitModel = queryService.getTradeLimit(lookup.getRuleValue(),
                            GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL, model.getShareType(),
                            GlobalConstant.CUST_TYPE_PERSONAL, model.getCapitalMode());
                        tradeLimitModels.put(fastSellKey, tradeLimitModel);
                    } else {
                        tradeLimitModel = tradeLimitModels.get(fastSellKey);
                    }

                    if (tradeLimitModel != null) {
                        cashChangeResult.setMinHoldShares(tradeLimitModel.getMinHoldShares());
                        cashChangeResult.setMinValue(tradeLimitModel.getMinValue());
                        cashChangeResult.setMaxValueForSell(tradeLimitModel.getMaxValue());
                    } else {
                        // 如果未找到，则不返回，前端根据是否有返回来决定是否做验证限制
                        logger.warn("sell tradeLimitModel does not exist");
                    }
                    // 设置最高可快速赎回的金额
                    // 如果为空，则不返回，前端根据是否有返回来决定是否做验证限制
                    if (!StringUtil.isEmpty(lookup.getComponentValue())) {
                        // 如果转换出错，则默认为最大值，让交易成功提交，由直销系统做最后的限制
                        cashChangeResult.setMaxValueForFastSell(BigDecimalUtil
                            .ConvertToBigDecimal(lookup.getComponentValue(), new BigDecimal(Integer.MAX_VALUE)));
                    }

                    cashChangeResults.add(cashChangeResult);
                }

                cashChangeListResult.setCashChangeResults(cashChangeResults);
            }
        }
        return cashChangeListResult;
    }

    @Override
    public ShareListResult queryShareModels(Long userId, String fundCode) {
        logger.info("queryShareModels - userId=" + userId);

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

            // Step 2: 资产查询, 查询该用户下的所有份额
            Map<String, Object> map = shareQueryService.query(GlobalConstant.MAX_REQUEST_NUM, 1, 1, "", "1", "",
                fundCode, "", user.getExternalClientId(), "", "", null);

            // 查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            HundsunUtils.ConvertToList(map, list, result);

            if (!result.getSuccess()) {
                return result;
            }

            // populate
            List<ShareModel> shares = ModelPopulateUtils.populateShare(list, lookups, result);
            result.setShares(shares);

            return result;

        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, "queryShareModels - Exception:", exception);
            throw new SystemDBException("queryShareModels Failure!", exception);
        }
    }
}
