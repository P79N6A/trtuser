package com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserOrgPrivDO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author bin.yu
 * @create 2019-05-07 10:27
 **/
@Data
public class UserOrgPriv extends UserOrgPrivDO  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * OrgDO-parent_org_id
     */
    private Long parentOrgId;

    /**
     * OrgDO-org_name
     */
    private String orgName;


}
