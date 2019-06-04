package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserDO;

/**
 * T_BFM_USER_ID_SEQ
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-23
 */
public interface UserDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param userId userId
     * @return int
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(UserDO record);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insertSelective(UserDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param userId userId
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.model.generator.userDo
     */
    UserDO selectByPrimaryKey(Long userId);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(UserDO record);
}