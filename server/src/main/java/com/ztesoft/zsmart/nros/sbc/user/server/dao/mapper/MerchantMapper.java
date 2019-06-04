package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.MerchantDO;

/**
 * MerchantDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-24
 */
public interface MerchantMapper {


    /**
     * 根据orgId获取一条数据库记录
     *
     * @param orgId orgId
     * @return com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.MerchantDO
     */
    MerchantDO selectByOrgId(Long orgId);

    int updateByOrgIdSelective(MerchantDO merchantDO);

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(MerchantDO record);


}