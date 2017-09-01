package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.OperationContent;

import java.util.List;

public interface OperationContentDao extends BaseDAO<OperationContent> {

    /**
     * 查询所有的首页运营内容
     * @param version
     * @return
     */
    List<OperationContent> queryOperationContents(String version);

    /**
     * 对app首页基金推荐记录进行删除
     *
     * @param id bannerID
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 对app首页基金推荐记录进行添加
     *
     * @param record
     * @return
     */
    int insert(OperationContent record);


    /**
     * 更新经过更改的app首页基金推荐记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OperationContent record);


    /**
     * 管理员得到的所有app首页基金推荐记录
     *
     * @return
     */
    List<OperationContent> selectAll();

}
