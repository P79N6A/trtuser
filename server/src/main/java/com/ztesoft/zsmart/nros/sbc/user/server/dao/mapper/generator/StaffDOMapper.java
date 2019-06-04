package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO;

/**
 * StaffDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-23
 */
public interface StaffDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param staffId staffId
     * @return int
     */
    int deleteByPrimaryKey(Long staffId);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(StaffDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(StaffDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param staffId staffId
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO
     */
    StaffDO selectByPrimaryKey(Long staffId);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(StaffDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(StaffDO record);
}