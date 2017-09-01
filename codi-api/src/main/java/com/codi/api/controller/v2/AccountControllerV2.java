package com.codi.api.controller.v2;

import com.codi.base.util.StringUtil;
import com.codi.base.web.RequestUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.service.UserService;
import com.codi.message.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shangdu Lin on 2017/6/21 14:09.
 */
@Controller
@RequestMapping("/acc/v2")
public class AccountControllerV2 {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult login(HttpServletRequest request, HttpServletResponse response, @RequestParam String loginName,
                      @RequestParam String password, @RequestHeader(value = GlobalConstant.HEADER_OS_TYPE) String osType,@RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId){

        // 获取IP地址
        String ip = RequestUtils.getIpAddr(request);

        BaseResult result = userService.login(loginName, password, deviceId, osType, ip);
        if (result.getSuccess() == false && StringUtil.isEmpty(result.getErrorMessage())) {
            result.setErrorMessage(MessageUtil.getErrorMessage(result.getErrorCode(), null));
        }

        return result;
    }
}
