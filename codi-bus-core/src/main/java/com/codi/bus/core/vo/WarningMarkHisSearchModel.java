package com.codi.bus.core.vo;

import com.codi.bus.core.domain.WarningMarkHis;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-26 16:23
 */
@Data
@Accessors(chain = true)
public class WarningMarkHisSearchModel extends WarningMarkHis {

    private String mobile;
}
