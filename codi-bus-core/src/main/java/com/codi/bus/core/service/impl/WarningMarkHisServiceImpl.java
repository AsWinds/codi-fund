package com.codi.bus.core.service.impl;

import com.codi.base.util.Assert;
import com.codi.base.util.DateUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.WarningMarkHisDao;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.WarningMarkHis;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.service.UserService;
import com.codi.bus.core.service.WarningMarkHisService;
import com.codi.bus.core.service.util.ModelPopulateUtils;
import com.codi.bus.core.vo.WarningMarkHisSearchModel;
import com.codi.bus.core.vo.WarningMarkHisSearchVo;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.fcloud.ufx.constant.HsConst;
import com.codi.message.constant.ErrorConstant;
import com.codi.trade.dto.WarningMarkDto;
import com.codi.trade.service.WarningMarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 警示内容
 *
 * @author shi.pengyan
 * @date 2017-06-23 15:58
 */
@Slf4j
@Service
@Transactional
public class WarningMarkHisServiceImpl implements WarningMarkHisService {

    @Resource
    private WarningMarkHisDao warningMarkHisDao;

    @Autowired
    private UserService userService;

    @Autowired
    private WarningMarkService warningMarkService;


    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addLocal(WarningMarkHis record) {
        Assert.notNull(record, "留痕不能为null");
        Assert.notNull(record.getWarningNo());

        record.setCreateDate(new Date());

        if (record.getUserId() != null) {

            User user = userService.getUser(record.getUserId());
            record.setClientName(user.getUserName());
            record.setClientId(user.getExternalClientId());

            if (user.getUserCard() != null) {
                record.setIdKindGb(HsConst.ID_KIND_GB_ID_CARD);
                record.setIdNo(user.getUserCard());
            }


        }

        return warningMarkHisDao.insertSelective(record);
    }

    @Override
    public BaseResult addLocalAndSync(WarningMarkHis record) {
        BaseResult result = new BaseResult();

        addLocal(record);

        // 直销还未完全实现客户编号非必填 2017-7-6 09:57
        if (StringUtil.isEmpty(record.getClientId())) {
            result.setSuccess(true);
            return result;
        }

        WarningMarkDto dto = new WarningMarkDto();

        dto.setWarning_no(record.getWarningNo());
        dto.setClient_id(record.getClientId());
        dto.setClient_name(record.getClientName());
        dto.setId_kind_gb(record.getIdKindGb());
        dto.setId_no(record.getIdNo());
        dto.setIp(record.getIp());
        dto.setBrower_type(record.getBrowerType());
        dto.setMac(record.getMac());
        dto.setOpen_id(record.getOpenId());
        dto.setDevice_id(record.getDeviceId());
        dto.setInvest_risk_tolerance(record.getInvestRiskTolerance());
        dto.setOfund_risklevel(record.getOfundRisklevel());
        dto.setFund_code(record.getFundCode());
        dto.setFund_busin_code(record.getFundBusinCode());
        dto.setMark_content(record.getMarkContent());
        dto.setOrder_date(DateUtil.format(record.getCreateDate(), "yyyyMMdd"));

        Map<String, Object> map = warningMarkService.save(dto);

        if (!ModelPopulateUtils.checkSuccess(map)) {
            String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
            result.setErrorMessage(errorInfo);
        } else {
            result.setSuccess(true);
        }
        return result;
    }

    @Override
    public Page<WarningMarkHisSearchModel> search(WarningMarkHisSearchVo record, Pageable pageable) {
        //return warningMarkHisDao.search(record, pageable);
        Page<WarningMarkHisSearchModel> page = warningMarkHisDao.search(record, pageable);
        return page;
    }
}
