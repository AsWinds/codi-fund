package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundDetail;

/**
 * 基金详情相关接口
 * 
 * @author shi.pengyan
 * @date 2016年10月28日 下午2:41:32
 */
public interface FundDetailDao extends BaseDAO<FundDetail> {

    /**
     * 查询基金
     * 
     * @param innerCode
     *            内部编码
     * @return
     */
    FundDetail queryFundDetail(Integer innerCode);

    /**
     * 基金详情
     * 
     * @param fundCode
     *            基金代码
     * @return
     */
    FundDetail queryByFundCode(String fundCode);

    /**
     * 查询管理人下的管理的基金列表
     * 
     * @param investAdvisorCode
     *            管理人编码
     * @return
     */
    List<Map<String, Object>> queryByInvestAdvisorCode(int investAdvisorCode, int pageIndex, int pageSize);
}