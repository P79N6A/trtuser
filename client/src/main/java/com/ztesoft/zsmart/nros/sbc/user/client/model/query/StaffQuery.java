package com.ztesoft.zsmart.nros.sbc.user.client.model.query;

import com.ztesoft.zsmart.nros.common.model.param.PageParam;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-23
 * Time: 16:06
 */
@Data
public class StaffQuery extends PageParam implements Serializable {

    //员工姓名
    private String staffName;

    //员工电话
    private String phone;

    //数据状态(不传默认是A)
    private String state;

    //员工邮箱
    private String email;

    //员工所属机构
    private List<Long> orgIds;

}
