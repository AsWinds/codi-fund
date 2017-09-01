package com.codi.fcloud.ufx.hssale.acco;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.ClientInfoModDto;
import com.codi.trade.service.ClientInfoModService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 13:18
 */
@Slf4j
@Service("clientInfoModAcctService")
public class ClientInfoModAcct extends UfxSDKFactory implements ClientInfoModService {
    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.CLIENTINFO_MOD_ACCT_V101;
    }

    @Override
    @Loggable
    public Map<String, Object> modAcct(String tradeAcco, String client_full_name, String client_name, String id_kind_gb,
                                       String id_no, String address, String ofund_prof_code, String birthday, String mobile_tel,
                                       String beneficiary, String holding_name, String tradeAccountName, String
                                           qualifiedFlag, Map<String,Object> map) {

        ClientInfoModDto dto = new ClientInfoModDto();
        dto.setMap(map);

        dto.setTrade_acco(tradeAcco).setClient_full_name(client_full_name).setClient_name(client_name).setId_kind_gb(id_kind_gb)
            .setId_no(id_no).setAddress(address).setOfund_prof_code(ofund_prof_code).setBirthday(birthday).setMobile_tel(mobile_tel)
            .setBeneficiary(beneficiary).setHolding_name(holding_name).setTrade_account_name(tradeAccountName)
            .setPub_hg_flag(qualifiedFlag);

        return this.modAcct(dto);
    }

    @Override
    @Loggable
    public Map<String, Object> modAcct(ClientInfoModDto dto) {

        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();

        Map<String,Object> map=dto.getMap();

        request.put("trust_way", trustWay);
        request.put("en_entrust_way", "0|1|1|0|0|0|0|"); //格式为：1|1|1|1|1|1|1|,1为开通，0为不开通，顺序为电话委托，网上委托，自助委托，传真委托，手机委托，经纪人委托，其他委托
        request.put("net_no", getString(dto.getNet_no(), "0001"));
        request.put("trade_acco", getString(dto.getTrade_acco()));
        request.put("password", getString(HsConst.NOPASSWORD)); //此接口不要密码
        request.put("client_full_name", getString(dto.getClient_full_name())); //客户名称全称
        request.put("client_name", getString(dto.getClient_name()));//客户姓名
        request.put("id_kind_gb", getString(dto.getId_kind_gb()));//证件类别
        request.put("id_no", getString(dto.getId_no()));// 证件号
        request.put("address", getString(dto.getAddress()));//联系地址
        request.put("ofund_prof_code", getString(dto.getOfund_prof_code()));//职业
        request.put("birthday", getString(dto.getBirthday())); //出生日期，推出年龄
        request.put("mobile_tel", getString(dto.getMobile_tel()));// 联系方式
        request.put("beneficiary", getString(dto.getBeneficiary())); // 实际收益人
        request.put("holding_name", getString(dto.getHolding_name())); // 实际控制人
        request.put("trade_account_name", getString(dto.getTrade_account_name())); // 交易账户名称
        request.put("pub_hg_flag", getString(dto.getPub_hg_flag()));// 适当性准入资格标识


        /**
         * 从查询结果中获取并设置为修改的值
         */
        request.put("order_date", getFromMap(map, "order_date", "")); // 下单日期
        request.put("apply_time", getFromMap(map, "apply_time", "")); // 申请时间
        request.put("client_gender", getFromMap(map, "client_gender", "0")); // 客户性别 //0男 1女 2非自然人
        request.put("marriage_status", getFromMap(map, "marriage_status", "0")); //TODO 常量 婚姻状况 0-未婚；1-已婚；
        request.put("education", getFromMap(map, "education", "03"));//TODO 学历 03 大专/本科

        request.put("instrepr_name", getFromMap(map, "instrepr_name")); // 法人代表姓名
        request.put("instrepr_id_no", getFromMap(map,"instrepr_id_no")); // 法人证件类型
        request.put("instrepr_id_kind_gb", getFromMap(map,"instrepr_id_kind_gb")); // 法人证件号码
        request.put("reg_address", getFromMap(map,"reg_address"));//注册地址
        request.put("trade", getFromMap(map,"trade"));// 行业
        request.put("cor_property", getFromMap(map,"cor_property"));//企业性质
        request.put("reg_capital", getFromMap(map,"reg_capital"));// 注册资本

        request.put("zipcode", getFromMap(map,"zipcode"));//		C6	邮政编码	N
        request.put("home_tel", getFromMap(map,"home_tel"));//		C20	家庭电话	N	机构开户时为必填项
        request.put("fax", getFromMap(map,"fax"));//		C32	传真号码	N
        request.put("e_mail", getFromMap(map,"e_mail"));//C64	电子信箱	N
        request.put("statement_flag", getFromMap(map,"statement_flag"));//		C1	对账单寄送选择	N
        request.put("szstock_account", getFromMap(map,"szstock_account"));//		C15	深圳主股东账号	N
        request.put("shstock_account", getFromMap(map,"shstock_account"));//		C15	上海主股东账号	N
        request.put("contact_name", getFromMap(map,"contact_name"));//		C64	经办人姓名	N
        request.put("contact_id_kind_gb", getFromMap(map,"contact_id_kind_gb"));//		C1	经办人证件类型	N
        request.put("contact_id_no", getFromMap(map,"contact_id_no"));//		C32	经办人证件号码	N
        request.put("contact_tel", getFromMap(map,"contact_tel"));//		C32	经办人电话	N
        request.put("contact_email", getFromMap(map,"contact_email"));//		C40	经办人电子邮件	N

        request.put("check_send_way", getFromMap(map,"check_send_way"));//		C1	账单寄送方式	N
        request.put("fund_card", getFromMap(map,"fund_card"));//		C32	资金卡号	N	托收签约号
        request.put("company_name", getFromMap(map,"company_name"));//		C64	公司名称	N	机构开户时为必填项
        request.put("office_tel", getFromMap(map,"office_tel"));//		C32	单位电话	N

        request.put("fund_nationality", getFromMap(map,"fund_nationality"));//		C3	国籍(基金直销)	N
        request.put("id_enddate", getFromMap(map, "id_enddate", "99991231"));//		N8	证件有效截止日期	Y
        request.put("organ_code", getFromMap(map, "organ_code"));//		C32	组织机构代码	N
        request.put("tax_register", getFromMap(map, "tax_register"));//		C32	国税税务登记号码	N
        request.put("instrepr_id_enddate", getFromMap(map, "instrepr_id_enddate"));//		N8	法人代表证件有效截至日	N
        request.put("contact_id_enddate", getFromMap(map, "contact_id_enddate"));//		N8	经办人证件有效截至日	N
        request.put("aml_risk_level", getFromMap(map, "aml_risk_level"));//		N10	反洗钱风险等级	N
        request.put("organ_valid_date", getFromMap(map, "organ_valid_date"));//		N8	组织代码证有效期	N

        request.put("contact_address", getFromMap(map, "contact_address"));//		C100	经办人地址	N
        request.put("contact_zipcode", getFromMap(map, "contact_zipcode"));//		C6	经办人邮编	N
        request.put("channel_serial_id", getFromMap(map, "channel_serial_id"));//	C32	银商流水号	N
        request.put("trade_source", getFromMap(map, "trade_source"));//	C12	交易来源	N
        request.put("hg_flag", getFromMap(map, "hg_flag"));//	C1	合格投资人标识	N
        request.put("effect_date", getFromMap(map, "effect_date"));//	C8	合格投资人生效日期	N
        request.put("effect_enddate", getFromMap(map, "effect_enddate"));//	C8	合格投资人截止日期	N
        request.put("profession_flag", getFromMap(map, "profession_flag"));//	C1	专业资质投资者	N
        request.put("pub_prof_flag", getFromMap(map, "pub_prof_flag"));//	C1	适当性专业投资者标识	N	0-否 1-是
        request.put("pub_prof_type", getFromMap(map, "pub_prof_flag"));//	C1	适当性专业投资者类别	N
        request.put("pub_prof_validdate", getFromMap(map, "pub_prof_validdate"));//	C8	适当性专业投资者有效期	N	当专业投资分类为A、B、C时候，有效期不可选，默认值为99991231，其他分类可以选择且必输有效期

        try {
            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }
}
