package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-02 15:08
 */
@Data
@Accessors(chain = true)
public class WarningMarkDto extends BaseDomain {

    private String net_no;//	C9	网点代码
    private String trust_way;//		C1	交易委托方式
    private Integer request_num;//		N10	请求行数
    private String trade_acco;//		C17	交易账号
    private String ta_acco;//		C12	TA账号
    private String password;//		C50	密码
    private String apply_time;//		N6	申请时间
    private String order_date;//		N8	下单日期
    private String warning_no;//		C10	警示编号
    private String allot_no;//		C24	申请编号
    private String client_id;//		C12	客户编号
    private String client_name;//		C60	客户姓名
    private String id_kind_gb;//		C1	证件类别
    private String id_no;//		C30	证件号码
    private String ip;//		C16	IP地址
    private String brower_type;//		C16	浏览器类型
    private String mac;//		C20	MAC地址
    private String open_id;//		C100	微信OPENID
    private String device_id;//		C200	设备号
    private String invest_risk_tolerance;//		C1	投资人风险承受能力
    private String ofund_risklevel;//		C1	基金风险等级
    private String fund_code;//	C6	基金代码
    private String fund_busin_code;//		C3	业务代码
    private String mark_content;//		C2000	留痕内容
    private String place_holder;//		C200	占位符
}
