package com.ztesoft.zsmart.nros.sbc.user.client.model.dto;

import lombok.Data;

/**
 * 组织架构详情DTO
 *
 * @author bin.yu
 * @create 2019-04-22 15:33
 **/
@Data
public class OrgDetailDTO extends OrgDTO{


    /**
     * 渠道
     */
    private ChannelDTO channelDTO;

    /**
     * 门店
     */
    private StoreDTO storeDTO;
    /**
     * 仓库
     */
    private WarehouseDTO warehouseDTO;

    /**
     * 商家
     */
    private MerchantDTO merchantDTO;

    /**
     * 子公司
     */
    private SubsidiaryDTO subsidiaryDTO;
}
