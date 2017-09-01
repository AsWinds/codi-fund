package com.codi.bus.constant;

/**
 * Cache Key 常量
 * 
 * @author shi.pengyan
 * @date 2016年11月15日 上午11:08:47
 */
public interface CacheKeyConst {

    /** 证券主表 **/
    String MF_SECUMAIN = "MF_SECUMAIN";
    /** 基金类型 **/
    String MF_FUND_TYPE = "MF_FUND_TYPE";
    /** 基金评级 **/
    String MF_FUNDRATING = "MF_FUNDRATING";
    /** 基金管理人信息 **/
    String MF_FUND_MANAGER_PERSON_INFO = "MF_FUND_MANAGER_PERSON_INFO";

    /** 证券主表 **/
    String SECU_MAIN = "SECU_MAIN";

    /** 权益排序key **/
    String MF_FUND_NET_VALUE_PERFORMANCE_SORT = "MF_FUND_NET_VALUE_PERFORMANCE_SORT";

    /** 净值排序key **/
    String MF_FUND_NET_VALUE_SORT = "MF_FUND_NET_VALUE_SORT";

    /** 基金内部编码 关联表 **/
    String MF_FUND_CODE_RELATIONSHIP_NEW = "MF_FUND_CODE_RELATIONSHIP_NEW";

    /** SH300 **/
    String SH300 = "SH300";
    /** SH300_LATEST **/
    String SH300_LATEST = "SH300_LATEST";

}
