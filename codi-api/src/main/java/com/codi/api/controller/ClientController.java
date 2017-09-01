package com.codi.api.controller;

import com.codi.api.validation.AccountValidation;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.web.RequestUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.HttpHeaderConstant;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.LoginResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.ClientService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.model.UserModel;
import com.codi.bus.core.service.model.WarningModel;
import com.codi.bus.core.sys.service.AppUpdateService;
import com.codi.bus.util.Platform;
import com.codi.message.constant.ErrorConstant;
import com.codi.message.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Shangdu Lin on 2017/6/20 13:33.
 */
@Controller
@RequestMapping("/client")
@Validated
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private AppUpdateService auService;

    @Resource(name = "clientService")
    private ClientService clientService;

    @Autowired
    private QueryService queryService;

    @Loggable
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getClientInfo(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId) {
        return clientService.getClientInfo(userId);
    }

    @Loggable
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult modifyClientInfo(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId, @RequestParam String address, @RequestParam String addressCode, @RequestParam String occupation, @RequestParam String occupationCode, @RequestParam String beneficiary, @RequestParam String owner, @RequestParam boolean selfSustain) {
        // 验证输入
        AccountValidation.validateClient(address,addressCode,occupation,occupationCode,beneficiary,owner,selfSustain);
        // 修改客户资料
        return clientService.modifyClientInfo(userId, address, addressCode, occupation, occupationCode, beneficiary, owner,
            selfSustain);
    }


    @Loggable
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult initClient(HttpServletRequest request, HttpServletResponse response, @RequestHeader(value
        = GlobalConstant.HEADER_AUTH_TOKEN) String token, @RequestHeader(value = GlobalConstant.HEADER_CLIENT_VERSION) String clientVersion, @RequestHeader(value = GlobalConstant.HEADER_OS_TYPE) Platform osType, @RequestHeader(value = GlobalConstant.HEADER_APP_IDENTIFIER) String appIdentifier, @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) {

        // 获取IP地址
        String ip = RequestUtils.getIpAddr(request);

        // 设置用户姓名和手机号
        User user = userService.getUserByToken(token);
        if (user == null) {
            LoginResult result = new LoginResult();
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(ErrorConstant.ERROR_NOT_LOGIN);
            result.setSuccess(false);
            return result;
        }


        LoginResult result = new LoginResult();
        result.setSuccess(true);
        UserModel model = new UserModel();
        model.setMobile(user.getUserMobile());
        model.setUserName(user.getUserName());
        // 初始化客户信息
        clientService.initClientInfo(user.getUserId(),model);
        result.setUser(model);

        //查询警示内容
        List<WarningModel> warningModels=queryService.queryWarnings();
        result.setWarnings(warningModels);

        // 验证token
        ValidateTokenResult tokenResult = userService.validateToken(token, ip, deviceId, true);
        if (!tokenResult.getSuccess()) {
            result = new LoginResult();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_BUSINESS);
            result.setErrorCode(tokenResult.getErrorCode());
            result.setErrorMessage(MessageUtil.getErrorMsg(result.getErrorCode()));
            result.setAppUpdateResult(auService.getAppUpdateResult(clientVersion, appIdentifier));
            return result;
        }

        // token
        result.setToken(tokenResult.getToken());
        result.setAppUpdateResult(auService.getAppUpdateResult(clientVersion, appIdentifier));

        return result;
    }

    @Loggable
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getTodos(HttpServletRequest request, HttpServletResponse response, @RequestAttribute(value = HttpHeaderConstant.HEADER_USER_ID) Long userId) {
        return clientService.getEventTodos(userId);
    }
}
