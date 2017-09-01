package com.codi.bus.core.service.util;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codi.bus.core.resultModel.FundDiscountSetting;
import com.codi.bus.core.resultModel.FundRate;

public class BizUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BizUtils.class);
	public static DateTimeFormatter HS_DATE_FORMAT = DateTimeFormat.forPattern("yyyyMMdd");
	
	public static FundRate getMappingFundRate(List<FundRate> rates, BigDecimal balance){
		for (FundRate fundRate : rates) {
			BigDecimal min_balance = new BigDecimal(fundRate.getMin_balance());
			BigDecimal max_balance = new BigDecimal(fundRate.getMax_balance());
			if (balance.compareTo(min_balance) >= 0 && balance.compareTo(max_balance) <= 0) {
				return fundRate;
			}
		}
		return null;
	}
	
	public static FundDiscountSetting getMappingFundDiscountSetting(List<FundDiscountSetting> settings, BigDecimal banlance){
		BigDecimal no_limit = new BigDecimal(0.00);
		for (FundDiscountSetting fundDiscountSetting : settings) {
			BigDecimal min_bla = new BigDecimal(fundDiscountSetting.getMin_bala());
			BigDecimal max_bla = new BigDecimal(fundDiscountSetting.getMax_bala());
			if (max_bla.compareTo(no_limit) == 0) {
				max_bla = new BigDecimal(Long.MAX_VALUE);
			}
			LocalDate now = new LocalDate();
			if (StringUtils.isNotBlank(fundDiscountSetting.getBelongdate_begin())) {
				LocalDate start_date = LocalDate.parse(fundDiscountSetting.getBelongdate_begin(), HS_DATE_FORMAT);
				if (now.isBefore(start_date)) {
					continue;
				}
			}
			if (StringUtils.isNotBlank(fundDiscountSetting.getBelongdate_end())) {
				LocalDate end_date = LocalDate.parse(fundDiscountSetting.getBelongdate_end(), HS_DATE_FORMAT);
				if (now.isAfter(end_date)) {
					continue;
				}
			}
			if (banlance.compareTo(min_bla) >= 0 && banlance.compareTo(max_bla) <= 0) {
				return fundDiscountSetting;
			}
		}
		return null;
	}
	
	public static BigDecimal getFundLastRatio(FundDiscountSetting setting, BigDecimal ratio){
		if (setting == null) {
			return ratio;
		}
		BigDecimal discount = new BigDecimal(setting.getDiscount());
		BigDecimal last_ratio = ratio.multiply(discount);
		if (StringUtils.isNotBlank(setting.getMin_fare_ratio())) {
			BigDecimal least_ratio = new BigDecimal(setting.getMin_fare_ratio());
			if (least_ratio.compareTo(ratio) == 1) {
				LOGGER.warn("Wrong configuration? discount setting min_fare_ratio:" + least_ratio + " but fund ratio:" + ratio);
				return ratio;
			}
			if (last_ratio.compareTo(least_ratio) == -1) {
				return least_ratio;
			}
		}
		return last_ratio;
	}
	
	private static final int PASSWORD_MINIMUM_LENGTH = 8;
	private static final int PASSWORD_MAXIMUM_LENGTH = 20;
	private static final String PASSWORD_RULE = "^([A-Za-z0-9._!@#$%])*$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_RULE);
	
	public static boolean validatePassword(String password){
		if (password.length() < PASSWORD_MINIMUM_LENGTH || password.length() > PASSWORD_MAXIMUM_LENGTH) {
			return false;
		}
		if (!password.trim().equals(password)) {
			return false;
		}
		HashSet<Character> chars = new HashSet<>();
		char[] char_array = password.toCharArray();
		for (int i = 0; i < char_array.length; i++) {
			chars.add(char_array[i]);
		}
		if (chars.size() == 1) {
			return false;
		}
		return PASSWORD_PATTERN.matcher(password).matches();
	}
	
	public static final int TRADE_PASSWORD_LENGTH = 6;
	private static final String TRADE_PASSWORD_RULE = "^([0-9])*$";
	private static final Pattern TRADE_PASSWORD_PATTERN = Pattern.compile(TRADE_PASSWORD_RULE);
	public static boolean validateTradePasswd(String tradePasswd){
		if (tradePasswd.length() != TRADE_PASSWORD_LENGTH) {
			return false;
		}
		HashSet<Character> chars = new HashSet<>();
		char[] char_array = tradePasswd.toCharArray();
		for (int i = 0; i < char_array.length; i++) {
			chars.add(char_array[i]);
		}
		if (chars.size() == 1) {
			return false;
		}
		return TRADE_PASSWORD_PATTERN.matcher(tradePasswd).matches();
	}
	
	public static void main(String[] args) {
		System.out.println(validatePassword("aaaaaaaa"));
		System.out.println(validatePassword("abc12xxxx3$"));
		System.out.println(validateTradePasswd("aaaaaa"));
		System.out.println(validateTradePasswd("123456"));
		System.out.println(validateTradePasswd("111111"));
		System.out.println(validateTradePasswd("12345a"));
		System.out.println(validateTradePasswd("12345 "));
	}
}
