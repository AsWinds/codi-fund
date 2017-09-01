package com.codi.bus.core.resultModel;

import java.util.List;

import com.codi.fundData.domain.FundAnnouncement;

/**
 * 公告
 * @author shi.pengyan
 * @date 2016年11月17日 下午4:00:39
 */
public class FundAnnouncementsResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private List<FundAnnouncement> announcements;

    public List<FundAnnouncement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<FundAnnouncement> announcements) {
        this.announcements = announcements;
    }

}
