package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 客户信息修改dto
 *
 * @author shi.pengyan
 * @date 2017-05-25 13:20
 */
@Data
@Accessors(chain = true)
public class ClientInfoModDto extends BaseDomain {

    private String trust_way;//	C1	交易委托方式
    private String en_entrust_way;//		C1	开通委托方式
    private String net_no;//		C9	网点代码
    private String trade_acco;//		C17	交易账号
    private String password;//		C50	密码
    private String apply_time;//		N6	申请时间
    private String order_date;//		N8	下单日期
    private String client_full_name;//		C100	客户名称全称
    private String client_name;//		C14	客户姓名
    private String id_kind_gb;//		C1	证件类别
    private String id_no;//		C32	证件号码
    private String statement_flag;//		C1	对账单寄送选择
    private String address;//		C120	联系地址
    private String zipcode;//		C6	邮政编码
    private String home_tel;//		C20	家庭电话
    private String fax;//		C32	传真号码
    private String e_mail;//		C64	电子信箱
    private String mobile_tel;//		C24	手机号码
    private String birthday;//		N8	出生日期
    private String client_gender;//		C1	客户性别
    private String ofund_prof_code;//		C2	职业
    private String marriage_status;//		C1	婚姻状况
    private String shstock_account;//		C15	上海主股东账号
    private String szstock_account;//		C15	深圳主股东账号
    private String trade_account_name;//		C60	交易账号名称
    private String instrepr_name;//		C20	法人代表姓名
    private String instrepr_id_kind_gb;//		C1	法人证件类型
    private String instrepr_id_no;//		C32	法人证件号码
    private String contact_name;//		C64	经办人姓名
    private String contact_id_kind_gb;//		C1	经办人证件类型
    private String contact_id_no;//		C32	经办人证件号码
    private String contact_tel;//		C32	经办人电话
    private String contact_email;//		C40	经办人电子邮件
    private String check_send_way;//		C1	账单寄送方式
    private String company_name;//		C64	公司名称
    private String office_tel;//		C32	单位电话
    private String fund_nationality;//		C3	国籍(基金直销)
    private String id_enddate;//		N8	证件有效截止日期
    private String organ_code;//		C32	组织机构代码
    private String tax_register;//		C32	国税税务登记号码
    private String instrepr_id_enddate;//		N8	法人代表证件有效截至日
    private String contact_id_enddate;//		N8	经办人证件有效截至日
    private String aml_risk_level;//		N10	反洗钱风险等级
    private String organ_valid_date;//		N8	组织代码证有效期
    private String contact_address;//		C100	经办人地址
    private String contact_zipcode;//		C6	经办人邮编
    private String fund_card;//		C32	资金卡号
    private String channel_serial_id;//		C32	银商流水号
    private String trade_source;//		C12	交易来源
    private String hg_flag;//		C1	合格投资人标识
    private String effect_date;//		C8	合格投资人生效日期
    private String effect_enddate;//		C8	合格投资人截止日期
    private String profession_flag;//		C1	专业资质投资者
    private String ciphertext;//		C8	密函编号
    private String education;//		C2	学历
    private String explain;//		C100	账户备注
    private String trade;//		C3	行业
    private String cor_property;//		C3	企业性质
    private String reg_capital;//		N16.2	注册资本
    private String seller;//		C8	业务员
    private String city_no;//		C4	城市
    private String special_code;//		C20	特殊代码
    private String ture_name_flag;//		C1	客户实名状态
    private String warranty_validate;//		C8	委托授权书有效期
    private String qualification_type;//		C1	资格证书类型
    private String qualification_no;//		C30	资格证书号码
    private String qualification_validate;//		C8	资格证书有效期
    private String recipients_type;//		C1	账单收件人类型
    private String recipients_no;//		C30	账单收件人证件号码
    private String recipients_validate;//		C8	账单收件人证件有效期
    private String principal_type;//		C1	负责人证件类型
    private String principal_no;//		C30	负责人证件号码
    private String principal_validate;//		C8	负责人证件有效期
    private String holding_name;//		C100	账户实际控制人
    private String holding_id_type;//		C1	控股股东证件类型
    private String holding_id_no;//		C30	控股股东证件号码
    private String holding_id_validate;//		C8	控股股东证件有效期
    private String holding_or_no;//		C20	控股股东组织代码证号码
    private String holding_tax_no;//		C20	控股股东税务登记证号码
    private String recipients_name;//		C20	账单收件人姓名
    private String principal_name;//		C20	负责人姓名
    private String check_id_validate;//		C8	证件年检有效期
    private String aml_explain;//		C60	反洗钱备注
    private String beneficiary;//		C100	账户实际受益人
    private String trust_name;//		C100	信托委托人名称
    private String trust_phone;//		C22	信托委托人联系电话
    private String reg_address;//		C60	注册地址
    private String holding_type;//		C1	控股股东类别
    private String trust_type;//		C1	委托人证件类型
    private String trust_no;//		C30	委托人证件号码
    private String trust_contact;//		C20	委托经办人
    private String trust_address;//		C60	委托人地址
    private String trust_fax_no;//		C24	委托人传真
    private String is_annuity_flag;//		C1	企业年金账户标识
    private String is_social_flag;//		C1	社保基金账户标识
    private String org_holding_name;//		C100	控股股东名称
    private String trade_purpose;//		C10	交易目的
    private String cont_explain;//		C60	经办人备注
    private String cont_right;//		C1	经办人权限
    private String cont_relation;//		C40	经办人申请人关系
    private String location_zip;//		C6	经常居住地邮编
    private String msg_send_type;//		C20	信息发送方式
    private String tax_bodies;//		C60	税务登记证发证机构
    private String cont_warrant_validate;//		C8	经办人授权书有效期
    private String trade_contact;//		C20	交易经办人
    private String signcard_startdate;//		C8	印鉴卡启用日期
    private String recommender_phone;//		C22	推荐人联系电话
    private String recommender_province;//		C3	推荐人省份代码
    private String recommender_cityno;//		C4	推荐人城市代码
    private String net_check_flag;//		C1	网上下单是否需要审核
    private String cont_identification_mode;//		C1	经办人识别标识
    private String agreement_sign_state;//		C10	协议签订状态
    private String emoney_fundflag;//		C1	e通宝标识
    private String belong_organ;//		C8	所属机构
    private String cust_level;//	C1	客户等级
    private String link_man;//	C20	联系人
    private String cust_english_name;//		C100	客户英文名称
    private String ext_company;//		C12	外部客户编号
    private String ext_custno;//		C12	外部集团编号
    private String job_dutys;//		C60	详细工作
    private String birth_address;//	C60	出生地
    private String income_comefrom;//		C1	收入来源
    private String has_usa_nationality;//		C1	是否具有美国国籍
    private String cust_trade_kind;//		C1	交易性质
    private String pre_accosize;//		C1	预计账户规模
    private String act_busin;//		C1	实际经营业务
    private String trust_beneficiary_name;//		C60	信托受益人姓名
    private String trust_beneficiary_phone;//		C22	信托受益人电话
    private String recommender_office;//		C60	推荐人所在单位部门
    private String permanent_address;//		C60	永久地址
    private String fatca_type;//		C1	FATCA分类
    private String fatca_industry_type;//	C1	FATCA行业分类
    private String tin_no;//		C9	TIN号
    private String ein_gin_no;//		C19	EIN号/GIIN号
    private String due_diligence_date;//		C8	尽职调查日期
    private String kjzt_company_no;//		C20	基金通机构编码
    private String pub_prof_flag;//	C1	适当性专业投资者标识
    private String pub_prof_type;//	C1	适当性专业投资者类别
    private String pub_hg_flag;//	C1	适当性准入资格标识
    private String pub_prof_validdate;//		C8	适当性专业投资者有效期
    private String busin_ass_code;//		C2	业务辅助代码
    private Map<String,Object> map;
}
