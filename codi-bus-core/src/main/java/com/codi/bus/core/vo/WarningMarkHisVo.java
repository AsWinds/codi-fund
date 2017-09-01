package com.codi.bus.core.vo;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-23 16:50
 */
@Data
@Accessors(chain = true)
public class WarningMarkHisVo extends BaseDomain {

    private static final long serialVersionUID = 1L;
    @NotBlank
    @Length(max = 10)
    private String warningNo; //警示编号
    @Length(max = 16)
    private String browerType;// 浏览器类型
    @Length(max = 20)
    private String mac;//
    @Length(max = 1)
    private String investRiskTolerance;// 投资人风险承受能力
    @Length(max = 1)
    private String ofundRisklevel; //基金风险等级
    @Length(max = 6)
    private String fundCode;// 基金代码
    @Length(max = 3)
    private String fundBusinCode; // 业务代码
    @Length(max = 2000)
    private String markContent; // 留痕内容

    @Length(max = 200)
    private String markPage;
    @Length(max = 200)
    private String markPosition;
    @Length(max = 200)
    private String fundName;
}
