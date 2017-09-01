package com.codi.fcloud.ufx.hssale.acco;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.Assert;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.bus.util.IdCardUtil;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.FundAcctOpenDto;
import com.codi.trade.service.FundacctDirectOpenAcctService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("fundacctDirectOpenAcctService")
public class FundacctDirectOpenAcct extends UfxSDKFactory implements FundacctDirectOpenAcctService {

    private static final String FUND_ACCT_OPEN_URL_NEW = UrlConstants.PREFIX_SALE + "fundacct_direct_open_acct_v1.0.2";

    /**
     * 开户 开户接口说明 资金方式就是指支付渠道如M指通联 开户之前必须鉴权如通联支付渠道进行短信签约，不鉴权的话是支付渠道是无法做代扣的
     * 鉴权接口返回的protocol_no的如果有值，请在开户时用字段资金卡号把这个值传入 民生监管的销售系统必须传联行号
     * 联机网银划款的销售系统必须传明细资金方式01 快钱支付渠道需传开户行所在省份 开户时证件有效期需要传样式为99991231
     * 开户之后返回的交易账号就是客户的主交易账号，如果需要绑定其他银行卡请走鉴权—增开1交易账号 如果想换卡，请走鉴权--客户银行资料修改
     * <p>
     * 快捷身份认证（第一次调用 发送短信验证码） 快捷身份认证（第二次调用 验证短信验证码）
     * 验证通过后，再增开交易账号请求（tradeaccount_add_acct接口）给销售系统，fund_interface_type字段传1(
     * 其他渠道会用到这个字段，易宝没有用到，但为统一也传1)，
     * detail_fund_way明细资金方式传01，如果签约协议号不为空，fund_card资金卡号传短信签约返回的签约协议号，表示已开通快捷支付
     */
    @Loggable
    @Override
    public Map<String, Object> openAcct(String idNo, String tradePassword, String userName, String bankCode,
                                        String bankNo, String bankName, String mobile, String fundCard, String capitalMode) {

        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);

            Map<String, Object> request = new HashMap<String, Object>();
            // request.put("targetcomp_id", "91000");
            // request.put("sendercomp_id", "10000");

            request.put("trust_way", trustWay); // 交易委托方式
            request.put("ta_acco", ""); // TA帐号
            request.put("en_entrust_way", "0|1|1|0|1|0|0|"); // 开通委托方式-？
            request.put("netno", ""); // 网点代码
            request.put("order_date", ""); // 下单日期
            request.put("apply_time", ""); // 申请时间
            request.put("account_type", "A"); // 账户类型-？
            request.put("cust_type", "1");// 客户类别(0 机构；1个人）
            request.put("client_full_name", userName);// 客户名称全称
            request.put("client_name", userName); // 客户姓名
            request.put("id_kind_gb", "0"); // 证件类别-0:身份证
            request.put("id_no", idNo); // 证件号码 -430524199209104466
            request.put("password", tradePassword); // 密码（明文，此处的密码就是数据库中的密码，请加密传送）
            request.put("client_gender", ""); // 客户性别
            request.put("birthday", "");// 出生日期
            request.put("marriage_status", ""); // 婚姻状况
            request.put("ofund_prof_code", "");// 职业
            request.put("instrepr_name", ""); // 法人代表姓名
            request.put("instrepr_id_no", ""); // 法人证件类型
            request.put("instrepr_id_kind_gb", ""); // 法人证件号码
            request.put("address", ""); // 联系地址
            request.put("zipcode", ""); // 邮政编码
            request.put("home_tel", ""); // 绰家庭电话
            request.put("fax", ""); // 传真号码
            request.put("mobile_tel", mobile); // 手机号码（目前版本一般都需要手机号码）
            request.put("e_mail", ""); // 电子信箱
            request.put("statement_flag", ""); // 对账单寄送选择
            request.put("szstock_account", ""); // 深圳主股东账号
            request.put("shstock_account", ""); // 上海主股东账号
            request.put("contact_name", ""); // 经办人姓名
            request.put("contract_id_kind", ""); // 经办人姓名
            request.put("contact_id_no", ""); // 经办人证件类型
            request.put("contract_id_kind_gb", ""); // 经办人证件号码
            request.put("contact_tel", ""); // 经办人电话
            request.put("contact_email", ""); // 经办人电子邮件
            request.put("bank_no", bankCode); // 银行代码
            request.put("bank_name", bankName); // 银行名称
            request.put("bank_account_name", userName); // 银行户名
            request.put("bank_account", bankNo); // 银行账号
            request.put("capital_mode", capitalMode);// 传P代表易宝
            String taNo = apiValueMap.get("ta_no");
            request.put("ta_no", taNo); // TA编号 - 默认招商-17
            request.put("check_send_way", "");// 账单寄送方式
            request.put("fund_card", fundCard); // 资金卡号（支付渠道签约后返回的协议号，建议传入）
            request.put("ofund_user_type", ""); // 用户类型
            request.put("company_name", ""); // 公司名称
            request.put("office_tel", ""); // 单位电话
            request.put("remittance_no", ""); // 汇款协议号
            request.put("branchbank", ""); // 联行号（民生监管的销售商需要传）
            request.put("open_province_code", ""); // 开户行所在省份
            request.put("open_city_no", ""); // 开户行所在城市
            request.put("detail_fund_way", detailFundWay); // 明细资金方式（托收协议，可以发起联机划款）
            request.put("fund_nationality", "");// 国籍(基金直销)
            request.put("id_enddate", "99991231"); // 证件有效截止日期
            request.put("organ_code", "");// 组织机构代码
            request.put("tax_register", ""); // 国税税务登记号码
            request.put("instrepr_id_enddate", "");// 法人代表证件有效截至日
            request.put("contact_id_enddate", "");// 经办人证件有效截至日
            request.put("aml_risk_level", "");// 反洗钱风险等级
            request.put("organ_valid_date", "");// 组织代码证有效期
            request.put("refree", ""); // 推荐人
            request.put("bank_account_name_long", "");// 长银行户名
            request.put("contact_address", "");// 经办人地址
            request.put("contact_zipcode", "");// 经办人邮编
            request.put("trade_source", "");// 交易来源
            request.put("fund_interface_type", this.DEFAULT_FUND_INTERFACE_TYPE); // 接口类型-易宝这个接口没有使用
            request.put("channel_serial_id", "");// 交易来源申请编号

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    @Loggable
    public Map<String, Object> openAcct(FundAcctOpenDto dto) {

        Assert.notNull(dto.getClient_name());
        Assert.notNull(dto.getId_no());
        Assert.notNull(dto.getPassword());
        Assert.notNull(dto.getAddress());
        Assert.notNull(dto.getMobile_tel());
        Assert.notNull(dto.getBank_no());
        Assert.notNull(dto.getBank_name());
        Assert.notNull(dto.getBank_account());
        Assert.notNull(dto.getBank_account_name());

        Assert.notNull(dto.getCapital_mode());
        Assert.notNull(dto.getFund_card());

        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
            String detailFundWay = apiValueMap.get(HSInputParameterNames.DETAIL_FUND_WAY);

            String taNo = apiValueMap.get("ta_no");

            Map<String, Object> request = new HashMap<String, Object>();
            // request.put("targetcomp_id", "91000");
            // request.put("sendercomp_id", "10000");

            request.put("trust_way", trustWay); // 交易委托方式
            request.put("net_no", getString(dto.getNet_no(), "0001")); // 网点代码
            request.put("en_entrust_way", getString(dto.getEn_entrust_way(), "0|1|1|0|1|0|0|")); // 开通委托方式-？
            request.put("order_date", getString(dto.getOrder_date(), "")); // 下单日期
            request.put("apply_time", getString(dto.getApply_time(), "")); // 申请时间
            request.put("cust_type", getString(dto.getCust_type(), "1"));// 客户类别(0 机构；1个人）
            request.put("client_name", getString(dto.getClient_name())); // 客户姓名
            request.put("client_full_name", getString(dto.getClient_full_name(), dto.getClient_name()));// 客户名称全称


            request.put("id_kind_gb", getString(dto.getId_kind_gb(), "0")); // 证件类别-0:身份证
            request.put("id_no", getString(dto.getId_no())); // 证件号码 -430524199209104466
            request.put("password", getString(dto.getPassword())); // 密码（明文，此处的密码就是数据库中的密码，请加密传送）
            request.put("client_gender", getString(dto.getClient_gender(), "0")); // 客户性别 //0男 1女 2非自然人

            request.put("birthday", getString(dto.getBirthday(), IdCardUtil.getBirthday(dto.getId_no())));// 出生日期
            request.put("marriage_status", getString(dto.getMarriage_status(), "0")); //TODO 常量 婚姻状况 0-未婚；1-已婚；
            request.put("ofund_prof_code", getString(dto.getOfund_prof_code(), "9"));// 职业 // 9 其他
            request.put("education", getString(dto.getEducation(), "03"));//TODO 学历 03 大专/本科

            request.put("instrepr_name", getString(dto.getInstrepr_name())); // 法人代表姓名
            request.put("instrepr_id_no", getString(dto.getInstrepr_id_no())); // 法人证件类型
            request.put("instrepr_id_kind_gb", getString(dto.getInstrepr_id_kind_gb())); // 法人证件号码
            request.put("reg_address", getString(dto.getReg_address()));//注册地址
            request.put("trade", getString(dto.getTrade()));// 行业
            request.put("cor_property", getString(dto.getCor_property()));//企业性质
            request.put("reg_capital", getString(dto.getReg_capital()));// 注册资本
            request.put("business_range", getString(dto.getBusiness_range()));//经验范围

            request.put("address", getString(dto.getAddress()));//	C120	联系地址	Y	个人开户时为通讯地址，机构开户时为办公地址
            request.put("zipcode", getString(dto.getZipcode()));//		C6	邮政编码	N
            request.put("home_tel", getString(dto.getHome_tel()));//		C20	家庭电话	N	机构开户时为必填项
            request.put("fax", getString(dto.getFax()));//		C32	传真号码	N
            request.put("mobile_tel", getString(dto.getMobile_tel()));//		C24	手机号码	N	个人开户时为必填项
            request.put("e_mail", getString(dto.getE_mail()));//C64	电子信箱	N
            request.put("statement_flag", getString(dto.getStatement_flag()));//		C1	对账单寄送选择	N
            request.put("szstock_account", getString(dto.getSzstock_account()));//		C15	深圳主股东账号	N
            request.put("shstock_account", getString(dto.getShstock_account()));//		C15	上海主股东账号	N
            request.put("contact_name", getString(dto.getContact_name()));//		C64	经办人姓名	N
            request.put("contact_id_kind_gb", getString(dto.getContact_id_kind_gb()));//		C1	经办人证件类型	N
            request.put("contact_id_no", getString(dto.getContact_id_no()));//		C32	经办人证件号码	N
            request.put("contact_tel", getString(dto.getContact_tel()));//		C32	经办人电话	N
            request.put("contact_email", getString(dto.getContact_email()));//		C40	经办人电子邮件	N
            request.put("broker", getString(dto.getBroker()));//		C8	经纪人	N

            request.put("bank_no", getString(dto.getBank_no()));//		C4	银行代码	Y
            request.put("bank_name", getString(dto.getBank_name()));//		C64	银行名称	Y
            request.put("bank_account", getString(dto.getBank_account()));//		C32	银行账号	Y
            request.put("bank_account_name", getString(dto.getBank_account_name()));//		C60	银行户名	Y

            request.put("capital_mode", getString(dto.getCapital_mode()));//		C2	资金方式	Y
            request.put("ta_no", getString(dto.getTa_no(), taNo));//		C24	TA编号	Y
            request.put("check_send_way", getString(dto.getCheck_send_way()));//		C1	账单寄送方式	N
            request.put("fund_card", getString(dto.getFund_card()));//		C32	资金卡号	N	托收签约号
            request.put("ofund_user_type", getString(dto.getOfund_user_type()));//		C1	用户类型	N
            request.put("company_name", getString(dto.getCompany_name()));//		C64	公司名称	N	机构开户时为必填项
            request.put("office_tel", getString(dto.getOffice_tel()));//		C32	单位电话	N
            request.put("branchbank", getString(dto.getBranchbank()));//		C12	联行号	N
            request.put("open_province_code", getString(dto.getOpen_province_code()));//		C3	开户行所在省份	N
            request.put("open_city_no", getString(dto.getOpen_city_no()));//		C4	开户行所在城市	N
            request.put("detail_fund_way", getString(dto.getDetail_fund_way(), detailFundWay));//		C2	明细资金方式	N
            request.put("fund_nationality", getString(dto.getFund_nationality()));//		C3	国籍(基金直销)	N
            request.put("id_enddate", getString(dto.getId_enddate(), "99991231"));//		N8	证件有效截止日期	Y
            request.put("organ_code", getString(dto.getOrgan_code()));//		C32	组织机构代码	N
            request.put("tax_register", getString(dto.getTax_register()));//		C32	国税税务登记号码	N
            request.put("instrepr_id_enddate", getString(dto.getInstrepr_id_enddate()));//		N8	法人代表证件有效截至日	N
            request.put("contact_id_enddate", getString(dto.getContact_id_enddate()));//		N8	经办人证件有效截至日	N
            request.put("aml_risk_level", getString(dto.getAml_risk_level()));//		N10	反洗钱风险等级	N
            request.put("organ_valid_date", getString(dto.getOrgan_valid_date()));//		N8	组织代码证有效期	N
            request.put("referee", getString(dto.getReferee()));//		C40	推荐人	N
            request.put("remittance_no", getString(dto.getRemittance_no()));//		C20	汇款协议号	N
            request.put("bank_account_name_long", getString(dto.getBank_account_name_long()));//		C100	长银行户名	N
            request.put("contact_address", getString(dto.getContact_address()));//		C100	经办人地址	N
            request.put("contact_zipcode", getString(dto.getContact_zipcode()));//		C6	经办人邮编	N
            request.put("fund_interface_type", getString(dto.getFund_interface_type(), this.DEFAULT_FUND_INTERFACE_TYPE));//		C1	接口类型	N
            request.put("channel_serial_id", getString(dto.getChannel_serial_id()));//	C32	银商流水号	N
            request.put("trade_source", getString(dto.getTrade_source()));//	C12	交易来源	N
            request.put("hg_flag", getString(dto.getHg_flag()));//	C1	合格投资人标识	N
            request.put("effect_date", getString(dto.getEffect_date()));//	C8	合格投资人生效日期	N
            request.put("effect_enddate", getString(dto.getEffect_enddate()));//	C8	合格投资人截止日期	N
            request.put("profession_flag", getString(dto.getProfession_flag()));//	C1	专业资质投资者	N
            request.put("trade_acco", getString(dto.getTrade_acco()));//	C17	交易账号	N
            request.put("pub_prof_flag", getString(dto.getPub_prof_flag()));//	C1	适当性专业投资者标识	N	0-否 1-是
            request.put("pub_prof_type", getString(dto.getPub_prof_flag()));//	C1	适当性专业投资者类别	N
            request.put("pub_hg_flag", getString(dto.getPub_hg_flag(), "1"));//	C1	适当性准入资格标识	N	0-否 1-是
            request.put("pub_prof_validdate", getString(dto.getPub_prof_validdate()));//	C8	适当性专业投资者有效期	N	当专业投资分类为A、B、C时候，有效期不可选，默认值为99991231，其他分类可以选择且必输有效期
            request.put("beneficiary", getString(dto.getBeneficiary(), dto.getClient_full_name()));//	C100	账户实际收益人	Y
            request.put("holding_name", getString(dto.getHolding_name(), dto.getClient_full_name()));//	C100	账户实际控制人	Y


            // 没有这个参数
            //request.put("account_type", "A"); // 账户类型-？

            Map<String, Object> response = getUfxSDK().transact(FUND_ACCT_OPEN_URL_NEW, request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.FUNDACCT_DIRECT_OPEN_ACCT;
    }
}
