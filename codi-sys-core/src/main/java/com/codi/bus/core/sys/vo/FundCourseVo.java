package com.codi.bus.core.sys.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.codi.bus.core.sys.domain.FundCourse;

import lombok.Data;

/**
 * Created by Shangdu Lin on 2017/5/3 18:06.
 */
@Data
public class FundCourseVo {
    private Long courseId;

    @NotEmpty
    private String courseTitle;

    @Range(min = FundCourse.TYPE_NONE, max = FundCourse.TYPE_QUESTION)
    @NotNull
    private Integer courseType;

    private Date publishDate;

    private String publisher;

    @NotEmpty
    private String courseContent;

    private String createUserId;

    private String lastUpdatedUserId;

    private Date lastUpdatedDate;
}
