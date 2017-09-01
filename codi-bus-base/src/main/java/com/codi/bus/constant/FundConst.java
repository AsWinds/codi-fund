package com.codi.bus.constant;

/**
 * 基金常量
 * 
 * @author shi.pengyan
 * @date 2016年9月23日 上午11:27:05
 */
public interface FundConst {
    /** 股票型 **/
    int FUND_TYPE_CODE_STOCK = 1101;
    /** 混合型 **/
    int FUND_TYPE_CODE_MIXIN = 1103;
    /** 债券型 **/
    int FUND_TYPE_CODE_BOND = 1105;
    /** 保本型 **/
    int FUND_TYPE_CODE_GUARANTEE = 1107;
    /** 货币型 **/
    int FUND_TYPE_CODE_CURRENCY = 1109;
    /** QDII **/
    int FUND_TYPE_CODE_QDII = 1110;
    /** 其他型 **/
    int FUND_TYPE_CODE_OTHER = 1199;
    /** 短期理财类型（表现形式是货基） **/
    int FUND_TYPE_CODE_SHORT_TERM_FINANCING = 900000;
    /** 指数型 **/
    int FUND_TYPE_CODE_INDEX = 910000;

    /** 基金公告来自季度表 **/
    String FUND_ANNOUNCEMENT_FROM_ANNOUNCEMENT = "FROM_ANNOUNCEMENT";
    /** 基金公告来自临时表 **/
    String FUND_ANNOUNCEMENT_FROM_INTERIMBULLETIN = "FROM_INTERIMBULLETIN";

    /** 基金经理在任 */
    Byte FUND_MANAGER_INCUMBENT = 1;
    /** 基金经理离任 */
    Byte FUND_MANAGER_INCUMBENT_OUT = 0;

    /** 资产种类代码 **/
    int FUND_ASSET_TYPE_TOTAL = 10099;

    /** 基金是否分红，是 */
    int FUND_DIVIDEND_DISTRIBUTE_YES = 1;
    /** 基金是否分红，否 */
    int FUND_DIVIDEND_DISTRIBUTE_NO = 0;

    /** 短期理财债券型基金 */
    int DATA_CODE_SHORT_TERM_FINANCING = 12070000;
    /** 短期理财债券型基金(A类) */
    int DATA_CODE_SHORT_TERM_FINANCING_A = 12070100;
    /** 短期理财债券型基金(B/C类) */
    int DATA_CODE_SHORT_TERM_FINANCING_B_AND_C = 12070200;
    /** QDII类型基金 */
    int DATA_CODE_QDII = 15000000;
    int DATA_CODE_QDII_100 = 15010000;
    int DATA_CODE_QDII_101 = 15010100;
    int DATA_CODE_QDII_102 = 15010200;
    int DATA_CODE_QDII_103 = 15010300;
    int DATA_CODE_QDII_104 = 15010400;
    int DATA_CODE_QDII_105 = 15010500;
    int DATA_CODE_QDII_108 = 15010800;
    int DATA_CODE_QDII_109 = 15010900;
    int DATA_CODE_QDII_200 = 15020000;
    int DATA_CODE_QDII_300 = 15030000;
    int DATA_CODE_QDII_400 = 15040000;
    int DATA_CODE_QDII_500 = 15050000;
    int DATA_CODE_QDII_600 = 15060000;
    int DATA_CODE_QDII_700 = 15070000;
    int DATA_CODE_QDII_701 = 15070100;
    int DATA_CODE_QDII_702 = 15070200;

    /** 指数型基金 **/
    int DATA_CODE_INDEX_100 = 10020100;
    int DATA_CODE_INDEX_200 = 10020200;

    /** 56-聚源基金分类 */
    int TYPE_CODE_JU_YUAN = 56;

    String FUND_TYPE_LABEL_SHORT_TERM_FINANCING = "短期理财";

    String FUND_TYPE_LABEL_QDII = "QDII";

    String FUND_TYPE_LABEL_INDEX = "指数型";

    /** 股票 **/
    int ASSET_TYPE_CODE_STOCK = 10020;
    /** 债券 **/
    int ASSET_TYPE_CODE_BOND = 10010;
    /** 银行存款 **/
    int ASSET_TYPE_CODE_BANK = 1000202;
    /** 其他资产 **/
    int ASSET_TYPE_CODE_OTHER = 10090;
    /** 基金 **/
    int ASSET_TYPE_CODE_FUND = 10015;

    /** 有效 **/
    int CODE_EFFECT_YES = 1;
    /** 无效 **/
    int CODE_EFFECT_NO = 2;
    /** 没有 **/
    String NONE = "NONE";

    // 22-母子基金分级关联 23-复制型基金关联 24-联接基金关联
    // 25-封转开基金对应 26-同一基金保本期关联 27-基金与收益线对应 29-开放式基金转型对应
    // 37-同一基金货币关系关联
    /** 21-同一基金分级关联 **/
    int CODE_DEFINE_SAME_FUND_CASCADE = 21;

    /** 升序 */
    int SORT_ASC = 0;
    /** 降序 */
    int SORT_DESC = 1;

}
