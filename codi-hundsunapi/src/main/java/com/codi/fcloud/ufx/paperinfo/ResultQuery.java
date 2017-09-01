package com.codi.fcloud.ufx.paperinfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;

@Service
public class ResultQuery extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/paperinfo_qry_acct";
    }

    @Loggable
    public Map<String, Object> getPaperinfoTestResult(String full_name, String id_no, String password) {
        try {
            Map<String, Object> request = new HashMap<>();
            request.put("trust_way", DEF_trust_way); // 交易委托方式
            request.put("query_type", DEF_query_type); // 查询类别(1-根据交易帐号或基金帐号查；
                                                       // 2-根据客户类型、客户名称、证件类型和证件号码查
            request.put("trade_acco", ""); // 交易账号
            request.put("ta_acco", ""); // TA帐号
            request.put("cust_type", DEF_cust_type); // 客户类别
            request.put("full_name", full_name); // 账户全称
            request.put("id_kind_gb", DEF_id_kind_gb); // 证件类别
            request.put("id_no", id_no); // 证件号码
            request.put("paper_client_type", DEF_paper_client_type); // 问卷客户类别
            request.put("password", password); // 密码

            return getUfxSDK().query(getTarget(), request).get(0);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

}
