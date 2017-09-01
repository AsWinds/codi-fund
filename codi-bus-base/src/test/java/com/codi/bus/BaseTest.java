package com.codi.bus;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-application.xml" })
public class BaseTest {

    protected ApplicationContext ctx;

    protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void before() {
        // ctx = new
        // ClassPathXmlApplicationContext("classpath:spring-application.xml");
    }
}
