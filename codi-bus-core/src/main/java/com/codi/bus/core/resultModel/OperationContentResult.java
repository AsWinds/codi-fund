package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.OperationBlockModel;

/**
 * 首页运营内容
 * @author song-jj
 */
public class OperationContentResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    /**
     * 区块列表
     */
    private List<OperationBlockModel> blocks;

    public List<OperationBlockModel> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<OperationBlockModel> blocks) {
        this.blocks = blocks;
    }
}
