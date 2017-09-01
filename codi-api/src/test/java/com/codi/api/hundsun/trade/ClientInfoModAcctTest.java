package com.codi.api.hundsun.trade;

import com.codi.api.hundsun.BaseHundSunTest;
import com.codi.trade.service.ClientInfoModService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-26 14:07
 */
@Slf4j
public class ClientInfoModAcctTest extends BaseHundSunTest {

    @Autowired
    private ClientInfoModService clientInfoModService;

    @Test
    public void testName() {
        String client_full_name = client_name;
        String client_name = client_full_name;
        String address = "西湖";
        String ofund_prof_code = "0";
        String birthday = "19900101";
        String mobile_tel = "15850577579";
        String beneficiary = client_full_name;
        String holding_name = client_full_name;
        String pub_hg_flag="1";
        String tradeAccountName="";

        Map<String, Object> map = clientInfoModService.modAcct(trade_acco, client_full_name, client_name, id_kind_gb, id_no, address, ofund_prof_code, birthday, mobile_tel, beneficiary, holding_name, tradeAccountName, pub_hg_flag,null);
        log2(map);
        log(map);
    }
}
