package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.common.EISResult;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param.PosRequireGoodParam;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param.ReturnGoodParam;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.service.InventoryCenterService;

/**
 * @author jiangxiaoxin
 * @description
 * @date 2019/5/6
 */
public class InventoryCenterServiceImpl implements InventoryCenterService {

    /**
     * 门店要货接口
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public EISResult savePosRequireGood(PosRequireGoodParam param) {
        return null;
    }

    /**
     * 门店退货接口
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public EISResult saveReceivingSynchronous(PosRequireGoodParam param) {
        return null;
    }

    /**
     * 门店入库退库确认
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public EISResult savePosReturnGoods(ReturnGoodParam param) {
        return null;
    }
}
