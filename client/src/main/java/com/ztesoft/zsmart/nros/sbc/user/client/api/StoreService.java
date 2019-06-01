package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StoreDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StoreQuery;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 19:52
 */
public interface StoreService {

    PageInfo listStoreByParams(StoreQuery storeQuery);

    void pushStoreMqServer(Long id);

    StoreDTO queryStoreDetailByParams(Long id);
}
