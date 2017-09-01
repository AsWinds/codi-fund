package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundBondPortifolioDetail;

/**
 * 债券型基金重仓
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:51:57
 */
public interface FundBondPortifolioDetailDao extends BaseDAO<FundBondPortifolioDetail> {

    /**
     * 选择最新的10条重仓组合
     * 
     * @param innerCode
     *            内部基金编码
     * @return Map<String,Object> <br/>
     *         ReportDate,<br/>
     *         SerialNumber,<br/>
     *         holdVolume,<br/>
     *         MarketValue,<br/>
     *         RatioInNV,<br/>
     *         InnerCode,<br/>
     *         ChiName<br/>
     *         FundName,<br/>
     *         FundNameAbbr<br/>
     */
    List<Map<String, Object>> selectLatest(int innerCode);

}