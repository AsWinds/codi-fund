package com.codi.fcloud.ufx.hssale.acco;

import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.EventTodoTranDto;
import com.codi.trade.service.EventTodoTranService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:25
 */
@Slf4j
@Service("eventTodoTranService")
public class EventTodoTranServiceImpl extends UfxSDKFactory implements EventTodoTranService {
    @Override
    public Map<String, Object> dealWith(EventTodoTranDto dto) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();

        request.put("trust_way", trustWay);
        request.put("net_no", getString(dto.getNet_no(), "0001"));
        request.put("trade_acco", getString(dto.getTrade_acco()));
        request.put("ta_acco", getString(dto.getTa_acco()));
        request.put("password", getString(dto.getPassword()));
        request.put("apply_time", getString(dto.getApply_time()));
        request.put("order_date", getString(dto.getOrder_date()));
        request.put("todo_serial_no", getString(dto.getTodo_serial_no()));
        request.put("do_type", getString(dto.getDo_type()));

        try {
            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + "event_todo_tran";
    }
}
