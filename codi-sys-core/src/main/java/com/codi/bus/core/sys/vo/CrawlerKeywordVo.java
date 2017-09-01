package com.codi.bus.core.sys.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by wangzhenhao on 2017/5/8.
 */
@Data
public class CrawlerKeywordVo {
    private Integer id;

    @NotEmpty
    private String keyword;
}
