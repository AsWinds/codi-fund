package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FixModel;

/**
 * @author song-jj
 *
 */
public class FixListResult extends BaseListResult {

    private static final long serialVersionUID = 1L;

    /**
     * 已定投的基金
     */
    private List<FixModel> fixes;

    public List<FixModel> getFixes() {
        return fixes;
    }

    public void setFixes(List<FixModel> fixes) {
        this.fixes = fixes;
    }
    
}
