package com.codi.bus.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 身份证辅助类
 *
 * @author shi.pengyan
 * @date 2017-06-19 14:32
 */
@Slf4j
public final class IdCardUtil {

    private IdCardUtil() {
    }

    /**
     * 获取生日 YYYYMMDD
     *
     * @param idCard 身份证
     * @return
     */
    public static String getBirthday(String idCard) {
        String card = idCard.trim();
        String year;
        String month;
        String day;

        if (card.length() == 18) { //处理18位身份证
            year = card.substring(6, 10);
            month = card.substring(10, 12);
            day = card.substring(12, 14);
        } else { //处理非18位身份证
            year = card.substring(6, 8);
            month = card.substring(8, 10);
            day = card.substring(10, 12);
            year = "19" + year;
        }

        if (month.length() == 1) {
            month = "0" + month; //补足两位
        }

        if (day.length() == 1) {
            day = "0" + day; //补足两位
        }

        return year + month + day;

    }

}
