package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.SubsidiaryDO;

/**
 * SubsidiaryDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-24
 */
public interface SubsidiaryMapper {

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(SubsidiaryDO record);

    /**
     * 根据orgId获取一条数据库记录
     *
     * @param orgId id
     * @return com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.SubsidiaryDO
     */
    SubsidiaryDO selectByOrgId(Long orgId);

    int updateByOrgIdSelective(SubsidiaryDO subsidiaryDO);

}