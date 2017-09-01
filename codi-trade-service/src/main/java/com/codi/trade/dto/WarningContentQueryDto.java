package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 警示内容查询
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:51
 */
@Data
@Accessors(chain = true)
public class WarningContentQueryDto extends BaseDomain {

    private String trust_way;//	C1	交易委托方式
    private String net_no;//C9	网点代码
    private String trade_acco;//	C17	交易账号
    private String ta_acco;//C12	TA账号
    private String client_id;//C18	客户编号
    private String password;

    private Integer qry_beginrownum;//N10	查询起始行号
    private String sort_direction;//C1	返回排序方式
    private Integer request_num;//N10	请求行数
    private Integer reqry_recordsum_flag;//N10	重新统计总记录数标志
    private String warning_no;//C10	警示编号
    private String warning_type;//C1	警示类型
    private String warning_channel;//C1	警示渠道
    private String warning_state;//C1	警示状态

}
