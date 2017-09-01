package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.base.domain.BaseResult;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月14日 下午5:23:09
 */
public class FundSortNetValueResult extends BaseResult {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** 净值列表 */
    private List<FundNetValueResult> netValueList;

    public List<FundNetValueResult> getNetValueList() {
        return netValueList;
    }

    public void setNetValueList(List<FundNetValueResult> netValueList) {
        this.netValueList = netValueList;
    }

}
