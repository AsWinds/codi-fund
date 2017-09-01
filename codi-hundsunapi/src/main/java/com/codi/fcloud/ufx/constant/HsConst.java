package com.codi.fcloud.ufx.constant;

/**
 * 恒生公共常量
 * <font color="red"> 放错位置了，暂时先这样</font>
 *
 * @author shi.pengyan
 * @date 2017-05-31 11:24
 */
public interface HsConst {

    /* 正序 */
    String SORT_DIRECTION_ASC  = "0";
    /* 倒序 */
    String SORT_DIRECTION_DESC = "1";

    /* 0-不重新统计 */
    Integer REQRY_RECORDSUM_FLAG_NO_REFRESH = 0;
    /*1-重新统计 */
    Integer REQRY_RECORDSUM_FLAG_REFRESH    = 1;

    /*普通投资者购买产品前警示*/
    String WARNING_TYPE_BEFORE_BUY                  = "A";
    /*普通投资者购买高风险产品的特别警示*/
    String WARNING_TYPE_BUY_HIGH_RISK_LEVEL_PRODUCT = "B";
    /*投资者购买不符合其风险承受能力的产品，风险不匹配警示*/
    String WARNING_TYPE_RISK_LEVEL_NOT_MATCH        = "C";
    /*普通投资者申请成为专业投资者风险警示*/
    String WARNING_TYPE_APPLY_TO_PROFESSION         = "D";
    /*产品风险等级变化风险警示*/
    String WARNING_TYPE_PRODCUT_RISK_LEVEL_CHANGE   = "E";

    /*柜台*/
    String WARNING_CHANNEL_COUNTER        = "0";
    /*网上交易*/
    String WARNING_CHANNEL_ONLINE_TRADING = "1";
    /*App*/
    String WARNING_CHANNEL_APP            = "2";
    /*微信*/
    String WARNING_CHANNEL_WECHAT         = "3";


    /*启用*/
    String WARNING_STATE_ENABLE  = "1";
    /*停用*/
    String WARNING_STATE_DISABLE = "0";

    /* 机构 */
    String ANSWER_TYPE_ORGANIZATION = "0";
    /* 个人 */
    String ANSWER_TYPE_PERSON       = "1";

    /* 非诚信 */
    String INTERGRITY_NO = "0";

    /* 诚信 */
    String INTERGRITY_YES = "1";

    /* 风险测评有效期 */
    Integer USER_RISK_LEVEL_EFFECT_YEAR = 1;

    /*【慎重】如果接口需要密码，但又不想让用户输入，请传此*/
    String NOPASSWORD = "NOPASSWORD";


    /* 身份证 */
    String ID_KIND_GB_ID_CARD = "0";

    //TODO 规范：系统参数都以 SYS_PARAM_ 开始
    /* 个人问卷调查有效天数 */
    String SYS_PARAM_RISK_QUESTION_VALID_DAY_FOR_PERSON = "RISKQUESTIONVALIDDAY";
}
