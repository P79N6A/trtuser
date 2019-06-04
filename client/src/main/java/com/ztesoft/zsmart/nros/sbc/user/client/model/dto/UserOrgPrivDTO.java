package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bin.yu
 * @create 2019-05-07 13:59
 **/
@Data
public class UserOrgPrivDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UserOrgPrivDO-id
     */
    private Long id;

    /**
     * UserOrgPrivDO-user_id
     */
    private Long userId;

    /**
     * UserOrgPrivDO-org_id
     */
    private Long orgId;

    /**
     * UserOrgPrivDO-gmt_create
     */
    private Date gmtCreate;

    /**
     * UserOrgPrivDO-creator
     */
    private JSONObject creator;

    /**
     * OrgDO-parent_org_id
     */
    private Long parentOrgId;

    /**
     * OrgDO-org_name
     */
    private String orgName;

}
