package com.codi.bus.util;

import com.codi.base.util.StringUtil;

/**
 * html工具
 * 
 * @author shi.pengyan
 * @date 2016年10月28日 下午4:52:10
 */
public final class HtmlUtil {
    /**
     * 将\n转换成p包裹的内容
     * 
     * @param originContent
     *            原始内容
     * @return
     */
    public static String convert2HTML(String originContent) {
        if (StringUtil.isEmpty(originContent)) {
            originContent = "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<p>").append(originContent.replaceAll("\n", "</p><p>")).append("</p>");
        return sb.toString();
    }

}
