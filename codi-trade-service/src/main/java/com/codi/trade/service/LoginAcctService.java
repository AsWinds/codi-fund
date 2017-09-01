package com.codi.trade.service;

import java.util.Map;

public interface LoginAcctService {
	//登录
	Map<String, Object> login(String password, String userName, String idCard);
}
