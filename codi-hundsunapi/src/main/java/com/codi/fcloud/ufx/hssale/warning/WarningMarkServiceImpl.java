package com.codi.fcloud.ufx.hssale.warning;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.WarningMarkDto;
import com.codi.trade.service.WarningMarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 警示内容
 *
 * @author shi.pengyan
 * @date 2017-06-02 15:13
 */
@Slf4j
@Service("warningMarkService")
public class WarningMarkServiceImpl extends UfxSDKFactory implements WarningMarkService {
    @Override
    @Loggable
    public Map<String, Object> save(WarningMarkDto dto) {
        //
        String              trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request  = new HashMap<String, Object>();

        request.put("trust_way", trustWay);
        request.put("net_no", getString(dto.getNet_no(), "0001"));
        request.put("request_num", getInteger(dto.getRequest_num(), 50));//请求行数
        request.put("trade_acco", getString(dto.getTrade_acco()));
        request.put("ta_acco", getString(dto.getTa_acco()));
        request.put("password", getString(dto.getPassword()));
        request.put("apply_time", getString(dto.getApply_time()));
        request.put("order_date", getString(dto.getOrder_date()));
        request.put("warning_no", getString(dto.getWarning_no()));
        request.put("allot_no", getString(dto.getAllot_no()));
        request.put("client_id", getString(dto.getClient_id()));
        request.put("client_name", getString(dto.getClient_name()));
        request.put("id_kind_gb", getString(dto.getId_kind_gb()));
        request.put("id_no", getString(dto.getId_no()));
        request.put("ip", getString(dto.getIp()));
        request.put("brower_type", getString(dto.getBrower_type()));
        request.put("mac", getString(dto.getMac()));
        request.put("open_id", getString(dto.getOpen_id()));
        request.put("device_id", getString(dto.getDevice_id()));
        request.put("invest_risk_tolerance", getString(dto.getInvest_risk_tolerance()));
        request.put("ofund_risklevel", getString(dto.getOfund_risklevel()));
        request.put("fund_code", getString(dto.getFund_code()));
        request.put("fund_busin_code", getString(dto.getFund_busin_code()));
        request.put("mark_content", getString(dto.getMark_content()));
        request.put("place_holder", getString(dto.getPlace_holder()));

        try {
            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.WARNING_MARK;
    }
}
