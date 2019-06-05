package com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-06 13:11
 **/
@Data
 public class StaffOrg implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private Long staffOrgId;

    private Long staffId;

    private String isDefault;


}
