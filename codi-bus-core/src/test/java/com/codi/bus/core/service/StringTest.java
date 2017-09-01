package com.codi.bus.core.service;

import org.junit.Test;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月8日 下午4:58:55
 */
public class StringTest {

    @Test
    public void test() {
        String a = "a\n b\n c\n<p>";
        System.out.println(a.replaceAll("\n", "<p></p>"));
    }
}
