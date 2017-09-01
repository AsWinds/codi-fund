package com.codi.fcloud.ufx.hssale.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;

@Service("rateQuery")
public class RateQuery extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/rate_qry";
    }

    @Loggable
    public List<Map<String, Object>> query(String fund_code, String fund_busin_code) {
        try {
            int page_size = 20;
            List<Map<String, Object>> firstPage = getUfxSDK().query(getTarget(),
                    getRequest(fund_code, fund_busin_code, "1", page_size, 1));
            if (firstPage.size() == 0) {
                throw new RuntimeException("HS returned unexpected result, the list length is 0!!!");
            }
            if (firstPage.size() == 1 && StringUtils.isNotBlank((String) firstPage.get(0).get("error_code"))) {
                return new ArrayList<>(0);
            }
            if (firstPage.size() < page_size) {
                return firstPage;
            }
            List<Map<String, Object>> res = new ArrayList<>(firstPage);
            for (;;) {
                List<Map<String, Object>> current = getUfxSDK().query(getTarget(),
                        getRequest(fund_code, fund_busin_code, "0", page_size, res.size() + 1));
                res.addAll(current);
                if (current.size() < page_size) {
                    break;
                }
                continue;
            }
            return res;
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    private Map<String, Object> getRequest(String fund_code, String fund_busin_code, String reqry_recordsum_flag,
            int request_num, int qry_beginrownum) {
        Map<String, Object> request = new HashMap<>();
        request.put("trust_way", DEF_trust_way); // 交易委托方式
        request.put("request_num", String.valueOf(request_num)); // 请求行数
        request.put("reqry_recordsum_flag", reqry_recordsum_flag); // 重新统计总记录数标志
        request.put("qry_beginrownum", String.valueOf(qry_beginrownum)); // 查询起始行号
        request.put("fund_code", fund_code); // 基金代码
        // request.put("share_type", ""); // 份额类型
        request.put("sort_direction", ""); // 排序方式
        request.put("fund_busin_code", fund_busin_code);
        return request;
    }

}
