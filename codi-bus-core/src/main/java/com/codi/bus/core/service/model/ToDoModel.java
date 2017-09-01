package com.codi.bus.core.service.model;

import lombok.Data;

/**
 * Created by Shangdu Lin on 2017/6/23 14:20.
 */
@Data
public class ToDoModel {
    private String businessCode;
    private String fundCode;
    private Integer riskLevel;
    private String protocolName;
    private String serialNo;
    private String warningType;
    private String placeHolder;
    private String warningContent;
    private String alloNo;
}
