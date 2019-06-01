package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 组织机构DTO
 *
 * @author bin.yu
 * @create 2019-04-22 11:13
 **/
@Data
public class OrgDTO implements Serializable {

    /**
     * BfmOrgDO-org_id
     */
    private Long orgId;

    /**
     * BfmOrgDO-parent_org_id
     */
    private Long parentOrgId;

    /**
     * BfmOrgDO-org_name
     */
    private String orgName;

    /**
     * BfmOrgDO-org_type
     */
    private String orgType;

    /**
     * BfmOrgDO-area_id
     */
    private Integer areaId;

    /**
     * BfmOrgDO-state
     */
    private String state;

    /**
     * BfmOrgDO-state_date
     */
    private Date stateDate;

    /**
     * BfmOrgDO-org_code
     */
    private String orgCode;


    private List<Long> children =new ArrayList<>();

}
