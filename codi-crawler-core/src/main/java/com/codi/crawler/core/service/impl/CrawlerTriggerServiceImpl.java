package com.codi.crawler.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codi.crawler.core.service.CrawlerNewsinfoService;
import com.codi.crawler.core.service.CrawlerSubService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;

/**
 * Created by wangzhenhao on 2017/5/15.
 */
public class CrawlerTriggerServiceImpl implements CrawlerSubService{


    @Autowired
    private ChannelTopic channelTopic;

    @Autowired
    private CrawlerNewsinfoService newsinfoService;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        Object o = JSONObject.parse(message.getBody());

        if ("trigger_now".equals(o.toString())) {
            newsinfoService.storeNewsinfos();
        }

    }
}
