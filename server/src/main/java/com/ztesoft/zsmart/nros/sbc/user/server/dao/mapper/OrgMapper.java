package com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.StaffOrg;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.OrgDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 组织架构mapper
 *
 * @author bin.yu
 * @create 2019-04-22 11:27
 **/
public interface OrgMapper {

    int getMaxOrgId();

    List<OrgDO> selectAllOrgList(@Param("state") String state, @Param("orgType") String orgType,@Param("spId") Long spId);

    List<OrgDO> selectStaffOrgList(@Param("staffId") Long staffId, @Param("parentId") Long parentId,
                                          @Param("areaId") Long areaId, @Param("orgCode") String orgCode, @Param("orgName") String orgName,
                                          @Param("orgType") String orgType, @Param("state") String state, @Param("spId") Long spId);

    List<OrgDO> selectOrgListByIds(@Param("orgIdsList") List<Long> resultList,
                                    @Param("orgType") String orgType, @Param("state") String state, @Param("areaId") Long areaId,
                                    @Param("spId") Long spId);

    List<OrgDO> selectOrgListByParentId(@Param("orgId") Long orgId);

    List<OrgDO> selectStaffDefaultOrg(@Param("staffId") Long staffId);

    List<StaffOrg> selectStaffOrg(@Param("staffId") Long staffId, @Param("orgType") String orgType);




}
