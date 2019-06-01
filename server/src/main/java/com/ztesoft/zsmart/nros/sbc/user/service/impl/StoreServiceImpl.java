package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.StoreDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StoreDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.StoreDomain;
import com.ztesoft.zsmart.nros.sbc.user.middleware.mq.model.StoreMq;
import com.ztesoft.zsmart.nros.sbc.user.middleware.mq.producer.StoreProducer;
import com.ztesoft.zsmart.nros.sbc.user.client.api.StoreService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StoreDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StoreQuery;
import jodd.bean.BeanCopy;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 20:06
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDomain storeDomain;

    @Autowired
    private StoreDOMapper storeDOMapper;

    @Autowired
    private StoreProducer storeProducer;

    @Override
    public PageInfo listStoreByParams(StoreQuery storeQuery) {
        Page page = PageHelper.startPage(storeQuery.getPageIndex(), storeQuery.getPageSize());
        List<StoreDO> storeDOS = storeDomain.queryChannelList(storeQuery);
        List<StoreDTO> storeDTOS = do2DTO(storeDOS);
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(storeDTOS);
        return pageInfo;
    }


    @Override
    public StoreDTO queryStoreDetailByParams(Long id) {
        StoreDO storeDO = storeDOMapper.selectByPrimaryKey(id);
        if(storeDO == null){
            return null;
        }
        StoreDTO storeDTO =ConvertUtil.beanCopy(storeDO, StoreDTO.class);
        return storeDTO;
    }

    @Override
    public void pushStoreMqServer(Long id) {
        StoreDO storeDO = storeDomain.findById(id);
        if (storeDO != null) {
            StoreMq storeMq = new StoreMq();
            BeanCopy.beans(storeDO, storeMq).copy();
            storeMq.setContact(storeDO.getLinkMan());
            storeProducer.sendMsg(storeMq);
        }
    }

    private List<StoreDTO> do2DTO(List<StoreDO> storeDOList) {
        if (CollectionUtils.isEmpty(storeDOList)) {
            return null;
        }
        List<StoreDTO> result = new ArrayList<>();

        for (StoreDO storeDO : storeDOList) {
            StoreDTO storeDTO = new StoreDTO();
            BeanCopy.beans(storeDO, storeDTO).copy();
            result.add(storeDTO);
        }

        return result;
    }
}
