package com.codi.bus.core.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.TransactionDao;
import com.codi.bus.core.domain.Transaction;

@Repository("transactionDao")
public class TransactionDaoImpl extends BaseDAOImpl<Transaction> implements TransactionDao {

	@Override
	public void add(Transaction entity) {
		entity.setCreateDate(new Date());	
		entity.setIsValid(true);
		this.insert(entity);		
	}

	@Override
	public void updateTransaction(Transaction entity) {
		entity.setLastUpdatedDate(new Date());			
		this.update(entity);
	}
	
}
