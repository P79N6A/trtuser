package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChannelDTO extends OrgDTO implements Serializable {
    /**
     * ChannelDO-id
     */
    private Long id;

    /**
     * ChannelDO-org_id
     */
    private Long orgId;

    /**
     * ChannelDO-number
     */
    private String number;

    /**
     * ChannelDO-name
     */
    private String name;

    /**
     * ChannelDO-type
     */
    private String type;

    /**
     * ChannelDO-plat
     */
    private String plat;

    /**
     * ChannelDO-send_store_id
     */
    private String sendStoreId;

    /**
     * ChannelDO-refund_store_id
     */
    private String refundStoreId;

    /**
     * ChannelDO-link_man
     */
    private String linkMan;

    /**
     * ChannelDO-mobile
     */
    private String mobile;

    /**
     * ChannelDO-merchant_code
     */
    private String merchantCode;

    /**
     * ChannelDO-gmt_create
     */
    private Date gmtCreate;

    /**
     * ChannelDO-gmt_modified
     */
    private Date gmtModified;

    /**
     * ChannelDO-creator
     */
    private String creator;

    /**
     * ChannelDO-modifier
     */
    private String modifier;

    /**
     * 渠道-state
     */
    private String state;

}
