package com.codi.admin.controller;

import com.codi.base.dao.plugin.page.PageView;
import com.codi.base.log.annotation.Loggable;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.service.PEAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Shangdu Lin on 2017/2/28 10:27.
 */
@RequestMapping("/pe")
@Controller
public class PEController {

    @Autowired
    private PEAppointmentService peAppointmentService;

    @Loggable
    @RequestMapping(value = "/query/appointments", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult queryAppointments(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "pageIndex") Integer pageIndex,
                                        @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "isActive") boolean isActive,
                                        @RequestParam(value = "productName") String productName, @RequestParam(value = "clientName") String clientName,
                                        @RequestParam(value = "mobile") String mobile) throws UnsupportedEncodingException {

        productName= URLDecoder.decode(productName,"UTF-8");
        clientName=URLDecoder.decode(clientName,"UTF-8");

        PageView pageView=peAppointmentService.queryListByPage(pageIndex,pageSize,isActive,productName,clientName,mobile);
        BaseResult result=new BaseResult();
        result.setResult(pageView);

        return result;
    }

}
