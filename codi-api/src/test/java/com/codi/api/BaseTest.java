package com.codi.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-application.xml"})
@Slf4j
public abstract class BaseTest {

    protected ApplicationContext ctx;

    @Before
    public void before() {
//        ctx = new ClassPathXmlApplicationContext("classpath:spring-applin.xml");
    }

    protected void print(Object obj) {
        log.debug("result={}", JSON.toJSONString(obj, true));
    }
}
