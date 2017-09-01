package com.codi.fcloud.ufx.paperinfo.v2;

import com.codi.base.log.annotation.Loggable;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.dto.QuestionQueryDto;
import com.codi.trade.service.paperinfo.QuestionQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 风险试题查询
 *
 * @author shi.pengyan
 * @date 2017-06-21 13:38
 */
@Slf4j
@Service
public class QuestionQueryServiceImpl extends UfxSDKFactory implements QuestionQueryService {

    private static final Integer DEFAULT_PAGE_SIZE = 5;//TODO 恒生调查问卷只返回9条

    @Override
    @Loggable
    public List<Map<String, Object>> query(QuestionQueryDto dto) {

        String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

        dto.setTrust_way(trustWay);
        dto.setReqry_recordsum_flag("1");
        dto.setQry_beginrownum("1");// 第一行


        List<Map<String, Object>> firstPage = getUfxSDK().query(getTarget(), getPageRequest(dto));
        if (firstPage.size() == 0) {
            // TODO
            throw new RuntimeException("Unexpected return result. the lenght should > 0");
        }
        if (firstPage.size() < DEFAULT_PAGE_SIZE) {
            return firstPage;
        }
        List<Map<String, Object>> res = new ArrayList<>(firstPage);
        for (; ; ) {

            dto.setReqry_recordsum_flag("0");
            dto.setQry_beginrownum("" + (res.size() + 1));
            List<Map<String, Object>> current = getUfxSDK().query(getTarget(), getPageRequest(dto));

            res.addAll(current);
            if (current.size() < DEFAULT_PAGE_SIZE) {
                break;
            }
            continue;
        }
        return res;
    }

    private Map<String, Object> getPageRequest(QuestionQueryDto dto) {
        Map<String, Object> request = new HashMap<>();

        request.put("trust_way", getString(dto.getTrust_way())); // 交易委托方式
        request.put("net_no", getString(dto.getNet_no(), "0001"));//网点代码
        request.put("request_num", getString(dto.getRequest_num(), "" + DEFAULT_PAGE_SIZE)); // 请求行数
        request.put("reqry_recordsum_flag", getString(dto.getReqry_recordsum_flag())); // 重新统计总记录数标志
        request.put("qry_beginrownum", getString(dto.getQry_beginrownum())); // 查询起始行号
        request.put("sort_direction", getString(dto.getSort_direction())); // 返回排序方式
        request.put("question_no", getString(dto.getQuestion_no())); // 问题编号
        request.put("answer_object", getString(dto.getAnswer_object(), HsConst.ANSWER_TYPE_PERSON)); // 回答对象,
        request.put("paper_client_type", getString(dto.getPaper_client_type(), DEF_paper_client_type)); // 问卷客户类别
        request.put("integrity_flag", getString(dto.getIntegrity_flag()));//诚信标志

        return request;
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.PAPERINFO_QUESTION_QRY;
    }
}
