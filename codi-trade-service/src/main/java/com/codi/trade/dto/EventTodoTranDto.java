package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 待办事项处理实体
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:20
 */
@Data
@Accessors(chain = true)
public class EventTodoTranDto extends BaseDomain {

    private String net_no; //网点代码
    private String trade_acco;//   交易账号
    private String ta_acco;//TA 账号
    private String password;

    private String apply_time;// 申请时间
    private String order_date;// 下单日期
    private String todo_serial_no; //待办编号
    private String do_type;// 操作类别
}
