package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.ChannelDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.ChannelQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 渠道服务接口
 * User: yaodingw
 * Date: 2019-04-16
 * Time: 13:13
 */
public interface ChannelService {

    PageInfo listChannels(ChannelQuery channelQuery);

    List<ChannelDTO> listChannelsByParams(ChannelQuery channelQuery);

    ChannelDTO findChannelById(Long channelId);

    ChannelDTO findChannelByOrgId(Long orgId);
}
