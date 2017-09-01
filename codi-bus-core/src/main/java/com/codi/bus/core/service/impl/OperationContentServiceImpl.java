package com.codi.bus.core.service.impl;

import com.codi.base.exception.BaseAppException;
import com.codi.base.util.BigDecimalUtil;
import com.codi.base.util.JsonUtil;
import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.dao.OperationContentDao;
import com.codi.bus.core.domain.OperationContent;
import com.codi.bus.core.resultModel.FundPerformanceResult;
import com.codi.bus.core.resultModel.OperationContentResult;
import com.codi.bus.core.service.FundDetailService;
import com.codi.bus.core.service.OperationContentService;
import com.codi.bus.core.service.model.OperationBlockModel;
import com.codi.bus.core.service.model.OperationContentModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 首页运营内容 Service
 *
 * @author song-jj
 */
@Service("operationContentService")
@Transactional(readOnly = true)
public class OperationContentServiceImpl implements OperationContentService {

    @Resource
    private OperationContentDao operationContentDao;

    @Resource(name = "fundDetailService")
    private FundDetailService fundDetailService;

    private static final String KEY_NAME_FUND_CODE = "fundCode";

    private static final String KEY_NAME_FUND_NAME = "fundName";

    private static final String KEY_NAME_FUND_TYPE = "appFundType";

    private static final String KEY_NAME_FUND_TYPE_NAME = "fundTypeName";

    /**
     * 查询所有的首页运营内容，支持老版本
     */
    @Override
    public OperationContentResult queryOperationContent() {
        return queryOperationContent(false, GlobalConstant.DEFAULT_OPERATION_VERSION);
    }

    /**
     * 查询所有的首页运营内容,根据配置来显示收益类型
     * @param dynamicIndicant
     * @param operationVersion
     * @return
     */
    @Override
    public OperationContentResult queryOperationContent(boolean dynamicIndicant,String operationVersion) {
        OperationContentResult result = new OperationContentResult();
        result.setSuccess(true);
        // 从数据库表查询运营内容
        List<OperationContent> contents = operationContentDao.queryOperationContents(operationVersion);

        // 如果列表为空
        if (CollectionUtils.isEmpty(contents)) {
            return result;
        }

        List<String> fundCodeList = new ArrayList<String>();

        // 将fundeCode添加到codeList
        Map<String, Object> fundCodeMap = null;
        for (OperationContent currentContent : contents) {
            if (!StringUtils.isEmpty(currentContent.getExtraMap())) {
                fundCodeMap = JsonUtil.parseJSON2Map(currentContent.getExtraMap());
                if (fundCodeMap.get(KEY_NAME_FUND_CODE) == null) {
                    continue;
                }
                fundCodeList.add(fundCodeMap.get(KEY_NAME_FUND_CODE).toString());
            }
        }

        // 取得净值
        List<FundPerformanceResult> fundNetValueList = fundDetailService.getFundPerformanceByBatch(fundCodeList);
        Map<String, FundPerformanceResult> netValueMap = new HashMap<String, FundPerformanceResult>();
        // 转成MAP
        if (!CollectionUtils.isEmpty(fundNetValueList)) {
            for (FundPerformanceResult netValue : fundNetValueList) {
                // 未查到
                if (netValue == null) {
                    continue;
                }
                netValueMap.put(netValue.getFundCode(), netValue);
            }
        }

        List<OperationBlockModel> blocks = new ArrayList<OperationBlockModel>();
        result.setBlocks(blocks);

        // 将区块一致的内容，分为一组
        OperationBlockModel block = null;
        String lastBlockName = ""; // 上一条数据的区块名
        List<OperationContentModel> funds = null; // 基金列表
        OperationContentModel contentModel = null; // 基金内容
        Map<String, Object> extraMap = null;

        // 合并数据
        for (OperationContent currentContent : contents) {

            String blockName = currentContent.getBlockName();
            // 跟上一条比，不一致
            if (!lastBlockName.equals(currentContent.getBlockName().trim())) {
                block = new OperationBlockModel(); // 一个区块
                blocks.add(block);

                // 区块里有很多基金
                funds = new ArrayList<OperationContentModel>();
                block.setFunds(funds);
                block.setBlockName(blockName);
            }
            // 一致
            contentModel = new OperationContentModel();
            BeanUtils.copyProperties(currentContent, contentModel);
            funds.add(contentModel);

            // 标签列表
            if (StringUtil.isNotEmpty(contentModel.getTag())) {
                contentModel.setTags(Arrays.asList(contentModel.getTag().split("，")));
            }

            // 取得净值
            if (!StringUtils.isEmpty(currentContent.getExtraMap())) {
                extraMap = getNetValue(netValueMap, contentModel, currentContent, dynamicIndicant);
            }

            if (extraMap != null) {
                extraMap.put(KEY_NAME_FUND_NAME, contentModel.getDescription());
                contentModel.setExtraInfo(extraMap);
            }

            lastBlockName = blockName;

        }

        return result;
    }

    @Override
    public List<OperationContent> queryOperationContentNew() throws BaseAppException {
        return operationContentDao.selectAll();
    }

    @Override
    @Transactional(readOnly = false)
    public int addOperationContent(OperationContent operationContent) throws BaseAppException {
        operationContent.setStatus("0");
        Date now = new Date();
        operationContent.setCreateTime(now);
        operationContent.setLastUpdatedTime(now);
        return operationContentDao.insert(operationContent);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteOperationContent(Long id) throws BaseAppException {
        return operationContentDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateOperationContent(OperationContent operationContent) throws BaseAppException {
        Date now = new Date();
        operationContent.setLastUpdatedTime(now);
        return operationContentDao.updateByPrimaryKeySelective(operationContent);
    }

    @Override
    @Transactional(readOnly = false)
    public int onlineOperationContent(OperationContent operationContent) throws BaseAppException {
        return operationContentDao.updateByPrimaryKeySelective(operationContent);
    }


    private Map<String, Object> getNetValue(Map<String, FundPerformanceResult> netValueMap, OperationContentModel contentModel,
            OperationContent currentContent,boolean dynamicIndicant) {
        Map<String, Object> extraMap = JsonUtil.parseJSON2Map(currentContent.getExtraMap());
        String fundCde = extraMap.get(KEY_NAME_FUND_CODE).toString(); // 取得fund_code

        // 未找到相应fund code
        if (!netValueMap.containsKey(fundCde)) {
            return extraMap;
        }

        FundPerformanceResult netValue = netValueMap.get(fundCde);

        int fundTypeCode = netValue.getFundTypeCode() == null ? 0 : netValue.getFundTypeCode().intValue();
        /*if(!dynamicIndicant) {
            // 货币型基金，净值显示 7日年化收益率
            if (FundUtil.isCurrency(netValue.getFundTypeCode())) {
                String latestWeeklyYield = netValue.getLatestWeeklyYield() == null ? ""
                    : (BigDecimalUtil.ConvertToString(netValue.getLatestWeeklyYield()) + "%");
                contentModel.setIndicant(latestWeeklyYield);
                contentModel.setRate(netValue.getLatestWeeklyYield());

                // 非货币型，净值显示 近三月收益
            } else {
                String threeMonth = netValue.getRRInThreeMonth() == null ? ""
                    : (BigDecimalUtil.ConvertToString(netValue.getRRInThreeMonth()) + "%");
                contentModel.setIndicant(threeMonth);
                contentModel.setRate(netValue.getRRInThreeMonth());
            }
        }else {*/
            //Shangdu Lin - 20170329 - 根据数据库要显示哪个收益率配置来获取具体的收益率
            BigDecimal rate=getNetValuePerformance(contentModel.getIndicantType(),netValue);
            String rateString = rate == null ? "": (BigDecimalUtil.ConvertToString(rate) + "%");
            contentModel.setIndicant(rateString);
            contentModel.setRate(rate);
      /*  }*/
        extraMap.put(KEY_NAME_FUND_TYPE, netValue.getFundTypeCode()); // 基金类型代码
        extraMap.put(KEY_NAME_FUND_TYPE_NAME, netValue.getFundType());// 基金类型名称

        return extraMap;
    }

    /**
     * 获取指定收益率
     * @param indicantType
     * @param netValue
     * @return
     */
    private BigDecimal getNetValuePerformance(String indicantType, FundPerformanceResult netValue){

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_LAST_ONE_WEEK)){
            return netValue.getLatestWeeklyYield();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_ONE_WEEK)){
            return netValue.getRRInSingleWeek();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_ONE_MONTH)){
            return netValue.getRRInSingleMonth();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_THREE_MONTH)){
            return netValue.getRRInThreeMonth();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_SIX_MONTH)){
            return netValue.getRRInSixMonth();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_ONE_YEAR)){
            return netValue.getRRInSingleYear();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_TWO_YEAR)){
            return netValue.getRRInTwoYear();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_THREE_YEAR)){
            return netValue.getRRInThreeYear();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_FIVE_YEAR)){
            return netValue.getRRInFiveYear();
        }

        if(indicantType.equals(GlobalConstant.PERFORMANCE_TYPE_TEN_YEAR)){
            return netValue.getRRInTenYear();
        }

        return netValue.getRRInThreeMonth();
    }

}
