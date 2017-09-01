package com.codi.bus.core.resultModel;

import lombok.Data;

/**
 * Created by Shangdu Lin on 2017/6/20 13:23.
 */
@Data
public class ClientInfoResult extends BaseResult {

    private String userAddress;


    private String addressCode;


    private String userOccupation;


    private String occupationCode;


    private Boolean selfSustain;


    private String beneficiary;


    private String owner;

}
