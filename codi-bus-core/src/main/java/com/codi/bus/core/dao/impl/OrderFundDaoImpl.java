package com.codi.bus.core.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.OrderFundDao;
import com.codi.bus.core.domain.OrderFund;

@Repository("orderFundDao")
public class OrderFundDaoImpl extends BaseDAOImpl<OrderFund> implements OrderFundDao {

	@Override
	public void add(OrderFund entity) {
		entity.setCreateDate(new Date());
		entity.setIsValid(true);
		this.insert(entity);		
	}

	@Override
	public void updateFund(OrderFund entity) {
		entity.setLastUpdatedDate(new Date());
		this.update(entity);
	}

	@Override
	public OrderFund getEntityByExtApplyNo(String externalApplyNo) {
		return this.getObject(OrderFund.class.getName()+".selectByExternalApplyNo", externalApplyNo);
	}

	@Override
	public void updateStatus(OrderFund entity) {
		entity.setLastUpdatedDate(new Date());
		this.update(OrderFund.class.getName()+".updateStatus", entity);
	}

}
