package com.codi.bus.core.sys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.vo.FundCourseVo;

/**
 * Created by Shangdu Lin on 2017/5/3 17:06.
 */
public interface FundCourseService {
    /**
     * 分页查询基金学堂
     * @param pageReq
     * @param title
     * @return
     */
    BaseResult queryList(Pageable pageReq, String title);

    /**
     * 新增基金学堂
     * @param vo
     * @return
     */
    BaseResult addCourse(FundCourseVo vo);

    /**
     * 更新基金学堂
     * @param vo
     * @return
     */
    BaseResult updateCourse(FundCourseVo vo);

    /**
     * 删除基金学堂
     * @param courseId
     * @return
     */
    int delete(Long courseId);

	Page<FundCourseVo> search(String keyword, Pageable pageable);

	Page<FundCourseVo> listFundCourse(Pageable pageable);

    /**
     * 根据ID查询
     * @param courseId
     * @return
     */
	FundCourseVo getCourseById(Long courseId);
}
