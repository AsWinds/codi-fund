package com.codi.fcloud.ufx.hssale.warning;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.WarningContentQueryDto;
import com.codi.trade.service.WarningContentQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-31 13:55
 */
@Slf4j
@Service("warningContentQueryService")
public class WarningContentQuery extends UfxSDKFactory implements WarningContentQueryService {

    @Loggable
    @Override
    public Map<String, Object> query(WarningContentQueryDto dto) {


        try {

            // 获取第一页
            Map<String, Object> request = getRequestParams(dto);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            // 如果requestNum是我们系统定义的最大值，则表明数据需要全部取出来
            getNextResponse(request, response, dto.getRequest_num());

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.WARNING_CONTENT_QRY;
    }

    /**
     * 获取请求对象
     * @param dto
     * @return
     */
    private Map<String, Object> getRequestParams(WarningContentQueryDto dto){
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();

        request.put("trust_way", trustWay);
        request.put("net_no", getString(dto.getNet_no(), "0001"));
        request.put("trade_acco", getString(dto.getTrade_acco()));
        request.put("ta_acco", getString(dto.getTa_acco()));
        request.put("password", getString(dto.getPassword()));

        //
        request.put("client_id", getString(dto.getClient_id()));
        request.put("qry_beginrownum", getInteger(dto.getQry_beginrownum(), 1));
        request.put("sort_direction", getString(dto.getSort_direction(), HsConst.SORT_DIRECTION_ASC));
        request.put("request_num", getInteger(dto.getRequest_num(), 50));//请求行数
        request.put("reqry_recordsum_flag", getInteger(dto.getReqry_recordsum_flag(), HsConst.REQRY_RECORDSUM_FLAG_REFRESH));
        //重新统计总记录数标志
        request.put("warning_no", getString(dto.getWarning_no()));
        request.put("warning_type", getString(dto.getWarning_type()));
        request.put("warning_channel", getString(dto.getWarning_channel()));
        request.put("warning_state", getString(dto.getWarning_state()));

        return request;
    }
}
