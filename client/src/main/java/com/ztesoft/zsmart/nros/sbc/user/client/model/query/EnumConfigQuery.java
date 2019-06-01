package com.ztesoft.zsmart.nros.sbc.user.client.model.query;

import com.ztesoft.zsmart.nros.common.model.param.PageParam;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 11:09
 */
@Data
public class EnumConfigQuery extends PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 类型code
    private String tableCode;

    // 类型名称
    private String tableName;

}
