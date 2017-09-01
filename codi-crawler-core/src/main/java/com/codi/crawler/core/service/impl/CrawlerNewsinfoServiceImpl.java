package com.codi.crawler.core.service.impl;

import com.codi.bus.core.resultModel.BaseResult;
import com.codi.crawler.core.dao.CrawlerKeywordDao;
import com.codi.crawler.core.dao.CrawlerNewsinfoDao;
import com.codi.crawler.core.dao.CrawlerWebsiteDao;
import com.codi.crawler.core.domain.CrawlerKeyword;
import com.codi.crawler.core.domain.CrawlerNewsinfo;
import com.codi.crawler.core.domain.CrawlerWebsite;
import com.codi.crawler.core.service.CrawlerNewsinfoService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangzhenhao on 2017/5/15.
 */
@Service("crawlerNewsinfoService")
public class CrawlerNewsinfoServiceImpl implements CrawlerNewsinfoService{
    @Autowired
    private CrawlerNewsinfoDao newsinfoDao;

    @Autowired
    private CrawlerWebsiteDao websiteDao;

    @Autowired
    private CrawlerKeywordDao keywordDao;

    private List<CrawlerKeyword> keywords = null;

    @Override
    public int addNewsinfo(CrawlerNewsinfo newsinfo) {
        return newsinfoDao.insertSelective(newsinfo);
    }


    public BaseResult storeNewsinfos() {
        newsinfoDao.deleteCurrentDayCrawlerData();

        keywords = keywordDao.selectAll();

        List<CrawlerWebsite> websites = websiteDao.selectAll();

        if (websites == null) {
            return null;
        }

        for (CrawlerWebsite website : websites) {
            List<CrawlerNewsinfo> newsinfos = getCrawlerNewsinfosByEachWebsite(website);

            for (CrawlerNewsinfo newsinfo : newsinfos) {
                newsinfoDao.insertSelective(newsinfo);
            }
        }

        return new BaseResult();
    }



    private List<CrawlerNewsinfo> getCrawlerNewsinfosByEachWebsite(CrawlerWebsite website) {
        List<CrawlerNewsinfo> newsinfos = new ArrayList<>();

        try {
            String websiteName = website.getName();


            Document doc = Jsoup.connect(website.getLink()).get();
            Elements div = doc.select(website.getSelectorFatherNode());
            List<String> datesList = new ArrayList<>();

            for (Element element : div) {
                Elements dates = element.select(website.getSelectorDate());
                Elements links = element.select(website.getSelectorLink());

                for (Element date : dates) {
                    datesList.add(date.html());
                }

                int current = 0;

                for (Element link : links) {
                    Document document = Jsoup.connect(link.attr("href")).get();
                    String matchDegree = calcuMatchDegree(document.toString());

                    if (matchDegree == null) {
                        current++;

                        continue;
                    }

                    CrawlerNewsinfo newsinfo = new CrawlerNewsinfo();
                    newsinfo.setSource(websiteName);
                    newsinfo.setTitle(link.text());
                    newsinfo.setLink(link.attr("href"));
                    newsinfo.setReleaseDate(datesList.get(current));
                    current++;
                    newsinfo.setCrawlerDate(new Date());
                    newsinfo.setMainContent(document.toString());
                    newsinfo.setMatchDegree(matchDegree);
                    newsinfos.add(newsinfo);
                }
            }
        } catch (Exception exception) {

        }

        return newsinfos;
    }

    private String calcuMatchDegree(String content) {
        int keywordsMatch = 0;
        int totalMatch = 0;

        for (CrawlerKeyword keyword : keywords) {
            if (content.contains(keyword.getKeyword())) {
                keywordsMatch++;

                totalMatch += count(content, keyword.getKeyword());
            }
        }

        if (keywordsMatch == 0) {
            return null;
        } else {
            return keywordsMatch + "个 " + totalMatch + "次";
        }
    }

    private int count(String text,String sub){
        int count =0, start =0;
        while((start=text.indexOf(sub,start))>=0){
            start += sub.length();
            count ++;
        }
        return count;
    }

    @Override
    public void deleteCurrentDayCrawlerData() {
        newsinfoDao.deleteCurrentDayCrawlerData();
    }

    public static void main(String[] args) throws Exception{

        /**
         * 和讯基金
         */
//        Document doc = Jsoup.connect("http://funds.hexun.com/hotnews").get();
//        Elements div = doc.select("div.temp01");
//
//        for (Element element : div) {
//            Elements spans = element.select("span");
//            Elements links = element.select("a");
//
//            for (Element span : spans) {
//                System.out.println(span.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         * 全景网
         */
//        Document doc = Jsoup.connect("http://www.p5w.net/fund/yw").get();
//        Elements div = doc.select("div.manlist3");
//
//        for (Element element : div) {
//            Elements dates = element.select("div.setinfo3");
//            Elements links = element.select("a");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         *凤凰网
         */
//        Document doc = Jsoup.connect("http://finance.ifeng.com/fund/jjdt/").get();
//        Elements div = doc.select("div.list03");
//
//        for (Element element : div) {
//            Elements dates = element.select("span.time01");
//            Elements links = element.select("a[target]");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         * 好买基金
         */
//        Document doc = Jsoup.connect("https://www.howbuy.com/news/c/2/203.htm").get();
//        Elements div = doc.select("div.newsList");
//
//        for (Element element : div) {
//            Elements dates = element.select("td[align=center]");
//            Elements links = element.select("a[target]");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         * 天天基金
         */
//        Document doc = Jsoup.connect("http://roll.eastmoney.com/fund.html").get();
//        Elements div = doc.select("div#artList");
//
//
//        for (Element element : div) {
//            Elements dates = element.select("span");
//            Elements links = element.select("a[target=_blank]");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         * 新浪财经
         */
//        Document doc = Jsoup.connect("http://roll.finance.sina.com.cn/finance/jj4/index_1.shtml").get();
//        Elements div = doc.select("ul.list_009");
//
//
//        for (Element element : div) {
//            Elements dates = element.select("span");
//            Elements links = element.select("a[target=_blank]");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }

        /**
         *腾讯基金
         */
//        Document doc = Jsoup.connect("http://finance.qq.com/l/fund/jjyw/index.htm").get();
//        Elements div = doc.select("div.newslist");
//
//        for (Element element : div) {
//            Elements dates = element.select("span.pub_time");
//            Elements links = element.select("a[target=_blank]");
//
//            for (Element date : dates) {
//                System.out.println(date.html());
//            }
//
//            for (Element link : links) {
//                System.out.println(link.attr("href"));
//                System.out.println(link.text());
//            }
//        }
    }
}
