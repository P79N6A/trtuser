package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

/**
 * @author bin.yu
 * @create 2019-05-06 14:39
 **/
@Data
public class StaffOrgDTO  extends OrgDTO{

    private Long staffOrgId;

    private Long staffId;

    private String isDefault;
}
