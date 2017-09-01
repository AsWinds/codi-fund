package com.codi.api.controller;

import com.codi.base.exception.BaseAppException;
import com.codi.base.log.annotation.Loggable;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.CashChangeListResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.resultModel.WalletDetailResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.WalletService;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 零钱包相关内容
 *
 * @author shi.pengyan
 * @date 2016年12月8日 下午5:15:12
 */
@Controller("wallet")
@RequestMapping("/wallet")
public class WalletController {

    private static final Logger logger = LoggerFactory.getLogger(WalletController.class);

    @Resource(name = "walletService")
    private WalletService walletService;

    @Resource(name = "userService")
    private UserService userService;

    @Loggable
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public WalletDetailResult getWalletDetail(@RequestParam(value = "token", required = false) String token,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseAppException {

        logger.debug("get Wallet Detail begin");

        WalletDetailResult result = walletService.getWalletDetail(token, deviceId);

        return result;
    }

    @Loggable
    @RequestMapping(value = "cashChangeInfo", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult queryCashChangeInfo(@RequestParam String token,
    		@RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseAppException{
        logger.debug("get wallet cashChange detail begin");

        CashChangeListResult result = null;

        // 验证token
        ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);

        if (!validateTokenResult.getSuccess()) {
            String errorMessage = MessageUtil.getErrorMessage(validateTokenResult.getErrorCode(), null);
            validateTokenResult.setErrorMessage(errorMessage);

            return validateTokenResult;
        }

        result = walletService.getWalletCashChangeDetails(validateTokenResult.getUserId());
//        result = walletService.getWalletCashChangeDetails(409l);
        return result;
    }
}
