package com.codi.bus.core.sys.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.dao.FundCourseDao;
import com.codi.bus.core.sys.domain.FundCourse;
import com.codi.bus.core.sys.service.FundCourseService;
import com.codi.bus.core.sys.vo.FundCourseVo;

/**
 * Created by Shangdu Lin on 2017/5/3 17:09.
 */
@Service("fundCourseService")
public class FundCourseServiceImpl implements FundCourseService {

    @Autowired
    private FundCourseDao fundCourseDao;

    /**
     * 分页查询基金学堂
     *
     * @param pageReq
     * @param title
     * @return
     */
    @Override
    public BaseResult queryList(Pageable pageReq, String title) {
        Page<FundCourse> courses = fundCourseDao.query(pageReq, title);
        return new PageResult<>(courses.map(new Converter<FundCourse, Object>() {
            @Override
            public Object convert(FundCourse fundCourse) {
                FundCourseVo vo=new FundCourseVo();
                BeanUtils.copyProperties(fundCourse,vo);

                return vo;
            }
        }));
    }

    /**
     * 新增基金学堂
     * @param vo
     * @return
     */
    @Override
    public BaseResult addCourse(FundCourseVo vo){
        FundCourse fundCourse=new FundCourse();
        BeanUtils.copyProperties(vo,fundCourse);
        fundCourseDao.add(fundCourse);

        FundCourseVo fundCourseVo=new FundCourseVo();
        BeanUtils.copyProperties(fundCourse,fundCourseVo);

        return new BaseResult(fundCourseVo);
    }

    /**
     * 更新基金学堂
     * @param vo
     * @return
     */
    @Override
    public BaseResult updateCourse(FundCourseVo vo){
        FundCourse fundCourse=new FundCourse();
        BeanUtils.copyProperties(vo,fundCourse);
        fundCourseDao.modify(fundCourse);

        FundCourseVo fundCourseVo=new FundCourseVo();
        BeanUtils.copyProperties(fundCourse,fundCourseVo);

        return new BaseResult(fundCourseVo);
    }

    /**
     * 删除基金学堂
     * @param courseId
     * @return
     */
    @Override
    public int delete(Long courseId){
        return fundCourseDao.delete(courseId);
    }

	@Override
	public Page<FundCourseVo> search(String keyword, Pageable pageable) {
		Page<FundCourse> page = fundCourseDao.query(pageable, keyword);
		return page.map(new Converter<FundCourse, FundCourseVo>() {

			@Override
			public FundCourseVo convert(FundCourse source) {
				FundCourseVo vo = new FundCourseVo();
				BeanUtils.copyProperties(source, vo);
				return vo;
			}
		});
	}

	@Override
	public Page<FundCourseVo> listFundCourse(Pageable pageable) {
		Page<FundCourse> page = fundCourseDao.listFundCourses(pageable);
		return page.map(new Converter<FundCourse, FundCourseVo>() {

			@Override
			public FundCourseVo convert(FundCourse source) {
				FundCourseVo vo = new FundCourseVo();
				BeanUtils.copyProperties(source, vo);
				return vo;
			}
		});
	}

    /**
     * 根据ID查询
     *
     * @param courseId
     * @return
     */
    @Override
    public FundCourseVo getCourseById(Long courseId) {
        FundCourseVo vo = new FundCourseVo();
        FundCourse source = fundCourseDao.selectByPrimaryKey(courseId);
        if (source == null) {
            return null;
        }
        BeanUtils.copyProperties(source, vo);
        return vo;
    }
}
