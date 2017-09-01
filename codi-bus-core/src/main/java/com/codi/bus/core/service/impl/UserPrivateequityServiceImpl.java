package com.codi.bus.core.service.impl;

import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.UserDao;
import com.codi.bus.core.dao.UserPrivateequityDao;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserPrivateequity;
import com.codi.bus.core.resultModel.PaperInfoTestResult;
import com.codi.bus.core.service.PaperInfoService;
import com.codi.bus.core.service.UserPrivateequityService;
import com.codi.bus.core.service.UserService;
import com.codi.bus.exception.BaseException;
import com.codi.bus.exception.HundsunAPIException;
import com.codi.fcloud.ufx.HsResponseUtil;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.fcloud.ufx.paperinfo.AnswerAdd;
import com.codi.message.constant.ErrorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 私募扩展信息服务实现类
 *
 * @author Shangdu Lin
 * @date 2017年1月9日 下午8:32:42
 */
@Service("userPrivateequityService")
@Transactional
public class UserPrivateequityServiceImpl implements UserPrivateequityService {

    @Autowired
    private UserPrivateequityDao userPrivateequityDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private AnswerAdd addAnswer;

    @Autowired
    private UserService userService;

    @Override
    public UserPrivateequity getByUserId(Long userId) {
        return userPrivateequityDao.getByUserId(userId);
    }

    @Override
    public void updateQualifiedInvester(Long userId, boolean isQualified) {
        userPrivateequityDao.updateQualifiedInvester(userId, isQualified);

    }

    @Override
    public void addOrUpdate(Long userId, boolean isQualified) {

        if (getByUserId(userId) == null) {
            userPrivateequityDao.add(userId, isQualified);
        } else {
            userPrivateequityDao.updateQualifiedInvester(userId, isQualified);
        }
    }

    /**
     * 判断用户是否做过风险测评
     *
     * @param userId
     * @return
     */
    @Override
    public PaperInfoTestResult getTestResult(Long userId) {
        User user = userDao.getEntity(userId);
        if (user == null) {
            throw new BaseException(ErrorConstant.ERROR_NO_USER_FIND);
        }

        //还未开过户
        PaperInfoTestResult result = new PaperInfoTestResult();
        if (!userService.checkAccountOpen(userId)) {
            UserPrivateequity userPrivateequity = userPrivateequityDao.getByUserId(userId);
            if (userPrivateequity == null) {
                result.setHave_tested(false);
                return result;
            }

            // 投资人风险承受能力
            if (StringUtil.isEmpty(userPrivateequity.getRiskTolerance())) {
                result.setHave_tested(false);
                return result;
            } else {
                result.setHave_tested(true);
                result.setPaper_id(userPrivateequity.getPaperId());
                result.setInvest_risk_tolerance(userPrivateequity.getRiskTolerance());
                return result;
            }
        } else {
            result = paperInfoService.getUserPaperInfoTestResult(userId, "");
            return result;
        }
    }

    /**
     * 提交风险测评
     *
     * @param answers
     * @return
     */
    @Override
    public PaperInfoTestResult commitAnswers(Long userId, String answers) {
        User user = userDao.getEntity(userId);
        if (user == null) {
            throw new BaseException(ErrorConstant.ERROR_NO_USER_FIND);
        }

        Map<String, Object> result = addAnswer.addPaperInfoAcct(GlobalConstant.TEST_PROXY_NAME, user.getUserMobile(), answers, "");
        if (HsResponseUtil.isOperationOk(result)) {
            String paperId = result.get(HSOutputParameterNames.PAPER_ID).toString();
            String riskTolerance = result.get(HSOutputParameterNames.INVEST_RISK_TOLERANCE).toString();
            //保存风险测评
            updateRiskTolerance(userId, paperId, riskTolerance);
            PaperInfoTestResult paperInfoTestResult=new PaperInfoTestResult();
            paperInfoTestResult.setPaper_id(paperId);
            paperInfoTestResult.setInvest_risk_tolerance(riskTolerance);
            paperInfoTestResult.setHave_tested(true);

            return paperInfoTestResult;

        } else {
            String errorInfo = result.get(HSOutputParameterNames.ERROR_INFO).toString();
            throw new HundsunAPIException(errorInfo);
        }
    }

    /**
     * 更新风险测评结果
     *
     * @param userId
     * @param paperId
     * @param riskTolerance
     */
    @Override
    public void updateRiskTolerance(Long userId, String paperId, String riskTolerance) {
        UserPrivateequity model = new UserPrivateequity();
        model.setPaperId(paperId);
        model.setRiskTolerance(riskTolerance);
        model.setUserId(userId);
        if (getByUserId(userId) == null) {
            userPrivateequityDao.add(model);
        } else {
            userPrivateequityDao.updateByUserId(model);
        }
    }

}
