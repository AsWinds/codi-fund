package com.codi.bus.core.service.util;

import java.math.BigDecimal;

import com.codi.bus.constant.FundConst;
import com.codi.fundData.domain.FundNetValuePerformance;

/**
 * 基金相关工具类
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 上午10:38:56
 */
public final class FundUtil {

    /**
     * 判断基金类型编码是否是货币<br/>
     * 短期理财表现形式为货基
     * 
     * @param fundTypeCode
     * @return
     */
    public static boolean isCurrency(Integer fundTypeCode) {
        if (fundTypeCode == null) {
            return false;
        }
        switch (fundTypeCode.intValue()) {
        case FundConst.FUND_TYPE_CODE_CURRENCY:
        case FundConst.FUND_TYPE_CODE_SHORT_TERM_FINANCING:
            return true;
        default:
            ;
        }

        return false;
    }

    /**
     * 获取统计类型最终字段
     * 
     * @param statisType
     *            对外公开的标识
     * @return
     */
    public static String getStatisType(Integer statisType) {
        switch (statisType) {
        case 0:
            return "NVDailyGrowthRate";
        case 1:
            return "RRInSingleWeek";
        case 2:
            return "RRInSingleMonth";
        case 3:
            return "RRInThreeMonth";
        case 4:
            return "RRInSixMonth";
        case 5:
            return "RRInSingleYear";
        case 6:
            return "RRInTwoYear";
        case 7:
            return "RRInThreeYear";
        case 8:
            return "RRSinceThisYear";
        }

        return "NVDailyGrowthRate";
    }

    /**
     * 依据类型返回对应值
     * 
     * @param netValue
     *            净值类型
     * @param statisType
     *            统计类型
     * @return
     */
    public static BigDecimal getStatisType(FundNetValuePerformance netValue, Integer statisType) {
        switch (statisType) {
        case 0:
            return netValue.getNVDailyGrowthRate();
        case 1:
            return netValue.getRRInSingleWeek();
        case 2:
            return netValue.getRRInSingleMonth();
        case 3:
            return netValue.getRRInThreeMonth();
        case 4:
            return netValue.getRRInSixMonth();
        case 5:
            return netValue.getRRInSingleYear();
        case 6:
            return netValue.getRRInTwoYear();
        case 7:
            return netValue.getRRInThreeYear();
        case 8:
            return netValue.getRRSinceThisYear();
        }

        return netValue.getNVDailyGrowthRate();
    }

}
