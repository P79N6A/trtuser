package com.ztesoft.zsmart.nros.sbc.user.server.common.enums;

/**
 * @Description: 系统元数据类型枚举
 * @Author: wangyaoding
 * @CreateDate: 2019-4-17 11:27:51
 */
public enum MetadataTypeEnum {
    CHANGE_TYPE("changeType","变化类型"),
    CHANNEL_PLAT("channelPlat","所属平台"),
    CHANNEL_TYPE("channelType","渠道类型"),
    DELIVERY_TYPE("deliveryType","履约方式"),
    DOCUMENT_TYPE("documentType","单据类型"),
    INVOICE_TYPE("invoiceType","单据类型"),
    INVOICE_TYPES("invoiceTypes","发票类型"),
    ORDER_CLOSE_REASON("orderCloseReason","订单关闭原因"),
    PAYMENT_TYPE("paymentType","支付类型"),
    PAY_TUNNEL_TP("payTunnelTp","支付方式"),
    PLATFORM_CODE("platformCode","订单来源"),
    PRODUCT_TYPE("productType","商品类型"),
    REFUND_STATUS("refundStatus","退单状态"),
    RETURN_STATUS("returnStatus","退货单状态"),
    SALES_ORDER_STATUS("salesOrderStatus","订单状态"),
    SALES_ORDER_TYPE("salesOrderType","订单类型"),
    SELLER_FLAG("sellerFlag","卖家备注旗帜"),
    STATUS("status","处理状态"),
    STOCK_UNITES("stockUnites","库存单位"),
    WAREHOUSE_TYPE("warehouseType","仓库类型");

    private String code;
    private String name;


    MetadataTypeEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        for (MetadataTypeEnum c : MetadataTypeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
