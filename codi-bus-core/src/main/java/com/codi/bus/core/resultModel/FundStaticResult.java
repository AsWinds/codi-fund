package com.codi.bus.core.resultModel;

import java.math.BigDecimal;
import java.util.List;

import com.codi.bus.core.resultModel.fund.FundBaseResult;
import com.codi.bus.core.service.model.FundStatisticModel;

/**
 * 图表趋势图中数据
 * 
 * @author shi.pengyan
 * @date 2016年11月4日 上午10:53:26
 */
public class FundStaticResult extends FundBaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<FundStatisticModel> netValueList;
    private List<FundStatisticModel> sh300List;

    private int monthCount; // 统计的月份数
    private BigDecimal fundTotal; // 基金统计数据
    private BigDecimal sh300Total;// 深沪 统计数据

    public List<FundStatisticModel> getNetValueList() {
        return netValueList;
    }

    public void setNetValueList(List<FundStatisticModel> netValueList) {
        this.netValueList = netValueList;
    }

    public List<FundStatisticModel> getSh300List() {
        return sh300List;
    }

    public void setSh300List(List<FundStatisticModel> sh300List) {
        this.sh300List = sh300List;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    public BigDecimal getFundTotal() {
        return fundTotal;
    }

    public void setFundTotal(BigDecimal fundTotal) {
        this.fundTotal = fundTotal;
    }

    public BigDecimal getSh300Total() {
        return sh300Total;
    }

    public void setSh300Total(BigDecimal sh300Total) {
        this.sh300Total = sh300Total;
    }

}
