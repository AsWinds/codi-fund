package com.codi.bus.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.resultModel.ApplyListResult;
import com.codi.bus.core.resultModel.AssetsResult;
import com.codi.bus.core.resultModel.BaseListResult;
import com.codi.bus.core.resultModel.FixListResult;
import com.codi.bus.core.resultModel.FundDiscountSetting;
import com.codi.bus.core.resultModel.FundListResult;
import com.codi.bus.core.resultModel.FundRate;
import com.codi.bus.core.resultModel.FundTradeRatio;
import com.codi.bus.core.resultModel.ShareListResult;
import com.codi.bus.core.resultModel.ShareTypeListResult;
import com.codi.bus.core.resultModel.TAListResult;
import com.codi.bus.core.resultModel.TradeLimitListResult;
import com.codi.bus.core.service.model.*;
import com.codi.bus.exception.BaseException;
import com.codi.bus.util.FundOperation;

public interface QueryService {

    /**
     * 查询某只基金
     * @param fundCode
     * @return
     */
    FundModel queryFund(String fundCode);

	// 基金查询
	FundListResult queryFunds(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode) throws BaseException;

	// 份额查询
	ShareListResult queryShares(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
			String sortDirection, boolean filterT0) throws BaseException;

	// 交易申请查询
	ApplyListResult queryApplys(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
			String sortDirection, boolean filterT0) throws BaseException;

	// 份额类别查询
	ShareTypeListResult queryShareTypes(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode, String fundName) throws BaseException;

	// 客户银行帐号查询
	BaseListResult queryAccountBanks(String tradeAccount, String clientId, String capitalMode, Integer requestNum,
			Integer queryFlag, Integer beginNum, String sortDirection) throws BaseException;

	// 根据基金代码查询基金费率
	List<FundRate> queryFundRate(String fund_code, FundOperation operation);

	// 获取基金申购费率
	FundTradeRatio getApplyFundRate(String fund_code, BigDecimal balance);

	// 获取基金赎回费率
	FundTradeRatio getExceedFundRate(String fund_code, BigDecimal balance);

	// 交易限制查询
	TradeLimitListResult queryTradeLimits(Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection,
			String fundCode, String shareType, String capitalMode, String businCode, String customType)
			throws BaseException;

	// 获取基金申购、赎回的最低数量
	TradeLimitModel getTradeLimit(String fundCode, String businCode, String shareType, String customType,
			String capitalMode) throws BaseException;

	// 获取基金的风险等级
	NewsModel getRiskLevel(String fundCode) throws BaseException;

	// 查询某一笔的交易
	ApplyModel queryApply(String applyNo) throws BaseException;

	/**
	 * TA账号查询
	 *
	 * @param 客户编号
	 * @return 账户列表
	 * @throws BaseException
	 */
	TAListResult queryTAAccounts(String clientId) throws BaseException;

	/**
	 * 根据基金代码获折扣信息
	 *
	 * @param fund_code
	 *
	 */
	List<FundDiscountSetting> queryFundDiscountSettings(String fund_code, FundOperation operation);

	// 获取主交易账号
	AccountModel getMainAccount(String clientId) throws BaseException;

	// 获取份额类别
	ShareTypeModel getShareType(String fundCode) throws BaseException;

	/**
	 * 基金定投
	 *
	 * @return 已参与定投的基金列表
	 * @throws BaseException
	 */
	FixListResult getFixes(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum, String sortDirection)
			throws BaseException;

	/**
	 * 获取用户零钱包的交易记录
	 *
	 * @author hzren
	 * @since pangu003
	 *
	 */
	ApplyListResult queryWalletOperationList(Long userId, Integer requestNum, Integer queryFlag, Integer beginNum,
			String sortDirection);

	/**
	 * 我的资产页面数据查询 -Shangdu Lin
	 *
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	AssetsResult queryAssets(Long userId) throws BaseException;

	/**
	 * Shangdu Lin: 查询某一用户下的某一时间段的所有交易记录, 此方法被用于计算当前交易日T0基金快速赎回限制
	 *
	 * @param userId
	 * @param beginDate
	 * @param endDate
	 * @param onlyT0
	 * @return
	 * @throws BaseException
	 */
	ApplyListResult queryApplys(Long userId, Date beginDate, Date endDate, String businCode, String confirmFlag,
			boolean onlyT0) throws BaseException;

	/**
	 * 获取某一用户当前工作日快速赎回的份额 - Shangdu Lin
	 * @param userId
	 * @param currentDate
	 * @param isWorkingDate
	 * @return
	 * @throws BaseException
	 */
	Map<String, BigDecimal> getCurrentWorkingDayFastRedeemShares(Long userId, Date currentDate, boolean isWorkingDate)
			throws BaseException;

	/**
	 * 获取某一用户上一工作日未T+1确认实时成功的快速赎回的份额 - Shangdu Lin
	 *
	 * @param userId
	 * @param currentDate
	 * @return
	 * @throws BaseException
	 */
	Map<String, BigDecimal> getLastWorkingDayFastRedeemShares(Long userId, Date currentDate) throws BaseException;

	/**
	 * 获取一时间段的快速赎回的份额 - Shangdu Lin
	 *
	 * @param userId
	 * @param currentDate
	 * @param interval
	 * @return
	 * @throws BaseException
	 */
	Map<String, BigDecimal> getFastRedeemSharesWithInterval(Long userId, Date currentDate, Integer interval)
			throws BaseException;

    /**
     * 查询基金的交易限制 - Shangdu Lin - 20170330
     * @param fundCode
     * @return
     */
    List<TradeLimitModel> queryTradeLimits(String fundCode);

    /**
     * 获取基金的交易限制 - Shangdu Lin - 20170330
     * @param fundCode
     * @param capitalMode
     * @param businCode
     * @param customType
     * @return
     */
    List<TradeLimitModel> queryTradeLimits(String fundCode, String capitalMode, String businCode,
                                                  String customType);

    /**
     * 查询警示内容
     * @return
     */
    List<WarningModel> queryWarnings();
}
