package com.codi.bus.core.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.OperationContentDao;
import com.codi.bus.core.domain.OperationContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页运营内容 Dao
 * @author song-jj
 */
@Repository("operationContentDao")
public class OperationContentDaoImpl extends BaseDAOImpl<OperationContent> implements OperationContentDao {

    /**
     * 查询所有的首页运营内容
     */
    @Override
    public List<OperationContent> queryOperationContents(String version) {
        return this.findList(generateStatement("queryOperationContents"), version);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.delete(generateStatement("deleteByPrimaryKey"), id);
    }

    @Override
    public int insert(OperationContent record) {
        return this.insert(generateStatement("insert"), record);
    }

    @Override
    public int updateByPrimaryKeySelective(OperationContent record) {
        return this.update(this.generateStatement("updateByPrimaryKeySelective"), record);
    }

    @Override
    public List<OperationContent> selectAll() {
        return this.findList(this.generateStatement("selectAll"));
    }


}
