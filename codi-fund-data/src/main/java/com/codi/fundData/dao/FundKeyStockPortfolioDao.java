package com.codi.fundData.dao;

import java.util.List;
import java.util.Map;

import com.codi.base.dao.BaseDAO;
import com.codi.fundData.domain.FundKeyStockPortfolio;

/**
 * 股票类型重仓
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午5:51:26
 */
public interface FundKeyStockPortfolioDao extends BaseDAO<FundKeyStockPortfolio> {

    /**
     * 选择最新的十大重仓股票组合
     * 
     * @param innerCode
     *            内部基金编码
     * @return Map<String,Object> <br/>
     *         A.ReportDate <br/>
     *         A.SerialNumber, <br/>
     *         A.holdVolume, <br/>
     *         A.MarketValue, <br/>
     *         A.RatioInNV, <br/>
     *         C.ChiNameAbbr, <br/>
     *         C.SecuAbbr <br/>
     */
    List<Map<String, Object>> selectLatest(int innerCode);
}