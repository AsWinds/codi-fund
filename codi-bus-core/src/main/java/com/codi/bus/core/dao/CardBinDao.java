package com.codi.bus.core.dao;

import com.codi.base.dao.BaseDAO;
import com.codi.bus.core.domain.CardBin;

public interface CardBinDao extends BaseDAO<CardBin> {
    CardBin getByBin(String bin);    
    CardBin getByBinLike(String bin);    
    CardBin getByCardNo(String cardNo);
}