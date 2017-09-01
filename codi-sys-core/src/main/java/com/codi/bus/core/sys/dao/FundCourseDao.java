package com.codi.bus.core.sys.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.bus.core.sys.domain.FundCourse;

/**
 * 亲，写个类注释呗
 * @author admin
 * @date 2017-05-03 15:29
 */
public interface FundCourseDao extends GeneratedBaseDao<FundCourse> {
    /**
     * 新增
     * @param model
     * @return
     */
    Long add(FundCourse model);

    /**
     * 修改
     * @param model
     * @return
     */
    int modify(FundCourse model);

    /**
     * 删除
     * @param courseId
     * @return
     */
    int delete(Long courseId);

    /**
     * 搜索
     * @param title
     * @return
     */
    List<FundCourse> query(String title);

    /**
     * 搜索
     * @param title
     * @return
     */
    Page<FundCourse> query(Pageable pageReq, String title);

    /**
     * 
     * APP端获取课堂列表
     * */
	Page<FundCourse> listFundCourses(Pageable pageable);

}
