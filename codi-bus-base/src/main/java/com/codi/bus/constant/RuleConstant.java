package com.codi.bus.constant;

public class RuleConstant {

	// 过滤掉的基金类型
	public static final String RULE_LOOKUP_TYPE_EXCLUDE_FUND_TYPE = "EXDFDTYPE";
	// 过滤掉的基金代码
	public static final String RULE_LOOKUP_TYPE_EXCLUDE_FUND_CODE = "EXDFDCODE";
	// 过滤掉的银行
	public static final String RULE_LOOKUP_TYPE_EXCLUDE_BANK = "EXDBANK";
	// 恒生主持的银行
	public static final String RULE_LOOKUP_TYPE_HSBANK = "HSBANK";
	// 易宝主持的银行
	public static final String RULE_LOOKUP_TYPE_EPAYBANK = "EPAYBANK";
	// 交易账号状态
	public static final String RULE_LOOKUP_TYPE_TDACCSTATUS = "TDACCSTATUS";
	// TA账号状态
	public static final String RULE_LOOKUP_TYPE_TAACCSTATUS = "TAACCSTATUS";
	// 脱敏的对应规则
	public static final String RULE_LOOKUP_TYPE_DESEXP = "DESEXP";
	// 脱敏字段
	public static final String RULE_LOOKUP_TYPE_DESFD = "DESFD";
	// 交易业务名称
	public static final String RULE_LOOKUP_TYPE_BUSINAME = "BUSINAME";
	// T+0 基金
	public static final String RULE_LOOKUP_TYPE_T0FUND = "T0FUND";
	// SMS短信发送配置
	public static final String RULE_LOOKUP_TYPE_SMSCONF = "SMSCONF";
	// 设置一个发送次数，控制一个IP在一个时间段的发送次数
	public static final String RULE_LOOKUP_VALUE_IPLIMIT = "IPLIMIT";
	// 设置一个时间段，单位为分钟，控制一个IP在一个时间段的发送频率
	public static final String RULE_LOOKUP_VALUE_IPTIME = "IPTIME";
	// 设置一个发送次数，控制一个手机号在一个时间段的发送次数
	public static final String RULE_LOOKUP_VALUE_MOBILELIMIT = "MOBILELIMIT";
	// 设置一个时间段，单位为分钟，控制一个手机号在一个时间段的发送频率
	public static final String RULE_LOOKUP_VALUE_MOBILETIME = "MOBILETIME";
	// 支付渠道
	public static final String RULE_LOOKUP_TYPE_PAYWAY = "PAYWAY";
    // 资金方式
    public static final String RULE_LOOKUP_TYPE_CAPITALMODE = "CAPITALMODE";
    // 提示信息
    public static final String RULE_LOOKUP_TYPE_TIPS = "TIPS";

}
