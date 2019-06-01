package com.ztesoft.zsmart.nros.sbc.user.client.model.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-07 16:39
 **/
@Data
public class UserOrgParam implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Long> userIds;

    private List<Long> orgIds;

}
