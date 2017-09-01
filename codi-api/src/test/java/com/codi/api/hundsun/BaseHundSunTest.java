package com.codi.api.hundsun;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.codi.api.BaseTest;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.service.util.HundsunUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 11:06
 */
@Slf4j
public class BaseHundSunTest extends BaseTest {

    protected String trade_acco = "0030";
    protected String id_no = "331102199403088980";
    protected String id_kind_gb = "0";// 身份证
    protected String client_name = "陈营帅";

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("CODI_HOME", "D:\\gitlab\\codi-fund\\codi-config\\CODI_HOME\\dev");
    }


    protected void log2(Map map) {
        BaseResult result = new BaseResult();
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        log.debug("is_success={}", result.getSuccess());
    }

    protected void log(Object obj) {
        log.debug("result={}", printJSON(obj));
    }

    private String printJSON(Object obj) {
        return JSON.toJSONString(obj,
            SerializerFeature.PrettyFormat,
            SerializerFeature.MapSortField);
    }
}
