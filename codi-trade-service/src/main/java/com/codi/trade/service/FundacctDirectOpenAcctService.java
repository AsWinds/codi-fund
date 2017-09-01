package com.codi.trade.service;

import com.codi.trade.dto.FundAcctOpenDto;

import java.util.Map;

public interface FundacctDirectOpenAcctService {
    //开户
    @Deprecated
    Map<String, Object> openAcct(String idNo, String tradePassword, String userName, String bankCode,
                                 String bankNo, String bankName, String mobile, String fundCard, String capitalMode);


    /**
     * 开户
     * 符合证监会《适应性改造要求》
     *
     * @param dto
     * @return
     * @author shi.pengyan 2017-6-19 13:39:57
     */
    Map<String, Object> openAcct(FundAcctOpenDto dto);
}
