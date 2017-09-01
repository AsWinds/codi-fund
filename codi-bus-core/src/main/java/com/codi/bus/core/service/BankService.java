package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.resultModel.CommonDataResult;
import com.codi.bus.core.resultModel.PayableBankListResult;
import com.codi.bus.core.service.model.BankLimitModel;
import com.codi.bus.exception.BaseException;


public interface BankService {
	List<UserBank> getListByUserId(Long userId) throws BaseException;
	PayableBankListResult getPayBanks(String capitalMode) throws BaseException;
	CommonDataResult<BankLimitModel> getPayBankLimits(String capitalMode, String bankCode) throws BaseException;
}
