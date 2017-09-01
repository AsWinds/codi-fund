package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.bus.core.service.model.FundPurchaseModel;
import com.codi.bus.core.service.model.FundRedeemModel;

public class FundBuyNoticeResult extends BaseResult {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String minPurchase;// 最小购买量
    private String minHold;// 最小持有份额
    private String minRedeem; // 最小赎回份额

    private String fundType;
    private int fundTypeCode;
    private String shareType; // 份额类型

    private List<FundPurchaseModel> fundPurchaseList;
    private List<FundRedeemModel> fundRedeemList;

    public String getMinPurchase() {
        return minPurchase;
    }

    public void setMinPurchase(String minPurchase) {
        this.minPurchase = minPurchase;
    }

    public String getMinHold() {
        return minHold;
    }

    public void setMinHold(String minHold) {
        this.minHold = minHold;
    }

    public String getMinRedeem() {
        return minRedeem;
    }

    public void setMinRedeem(String minRedeem) {
        this.minRedeem = minRedeem;
    }

    public List<FundPurchaseModel> getFundPurchaseList() {
        return fundPurchaseList;
    }

    public void setFundPurchaseList(List<FundPurchaseModel> fundPurchaseList) {
        this.fundPurchaseList = fundPurchaseList;
    }

    public List<FundRedeemModel> getFundRedeemList() {
        return fundRedeemList;
    }

    public void setFundRedeemList(List<FundRedeemModel> fundRedeemList) {
        this.fundRedeemList = fundRedeemList;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public int getFundTypeCode() {
        return fundTypeCode;
    }

    public void setFundTypeCode(int fundTypeCode) {
        this.fundTypeCode = fundTypeCode;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

}
