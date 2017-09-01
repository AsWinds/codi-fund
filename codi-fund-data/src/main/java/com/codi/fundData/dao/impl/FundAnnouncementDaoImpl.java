package com.codi.fundData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.base.dao.plugin.page.PageView;
import com.codi.fundData.dao.FundAnnouncementDao;
import com.codi.fundData.domain.FundAnnouncement;

/**
 * 
 * @author shi.pengyan
 * @date 2016年11月17日 下午3:57:17
 */
@Repository("fundAnnouncementDao")
public class FundAnnouncementDaoImpl extends BaseDAOImpl<FundAnnouncement> implements FundAnnouncementDao {

    @Override
    public FundAnnouncement queryFundAnnouncement(Long announcementID) {
        return this.getObject(generateStatement("selectFromAnnouncement"), announcementID);
    }

    @Override
    public FundAnnouncement queryFundInterimBulletin(Long id) {
        return this.getObject(generateStatement("selectFromInterimBulletin"), id);
    }

    @Override
    public List<FundAnnouncement> queryFundAnnouncement(Integer innerCode, Integer pageIndex, Integer pageSize) {

        PageView pageView = getPageView(pageIndex, pageSize);

        Map<String, Object> param = new HashMap<>();
        param.put("innerCode", innerCode);
        param.put("pageView", pageView);

        return this.findList(generateStatement("selectAnnouncement"), param);
    }

}
