package com.codi.fcloud.ufx.hssale.trade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.AllotTradeService;

@Service("allotTradeService")
public class AllotTrade extends UfxSDKFactory implements AllotTradeService {

    /**
     * 申购 申购如果是联机网银划款必须是传明细资金方式01 申购发送成功并返回申请编号，这只是代表这笔交易销售系统已经受理，如果想看是否是有效交易
     * 需要用申购编号进行交易申请查询，看扣款状态是否为有效，只有有效的交易销售系统才会发给TA
     * 
     * @author Shangdu Lin
     * @create 20160911
     */
	@Loggable
	@Override
    public Map<String, Object> buy(String capitalMode, Integer moneyType, String tradeAcco, String password,
            String fundCode, String bankCode, String bankAccount, BigDecimal balance, String shareType,
            String tradeSource) {

        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);

            Map<String, Object> request = new HashMap<String, Object>();
            // 交易委托方式:2-网上委托
            request.put("trust_way", trustWay);
            // 交易账号
            request.put("trade_acco", tradeAcco);
            // 密码
            request.put("password", password);
            // 申请时间
            request.put("apply_time", "");
            // 下单日期
            request.put("order_date", "");
            // 基金代码
            request.put("fund_code", fundCode);
            // 银行代码
            request.put("bank_no", bankCode);
            // 银行账号
            request.put("bank_account", bankAccount);
            // 份额分类
            request.put("share_type", shareType);
            // 发生金额
            request.put("balance", balance);
            // 币种类别
            request.put("money_type", moneyType);
            // 资金方式
            request.put("capital_mode", capitalMode);
            // 经纪人
            request.put("broker", "");
            // 交易退款标志
            request.put("returnflag", "");
            // 明细资金方式
            request.put("detail_fund_way", detailFundWay);
            // 业务大类
            request.put("busin_board_type", "");// 这个字段不用传,特殊业务用的
            // 交易来源 - 交易来源根据你们的需求,可以为空,如果想区别交易的来源 可以传 没有特殊需求的话 对于恒生来说只是个记录
            request.put("trade_source", tradeSource);
            // 推荐人
            request.put("referee", "");
            // 接口类型
            request.put("fund_interface_type", "");
            // 是否需要扣款
            request.put("needdeduct", "");
            // 交易来源申请编号
            request.put("channel_serial_id", "");

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.ALLOT_TRADE;
    }

}
