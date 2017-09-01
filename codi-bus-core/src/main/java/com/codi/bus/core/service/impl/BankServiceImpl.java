package com.codi.bus.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.dao.UserBankDao;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.domain.LookupKey;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.resultModel.CommonDataResult;
import com.codi.bus.core.resultModel.PayableBankListResult;
import com.codi.bus.core.resultModel.PayableBankModel;
import com.codi.bus.core.service.BankService;
import com.codi.bus.core.service.model.BankLimitModel;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.SystemDBException;
import com.codi.message.constant.ErrorConstant;

@Service("bankService")
@Transactional
public class BankServiceImpl implements BankService {

	private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

	@Resource(name = "userBankDao")
	private UserBankDao userBankDao;

	@Resource(name = "lookupDao")
	private LookupDao lookupDao;

	@Override
	public List<UserBank> getListByUserId(Long userId) throws BaseException {
		logger.info("getListByUserId - UserId:" + userId);
		try {

			return userBankDao.getListByUserId(userId);

		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "getListByUserId - Exception:", exception);
			throw new SystemDBException("getListByUserId Failure!", exception);
		}
	}

	@Override
	public PayableBankListResult getPayBanks(String capitalMode) throws BaseException {
		logger.info("getPayBanks - capitalMode:" + capitalMode);
		try {

			// 不支持的银行
			List<Lookup> excludelookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EXCLUDE_BANK);
			// 易宝支持的银行
			List<Lookup> epayLookups = lookupDao.getLookupByType(RuleConstant.RULE_LOOKUP_TYPE_EPAYBANK);

			PayableBankListResult result = new PayableBankListResult();
			result.setSuccess(true);
			List<PayableBankModel> banks = new ArrayList<>();
			for (Lookup epay : epayLookups) {

				//
				boolean exclude = false;
				for (Lookup lookup : excludelookups) {
					if (lookup.getRuleValue().equals(epay.getRuleValue())) {
						exclude = true;
					}
				}
				if (exclude) {
					continue;
				}

				PayableBankModel model = new PayableBankModel();
				model.setBankCode(epay.getRuleValue());
				model.setBankName(epay.getRuleText());
				banks.add(model);
			}
			result.setBanks(banks);
			result.setRowCount((long) banks.size());
			result.setTotalCount((long) banks.size());

			return result;
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "getPayBanks - Exception:", exception);
			throw new SystemDBException("getPayBanks Failure!", exception);
		}
	}

	/**
	 * 获取支付渠道银行卡的单笔限额
	 * 
	 * @param capitalMode
	 * @param bankCode
	 * @return
	 * @throws BaseException
	 */
	@Override
	public CommonDataResult<BankLimitModel> getPayBankLimits(String capitalMode, String bankCode) throws BaseException {
		logger.info("getPayBankLimits - capitalMode:" + capitalMode);
		try {

			// 获取支付渠道
			LookupKey key = new LookupKey();
			key.setRuleType(RuleConstant.RULE_LOOKUP_TYPE_PAYWAY);
			key.setRuleValue(capitalMode);
			Lookup payway = lookupDao.getLookupByKey(key);
			if (payway == null) {
				return new CommonDataResult<BankLimitModel>(false, ErrorConstant.ERROR_PAYWAY_NO_FIND, GlobalConstant.ERROR_TYPE_APPLICATION);
			}

			// 获取该支付渠道下的银行
			key.setRuleType(payway.getComponentValue());
			key.setRuleValue(bankCode);
			Lookup bank = lookupDao.getLookupByKey(key);
			if (bank == null) {
				return new CommonDataResult<BankLimitModel>(false, ErrorConstant.ERROR_PAYWAY_BANK_NO_FIND, GlobalConstant.ERROR_TYPE_APPLICATION);
			}

			BankLimitModel model = new BankLimitModel();
			model.setBankName(bank.getRuleText());
			model.setBankCode(bank.getRuleValue());
			model.setSingleTradeLimit(BigDecimalUtil.ConvertToBigDecimal(bank.getComponentValue(), new BigDecimal(-1)));
			
			return new CommonDataResult<BankLimitModel>(model);

		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "getPayBankLimits - Exception:", exception);
			throw new SystemDBException("getPayBankLimits Failure!", exception);
		}
	}

}
