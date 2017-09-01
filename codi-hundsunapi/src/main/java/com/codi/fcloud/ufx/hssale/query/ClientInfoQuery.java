package com.codi.fcloud.ufx.hssale.query;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.ClientInfoQueryDto;
import com.codi.trade.service.ClientInfoQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-25 10:46
 */
@Slf4j
@Service("clientInfoQueryService")
public class ClientInfoQuery extends UfxSDKFactory implements ClientInfoQueryService {


    @Loggable
    @Override
    public Map<String, Object> queryByTradeAcco(String tradeAcco) {
        ClientInfoQueryDto dto = new ClientInfoQueryDto();
        dto.setTrade_acco(tradeAcco);

        return query(dto);
    }

    @Loggable
    @Override
    public Map<String, Object> query(ClientInfoQueryDto dto) {

        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();


        request.put("trust_way", trustWay);
        request.put("net_no", getString(dto.getNet_no(), "0001"));
        request.put("trade_acco", getString(dto.getTrade_acco()));
        request.put("ta_acco", getString(dto.getTa_acco()));
        request.put("password", getString(HsConst.NOPASSWORD)); //此接口不要密码
        request.put("apply_time", getString(dto.getApply_time()));
        request.put("order_date", getString(dto.getOrder_date()));

        try {
            //
            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }

    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + "clientinfo_qry_acct_v1.0.2";
    }
}
