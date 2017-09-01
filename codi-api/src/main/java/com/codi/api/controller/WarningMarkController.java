package com.codi.api.controller;

import com.codi.base.util.StringUtil;
import com.codi.base.web.RequestUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.ValidateTokenResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.WarningMarkHisService;
import com.codi.bus.core.vo.WarningMarkHisVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 警示留痕
 *
 * @author shi.pengyan
 * @date 2017-06-23 16:46
 */
@Slf4j
@RestController
@RequestMapping("/warning_mark")
public class WarningMarkController {

    @Autowired
    private WarningMarkHisService warningMarkHisService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 增加留痕
     *
     * @param requesetVo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@Validated WarningMarkHisVo requesetVo,
                          @RequestHeader(value = GlobalConstant.HEADER_CLIENT_VERSION, required = false) String appVersion,
                          @RequestHeader(value = GlobalConstant.HEADER_OS_TYPE, required = false) String osType,
                          @RequestHeader(value = GlobalConstant.HEADER_AUTH_TOKEN, required = false) String token,
                          @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE, required = false) String deviceId) {

        WarningMarkHis record = new WarningMarkHis();
        BeanUtils.copyProperties(requesetVo, record);
        record.setIp(RequestUtils.getIpAddr(request));

        if (StringUtil.isNotEmpty(osType)) {
            record.setBrowerType(osType);
        }

        if (StringUtil.isNotEmpty(deviceId)) {
            record.setDeviceId(deviceId);
        }
        record.setAppVersion(appVersion);

        if (StringUtil.isNotEmpty(token) && StringUtil.isNotEmpty(deviceId)) {
            ValidateTokenResult validateTokenResult = userService.validateToken(token, deviceId);
            if (validateTokenResult.getSuccess()) {
                record.setUserId(validateTokenResult.getUserId());
            }
        }


        return warningMarkHisService.addLocalAndSync(record);
    }

}
