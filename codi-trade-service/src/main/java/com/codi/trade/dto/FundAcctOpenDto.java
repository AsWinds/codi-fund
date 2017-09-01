package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 基金账户开户模型
 *
 * @author shi.pengyan
 * @date 2017-06-19 13:30
 */
@Data
@Accessors(chain = true)
public class FundAcctOpenDto extends BaseDomain {
    private String trust_way; //	C1	交易委托方式	Y
    private String net_no; //	C9	网点代码	N	不传则使用默认值"0001" ，有传值（包括空）则使用所传值
    private String en_entrust_way; //	C1	开通委托方式	Y	格式为：1|1|1|1|1|1|1|,1为开通，0为不开通，顺序为电话委托，网上委托，自助委托，传真委托，手机委托，经纪人委托，其他委托
    private String order_date; //	N8	下单日期	N	为空则下单日期取服务器收到报文的请求日期；不为空则该日期为下单日期；
    private String apply_time; //	N6	申请时间	N
    private String cust_type; //	C1	客户类别	Y	1-个人；0-机构
    private String client_full_name; //	C100	客户名称全称	Y
    private String client_name; //	C14	客户姓名	Y
    private String id_kind_gb; //	C1	证件类别	Y
    private String id_no; //	C32	证件号码	Y
    private String password; //	C50	密码	Y
    private String client_gender; //	C1	客户性别	N
    private String birthday; //	N8	出生日期	Y
    private String marriage_status; //	C1	婚姻状况	Y	0-未婚；1-已婚；
    private String ofund_prof_code; //	C2	职业	N	个人开户时为必填项
    private String education; //	C2	学历	N	个人开户时为必填项
    private String instrepr_name; //	C20	法人代表姓名	N	机构开户时为必填项
    private String instrepr_id_kind_gb; //	C1	法人证件类型	N	机构开户时为必填项
    private String instrepr_id_no; //	C32	法人证件号码	N	机构开户时为必填项
    private String reg_address; //	C60	注册地址	N	机构开户时为必填项
    private String trade; //	C3	行业	N	机构开户时为必填项
    private String cor_property; //	C3	企业性质	N	机构开户时为必填项
    private String reg_capital; //	N16.2	注册资本	N	机构开户时为必填项
    private String business_range; //	C60	经营范围	N	机构开户时为必填项
    private String address; //	C120	联系地址	Y	个人开户时为通讯地址，机构开户时为办公地址
    private String zipcode; //	C6	邮政编码	N
    private String home_tel; //	C20	家庭电话	N	机构开户时为必填项
    private String fax; //	C32	传真号码	N
    private String mobile_tel; //	C24	手机号码	N	个人开户时为必填项
    private String e_mail; //	C64	电子信箱	Y
    private String statement_flag; //	C1	对账单寄送选择	N
    private String szstock_account; //	C15	深圳主股东账号	N
    private String shstock_account; //	C15	上海主股东账号	N
    private String contact_name; //	C64	经办人姓名	N
    private String contact_id_kind_gb; //	C1	经办人证件类型	N
    private String contact_id_no; //	C32	经办人证件号码	N
    private String contact_tel; //	C32	经办人电话	N
    private String contact_email; //	C40	经办人电子邮件	N
    private String broker; //	C8	经纪人	N
    private String bank_no; //	C4	银行代码	Y
    private String bank_name; //	C64	银行名称	Y
    private String bank_account; //	C32	银行账号	Y
    private String bank_account_name; //	C60	银行户名	Y
    private String capital_mode; //	C2	资金方式	Y
    private String ta_no; //	C24	TA编号	Y
    private String check_send_way; //	C1	账单寄送方式	N
    private String fund_card; //	C32	资金卡号	N	托收签约号
    private String ofund_user_type; //	C1	用户类型	N
    private String company_name; //	C64	公司名称	N	机构开户时为必填项
    private String office_tel; //	C32	单位电话	N
    private String branchbank; //	C12	联行号	N
    private String open_province_code; //	C3	开户行所在省份	N
    private String open_city_no; //	C4	开户行所在城市	N
    private String detail_fund_way; //	C2	明细资金方式	N
    private String fund_nationality; //	C3	国籍(基金直销)	N
    private String id_enddate; //	N8	证件有效截止日期	Y
    private String organ_code; //	C32	组织机构代码	N
    private String tax_register; //	C32	国税税务登记号码	N
    private String instrepr_id_enddate; //	N8	法人代表证件有效截至日	N
    private String contact_id_enddate; //	N8	经办人证件有效截至日	N
    private String aml_risk_level; //	N10	反洗钱风险等级	N
    private String organ_valid_date; //	N8	组织代码证有效期	N
    private String referee; //	C40	推荐人	N
    private String remittance_no; //	C20	汇款协议号	N
    private String bank_account_name_long; //	C100	长银行户名	N
    private String contact_address; //	C100	经办人地址	N
    private String contact_zipcode; //	C6	经办人邮编	N
    private String fund_interface_type; //	C1	接口类型	N
    private String channel_serial_id; //	C32	银商流水号	N
    private String trade_source; //	C12	交易来源	N
    private String hg_flag; //	C1	合格投资人标识	N
    private String effect_date; //	C8	合格投资人生效日期	N
    private String effect_enddate; //	C8	合格投资人截止日期	N
    private String profession_flag; //	C1	专业资质投资者	N
    private String trade_acco; //	C17	交易账号	N
    private String pub_prof_flag; //	C1	适当性专业投资者标识	N	0-否 1-是
    private String pub_prof_type; //	C1	适当性专业投资者类别	N
    private String pub_hg_flag; //	C1	适当性准入资格标识	N	0-否 1-是
    private String pub_prof_validdate; //	C8	适当性专业投资者有效期	N	当专业投资分类为A、B、C时候，有效期不可选，默认值为99991231，其他分类可以选择且必输有效期
    private String beneficiary; //	C100	账户实际收益人	Y
    private String holding_name; //	C100	账户实际控制人	Y


}
