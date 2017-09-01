package com.codi.fcloud.ufx.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 适当性专业投资者类别
 *
 * @author shi.pengyan
 * @date 2017-05-25 17:44
 */
public final class PubProfType {

    private static Map<String, String> data = new HashMap<>(5);

    static {
        data.put("A", "金融机构");
        data.put("B", "金融机构发行的产品");
        data.put("C", "特殊投资者/产品");
        data.put("D", "实力机构投资者");
        data.put("E", "实力个人投资者");
    }

    private PubProfType() {
    }

    public static String get(String key) {
        if (key == null || key.length() == 0) {
            return null;
        }
        return data.get(key.toUpperCase());
    }

}
