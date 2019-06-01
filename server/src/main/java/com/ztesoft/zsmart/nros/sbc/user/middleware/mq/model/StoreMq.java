package com.ztesoft.zsmart.nros.sbc.user.middleware.mq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 门店信息推送实体
 *
 * @author bin.yu
 * @create 2019-04-20 10:32
 **/
@Data
public class StoreMq implements Serializable {

    private Long id;
    private String number;
    private String name;

    private String province;
    private Long provinceId;
    private String city;
    private Long cityId;
    private String area;
    private Long areaId;
    //联系linkMan
    private String contact;
    private String mobile;
    private String phone;
    private String zipCode;
    private String longitude;
    private String latitude;
    /**
     * 详细地址
     */
    private String address;
}
