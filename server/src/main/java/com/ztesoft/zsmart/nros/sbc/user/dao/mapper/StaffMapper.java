package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StaffDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * StaffDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-23
 */
public interface StaffMapper {
    List<StaffDO> selectStaffList(@Param("staffDetail")StaffDetail staffDetail);

    List<StaffDetail> selectStaffDetailList(@Param("staffDO") StaffDO staffDO);

    StaffDetail selectStaffDetail(@Param("id") Long id);
}