package com.codi.bus.core.sys.dao.impl;

import com.codi.base.dao.BaseDAOImpl;
import com.codi.bus.core.sys.dao.CrawlerKeywordDao;
import com.codi.bus.core.sys.domain.CrawlerKeyword;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/8.
 */

@Repository("crawlerKeywordDao")
public class CrawlerKeywordDaoImpl extends BaseDAOImpl<CrawlerKeyword> implements CrawlerKeywordDao{

    @Override
    public int insert(CrawlerKeyword record) {
        return 0;
    }




    @Override
    public List<CrawlerKeyword> select() {
        List<CrawlerKeyword> keywords = this.findList("selectAllKeywords");

        return keywords;
    }



    @Override
    public int deleteAllKeywords() {
        return this.delete("deleteAllKeywords");
    }

    @Override
    public int insertAllKeywords(List<CrawlerKeyword> keywords) {
        for (CrawlerKeyword keyword : keywords) {
            this.insert(this.generateStatement("insertSelective"), keyword);
        }

        return 0;
    }

}
