package com.codi.bus.core.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 警示留痕
 *
 * @author spy
 * @date 2017-06-23 15:55
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class WarningMarkHis extends BaseDomain {
    private static final long serialVersionUID = 1L;
    private Long    id;
    private Integer status;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date    createDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date    lastUpdateDate;
    private Long    userId;
    private String  tradeAcco;
    private String  warningNo;
    private String  allotNo;
    private String  clientId;
    private String  clientName;
    private String  idKindGb;
    private String  idNo;
    private String  ip;
    private String  browerType;
    private String  mac;
    private String  openId;
    private String  deviceId;
    private String  investRiskTolerance;
    private String  ofundRisklevel;
    private String  fundCode;
    private String  fundBusinCode;
    private String  markContent;
    private String  placeHolder;

    private String markPage;
    private String markPosition;
    private String appVersion;
    private String fundName;
    private String orderId;
}
