package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.ChannelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelMapper {

    List<ChannelDO> selectChannelList(@Param("channelDO")ChannelDO channelDO);

    ChannelDO selectByOrgId(Long orgId);

    int insert(ChannelDO record);


    /**
     * 根据orgId来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByOrgIdSelective(ChannelDO record);
}
