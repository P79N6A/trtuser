package com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.model;

import com.ztesoft.zsmart.nros.common.model.BaseModel;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-06-03
 * Time: 14:50
 */
@Data
public class AuthorizationBO extends BaseModel {
    /**
     * UserOrgPrivDO-用户主键
     */
    private Long userId;

    /**
     * UserOrgPrivDO-机构主键
     */
    private Long orgId;

}
