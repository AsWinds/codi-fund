package com.codi.bus.core.service.model;

import java.util.Date;

public class UserModel {
	private String mobile;

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

	private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	private String userCard;

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserCard() {
		return userCard;
	}

	private boolean professionalFlag;

    public boolean isProfessionalFlag() {
        return professionalFlag;
    }

    public void setProfessionalFlag(boolean professionalFlag) {
        this.professionalFlag = professionalFlag;
    }

    private boolean CompletedFlag;

    public boolean isCompletedFlag() {
        return CompletedFlag;
    }

    public void setCompletedFlag(boolean completedFlag) {
        CompletedFlag = completedFlag;
    }

    private Integer investRiskTolerance;

    public Integer getInvestRiskTolerance() {
        return investRiskTolerance;
    }

    public void setInvestRiskTolerance(Integer investRiskTolerance) {
        this.investRiskTolerance = investRiskTolerance;
    }

    private Date testExpiredDate;

    public Date getTestExpiredDate() {
        return testExpiredDate;
    }

    public void setTestExpiredDate(Date testExpiredDate) {
        this.testExpiredDate = testExpiredDate;
    }

    private boolean testExpired;

    public boolean isTestExpired() {
        return testExpired;
    }

    public void setTestExpired(boolean testExpired) {
        this.testExpired = testExpired;
    }

    private Integer openFlag;

    public Integer getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Integer openFlag) {
        this.openFlag = openFlag;
    }
}
