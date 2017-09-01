package com.codi.bus.core.sys.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.codi.base.dao.PageImpl;
import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.bus.core.sys.dao.FundCourseDao;
import com.codi.bus.core.sys.domain.FundCourse;
import com.github.pagehelper.PageRowBounds;

/**
 * Created by Shangdu Lin on 2017/5/3 16:00.
 */
@Repository("fundCourseDao")
public class FundCourseDaoImpl extends GeneratedBaseDaoImpl<FundCourse> implements FundCourseDao {
    /**
     * 新增
     *
     * @param model
     * @return
     */
    @Override
    public Long add(FundCourse model) {
        model.setIsDeleted(false);
        model.setCreateDate(new Date());
        this.insert(this.generateStatement("insertSelective"), model);
        return model.getCourseId();
    }

    /**
     * 修改
     *
     * @param model
     * @return
     */
    @Override
    public int modify(FundCourse model) {
        model.setLastUpdatedDate(new Date());
        return this.update(this.generateStatement("updateByPrimaryKeySelective"),model);
    }

    /**
     * 删除
     *
     * @param courseId
     * @return
     */
    @Override
    public int delete(Long courseId) {
        FundCourse model=new FundCourse();
        model.setIsDeleted(true);
        model.setLastUpdatedDate(new Date());
        model.setCourseId(courseId);
        return this.delete(this.generateStatement("fakeDelete"),model);
    }

    /**
     * 搜索
     *
     * @param title
     * @return
     */
    @Override
    public List<FundCourse> query(String title) {
        return this.findList(this.generateStatement("selectByTitle"),title);
    }

    /**
     * 搜索
     *
     * @param pageReq
     * @param title
     * @return
     */
    @Override
    public Page<FundCourse> query(Pageable pageable, String title) {
    	PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
        Map<String, Object> map=new HashMap<>();
        map.put("title", title);
        List<FundCourse> courses= this.findList(this.generateStatement("queryByPage"), map, prb);
        return new PageImpl<FundCourse>(courses,pageable, prb.getTotal());
    }

	@Override
	public Page<FundCourse> listFundCourses(Pageable pageable) {
    	PageRowBounds prb = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
        List<FundCourse> courses= this.findList(this.generateStatement("listFundCourses"), null, prb);
        return new PageImpl<FundCourse>(courses,pageable, prb.getTotal());
	}

}
