package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @author jiangxiaoxin
 * @description
 * @date 2019/5/6
 */
@Data
public class ReturnGoodParam {

    private List<ReturnGoodItem> returnGoodsDTOS;

    private Date syaddj;

    private int syan8;

    private String sydcto;

    private int sydoco;

    private String syedct;

    private String syeder;

    private int syedoc;

    private String syedsp;

    private String syedst;

    private String syekco;

    private String syjobn;

    private String sykcoo;

    private String sypid;

    private int syshan;

    private String sysmcu;

    private String sytday;

    private Date syupmj;

    private String syuser;

    private String syvr02;

    private int szedln;

}
