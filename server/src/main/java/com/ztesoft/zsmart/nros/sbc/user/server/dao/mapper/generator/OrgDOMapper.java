package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.OrgDO;

/**
 * OrgDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-22
 */
public interface OrgDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param orgId orgId
     * @return int
     */
    int deleteByPrimaryKey(Long orgId);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(OrgDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(OrgDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param orgId orgId
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.OrgDO
     */
    OrgDO selectByPrimaryKey(Long orgId);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(OrgDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(OrgDO record);
}