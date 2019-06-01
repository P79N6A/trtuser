package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 仓库DTO
 *
 * @author bin.yu
 * @create 2019-04-18 15:09
 **/
@Data
public class WarehouseDTO implements Serializable {

    /**
     * 同仁堂仓库实体-主键
     */
    private Long id;

    /**
     * 同仁堂仓库实体-bfm_org的主键
     */
    private Long orgId;

    /**
     * 同仁堂仓库实体-仓库名称
     */
    private String name;

    /**
     * 同仁堂仓库实体-仓库编号
     */
    private String number;

    /**
     * 同仁堂仓库实体-详细地址
     */
    private String address;

    /**
     * 同仁堂仓库实体-省名称
     */
    private String province;

    /**
     * 同仁堂仓库实体-市名称
     */
    private String city;

    /**
     * 同仁堂仓库实体-区域名称
     */
    private String area;

    /**
     * 同仁堂仓库实体-联系人姓名
     */
    private String contact;

    /**
     * 同仁堂仓库实体-状态A有效,X无效
     */
    private String state;

    /**
     * 同仁堂仓库实体-是否启用0,启用,1禁用
     */
    private String enable;

    /**
     * 同仁堂仓库实体-分机号
     */
    private String extensionNumber;

    /**
     * 同仁堂仓库实体-联系人手机号
     */
    private String mobile;

    /**
     * 同仁堂仓库实体-对应门店编码
     */
    private Long storeId;

    /**
     * 同仁堂仓库实体-对应门店名称
     */
    private String storeName;

    /**
     * 同仁堂仓库实体-电话
     */
    private String telephone;

    /**
     * 同仁堂仓库实体-仓库类型 1：实体仓 2：门店仓 3：售药机仓
     */
    private String type;

    /**
     * 同仁堂仓库实体-邮编
     */
    private String zipCode;

    /**
     * 同仁堂仓库实体-是否共享：0共享，1不共享
     */
    private String shareFlag;
}
