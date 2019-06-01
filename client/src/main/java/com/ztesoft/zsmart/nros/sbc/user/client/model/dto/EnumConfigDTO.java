package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 11:08
 */
@Data
public class EnumConfigDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * EnumConfigDO-id
     */
    private Long id;

    /**
     * EnumConfigDO-field_code
     */
    private String fieldCode;

    /**
     * EnumConfigDO-field_name
     */
    private String fieldName;

    /**
     * EnumConfigDO-table_code
     */
    private String tableCode;

    /**
     * EnumConfigDO-table_name
     */
    private String tableName;
}
