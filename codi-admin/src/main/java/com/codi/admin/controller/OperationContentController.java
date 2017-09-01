package com.codi.admin.controller;

import com.codi.base.domain.BaseController;
import com.codi.base.domain.BaseResult;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.domain.OperationContent;
import com.codi.bus.core.service.OperationContentService;
import com.codi.superman.base.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 周翔 on 2017/5/9.
 */
@RestController
@RequestMapping("/sys/oc")
public class OperationContentController extends BaseController {
    @Autowired
    OperationContentService operationContentService;

    /**
     * 管理员所有的app首页基金推荐记录
     *
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public BaseResult getOperationContent() throws BaseAppException {
        return BaseResult.success(operationContentService.queryOperationContentNew());
    }


    /**
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public BaseResult addOperationContent(OperationContent operationContent) throws BaseAppException {
        operationContentService.addOperationContent(operationContent);
        return BaseResult.success(operationContent);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public BaseResult deleteOperationContent(@RequestParam(value = "id") Long id) throws BaseAppException {

        operationContentService.deleteOperationContent(id);
        return BaseResult.success();
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseResult updateOperationContent(OperationContent operationContent) throws BaseAppException {
        operationContentService.updateOperationContent(operationContent);
        return BaseResult.success();
    }

    /**
     * 上线
     *
     * @param
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "online", method = RequestMethod.POST)
    public BaseResult onlineOperationContent(OperationContent operationContent) throws BaseAppException {

        operationContentService.onlineOperationContent(operationContent);
        return BaseResult.success();
    }
}
