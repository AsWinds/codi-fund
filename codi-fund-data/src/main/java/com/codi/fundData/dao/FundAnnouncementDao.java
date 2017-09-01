package com.codi.fundData.dao;

import java.util.List;

import com.codi.fundData.domain.FundAnnouncement;

/**
 * 基金公告
 * 
 * @author shi.pengyan
 * @date 2016年9月25日 下午1:58:22
 */
public interface FundAnnouncementDao {

    /**
     * 获取公共列表
     * 
     * @param innerCode
     *            基金内部编码
     * @param pageIndex
     *            页码
     * @param pageSize
     *            记录数大小
     * @return
     */
    List<FundAnnouncement> queryFundAnnouncement(Integer innerCode, Integer pageIndex, Integer pageSize);

    /**
     * 获取季度公共
     * 
     * @param announcementID
     * @return
     */
    FundAnnouncement queryFundAnnouncement(Long announcementID);

    /**
     * 获取临时公告
     * 
     * @param id
     * @return
     */
    FundAnnouncement queryFundInterimBulletin(Long id);

}