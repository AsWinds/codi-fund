package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundDividendModel;
import com.codi.bus.core.service.model.FundSharesSplitModel;

/**
 * 
 * @author shi.pengyan
 * @date 2016年10月11日 下午2:18:32
 */
public class FundDividendAndSharesSplitResult extends BaseResult {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<FundDividendModel> dividendList;
    private List<FundSharesSplitModel> sharesSplitList;

    public List<FundDividendModel> getDividendList() {
        return dividendList;
    }

    public void setDividendList(List<FundDividendModel> dividendList) {
        this.dividendList = dividendList;
    }

    public List<FundSharesSplitModel> getSharesSplitList() {
        return sharesSplitList;
    }

    public void setSharesSplitList(List<FundSharesSplitModel> sharesSplitList) {
        this.sharesSplitList = sharesSplitList;
    }
}
