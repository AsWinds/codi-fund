package com.codi.bus.core.service.util;

import com.codi.base.util.*;
import com.codi.bus.constant.FundConst;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.impl.QueryServiceImpl;
import com.codi.bus.core.service.model.*;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.IdCardUtil;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.message.constant.ErrorConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

public class ModelPopulateUtils {

    private static final Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

    /**
     * populate 份额查询
     *
     * @param list
     * @param lookups
     * @param result
     * @return
     */
    public static List<ShareModel> populateShare(List<Map<String, Object>> list, List<Lookup> lookups,
                                                 ShareListResult result) {
        List<ShareModel> shares = new ArrayList<>();
        for (Map<String, Object> item : list) {
            ShareModel model = new ShareModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return shares;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            model.setAutoBuy(item.get(HSOutputParameterNames.AUTO_BUY).toString());
            model.setAvailableDueShare(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.AVAILABLE_DUE_SHARE).toString()));
            model.setBankAccount(item.get(HSOutputParameterNames.BANK_ACCOUNT).toString());
            model.setBusinessFrozenAmount(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.BUSINESS_FROZEN_AMOUNT).toString()));
            model.setCapitalMode(item.get(HSOutputParameterNames.CAPITAL_MODE).toString());
            model.setCurrentShare(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.CURRENT_SHARE).toString()));
            model.setEnableShares(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.ENABLE_SHARES).toString()));
            model.setExcetransInTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.EXCETRANS_IN_TOTAL_QUOTA).toString()));
            model.setExcetransOutTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.EXCETRANS_OUT_TOTAL_QUOTA).toString()));
            model.setTradeAccount(item.get(HSOutputParameterNames.TRADE_ACCO).toString());
            model.setFrozenShare(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.FROZEN_SHARE).toString()));
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setQuickExceedEnableShare(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.QUICK_EXCEED_ENABLE_SHARE).toString()));

            model.setShareType(item.get(HSOutputParameterNames.SHARE_TYPE).toString());
            model.setTodayApplyTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TODAY_APPLY_TOTAL_QUOTA).toString()));
            model.setTodayExceedTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TODAY_EXCEED_TOTAL_QUOTA).toString()));
            /*
             * model.setTodayIncome(
			 * BigDecimalUtil.ConvertToBigDecimal(item.get(
			 * HSOutputParameterNames.TODAY_INCOME).toString()));
			 */
            model.setTodayTransinTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TODAY_TRANSIN_TOTAL_QUOTA).toString()));
            model.setTodayTransoutTotalQuota(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TODAY_TRANSOUT_TOTAL_QUOTA).toString()));
            model.setUnpaidIncome(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.UNPAID_INCOME).toString()));
            model.setWorthValue(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.WORTH_VALUE).toString()));

            // 累计收益 - add by Shangdu Lin - 20170531
            model.setAccumIncome(BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.ACCUM_INCOME).toString()));

            String bankNo = item.get(HSOutputParameterNames.BANK_NO).toString().trim();
            if (lookups != null) {
                for (Lookup lookup : lookups) {
                    if (lookup.getRuleValue().equals(bankNo)) {
                        model.setBankCode(lookup.getComponentValue());
                        model.setBankName(lookup.getRuleText());
                        break;
                    }
                }
            }

            // 如果资产为0 && 当前份额为0 && 可用份额为0， 则不显示
            if (model.getWorthValue().compareTo(new BigDecimal(0)) == 0
                && model.getCurrentShare().compareTo(new BigDecimal(0)) == 0
                && model.getEnableShares().compareTo(new BigDecimal(0)) == 0) {
                continue;
            }

            shares.add(model);
        }

        return shares;
    }

    /**
     * populate TA账户信息
     *
     * @param list
     * @param result
     * @return
     */
    public static List<AccountModel> populateAccount(List<Map<String, Object>> list, BaseListResult result) {

        List<AccountModel> accounts = new ArrayList<>();
        for (Map<String, Object> item : list) {
            AccountModel model = new AccountModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return accounts;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }
            model.setClientId(item.get(HSOutputParameterNames.CLIENT_ID).toString());
            model.setMainAccountFlag(item.get(HSOutputParameterNames.MAIN_ACCOUNT_FLAG).toString());
            model.setTradeAccount(item.get(HSOutputParameterNames.TRADE_ACCO).toString());
            // 交易账号状态
            model.setTradeAccountStatus(item.get(HSOutputParameterNames.TRANS_ACCT_STATUS).toString());
            // TA账号状态
            model.setTaAccountStatus(item.get(HSOutputParameterNames.FUND_ACCT_STATUS).toString());
            // TA账号
            model.setTaAccount(item.get(HSOutputParameterNames.TA_ACCO).toString());

            accounts.add(model);
        }

        return accounts;
    }

    /**
     * populate 交易限制信息
     *
     * @param list
     * @return
     */
    public static List<TradeLimitModel> populateTradeLimit(List<Map<String, Object>> list) {
        List<TradeLimitModel> limits = new ArrayList<>();
        for (Map<String, Object> item : list) {
            TradeLimitModel model = new TradeLimitModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                model.setRowCount(Long.parseLong(rowCount));
            } else {
                return limits;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                model.setTotalCount(Long.parseLong(totalCount));
            }

            model.setFundBusinCode(item.get(HSOutputParameterNames.FUND_BUSIN_CODE).toString());
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setMaxValue(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.MAX_VALUE).toString()));
            model.setMinValue(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.MIN_VALUE).toString()));
            model.setSecondMin(
                BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.SECOND_MIN).toString()));
            model.setShareType(item.get(HSOutputParameterNames.SHARE_TYPE).toString());

            limits.add(model);
        }

        return limits;
    }

    /**
     * populate 交易确认信息
     *
     * @param list
     * @return
     */
    public static List<ConfirmModel> populateConfirm(List<Map<String, Object>> list) {
        List<ConfirmModel> confirms = new ArrayList<>();
        for (Map<String, Object> item : list) {
            ConfirmModel model = new ConfirmModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                model.setRowCount(Long.parseLong(rowCount));
            } else {
                return confirms;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                model.setTotalCount(Long.parseLong(totalCount));
            }

            // 本金
            model.setConfirmBalance(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TRADE_CONFIRM_BALANCE).toString()));
            model.setFundBusinCode(item.get(HSOutputParameterNames.FUND_BUSIN_CODE).toString());
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setTAConfirmFlag(item.get(HSOutputParameterNames.TACONFIRM_FLAG).toString());
            model.setTradeAcco(item.get(HSOutputParameterNames.TRADE_ACCO).toString());
            // 交易确认份额
            model.setConfirmShares(BigDecimalUtil
                .ConvertToBigDecimal(item.get(HSOutputParameterNames.TRADE_CONFIRM_TYPE).toString()));
            model.setAffirmDate(item.get(HSOutputParameterNames.AFFIRM_DATE).toString());

            confirms.add(model);
        }

        return confirms;
    }

    /**
     * populate 银行卡信息
     *
     * @param list
     * @param lookups
     * @param result
     * @return
     */
    public static List<BankModel> populateBank(List<Map<String, Object>> list, List<Lookup> lookups,
                                               BaseListResult result) {
        List<BankModel> banks = new ArrayList<>();
        for (Map<String, Object> item : list) {

            BankModel model = new BankModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return banks;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            // 从Lookup获取银行简称和银行名称
            String bankNo = item.get(HSOutputParameterNames.BANK_NO).toString();
            if (lookups != null) {
                for (Lookup lookup : lookups) {
                    if (lookup.getRuleValue().equals(bankNo)) {
                        model.setBankCode(lookup.getComponentValue());
                        model.setBankName(lookup.getRuleText());
                        break;
                    }
                }
            }
            model.setUserBankNo(item.get(HSOutputParameterNames.BANK_ACCOUNT).toString());
            model.setCapitalMode(item.get(HSOutputParameterNames.CAPITAL_MODE).toString());
            // 交易账号
            model.setTradeAccount(item.get(HSOutputParameterNames.TRADE_ACCO).toString());

            banks.add(model);
        }

        return banks;
    }

    /**
     * populate 份额类别
     *
     * @param list
     * @return
     */
    public static List<ShareTypeModel> populateShareType(List<Map<String, Object>> list) {
        List<ShareTypeModel> shareTypes = new ArrayList<>();
        for (Map<String, Object> item : list) {
            ShareTypeModel model = new ShareTypeModel();

            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                model.setRowCount(Long.parseLong(rowCount));
            } else {
                return shareTypes;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                model.setTotalCount(Long.parseLong(totalCount));
            }

            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setFundName(item.get(HSOutputParameterNames.FUND_NAME).toString());
            model.setFundStatus(item.get(HSOutputParameterNames.FUND_STATUS).toString());
            model.setFundType(item.get(HSOutputParameterNames.OFUND_TYPE).toString());
            model.setShareType(item.get(HSOutputParameterNames.SHARE_TYPE).toString());

            shareTypes.add(model);
        }

        return shareTypes;
    }

    /**
     * populate 交易申请
     *
     * @param list
     * @param result
     * @param tradeLookups
     * @param bankLookups
     * @return
     */
    public static List<ApplyModel> populateApply(List<Map<String, Object>> list, ApplyListResult result,
                                                 List<Lookup> tradeLookups, List<Lookup> bankLookups) {
        List<ApplyModel> applys = new ArrayList<>();
        for (Map<String, Object> item : list) {
            ApplyModel model = new ApplyModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return applys;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            // 过滤掉撤单申请交易
            model.setFundBusinCode(item.get(HSOutputParameterNames.FUND_BUSIN_CODE).toString());
            if (model.getFundBusinCode().equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_UNDO)) {
                continue;
            }

            model.setAllotNo(item.get(HSOutputParameterNames.ALLOT_NO).toString());
            model.setBalance(BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.BALANCE).toString()));
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setOrderDate(item.get(HSOutputParameterNames.ORIGINAL_DATE).toString());
            model.setOrderTime(item.get(HSOutputParameterNames.ORDER_DATE).toString());
            model.setDeductStatus(item.get(HSOutputParameterNames.DEDUCT_STATUS).toString());
            model.setTAConfirmFlag(item.get(HSOutputParameterNames.TACONFIRM_FLAG).toString());
            // model.setFundBusinCode(item.get(HSOutputParameterNames.FUND_BUSIN_CODE).toString());
            model.setTradeAcco(item.get(HSOutputParameterNames.TRADE_ACCO).toString());
            model.setSendFlag(item.get(HSOutputParameterNames.SEND_FLAGS).toString());
            model.setApplyDate(item.get(HSOutputParameterNames.APPLY_DATE).toString());
            model.setShares(BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames.SHARES).toString()));
            // 恒生代码
            model.setBankHSCode(item.get(HSOutputParameterNames.BANK_NO).toString());

            // 设置交易业务名称
            if (tradeLookups != null) {
                for (Lookup lookup : tradeLookups) {
                    if (lookup.getRuleValue().equals(model.getFundBusinCode())) {
                        model.setFundBusinName(lookup.getRuleText());
                        break;
                    }
                }
            }

            // 设置银行名称
            if (bankLookups != null) {
                for (Lookup lookup : bankLookups) {
                    if (lookup.getRuleValue().equals(model.getBankHSCode())) {
                        model.setBankName(lookup.getRuleText());
                        break;
                    }
                }
            }

            applys.add(model);
        }

        return applys;
    }

    /**
     * populate 基金查询
     *
     * @param list
     * @param result
     * @return
     */
    public static List<FundModel> populateFund(List<Map<String, Object>> list, FundListResult result) {
        List<FundModel> funds = new ArrayList<>();
        for (Map<String, Object> item : list) {
            FundModel model = new FundModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return funds;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setFundName(item.get(HSOutputParameterNames.FUND_NAME).toString());
            model.setFundStatus(item.get(HSOutputParameterNames.FUND_STATUS).toString());
            model.setTANo(item.get(HSOutputParameterNames.TA_NO).toString());
            model.setFundType(item.get(HSOutputParameterNames.OFUND_TYPE).toString());

            funds.add(model);
        }

        return funds;
    }

    /**
     * 计算 总资产，总当日收益，最新净值日期，是否有在途
     *
     * @param funds
     * @param applys
     * @param lookups
     * @param needT0
     * @param fastRedeemShares
     * @param lastFastRedeemShares
     * @return
     */
    public static AssetFundModel sumOfAsset(List<AssetFundModel> funds, List<ApplyModel> applys, List<Lookup> lookups,
                                            boolean needT0, Map<String, BigDecimal> fastRedeemShares, Map<String, BigDecimal> lastFastRedeemShares,
                                            Map<String, BigDecimal> lastNetValues, Collection<ConfirmModel> confirms, Date
                                                currentWorkingDate) {
        // 同个基金的汇总
        Map<String, AssetFundModel> fundSums = new HashMap<>();
        // 最新的净值日期
        Date lastNetDate = null;
        // 基金代码
        String fundCode = null;
        // 计算总和
        for (AssetFundModel model : funds) {
            // 是否是T0基金
            boolean isT0 = model.getAssetType() == GlobalConstant.ASSET_TYPE_WALLET;
            if (needT0 && !isT0) {
                continue;
            }

            if (!needT0 && isT0) {
                continue;
            }

            // 基金代码
            fundCode = model.getFundCode();
            // 每个fundCode, 一个AssetFundModel
            if (!fundSums.containsKey(fundCode)) {
                fundSums.put(fundCode, model);
            } else {
                AssetFundModel innerFund = fundSums.get(fundCode);
                // 累加当前份额
                innerFund.setCurrentShares(MoneyUtils.add(innerFund.getCurrentShares(), model.getCurrentShares()));
                // 累加累计收益, 一个fundCode, 一个AssetFundModel - add by Shangdu Lin - 20170531
                // innerFund.setAccumIncome(MoneyUtils.add(innerFund.getAccumIncome(),model.getAccumIncome()));
                // 累加未付收益 - add by Shangdu Lin - 20170612
                innerFund.setUnpaidIncome(MoneyUtils.add(innerFund.getUnpaidIncome(), model.getUnpaidIncome()));
            }

            // 设置最新净值日期
            Date netDate = model.getNetValueDate();
            if (lastNetDate == null) {
                lastNetDate = netDate;
            } else {
                // 如果比当前净值日期大，则用大的
                if (lastNetDate.before(netDate)) {
                    lastNetDate = netDate;
                }
            }
        }

        /**
         * Shangdu Lin - 20170419
         * 非货币基金、货币基金：如果净值日期小于当前工作日，则应确认日期是当前工作日的基金份额
         */
        if (!CollectionUtils.isEmpty(confirms)) {
            for (Map.Entry<String, AssetFundModel> entry : fundSums.entrySet()) {
                AssetFundModel model = entry.getValue();
                if (dateBefore(model.getNetValueDate(), currentWorkingDate)) {
                    BigDecimal confirmedShares = getConfirmShares(confirms, model.getFundCode(), currentWorkingDate);
                    model.setCurrentSharesWithoutTodayConfirmed(MoneyUtils.subtract(model.getCurrentShares(), confirmedShares));
                }
            }
        }

        // 如果是T0, 先减掉快速赎回的份额
        // 计算总资产值和总日收益
        BigDecimal totalWorthValue = null;
        BigDecimal totalTodayIncome = null;
        //累计收益 - add by Shangdu Lin - 20170531
        //BigDecimal totalAccumIncome=null;
        // 未付收益 - add by Shangdu Lin - 20170612
        BigDecimal totalUnpaidIncome = null;
        for (Map.Entry<String, AssetFundModel> entry : fundSums.entrySet()) {
            AssetFundModel model = entry.getValue();
            BigDecimal currentShares = model.getCurrentShares();
            BigDecimal currentSharesWithoutLastT0 = model.getCurrentSharesWithoutTodayConfirmed();
            // 如果当前工作日没有待确认的份额，则使用当前份额
            if (currentSharesWithoutLastT0 == null) {
                currentSharesWithoutLastT0 = model.getCurrentShares();
            }
            // 当前份额减掉快速赎回的份额
            if (needT0 && fastRedeemShares.containsKey(entry.getKey())) {
                currentShares = MoneyUtils.subtract(currentShares, fastRedeemShares.get(entry.getKey()));
            }

            // 当前份额减掉当前净值日期的快速赎回的份额，当前净值日期为上一工作日， 因为上一工作日的快速赎回的份额不会有日收益
            if (needT0 && lastFastRedeemShares.containsKey(entry.getKey())) {
                currentSharesWithoutLastT0 = MoneyUtils.subtract(currentSharesWithoutLastT0,
                    lastFastRedeemShares.get(entry.getKey()));
            }

            // Shangdu Lin - 20170502
            // 4舍5入后再相加
            // why:因为在我的资产页，各个基金是分开显示的，而且每个基金都会显示资产，每个资产是4舍5入的，且基于此就算出总资产并显示
            // 资产=份额*净值
            BigDecimal worthValue = currentShares.multiply(model.getNetValue());
            worthValue = worthValue.setScale(2, BigDecimal.ROUND_HALF_UP);
            totalWorthValue = MoneyUtils.add(totalWorthValue, worthValue);
            //累计收益, 只有货币基金的累计收益有值，非货币基金的累计收益接口不会返回 - add by Shangdu Lin - 20170531
            //totalAccumIncome=MoneyUtils.add(totalAccumIncome,model.getAccumIncome());
            // 未付收益 - add by Shangdu Lin - 20170612
            totalUnpaidIncome = MoneyUtils.add(totalUnpaidIncome, model.getUnpaidIncome());

            BigDecimal todayIncome = null;
            if (model.getIsCurrency()) {
                // 万份收益
                todayIncome = currentSharesWithoutLastT0.divide(new BigDecimal(10000), 4)
                    .multiply(model.getDailyProfit());
            } else {
                // 日收益=当前基金份额*（当天净值- 前一个工作日净值）
                BigDecimal lastUnitValue = lastNetValues.get(model.getFundCode());
                BigDecimal margin = MoneyUtils.subtract(model.getNetValue(), lastUnitValue);
                todayIncome = currentSharesWithoutLastT0.multiply(margin);

                logger.warn("sumOfAsset - 基金代码:{},上一工作日净值:{},当前净值:{},当前份额:{},净值差额:{},日收益:{}", model.getFundCode(),
                    lastUnitValue, model.getNetValue(), currentSharesWithoutLastT0, margin, todayIncome);
            }

            // 4舍5入后再相加
            // why:因为在我的资产页，各个基金是分开显示的，而且每个基金都会显示当日收益，每个当日收益是4舍5入的，且基于此就算出总收益并显示
            // 所以这里算法需保持一致才能显示一致
            todayIncome = todayIncome.setScale(2, BigDecimal.ROUND_HALF_UP);

            totalTodayIncome = MoneyUtils.add(totalTodayIncome, todayIncome);
        }

        // 基金
        AssetFundModel fund = new AssetFundModel();
        // 设置总资产
        fund.setTotalWorthValue(totalWorthValue);
        // 设置总收益
        fund.setTotalTodayIncome(totalTodayIncome);
        // 设置最新净值日期
        fund.setNetValueDate(lastNetDate);
        // 设置资产类别
        int assetType = GlobalConstant.ASSET_TYPE_FUND;
        if (needT0) {
            assetType = GlobalConstant.ASSET_TYPE_WALLET;
            // 这个主要是给零钱包界面使用，零钱包页面需要显示该用户当前持有的T0基金的七日年化，目前当前T0基金只有一只，213009或213909
            fund.setFundCode(fundCode);
        }
        fund.setAssetType(assetType);
        //累计收益, 只有货币基金的累计收益有值，非货币基金的累计收益接口不会返回 - add by Shangdu Lin - 20170531
        //fund.setTotalAccumIncome(totalAccumIncome);
        // 未付收益 - add by Shangdu Lin - 20170612
        fund.setTotalUnpaidIncome(totalUnpaidIncome);

        // 总基金个数
        fund.setFundsCount(fundSums.size());
        // 是否在途
        boolean inTransit = checkInTransit(applys, lookups, needT0);
        fund.setInTransit(inTransit);

        return fund;
    }

    /**
     * 获取确认成功的份额
     *
     * @param confirms
     * @param fundCode
     * @return
     */
    public static BigDecimal getConfirmShares(Collection<ConfirmModel> confirms, String fundCode, Date
        currentWorkingDate) {
        BigDecimal shares = new BigDecimal(0);
        if (CollectionUtils.isEmpty(confirms)) {
            return shares;
        }
        for (ConfirmModel model :
            confirms) {
            // 申购和定投成功的份额
            if (model.getFundCode().equals(fundCode)
                && model.getAffirmDate().equals(DateUtils.formatDate4(currentWorkingDate))
                && (model.getFundBusinCode().equals(GlobalConstant.FUND_BUSIN_CODE_CONFIRM_BUY) || model.getFundBusinCode().equals(GlobalConstant.FUND_BUSIN_CODE_CONFIRM_FIX_BUY))
                && checkConfirmSuccess(model.getTAConfirmFlag())) {
                shares = MoneyUtils.add(shares, model.getConfirmShares());
            }
        }

        logger.warn("当前日期:{},基金代码:{},确认成功的份额:{}", DateUtils.formatDate4(currentWorkingDate), fundCode, shares);

        return shares;
    }

    /**
     * 判断是否确认成功
     * 1-确认成功
     * 2-部分确认
     * 3-实时确认成功
     *
     * @param confirmFlag
     * @return
     */
    public static boolean checkConfirmSuccess(String confirmFlag) {
        if (confirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_CONFIRMED) || confirmFlag.equals(GlobalConstant
            .TACONFIRM_FLAG_PART_CONFIRMED) || confirmFlag.equals(GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS)) {
            return true;
        }

        return false;
    }

    /**
     * 判断是否有在途
     *
     * @param applys
     * @param lookups
     * @param needT0
     * @return
     */
    public static boolean checkInTransit(List<ApplyModel> applys, List<Lookup> lookups, boolean needT0) {
        // 判断是否有在途的交易
        for (ApplyModel model : applys) {
            if (needT0) {
                // 未确认并且不能是无效扣款状态
                if (model.getTAConfirmFlag().equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)
                    && !model.getDeductStatus().equals(GlobalConstant.DEDUCT_STATUS_INVALID)
                    && isT0Fund(lookups, model.getFundCode())) {

                    return true;
                }
            } else {
                // 未确认并且不能是无效扣款状态
                if (model.getTAConfirmFlag().equals(GlobalConstant.TACONFIRM_FLAG_UNCONFIRM)
                    && !model.getDeductStatus().equals(GlobalConstant.DEDUCT_STATUS_INVALID)
                    && !isT0Fund(lookups, model.getFundCode())) {

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 计算每笔持仓的份额，当日收益，净值日期， 日收益
     *
     * @param shares
     * @param lookups
     * @param fundNetValueList
     * @return
     */
    public static List<AssetFundModel> extractFunds(List<ShareModel> shares, List<Lookup> lookups,
                                                    List<FundNetValueResult> fundNetValueList) {
        List<AssetFundModel> funds = new ArrayList<>();
        Map<String, FundNetValueResult> map = new HashMap<>();
        // 计算份额，当日收益，净值日期， 日收益
        for (ShareModel share : shares) {
            // 如果当前份额为0，则不考虑在内
            BigDecimal currentShare = share.getCurrentShare();
            if (MoneyUtils.compareTo(currentShare, 0) == 0) {
                continue;
            }

            // 从聚源获取基金基础信息
            String fundCode = share.getFundCode();
            FundNetValueResult netValueResult = null;
            if (map.containsKey(fundCode)) {
                netValueResult = map.get(fundCode);
            } else {
                netValueResult = getNetValue(fundNetValueList, fundCode);
                if (netValueResult == null) {
                    throw new BaseException(ErrorConstant.ERROR_GILDATA_EMPTY);
                }

                map.put(fundCode, netValueResult);
            }

            AssetFundModel assetFundModel = new AssetFundModel();
            // 基金代码
            assetFundModel.setFundCode(share.getFundCode());
            // 当前份额
            assetFundModel.setCurrentShares(currentShare);
            // 单位净值
            assetFundModel.setNetValue(netValueResult.getUnitNV());
            // 单位净值日期
            assetFundModel.setNetValueDate(netValueResult.getTradingDay());
            // 资产类型
            assetFundModel.setAssetType(GlobalConstant.ASSET_TYPE_FUND);
            // 累计收益
            //assetFundModel.setAccumIncome(share.getAccumIncome());
            // 累计收益 = 每月5号06文件中的“红利资金” + 每日05文件中的“货币基金未分配收益金额”
            assetFundModel.setUnpaidIncome(share.getUnpaidIncome());

            // 货币基金
            if (netValueResult.getFundTypeCode().intValue() == FundConst.FUND_TYPE_CODE_CURRENCY) {
                // 此fund为货币基金
                assetFundModel.setIsCurrency(true);

                // 资产类型
                if (isT0Fund(lookups, fundCode)) {
                    assetFundModel.setAssetType(GlobalConstant.ASSET_TYPE_WALLET);
                }

                // 从聚源获取万份收益
                BigDecimal dailyProfit = netValueResult.getDailyProfit();
                if (dailyProfit == null) {
                    dailyProfit = new BigDecimal(0);
                    logger.error(
                        MessageFormat.format("queryAssets-getDailyProfit is null for fund code ={0}", fundCode));
                }
                // 万份收益
                assetFundModel.setDailyProfit(dailyProfit);

            } else {

                // 此fund为非货币基金
                assetFundModel.setIsCurrency(false);

                // 从聚源获取日收益率
                BigDecimal todayIncomeRate = netValueResult.getNvDailyGrowthRate();
                if (todayIncomeRate == null) {
                    todayIncomeRate = new BigDecimal(0);
                    logger.error(MessageFormat.format("queryAssets-getNvDailyGrowthRate is null for fund code ={0}",
                        fundCode));
                }

                // 日收益率
                assetFundModel.setTodayIncomeRate(todayIncomeRate);
            }

            funds.add(assetFundModel);
        }

        return funds;
    }

    /**
     * 判断是否是T0基金
     *
     * @param lookups
     * @param fundCode
     * @return
     */
    public static boolean isT0Fund(List<Lookup> lookups, String fundCode) {
        if (CollectionUtils.isEmpty(lookups)) {
            return false;
        }
        for (Lookup lookup : lookups) {
            if (lookup.getRuleValue().equals(fundCode)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获取某只基金的聚源基础数据
     *
     * @param fundNetValueList
     * @param fundCode
     * @return
     */
    public static FundNetValueResult getNetValue(List<FundNetValueResult> fundNetValueList, String fundCode) {
        for (FundNetValueResult fundNetValueResult : fundNetValueList) {
            if (fundNetValueResult == null) {
                continue;
            }
            if (fundNetValueResult.getFundCode().equals(fundCode)) {
                return fundNetValueResult;
            }
        }

        return null;
    }

    /**
     * 将产品List转换成Map<code,name>
     *
     * @param products
     * @return key是基金code，value是name
     */
    public static Map<String, String> convertProductsToMap(List<SecurityProduct> products) {
        Map<String, String> codeMap = new HashMap<String, String>();
        if (CollectionUtils.isEmpty(products)) {
            return codeMap;
        }

        for (SecurityProduct product : products) {
            if (codeMap.containsKey(product.getSecuCode())) {
                continue;
            }
            // 添加到MAP
            codeMap.put(product.getSecuCode(), product.getChiName());
        }

        return codeMap;
    }

    /**
     * 累计快速赎回的份额
     *
     * @param applys
     * @return
     */
    public static Map<String, BigDecimal> getFastSellShares(List<ApplyModel> applys) {
        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal shares = new BigDecimal(0);
        for (ApplyModel model : applys) {
            String fundCode = model.getFundCode();
            if (!map.containsKey(fundCode)) {
                map.put(fundCode, new BigDecimal(0));
            }

            // 获取之前份额
            shares = map.get(fundCode);

            // 快速赎回成功 - 实时确认成功
            if (model.getTAConfirmFlag().equals(GlobalConstant.TACONFIRM_FLAG_REAL_SUCCESS)) {
                shares = MoneyUtils.add(shares, model.getShares());
            }

            // 保存
            map.put(fundCode, shares);
        }

        return map;
    }

    /**
     * 获取净值日期
     *
     * @param funds
     * @param lookups
     * @return
     */
    public static Date getNetDate(List<FundNetValueResult> funds, List<Lookup> lookups) {
        for (Lookup lookup : lookups) {
            logger.warn("getNetDate-ruleValue:" + lookup.getRuleValue());
            for (FundNetValueResult fund : funds) {
                String fundCode = fund.getFundCode();
                logger.warn("getNetDate-fundCode:" + fundCode);
                if (fundCode != null && fundCode.equals(lookup.getRuleValue())) {
                    return fund.getTradingDay();
                }
            }
        }

        logger.warn("getNetDate-未找到T0基金或未找到T0基金的净值日期");

        return new Date();
    }

    /**
     * 如果valueOne before valueTwo，则返回true，否则返回false
     *
     * @param valueOne
     * @param valueTwo
     * @return
     */
    public static boolean dateBefore(Date valueOne, Date valueTwo) {
        valueOne = DateUtils.stringToDate(DateUtils.formatDate4(valueOne), GlobalConstant.DATE_FORMAT_YYYYMMDD);
        valueTwo = DateUtils.stringToDate(DateUtils.formatDate4(valueTwo), GlobalConstant.DATE_FORMAT_YYYYMMDD);
        if (valueOne.before(valueTwo)) {
            return true;
        }

        return false;
    }

    /**
     * populate份额明细
     *
     * @param list
     * @param result
     * @return
     */
    public static List<DividendModel> populateDividend(List<Map<String, Object>> list, BaseListResult result) {
        List<DividendModel> dividends = new ArrayList<>();
        for (Map<String, Object> item : list) {
            DividendModel model = new DividendModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return dividends;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            // 交易账号
            model.setTradeAccount(item.get(HSOutputParameterNames.TRADE_ACCO).toString());
            // TA账号
            model.setTaAccount(item.get(HSOutputParameterNames.TA_ACCO).toString());
            // 基金代码
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            // 红利总金额
            model.setTotalDividendBalance(BigDecimalUtil.ConvertToBigDecimal(item.get(HSOutputParameterNames
                .DIVIDEND_TOTALBALA).toString()));

            dividends.add(model);
        }

        return dividends;
    }

    /**
     * 判断恒生返回调用结果是否成功
     *
     * @param map
     * @return
     */
    public static boolean checkSuccess(Map<String, Object> map) {
        if (!map.containsKey(HSOutputParameterNames.SUCCESS_TYPE)) {
            return false;
        }

        String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
        if (successType.equals("0")) {
            return true;
        }

        return false;
    }

    /**
     * populate客户信息
     *
     * @param map
     * @return
     */
    public static ClientInfoModel populateClientInfo(Map<String, Object> map) {
        ClientInfoModel model = new ClientInfoModel();

        if (map != null) {
            model.setClientFullName(map.get(HSOutputParameterNames.CLIENT_FULL_NAME).toString());
            model.setClientName(map.get(HSOutputParameterNames.CLIENT_NAME).toString());
            model.setIdNo(map.get(HSOutputParameterNames.ID_NO).toString());
            model.setIdKind(map.get(HSOutputParameterNames.ID_KIND_GB).toString());
            model.setMobile(map.get(HSOutputParameterNames.MOBILE_TEL).toString());
            model.setBirthday(IdCardUtil.getBirthday(model.getIdNo()));
            model.setProfessionalFlag(map.get(HSOutputParameterNames.PUB_PROF_FLAG).toString());
            model.setAddress(map.get(HSOutputParameterNames.ADDRESS).toString());
            model.setTradeAccountName(map.get(HSOutputParameterNames.TRADE_ACCOUNT_NAME).toString());
            model.setQualifiedFlag(map.get(HSOutputParameterNames.PUB_HG_FLAG).toString());
            String risk = map.get(HSOutputParameterNames.INVEST_RISK_TOLERANCE).toString();
            if (StringUtil.isNotEmpty(risk)) {
                model.setInvestRiskTolerance(Integer.parseInt(risk));
            }
        }
        return model;
    }

    /**
     * populate警示模板内容
     *
     * @param list
     * @param result
     * @return
     */
    public static List<WarningModel> populateWarnings(List<Map<String, Object>> list, BaseListResult result) {
        List<WarningModel> warnings = new ArrayList<>();
        for (Map<String, Object> item : list) {
            WarningModel model = new WarningModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return warnings;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            model.setWarningNo(item.get(HSOutputParameterNames.WARNING_NO).toString());
            model.setWarningType(item.get(HSOutputParameterNames.WARNING_TYPE).toString());
            model.setWarningContent(item.get(HSOutputParameterNames.WARNING_CONTENT).toString());

            warnings.add(model);
        }

        return warnings;
    }

    /**
     * populate待办事项
     *
     * @param list
     * @param result
     * @return
     */
    public static List<ToDoModel> populateTodos(List<Map<String, Object>> list, BaseListResult result) {
        List<ToDoModel> todos = new ArrayList<>();
        for (Map<String, Object> item : list) {
            ToDoModel model = new ToDoModel();
            // 记录数
            String rowCount = item.get(HSOutputParameterNames.ROWCOUNT).toString();
            if (!StringUtil.isEmpty(rowCount)) {
                result.setRowCount(Long.parseLong(rowCount));
            } else {
                return todos;
            }
            // 总记录数
            String totalCount = item.get(HSOutputParameterNames.TOTAL_COUNT).toString();
            if (!StringUtil.isEmpty(totalCount)) {
                result.setTotalCount(Long.parseLong(totalCount));
            }

            model.setSerialNo(item.get(HSOutputParameterNames.TODO_SERIAL_NO).toString());
            model.setWarningType(item.get(HSOutputParameterNames.WARNING_TYPE).toString());
            model.setBusinessCode(item.get(HSOutputParameterNames.FUND_BUSIN_CODE).toString());
            model.setFundCode(item.get(HSOutputParameterNames.FUND_CODE).toString());
            model.setPlaceHolder(item.get(HSOutputParameterNames.PLACE_HOLDER).toString());
            model.setProtocolName(item.get(HSOutputParameterNames.PROTOCOL_NAME).toString());
            model.setAlloNo(item.get(HSOutputParameterNames.ALLOT_NO).toString());

            todos.add(model);
        }

        return todos;
    }

    /**
     * 组装待办事项内容
     *
     * @param source
     * @param placeHolder
     * @return
     */
    public static String buildTodoConent(String source, String placeHolder) {
        try {
            System.out.println(source);
            String[] array = placeHolder.split("\\|");
            for (String blocker :
                array) {
                String[] items = blocker.split(":");
                String finder = "{" + items[0] + "}";
                String replacer = items[1].trim();
                source = source.replace(finder, replacer);
                System.out.println("finder=" + finder + ",replacer=" + replacer + ",source=" + source);
            }

            return source;
        } catch (Exception ex) {
            logger.error(ExceptionUtil.getMessage(ex));
            throw new BaseException(ErrorConstant.ERROR_CLIENT_NO_FIND);
        }
    }

    /**
     * 根据警示类型查询警示内容
     * @param warnings
     * @param warningType
     * @return
     */
    public static WarningModel getWarning(List<WarningModel> warnings, String warningType) {
        if (!CollectionUtils.isEmpty(warnings)) {
            for (WarningModel model :
                warnings) {
                if (model.getWarningType().equals(warningType)) {
                    return model;
                }
            }
        }

        return null;
    }
}
