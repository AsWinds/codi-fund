package com.codi.bus.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codi.base.exception.BaseAppException;
import com.codi.bus.core.resultModel.FundAnnouncementResult;
import com.codi.bus.core.resultModel.FundDetailResult;
import com.codi.bus.core.resultModel.FundNetValueHistoryResult;
import com.codi.bus.core.resultModel.FundNetValueResult;
import com.codi.bus.core.resultModel.FundOverViewResult;
import com.codi.bus.core.resultModel.FundPerformanceResult;
import com.codi.bus.core.service.model.FundAssetAllocationModel;
import com.codi.bus.core.service.model.FundInvestIndustryModel;
import com.codi.bus.core.service.model.FundSortModel;
import com.codi.bus.core.service.model.FundStatisticModel;
import com.codi.bus.exception.BaseException;
import com.codi.fundData.domain.FundAnnouncement;
import com.codi.fundData.domain.FundDetail;
import com.codi.fundData.domain.FundDividend;
import com.codi.fundData.domain.FundInvestAdvisorOutline;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.domain.FundManager;
import com.codi.fundData.domain.FundNetValuePerformance;
import com.codi.fundData.domain.FundPersonInfo;
import com.codi.fundData.domain.FundPortifolio;
import com.codi.fundData.domain.FundRating;
import com.codi.fundData.domain.FundSharesSplit;
import com.codi.fundData.domain.SecurityProduct;

/**
 * 基金详情服务(综合)
 *
 * @author shi.pengyan
 * @date 2016年9月22日 下午2:34:55
 */
public interface FundDetailService {

    /**
     * 获取基金基本信息
     *
     * @param fundCode
     *            基金代码
     * @return
     * @throws BaseException
     */
    SecurityProduct getSecurityProduct(String fundCode) throws BaseException;

    /**
     * 批量查询基金接口
     *
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseException
     */
    List<SecurityProduct> getSecurityProducts(List<String> fundCode) throws BaseException;

    /**
     * 获取基金的详情（简单）
     *
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseException
     */
    FundDetail getFundDetail(String fundCode) throws BaseException;

    /**
     * 获取基金详情
     *
     * @param innerCode
     *            基金内部编码
     * @return
     * @throws BaseException
     */
    FundDetail getFundDetailByInnerCode(Integer innerCode) throws BaseException;

    /**
     * 查询基金详情(复杂)
     *
     * @param fundCode
     *            基金编码
     * @return 基金详情信息
     * @throws BaseException
     */
    FundDetailResult getFundDetailByFundCode(String fundCode) throws BaseAppException;

    /**
     * 获取基金评级
     *
     * @param innerCode
     *            基金内部编码
     * @return
     * @throws BaseAppException
     */
    FundRating getFundRating(Integer innerCode) throws BaseAppException;

    /**
     * 通过管理人编码查询基金列表
     *
     * @param investAdvisorCode
     *            管理人编码
     * @param pageIndex
     *            当前页面码
     * @param pageSize
     *            分页大小
     * @return
     * @throws BaseAppException
     */
    List<Map<String, Object>> getFundByInvestAdvisor(int investAdvisorCode, int pageIndex, int pageSize)
            throws BaseAppException;

    /**
     * 获取基金概要
     *
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseException
     */
    FundOverViewResult getFundOverView(String fundCode) throws BaseException;

    /**
     * 获取单个基金指定日期净值
     *
     * @param fundCode
     *            基金编码
     * @param date
     *            某日期
     * @return 基金净值
     * @throws BaseException
     */
    FundNetValueResult getFundNetValue(String fundCode, Date date) throws BaseException;

    /**
     * 批量获取基金净值（从MF_NetValue中取）
     *
     * @param fundCodeList
     *            基金编码
     * @param date
     *            日期
     * @return
     * @throws BaseException
     */
    List<FundNetValueResult> getFundNetValueByBatch(List<String> fundCodeList, Date date) throws BaseException;

    /**
     * 获取基金净值历史信息
     *
     * @param innerCode
     *            基金内部编码
     * @param pageIndex
     *            页码
     * @param pageSize
     *            记录数
     * @return
     * @throws BaseException
     */
    FundNetValueHistoryResult getFundNetValueHistory(Integer innerCode, Integer pageIndex, Integer pageSize,
            Integer sort) throws BaseException;

    /**
     * 获取基金表现
     *
     * @param fundCodeList
     * @return
     * @throws BaseException
     */
    FundPerformanceResult getFundPerformance(String fundCodeList) throws BaseException;

    /**
     * 批量获取基金表现（统计信息）
     *
     * @param fundCodeList
     * @return
     * @throws BaseException
     */
    List<FundPerformanceResult> getFundPerformanceByBatch(List<String> fundCodeList) throws BaseException;

    /**
     * 获取基金净值最新表现（不包括货币基金）(统计相关信息)
     *
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseException
     */
    FundNetValuePerformance getFundNetValuePerformance(String fundCode) throws BaseException;

    /**
     * 获取货币型基金净值表现(统计相关信息);
     *
     * @param fundCode
     *            基金编码
     * @return
     * @throws BaseException
     */
    FundMMYieldPerformance getFundMMYieldPerformance(String fundCode) throws BaseException;

    /**
     * 获取基金管理人信息
     *
     * @param InvestAdvisorCode
     * @return
     * @throws BaseException
     */
    FundInvestAdvisorOutline getFundInvestAdvisorOutline(Integer investAdvisorCode) throws BaseException;

    /**
     * 查询公告列表
     *
     * @param param
     *            pageView,fundCode
     * @return
     * @throws BaseException
     */
    List<FundAnnouncement> getFundAnnouncements(Integer innerCode, Integer pageIndex, Integer pageSize)
            throws BaseException;

    /**
     * 读取公共详细内容
     *
     * @param announcementId
     *            数据库唯一标识
     * @param resourceType
     *            资源类型
     * @return
     * @throws BaseException
     */
    FundAnnouncementResult getFundAnnouncement(Long announcementId, String resourceType) throws BaseException;

    /**
     * 获取基金经理列表
     *
     * @param fundCode
     *            基金编码
     * @return 基金经理列表
     * @throws BaseException
     */
    List<FundManager> getFundManagers(String fundCode) throws BaseException;

    /**
     * 获取基金经理业绩
     *
     * @param fundManagerCode
     *            基金经理编码
     * @param status
     *            状态（是否在职）
     * @return
     * @throws BaseException
     */
    List<Map<String, Object>> getFundManagerPerformance(String fundManagerCode, Byte status) throws BaseException;

    /**
     * 查询基金分红列表
     *
     * @param param
     *            pageView,innerCode
     * @return
     * @throws BaseException
     */
    List<FundDividend> getFundDividend(Map<String, Object> param) throws BaseException;

    /**
     * 查询基金拆分
     *
     * @param param
     *            pageView,innerCode
     * @return
     * @throws BaseException
     */
    List<FundSharesSplit> getFundSharesSplit(Map<String, Object> param) throws BaseException;

    /**
     * 基金从业人员
     *
     * @param personalCode
     *            所属人员编码
     * @return
     * @throws BaseException
     */
    FundPersonInfo getFundPersonInfo(Long personalCode) throws BaseException;

    /**
     * 获取资产配置
     *
     * @param innerCode
     *            内部编码
     * @param assetTypeCodes
     *            指定资产编码类型
     * @return
     * @throws BaseException
     */
    List<FundAssetAllocationModel> getFundAssetAllocation(int innerCode, List<Integer> assetTypeCodes)
            throws BaseException;

    /**
     * 获取基金的投资组合
     *
     * @param innerCode
     *            基金内部编码
     * @return
     * @throws BaseException
     */
    List<FundPortifolio> getFundPortifolio(int innerCode) throws BaseException;

    /**
     * 获取基金的行业投资
     *
     * @param innerCode
     *            基金内部编码
     * @return
     * @throws BaseException
     */
    List<FundInvestIndustryModel> getFundInvestIndustry(int innerCode) throws BaseException;

    /**
     * 获取基金表现的统计数据
     *
     * @param innerCode
     *            基金内部编码
     * @param monthCount
     *            月份数
     * @param endDate
     *            截止日期
     * @return
     * @throws BaseAppException
     */
    List<FundStatisticModel> getStatisticData(Integer innerCode, int monthCount, Date endDate) throws BaseAppException;

    /**
     * 获取基金一段时间内的表现(非货基)
     *
     * @param innerCode
     *            基金内部编码
     * @param monthCount
     *            月份数
     * @param endDate
     *            截止日期
     * @return
     * @throws BaseAppException
     */
    BigDecimal getStatisticTotal(Integer innerCode, int monthCount, Date endDate) throws BaseAppException;

    /**
     * 获取某一类型基金的收益排行
     *
     * @param fundType
     *            基金类型
     * @param fundCodes
     *            基金编码列表
     * @param statisType
     *            统计类型 0-8: 日,周,月,季,半年,一年,两年,三年,今年以来
     * @param sort
     *            升降序<br/>
     *            0：升序；1：降序
     * @param pageIndex
     *            页码，从1开始
     * @param pageSize
     *            记录数
     * @return
     * @throws BaseAppException
     */
    List<FundSortModel> getSortByNetValuePerformance(Integer fundType, List<String> fundCodes, Integer statisType,
            Integer sort, Integer pageIndex, Integer pageSize) throws BaseAppException;

}
