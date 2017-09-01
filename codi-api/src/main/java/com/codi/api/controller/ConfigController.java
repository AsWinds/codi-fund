package com.codi.api.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codi.base.config.ConfigurationMgr;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.core.resultModel.BaseResult;

/**
 * 配置
 * 
 * @author shi.pengyan
 * @date 2016年10月21日 上午10:12:30
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    // TODO 需要token登录用户才可以调用，暂时入口
    // @RequestMapping(value = "/log4j", method = RequestMethod.GET)
    public void resetLog4j(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "level") String level) {
        StringBuilder filePath = new StringBuilder(ConfigurationMgr.getConfigurationPath());
        filePath.append(File.separator).append("log4j");
        filePath.append(File.separator).append("log4j-").append(level.toLowerCase()).append(".properties");

        BaseResult baseResult = new BaseResult();

        File file = new File(filePath.toString());

        if (file.exists()) {
            baseResult.setSuccess(true);
            PropertyConfigurator.configure(file.toString());
        } else {
            baseResult.setSuccess(false);
        }
        logger.info("this is info");
        logger.debug("this is debug");
        logger.trace("this is trace");
        logger.warn("this is warn");
        logger.error("this is error");

        ResponseUtils.renderJson(request, response, baseResult, true);
    }
}
