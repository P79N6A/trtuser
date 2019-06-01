package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author jiangxiaoxin
 * @description
 * @date 2019/5/6
 */
@Data
public class RequireGoodsItem {
    private String edst;    //业务记录集（固定值）

    private String eder;    //发送/接收 指示符（固定值）

    private String edsp;    //处理成功（固定值）

    //订单类型（固定值， S7: 特殊退货
    private String dcto;

    //项目编码
    private String litm;

    //行类型（退货：C  要货：S）
    private String lnty;

    //行号
    private Integer lnid;

    //计量单位
    private String uom;

    //订购数量
    private BigDecimal uorg;

    private BigDecimal uprc;    //单价

    private BigDecimal aexp;    //总价

    private BigDecimal urat; //销售金额（用户金额）

    private BigDecimal urrf; //销售单价

    private String sfxo;    //订单后缀

    private String mcu;        //经营单位

    private String okco;    //单据公司

    private String oorn;    //原始单据号

    private String octo;    //原始单据类型

    private String rcto;    //相关订单类型

    private BigDecimal ogno;    //原始行号

    private String an8;    //地址号

    private String shan;    //发送至地址号

    private Date drqj;    //要求到货日期

    private Date trdj;    //订单日期

    private Date pddj;    //计划提货

    private String vr01;    //POS订单货号

    private String vr02;    //Y（紧急要货）/（调拨与试吃试饮时.【调出、S7】填流水号;【调入、SF】填流水号）

    private String user;    //用户号（POS 固定值）

    private String pid;        //程序号

    private String jobn;    //工作站号

    private Date upmj;    //更新日期

    private String tday;    //具体时间

    private String flag; //处理标识
}
