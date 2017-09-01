package com.codi.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codi.base.domain.BaseResult;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.service.LookupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.OperationContentResult;
import com.codi.bus.core.service.OperationContentService;
import com.codi.bus.core.service.UserService;

/**
 * 运营Controller
 * @author song-jj
 */
@Controller
@RequestMapping("operation")
public class OperationController extends BaseController {

    @Resource(name = "operationContentService")
    private OperationContentService operationContentService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "lookupService")
    private LookupService lookupService;

    /**
     * 查询基金详情页(总入口)
     *
     * @param request
     *            request
     * @param response
     *            response
     * @param fundCode
     *            基金代码
     * @throws BaseAppException
     */
    @RequestMapping("contents")
    public @ResponseBody OperationContentResult queryFundDetail(HttpServletRequest request, HttpServletResponse response,
            @RequestHeader(value = GlobalConstant.HEADER_APP_DEVICE) String deviceId) throws BaseAppException {

        return operationContentService.queryOperationContent();

    }

    /**
     * 获取提示信息
     * @param request
     * @param response
     * @param tipCode
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "tips",method = RequestMethod.GET)
    public @ResponseBody BaseResult queryTips(HttpServletRequest request, HttpServletResponse response, @RequestParam
                                              String tipCode) throws BaseAppException{
        Lookup lookup= lookupService.getLookup(RuleConstant.RULE_LOOKUP_TYPE_TIPS, tipCode);
        BaseResult result=new BaseResult();
        result.setResult(lookup.getComponentValue());

        return result;
    }


}
