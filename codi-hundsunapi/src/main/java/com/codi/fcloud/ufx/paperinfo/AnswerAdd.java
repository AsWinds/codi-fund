package com.codi.fcloud.ufx.paperinfo;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnswerAdd extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/paperinfo_add_acct";
    }

    @Loggable
    public Map<String, Object> addPaperInfoAcct(String full_name, String id_no, String elig_content,
            String invest_risk_tolerance) {
        try {
            Map<String, Object> request = new HashMap<String, Object>();
            request.put("trust_way", DEF_trust_way); // 委托方式
            request.put("cust_type", DEF_cust_type); // 客户类别
            request.put("full_name", full_name); // 账户全称
            request.put("id_kind_gb", DEF_id_kind_gb); // 证件类别
            request.put("id_no", id_no); // 证件号码
            request.put("elig_content", elig_content); // 客户答题内容
            request.put("invest_risk_tolerance", invest_risk_tolerance);// 投资人风险承受能力
            request.put("paper_client_type", DEF_paper_client_type);// 问卷客户类别

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);

            return appendLog(request, response);

        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

}
