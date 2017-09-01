package com.codi.trade.service;

import com.codi.trade.dto.ClientInfoModDto;

import java.util.Map;

/**
 * 客户资料更新
 *
 * @author shi.pengyan
 * @date 2017-05-25 13:13
 */
public interface ClientInfoModService {

    /**
     * 修改客户资料
     *
     * @param trade_acco
     * @param client_full_name
     * @param client_name
     * @param id_kind_gb
     * @param id_no
     * @param address
     * @param ofund_prof_code
     * @param birthday
     * @param mobile_tel
     * @param beneficiary
     * @param holding_name
     * @return
     */
    Map<String, Object> modAcct(String trade_acco, String client_full_name, String client_name, String id_kind_gb,
                                String id_no, String address, String ofund_prof_code, String birthday, String mobile_tel, String beneficiary, String holding_name, String tradeAccountName, String qualifiedFlag, Map<String, Object> map);

    /**
     * 修改客户资料
     *
     * @param dto
     * @return
     */
    Map<String, Object> modAcct(ClientInfoModDto dto);
}
