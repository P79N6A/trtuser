package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.annotation.DatapriveAop;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.StoreMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.StoreDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StoreDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StoreDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StoreQuery;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-18
 * Time: 14:26
 */
@Repository("B")
public class StoreDomain extends AbstractOrgDomain<OrgDetailDTO> {


    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreDOMapper storeDOMapper;

    @DatapriveAop
    public List<StoreDO> queryChannelList(StoreQuery storeQuery) {
        StoreDO storeDO = query2StoreDO(storeQuery);
        return storeMapper.selectStoreList(storeDO);
    }

    @Override
    public void addOrg(OrgDetailDTO org) {
        StoreDO storeDO=detailDTO2DetailDO(org.getStoreDTO());
        storeDO.setOrgId(org.getOrgId());
        storeDO.setName(org.getOrgName());
        storeMapper.insert(storeDO);
    }

    @Override
    public void updateOrg(OrgDetailDTO org) {
        StoreDO storeDO=detailDTO2DetailDO(org.getStoreDTO());
        storeDO.setName(org.getOrgName());
        storeMapper.updateByOrgIdSelective(storeDO);
    }

    @Override
    public void deleted(Long orgId) {
        StoreDO storeDO = new StoreDO();
        storeDO.setOrgId(orgId);
        storeDO.setState(DataStateEnum.X.getCode());
        storeMapper.updateByOrgIdSelective(storeDO);
    }

    @Override
    public OrgDetail findByOrgId(Long orgId) {
        OrgDetail orgDetail = new OrgDetail();
        StoreDO storeDO = storeMapper.selectByOrgId(orgId);
        orgDetail.setStoreDO(storeDO);
        return orgDetail;
    }

    public StoreDO findById(Long id) {
        return storeDOMapper.selectByPrimaryKey(id);
    }



    private StoreDO query2StoreDO(StoreQuery storeQuery) {
        StoreDO storeDO= new StoreDO();
        //如果query的state值是空的,表示查有效的
        if(storeQuery == null ){
            storeQuery.setState(DataStateEnum.A.getCode());
        } else  {
            storeQuery.setState(DataStateEnum.getDataState(storeQuery.getState()));
        }
        BeanCopy.beans(storeQuery, storeDO).copy();
        return storeDO;
    }

    private StoreDO detailDTO2DetailDO(StoreDTO storeDTO) {
        return ConvertUtil.beanCopy(storeDTO, StoreDO.class);
    }

}
