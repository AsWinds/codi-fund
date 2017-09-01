package com.codi.fcloud.ufx.hssale.acco;

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
import com.codi.trade.service.TradeAccountAddAcctService;

@Service("tradeAccountAddAcctService")
public class TradeAccountAddAcct extends UfxSDKFactory implements TradeAccountAddAcctService {

    /**
     * 增开交易帐号 增开交易账号对应的业务是增绑银行卡，业务流程是鉴权--增开交易账号，入参需要传入原有交易账号密码和新卡信息
     * 
     * @author ${user}
     * @create ${date}
     */
	@Loggable
	@Override
    public Map<String, Object> addAcct(String idNo, String tradePassword, String userName, String bankCode,
            String bankNo, String bankName, String mobile, String fundCard, String capitalMode,
            String mainTradeAccount) {

        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);

            Map<String, Object> request = new HashMap<String, Object>();

            request.put("trust_way", trustWay); // 交易委托方式
            request.put("trade_acco", mainTradeAccount); // 主交易账号
            request.put("ta_acco", ""); // TA账号
            request.put("apply_time", ""); // 申请时间；
            request.put("order_date", ""); // 下单时间；
            request.put("password", tradePassword); // 密码；
            // request.put("trade_account_name", "张六"); // 交易账号名称
            request.put("home_tel", ""); // 家庭电话
            request.put("contact_name", ""); // 经办人姓名
            request.put("contract_id_kind", ""); // 经办人证件类型
            request.put("contact_id_no", ""); // 经办人证件号码
            request.put("contact_tel", ""); // 经办人电话
            request.put("contact_email", ""); // 经办人电子邮件
            request.put("statement_flag", ""); // 对账单寄送选择
            request.put("address", ""); // 联系地址
            request.put("zipcode", ""); // 邮政编码
            request.put("mobile_tel", mobile); // 联系人电话
            request.put("fax", ""); // 传真号码
            request.put("e_mail", ""); // 电子邮箱
            request.put("bank_no", bankCode); // 银行代码
            request.put("bank_name", bankName); // 银行名称
            request.put("bank_account_name", userName); // 银行户名
            request.put("bank_account", bankNo); // 银行账号
            request.put("capital_mode", capitalMode); // 资金方式
            request.put("check_send_way", ""); // 账单寄送方式
            request.put("company_name", ""); // 公司名称
            request.put("office_tel", ""); // 公司电话
            request.put("fund_card", fundCard); // 资金卡号
            request.put("bank_open_id_kind_gb", "0"); // 银行开户证件类型 - 证件类别-0:身份证
            request.put("bank_open_id_no", idNo); // 银行开户证件号码
            request.put("detail_fund_way", detailFundWay); // 明细资金方式
            request.put("fund_interface_type", this.DEFAULT_FUND_INTERFACE_TYPE); // 接口类型
            request.put("bank_account_name_long", ""); // 长银行用户名
            request.put("channel_serial_id", ""); // 交易来源申请编号

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
        return UrlConstants.PREFIX_SALE + UrlConstants.TRADEACCOUNT_ADD_ACCT;
    }
}
