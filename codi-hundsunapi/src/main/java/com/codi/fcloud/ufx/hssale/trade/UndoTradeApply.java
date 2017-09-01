package com.codi.fcloud.ufx.hssale.trade;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codi.base.log.annotation.Loggable;
import com.codi.base.util.ExceptionUtil;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.PrintUtil;
import com.codi.fcloud.ufx.UfxSDKFactory;
import com.codi.fcloud.ufx.constant.HSInputParameterNames;
import com.codi.fcloud.ufx.constant.UrlConstants;
import com.codi.trade.service.UndoTradeApplyService;

@Service("undoTradeApplyService")
public class UndoTradeApply extends UfxSDKFactory implements UndoTradeApplyService {

    /**
     * 撤单 撤单只能对当前工作日撤单 今天的工作日是10号 他的工作日是9号下午三点 到10下午三点 ，10号下午三点以后是11号的工作日，
     * 如果是在下午三点以前发起的有效业务需要撤单，那必须在下午3点之前撤单，下午3点以后不允许撤单了
     * 
     * @author Shangdu Lin
     * @create 20160914
     */
	@Loggable
    @Override
    public Map<String, Object> undo(String originalApplyNo, String tradePassword, String tradeAcco,
            String tradeSource) {
        try {
            String trustWay = apiValueMap.get(HSInputParameterNames.TRUST_WAY);

            Map<String, Object> request = new HashMap<String, Object>();
            // 交易委托方式
            request.put(HSInputParameterNames.TRUST_WAY, trustWay);
            // 交易账号
            request.put(HSInputParameterNames.TRADE_ACCO, tradeAcco);
            // 密码
            request.put(HSInputParameterNames.PASSWORD, tradePassword);
            // 下单日期
            request.put(HSInputParameterNames.ORDER_DATE, "");
            // 申请时间
            request.put(HSInputParameterNames.APPLY_TIME, "");
            // 原申请单编号
            request.put(HSInputParameterNames.ORIGINAL_APPNO, originalApplyNo);
            // 业务大类
            request.put(HSInputParameterNames.BUSIN_BOARD_TYPE, "");
            // 交易来源申请编号
            request.put(HSInputParameterNames.CHANNEL_SERIAL_ID, "");
            // 交易来源
            request.put(HSInputParameterNames.TRADE_SOURCE, tradeSource);

            Map<String, Object> response = getUfxSDK().transact(getTarget(), request);
            PrintUtil.printResponse(response);

            return appendLog(request, response);
        } catch (Exception exception) {
            ExceptionUtil.logError(logger, getTarget(), exception);
            throw new HundsunAPIException(ExceptionUtil.getMessage(exception));
        }
    }

    @Override
    protected String getTarget() {
        return UrlConstants.PREFIX_SALE + UrlConstants.UNDOTRADEAPPLY_TRADE;
    }

}
