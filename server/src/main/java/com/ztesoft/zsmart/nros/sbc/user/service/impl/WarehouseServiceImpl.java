package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.WarehouseDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.warehouseDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.api.WarehouseService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.WarehouseDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.WarehouseQuery;
import jodd.bean.BeanCopy;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bin.yu
 * @create 2019-04-18 15:22
 **/
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private warehouseDomain warehouseDomain;

    @Override
    public PageInfo pageWarehouses(WarehouseQuery warehouseQuery) {
        Page page = PageHelper.startPage(warehouseQuery.getPageIndex(), warehouseQuery.getPageSize());
        List<WarehouseDO> warehouseDOS = warehouseDomain.queryChannelList(warehouseQuery);
        List<WarehouseDTO> warehouseDTOS = do2DTO(warehouseDOS);
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(warehouseDTOS);
        return pageInfo;
    }

    @Override
    public List<WarehouseDTO> listWarehousesByParams(WarehouseQuery warehouseQuery) {
        List<WarehouseDO> warehouseDOS = warehouseDomain.queryChannelList(warehouseQuery);
        List<WarehouseDTO> warehouseDTOS = do2DTO(warehouseDOS);
        return warehouseDTOS;
    }


    @Override
    public WarehouseDTO selectByPrimaryKey(Long id) {
        WarehouseDO warehouseDO = warehouseDomain.selectByPrimaryKey(id);
        return ConvertUtil.beanCopy(warehouseDO, WarehouseDTO.class);
    }

    private List<WarehouseDTO> do2DTO(List<WarehouseDO> warehouseDOList) {
        if (CollectionUtils.isEmpty(warehouseDOList)) {
            return null;
        }
        List<WarehouseDTO> result=new ArrayList<>();

        for (WarehouseDO warehouseDO : warehouseDOList) {
            WarehouseDTO warehouseDTO = new WarehouseDTO();
            BeanCopy.beans(warehouseDO,warehouseDTO).copy();
            result.add(warehouseDTO);
        }
        return result;
    }
}
