/**
 * 
 */
package com.codi.bus.core.resultModel;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class FundInfoListResult  extends BaseResult {

	private static final long serialVersionUID = 1L;
	
	private List<FundInfoResult> fundInfos;

	public List<FundInfoResult> getFundInfos() {
		return fundInfos;
	}

	public void setFundInfos(List<FundInfoResult> fundInfos) {
		this.fundInfos = fundInfos;
	}
	
}
