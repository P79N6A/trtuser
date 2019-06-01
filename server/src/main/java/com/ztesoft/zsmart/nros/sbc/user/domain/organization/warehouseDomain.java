package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.WarehouseMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.WarehouseDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.WarehouseDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.WarehouseDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.WarehouseQuery;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仓库domain
 *
 * @author bin.yu
 * @create 2019-04-18 15:01
 **/
@Repository("C")
public class warehouseDomain extends AbstractOrgDomain<OrgDetailDTO> {


    @Autowired
    private WarehouseDOMapper warehouseDOMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public void addOrg(OrgDetailDTO org) {
        WarehouseDO warehouseDO=detailDTO2DetailDO(org.getWarehouseDTO());
        warehouseDO.setOrgId(org.getOrgId());
        warehouseDO.setName(org.getOrgName());
        warehouseMapper.insert(warehouseDO);

    }

    @Override
    public void updateOrg(OrgDetailDTO org) {
        WarehouseDO warehouseDO=detailDTO2DetailDO(org.getWarehouseDTO());
        warehouseDO.setName(org.getOrgName());
        warehouseMapper.updateByOrgIdSelective(warehouseDO);
    }

    @Override
    public void deleted(Long orgId) {
        WarehouseDO warehouseDO = new WarehouseDO();
        warehouseDO.setState(DataStateEnum.X.getCode());
        warehouseDO.setOrgId(orgId);
        warehouseMapper.updateByOrgIdSelective(warehouseDO);
    }

    @Override
    public OrgDetail findByOrgId(Long orgId) {
        OrgDetail orgDetail = new OrgDetail();
        WarehouseDO warehouseDO = warehouseMapper.selectByOrgId(orgId);
        orgDetail.setWarehouseDO(warehouseDO);
        return orgDetail;
    }

    public List<WarehouseDO> queryChannelList(WarehouseQuery warehouseQuery) {
        WarehouseDO warehouseDO = query2WarehouseDO(warehouseQuery);
        return warehouseMapper.selectWarehouseList(warehouseDO);
    }

    public List<WarehouseDO> pageWarehousesNotInOrgIds(WarehouseQuery warehouseQuery,List<Long> orgIds) {
        WarehouseDO warehouseDO = query2WarehouseDO(warehouseQuery);
        return warehouseMapper.pageWarehousesNotInOrgIds(warehouseDO,orgIds);
    }

    public WarehouseDO selectByPrimaryKey(Long id) {
        return warehouseDOMapper.selectByPrimaryKey(id);
    }

    private WarehouseDO query2WarehouseDO(WarehouseQuery warehouseQuery) {
        WarehouseDO warehouseDO = new WarehouseDO();
        //如果query的state值是空的,表示查有效的
        if(warehouseQuery == null ){
            warehouseQuery.setState(DataStateEnum.A.getCode());
        } else  {
            warehouseQuery.setState(DataStateEnum.getDataState(warehouseQuery.getState()));
        }
        BeanCopy.beans(warehouseQuery, warehouseDO).copy();
        return warehouseDO;
    }

    private WarehouseDO detailDTO2DetailDO(WarehouseDTO warehouseDTO) {
        return ConvertUtil.beanCopy(warehouseDTO, WarehouseDO.class);
    }



}
