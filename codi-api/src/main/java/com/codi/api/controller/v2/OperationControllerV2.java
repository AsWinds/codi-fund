package com.codi.api.controller.v2;

import com.codi.api.controller.BaseController;
import com.codi.base.exception.BaseAppException;
import com.codi.base.log.annotation.Loggable;
import com.codi.bus.core.resultModel.OperationContentResult;
import com.codi.bus.core.service.OperationContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 运营Controller
 * @author Shangdu Lin
 */
@Controller
@RequestMapping("operation/v2")
public class OperationControllerV2 extends BaseController {

    @Resource(name = "operationContentService")
    private OperationContentService operationContentService;

    /**
     * 获取首页block信息
     * @param request
     * @param response
     * @return
     * @throws BaseAppException
     */
    @Loggable
    @RequestMapping(value = "contents", method = RequestMethod.GET)
    public @ResponseBody OperationContentResult queryFundDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam String version) throws BaseAppException {

        return operationContentService.queryOperationContent(true, version);

    }

}
