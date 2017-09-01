package com.codi.fcloud.ufx.hssale.trade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.DateUtils;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.FixAllotTradeService;

/**
 * 定期定额申购协议签约
 * 
 * @author song-jj
 */
@Service("fixAllotTradeService")
public class FixAllotTrade extends UfxSDKFactory implements FixAllotTradeService {

	@Loggable
    @Override
    public Map<String, Object> fix(String capitalMode, String password, String tradeAcco, String tradeSource,
            String fundCode, BigDecimal balance, String shareType, String protocolPeriodUnit, Long protocolFixDay) {
        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);
            // 首次交易日期-YYYYMMDD
            String firstExchDateStr = getFristExchDate(protocolFixDay, protocolPeriodUnit);
            // 首次交易日期-YYYYMM
            Integer firstExchDate = Integer.valueOf(firstExchDateStr.substring(0, 6));
            // 重新计算后的首次交易日期
            protocolFixDay = Long.valueOf(firstExchDateStr.substring(6, firstExchDateStr.length()));
            // 创建request
            Map<String, Object> request = createRequest(capitalMode, password, tradeAcco, tradeSource, fundCode,
                    balance, shareType, protocolPeriodUnit, protocolFixDay, firstExchDate, trustWay, detailFundWay);
            // 接口类型
            request.put("fund_interface_type", "");
            // 首次交易日期-YYYYMM
            request.put("first_exchdate", firstExchDate);
            // 币种类别
            request.put("money_type", GlobalConstant.MONEY_TYPE_RMB);
            // 经纪人
            request.put("broker", "");
            // 推荐人
            request.put("referee", "");
            // 业务大类
            request.put("busin_board_type", "");// 这个字段不用传,特殊业务用的

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    public static Map<String, Object> createRequest(String capitalMode, String password, String tradeAcco,
            String tradeSource, String fundCode, BigDecimal balance, String shareType, String protocolPeriodUnit,
            Long protocolFixDay, Integer firstExchDate, String trustWay, String detailFundWay) {
        Map<String, Object> request = new HashMap<String, Object>();
        // 交易委托方式:2-网上委托
        request.put("trust_way", trustWay);
        // 网点代码
        // request.put("net_no", "");
        // 交易账号
        request.put("trade_acco", tradeAcco);
        // TA账号
        request.put("ta_acco", "");
        // 密码
        request.put("password", password);
        // 申请时间
        request.put("apply_time", "");
        // 下单日期
        request.put("order_date", "");

        // 终止日期： 首次交易日的十年后
        if (firstExchDate != null) {
            Integer expiryDate = firstExchDate + 1000;
            String expiryDay = protocolFixDay < 10 ? ("0" + protocolFixDay.toString()) : protocolFixDay.toString();
            request.put("expiry_date", expiryDate.toString() + expiryDay);
        }
        // 交易周期
        request.put("trade_period", GlobalConstant.TRADE_PERIOD_ONE_MONTH);
        // 顺延天数
        request.put("extends_day", "");
        // 定投交易日
        request.put("protocol_fix_day", protocolFixDay);
        // 基金代码
        request.put("fund_code", fundCode);
        // 份额分类
        request.put("share_type", shareType);
        // 发生金额
        if (balance != null) {
            request.put("balance", balance);
        }
        // 资金方式
        request.put("capital_mode", capitalMode);
        if (detailFundWay != null) {
            // 明细资金方式
            request.put("detail_fund_way", detailFundWay);
        }
        // 协议周期单位
        request.put("protocol_period_unit", protocolPeriodUnit);
        // 交易来源申请编号
        request.put("channel_serial_id", "");
        // 交易来源 - 交易来源根据你们的需求,可以为空,如果想区别交易的来源 可以传 没有特殊需求的话 对于恒生来说只是个记录
        request.put("trade_source", tradeSource);
        return request;
    }
    
    /**
     * 根据定投交易日算出首次交易日期
     * 
     * @param protocolFixDay
     *            定投日期
     * @param protocolPeriodUnit
     *            定投周期
     * @return
     */
    public static String getFristExchDate(Long protocolFixDay, String protocolPeriodUnit) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        StringBuilder sb = new StringBuilder();

        Calendar threeOClock = Calendar.getInstance();
        threeOClock.setTime(new Date());
        threeOClock.set(Calendar.HOUR_OF_DAY, 15);// 这是时
        threeOClock.set(Calendar.MINUTE, 1);// 这是分
        threeOClock.set(Calendar.SECOND, 0);// 这是秒

        // 时间超过15：01分
        boolean hasPast = DateUtils.differDate(threeOClock.getTime(), now.getTime(), DateUtils.DIFFER_IN_SECOND) >= 0l;
        boolean isWeekUnit = GlobalConstant.PROTOCOL_PERIOD_UNIT_WEEK.equals(protocolPeriodUnit);// 协议周期单位是周

        // 交易日期是今天或者今天之前 或者 三点以后选择了明天的日期，则首次交易日是下个月
        if (isWeekUnit) {
            int dayOfWeek = DateUtils.dayOfWeek(new Date());
            dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;
            Long addDays = protocolFixDay - dayOfWeek; // 下次
            int oldDayOfWeek = dayOfWeek;
            // 周末的申请都算在周一
            if (dayOfWeek > 5) {
                dayOfWeek = 1;
                hasPast = false;
            }

            // 这里的protocolFixDay，其实是周一~周五
            // 下周
            if (protocolFixDay <= oldDayOfWeek || (addDays == 1 && hasPast)) {
                addDays = 7 - oldDayOfWeek + protocolFixDay; // 下次
            }
            // 周五15点以后的或者周末的申请都算在周一，所以要从下下周一开始扣款
            if ((oldDayOfWeek > 5 || (oldDayOfWeek == 5 && hasPast)) && protocolFixDay == 1) {
                addDays += 7;
            }
            Date nextFixDate = DateUtils.addDay(new Date(), addDays.intValue());
            return DateUtils.formatDate4(nextFixDate);
        } else if (!isWeekUnit && day >= protocolFixDay.intValue() || (protocolFixDay - day == 1 && hasPast)) {
            // 12月份
            if (month == 12) {
                year = year + 1;
                month = 1;
            } else {
                month = month + 1;
            }
        }
        String monthStr = month < 10 ? ("0" + String.valueOf(month)) : String.valueOf(month);
        sb.append(year).append(monthStr).append(protocolFixDay);
        return sb.toString();
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.FIX_ALLOT_TRADE;
    }

}
