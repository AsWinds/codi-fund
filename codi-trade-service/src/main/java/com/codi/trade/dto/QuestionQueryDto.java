package com.codi.trade.dto;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-21 13:30
 */
@Data
@Accessors(chain = true)
public class QuestionQueryDto extends BaseDomain {

    private String trust_way;//	C1	交易委托方式
    private String net_no;//	C9	网点代码
    private String request_num;//	N10	请求行数
    private String reqry_recordsum_flag;//	N10	重新统计总记录数标志
    private String qry_beginrownum;//	N10	查询起始行号
    private String sort_direction;//	C1	返回排序方式
    private String question_no;//	N10	问题编号
    private String answer_object;//	C1	回答对象, 0：机构，1：个人
    private String paper_client_type;//	C1	问卷客户类别
    private String integrity_flag;//	C1	诚信标志
}
