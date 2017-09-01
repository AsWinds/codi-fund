package com.codi.message.constant;

public class ErrorConstant {

	// 一般错误消息FIELD占位符
	public static final String PLACEHOLDER_FIELD = "FIELD";

	// 泛型错误
	public static final Integer ERROR_GENERAL = -1;

	// Error Code
	// 手机号未注册
	public static final Integer ERROR_MOBILE_NOT_REG = 1000;
	// 用户密码错误
	public static final Integer ERROR_PASSWORD_WRONG = 1001;
	// 恒生API接口调用出错
	public static final Integer ERROR_HUNDSUNAPI_WRONG = 1002;
	// 手机号已注册
	public static final Integer ERROR_MOBILE_REGED = 1003;
	// 身份证已注册
	public static final Integer ERROR_IDCARD_REGED = 1004;
	// 银行卡号已注册
	public static final Integer ERROR_BANKNO_REGED = 1005;
	// {FIELD}不能为空
	public static final Integer ERROR_FIELD_NO_FIND = 1006;
	// 错误消息FIELD占位符
	public static final String PLACEHOLDER_FIELD_NO_FIND_FIELD = "FIELD";
	// 用户未登陆
	public static final Integer ERROR_NOT_LOGIN = 1007;
	// 用户登陆已过期
	public static final Integer ERROR_LOGIN_EXPIRED = 1008;
	// 注册手机验证码不正确
	public static final Integer ERROR_REGVCODE_INCORRECT = 1009;
	// 手机号不合法
	public static final Integer ERROR_MOBILE_INVALID = 1010;
	// 短信模板未找到
	public static final Integer ERROR_TEMPLATE_NO_FIND = 1011;
	// 数据库错误
	public static final Integer ERROR_SYSTEM_DB = 1012;
	// XML处理错误
	public static final Integer ERROR_XML = 1013;
	// 易宝签名错误
	public static final Integer ERROR_EPAY_SIGN_INCORRECT = 1014;
	// 科地自身的签名错误
	public static final Integer ERROR_CODI_SIGN_INCORRECT = 1015;
	// 支付异常
	public static final Integer ERROR_PAY_EXCEPTION = 1016;
	// 获取流水号出错
	public static final Integer ERROR_SERIAL_NO_GEN = 1017;
	// 必须是数字字段
	public static final Integer ERROR_NUMERIC_FIELD = 1018;
	// 无相应的卡bin信息
	public static final Integer ERROR_NO_CARD_BIN = 1019;
	// 无相应的订单信息
	public static final Integer ERROR_NO_ORDER_FIND = 1020;
	// 无相应的银行卡信息
	public static final Integer ERROR_NO_BANK_CARD_FIND = 1021;
	// 系统异常错误
	public static final Integer ERROR_SYS_EXCEPTION = 1022;
	// 非法请求
	public static final Integer ERROR_INVALID_REQUEST = 1023;
	/** 基金编码不存在 */
	public static final Integer ERROR_FUND_NOT_EXIST = 1024;
	// 基金的风险等级大于用户的投资风险等级
	public static final Integer ERROR_RISK_LEVEL = 1025;
	// 短信发送太频繁
	public static final Integer ERROR_SEND_TOO_FREQUENT = 1026;
	// 用户已在其他地方登录
	public static final Integer ERROR_LOGIN_IN_OTHER_PLACE = 1027;
	// 申购的金额小于最低起购金额
	public static final Integer ERROR_BUY_LESS_THAN_MIN_VALUE = 1028;
	// 申购的金额大于最高可购金额
	public static final Integer ERROR_BUY_MORE_THAN_MAX_VALUE = 1029;
	// 赎回的份额小于最低可赎份额
	public static final Integer ERROR_SELL_LESS_THAN_MIN_VALUE = 1030;
	// 赎回的份额大于最高可赎份额
	public static final Integer ERROR_SELL_MORE_THAN_MAX_VALUE = 1031;

	/** 基金经理不存在 **/
	public static final Integer ERROR_FUND_MANAGER_NOT_EXIST = 1032;
	// 用户还未开户
	public static final Integer ERROR_NO_ACCOUNT = 1033;
	/** 基金详情不存在 */
	public static final Integer ERROR_FUND_DETAIL_NOT_EXIST = 1034;

	/** 货基没有申购赎回费率 */
	public static final Integer ERROR_FUND_CURRENCY_NO_RATE = 1035;
	/** 货基没有红利和拆分 */
	public static final Integer ERROR_FUND_CURRENCY_NO_SHARE = 1036;

	// 不能撤单
	public static final Integer ERROR_UNDO_DISABLE = 1037;
	// 未找到银行编号 - {FIELD}
	public static final Integer ERROR_NO_BANK_CODE_FIND = 1038;
	// 未找到主交易账号
	public static final Integer ERROR_NO_MAIN_ACCOUNT_FIND = 1039;
	// 未找到份额类别
	public static final Integer ERROR_NO_SHARE_TYPE_FIND = 1040;
	// 聚源API接口调用出错
	public static final Integer ERROR_GILDATA_WRONG = 1041;
	// 重复提交交易
	public static final Integer ERROR_DUPLICATE_APPLY = 1042;
	// 重复提交验证吗申请
	public static final Integer ERROR_DUPLICATE_VCODE = 1043;
	// 只有一张银行卡不能销户
	public static final Integer ERROR_CAN_NOT_CLOSE = 1044;
	// 搜索关键字不能为空
	public static final Integer ERROR_KEYWORD_EMPTY = 1045;
	// 密码不符合规则
	public static final Integer ERROR_PASSWORD_MISMATCH_RULE = 1046;

	// {FIELD}日期不正确
	public static final Integer ERROR_INVALID_DATE = 1047;
	// 扣款日期不能是当天
	public static final Integer ERROR_NOT_CURRENT_DAY = 1048;
	// 扣款日期不能大于28号
	public static final Integer ERROR_NOT_SUPPORT_DAY = 1049;
	/***
	 * 未找到该用户
	 */
	public static final Integer ERROR_NO_USER_FIND = 1050;
	/***
	 * 非法设备
	 */
	public static final Integer ERROR_DEVICE_INVALID = 1051;
	/**
	 * 未找到下一个工作日
	 */
	public static final Integer ERROR_CANNOT_FIND_NEXT_WORKING_DAY = 1052;
	/**
	 * 未找到上一个工作日
	 */
	public static final Integer ERROR_CANNOT_FIND_LAST_WORKING_DAY = 1053;

	/** 没有T0相关的基金 **/
	public static final Integer ERROR_NO_T0_FUND = 1054;

	/**
	 * 无基金基础数据
	 */
	public static final Integer ERROR_GILDATA_EMPTY = 1055;

	// 未找到交易限制
	public static final Integer ERROR_TRADE_LIMIT_NOT_EXISTS = 1056;

	/**
	 * 未找到当前工作日
	 */
	public static final Integer ERROR_WORKING_DATE_NO_FIND = 1057;
	/**
	 * 未找到支付渠道
	 */
	public static final Integer ERROR_PAYWAY_NO_FIND = 1058;
	/**
	 * 未找到该支付渠道的银行单笔限额
	 */
	public static final Integer ERROR_PAYWAY_BANK_NO_FIND = 1059;

    /**
     * 未找到客户资料
     */
	public static final Integer ERROR_CLIENT_NO_FIND=1060;

    /**
     * 待办事项内容解析出错
     */
    public static final Integer ERROR_TODO_PARAMS_INVALID=1061;

    /**
     * 风险测评到期时间格式有误
     */
    public static final Integer ERROR_TEST_EXPIRED_DATE_INVALID=1062;
}
