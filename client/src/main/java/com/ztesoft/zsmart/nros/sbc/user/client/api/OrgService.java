package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffOrgDTO;

import java.util.List;

/**
 * 组织架构service
 *
 * @author bin.yu
 * @create 2019-04-22 14:13
 **/
public interface OrgService {

    /**
     * 查询员工的归属组织
     *
     * @param staffId 员工标识
     * @return List<OrgDTO> 组织列表
     */
    List<OrgDTO> queryOwnedOrgListByStaffId(Long staffId);

    /**
     * 查询下级组织列表
     *
     * @param orgId
     * @return List<OrgDto> 组织dto列表
     */
    List<OrgDTO> queryOrgListByParentId(Long orgId);

    OrgDetailDTO findOrgByOrgId(Long orgId);

    void addOrg(OrgDetailDTO orgDetail);

    void modOrg(OrgDetailDTO orgDetail);

    void delOrg(Long orgId);

    List<StaffOrgDTO> selectStaffOrg(Long staffId, String orgType);





}
