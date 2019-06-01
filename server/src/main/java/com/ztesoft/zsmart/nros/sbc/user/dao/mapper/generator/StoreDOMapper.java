package com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StoreDO;

/**
 * 门店详情信息表
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-20
 */
public interface StoreDOMapper {
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
    int insert(StoreDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(StoreDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id id
     * @return com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StoreDO
     */
    StoreDO selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(StoreDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(StoreDO record);
}