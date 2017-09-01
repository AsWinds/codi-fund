package com.codi.bus.core.service.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by Shangdu Lin on 2017/6/20 15:51.
 */
@Data
public class ClientInfoModel {

    private String clientFullName;

    private String clientName;


    private String idNo;


    private String idKind;

    private String mobile;

    private String birthday;

    private String professionalFlag;

    private String tradeAccount;

    private String address;

    private Integer investRiskTolerance;

    private String tradeAccountName;

    private String qualifiedFlag;

    private Map<String, Object> map;
}
