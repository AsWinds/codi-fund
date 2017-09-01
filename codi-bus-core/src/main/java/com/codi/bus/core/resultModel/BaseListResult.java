package com.codi.bus.core.resultModel;

public class BaseListResult extends BaseResult {
    private static final long serialVersionUID = 1L;
    

    public BaseListResult() {
    	super();
    }

    public BaseListResult(boolean success, String errorMsg) {
        super(success, errorMsg);        
    }

    // 总记录数
    private Long totalCount;

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    // 记录数
    private Long rowCount;

    public void setRowCount(Long rowCount) {
        this.rowCount = rowCount;
    }

    public Long getRowCount() {
        return this.rowCount;
    }   
    
}
