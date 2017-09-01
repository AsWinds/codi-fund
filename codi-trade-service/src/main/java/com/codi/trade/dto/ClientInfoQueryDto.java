package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 10:43
 */

@Data
@Accessors(chain = true)
public class ClientInfoQueryDto extends BaseDomain {
    private String trust_way;//	C1	交易委托方式
    private String net_no;//C9	网点代码
    private String trade_acco;//C17	交易账号
    private String ta_acco;//C12	TA账号
    private String password;//C50	密码
    private String apply_time;//N6	申请时间
    private String order_date;//N8	下单日期
}
