package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.MerchantDO;

/**
 * MerchantDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-25
 */
public interface MerchantDOMapper {
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
    int insert(MerchantDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(MerchantDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id id
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.MerchantDO
     */
    MerchantDO selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(MerchantDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(MerchantDO record);
}