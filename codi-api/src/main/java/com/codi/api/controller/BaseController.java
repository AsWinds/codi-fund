package com.codi.api.controller;

import java.util.Date;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.codi.base.util.DateEditor;

/**
 * Controller基类
 * 
 * @date 2016年10月31日 下午4:59:44
 */
public class BaseController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
