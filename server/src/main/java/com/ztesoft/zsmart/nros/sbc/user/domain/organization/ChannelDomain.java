package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.annotation.DatapriveAop;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.ChannelMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.ChannelDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.ChannelDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.ChannelQuery;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-16
 * Time: 15:23
 */
// A 表示组织机构类型是渠道
@Component("A")
public class ChannelDomain extends AbstractOrgDomain<OrgDetailDTO> {


    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public void addOrg(OrgDetailDTO org) {
        ChannelDO channelDO=detailDTO2DetailDO(org.getChannelDTO());
        channelDO.setOrgId(org.getOrgId());
        channelDO.setName(org.getOrgName());
        channelMapper.insert(channelDO);
    }

    @Override
    public void updateOrg(OrgDetailDTO org) {
        ChannelDO channelDO=detailDTO2DetailDO(org.getChannelDTO());
        channelDO.setName(org.getOrgName());
        channelMapper.updateByOrgIdSelective(channelDO);
    }

    @Override
    public void deleted(Long orgId) {
        ChannelDO channelDO = new ChannelDO();
        channelDO.setOrgId(orgId);
        channelDO.setState(DataStateEnum.X.getCode());
        channelMapper.updateByOrgIdSelective(channelDO);
    }

    @Override
    public OrgDetail findByOrgId(Long orgId) {
        OrgDetail orgDetail = new OrgDetail();
        ChannelDO channelDO = channelMapper.selectByOrgId(orgId);
        orgDetail.setChannelDO(channelDO);
        return orgDetail;
    }



    @DatapriveAop
    public List<ChannelDO> queryChannelList(ChannelQuery channelQuery) {
        ChannelDO channelDO = query2ChannelDO(channelQuery);
        return channelMapper.selectChannelList(channelDO);
    }

    public ChannelDO selectChannelByOrgId(Long orgId){
        return channelMapper.selectByOrgId(orgId);
    }



    private ChannelDO query2ChannelDO(ChannelQuery channelQuery) {
        ChannelDO channelDO = new ChannelDO();
        BeanCopy.beans(channelQuery, channelDO).copy();
        return channelDO;
    }

    private ChannelDO detailDTO2DetailDO(ChannelDTO channelDTO) {
        return ConvertUtil.beanCopy(channelDTO, ChannelDO.class);
    }


}
