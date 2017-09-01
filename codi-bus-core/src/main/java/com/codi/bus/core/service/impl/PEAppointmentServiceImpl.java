package com.codi.bus.core.service.impl;

import com.codi.base.dao.plugin.page.PageView;
import com.codi.base.util.DateUtils;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.PEAppointmentDao;
import com.codi.bus.core.domain.PEAppointment;
import com.codi.bus.core.service.PEAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Shangdu Lin
 * @date 2017年1月9日 下午10:56:35
 */
@Service("peappointmentService")
@Transactional
public class PEAppointmentServiceImpl implements PEAppointmentService {

    @Autowired
    private PEAppointmentDao peappointmentDao;

    @Override
    public void addAppointment(Long userId, String clientName, String clientMobile, Long productId,
                               String productName) {
        if (!hasAppointed(clientMobile,productId)) {
            peappointmentDao.addAppointment(userId, clientName, clientMobile, productId, productName);
        }
    }

    @Override
    public List<PEAppointment> queryListForAppoint(String clientMobile, Long productId) {
        return peappointmentDao.queryListForAppoint(clientMobile, productId);
    }

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
    @Override
    public PageView queryListByPage(Integer pageIndex, Integer pageSize, boolean isActive,
                                    String productName, String clientName,
                                    String mobile) {
        return peappointmentDao.queryListByPage(pageIndex, pageSize, isActive, productName, clientName, mobile);
    }

    /**
     * 查询是否24小时内已注册
     * @param clientMobile
     * @param productId
     * @return
     */
    @Override
    public boolean hasAppointed(String clientMobile, Long productId) {
        List<PEAppointment> appointments = queryListForAppoint(clientMobile,productId);
        // 获取最新的一条预约
        if (!CollectionUtils.isEmpty(appointments) && appointments.size() > 0) {
            PEAppointment appointment = appointments.get(0);
            // 24小时内不能重复预约
            Date expiredTime = DateUtils.addDay(appointment.getAppointmentTime(), GlobalConstant.PE_APPOINTMENT_DAYS);
            if (expiredTime.after(new Date())) {
                return true;
            }
        }

        return false;
    }

}
