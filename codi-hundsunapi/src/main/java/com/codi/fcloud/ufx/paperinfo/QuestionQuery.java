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
public class QuestionQuery extends UfxSDKFactory {

    @Override
    protected String getTarget() {
        return "/cwsale/v1/paperinfo_question_qry";
    }

    @Loggable
    public List<Map<String, Object>> getAllQuestions() {
        try {
            String trust_way = DEF_trust_way;
            String answer_object = DEF_answer_object;
            String paper_client_type = DEF_paper_client_type;
            int page_size = 5;
            List<Map<String, Object>> firstPage = getUfxSDK().query(getTarget(),
                    getPageRequest(trust_way, "1", "1", answer_object, paper_client_type));
            if (firstPage.size() == 0) {
                // TODO
                throw new RuntimeException("Unexpected return result. the lenght should > 0");
            }
            if (firstPage.size() < page_size) {
                return firstPage;
            }
            List<Map<String, Object>> res = new ArrayList<>(firstPage);
            for (;;) {
                List<Map<String, Object>> current = getUfxSDK().query(getTarget(), getPageRequest(trust_way, "0",
                        Integer.toString(res.size() + 1), answer_object, paper_client_type));
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

    private Map<String, Object> getPageRequest(String trust_way, String reqry_recordsum_flag, String qry_beginrownum,
            String answer_object, String paper_client_type) {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("trust_way", trust_way); // 交易委托方式
        request.put("request_num", "5"); // 请求行数
        request.put("reqry_recordsum_flag", reqry_recordsum_flag); // 重新统计总记录数标志
        request.put("qry_beginrownum", qry_beginrownum); // 查询起始行号
        request.put("sort_direction", ""); // 返回排序方式
        request.put("question_no", ""); // 问题编号
        request.put("answer_object", answer_object); // 回答对象
        request.put("paper_client_type", paper_client_type); // 问卷客户类别
        return request;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> response = new QuestionQuery().getAllQuestions();

        System.out.println(response);
        System.out.println("--------");
        System.out.println(JSON.toJSONString(response));
    }
}
