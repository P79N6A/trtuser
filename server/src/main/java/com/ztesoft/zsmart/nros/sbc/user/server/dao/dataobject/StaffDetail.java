package com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-23
 * Time: 18:25
 */
@Data
public class StaffDetail extends StaffDO {

    //机构名称
    private String orgName;

    //机构主键
    private Long orgId;

    //职位名称
    private String jobName;

    //职位主键
    private Long jobId;

    //所属的组织机构列表
    private List<Long> orgIds;
}
