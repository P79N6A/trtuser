package com.ztesoft.zsmart.nros.sbc.user.dao.dataobject;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.OrgDO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author bin.yu
 * @create 2019-05-06 13:11
 **/
@Data
 public class StaffOrg extends OrgDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long staffOrgId;

    private Long staffId;

    private String isDefault;


}
