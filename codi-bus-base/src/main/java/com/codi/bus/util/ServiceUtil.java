package com.codi.bus.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codi.base.spring.SpringContextHolder;

public class ServiceUtil {

	private static ClassPathXmlApplicationContext applicationContext;

	private static ApplicationContext getApplication() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext(
					new String[] { "classpath:spring-application.xml" });
		}
		return applicationContext;
	}

	public static <T> T getService(String name) {
		if (applicationContext == null) {
			getApplication();
		}
		return SpringContextHolder.getBean(name);
	}
	
	public static void closeApplicationContext() {
		if (applicationContext != null) {
			applicationContext.close();
		}
	}
}
