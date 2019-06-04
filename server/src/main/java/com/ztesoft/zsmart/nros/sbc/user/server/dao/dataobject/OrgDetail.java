package com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject;

import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.ChannelDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.MerchantDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.OrgDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StoreDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.SubsidiaryDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.WarehouseDO;
import lombok.Data;

import java.io.Serializable;

/**
 * 机构详情
 *
 * @author bin.yu
 * @create 2019-04-22 16:06
 **/
@Data
public class OrgDetail extends OrgDO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 渠道
     */
    private ChannelDO channelDO;

    /**
     * 门店
     */
    private StoreDO storeDO;
    /**
     * 仓库
     */
    private WarehouseDO warehouseDO;

    /**
     * 商家
     */
    private MerchantDO merchantDO;

    /**
     * 子公司
     */
    private SubsidiaryDO subsidiaryDO;
}
