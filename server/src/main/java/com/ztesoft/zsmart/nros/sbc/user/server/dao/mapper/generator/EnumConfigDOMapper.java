package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.EnumConfigDO;

/**
 * EnumConfigDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-20
 */
public interface EnumConfigDOMapper {
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
    int insert(EnumConfigDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(EnumConfigDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id id
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.EnumConfigDO
     */
    EnumConfigDO selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(EnumConfigDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(EnumConfigDO record);
}