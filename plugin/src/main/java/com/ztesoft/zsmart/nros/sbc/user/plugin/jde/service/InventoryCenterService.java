package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.service;

import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.common.EISResult;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param.PosRequireGoodParam;
import com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.param.ReturnGoodParam;

/**
 * @author yangchao
 * @create 2019/5/6 15:37
 */
public interface InventoryCenterService {

    /**
     * 门店要货接口
     * @return
     */
    EISResult savePosRequireGood(PosRequireGoodParam param);

    /**
     * @return
     */
    EISResult saveReceivingSynchronous(PosRequireGoodParam param);

    /**
     * 门店入库退库确认
     * @return
     */
    EISResult savePosReturnGoods(ReturnGoodParam param);

}
