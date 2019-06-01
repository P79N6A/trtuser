package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author jiangxiaoxin
 * @description
 * @date 2019/5/6
 */
@Data
public class PosRequireGoodParam {
    private String syekco;

    private BigDecimal syedoc;

    private String syedct;

    private String edst;    //业务记录集（固定值）

    private Integer szedln;

    private String eder;    //发送/接收 指示符（固定值）

    private String edsp;    //处理成功（固定值）

    private String tpur;    //业务记录集用途

    private String sfxo;    //订单后缀

    private String mcu;        //经营单位

    private String okco;    //单据公司

    private String oorn;    //原始单据号

    private String octo;    //原始单据类型

    private String rcto;    //相关订单类型

    private String an8;    //地址号

    private String shan;    //发送至地址号

    private Date drqj;    //要求到货日期

    private Date trdj;    //订单日期

    private Date pddj;    //计划提货

    private String vr01;    //POS订单货号

    private String vr02;    //Y（紧急要货）/（调拨与试吃试饮时.【调出、S7】填流水号;【调入、SF】填流水号）

    private String urcd;    //用户编码

    private Date urdt;    //用户日期

    private BigDecimal urat;    //用户金额

    private BigDecimal urab;    //用户号

    private String urrf;    //用户参考

    private String user;    //用户号（POS 固定值）

    private String pid;        //程序号

    private String jobn;    //工作站号

    private Date upmj;    //更新日期

    private String tday;    //具体时间

    private String logisticsNumber; //物流单号

    private String logisticsCompany; //物流名称

    private String consignee; //收货姓名

    private String mobile; //收货联系方式

    private String receiveAddress; //收货地址

    private String sytorg; //业务记录发起人

    private String flag; //标识

    private List<RequireGoodsItem> requireGoodsDTOS;

}
