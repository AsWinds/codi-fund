package com.codi.fcloud.ufx.hssale.query;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.DateUtils;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.NextDayQueryService;

@Service("nextDayQueryService")
public class NextDayQuery extends UfxSDKFactory implements NextDayQueryService {

    /**
     * 获取下一工作日,默认只传回一条记录，不管request_num是否比1大
     * 
     * @param currentDate
     * @return
     */
	@Loggable
	@Override
    public Map<String, Object> query(Date currentDate) {
        try {
            // 获取第一页
            Map<String, Object> request = getRequestParams(currentDate);

            List<Map<String, Object>> response = getUfxSDK().query(getTarget(), request);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.NEXT_DAY_QRY;
    }

    /**
     * 获取请求参数 默认只传回一条记录，不管request_num是否比1大 账号的入参都没有作用
     * 
     * @param currentDate
     * @return
     */
    private Map<String, Object> getRequestParams(Date currentDate) {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("net_no", ""); // 网点代码
        request.put("request_num", "1"); // 请求行数
        request.put("reqry_recordsum_flag", "1"); // 重新统计总记录数标志
        request.put("qry_beginrownum", "1"); // 查询起始行号
        request.put("sort_direction", "1"); // 查询起始行号
        request.put("trade_acco", ""); // 交易帐号
        request.put("ta_acco", ""); // TA账号
        request.put("client_id", ""); // 客户编号
        // yyyyMMdd
        request.put("day", DateUtils.formatDate4(currentDate)); // 当前工作日

        return request;
    }

}
