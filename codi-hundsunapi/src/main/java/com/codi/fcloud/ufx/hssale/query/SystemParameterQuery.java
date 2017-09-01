package com.codi.fcloud.ufx.hssale.query;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.SystemParameterQueryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统参数
 *
 * @author shi.pengyan
 * @version 1.0 2017-07-05 13:33
 * @since 1.0
 */

@Service
public class SystemParameterQuery extends UfxSDKFactory implements SystemParameterQueryService {

    @Loggable
    @Override
    public Map<String, Object> query(String paramItem, String paramClass) {
        String              trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request  = new HashMap<>();

        request.put("trust_way", trustWay);
        request.put("net_no", "0001");
        request.put("parameter_class", getString(paramClass)); //分类
        request.put("parameter_item", getString(paramItem)); // 参数项

        try {
            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    public Map<String, Object> query(String paramItem) {
        return this.query(paramItem, null);
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.SYSTEM_PARAMETER_QRY;
    }
}
