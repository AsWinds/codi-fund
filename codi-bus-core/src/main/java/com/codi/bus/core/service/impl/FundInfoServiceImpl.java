/**
 *
 */
package com.codi.bus.core.service.impl;

import com.codi.base.util.Assert;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.FundInfoDao;
import com.codi.bus.core.dao.LookupDao;
import com.codi.bus.core.domain.FundInfo;
import com.codi.bus.core.resultModel.FundInfoListResult;
import com.codi.bus.core.resultModel.FundInfoResult;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.FundInfoService;
import com.codi.bus.core.service.QueryService;
import com.codi.bus.core.service.model.FundModel;
import com.codi.bus.exception.BaseException;
import com.codi.fundData.domain.FundDetail;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.message.constant.ErrorConstant;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 基金基本信息 serviceImpl
 *
 * @author song-jj
 *
 */
@Service("fundInfoService")
@Transactional
public class FundInfoServiceImpl implements FundInfoService {

    @Resource(name = "fundInfoDao")
    private FundInfoDao fundInfoDao;

    @Resource(name = "lookupDao")
    private LookupDao lookupDao;

    @Resource(name = "fundDetailService")
    private FundDetailService fundDetailService;

    @Autowired
    private QueryService queryService;

    /**
     * 字典表常量：基金类型
     */
    public static String RULE_LOOKUP_TYPE = "fundType";

    /**
     * 字典表-基金类型常量：0 普通型
     */
    public static String LOOKUP_TYPE_CODE_NORMAL = "0";

    /**
     * 根据恒生的基金，插入到数据库
     *
     * @throws Exception
     */
    @Override
    public void insertFundInfo(List<FundModel> fundList) throws Exception {
        // 无数据
        if (CollectionUtils.isEmpty(fundList)) {
            return;
        }

        // 生成基金代码列表，用于查询基金名称简写
        List<String> fundCodes = new ArrayList<String>();
        for (FundModel fundModel : fundList) {
            fundCodes.add(fundModel.getFundCode());
        }

        // 查询
        List<SecurityProduct> securityProducts = fundDetailService.getSecurityProducts(fundCodes);
        Map<String, String> shortNameMap = convertList2Map(securityProducts);

        FundInfo fundInfo = null;

        // 先删除旧数据
        fundInfoDao.delete();

        FundDetail detail = null;
        // 生成插入的对象
        for (FundModel fundModel : fundList) {
            fundInfo = new FundInfo();
            // 拷贝
            BeanUtils.copyProperties(fundInfo, fundModel);

            // 缩写
            if (shortNameMap.containsKey(fundModel.getFundCode())) {
                fundInfo.setShortName(shortNameMap.get(fundModel.getFundCode()));
            }

            // 从聚源取得基金类型名称
            detail = fundDetailService.getFundDetail(fundModel.getFundCode());
            if (detail == null) {

            } else {
                fundInfo.setFundTypeName(detail.getFundType());
                fundInfo.setFundTypeCode(detail.getFundTypeCode());
            }

            // fundModel已有基金风险等级
            /*// 设置基金风险等级 - add by Shangdu - 20170622
            NewsModel newsModel=queryService.getRiskLevel(fundModel.getFundCode());
            fundInfo.setRiskLevel(newsModel.getRiskLevel());*/

            // 插入数据库
            fundInfoDao.insert(fundInfo);
        }
    }

    private Map<String, String> convertList2Map(List<SecurityProduct> securityProducts) {
        Map<String, String> shortNameMap = new HashMap<String, String>();

        if (CollectionUtils.isEmpty(securityProducts)) {
            return shortNameMap;
        }

        // List 转 Map
        for (SecurityProduct product : securityProducts) {
            shortNameMap.put(product.getSecuCode(), product.getChiSpelling());
        }

        return shortNameMap;
    }

    /**
     * 根据关键字，模糊查询基金信息
     *
     * @throws Exception
     */
    @Override
    public FundInfoListResult query(String keyword) throws Exception {
        // 关键字不能为空
        if (StringUtil.isEmpty(keyword)) {
            throw new BaseException(ErrorConstant.ERROR_KEYWORD_EMPTY, "关键字不能为空", GlobalConstant.ERROR_TYPE_BUSINESS);
        }

        // 返回的基金信息列表
        List<FundInfoResult> fundInfoResults = new ArrayList<FundInfoResult>();

        FundInfoListResult result = new FundInfoListResult();
        result.setSuccess(true);
        result.setFundInfos(fundInfoResults);

        List<FundInfo> fundInfos = fundInfoDao.queryFundInfo(keyword);
        if (CollectionUtils.isEmpty(fundInfos)) {
            return result;
        }

        FundInfoResult fundInfoResult = null;
        // 基金类型转换
        for (FundInfo fundInfo : fundInfos) {
            fundInfoResult = new FundInfoResult();
            // 拷贝属性值
            BeanUtils.copyProperties(fundInfoResult, fundInfo);

            fundInfoResult.setAppFundType(fundInfo.getFundTypeCode());

            // 添加到返回列表中
            fundInfoResults.add(fundInfoResult);
        }

        return result;
    }

    /**
     * 根据基金类型代码，查询基金
     *
     * @param fundTypeCode 基金类型代码
     * @return 基金基本信息列表
     */
    @Override
    public List<FundInfo> queryFundInfoByType(Integer fundTypeCode) {
        // 基金类型代码不能为空
        Assert.notNull(fundTypeCode);

        return fundInfoDao.selectFundInfoByType(fundTypeCode);
    }

    /**
     * 分页查询基金
     *
     * @param pageSize 一页的记录数
     * @param pageIndex 当前页
     * @return 基金列表
     */
    @Override
    public List<FundInfo> queryPage(Integer pageSize, Integer pageIndex) {
        return fundInfoDao.queryPage(pageIndex, pageSize);
    }

    @Override
    public List<FundInfo> queryList(Integer pageIndex, Integer pageSize) {
        return fundInfoDao.queryList(pageIndex, pageSize);
    }

    @Override
    public int queryListCount() {
        return fundInfoDao.queryListCount();
    }

    /**
     * 根据基金类型代码，查询基金
     *
     * @param fundTypeCodes 基金类型代码 列表
     * @return 基金基本信息列表
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<FundInfo> queryFundInfoByTypes(List<Integer> fundTypeCodes) {
        Assert.notEmpty(fundTypeCodes);
        return fundInfoDao.selectFundInfoByTypes(fundTypeCodes);
    }

    /**
     * 更新所有已有基金的基金类型
     */
    public int updateFundType() {
        // 查询已有的基金
        List<FundInfo> fundList = fundInfoDao.queryAllFunds();

        // 无数据
        if (CollectionUtils.isEmpty(fundList)) {
            return 0;
        }

        FundInfo newFundInfo = null;
        Date now = new Date();
        int count = 0;
        for (FundInfo fundInfo : fundList) {
            FundDetail detail = fundDetailService.getFundDetail(fundInfo.getFundCode());
            // 类型代码或者类型名称无变化
            if (detail.getFundTypeCode().equals(fundInfo.getFundTypeCode())
                    && detail.getFundType().equals(fundInfo.getFundTypeName())) {
                continue;
            }
            // 有变更的情况，更新
            newFundInfo = new FundInfo();
            newFundInfo.setFundCode(fundInfo.getFundCode());
            newFundInfo.setFundTypeCode(detail.getFundTypeCode());
            newFundInfo.setFundTypeName(detail.getFundType());
            newFundInfo.setLastUpdatedDate(now);

            // 更新操作
            fundInfoDao.updateTypeByFundCode(newFundInfo);
            count++;
        }

        return count;
    }

}
