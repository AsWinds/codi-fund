package com.codi.bus.core.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.FundInfo;

/**
 * 基金信息
 * @author Administrator
 *
 */
public interface FundInfoDao extends BaseDAO<FundInfo> {
	/**
	 * 插入基金信基本信息
	 * @param fundInfo
	 * @return
	 */
    int insert(FundInfo fundInfo);

    /**
     * 更新基金信基本信息
     * @param fundInfo
     * @return
     */
    int delete();

    /**
     * 根据关键字模糊查询基金信息
     * @param keyword 关键字
     * @return 基金信息列表
     */
    List<FundInfo> queryFundInfo(String keyword);

    /**
     * 根据基金类型基金
     * @param fundTypeCode 基金类型
     * @return 基金列表
     */
    List<FundInfo> selectFundInfoByType(Integer fundTypeCode);

    /**
     * 分页查询
     * @return 分页查询后的基金
     */
    List<FundInfo> queryPage(Integer pageIndex, Integer pageSize);


    /**
     * 分页查询
     *
     * @return 分页查询后的基金部分字段, 并按code排序
     */
    List<FundInfo> queryList(Integer pageIndex, Integer pageSize);

    int queryListCount();



    /**
     * 根据基金类型基金
     * @param fundTypeCode 基金类型
     * @return 基金列表
     */
    List<FundInfo> selectFundInfoByTypes(List<Integer> fundTypeCodes);

    /**
     * 更新已有基金的基金类型
     * @param fundInfo
     * @return
     */
    int updateTypeByFundCode(FundInfo fundInfo);

    /**
     * 取得所有基金
     * @return
     */
    List<FundInfo> queryAllFunds();


}
