package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.client.api.ChannelService;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.ChannelDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.ChannelDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.ChannelDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.ChannelDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.ChannelQuery;
import jodd.bean.BeanCopy;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-16
 * Time: 15:23
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelDOMapper channelDOMapper;

    @Autowired
    private ChannelDomain channelDomain;

    @Override
    public PageInfo listChannels(ChannelQuery channelQuery) {
        Page page = PageHelper.startPage(channelQuery.getPageIndex(), channelQuery.getPageSize());
        List<ChannelDO> channelDOList = channelDomain.queryChannelList(channelQuery);
        List<ChannelDTO> channelDTOS = do2DTO(channelDOList);
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(channelDTOS);
        return pageInfo;
    }

    @Override
    public List<ChannelDTO> listChannelsByParams(ChannelQuery channelQuery) {
        List<ChannelDO> channelDOList = channelDomain.queryChannelList(channelQuery);
        List<ChannelDTO> channelDTOS = do2DTO(channelDOList);
        return channelDTOS;
    }

    @Override
    public ChannelDTO findChannelById(Long channelId) {
        ChannelDO channelDO= channelDOMapper.selectByPrimaryKey(channelId);
        ChannelDTO channelDTO = ConvertUtil.beanCopy(channelDO, ChannelDTO.class);
        return channelDTO;
    }

    @Override
    public ChannelDTO findChannelByOrgId(Long orgId) {
        ChannelDO channelDO= channelDomain.selectChannelByOrgId(orgId);
        ChannelDTO channelDTO = ConvertUtil.beanCopy(channelDO, ChannelDTO.class);
        return channelDTO;
    }

    private List<ChannelDTO> do2DTO(List<ChannelDO> channelDOList) {
        if (CollectionUtils.isEmpty(channelDOList)) {
            return null;
        }
        List<ChannelDTO> result = new ArrayList<>();

        for (ChannelDO channelDO : channelDOList) {
            ChannelDTO channelDTO = new ChannelDTO();
            BeanCopy.beans(channelDO, channelDTO).copy();
            result.add(channelDTO);

        }

        return result;
    }
}
