package com.codi.bus.core.service;

import com.codi.base.dao.plugin.page.PageView;
import com.codi.bus.core.domain.PEAppointment;

import java.util.List;

/**
 * @author Shangdu Lin
 * @date 2017年1月9日 下午10:54:50
 */
public interface PEAppointmentService {

    /**
     * 添加预约
     *
     * @param userId
     * @param clientName
     * @param clientMobile
     * @param productId
     * @param productName
     */
    void addAppointment(Long userId, String clientName, String clientMobile, Long productId, String productName);

    /**
     * 查询用户的预约
     * @param clientMobile
     * @param productId
     * @return
     */
    List<PEAppointment> queryListForAppoint(String clientMobile, Long productId);

    /**
     * 分页查询用户预约列表
     *
     * @param pageIndex
     * @param pageSize
     * @param isActive
     * @param productName
     * @param clientName
     * @param mobile
     * @return
     */
    PageView queryListByPage(Integer pageIndex, Integer pageSize, boolean isActive,
                             String productName, String clientName,
                             String mobile);

    /**
     * 查询是否24小时内已注册
     * @param clientMobile
     * @param productId
     * @return
     */
    boolean hasAppointed(String clientMobile, Long productId);
}
