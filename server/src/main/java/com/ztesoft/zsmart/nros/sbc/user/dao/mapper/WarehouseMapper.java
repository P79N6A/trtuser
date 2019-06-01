package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.WarehouseDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bin.yu
 * @create 2019-04-18 14:46
 **/
public interface WarehouseMapper {

    /**
     * 插入数据库记录
     *
     * @param record record
     * @return int
     */
    int insert(WarehouseDO record);

    List<WarehouseDO> selectWarehouseList(@Param("warehouseDO") WarehouseDO warehouseDO);

    List<WarehouseDO> pageWarehousesNotInOrgIds(@Param("warehouseDO") WarehouseDO warehouseDO,@Param("orgIds") List<Long> orgIds);

    WarehouseDO selectByOrgId(@Param("orgId") Long orgId);

    int updateByOrgIdSelective(WarehouseDO warehouseDO);

}
