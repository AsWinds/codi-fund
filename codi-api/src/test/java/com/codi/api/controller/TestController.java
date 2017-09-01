package com.codi.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.resultModel.FundDetailResult;
import com.codi.bus.core.service.BankService;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.exception.BaseException;

@Controller
@RequestMapping("test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private UserService userService;

    @Resource
    private BankService bankService;

    @Resource
    private FundDetailService fundDetailService;

    @RequestMapping("combine")
    public BaseResult combineDao(HttpServletRequest request, HttpServletResponse response) throws BaseAppException {

       
        BaseResult result = new BaseResult();

        try {
            userService.checkIDCard("1111111");

            FundDetailResult fundDetail = fundDetailService.getFundDetailByFundCode("550010");

            System.out.println(fundDetail);

            bankService.getListByUserId(111L);
            userService.checkIDCard("asdfads");

        } catch (BaseException e) {
            logger.error("aaaa", e);
        }
        return result;
    }

}
