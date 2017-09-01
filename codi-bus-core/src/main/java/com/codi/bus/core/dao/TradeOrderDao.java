package com.codi.bus.core.dao;

import java.util.List;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.TradeOrder;
import com.codi.bus.core.service.model.FixBankModel;

public interface TradeOrderDao extends BaseDAO<TradeOrder> {   
	void add(TradeOrder entity);
	void updateOrder(TradeOrder entity);
	TradeOrder getEntityByOrderId(Long orderId);
	void updateStatus(TradeOrder entity);
	
	/**
	 * 根据定投协议号查询银行信息
	 * @param list 定投协议号列表
	 * @return
	 */
	List<FixBankModel> selectBankInfoByScheduledProtocolId(List<String> list);
}