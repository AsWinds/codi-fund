package com.codi.bus.core.dao;

import com.codi.base.dao.v2.GeneratedBaseDao;
import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.vo.WarningMarkHisSearchModel;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 亲，写个类注释呗
 *
 * @author spy
 * @date 2017-06-23 15:55
 */
public interface WarningMarkHisDao extends GeneratedBaseDao<WarningMarkHis> {

    /**
     * 搜索
     *
     * @param record
     * @param pageable
     * @return
     */
    Page<WarningMarkHisSearchModel> search(WarningMarkHisSearchVo record, Pageable pageable);
}
