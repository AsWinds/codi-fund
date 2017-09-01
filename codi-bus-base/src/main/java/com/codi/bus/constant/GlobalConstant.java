package com.codi.bus.constant;

import java.math.BigDecimal;

public class GlobalConstant {
	// 手机号码长度
	public static final Integer MOBILE_LENGTH = 11;
	// 手机session保留天数
	public static final Integer EXPIRED_DAYS = 10;
	// 创蓝
	public static final String SMS_CHANNEL_DEFAULT = "CLan";
	// sms.properties属性channel key
	public static final String SMS_PROPERTY_CHANNEL = "channel";
	// templatecode key
	public static final String SMS_PROPERTY_TEMPLATE_CODE = "templatecode";
	public static final String SMS_TEMPLATE_CODE_DEFAULT = "REGVERIFYSMS";
	// 用户验证码
	public static final String SMS_BIZ_CODE_VERIFY = "REGVERIFYSMS";
	// 用户验证码字符串替换KEY
	public static final String SMS_PLACEHOLDER_VCODE = "VCODE";

	// 短信验证码过期时间
	public static final String SMS_PROPERTY_EXPIRED_SECONDS = "expiredseconds";
	public static final Integer SMS_EXPIRED_SECONDS_DEFAULT = 120;
	// 申请编号过去时间
	public static final Integer APPLY_EXPIRED_HOURS_DEFAULT = 24;

	// 日期格式 - yyyyMMdd
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    /* 日期格式 yyyy-MM-dd */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	// 日期格式 - HHmmss
	public static final String DATE_FORMAT_HHMMSS = "HHmmss";

	// 行业短信
	public static final Integer SMS_TYPE_INDUSTRY = 1;
	// 营销短信
	public static final Integer SMS_TYPE_MARKETING = 2;

	// 发送计划-立即发送
	public static final Integer SMS_PLAN_INSTANT = 1;
	// 发送计划-将来发送
	public static final Integer SMS_PLAN_FUTURE = 2;
	// 短信发送状态 - 发送中
	public static final Integer SMS_STATUS_SENDING = 0;
	// 短信发送状态 - 已发送
	public static final Integer SMS_STATUS_SENT = 1;
	// 短信发送状态 - 发送失败
	public static final Integer SMS_STATUS_FAILED = 10;

	// 恒生接口交易流水
	// Map - Key - Request
	public static final String KEY_REQUEST = "_request";
	// Map - Key - Request Raw
	public static final String KEY_REQUEST_RAW = "_request_raw";
	// Map - Key - Request header
	public static final String KEY_REQUEST_HEADER = "_request_header";
	// Map - Key - Request desensitize time
	public static final String KEY_REQUEST_DESENSITIZE_TIME = "_request_des_time";
	// Map - Key - Response
	public static final String KEY_RESPONSE = "_response";
	// Map - Key - Response Raw
	public static final String KEY_RESPONSE_RAW = "_response_raw";
	// Map - Key - Response desensitize time
	public static final String KEY_RESPONSE_DESENSITIZE_TIME = "_response_des_time";
	// Map - Key - List<Map<String, Object>>
	public static final String KEY_LIST_MAP = "_list_map";
	// Map - Key - API cost time
	public static final String KEY_API_COST_TIME = "_api_cost_time";
	// Map - Key - API
	public static final String KEY_API = "_api";

	// Map - Key - Method
	public static final String KEY_METHOD = "_method";

	// Redis - Key - Prefix - Mobile
	public static final String REDIS_KEY_MOBILE = "_mobile";
	// Redis - Key - Prefix - IP
	public static final String REDIS_KEY_IP = "_ip";
	// Redis - Key - Prefix - Apply Buy
	public static final String REDIS_KEY_APPLY_BUY = "_apply_buy";
	// Redis - Key - Prefix - Apply Sell
	public static final String REDIS_KEY_APPLY_SELL = "_apply_sell";
	// Redis - Key - Prefix - Apply Undo
	public static final String REDIS_KEY_APPLY_UNDO = "_apply_undo";
	// Redis - Key - Prefix - Apply VCode
	public static final String REDIS_KEY_APPLY_VCODE = "_apply_vcode";
	// Redis - Key - Prefix - Apply FAST_REDEEM
	public static final String REDIS_KEY_APPLY_FAST_REDEEM = "_apply_fast_redeem";
	// Redis - Key - Prefix - desensitize field
	public static final String REDIS_KEY_DESFD = "_DESFD";

	// 交易状态 - 成功
	public static final Integer TRANSACTION_STATUS_SUCCESS = 1;
	// 交易状态 - 失败
	public static final Integer TRANSACTION_STATUS_FAIL = -1;
	// 交易类型-调用恒生API接口
	public static final String TRANSACTION_TYPE_HSAPI = "HSAPI";
	// 交易类别
	// 交易类别 - 申购
	public static final String TRADE_TYPE_BUY = "BUY";
	// 交易类别 - 赎回
	public static final String TRADE_TYPE_SELL = "SELL";
	// 交易类别 - 撤单
	public static final String TRADE_TYPE_CANCEL = "CANCEL";
	// 交易类别 - 定投申购
	public static final String TRADE_TYPE_FIX = "FIX";
	// 交易类别 - 定投修改
	public static final String TRADE_TYPE_FIX_MODIFY = "FIX_MODIFY";
	// 交易类别 - 定投终止
	public static final String TRADE_TYPE_FIX_STOP = "FIX_STOP";
	// 交易类别 - 快速赎回
	public static final String TRADE_TYPE_FAST_REDEEM = "FAST_REDEEM";
	// 订单状态
	// 订单状态 - 交易申请
	public static final Integer ORDER_STATUS_APPLY = 1;
	// 订单状态 - 交易申请失败
	public static final Integer ORDER_STATUS_APPLY_FAIL = -1;
	// 订单状态 - 交易确认
	public static final Integer ORDER_STATUS_CONFIRM = 2;
	// 订单状态 - 交易确认失败
	public static final Integer ORDER_STATUS_CONFIRM_FAIL = -2;
	// 订单状态 - 撤单
	public static final Integer ORDER_STATUS_CANCEL = 3;
	// 交易基金状态
	// 交易基金状态 - 待确认
	public static final Integer FUND_STATUS_AWAITING_CONFIRM = 1;
	// 交易基金状态 - 申请失败
	public static final Integer FUND_STATUS_APPLY_FAIL = -1;
	// 交易基金状态 - 撤单
	public static final Integer FUND_STATUS_CANCEL = -2;
	// 基金类型
	// 货币型
	public static final String FUND_TYPE_CURRENCY = "2";
	// 保本型
	public static final String FUND_TYPE_BREAK_EVEN = "7";
	// 债券型
	public static final String FUND_TYPE_BOND = "6";
	// 混合基金
	public static final String FUND_TYPE_HYBRID = "b";
	// 股票型
	public static final String FUND_TYPE_STOCK = "1";
	// 指数型
	public static final String FUND_TYPE_INDEX = "8";
	// 基金风险等级
	// 低风险等级
	public static final Integer RISK_LEVEL_LOW = 1;
	public static final String RISK_LEVEL_LOW_STRING = "低风险";
	// 	中低风险基金
    public static final Integer RISK_LEVEL_MIDDLE_LOW = 2;
    public static final String RISK_LEVEL_MIDDLE_LOW_STRING = "中低风险";
	// 中风险等级
	public static final Integer RISK_LEVEL_MEDIUM = 3;
	public static final String RISK_LEVEL_MEDIUM_STRING = "中风险";
	// 中高风险基金
    public static final Integer RISK_LEVEL_MEDIUM_HIGH = 4;
    public static final String RISK_LEVEL_MEDIUM_HIGH_STRING = "中高风险";
	// 高风险等级
	public static final Integer RISK_LEVEL_HIGH = 5;
	public static final String RISK_LEVEL_HIGH_STRING = "高风险";

	// 投资人风险承受能力
    // 安全型
    public static final Integer INVEST_RISK_TOLERANCE_SAFE=1;

	// 扣款状态
	// 扣款状态-未校验
	public static final String DEDUCT_STATUS_UNCHECK = "0";
	// 未校验
	public static final String DEDUCT_STATUS_UNCHECK_STRING = "未扣款";
	// 扣款状态-无效
	public static final String DEDUCT_STATUS_INVALID = "1";
	// 无效
	public static final String DEDUCT_STATUS_INVALID_STRING = "扣款失败";
	// 扣款状态-有效
	public static final String DEDUCT_STATUS_VALID = "2";
	// 有效
	public static final String DEDUCT_STATUS_VALID_STRING = "扣款成功";
	// 扣款状态-已发送扣款指令
	public static final String DEDUCT_STATUS_SENT = "3";
	// 已发送扣款指令
	public static final String DEDUCT_STATUS_SENT_STRING = "扣款中";
	// 赎回中
	public static final String DEDUCT_STATUS_SELLING_STRING = "赎回中";
	// 赎回已确认
	public static final String DEDUCT_STATUS_SELLED_STRING = "已确认";
	// 发送标志 - 未发送
	public static final String SEND_FLAG_UNSEND = "0";
	// 工作日的结束时间 - HHmmss
	public static final String WORKING_DATE_END_TIME = "150000";
	// 银行卡类型
	// DC-储蓄卡
	public static final String CARD_TYPE_DC = "DC";
	// CC-信用卡
	public static final String CARD_TYPE_CC = "CC";

	// 申请业务编码 - 发起或者查询交易申请
	// 定期定额赎回
	public static final String FUND_BUSIN_CODE_APPLY_FIX_SELL = "095";
	// 定期定额赎回协议签订
	public static final String FUND_BUSIN_CODE_APPLY_FIX_SELL_SIGN = "091";
	// 定期定额赎回协议取消
	public static final String FUND_BUSIN_CODE_APPLY_FIX_SELL_CANCEL = "094";
	// 定期定额赎回协议修改
	public static final String FUND_BUSIN_CODE_APPLY_FIX_SELL_MODIFY = "987";

	// 定期定额申购
	public static final String FUND_BUSIN_CODE_APPLY_FIX_BUY = "039";
	// 定期定额申购协议签订
	public static final String FUND_BUSIN_CODE_APPLY_FIX_BUY_SIGN = "090";
	// 定期定额申购协议修改
	public static final String FUND_BUSIN_CODE_APPLY_FIX_BUY_MODIFY = "988";
	// 定期定额申购协议取消
	public static final String FUND_BUSIN_CODE_APPLY_FIX_BUY_CANCEL = "093";

	// //自定义code T0 申购, 叫做存入
	// public static final String FUND_BUSIN_CODE_T0_APPLY_BUY = "082";
	// //自定义code T0 赎回, 叫做取现
	// public static final String FUND_BUSIN_CODE_T0_APPLY_SELL = "084";

	// 申购
	public static final String FUND_BUSIN_CODE_APPLY_BUY = "022";
	// 申购字符串
	public static final String FUND_BUSIN_CODE_APPLY_BUY_STRING = "申购";
	// 赎回
	public static final String FUND_BUSIN_CODE_APPLY_SELL = "024";
	// T0快速赎回
	public static final String FUND_BUSIN_CODE_T0_FAST_APPLY_SELL = "098";

	// 赎回字符串
	public static final String FUND_BUSIN_CODE_APPLY_SELL_STRING = "赎回";
	// 设置分红方式
	public static final String FUND_BUSIN_CODE_APPLY_BONUS = "029";
	// 设置分红方式字符串
	public static final String FUND_BUSIN_CODE_APPLY_BONUS_STRING = "设置分红方式";
	// 撤销申请
	public static final String FUND_BUSIN_CODE_APPLY_UNDO = "053";
	// 撤销申请字符串
	public static final String FUND_BUSIN_CODE_APPLY_UNDO_STRING = "撤销申请";
	// 确认业务编码 - 查询交易确认
	// 认购
	public static final String FUND_BUSIN_CODE_CONFIRM_SUBSCRIBE_BUY = "120";
	// 申购
	public static final String FUND_BUSIN_CODE_CONFIRM_BUY = "122";
	// 赎回
	public static final String FUND_BUSIN_CODE_CONFIRM_SELL = "124";
	// 定期定额申购
    public static final String FUND_BUSIN_CODE_CONFIRM_FIX_BUY = "139";

	// 确认标志 - 未确认
	public static final String TACONFIRM_FLAG_UNCONFIRM = "9";
	public static final String TACONFIRM_FLAG_UNCONFIRM_STRING = "在途";
	// 确认标志 - 撤单
	public static final String TACONFIRM_FLAG_UNDO = "4";
	public static final String TACONFIRM_FLAG_UNDO_STRING = "已撤单";
	// 确认标志 - 确认失败
	public static final String TACONFIRM_FLAG_FAIL = "0";
	public static final String TACONFIRM_FLAG_FAIL_STRING = "确认失败";
	// 确认标志 - 确认成功
	public static final String TACONFIRM_FLAG_CONFIRMED = "1";
	public static final String TACONFIRM_FLAG_CONFIRMED_STRING = "确认成功";
	// 确认标志 - 部分确认
	public static final String TACONFIRM_FLAG_PART_CONFIRMED = "2";
	public static final String TACONFIRM_FLAG_PART_CONFIRMED_STRING = "部分确认";
	// 确认标志 - 实时确认成功
	public static final String TACONFIRM_FLAG_REAL_SUCCESS = "3";
	public static final String TACONFIRM_FLAG_REAL_SUCCESS_STRING = "实时确认成功";
	// 确认标志 - 行为确认
	public static final String TACONFIRM_FLAG_ACTION = "5";
	public static final String TACONFIRM_FLAG_ACTION_STRING = "行为确认";

	// 分页请求所有的记录
	public static final Integer MAX_REQUEST_NUM = 99999;

	// 分页请求的最大条数
	public static final Integer ALLOWED_MAX_REQUEST_NUM = 50;

	// 资金方式-P-易宝
	public static final String CAPITAL_MODE_EPAY = "P";
	// 资金方式-P-易宝
	public static final String CAPITAL_MODE_EPAY_STRING = "易宝";
	// 资金方式-1-柜台-普通方式
	public static final String CAPITAL_MODE_COUNTER = "1";
	// 资金方式-1-柜台-普通方式
	public static final String CAPITAL_MODE_COUNTER_STRING = "柜台";
	// 用户的来源
	// APP
	public static final String USER_FROM_APP = "APP";
	// 柜台
	public static final String USER_FROM_COUNTER = "COUNTER";
	// WEB
	public static final String USER_FROM_WEB = "WEB";

	/** codi数据源KEY **/
	public static final String DATA_SOURCE_CODI = "DATA_SOURCE_CODI";
	/** 基金详情数据源KEY **/
	public static final String DATA_SOURCE_FUND_DETAIL = "DATA_SOURCE_FUND_DETAIL";

	/** BigDecimal 0 */
	public static final BigDecimal BIG_DECIMAL_0 = new BigDecimal(0);
	/** BigDecimal 100 */
	public static final BigDecimal BIG_DECIMAL_100 = new BigDecimal(100);

	/** 个人用户 **/
	public static final String CUST_TYPE_PERSONAL = "1";

	/** 机构户 **/
	public static final String CUST_TYPE_ORGANIZATION = "0";

	/** 份额类别 A */
	public static final String SHARE_TYPE_A = "A";

	/** 份额类型B */
	public static final String SHARE_TYPE_B = "B";
	/** 10 */
	public static final BigDecimal NUMBER_TEN = new BigDecimal(10);
	/** 一亿 */
	public static final BigDecimal NUMBER_ONE_HUNDRED_MILLION = new BigDecimal(Math.pow(10, 8));
	/** 一百万，0.01亿 */
	public static final BigDecimal NUMBER_ONE_MILLION = new BigDecimal(Math.pow(10, 6));
	/** 1w */
	public static final BigDecimal NUMBER_TEN_THOUSAND = new BigDecimal(Math.pow(10, 4));
	/** 万元 **/
	public static final String PRICE_UNIT_TEN_THOUSAND = "万元";
	/** 亿元 **/
	public static final String PRICE_UNIT_TEN_HUNDRED_MILLION = "亿元";
	/** 万份 */
	public static final String SHARE_UNIT_TEN_THOUSAND = "万份";
	/** 亿份 **/
	public static final String SHARE_UNIT_TEN_HUNDRED_MILLION = "亿份";
	// 账号状态
	// 未开户
	public static final int ACCOUNT_STATUS_NO_OPEN = 1;
	// 柜台已开户, APP未绑定银行卡
	public static final int ACCOUNT_STATUS_COUNTER_OPEN = 2;
	// APP已开户
	public static final int ACCOUNT_STATUS_APP_OPEN = 3;
	// 主交易账号
	public static final String MAIN_ACCOUNT_FLAG_YES = "1";
	// 设置一个发送次数，控制一个手机号在一个时间段的发送次数
	public static final int SMS_ALLOWED_NUMBERS_ONE_MOBILE_ONE_UNIT = 1;
	// 设置一个发送次数，控制一个IP在一个时间段的发送次数
	public static final int SMS_ALLOWED_NUMBERS_ONE_IP_ONE_UNIT = 600;
	// 设置一个时间段，单位为分钟，控制一个手机号在一个时间段的发送频率，单位为分钟
	public static final int SMS_ALLOWED_TIME_ONE_MOBILE = 1;
	// 设置一个时间段，单位为分钟，控制一个IP在一个时间段的发送频率
	public static final int SMS_ALLOWED_TIME_ONE_IP = 60;
	/*
	 * 基金信息中的基金状态: 0 正常开放 1 认购时期 2 停止赎回 3 停止申购 4 封闭期 5 停止交易 6 基金终止 7 权益登记 8 红利发放
	 * 9 发行失败 a 非本机构代销 b 发行成功 z 转认购期
	 */
	// 正常开放
	public static final String FUND_BASE_STATUS_OPEN = "0";
	// 认购时期
	public static final String FUND_BASE_STATUS_SUBSCRIBE = "1";
	// 停止赎回
	public static final String FUND_BASE_STATUS_STOP_SELL = "2";
	// 停止申购
	public static final String FUND_BASE_STATUS_STOP_BUY = "3";
	// 封闭期
	public static final String FUND_BASE_STATUS_CLOSE = "4";
	// 停止交易
	public static final String FUND_BASE_STATUS_STOP_TRADE = "5";
	// 基金终止
	public static final String FUND_BASE_STATUS_FUND_STOP = "6";
	// 权益登记
	public static final String FUND_BASE_STATUS_GAIN_REGISTER = "7";
	// 红利发放
	public static final String FUND_BASE_STATUS_DIVIDEND_OFFER = "8";
	// 发行失败
	public static final String FUND_BASE_STATUS_ISSUE_FAIL = "9";
	// 非本机构代销
	public static final String FUND_BASE_STATUS_NOT_BELOG = "a";
	// 发行成功
	public static final String FUND_BASE_STATUS_ISSUE_SUCCESS = "b";
	// 转认购期
	public static final String FUND_BASE_STATUS_TURN_TO_SUBSCRIBE = "z";
	// 银行卡状态
	// 不在渠道支持的列表里
	public static final int BANK_CARD_TYPE_NOT_SUPPORT = 1;
	// 信用卡
	public static final int BANK_CARD_TYPE_CC = 2;
	// 储蓄卡
	public static final int BANK_CARD_TYPE_DC = 3;
	// 卡bin未识别出来
	public static final int BANK_CARD_TYPE_UNDEFINE = 4;
	// 币种类别:0-人民币
	public static final Integer MONEY_TYPE_RMB = 0;
	// 交易周期:1个月
	public static final String TRADE_PERIOD_ONE_MONTH = "1";
	public static final String FUND_BUSIN_CODE_FIX = "090";
	/**
	 * 协议状态:正常协议修改填A
	 */
	public static final String FIX_STATE_NORMAL = "A";
	/**
	 * 协议状态:终止协议填H
	 */
	public static final String FIX_STATE_STOP = "H";
	// 交易账号状态 - 0-正常
	public static final String TRADE_ACCOUNT_STATUS_WORKING = "0";
	/**
	 * 巨额赎回标识：继续赎回
	 */
	public static final String FUND_EXCEED_FLAG = "1";
	/**
	 * 定投动作：申购
	 */
	public static final String FIX_MODEL_NORMAL = "0";
	/**
	 * 定投动作：定投修改
	 */
	public static final String FIX_MODEL_MODIFY = "1";
	/**
	 * 定投动作：定投终止
	 */
	public static final String FIX_MODEL_STOP = "2";
	/**
	 * 协议周期单位:月
	 */
	public static final String PROTOCOL_PERIOD_UNIT_WEEK = "1";
	/**
	 * 协议周期单位:月
	 */
	public static final String PROTOCOL_PERIOD_UNIT_MONTH = "0";
	/***
	 * 系统错误
	 */
	public static final String ERROR_TYPE_SYSTEM = "SYS";
	/***
	 * 应用错误
	 */
	public static final String ERROR_TYPE_APPLICATION = "APC";
	/***
	 * 业务错误
	 */
	public static final String ERROR_TYPE_BUSINESS = "BUS";
	/**
	 * App-Device头
	 */
	public static final String HEADER_APP_DEVICE = "App-Device";
    public static final String HEADER_AUTH_TOKEN = "Auth-Token";
    public static final String HEADER_CLIENT_VERSION = "Client-Version";
    public static final String HEADER_OS_TYPE = "Os-Type";
    public static final String HEADER_APP_IDENTIFIER = "App-Identifier";
	/**
	 * 最大的假期数，会被用在计算上一个工作日的接口中
	 */
	public static final int MAX_NON_WORKING_DAY = 15;
	/**
	 * 零钱包
	 */
	public static final int ASSET_TYPE_WALLET = 1;
	/**
	 * 基金
	 */
	public static final int ASSET_TYPE_FUND = 2;
	/**
	 * 设置获取快速赎回未T+1确认份额的前后天数
	 */
	public static final Integer FAST_REDEEM_INTERVAL_DAYS_AFTER_BEFORE = 30;
    /**
     * 私募24小时内不能重复预约
     */
    public static final Integer PE_APPOINTMENT_DAYS = 1;

    /**
     * 私募
     */
    /**
     * 已上架
     */
    public static final Integer PE_PRODUCT_STUTAS_ONSALE = 1;
    /**
     * 已下架
     */
    public static final Integer PE_PRODUCT_STUTAS_NOT_ONSALE = 2;
    /**
     * 私募入口用户风险测评时提交测评结果的临时代理用户名称，因为私募入口的时候用户可能只是注册还未开户，所以没有用户名称
     */
    public static final String TEST_PROXY_NAME="平台代理";
    /**
     * 基金的最新表现,包括周、一个月、三个月、半年、一年、二年、三年、五年、十年、成立以来的回报
     */
    public static final String PERFORMANCE_TYPE_ONE_WEEK="1W";
    public static final String PERFORMANCE_TYPE_LAST_ONE_WEEK="L1W";
    public static final String PERFORMANCE_TYPE_ONE_MONTH="1M";
    public static final String PERFORMANCE_TYPE_THREE_MONTH="3M";
    public static final String PERFORMANCE_TYPE_SIX_MONTH="6M";
    public static final String PERFORMANCE_TYPE_ONE_YEAR="1Y";
    public static final String PERFORMANCE_TYPE_TWO_YEAR="2Y";
    public static final String PERFORMANCE_TYPE_THREE_YEAR="3Y";
    public static final String PERFORMANCE_TYPE_FIVE_YEAR="5Y";
    public static final String PERFORMANCE_TYPE_TEN_YEAR="10Y";
    /**
     * 首页运营内容的默认版本，此字段设计成用于支持老版本     *
     */
    public static final String DEFAULT_OPERATION_VERSION="1";
    /**
     * T0 在使用funds
     */
    public static int T0_FUNDS_IN_USE = 1;

    /**
     * 警示渠道-APP
     */
    public static final String WARNING_CHANNEL_APP="2";

}
