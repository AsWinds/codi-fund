package com.codi.bus.core.service;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.resultModel.CashChangeListResult;
import com.codi.bus.core.resultModel.ShareListResult;
import com.codi.bus.core.resultModel.WalletDetailResult;

/**
 * 零钱包 相关接口
 * 
 * @author song-jj
 */
public interface WalletService {

    /**
     * 查询零钱包详情
     * 
     * @param token
     *            用户token，可选
     * @param deviceId
     *            设备ID，可选
     * @return 零钱包详情
     */
    WalletDetailResult getWalletDetail(String token, String deviceId) throws BaseAppException;
    
    /**
     * 查询零钱包详情
     * 
     * @param userId
     *            用户id，必选
	 * @param fundCode
     *            基金代碼，必选
     * @return 零钱包提現展示頁面
     */
    CashChangeListResult getWalletCashChangeDetails(Long userId);
    
    ShareListResult queryShareModels(Long userId,String fundCode);
}
