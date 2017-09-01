package com.codi.fcloud.ufx.paperinfo;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnswerModify extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/paperinfo_mod_acct";
    }

    @Loggable
    public Map<String, Object> modifyPaperInfoAcct(String paper_id, String elig_content, String invest_risk_tolerance,
            String full_name, String id_no) {
        try {
            Map<String, Object> request = new HashMap<String, Object>();
            request.put("trust_way", DEF_trust_way);
            request.put("paper_id", paper_id);
            request.put("elig_content", elig_content);
            request.put("invest_risk_tolerance", invest_risk_tolerance);
            request.put("cust_type", DEF_cust_type);
            request.put("full_name", "");
            request.put("id_kind_gb", DEF_id_kind_gb);
            request.put("id_no", id_no);
            request.put("paper_client_type", DEF_paper_client_type);

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);

            return appendLog(request, response);

        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

}
