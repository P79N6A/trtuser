package com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.ChannelDO;

/**
 * 渠道
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-25
 */
public interface ChannelDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(ChannelDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(ChannelDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id id
     * @return com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.ChannelDO
     */
    ChannelDO selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(ChannelDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(ChannelDO record);
}