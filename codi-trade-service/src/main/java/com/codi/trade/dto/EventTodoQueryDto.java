package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 待办事项查询实体
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:07
 */
@Data
@Accessors(chain = true)
public class EventTodoQueryDto extends BaseDomain {

    private String net_no; //网点代码
    private String client_id;
    private Integer qry_beginrownum;
    private String sort_direction;
    private Integer request_num;
    private Integer reqry_recordsum_flag;
    private String fund_busin_code;
}
