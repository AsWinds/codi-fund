package com.codi.fcloud.ufx.paperinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.UfxSDKFactory;

@Service
public class QuestionSectionQuery extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/paperinfo_question_section_qry";
    }

    @Loggable
    public List<Map<String, Object>> getAllQuestionSections() {
        try {
            int page_size = 50;
            List<Map<String, Object>> firstPage = getUfxSDK().query(getTarget(), getPageRequest("1", "1"));
            if (firstPage.size() == 0) {
                // TODO
                throw new RuntimeException("Unexpected query result from ufx");
            }
            if (firstPage.size() < page_size) {
                return firstPage;
            }
            List<Map<String, Object>> res = new ArrayList<>(firstPage);
            for (;;) {
                List<Map<String, Object>> current = getUfxSDK().query(getTarget(),
                        getPageRequest("0", Integer.toString(res.size() + 1)));
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

    public Map<String, Object> getPageRequest(String reqry_recordsum_flag, String qry_beginrownum) {
        String trust_way = DEF_trust_way;
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trust_way); // 交易委托方式
        request.put("request_num", "50"); // 请求行数
        request.put("reqry_recordsum_flag", reqry_recordsum_flag); // 重新统计总记录数标志
        request.put("qry_beginrownum", qry_beginrownum); // 查询起始行号
        request.put("sort_direction", ""); // 返回排序方式
        request.put("option_no", "");// 选项编号
        return request;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> response = new QuestionSectionQuery().getAllQuestionSections();

        System.out.println(response);
        System.out.println("--------");
        System.out.println(response.size());
        System.out.println(JSON.toJSONString(response));
    }

}
