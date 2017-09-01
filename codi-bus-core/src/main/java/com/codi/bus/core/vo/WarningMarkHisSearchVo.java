package com.codi.bus.core.vo;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-23 16:50
 */
@Data
@Accessors(chain = true)
public class WarningMarkHisSearchVo extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String mobile;
    private String clientName;
    private String idNo;
    private Date   createDate;

    @Length(max = 6)
    private String fundCode;// 基金代码

}
