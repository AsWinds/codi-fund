package com.codi.bus.core.service;

import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.vo.WarningMarkHisSearchModel;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 警示留痕服务
 *
 * @author shi.pengyan
 * @date 2017-06-23 15:57
 */
public interface WarningMarkHisService {

    /**
     * 添加警示留痕， 只插入DB
     *
     * @param record
     * @return
     */
    int addLocal(WarningMarkHis record);

    /**
     * 添加警示留痕， 插入DB,同步发送hundsun
     *
     * @param record
     * @return
     */
    BaseResult addLocalAndSync(WarningMarkHis record);


    /**
     * 搜索
     *
     * @param record
     * @return
     */
    Page<WarningMarkHisSearchModel> search(WarningMarkHisSearchVo record, Pageable pageable);

}
