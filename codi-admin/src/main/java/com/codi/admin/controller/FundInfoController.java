package com.codi.admin.controller;

import com.codi.base.domain.BaseController;
import com.codi.base.domain.BaseResult;
import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.service.FundInfoService;
import com.codi.superman.base.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 周翔 on 2017/5/8.
 */

@RestController
@RequestMapping("/sys/fund")
public class FundInfoController extends BaseController {

    @Autowired
    private FundInfoService fundInfoService;

    /**
     * 获取所有的基金信息
     *
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public BaseResult getFundInfo(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws BaseAppException {

        return BaseResult.success(fundInfoService.queryList(pageIndex, pageSize));
    }

    /**
     * 获取基金总数
     *
     * @return
     * @throws BaseAppException
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public BaseResult getBulletinCount() throws BaseAppException {
        return BaseResult.success(fundInfoService.queryListCount());
    }
}
