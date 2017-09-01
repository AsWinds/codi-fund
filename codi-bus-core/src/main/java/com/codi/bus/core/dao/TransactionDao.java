package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.Transaction;

public interface TransactionDao extends BaseDAO<Transaction> {
    void add(Transaction entity);
    void updateTransaction(Transaction entity);
}