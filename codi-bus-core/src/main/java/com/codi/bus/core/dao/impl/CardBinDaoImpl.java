package com.codi.bus.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.dao.CardBinDao;
import com.codi.bus.core.domain.CardBin;

@Repository("cardBinDao")
public class CardBinDaoImpl extends BaseDAOImpl<CardBin> implements CardBinDao {

	@Override
	public CardBin getByBin(String bin) {
		List<CardBin> list= this.findList(CardBin.class.getName()+".selectByBin", bin);
		if(CollectionUtils.isEmpty(list)||list.size()!=1){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	@Override
	public CardBin getByBinLike(String bin) {
		List<CardBin> list= this.findList(CardBin.class.getName()+".selectByBinLike", bin);
		if(CollectionUtils.isEmpty(list)||list.size()!=1){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public CardBin getByCardNo(String cardNo) {
		List<CardBin> list=this.findList(CardBin.class.getName()+".selectByCardNo", cardNo);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		
		return null;
	}

}
