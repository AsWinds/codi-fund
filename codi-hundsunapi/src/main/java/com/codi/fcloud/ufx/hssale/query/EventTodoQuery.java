package com.codi.fcloud.ufx.hssale.query;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.EventTodoQueryDto;
import com.codi.trade.service.EventTodoQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-26 14:41
 */
@Slf4j
@Service("eventTodoQueryService")
public class EventTodoQuery extends UfxSDKFactory implements EventTodoQueryService {

    @Override
    @Loggable
    public Map<String, Object> query(EventTodoQueryDto dto) {

        return query(dto.getClient_id(), dto.getQry_beginrownum(),
            dto.getSort_direction(), dto.getRequest_num(), dto.getReqry_recordsum_flag(),
            dto.getFund_busin_code());
    }

    @Loggable
    @Override
    public Map<String, Object> query(String client_id, Integer qry_beginrownum,
                                     String sort_direction, Integer request_num, Integer reqry_recordsum_flag,
                                     String fund_busin_code) {


        try {

            Map<String, Object> request = getRequestParams(client_id, qry_beginrownum, sort_direction, request_num,
                reqry_recordsum_flag, fund_busin_code);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            // 如果requestNum是我们系统定义的最大值，则表明数据需要全部取出来
            getNextResponse(request, response, request_num);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }

    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.EVENT_TODO_QRY;
    }

    /**
     * @param client_id
     * @param qry_beginrownum
     * @param sort_direction
     * @param request_num
     * @param reqry_recordsum_flag
     * @param fund_busin_code
     * @return
     */
    private Map<String, Object> getRequestParams(String client_id, Integer qry_beginrownum,
                                                 String sort_direction, Integer request_num, Integer reqry_recordsum_flag,
                                                 String fund_busin_code) {
        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);
        Map<String, Object> request = new HashMap<String, Object>();

        request.put("trust_way", trustWay);
        request.put("net_no", "0001");
        request.put("password", "");
        request.put("ext_custno", StringUtil.isNotEmpty(client_id) ? client_id : "");//客户编号
        request.put("qry_beginrownum", qry_beginrownum != null ? qry_beginrownum : 1);//查询起始行号
        request.put("sort_direction", getString(sort_direction));//返回排序方式
        request.put("request_num", getInteger(request_num, 50));//请求行数
        request.put("reqry_recordsum_flag", getInteger(reqry_recordsum_flag, 1));//重新统计总记录数标志
        request.put("fund_busin_code", getString(fund_busin_code));//业务代码

        return request;
    }
}
