package com.codi.bus.core;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class SpringTest {

	@Test
	public void testPath() throws IOException{
		ClassPathResource re = new ClassPathResource("classpath:/mybatis/*.xml");
		System.out.println(re.getURL());
	}

}
