package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.OrderFund;

public interface OrderFundDao extends BaseDAO<OrderFund> {
    void add(OrderFund entity);
    void updateFund(OrderFund entity);
    void updateStatus(OrderFund entity);
    OrderFund getEntityByExtApplyNo(String externalApplyNo);
}