/**
 *
 */
package com.codi.bus.core.service;

import java.util.List;

import com.codi.bus.core.domain.FundInfo;
import com.codi.bus.core.resultModel.FundInfoListResult;
import com.codi.bus.core.service.model.FundModel;

/**
 * 基金基本信息 service
 * @author song-jj
 *
 */
public interface FundInfoService {
	/**
	 * 根据从恒生查询的基金数据，插入到数据库中
	 * @param fundList
	 */
	void insertFundInfo(List<FundModel> fundList) throws Exception;

	/**
	 * 查询基金基本信息
	 * @return
     * @throws Exception
     */
	FundInfoListResult query(String keyword) throws Exception;

    /**
	 * 根据基金类型代码，查询基金
	 * @param fundTypeCode 基金类型代码
	 * @return 基金基本信息列表
	 */
	List<FundInfo> queryFundInfoByType(Integer fundTypeCode);

    /**
     * 分页查询基金
     * @param pageSize 一页的记录数
     * @param pageIndex 当前页
     * @return 基金列表
     */
    List<FundInfo> queryPage(Integer pageSize, Integer pageIndex);

    /**
     * 分页查询基金部分字段，按code排序
     *
     * @param pageSize  一页的记录数
     * @param pageIndex 当前页
     * @return 基金列表
     */
    List<FundInfo> queryList(Integer pageSize, Integer pageIndex);

    int queryListCount();

	/**
     * 根据基金类型代码，查询基金
     * @param fundTypeCodes 基金类型代码 列表
     * @return 基金基本信息列表
     */
    List<FundInfo> queryFundInfoByTypes(List<Integer> fundTypeCodes);

    /**
     * 更新已有基金的基金类型
     */
    int updateFundType();
}
