package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StoreDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店详情信息表
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-17
 */
public interface StoreMapper {

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(StoreDO record);


    List<StoreDO> selectStoreList(@Param("storeDO")StoreDO storeDO);

    StoreDO selectByOrgId(@Param("orgId") Long orgId);

    int updateByOrgIdSelective(StoreDO storeDO);
}