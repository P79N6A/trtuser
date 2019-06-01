package com.ztesoft.zsmart.nros.sbc.nrosuser.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.nrosuser.BaseTest;
import com.ztesoft.zsmart.nros.sbc.user.client.api.ChannelService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.ChannelQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelServiceTest extends BaseTest {

    @Autowired
    private ChannelService channelService;

    @Test
    public void testList(){
        try {
            ChannelQuery channelQuery = new ChannelQuery();
            PageInfo pageResult = channelService.listChannels(channelQuery);
            logger.info("ChannelServiceTest listTest result ->. " + JSONArray.toJSON(pageResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
