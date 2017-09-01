package com.codi.bus.core.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.PEAppointmentDao;
import com.codi.bus.core.domain.PEAppointment;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shangdu Lin
 *
 * @date 2017年1月9日 下午10:30:04
 */
@Repository("peappointmentDao")
public class PEAppointmentDaoImpl extends BaseDAOImpl<PEAppointment> implements PEAppointmentDao {

	/**
	 * 添加预约
	 */
	@Override
	public void addAppointment(Long userId, String clientName, String clientMobile, Long productId, String productName) {
		PEAppointment model=new PEAppointment();
		model.setAppointmentTime(new Date());
		model.setClientMobile(clientMobile);
		model.setClientName(clientName);
		model.setProductId(productId);
		model.setProductName(productName);
		model.setIsValid(true);
		model.setCreateDate(new Date());
		model.setCreateUserId(userId.toString());
		this.insert(model);
	}

	/**
	 * 查询用户的预约
	 */
	@Override
	public List<PEAppointment> queryListForAppoint(String clientMobile, Long productId) {
        PEAppointment appointment=new PEAppointment();
        appointment.setClientMobile(clientMobile);
        appointment.setProductId(productId);
		return this.findList(this.generateStatement("selectForAppoint"), appointment);
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
    public PageView queryListByPage(Integer pageIndex, Integer pageSize, boolean isActive, String productName, String clientName, String mobile) {
        PageView pageView=getPageView(pageIndex, pageSize);
        PEAppointment model=new PEAppointment();
        model.setProductName(productName);
        model.setClientName(clientName);
        model.setClientMobile(mobile);
        if(isActive){
            model.setProductStatus(GlobalConstant.PE_PRODUCT_STUTAS_ONSALE);
        }else {
            model.setProductStatus(GlobalConstant.PE_PRODUCT_STUTAS_NOT_ONSALE);
        }

        Map<String, Object> map=new HashedMap();
        map.put("pageView", pageView);
        map.put("model", model);

        List<PEAppointment> list= this.findList(generateStatement("queryList"), map);

        pageView.setRecords(list);

        return pageView;
    }

}
