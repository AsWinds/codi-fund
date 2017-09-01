package com.codi.bus.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.codi.base.exception.BaseAppException;
import com.codi.base.util.DateUtil;
import com.codi.bus.constant.FundConst;
import com.codi.bus.core.BaseTest;
import com.codi.bus.core.resultModel.FundAnnouncementResult;
import com.codi.bus.core.resultModel.FundDetailResult;
import com.codi.bus.core.resultModel.FundNetValueResult;
import com.codi.bus.core.resultModel.FundOverViewResult;
import com.codi.bus.core.resultModel.FundPerformanceResult;
import com.codi.bus.core.service.model.FundInvestIndustryModel;
import com.codi.bus.exception.BaseException;
import com.codi.fundData.domain.FundAnnouncement;
import com.codi.fundData.domain.FundInvestAdvisorOutline;
import com.codi.fundData.domain.FundMMYieldPerformance;
import com.codi.fundData.domain.FundNetValuePerformance;
import com.codi.fundData.domain.FundPersonInfo;
import com.codi.fundData.domain.FundPortifolio;
import com.codi.fundData.domain.FundRating;
import com.codi.fundData.domain.SecurityProduct;
import com.codi.fundData.service.SecurityProductService;

/**
 * FundDetail test
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午4:42:29
 */
public class FundDetailServiceTest extends BaseTest {

    @Autowired
    private FundDetailService fundDetailService;

    @Autowired
    private SecurityProductService securityProductService;

    // @Autowired
    // private UserService userService;

    // 货币基金 550010 12754
    private static final String FUND_CODE_CURRENCY = "550010";
    private static final int FUND_INNER_CODE_CURRENCY = 12754;

    // 债券基金 550004 7254
    private static final String FUND_CODE_BOND = "550004";
    private static final int FUND_INNER_CODE_BOND = 7254;

    // 混合基金 550001 4196
    private static final String FUND_CODE_MIXIN = "550001";
    private static final int FUND_INNER_CODE_MIXIN = 4196;

    // 短期理财，表现为货币基金
    private static final String FUND_CODE_SHORT_TERM_FINANCING = "550012";
    private static final int FUND_INNER_CODE_SHORT_TERM_FINANCING = 20561;

    // QDII
    private static final String FUND_CODE_QDII = "378546";
    private static final int FUND_INNER_CODE_QDII = 16426;

    @Before
    public void init() {
        // DataSourceContextHolder.setContextType(GlobalConstant.DATA_SOURCE_FUND_DETAIL);
        // fundDetailService = (FundDetailService)
        // ctx.getBean("fundDetailService");
        // userService = (UserService) ctx.getBean("userService");
        System.out.println("mixin innerCode" + FUND_INNER_CODE_MIXIN);
        System.out.println("FUND_INNER_CODE_SHORT_TERM_FINANCING=" + FUND_INNER_CODE_SHORT_TERM_FINANCING);
        System.out.println("FUND_CODE_QDII" + FUND_CODE_QDII);
        System.out.println("FUND_INNER_CODE_QDII" + FUND_INNER_CODE_QDII);

    }

    @Test
    public void getSecurityProduct() throws BaseAppException {
        SecurityProduct p = securityProductService.querySecurityProduct(FUND_CODE_CURRENCY);
        System.out.println(p);
    }

    @Test
    public void getSecurityProductTest() throws BaseException {
        SecurityProduct product = fundDetailService.getSecurityProduct(FUND_CODE_CURRENCY);
        System.out.println(product);
        // 信诚货A
        Assert.assertEquals("XCHA", product.getChiSpelling());
    }

    @Test
    public void getSecurityProductsTest() throws BaseException {
        List<String> fundCodes = new ArrayList<>();
        fundCodes.add(FUND_CODE_BOND);
        fundCodes.add(FUND_CODE_CURRENCY);
        fundCodes.add(FUND_CODE_MIXIN);

        List<SecurityProduct> products = fundDetailService.getSecurityProducts(fundCodes);
        for (SecurityProduct p : products) {
            System.out.println(p.getSecuCode() + "\t" + p.getChiName() + "\t" + p.getChiSpelling());
        }
    }

    @Test
    public void getFundDetailTest() throws BaseAppException {
        // FundDetailResult result =
        // fundDetailService.getFundDetailByFundCode(FUND_CODE_CURRENCY);
        FundDetailResult result = fundDetailService.getFundDetailByFundCode(FUND_CODE_SHORT_TERM_FINANCING);

        System.out.println(result.toString(2));
    }

    @Test
    public void combineTest() throws BaseException {

        // LoginResult loginResult = userService.login("1111", "111", "aa",
        // "111");
        //
        // System.out.println(loginResult);
        //
        // SecurityProduct product =
        // fundDetailService.getSecurityProduct(FUND_CODE_CURRENCY);
        // System.out.println(product);
        //
        // LoginResult loginResult2 = userService.login("1111", "111", "aa",
        // "111");
        //
        // System.out.println(loginResult2);

    }

    @Test
    public void fundNetValueTest() throws BaseException {
        Date date = DateUtil.parse("2016-09-23 12:12:12");
        date = new Date();
        FundNetValueResult result = fundDetailService.getFundNetValue(FUND_CODE_CURRENCY, date);

        System.out.println(DateUtil.format(date, "YYYY-MM-DD HH:mm:ss"));
        System.out.println("货基");
        System.out.println(result);

        FundNetValueResult result2 = fundDetailService.getFundNetValue(FUND_CODE_BOND, date);
        System.out.println("非货基");
        System.out.println(result2);
    }

    @Test
    public void fundNetValueBatchTest() throws BaseException {
        Date date = new Date();
        List<String> fundCodeList = new ArrayList<String>();
        fundCodeList.add("550010");
        fundCodeList.add("550001");

        List<FundNetValueResult> fundNetValueList = fundDetailService.getFundNetValueByBatch(fundCodeList, date);

        System.out.println(DateUtil.format(date, "YYYY-MM-DD HH:mm:ss"));
        if (fundNetValueList != null) {
            for (FundNetValueResult fundNetValue : fundNetValueList) {
                System.out.println(fundNetValue);
                System.out.println("---------------------");
            }
        }
    }

    @Test
    public void fundRatingTest() throws BaseAppException {
        FundRating fundRating = fundDetailService.getFundRating(FUND_INNER_CODE_CURRENCY);
        System.out.println(fundRating);
    }

    // 非货币型基金
    @Test
    public void fundNetValuePerformanceTest() throws BaseException {
        FundNetValuePerformance netValue = fundDetailService.getFundNetValuePerformance(FUND_CODE_BOND);
        System.out.println(netValue);
    }

    // 必须是货币型
    @Test
    public void fundMMYieldPerformanceTest() throws BaseException {
        FundMMYieldPerformance netValue = fundDetailService.getFundMMYieldPerformance(FUND_CODE_CURRENCY);
        System.out.println(netValue);
    }

    @Test
    public void fundPerformanceTest() throws BaseException {
        // 550012 债券型货基
        FundPerformanceResult result = fundDetailService.getFundPerformance("217026");
        System.out.println("-------217026-------------");
        System.out.println(result);

        // result = fundDetailService.getFundPerformance(FUND_CODE_BOND);
        // System.out.println(result);
        //
        // result = fundDetailService.getFundPerformance(FUND_CODE_MIXIN);
        // System.out.println(result);

    }

    @Test
    public void fundInvestAdvisorOutlineTest() throws BaseException {
        int investAdvisorCode = 10684;
        FundInvestAdvisorOutline result = fundDetailService.getFundInvestAdvisorOutline(investAdvisorCode);
        System.out.println(result);
        Assert.assertEquals(result.getInvestAdvisorName(), "信诚基金管理有限公司");
    }

    @Test
    public void fundAnnouncementsTest() throws BaseException {

        List<FundAnnouncement> result = fundDetailService.getFundAnnouncements(
                Integer.valueOf(FUND_INNER_CODE_CURRENCY), 1, 10);

        for (FundAnnouncement item : result) {
            System.out.println(item.getID() + "\t" + item.getTitle());
        }
        System.out.println("共：" + result.size());
    }

    @Test
    public void fundAnnouncementTest() throws BaseException {
        Long announcementId = 525343509379L;
        // announcementId=495532512902L;//notText
        System.out.println("季度公告");
        FundAnnouncementResult result = fundDetailService.getFundAnnouncement(announcementId,
                FundConst.FUND_ANNOUNCEMENT_FROM_ANNOUNCEMENT);
        System.out.println(result);

        System.out.println("临时公告");

        result = fundDetailService.getFundAnnouncement(495532506214L, FundConst.FUND_ANNOUNCEMENT_FROM_INTERIMBULLETIN);
        System.out.println(result);

    }

    /**
     * 基金从业人员信息
     * 
     * @throws BaseException
     */
    @Test
    public void queryFundManagerPersonInfoTest() throws BaseException {
        String fundManagerCode = "101001834";
        FundPersonInfo result = fundDetailService.getFundPersonInfo(Long.valueOf(fundManagerCode));
        System.out.println(result);
    }

    /**
     * 基金经理业绩
     * 
     * @throws NumberFormatException
     * @throws BaseException
     */
    @Test
    public void queryFundManagerPerformanceTest() throws NumberFormatException, BaseException {
        String fundManagerCode = "101001834";
        // 查询所有业绩
        List<Map<String, Object>> result = fundDetailService.getFundManagerPerformance(fundManagerCode, null);
        System.out.println(result);
    }

    @Test
    public void queryFundOverviewTest() throws BaseException {
        FundOverViewResult result;
        // result = fundDetailService.getFundOverView(FUND_CODE_CURRENCY);
        // System.out.println(result);

        result = fundDetailService.getFundOverView(FUND_CODE_MIXIN);
        System.out.println(result);
    }

    @Test
    public void queryFundPortfioloTest() throws NumberFormatException, BaseException {
        List<FundPortifolio> list = fundDetailService.getFundPortifolio(Integer.valueOf(FUND_INNER_CODE_BOND));
        System.out.println(list);
    }

    @Test
    public void queryFundInvestIndustry() throws NumberFormatException, BaseException {
        List<FundInvestIndustryModel> list = fundDetailService.getFundInvestIndustry(Integer
                .valueOf(FUND_INNER_CODE_QDII));
        System.out.println(list);
        System.out.println("----------------------------");

        list = fundDetailService.getFundInvestIndustry(Integer.valueOf(FUND_INNER_CODE_MIXIN));
        System.out.println(list);
    }

}
