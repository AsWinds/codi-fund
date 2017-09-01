package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundQDIIPortfolioDetail;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:51:11
 */
public interface FundQDIIPortfolioDetailDao extends BaseDAO<FundQDIIPortfolioDetail> {

    /**
     * 
     * @param innerCode
     * @return <br/>
     *         ReportDate,<br/>
     *         SerialNumber,<br/>
     *         HoldVolume,<br/>
     *         MarketValue,<br/>
     *         RatioInNV,<br/>
     *         FundCode<br/>
     *         FundName,<br/>
     *         FundNameAbbr<br/>
     */
    List<Map<String, Object>> selectLatest(int innerCode);

}