package com.ztesoft.zsmart.nros.sbc.user.client.model.query;

import com.ztesoft.zsmart.nros.common.model.param.PageParam;
import lombok.Data;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-16
 * Time: 15:14
 */
@Data
public class ChannelQuery extends PageParam implements Serializable {

    // 渠道类型
    private String type;

    // 名称
    private String name;

}
