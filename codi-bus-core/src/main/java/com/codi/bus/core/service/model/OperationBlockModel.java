package com.codi.bus.core.service.model;

import java.util.List;

/**
 * 运营区块Model
 * @author song-jj
 */
public class OperationBlockModel {
    /**
     * 区块
     */
    private String blockName;
    
    /**
     * 内容
     */
    private List<OperationContentModel> funds;

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public List<OperationContentModel> getFunds() {
        return funds;
    }

    public void setFunds(List<OperationContentModel> funds) {
        this.funds = funds;
    }
    
}
