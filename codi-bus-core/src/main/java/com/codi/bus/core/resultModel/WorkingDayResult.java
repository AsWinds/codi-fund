package com.codi.bus.core.resultModel;

import java.util.Date;
import java.util.List;

public class WorkingDayResult extends BaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 下一个工作日
     */
    private Date nextWorkingDay;

    public Date getNextWorkingDay() {
        return nextWorkingDay;
    }

    public void setNextWorkingDay(Date nextWorkingDay) {
        this.nextWorkingDay = nextWorkingDay;
    }

    /**
     * 上一个工作日
     */
    private Date lastWorkingDay;

    public Date getLastWorkingDay() {
        return lastWorkingDay;
    }

    public void setLastWorkingDay(Date lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }
    
    private List<Date> workingDates;
    
    public List<Date> getWorkingDates(){
    	return this.workingDates;
    }
    
    public void setWorkingDates(List<Date> workingDates){
    	this.workingDates=workingDates;
    }
    
}
