package com.codi.bus.core.service.impl;

import com.codi.base.util.DateUtils;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.TransactionDao;
import com.codi.bus.core.dao.UserProfileDao;
import com.codi.bus.core.domain.Transaction;
import com.codi.bus.core.domain.User;
import com.codi.bus.core.domain.UserBank;
import com.codi.bus.core.domain.UserProfile;
import com.codi.bus.core.resultModel.*;
import com.codi.bus.core.service.*;
import com.codi.bus.core.service.model.*;
import com.codi.bus.core.service.util.HundsunUtils;
import com.codi.bus.core.service.util.ModelPopulateUtils;
import com.codi.bus.core.service.util.ObjectCreator;
import com.codi.bus.exception.BaseException;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.message.constant.ErrorConstant;
import com.codi.trade.dto.EventTodoQueryDto;
import com.codi.trade.service.ClientInfoModService;
import com.codi.trade.service.ClientInfoQueryService;
import com.codi.trade.service.EventTodoQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Shangdu Lin on 2017/6/19 13:23.
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Resource(name = "clientInfoQueryService")
    private ClientInfoQueryService clientInfoQueryService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "bankService")
    private BankService bankService;

    @Resource(name = "clientInfoModAcctService")
    private ClientInfoModService clientInfoModService;

    @Resource(name = "transactionDao")
    private TransactionDao transactionDao;

    @Resource(name = "userProfileService")
    private UserProfileService userProfileService;

    @Resource(name = "userProfileDao")
    private UserProfileDao userProfileDao;

    @Autowired
    private QueryService queryService;

    @Autowired
    private EventTodoQueryService eventTodoQueryService;

    @Autowired
    private PaperInfoService paperInfoService;

    /**
     * 查询客户资料
     *
     * @param userId
     * @return
     */
    @Override
    public BaseResult getClientInfo(Long userId) {
        UserProfile profile = userProfileDao.selectByUserId(userId);

        ClientInfoResult result = new ClientInfoResult();
        if (profile != null) {
            BeanUtils.copyProperties(profile, result);
        }

        return result;
    }

    /**
     * 修改客户资料
     *
     * @param userId
     * @param address
     * @param addressCode
     * @param occupation
     * @param occupationCode
     * @param beneficiary
     * @param owner
     * @param isSelf
     * @return
     */
    @Override
    @Transactional
    public BaseResult modifyClientInfo(Long userId, String address, String addressCode, String occupation, String
        occupationCode, String beneficiary, String owner, boolean isSelf) {

        BaseResult result = new BaseResult();

        // Step 1: 获取客户资料
        ClientInfoModel model = getExternalClientInfo(userId);
        if (model == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_NO_BANK_CARD_FIND);
            return result;
        }
        if (isSelf) {
            //hundsun查询用户接口，老版本中老用户没传client_name //shi.pengyan 2017-7-10 16:41:42
            String name = model.getClientFullName();
            if (StringUtil.isEmpty(name)) {
                name = model.getClientName();
            }

            beneficiary = name;
            owner = name;
        }

        // Step 2: 修改恒生客户资料
        Map<String, Object> map = clientInfoModService.modAcct(model.getTradeAccount(), model.getClientFullName(), model
            .getClientName(), model.getIdKind(), model.getIdNo(), address, occupationCode, model.getBirthday(), model
            .getMobile(), beneficiary, owner, model.getTradeAccountName(), "1", model.getMap());

        if (!ModelPopulateUtils.checkSuccess(map)) {
            String errorInfo = map.get(HSOutputParameterNames.ERROR_INFO).toString();
            result.setSuccess(false);
            result.setErrorType(GlobalConstant.ERROR_TYPE_APPLICATION);
            result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
            result.setErrorMessage(errorInfo);
        } else {
            result.setSuccess(true);

            // Step 4: 修改本地客户资料
            // 必须是恒生修改成功后才更新用户资料，否则会造成用户信息已修改的假象 //shi.pengyan 2017-7-10 13:30:01
            UserProfile userProfile = new UserProfile();
            userProfile.setUserId(userId);
            userProfile.setUserAddress(address);
            userProfile.setAddressCode(addressCode);
            userProfile.setUserOccupation(occupation);
            userProfile.setOccupationCode(occupationCode);
            userProfile.setSelfSustain(isSelf);
            userProfile.setBeneficiary(beneficiary);
            userProfile.setOwner(owner);
            userProfileService.addOrUpdate(userProfile);
        }


        // Step 5: 记录操作日志
        // 插入交易记录流水
        Transaction transaction = ObjectCreator.createTransaction(map);
        // 不管成功或失败，都插入交易流水
        transactionDao.add(transaction);

        return result;
    }

    /**
     * 从恒生获取客户信息
     *
     * @param userId
     * @return
     */
    @Override
    public ClientInfoModel getExternalClientInfo(Long userId) {

        BaseResult result = new BaseResult();
        // Step 1: 获取交易账号
        List<UserBank> userBanks = bankService.getListByUserId(userId);
        if (CollectionUtils.isEmpty(userBanks)) {
            return null;
        }

        String tradeAccount = null;
        for (UserBank userBank :
            userBanks) {
            tradeAccount = userBank.getExternalTradeAccount();
            if (StringUtil.isNotEmpty(tradeAccount)) {
                break;
            }
        }

        if (StringUtil.isEmpty(tradeAccount)) {
            return null;
        }

        // Step 2: 查询客户资料
        Map<String, Object> map = clientInfoQueryService.queryByTradeAcco(tradeAccount);
        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            throw new BaseException(result.getErrorCode(), result.getErrorMessage());
        }

        if (CollectionUtils.isEmpty(list)) {
            throw new BaseException(ErrorConstant.ERROR_CLIENT_NO_FIND);
        }

        Map<String, Object> clientInfoMap = list.get(0);

        ClientInfoModel model = ModelPopulateUtils.populateClientInfo(clientInfoMap);
        model.setTradeAccount(tradeAccount);
        model.setMap(clientInfoMap);

        return model;
    }

    /**
     * 初始化客户资料信息
     *
     * @param userId
     * @param model
     */
    @Override
    public void initClientInfo(Long userId, UserModel model) {
        //设置客户资料
        String          expiredDate     = null;
        ClientInfoModel clientInfoModel = getExternalClientInfo(userId);
        if (clientInfoModel != null) {
            //是否专业投资者
            if (StringUtil.isNotEmpty(clientInfoModel.getProfessionalFlag()) && clientInfoModel.getProfessionalFlag().equals
                ("1")) {
                model.setProfessionalFlag(true);
            } else {
                model.setProfessionalFlag(false);
            }

            //是否资料已完善
            if (StringUtil.isNotEmpty(clientInfoModel.getQualifiedFlag()) && clientInfoModel.getQualifiedFlag().equals("1")) {
                model.setCompletedFlag(true);
            } else {
                model.setCompletedFlag(false);
            }

            //风险等级
            PaperInfoTestResult testResult = paperInfoService.getUserPaperInfoTestResult(userId, "");
            if (!testResult.getSuccess()) {
                throw new BaseException(testResult.getErrorCode(), testResult.getErrorMessage());
            }
            if (StringUtil.isNotEmpty(testResult.getInvest_risk_tolerance())) {
                model.setInvestRiskTolerance(Integer.parseInt(testResult.getInvest_risk_tolerance()));
            } else {
                logger.warn("userId;{},mobile:{} 已开户，但未找到风险测评", userId, model.getMobile());
            }

            //获取风险等级过期时间
            expiredDate = testResult.getExpire_date();

        } else {
            //已注册，但未开户
            model.setProfessionalFlag(false);
            model.setCompletedFlag(false);
            model.setInvestRiskTolerance(GlobalConstant.INVEST_RISK_TOLERANCE_SAFE);
        }

        // 设置开户状态
        model.setOpenFlag(getOpenFlag(userId));

        // 默认风险测评为过期
        model.setTestExpired(true);
        // 设置风险测评过期时间
        if (StringUtil.isNotEmpty(expiredDate)) {
            try {
                model.setTestExpiredDate(DateUtils.stringToDate(expiredDate, "yyyy-MM-dd"));
            } catch (Exception ex) {
                throw new BaseException(ErrorConstant.ERROR_TEST_EXPIRED_DATE_INVALID);
            }
            // 判断风险测评是否过期
            if (model.getTestExpiredDate() != null && DateUtils.addDay(model.getTestExpiredDate(), 1).after(new Date())) {
                model.setTestExpired(false);
            }
        }

    }

    /**
     * 查询待办事项
     *
     * @param userId
     * @return
     */
    @Override
    public BaseResult getEventTodos(Long userId) {

        BaseResult result = new BaseResult();
        // Step 1: 查询用户
        User userEntity = userService.getUser(userId);
        if (userEntity == null) {
            result.setSuccess(false);
            result.setErrorCode(ErrorConstant.ERROR_NO_USER_FIND);
            return result;
        }
        if (StringUtil.isEmpty(userEntity.getExternalClientId())) {
            return result;
        }

        // Step 2: 查询代办事项
        EventTodoQueryDto dto = new EventTodoQueryDto();
        dto.setRequest_num(GlobalConstant.MAX_REQUEST_NUM);
        dto.setClient_id(userEntity.getExternalClientId());
        Map<String, Object> map = eventTodoQueryService.query(dto);
        // 查询结果
        List<Map<String, Object>> list = new ArrayList<>();
        HundsunUtils.ConvertToList(map, list, result);
        if (!result.getSuccess()) {
            return result;
        }
        List<ToDoModel> todos = ModelPopulateUtils.populateTodos(list, new BaseListResult());

        if (CollectionUtils.isEmpty(todos)) {
            return result;
        }
        // Step 3: 查询警示内容
        List<WarningModel> warnings = queryService.queryWarnings();

        // Step 4: 组装警示内容，设置风险等级
        for (ToDoModel model :
            todos) {
            // 警示内容
            WarningModel warning = ModelPopulateUtils.getWarning(warnings, model.getWarningType());
            if (warning != null) {
                model.setWarningContent(ModelPopulateUtils.buildTodoConent(warning.getWarningContent(), model.getPlaceHolder()));
            }

            //风险等级
            NewsModel news = queryService.getRiskLevel(model.getFundCode());
            if (news != null) {
                model.setRiskLevel(news.getRiskLevel());
            }
        }

        result.setResult(todos);

        return result;
    }

    /**
     * 获取开户状态
     *
     * @param userId
     * @return
     */
    @Override
    public Integer getOpenFlag(Long userId) {

        User userEntity = userService.getUser(userId);
        if (userEntity == null) {
            throw new BaseException(ErrorConstant.ERROR_NO_USER_FIND);
        }
        String externalClientId = userEntity.getExternalClientId();
        if (StringUtil.isEmpty(externalClientId)) {
            // 未开户
            return GlobalConstant.ACCOUNT_STATUS_NO_OPEN;
        } else {
            // 获取用户银行卡
            BaseListResult listResult = queryService.queryAccountBanks("", userEntity.getExternalClientId(), "",
                GlobalConstant.MAX_REQUEST_NUM, 1, 1, "1");
            if (!listResult.getSuccess()) {
                throw new BaseException(listResult.getErrorCode(), listResult.getErrorMessage());
            }

            List<BankModel> banks = ((BankListResult) listResult).getBanks();
            if (banks == null || banks.size() == 0) {
                // 未开户
                return GlobalConstant.ACCOUNT_STATUS_NO_OPEN;
            } else {
                // 判断是否开户
                int counter = 0;
                int app     = 0;
                for (BankModel bankModel : banks) {
                    if (bankModel.getCapitalMode().equals(GlobalConstant.CAPITAL_MODE_COUNTER)) {
                        counter = counter + 1;
                    } else if (!StringUtil.isEmpty(bankModel.getCapitalMode())) {
                        app = app + 1;
                    }
                }

                if (app > 0) {
                    // APP已开户
                    return GlobalConstant.ACCOUNT_STATUS_APP_OPEN;
                } else if (counter > 0) {
                    // 柜台已开户
                    return GlobalConstant.ACCOUNT_STATUS_COUNTER_OPEN;
                } else {
                    // 未开户
                    return GlobalConstant.ACCOUNT_STATUS_NO_OPEN;
                }
            }
        }
    }

}
