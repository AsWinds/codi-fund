package com.codi.bus.core.service;


import com.codi.bus.core.resultModel.BaseResult;
import com.codi.bus.core.service.model.ClientInfoModel;
import com.codi.bus.core.service.model.UserModel;

/**
 * Created by Shangdu Lin on 2017/6/19 11:28.
 */
public interface ClientService {

    /**
     * 获取客户信息
     * @param userId
     * @return
     */
    BaseResult getClientInfo(Long userId);

    /**
     * 修改客户信息
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
    BaseResult modifyClientInfo(Long userId, String address, String addressCode, String occupation, String
        occupationCode, String  beneficiary, String owner, boolean isSelf);

    /**
     * 从恒生获取客户资料信息
     * @param userId
     * @return
     */
    ClientInfoModel getExternalClientInfo(Long userId);

    /**
     * 初始化客户资料
     * @param userId
     * @param model
     */
    void initClientInfo(Long userId, UserModel model);

    /**
     *  查询待办事项
     * @param userId
     * @return
     */
    BaseResult getEventTodos(Long userId);

    /**
     * 获取开户状态值
     * @param userId
     * @return
     */
    Integer getOpenFlag(Long userId);
}
