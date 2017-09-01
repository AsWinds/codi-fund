package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundAssetAllocationModel;
import com.codi.bus.core.service.model.FundInvestIndustryModel;
import com.codi.fundData.domain.FundPortifolio;

/**
 * 资产分布
 * 
 * @author shi.pengyan
 * @date 2016年10月24日 下午4:15:32
 */
public class FundAssetAllocationResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private List<FundAssetAllocationModel> assetAllocations; // 资产组合
    private List<FundPortifolio> portifolios;// 十大重仓
    private List<FundInvestIndustryModel> industrys;// 行业分布

    public List<FundAssetAllocationModel> getAssetAllocations() {
        return assetAllocations;
    }

    public void setAssetAllocations(List<FundAssetAllocationModel> assetAllocations) {
        this.assetAllocations = assetAllocations;
    }

    public List<FundPortifolio> getPortifolios() {
        return portifolios;
    }

    public void setPortifolios(List<FundPortifolio> portifolios) {
        this.portifolios = portifolios;
    }

    public List<FundInvestIndustryModel> getIndustrys() {
        return industrys;
    }

    public void setIndustrys(List<FundInvestIndustryModel> industrys) {
        this.industrys = industrys;
    }

}
