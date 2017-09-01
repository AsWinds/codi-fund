package com.codi.bus.core.dao.impl;

import com.codi.base.dao.PageImpl;
import com.codi.base.dao.v2.GeneratedBaseDaoImpl;
import com.codi.bus.core.dao.WarningMarkHisDao;
import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.vo.WarningMarkHisSearchModel;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import com.github.pagehelper.PageRowBounds;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-06-23 15:56
 */
@Slf4j
@Repository
public class WarningMarkHisDaoImpl extends GeneratedBaseDaoImpl<WarningMarkHis> implements WarningMarkHisDao {
    @Override
    public Page<WarningMarkHisSearchModel> search(WarningMarkHisSearchVo record, Pageable pageable) {

        PageRowBounds                   prb    = new PageRowBounds(pageable.getPageNumber(), pageable.getPageSize());
        List<WarningMarkHisSearchModel> result = getSqlSession().selectList(generateStatement("search"), record, prb);


        return new PageImpl<>(result, pageable, prb.getTotal());
    }
}
