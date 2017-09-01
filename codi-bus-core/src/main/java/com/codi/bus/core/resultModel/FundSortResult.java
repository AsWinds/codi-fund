package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundSortModel;

/**
 * 基金排序
 * 
 * @author shi.pengyan
 * @date 2016年11月16日 下午1:08:35
 */
public class FundSortResult extends BaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<FundSortModel> sortList;

    public List<FundSortModel> getSortList() {
        return sortList;
    }

    public void setSortList(List<FundSortModel> sortList) {
        this.sortList = sortList;
    }

}
