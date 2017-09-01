/**
 *
 */
package com.codi.bus.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.bus.core.dao.FundInfoDao;
import com.codi.bus.core.domain.FundInfo;

/**
 * @author Administrator
 *
 */
@Repository("fundInfoDao")
public class FundInfoDaoImpl extends BaseDAOImpl<FundInfo> implements FundInfoDao {

	@Override
	public int insert(FundInfo fundInfo) {
		return this.insert(generateStatement("insert"), fundInfo);
	}

	@Override
	public List<FundInfo> queryFundInfo(String keyword) {
		return this.findList(generateStatement("queryFundInfo"), keyword);
	}

	@Override
	public int delete() {
		return this.delete(generateStatement("delete"));
	}

    @Override
    public List<FundInfo> selectFundInfoByType(Integer fundTypeCode) {
        return this.findList(generateStatement("selectFundInfoByType"), fundTypeCode);
    }

    /**
     * 分页查询
     * @return 分页查询后的基金
     */
    @Override
    public List<FundInfo> queryPage(Integer pageIndex, Integer pageSize) {
        PageView pageView = getPageView(pageIndex, pageSize);
        Map<String, Object> param = new HashMap<>();
        param.put("pageView", pageView);
        return this.findList(generateStatement("queryPage"), param);
    }

    @Override
    public List<FundInfo> queryList(Integer pageIndex, Integer pageSize) {
        PageView pageView = getPageView(pageIndex, pageSize);
        Map<String, Object> param = new HashMap<>();
        param.put("pageView", pageView);
        List<FundInfo> list = this.findList(generateStatement("queryList"), param);
        return list;
    }

    @Override
    public int queryListCount() {
        return this.getSqlSession().selectOne(generateStatement("queryListCount"));
    }

    /**
     * 根据基金类型基金
     * @param fundTypeCodes 基金类型
     * @return 基金列表
     */
    @Override
    public List<FundInfo> selectFundInfoByTypes(List<Integer> fundTypeCodes) {
        return this.findList(generateStatement("selectFundInfoByTypes"), fundTypeCodes);
    }

    /**
     * 更新已有基金的基金类型
     */
    @Override
    public int updateTypeByFundCode(FundInfo fundInfo) {
        return this.update(generateStatement("updateTypeByFundCode"), fundInfo);
    }

    /**
     * 取得所有的基金
     */
    @Override
    public List<FundInfo> queryAllFunds() {
        return this.findList(generateStatement("queryAllFunds"));
    }

}
