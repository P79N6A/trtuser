package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.WarehouseDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.WarehouseQuery;

import java.util.List;

/**
 * 仓库service
 *
 * @author bin.yu
 * @create 2019-04-18 15:18
 **/
public interface WarehouseService {


    PageInfo pageWarehouses(WarehouseQuery warehouseQuery);

    List<WarehouseDTO> listWarehousesByParams(WarehouseQuery warehouseQuery);

    WarehouseDTO selectByPrimaryKey(Long id);
}
