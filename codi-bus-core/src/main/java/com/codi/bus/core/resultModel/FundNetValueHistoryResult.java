package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.resultModel.fund.FundBaseResult;
import com.codi.bus.core.service.model.FundNetValueModel;

/**
 * 基金历史返回值
 * 
 * @author shi.pengyan
 * @date 2016年9月26日 下午5:43:59
 */
public class FundNetValueHistoryResult extends FundBaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<FundNetValueModel> netValueList;

    public List<FundNetValueModel> getNetValueList() {
        return netValueList;
    }

    public void setNetValueList(List<FundNetValueModel> netValueList) {
        this.netValueList = netValueList;
    }

}
