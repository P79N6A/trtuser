package com.ztesoft.zsmart.nros.sbc.user.client.model.query;

import com.ztesoft.zsmart.nros.common.model.param.PageParam;
import lombok.Data;

import java.io.Serializable;

/**
 * 仓库query
 *
 * @author bin.yu
 * @create 2019-04-18 15:03
 **/
@Data
public class WarehouseQuery extends PageParam implements Serializable {


    /**
     * 仓库类型
     */
    private String type;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库编号
     */
    private String number;

    /**
     *  数据状态
     */
    private String state;

}
