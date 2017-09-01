package com.codi.bus.core.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.TradeOrderDao;
import com.codi.bus.core.domain.TradeOrder;
import com.codi.bus.core.service.model.FixBankModel;

@Repository("tradeOrderDao")
public class TradeOrderDaoImpl extends BaseDAOImpl<TradeOrder> implements TradeOrderDao {

	@Override
	public void add(TradeOrder entity) {
		entity.setCreateDate(new Date());
		entity.setIsValid(true);
		this.insert(entity);		
	}

	@Override
	public void updateOrder(TradeOrder entity) {
		entity.setLastUpdatedDate(new Date());
		this.update(entity);		
	}

	@Override
	public TradeOrder getEntityByOrderId(Long orderId) {
		return this.getObject(TradeOrder.class.getName()+".selectByPrimaryKey", orderId);
	}

	@Override
	public void updateStatus(TradeOrder entity) {
		entity.setLastUpdatedDate(new Date());
		this.update(TradeOrder.class.getName()+".updateStatus", entity);			
	}

    @Override
    public List<FixBankModel> selectBankInfoByScheduledProtocolId(List<String> list) {
        Map<String, Object> param = new HashMap<>();
        param.put("list", list);
        return getSqlSession().selectList(generateStatement("selectBankInfoByScheduledProtocolId"), list);
    }

}
