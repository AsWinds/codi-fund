package com.codi.bus.core.service;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.domain.OperationContent;
import com.codi.bus.core.resultModel.OperationContentResult;

import java.util.List;

/**
 * 首页运营内容 Service
 * @author song-jj
 */
public interface OperationContentService {
    /**
     * 查询所有的首页运营内容
     */
    OperationContentResult queryOperationContent();

    /**
     * 查询所有的首页运营内容,根据配置来显示收益类型
     * @param dynamicIndicant
     * @param operationVersion
     * @return
     */
    OperationContentResult queryOperationContent(boolean dynamicIndicant,String operationVersion);

    /**
     * 管理员得到所有app首页基金推荐记录
     *
     * @return
     * @throws BaseAppException
     */
    List<OperationContent> queryOperationContentNew() throws BaseAppException;

    /**
     * 添加app首页基金推荐记录
     *
     * @return
     */
    int addOperationContent(OperationContent operationContent) throws BaseAppException;

    /**
     * 删除app首页基金推荐记录
     *
     * @param id
     * @return
     */
    int deleteOperationContent(Long id) throws BaseAppException;

    /**
     * 更新app首页基金推荐记录
     *
     * @return
     */
    int updateOperationContent(OperationContent operationContent) throws BaseAppException;

    /**
     * 基金推荐上线
     *
     * @return
     */
    int onlineOperationContent(OperationContent operationContent) throws BaseAppException;
}
